package c0717.scanner;

import java.util.Scanner;

public class MainWhile_if {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		while (true) {
			System.out.println("\n0 ~ 9 ������ ���ڸ� �Է��ϼ���.");
			System.out.println("9�� ���α׷� �����Դϴ�.");
			System.out.println("���� �Է� : ");
			int choice = s1.nextInt();
			if (choice == 9) {
				break; //while���� �����Ѵ�.
			} else {
				System.out.println("��� ������ �մϴ�.");
			}
		}
		s1.close();
		System.out.println("Scanner closed.");
	}

}
