package test.plus;
/**
 * 
 * @author ���ؿ�
 *	���ϱ� �������α׷�
	���� : �� ���� ���� ����� ȭ�� ���
	���� : �� ���� ���� ����� ȭ�� ���
	���� : 
	1. �μ��� �Է¹޴´�
	1-1 a, b;
	2. ��������� �����Ѵ�
	2-1 result;
	3. �μ��� + �����Ͽ� 2�� ��������� �ִ´�(�����Ѵ�)
	3-1 result = a + b;
	4. ��������� ����Ѵ�
	4-1 syso(result);
	
 */
public class TestPlus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int a=1, b=2; /* �Ǵ� int a=1;
							    int b=2;
								ó�� ���ٷ� �ۼ� ����*/
			int result; // ����
			result = a + b;
			System.out.println(a+"+"+b+ "\b" +"="+result);
			
			float c= 1.0f, d=2.0f;
			double result1;
			result1 = c + d;
			System.out.println(result1);
		 
	}

}
