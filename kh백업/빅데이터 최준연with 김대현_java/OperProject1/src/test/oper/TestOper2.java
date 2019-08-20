package test.oper;

import java.io.IOException;

/**
 * 
 * @author 최준연
 * 설명 : 
 * 1. Arguments에 정수 2개, 연산자 1개를 넣는다. 
 * 1-1 for문으로 Arguments의 입력값을 출력해본다
 * 2. Arguments를 int로 인식하기 위해 x = Integer.parseInt(); 를 사용한다.
 *
 */
public class TestOper2 {
	// String[] args = {"5", "2", "-"}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for (int i = 0; i < args.length; i++) {
			String string = args[i];
			System.out.println(string);			
		}
		int opr1 = 5, opr2 = 2; char op = '-';
		int result = 0;

//		Integer i = new Integer(opr1); //Wrapper 클래스
//		Integer i = new Integer(args[0]);
//		opr1 = i.intValue();
		
//		i = new Integer(args[1]);
//		opr2 = i.intValue();
		
		opr1 = Integer.parseInt(args[0]);
		opr2 = Integer.parseInt(args[1]);		
		op = args[2].charAt(0);
		
		
		System.out.print("input : ");
		int data = System.in.read();
		System.out.println("input data = " + (char)data);
		opr1 = (char)data;
		
		System.out.print("input : ");
		data = System.in.read();
		System.out.println("input data = " + (char)data);
		opr2 = (char)data;
		
		System.out.print("input : ");
		data = System.in.read();
		System.out.println("input data = " + (char)data);
		op = (char)data;

		/*
		 * if else 구문
		if (op == '+') { result = opr1 + opr2;
			
		} else { result = opr1 - opr2;

		}
		*/
		/*삼항 연산자
		result = (op=='+') ? opr1+opr2 : opr1-opr2;
		*/
		/*논리 연산자 &&(and), ||(or)
		boolean a = (op == '+')&&((result = opr1+opr2)>0);
				a = (op == '+')||((result = opr1-opr2)>0);
		*/
		
		//사칙연산 여러버전
		
		/* if else if 구문
		if (op =='+') {result = opr1 + opr2;
			
		} else if (op =='-'){ result = opr1 - opr2;

		} else if (op =='*') { result = opr1 * opr2;
			
		} else if (op =='/') { result = opr1 / opr2;
			
		}
		*/
		
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
		
		/* 삼항 연산자
		result = (op=='+')? opr1 + opr2 : ((op=='-')? opr1-opr2 :((op == '*')? opr1 * opr2 :((op == '/')? opr1 / opr2 : result)));
		*/
		/* 논리연산 구문
		 * boolean a = (op == '+')&&((result= opr1 + opr2)>0)
				||((op=='-')&&((result = opr1 -opr2)>0))
				||((op=='*')&&((result = opr1 *opr2)>0))
				||((op=='/')&&((result = opr1 /opr2)>0));
		*/
		
		System.out.println(""+opr1+op+opr2+"="+result);
		
	}

}
