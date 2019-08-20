package c0717.scanner;

import java.util.Scanner;

public class MainWhile_switch {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		boolean whileLoop = true;
		while (whileLoop) {
			System.out.println("\n0 ~ 9 사이의 숫자를 입력하세요.");
			System.out.println("9는 프로그램 종료입니다.");
			System.out.println("숫자 입력 : ");
			int choice = s1.nextInt();
			switch (choice) {
			case 9:
				System.out.println("종료를 선택하셨습니다.");
				whileLoop = false;
				break;
			default:
				System.out.println("계속 진행을 합니다.");
				break;
			}
		}

		s1.close();
		System.out.println("Scanner closed.");
	}
}
