'use strict';

// 방에 들어가 채널이 준비가 됨
var isChannelReady = false;
// 내가 방에 첫 입장한 클라이언트라면 true
var isInitiator = false;

var isStarted = false;
var localStream;
var pc;
var remoteStream;
var turnReady;

// iceServers
var pcConfig = {
    'iceServers': [{
        'urls': 'stun:stun.l.google.com:19302'
    }]
};

// Set up audio and video regardless of what devices are present.
var sdpConstraints = {
    offerToReceiveAudio: true,
    offerToReceiveVideo: false
};

/////////////////////////////////////////////

// 방 번호 설정
var room = 'foo';

var socket = io("http://localhost:8000");

// 방 번호가 있다면 (create or join, room) emit
if (room !== '') {
    socket.emit('create or join', room);
    console.log('Attempted to create or  join room', room);
}

// created -> isInitiator를 true로
socket.on('created', function (room) {
    console.log('Created room ' + room);
    isInitiator = true;
});

// full -> log
socket.on('full', function (room) {
    console.log('Room ' + room + ' is full');
});

// join -> isChannelReady를 true 
// 내가 들어가있던 방에 누군가 들어옴
socket.on('join', function (room) {
    console.log('Another peer made a request to join room ' + room);
    console.log('This peer is the initiator of room ' + room + '!');
    isChannelReady = true;
});

// joined -> 이미 방에 1명이 들어가있었음
socket.on('joined', function (room) {
    console.log('joined: ' + room);
    isChannelReady = true;
});

// log -> 들어온 array를 log
socket.on('log', function (array) {
    console.log.apply(console, array);
});

////////////////////////////////////////////////

function sendMessage(message) {
    console.log('Client sending message: ', message);
    socket.emit('message', message);
}

// This client receives a message
socket.on('message', function (message) {
    console.log('Client received message:', message);
    if (message === 'got user media') {
        maybeStart();
    } else if (message.type === 'offer') {
        if (!isInitiator && !isStarted) {
            maybeStart();
        }
        pc.setRemoteDescription(new RTCSessionDescription(message));
        doAnswer();
    } else if (message.type === 'answer' && isStarted) {
        pc.setRemoteDescription(new RTCSessionDescription(message));
    } else if (message.type === 'candidate' && isStarted) {
        var candidate = new RTCIceCandidate({
            sdpMLineIndex: message.label,
            candidate: message.candidate
        });
        pc.addIceCandidate(candidate);
    } else if (message === 'bye' && isStarted) {
        handleRemoteHangup();
    }
});

////////////////////////////////////////////////////

var localAudio = document.querySelector('#localAudio');
var remoteAudio = document.querySelector('#remoteAudio');

navigator.getUserMedia = (navigator.getUserMedia ||
    navigator.webkitGetUserMedia ||
    navigator.mozGetUserMedia ||
    navigator.msGetUserMedia);

navigator.mediaDevices.getUserMedia({
    audio: true,
    video: false
})
    .then(gotStream)
    .catch(function (e) {
        alert('getUserMedia() error: ' + e.name);
    });


function gotStream(stream) {
    console.log('Adding local stream.');
    localStream = stream;
    localAudio.srcObject = stream;
    sendMessage('got user media');
    if (isInitiator) {
        maybeStart();
    }
}

var constraints = {
    video: false,
    audio: true
};

console.log('Getting user media with constraints', constraints);

if (location.hostname !== 'localhost') {
    requestTurn(
        'https://computeengineondemand.appspot.com/turn?username=41784574&key=4080218913'
    );
}

// 조건이 맞다면 피어커넥션 함수 실행
function maybeStart() {
    console.log('>>>>>>> maybeStart() ', isStarted, localStream, isChannelReady);
    if (!isStarted && typeof localStream !== 'undefined' && isChannelReady) {
        console.log('>>>>>> creating peer connection');
        createPeerConnection();
        pc.addStream(localStream);
        isStarted = true;
        console.log('isInitiator', isInitiator);
        if (isInitiator) {
            doCall();
        }
    }
}

window.onbeforeunload = function () {
    sendMessage('bye');
};

/////////////////////////////////////////////////////////

function createPeerConnection() {
    try {
        pc = new RTCPeerConnection(null);
        pc.onicecandidate = handleIceCandidate;
        pc.onaddstream = handleRemoteStreamAdded;
        pc.onremovestream = handleRemoteStreamRemoved;
        console.log('Created RTCPeerConnnection');
    } catch (e) {
        console.log('Failed to create PeerConnection, exception: ' + e.message);
        alert('Cannot create RTCPeerConnection object.');
        return;
    }
}

function handleIceCandidate(event) {
    console.log('icecandidate event: ', event);
    if (event.candidate) {
        sendMessage({
            type: 'candidate',
            label: event.candidate.sdpMLineIndex,
            id: event.candidate.sdpMid,
            candidate: event.candidate.candidate
        });
    } else {
        console.log('End of candidates.');
    }
}

function handleCreateOfferError(event) {
    console.log('createOffer() error: ', event);
}

// 
function doCall() {
    console.log('Sending offer to peer');
    pc.createOffer(setLocalAndSendMessage, handleCreateOfferError);
}

function doAnswer() {
    console.log('Sending answer to peer.');
    pc.createAnswer().then(
        setLocalAndSendMessage,
        onCreateSessionDescriptionError
    );
}

function setLocalAndSendMessage(sessionDescription) {
    pc.setLocalDescription(sessionDescription);
    console.log('setLocalAndSendMessage sending message', sessionDescription);
    sendMessage(sessionDescription);
}

function onCreateSessionDescriptionError(error) {
    trace('Failed to create session description: ' + error.toString());
}

function requestTurn(turnURL) {
    var turnExists = false;
    for (var i in pcConfig.iceServers) {
        if (pcConfig.iceServers[i].urls.substr(0, 5) === 'turn:') {
            turnExists = true;
            turnReady = true;
            break;
        }
    }
    if (!turnExists) {
        console.log('Getting TURN server from ', turnURL);
        // No TURN server. Get one from computeengineondemand.appspot.com:
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4 && xhr.status === 200) {
                var turnServer = JSON.parse(xhr.responseText);
                console.log('Got TURN server: ', turnServer);
                pcConfig.iceServers.push({
                    'urls': 'turn:' + turnServer.username + '@' + turnServer.turn,
                    'credential': turnServer.password
                });
                turnReady = true;
            }
        };
        xhr.open('GET', turnURL, true);
        xhr.send();
    }
}

function handleRemoteStreamAdded(event) {
    console.log('Remote stream added.');
    remoteStream = event.stream;
    remoteAudio.srcObject = remoteStream;
}

function handleRemoteStreamRemoved(event) {
    console.log('Remote stream removed. Event: ', event);
}

function hangup() {
    console.log('Hanging up.');
    stop();
    sendMessage('bye');
}

function handleRemoteHangup() {
    console.log('Session terminated.');
    stop();
    isInitiator = false;
}

function stop() {
    isStarted = false;
    pc.close();
    pc = null;
}
