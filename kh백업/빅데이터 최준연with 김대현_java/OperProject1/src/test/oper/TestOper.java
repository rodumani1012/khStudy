package test.oper;
/**
 * 
 * @author 최준연
 * 1. 두가지 변수를 선언하고 숫자를 입력한다.
 * 2. 사칙연산 기호 중 한가지를 입력한다.
 * 3. 이를 계산한 결과를 출력한다.
 *
 */
public class TestOper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opr1 = 5, opr2 = 2; char op = '-';
		int result = 0;
		/*
		 * if else 구문
		if (op == '+') { result = opr1 + opr2;
			
		} else { result = opr1 - opr2;

		}
		*/
		/*삼항 연산자
		result = (op=='+') ? opr1+opr2 : opr1-opr2;
		*/
		//논리 연산자 &&(and), ||(or)
		boolean a = (op == '+')&&((result = opr1+opr2)>0);
				a = (op == '+')||((result = opr1-opr2)>0);
		
		System.out.println(""+opr1+op+opr2+"="+result);
		
	}

}
