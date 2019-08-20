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
			System.out.println("\n[�޴� ����]-------------------");
			System.out.println("1. ���");
			System.out.println("2. ��ü ���");
			System.out.println("9. ����");
			System.out.print("�޴��� �����ϼ��� => ");
			int menu = s1.nextInt();
			switch (menu) {
			case 1:
				System.out.println("[���]");
				System.out.print("Ŀ�� �޴��� �Է��ϼ��� => ");
				String inputName = s1.next();
				System.out.print("������ �Է��ϼ��� => ");
				int inputPrice = s1.nextInt();
				Coffee c1 = new Coffee(inputName, inputPrice);
				coffeeList.add(c1);
				System.out.println("��� ���� �մϴ�.");
				break;
			case 2:
				System.out.println("\n[��ü ���]");
				for (int i = 0; i < coffeeList.size(); i++) {
					Coffee c2 = coffeeList.get(i);
					c2.printInfo();		
					total += c2.getPrice();
				}
				System.out.println("-----�Ѱ�-----");
				System.out.println("Ŀ�� ���� : " + coffeeList.size());
//				for (int j = 0; j < coffeeList.size(); j++) {
//					int price = coffeeList.get(j).getPrice();
//					total += price;
//				}
				String coffeePriceTotal = df1.format(total);
				System.out.println("���� �Ѿ� : " + coffeePriceTotal);
				break;
			case 9:
				System.out.println("[����]");
				System.out.println("���α׷��� �����մϴ�.");
				whileLoop = false;
				break;
			default:
				System.out.println("\n�߸� �����ϼ̽��ϴ�. ��� ������ �մϴ�.");
				break;
			}
		}
		s1.close();
		System.out.println("Scanner closed");

	}

}
