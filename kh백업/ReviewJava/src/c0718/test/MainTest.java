package c0718.test;

import java.util.ArrayList;
import java.util.Scanner;

import c0718.test.CalendarUtil;

public class MainTest {

	public static void main(String[] args) {
		// Member m1 = new Member("myId", "myPassword", "myName",
		// "my@email.com", CalendarUtil.getDate());
		// m1.printInfo();

		// Calendar
		// CalendarUtil cu = new CalendarUtil();
		// String dateTime = cu.getDateTime();
		// String dateTime = CalendarUtil.getDateTime();
		// System.out.println("�Ͻ�=[" + dateTime + "]");
		//
		// String date = CalendarUtil.getDate();
		// System.out.println("����=[" + date + "]");

//		ArrayList<Member> memberList = new ArrayList<Member>();
		ArrayList<Member> memberList = MemberFileUtil.readMemberFile("C:/Work/MemberInfo.txt");
		Scanner s1 = new Scanner(System.in);
		boolean whileLoop = true;
		System.out.println("******[ ȸ������ ���α׷� : Manager HO ]******");
		System.out.println("���α׷��� �����մϴ�.");
		while (whileLoop) {
			System.out.println("\n[�޴� ����]-------------------");
			System.out.println("1. ȸ������");
			System.out.println("2. ��й�ȣ ����");
			System.out.println("3. ȸ�� ����");
			System.out.println("4. ��ȸ : ��ü");
			System.out.println("5. ��ȸ : ���̵�");
			System.out.println("6. ��ȸ : �̸�");
			System.out.println("7. �������� : ��ü");
			System.out.println("9. ����");
			System.out.print("�޴��� �����ϼ��� => ");
			int menu = s1.nextInt();
			switch (menu) {
			case 1:
				System.out.println("[ȸ�� ����]");
				System.out.print("���̵� �Է��ϼ���=> ");
				String inputId = s1.next();
				System.out.print("��й�ȣ�� �Է��ϼ��� => ");
				String inputPassword = s1.next();
				System.out.print("�̸��� �Է��ϼ���=> ");
				String inputName = s1.next();
				System.out.print("�̸��ϸ� �Է��ϼ���=> ");
				String inputEmail = s1.next();
				String regdate1 = CalendarUtil.getDate();
				Member m1 = new Member(inputId, inputPassword, inputName, inputEmail, regdate1);
				memberList.add(m1);
				System.out.println("��� ���� �մϴ�.");
				break;
			case 2:
				System.out.println("\n[��й�ȣ ����]");
				System.out.print("���̵� �Է��ϼ���.");
				String changePwId = s1.next();
				System.out.print("������ ��й�ȣ�� �Է��ϼ���.");
				String changePw = s1.next();
				for (int i = 0; i < memberList.size(); i++) {
					String change1 = memberList.get(i).getId();
					if (changePwId.equals(change1)) {
						memberList.get(i).setPassword(changePw);
						System.out.println(change1 + " ���� ��й�ȣ�� ����Ǿ����ϴ�");
						break;
					}
				}

				break;
			case 3:
				System.out.println("[ȸ�� ����]");
				System.out.print("������ ���̵� �Է��ϼ���.");
				String delId = s1.next();
				for (int i = 0; i < memberList.size(); i++) {
					String change2 = memberList.get(i).getId();
					if (delId.equals(change2)) {
						memberList.remove(i);
						System.out.println(change2 + " ���� ȸ��Ż�� ���������� ó���Ǿ����ϴ�.");
						break;
					}
				}
				break;
			case 4:
				System.out.println("[��ü ��ȸ]");
				System.out.println("ȸ���� ��ȸ�մϴ�.");
				for (int i = 0; i < memberList.size(); i++) {
					Member m = memberList.get(i);
					System.out.print((i + 1) + ".");
					m.printInfo();
				}
				break;
			case 5:
				System.out.println("[���̵� ��ȸ]");
				System.out.print("���̵� �Է��ϼ��� => ");
				String searchId = s1.next();
				boolean existIdYn5 = false; // ���̵� ���� ����. true:����, false:������.
											// Flag : 0 or 1
				for (int i = 0; i < memberList.size(); i++) {
					String id = memberList.get(i).getId();
					if (searchId.equals(id)) {
						System.out.println("\t");
						memberList.get(i).printInfo();
						existIdYn5 = true;
						break;
					}
				}
				if (existIdYn5 == false) {
					System.out.println("\t���̵� �������� �ʽ��ϴ�.");
				}
				break;
			case 6:
				System.out.println("[�̸� ��ȸ]");
				System.out.print("�̸��� �Է��ϼ��� => ");
				String searchName = s1.next();
				boolean existIdYn6 = false;
				for (int i = 0; i < memberList.size(); i++) {
					String name = memberList.get(i).getName();
					if (searchName.equals(name)) {
						System.out.println("\t");
						memberList.get(i).printInfo();
						existIdYn6 = true;
						break;
					}
				}
				if (existIdYn6 == false) {
					System.out.println("\t���̵� �������� �ʽ��ϴ�.");
				}
				break;
			case 7:
				System.out.println("[�������� : ��ü]");
				System.out.print("ȸ�� ������ ���Ϸ� �����Ͻðڽ��ϱ�? (y/n) =>");
				String saveYn = s1.next();
				if (saveYn.equals("y")) {
					MemberFileUtil.writeMemberFile(memberList, "C:/Work/MemberInfo.txt");
				} else {
					System.out.println("���� ������ ����ϼ̽��ϴ�.");
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
