package test.oper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * @author 최준연
 * 설명 : 
 * InputStreamReader를 사용하여 입력값을 받고
 * BufferedReader를 사용하여 이를 읽고 출력한다
 *
 */
public class TestOper5 {
	// String[] args = {"5", "2", "-"}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			String string = args[i];
			System.out.println(string);			
		}
		int opr1 = 5, opr2 = 2; char op = '-';
		int result = 0;
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("input 1st number : ");
		opr1 = in.nextInt();
		System.out.print("input 2st number : ");
		opr2 = in.nextInt();
		System.out.print("input op> ");
		op = in.next().charAt(0);
		
		
		switch (op) {
		case '+': 
			result = opr1 + opr2;			
			break;
		case '-': 
			result = opr1 - opr2;			
			break;
		case '*': 
			result = opr1 * opr2;			
			break;
		case '/': 
			result = opr1 / opr2;			
			break;
		default:
			result = 0;
			break;
		}
		
		
		System.out.println(""+opr1+op+opr2+"="+result);

		
	}

}
