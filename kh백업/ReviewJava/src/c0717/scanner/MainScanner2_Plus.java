package c0717.scanner;

import java.util.Scanner;

public class MainScanner2_Plus {

	public static void main(String[] args) {
		System.out.println("������ �����մϴ�.");
		Scanner s1 = new Scanner(System.in);
		System.out.println("ù��° ���ڸ� �Է��ϼ��� : ");
		int intVal1 = s1.nextInt();
		System.out.println("�ι�° ���ڸ� �Է��ϼ��� : ");
		int intVal2 = s1.nextInt();
		int plusResult = intVal1 + intVal2;
		System.out.println(intVal1 + " + " + intVal2 + " = " + plusResult);
		s1.close();
		System.out.println("Scanner closed.");
	}

}
