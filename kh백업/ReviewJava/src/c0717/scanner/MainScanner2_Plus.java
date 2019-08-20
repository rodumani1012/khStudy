package c0717.scanner;

import java.util.Scanner;

public class MainScanner2_Plus {

	public static void main(String[] args) {
		System.out.println("연산을 시작합니다.");
		Scanner s1 = new Scanner(System.in);
		System.out.println("첫번째 숫자를 입력하세요 : ");
		int intVal1 = s1.nextInt();
		System.out.println("두번째 숫자를 입력하세요 : ");
		int intVal2 = s1.nextInt();
		int plusResult = intVal1 + intVal2;
		System.out.println(intVal1 + " + " + intVal2 + " = " + plusResult);
		s1.close();
		System.out.println("Scanner closed.");
	}

}
