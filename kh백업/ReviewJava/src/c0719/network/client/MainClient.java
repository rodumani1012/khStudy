package c0719.network.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import c0719.network.server.LogUtil;

public class MainClient {

	public static void main(String[] args) {
		LogUtil.printInfo("----------Client----------");
		Socket socket = null;
		
		// Stream : Variable ------------------------------------------
		// Input  // 키보드로부터 입력을 받아내는 것
		InputStreamReader isr = null; //바이트 스트림 => 문자 단위로 입력 받음
		BufferedReader br = null; // 라인 단위로 입력 받음
		// Output
		OutputStream os = null;
		OutputStreamWriter osw = null; // 문자 스트림 => 바이트
		PrintWriter pw = null;
		// -------------------------------------------------------
		
		
		try {
			String serverIp = "220.67.114.125"; // 서버 IP
			int serverPort = 8000; // 서버 Port(포트)
			socket = new Socket(serverIp, serverPort); // 서버와 연결(서버에 신호를 보내는것)
														// MainServer에서 accept하여
														// 신호를 받는다.
			LogUtil.printMsg("서버 연결 성공");
			LogUtil.printInfo("\t# Connection Information");
			LogUtil.printInfo("\t* Local IP=[" + socket.getLocalAddress() + "]");
			LogUtil.printInfo("\t* Local Port=[" + socket.getLocalPort() + "]");
			LogUtil.printInfo("\t* Remote IP=[" + socket.getInetAddress() + "]");
			LogUtil.printInfo("\t* Remote Port=[" + socket.getPort() + "]");
			
			// Stream : Object Creation -------------------------------------
			// Input
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			
			// Output
			os = socket.getOutputStream();
			osw = new OutputStreamWriter(os);
			pw = new PrintWriter(osw);
			//-----------------------------------------------------------
			// Stream : 메시지 송신
			LogUtil.printMsgGuide("메시지를 입력하세요 => ");
			while (true) {
				String message = br.readLine();
				if (message == null) {
					break;
				}
				if (message.equals("quit")) {
					break;
				}
				pw.println(message);
				pw.flush();
				LogUtil.printMsgGuide("메시지를 입력하세요 => ");
			}
			//--------------------------------------------------------------------
			
			//Stream : Close -----------------------------------------------------
			//Input
			br.close();
			isr.close();
			//Output
			pw.close();
			osw.close();
			os.close();
			// ---------------------------------------------------------------------
			
			socket.close(); // 통신 종료
			LogUtil.printMsg("서버 연결 종료");
		} catch (UnknownHostException e) {
			LogUtil.printInfo("\n----[Client] UnknownHostException");
			e.printStackTrace();
		} catch (IOException e) {
			LogUtil.printInfo("\n----[Client] IOException");
			e.printStackTrace();
		} finally {
			// Stream : finally ----------------------------------------------
			// Input
			try {
				if (br != null) {br.close();}
			} catch (IOException e) {e.printStackTrace();}
			try {
				if (isr != null) {isr.close();}
			} catch (IOException e) {e.printStackTrace();}
			// Output
			if (pw != null) {pw.close();}
			try {
				if (osw != null) {osw.close();}
			} catch (IOException e) {e.printStackTrace();}
			try {
				if (os != null) {os.close();}
			} catch (IOException e) {e.printStackTrace();}
			try {
				if (socket != null) {socket.close();}
			} catch (IOException e) {e.printStackTrace();}
		}
	}

}
