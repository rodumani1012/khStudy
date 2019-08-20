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
		// Input  // Ű����κ��� �Է��� �޾Ƴ��� ��
		InputStreamReader isr = null; //����Ʈ ��Ʈ�� => ���� ������ �Է� ����
		BufferedReader br = null; // ���� ������ �Է� ����
		// Output
		OutputStream os = null;
		OutputStreamWriter osw = null; // ���� ��Ʈ�� => ����Ʈ
		PrintWriter pw = null;
		// -------------------------------------------------------
		
		
		try {
			String serverIp = "220.67.114.125"; // ���� IP
			int serverPort = 8000; // ���� Port(��Ʈ)
			socket = new Socket(serverIp, serverPort); // ������ ����(������ ��ȣ�� �����°�)
														// MainServer���� accept�Ͽ�
														// ��ȣ�� �޴´�.
			LogUtil.printMsg("���� ���� ����");
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
			// Stream : �޽��� �۽�
			LogUtil.printMsgGuide("�޽����� �Է��ϼ��� => ");
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
				LogUtil.printMsgGuide("�޽����� �Է��ϼ��� => ");
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
			
			socket.close(); // ��� ����
			LogUtil.printMsg("���� ���� ����");
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
