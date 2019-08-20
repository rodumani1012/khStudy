package c0717.scanner;

import java.util.Scanner;

public class MainScanner3_Name {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		System.out.println("이름을 입력하세요 : ");
		String inputName = s1.next();
		System.out.println("나이를 입력하세요 : ");
		int inputAge = s1.nextInt();
		Person p1 = new Person(inputName, inputAge);
		p1.printInfo();
		
		s1.close();
		System.out.println("Scanner closed");
	}

}
