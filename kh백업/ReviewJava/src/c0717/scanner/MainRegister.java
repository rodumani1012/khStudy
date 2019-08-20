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
			System.out.println("\n[�޴� ����]-------------------");
			System.out.println("1. ���");
			System.out.println("2. ��ü ���");
			System.out.println("9. ����");
			System.out.print("�޴��� �����ϼ��� => ");
			int menu = s1.nextInt();
			switch (menu) {
			case 1:
				System.out.println("[���]");
				System.out.print("�̸��� �Է��ϼ��� => ");
				String name = s1.next();
				System.out.print("���̸� �Է��ϼ��� => ");
				int age = s1.nextInt();
				Person p1 = new Person(name, age);
				personList.add(p1);
				System.out.println("��� ���� �մϴ�.");
				break;
			case 2:
				System.out.println("\n[��ü ���]");
				for (int i = 0; i < personList.size(); i++) {
					Person p2 = personList.get(i);
					p2.printInfo();
				}
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
