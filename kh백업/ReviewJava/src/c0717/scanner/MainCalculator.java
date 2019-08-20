package c0717.scanner;

import java.util.Scanner;

public class MainCalculator {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		boolean whileLoop = true;
		int result = 0;
		while (whileLoop) {
			System.out.println("\n[메뉴]----------------------------");
			System.out.println("1. 더하기");
			System.out.println("2. 빼기");
			System.out.println("3. 곱하기");
			System.out.println("4. 나누기");
			System.out.println("5. 나머지");
			System.out.println("9. 종료");	
			System.out.print("원하는 연산 메뉴를 입력하세요 : ");
			int choiceMenu = s1.nextInt();
			switch (choiceMenu) {
			case 1:
				System.out.println("더하기를 선택하셨습니다.");
				System.out.print("첫번째 숫자를 입력하세요 : ");
				int a1 = s1.nextInt();
				System.out.print("두번째 숫자를 입력하세요 : ");
				int b1 = s1.nextInt();
				result = a1 + b1;
				System.out.println("결과값 = " + result);
				break;
			case 2:
				System.out.println("빼기를 선택하셨습니다.");
				System.out.print("첫번째 숫자를 입력하세요 : ");
				int a2 = s1.nextInt();
				System.out.print("두번째 숫자를 입력하세요 : ");
				int b2 = s1.nextInt();
				result = a2 - b2;
				System.out.println("결과값 = " + result);
				break;
			case 3:
				System.out.println("곱하기를 선택하셨습니다.");
				System.out.print("첫번째 숫자를 입력하세요 : ");
				int a3 = s1.nextInt();
				System.out.print("두번째 숫자를 입력하세요 : ");
				int b3 = s1.nextInt();
				result = a3 * b3;
				System.out.println("결과값 = " + result);
				break;
			case 4:
				System.out.println("나누기를 선택하셨습니다.");
				System.out.print("첫번째 숫자를 입력하세요 : ");
				int a4 = s1.nextInt();
				System.out.print("두번째 숫자를 입력하세요 : ");
				int b4 = s1.nextInt();
				result = a4 / b4;
				System.out.println("결과값 = " + result);
				break;
			case 5:
				System.out.println("나머지를 선택하셨습니다.");
				System.out.print("첫번째 숫자를 입력하세요 : ");
				int a5 = s1.nextInt();
				System.out.print("두번째 숫자를 입력하세요 : ");
				int b5 = s1.nextInt();
				result = a5 % b5;
				System.out.println("결과값 = " + result);
				break;
			case 9:
				System.out.println("종료를 선택하셨습니다.");
				whileLoop = false;
				break;

			default:
				System.out.println("\n잘못 선택하셨습니다. 계속 진행을 합니다.");
				break;
			}
			
		}
		s1.close();
		System.out.println("Scanner closed.");
	}

}
