package c0717.scanner;

import java.util.Scanner;

public class MainScanner4_CoffeeMenu {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		System.out.println("커피 이름을 입력하세요 : ");
		String inputName = s1.nextLine();
		System.out.println("가격을 입력하세요 : ");
		int inputPrice = s1.nextInt();
		Coffee menu = new Coffee(inputName, inputPrice);
		menu.printInfo();
		
		s1.close();
		System.out.println("Scanner closed");

	}

}
