package c0717.scanner;

import java.util.Scanner;

public class MainScanner {

	public static void main(String[] args) {
		// Scanner ����
		Scanner sc = new Scanner(System.in);
		
		System.out.println("������ �Է��ϼ��� : ");
		int intValue = sc.nextInt(); // XX.nextInt(); �� �Է��� ������ �޴� �Լ�
		System.out.println("�Է�=[" + intValue + "]");
		
		System.out.println("�Ǽ��� �Է��ϼ��� : ");
		float floatValue = sc.nextFloat();
		System.out.println("�Է�=[" + floatValue + "]");
		
		System.out.println("�ܾ �Է��ϼ��� : ");
		String stringValue = sc.next(); //������ �����ڷ� �ܾ�
		System.out.println("�Է�=[" + stringValue + "]");
		
		
		// Scanner ����
		sc.close();
		System.out.println("Scanner closed.");
		
		
	}

}
