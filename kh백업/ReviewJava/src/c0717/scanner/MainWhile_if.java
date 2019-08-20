package c0717.scanner;

import java.util.Scanner;

public class MainWhile_if {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.println("\n0 ~ 9 사이의 숫자를 입력하세요.");
			System.out.println("9는 프로그램 종료입니다.");
			System.out.println("숫자 입력 : ");
			int choice = s1.nextInt();
			if (choice == 9) {
				break; //while문을 종료한다.
			} else {
				System.out.println("계속 진행을 합니다.");
			}
		}
		s1.close();
		System.out.println("Scanner closed.");
	}

}
