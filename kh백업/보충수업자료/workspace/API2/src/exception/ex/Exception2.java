package exception.ex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception2 {

	//1 -> 랜던값으로 나눴다!
	//2 -> 입력한 값으로 나눠보자!!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//결과값 담을 변수
		int res = 0;
		
		System.out.println("나눌 숫자 하나 입력!!: ");
		
		//try / catch
		
//		try {
//		int num = sc.nextInt();
//		res = 10/num;
//		System.out.println(res);
//		} catch (ArithmeticException e) {
//			System.out.println("0을 넣으니까 안되지요!!!!");
//		} catch(InputMismatchException e) {
//			System.out.println("문자를 넣으니까 안되는거자나!!!");
//		}
		
		
//		try {
//		int num = sc.nextInt();
//		res = 10/num;
//		System.out.println(res);
//		} catch(Exception e) {
//			System.out.println("문자를 넣거나 0을 넣으니까 안되는거자나!!!");
//		}
//		
		
		try {
		int num = sc.nextInt();
		res = 10/num;
		System.out.println(res);
		}catch (ArithmeticException e) {
			System.out.println("0을 넣으니까 안되지요!!!!");
		} catch(InputMismatchException e) {
			System.out.println("문자를 넣으니까 안되는거자나!!!");
		} catch(Exception e) {
			System.out.println("너가 0아니면 문자 입력햇겠지...!!!");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
