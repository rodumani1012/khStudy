package test.data;
/**
 * 
 * @author ���ؿ�
 ������Ÿ���׽�Ʈ
 ���� : �⺻�� ������Ÿ�԰� String�� �׽�Ʈ�غ���.
 ���� : �� ������ Ÿ�Ժ��� ������ ����� �⺻ ���� �� ȭ�� ����� �ϴ� ���α׷�
 ���� : 
 1. ������(������) - int:32, long:64, short:16
 1-1 intŸ�� ���� i�� �����ϰ� 5��� ���� �����Ѵ�.
 1-2 longŸ�� ���� l�� �����ϰ� 50���� ���� �����Ѵ�.
 1-3 shortŸ�� ���� s�� �����ϰ� 5�̶�� ���� �����Ѵ�.
 2. �Ǽ��� - double:64, float:32
 2-1 doubleŸ�� ���� d�� �����ϰ� 3.141592��� ���� �����Ѵ�.
 2-2 floatŸ�� ���� f�� �����ϰ� 3.141592�̶�� ���� �����Ѵ�.
 3. ���� - boolean:1 = true/false
 3-1 booleanŸ�� ���� b�� �����ϰ� true��� ���� �����Ѵ�.
 4. ������ - char:16, ���ڿ� - String(? : ������)
 4-1 charŸ�� ���� c�� �����ϰ� 'A'�̶�� ���� �����Ѵ�.
 4-2 StringŸ�� ���� str�� �����ϰ� "Hello"��� ���� �����Ѵ�.
 5. �����ͱ⺻�� - byte:8
 5-1 byteŸ�� ���� by�� �����ϰ� 1�̶�� ���� �����Ѵ�.
 5-2 byte[]Ÿ�� ���� buffer�� �����ϰ� str.getBytes()��� ���� �����Ѵ�. 
 
 0. �� ��ȣ�� �������� syso�� ����Ѵ�
 *
 */
public class TestData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // intŸ�� ���� i�� �����ϰ� 5��� ���� �����Ѵ�.
		int i; i = 5;
		System.out.println("int : " + i);
		// longŸ�� ���� l�� �����ϰ� 50���� ���� �����Ѵ�.
		long l; l = 5000000000L;
		System.out.println("long : " + l);
//		 shortŸ�� ���� s�� �����ϰ� 5�̶�� ���� �����Ѵ�.
		short s; s=5;
		System.out.println("short : " + s);
//		 doubleŸ�� ���� d�� �����ϰ� 3.141592��� ���� �����Ѵ�.
		double d; d=3.141592;
		System.out.println("double : " + d);
//		 floatŸ�� ���� f�� �����ϰ� 3.141592�̶�� ���� �����Ѵ�.
		float f; f=3.141592F;	//f=(float) 3.141592;
		System.out.println("float : "+f);
//		 booleanŸ�� ���� b�� �����ϰ� true��� ���� �����Ѵ�.
		boolean b; b=true;
		System.out.println("boolean : " + b);
//		 charŸ�� ���� c�� �����ϰ� 'A'�̶�� ���� �����Ѵ�.
		char c; c = 'A';
		System.out.println("char : "+c);
//		 StringŸ�� ���� str�� �����ϰ� "Hello"��� ���� �����Ѵ�.
		String str; str="Hello";
		System.out.println("String : " + str);
//		 byteŸ�� ���� by�� �����ϰ� 1�̶�� ���� �����Ѵ�.
		byte by; by=1;
		System.out.println("byte : " +by);
//		 byte[]Ÿ�� ���� buffer�� �����ϰ� str.getBytes()��� ���� �����Ѵ�. 
		byte[] buffer; buffer = str.getBytes();
		System.out.println("byte[] : " + buffer);
//		 0. �� ��ȣ�� �������� syso�� ����Ѵ�
		
		//long l = l + 5;
		l = l + 5; //�Ǵ� l = l + i;
		i = (int) (i+l);
		System.out.println("i���� = " + i); // -> 50�� + 5 = 50�� 5�� �����ϰ� int i�� �־ ��� �����Ͱ� �ջ��.
		i = i + s; s = (short) (s + i);
				   s = (short) (s + 1);
				   s = (short) (s+s);
				   by = (byte) (by+by);
				   c = (char) (c + c); //short byte char�� ������ �� int�� ��ȯ�Ǳ� ������ ��Ģ�� ��߳��Ƿ� c = c+c; �� ������ ����.
				   
	   // ����(*, <<)
	   i = 1000000000; i = i*i;
	   System.out.println("10�� * 10�� = " +i);
	   
	   i = 1; i=i<<32; System.out.println("1<<32 -> "+i);
	   		  i=i<<31; System.out.println("1<<31 -> "+i);
	   		  i<<=1; System.out.println("1<<31<<1 -> "+i);
	   		  
	   i = 1; i<<=1; //*2�� ���
	   System.out.println("1<<1 -> "+i);
	   i = 1; i<<=10;
	   System.out.println("1<<10 -> "+i);
	   
	   i = -1; i=i>>33;
	   System.out.println("-1>> 33 -> "+i);
	   
	   i = 1; i=i<<31; System.out.println("1<<31 -> " +i);
	   		  i=i>>31; System.out.println("1<<31>>31 -> " +i);
	   
	   i = 0; int i2 = -1;
	   
	   //������ ����
	   int a = 4; int a2 = 2;
	   if((a>a2)||((a2=a)==a));
	   System.out.print("a�� �� = " + a);
	   System.out.println("\t a2�� �� = "+ a2);
	   
	   // ���� ������ : ~�� ������ 
//  	    ���̸� ���� ������� �����ϰ� 
//  	   �����̸� ���� ������� �����Ѵ�.
	   int result = (false) ? 1 : 2;
	   result = (a>a2)? a : a2;
	   System.out.println("result = " +result);
	   
	   
	   /*
	    * ���ϱ⻩��
		���� : ���� �Ǵ� ���� ���α׷�
		���� : �ΰ��� ������ �Ѱ��� �����ȣ�� �Է¹޾�(�����ؼ� �ƹ� ���̳� �����϶�)
		       �����ȣ�� '+'��� ���ϱ� ������ �� ������� ȭ�鿡 ����Ѵ�.
		       �����ȣ�� '-'��� ���� ������ �� ������� ȭ�鿡 ����Ѵ�.
		���� : 
		1. �ΰ��� ������ �Ѱ��� ���ڸ� �Է¹޴´�.
		2. ��������� �����Ѵ�.
		3. �����ȣ�� '+'�� ������ �μ��� + �����Ͽ� ��������� �ִ´�(�����Ѵ�)
		   �׷��� ������ - �����Ͽ� ��������� �ִ´�.
		4. ��������� ����Ѵ�.
	    */
	   int x, y; x=1; y=2;
	   char op1; op1 = '+';
	   int result1;
	  /* if (op1 == '+') {result1 = x + y;
		
	} else {result1 = x-y;

	}*/ //if else ����
	   result1 = (op1=='+') ? x+y : x-y; //���� ������ ����
	   System.out.println("����� = " + result1);

	   
	   int q, w; q=2; w=3;
	   char op2; op2 = '+';
	   int result2, result3;  result2 = q + w;   result3 = q - w;
	   if (op2=='+'||op2=='-');
	   System.out.println("���� �� = " +result2);
	   System.out.println("�� �� = " + result3);
	   
		
	}
}











