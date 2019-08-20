package c0719.network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainInteAddress {

	public static void main(String[] args) {
		
		try {
			InetAddress local = InetAddress.getLocalHost(); //내 컴퓨터의 정보를 갖고오는 것
			
			System.out.println("--------Local--------");
			System.out.print("Host=[" + local.getHostName() + "]");
			System.out.println("\tIP=[" + local.getHostAddress() +"]");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			InetAddress remote = InetAddress.getByName("www.naver.com"); //상대의 정보를 갖고오는것
			
			System.out.println("--------Remote--------");
			System.out.print("Host=[" + remote.getHostName() + "]");
			System.out.println("\tIP=[" + remote.getHostAddress() +"]");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		// getAllByName()  -  갖고있는 모든 (여러개의) IP 주소를 얻는다.
		try {
			InetAddress[] remoteArray = InetAddress.getAllByName("www.naver.com");

			System.out.println("\n--------Remote All--------");
			for (int i = 0; i < remoteArray.length; i++) {
				System.out.print("Host=[" + remoteArray[i].getHostName() + "]");
				System.out.println("\tIP=[" + remoteArray[i].getHostAddress() +"]");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
