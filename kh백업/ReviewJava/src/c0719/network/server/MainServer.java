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
		InputStream is = null; 			//Stream ����
		InputStreamReader isr = null;	// inputstream --> reader ��ȯ
		BufferedReader br = null;		//���� ������ ����
		//-----------------------------------------------------------
		
		try {
			int port = 8000;
			serverSocket = new ServerSocket(port); // 8000���̶�� ���� ������ ������ �� ���

			socket = serverSocket.accept(); 		// Ŭ���̾�Ʈ�� ����(��ȣ�� ������ ó���ϴ� ��)
			LogUtil.printMsg("Ŭ���̾�Ʈ ���� ����");		// �ڵ����� �����ϴ� ������ ����
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
			
			// Stream : �޽��� ����
			while (true) {
				String message = br.readLine(); // �� �� ������ �о��.
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
