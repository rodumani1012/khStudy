package c0717.scanner;

import java.util.Scanner;

public class MainCalculator {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		boolean whileLoop = true;
		int result = 0;
		while (whileLoop) {
			System.out.println("\n[�޴�]----------------------------");
			System.out.println("1. ���ϱ�");
			System.out.println("2. ����");
			System.out.println("3. ���ϱ�");
			System.out.println("4. ������");
			System.out.println("5. ������");
			System.out.println("9. ����");	
			System.out.print("���ϴ� ���� �޴��� �Է��ϼ��� : ");
			int choiceMenu = s1.nextInt();
			switch (choiceMenu) {
			case 1:
				System.out.println("���ϱ⸦ �����ϼ̽��ϴ�.");
				System.out.print("ù��° ���ڸ� �Է��ϼ��� : ");
				int a1 = s1.nextInt();
				System.out.print("�ι�° ���ڸ� �Է��ϼ��� : ");
				int b1 = s1.nextInt();
				result = a1 + b1;
				System.out.println("����� = " + result);
				break;
			case 2:
				System.out.println("���⸦ �����ϼ̽��ϴ�.");
				System.out.print("ù��° ���ڸ� �Է��ϼ��� : ");
				int a2 = s1.nextInt();
				System.out.print("�ι�° ���ڸ� �Է��ϼ��� : ");
				int b2 = s1.nextInt();
				result = a2 - b2;
				System.out.println("����� = " + result);
				break;
			case 3:
				System.out.println("���ϱ⸦ �����ϼ̽��ϴ�.");
				System.out.print("ù��° ���ڸ� �Է��ϼ��� : ");
				int a3 = s1.nextInt();
				System.out.print("�ι�° ���ڸ� �Է��ϼ��� : ");
				int b3 = s1.nextInt();
				result = a3 * b3;
				System.out.println("����� = " + result);
				break;
			case 4:
				System.out.println("�����⸦ �����ϼ̽��ϴ�.");
				System.out.print("ù��° ���ڸ� �Է��ϼ��� : ");
				int a4 = s1.nextInt();
				System.out.print("�ι�° ���ڸ� �Է��ϼ��� : ");
				int b4 = s1.nextInt();
				result = a4 / b4;
				System.out.println("����� = " + result);
				break;
			case 5:
				System.out.println("�������� �����ϼ̽��ϴ�.");
				System.out.print("ù��° ���ڸ� �Է��ϼ��� : ");
				int a5 = s1.nextInt();
				System.out.print("�ι�° ���ڸ� �Է��ϼ��� : ");
				int b5 = s1.nextInt();
				result = a5 % b5;
				System.out.println("����� = " + result);
				break;
			case 9:
				System.out.println("���Ḧ �����ϼ̽��ϴ�.");
				whileLoop = false;
				break;

			default:
				System.out.println("\n�߸� �����ϼ̽��ϴ�. ��� ������ �մϴ�.");
				break;
			}
			
		}
		s1.close();
		System.out.println("Scanner closed.");
	}

}
