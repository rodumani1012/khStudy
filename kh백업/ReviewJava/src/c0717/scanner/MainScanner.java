package c0717.scanner;

import java.util.Scanner;

public class MainScanner {

	public static void main(String[] args) {
		// Scanner 시작
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요 : ");
		int intValue = sc.nextInt(); // XX.nextInt(); 는 입력을 정수로 받는 함수
		System.out.println("입력=[" + intValue + "]");
		
		System.out.println("실수를 입력하세요 : ");
		float floatValue = sc.nextFloat();
		System.out.println("입력=[" + floatValue + "]");
		
		System.out.println("단어를 입력하세요 : ");
		String stringValue = sc.next(); //공백을 구분자로 단어
		System.out.println("입력=[" + stringValue + "]");
		
		
		// Scanner 종료
		sc.close();
		System.out.println("Scanner closed.");
		
		
	}

}
