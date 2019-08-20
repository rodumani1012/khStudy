package c0717.scanner;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MainRegister_Coffee {

	public static void main(String[] args) {
		ArrayList<Coffee> coffeeList = new ArrayList<Coffee>();
		Scanner s1 = new Scanner(System.in);
		boolean whileLoop = true;
		DecimalFormat df1 = new DecimalFormat("#,###");
		int total = 0;
		while (whileLoop) {
			System.out.println("\n[메뉴 선택]-------------------");
			System.out.println("1. 등록");
			System.out.println("2. 전체 출력");
			System.out.println("9. 종료");
			System.out.print("메뉴를 선택하세요 => ");
			int menu = s1.nextInt();
			switch (menu) {
			case 1:
				System.out.println("[등록]");
				System.out.print("커피 메뉴을 입력하세요 => ");
				String inputName = s1.next();
				System.out.print("가격을 입력하세요 => ");
				int inputPrice = s1.nextInt();
				Coffee c1 = new Coffee(inputName, inputPrice);
				coffeeList.add(c1);
				System.out.println("계속 진행 합니다.");
				break;
			case 2:
				System.out.println("\n[전체 출력]");
				for (int i = 0; i < coffeeList.size(); i++) {
					Coffee c2 = coffeeList.get(i);
					c2.printInfo();		
					total += c2.getPrice();
				}
				System.out.println("-----총계-----");
				System.out.println("커피 개수 : " + coffeeList.size());
//				for (int j = 0; j < coffeeList.size(); j++) {
//					int price = coffeeList.get(j).getPrice();
//					total += price;
//				}
				String coffeePriceTotal = df1.format(total);
				System.out.println("가격 총액 : " + coffeePriceTotal);
				break;
			case 9:
				System.out.println("[종료]");
				System.out.println("프로그램을 종료합니다.");
				whileLoop = false;
				break;
			default:
				System.out.println("\n잘못 선택하셨습니다. 계속 진행을 합니다.");
				break;
			}
		}
		s1.close();
		System.out.println("Scanner closed");

	}

}
