package c0717.scanner;

import java.util.Scanner;

public class MainScanner4_CoffeeMenu {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		System.out.println("Ŀ�� �̸��� �Է��ϼ��� : ");
		String inputName = s1.nextLine();
		System.out.println("������ �Է��ϼ��� : ");
		int inputPrice = s1.nextInt();
		Coffee menu = new Coffee(inputName, inputPrice);
		menu.printInfo();
		
		s1.close();
		System.out.println("Scanner closed");

	}

}
