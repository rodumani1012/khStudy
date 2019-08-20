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
		// System.out.println("일시=[" + dateTime + "]");
		//
		// String date = CalendarUtil.getDate();
		// System.out.println("일자=[" + date + "]");

//		ArrayList<Member> memberList = new ArrayList<Member>();
		ArrayList<Member> memberList = MemberFileUtil.readMemberFile("C:/Work/MemberInfo.txt");
		Scanner s1 = new Scanner(System.in);
		boolean whileLoop = true;
		System.out.println("******[ 회원관리 프로그램 : Manager HO ]******");
		System.out.println("프로그램을 시작합니다.");
		while (whileLoop) {
			System.out.println("\n[메뉴 선택]-------------------");
			System.out.println("1. 회원가입");
			System.out.println("2. 비밀번호 변경");
			System.out.println("3. 회원 삭제");
			System.out.println("4. 조회 : 전체");
			System.out.println("5. 조회 : 아이디");
			System.out.println("6. 조회 : 이름");
			System.out.println("7. 파일저장 : 전체");
			System.out.println("9. 종료");
			System.out.print("메뉴를 선택하세요 => ");
			int menu = s1.nextInt();
			switch (menu) {
			case 1:
				System.out.println("[회원 가입]");
				System.out.print("아이디를 입력하세요=> ");
				String inputId = s1.next();
				System.out.print("비밀번호를 입력하세요 => ");
				String inputPassword = s1.next();
				System.out.print("이름를 입력하세요=> ");
				String inputName = s1.next();
				System.out.print("이메일를 입력하세요=> ");
				String inputEmail = s1.next();
				String regdate1 = CalendarUtil.getDate();
				Member m1 = new Member(inputId, inputPassword, inputName, inputEmail, regdate1);
				memberList.add(m1);
				System.out.println("계속 진행 합니다.");
				break;
			case 2:
				System.out.println("\n[비밀번호 변경]");
				System.out.print("아이디를 입력하세요.");
				String changePwId = s1.next();
				System.out.print("변경할 비밀번호를 입력하세요.");
				String changePw = s1.next();
				for (int i = 0; i < memberList.size(); i++) {
					String change1 = memberList.get(i).getId();
					if (changePwId.equals(change1)) {
						memberList.get(i).setPassword(changePw);
						System.out.println(change1 + " 님의 비밀번호가 변경되었습니다");
						break;
					}
				}

				break;
			case 3:
				System.out.println("[회원 삭제]");
				System.out.print("삭제할 아이디를 입력하세요.");
				String delId = s1.next();
				for (int i = 0; i < memberList.size(); i++) {
					String change2 = memberList.get(i).getId();
					if (delId.equals(change2)) {
						memberList.remove(i);
						System.out.println(change2 + " 님의 회원탈퇴가 정상적으로 처리되었습니다.");
						break;
					}
				}
				break;
			case 4:
				System.out.println("[전체 조회]");
				System.out.println("회원을 조회합니다.");
				for (int i = 0; i < memberList.size(); i++) {
					Member m = memberList.get(i);
					System.out.print((i + 1) + ".");
					m.printInfo();
				}
				break;
			case 5:
				System.out.println("[아이디 조회]");
				System.out.print("아이디를 입력하세요 => ");
				String searchId = s1.next();
				boolean existIdYn5 = false; // 아이디 존재 여부. true:존재, false:미존재.
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
					System.out.println("\t아이디가 존재하지 않습니다.");
				}
				break;
			case 6:
				System.out.println("[이름 조회]");
				System.out.print("이름을 입력하세요 => ");
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
					System.out.println("\t아이디가 존재하지 않습니다.");
				}
				break;
			case 7:
				System.out.println("[파일저장 : 전체]");
				System.out.print("회원 정보를 파일로 저장하시겠습니까? (y/n) =>");
				String saveYn = s1.next();
				if (saveYn.equals("y")) {
					MemberFileUtil.writeMemberFile(memberList, "C:/Work/MemberInfo.txt");
				} else {
					System.out.println("파일 저장을 취소하셨습니다.");
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
