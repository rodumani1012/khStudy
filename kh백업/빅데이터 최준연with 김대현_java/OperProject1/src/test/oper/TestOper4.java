package test.oper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 최준연
 * 설명 : 
 * InputStreamReader를 사용하여 입력값을 받고
 * BufferedReader를 사용하여 이를 읽고 출력한다
 *
 */
public class TestOper4 {
	// String[] args = {"5", "2", "-"}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			String string = args[i];
			System.out.println(string);			
		}
		int opr1 = 5, opr2 = 2; char op = '-';
		int result = 0;
		
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
				
		System.out.print("input 1st number : ");
		args[0] = br.readLine();
		System.out.print("input 2st number : ");
		args[1] = br.readLine();
		System.out.print("input op> ");
		args[2] = br.readLine();
		
		opr1 = Integer.parseInt(args[0]);
		opr2 = Integer.parseInt(args[1]);		
		op = args[2].charAt(0);
		
		
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
