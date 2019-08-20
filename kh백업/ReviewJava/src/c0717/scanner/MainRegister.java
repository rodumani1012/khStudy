package c0717.scanner;

import java.util.ArrayList;
import java.util.Scanner;

import c0717.arraylist.Person;

public class MainRegister {

	public static void main(String[] args) {
		ArrayList<Person> personList = new ArrayList<Person>();
		Scanner s1 = new Scanner(System.in);
		boolean whileLoop = true;
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
				System.out.print("이름을 입력하세요 => ");
				String name = s1.next();
				System.out.print("나이를 입력하세요 => ");
				int age = s1.nextInt();
				Person p1 = new Person(name, age);
				personList.add(p1);
				System.out.println("계속 진행 합니다.");
				break;
			case 2:
				System.out.println("\n[전체 출력]");
				for (int i = 0; i < personList.size(); i++) {
					Person p2 = personList.get(i);
					p2.printInfo();
				}
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
