package test.oper;
/**
 * 
 * @author ���ؿ�
 * 1. �ΰ��� ������ �����ϰ� ���ڸ� �Է��Ѵ�.
 * 2. ��Ģ���� ��ȣ �� �Ѱ����� �Է��Ѵ�.
 * 3. �̸� ����� ����� ����Ѵ�.
 *
 */
public class TestOper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opr1 = 5, opr2 = 2; char op = '-';
		int result = 0;
		/*
		 * if else ����
		if (op == '+') { result = opr1 + opr2;
			
		} else { result = opr1 - opr2;

		}
		*/
		/*���� ������
		result = (op=='+') ? opr1+opr2 : opr1-opr2;
		*/
		//�� ������ &&(and), ||(or)
		boolean a = (op == '+')&&((result = opr1+opr2)>0);
				a = (op == '+')||((result = opr1-opr2)>0);
		
		System.out.println(""+opr1+op+opr2+"="+result);
		
	}

}
