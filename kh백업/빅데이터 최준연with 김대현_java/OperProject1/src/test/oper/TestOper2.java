package test.oper;

import java.io.IOException;

/**
 * 
 * @author ���ؿ�
 * ���� : 
 * 1. Arguments�� ���� 2��, ������ 1���� �ִ´�. 
 * 1-1 for������ Arguments�� �Է°��� ����غ���
 * 2. Arguments�� int�� �ν��ϱ� ���� x = Integer.parseInt(); �� ����Ѵ�.
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

//		Integer i = new Integer(opr1); //Wrapper Ŭ����
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
		 * if else ����
		if (op == '+') { result = opr1 + opr2;
			
		} else { result = opr1 - opr2;

		}
		*/
		/*���� ������
		result = (op=='+') ? opr1+opr2 : opr1-opr2;
		*/
		/*�� ������ &&(and), ||(or)
		boolean a = (op == '+')&&((result = opr1+opr2)>0);
				a = (op == '+')||((result = opr1-opr2)>0);
		*/
		
		//��Ģ���� ��������
		
		/* if else if ����
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
		
		/* ���� ������
		result = (op=='+')? opr1 + opr2 : ((op=='-')? opr1-opr2 :((op == '*')? opr1 * opr2 :((op == '/')? opr1 / opr2 : result)));
		*/
		/* ������ ����
		 * boolean a = (op == '+')&&((result= opr1 + opr2)>0)
				||((op=='-')&&((result = opr1 -opr2)>0))
				||((op=='*')&&((result = opr1 *opr2)>0))
				||((op=='/')&&((result = opr1 /opr2)>0));
		*/
		
		System.out.println(""+opr1+op+opr2+"="+result);
		
	}

}
