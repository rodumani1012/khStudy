package c0717.scanner;

import java.util.Scanner;

public class MainWhile_switch {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		boolean whileLoop = true;
		while (whileLoop) {
			System.out.println("\n0 ~ 9 ������ ���ڸ� �Է��ϼ���.");
			System.out.println("9�� ���α׷� �����Դϴ�.");
			System.out.println("���� �Է� : ");
			int choice = s1.nextInt();
			switch (choice) {
			case 9:
				System.out.println("���Ḧ �����ϼ̽��ϴ�.");
				whileLoop = false;
				break;
			default:
				System.out.println("��� ������ �մϴ�.");
				break;
			}
		}

		s1.close();
		System.out.println("Scanner closed.");
	}
}
