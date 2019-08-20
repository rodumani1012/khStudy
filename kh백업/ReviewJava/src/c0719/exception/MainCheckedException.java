package c0719.exception;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MainCheckedException {

	public static void main(String[] args) {
		// checked Exception 일단 무조건 예외처리 해야하는 것
		InetAddress ia;
//		ia = InetAddress.getByName("www.naver.com");
//		System.out.println("ia=[" + ia + "]");
		
		try {
			ia = InetAddress.getByName("www.naver.com");
			System.out.println("ia=[" + ia + "]"); 
		} catch (UnknownHostException e) {
			System.out.println("-- Exception Handling !!! --");
		} finally {
			System.out.println("finally");
		}
		
	}

}
