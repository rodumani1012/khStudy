package exception.ex;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("영문을 쓰세요(대문자 입력시 오류 발생): ");
		String input = sc.next();
		
		//[1]
		//input을 살펴 본다음에 대문자가 포함되어 있다면 오류 발생!!
		
		try {
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i) >= 'A' && input.charAt(i)<='Z') {
				throw new CustomException("아니아니아니아니야~");
				
			}
		}
		} catch (CustomException e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
