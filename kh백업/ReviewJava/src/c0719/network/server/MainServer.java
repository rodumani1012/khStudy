package c0719.network.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	public static void main(String[] args) {

		LogUtil.printInfo("-------------------------Server-------------------------");

		ServerSocket serverSocket = null;
		Socket socket = null;
		
		//Stream : Variable -----------------------------------------
		//input
		InputStream is = null; 			//Stream 단위
		InputStreamReader isr = null;	// inputstream --> reader 변환
		BufferedReader br = null;		//라인 단위로 읽음
		//-----------------------------------------------------------
		
		try {
			int port = 8000;
			serverSocket = new ServerSocket(port); // 8000번이라는 서버 소켓을 생성한 후 대기

			socket = serverSocket.accept(); 		// 클라이언트와 연결(신호가 들어오면 처리하는 것)
			LogUtil.printMsg("클라이언트 연결 성공");		// 자동으로 연결하는 소켓을 생성
			LogUtil.printInfo("\t# Connection Information");
			LogUtil.printInfo("\t* Local IP=[" + socket.getLocalAddress() + "]");
			LogUtil.printInfo("\t* Local Port=[" + socket.getLocalPort() + "]");
			LogUtil.printInfo("\t* Remote IP=[" + socket.getInetAddress() + "]");
			LogUtil.printInfo("\t* Remote Port=[" + socket.getPort() + "]");
			
			//Stream : Object Creation -----------------------------------------
			// Input
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			// ---------------------------------------------------------------------
			
			// Stream : 메시지 수신
			while (true) {
				String message = br.readLine(); // 한 줄 단위로 읽어낸다.
				if (message == null) {
					break;
				}
				LogUtil.printMsg("(Client)" + message);
			}
			
			// Stream : Close --------------------------------------------------------
			// Input
			br.close();
			isr.close();
			is.close();
			// -----------------------------------------------------------------------
			
			socket.close();
			LogUtil.printMsg("Socket Close");
			serverSocket.close();
			System.out.println("ServerSocket close");
		} catch (IOException e) {
			LogUtil.printInfo("\n------- [Server] IOException ------");
			e.printStackTrace();
		} finally {
			try { 
				if (socket != null) {socket.close();}
			} catch (IOException e) {e.printStackTrace();}
			
			try {
				if (serverSocket != null) {serverSocket.close();}
			} catch (IOException e) {e.printStackTrace();}
			
			try { 
				if (br != null) {br.close();}
			} catch (IOException e) {e.printStackTrace();}
			try { 
				if (isr != null) {isr.close();}
			} catch (IOException e) {e.printStackTrace();}
			try { 
				if (is != null) {is.close();}
			} catch (IOException e) {e.printStackTrace();}
		}

	}

}
