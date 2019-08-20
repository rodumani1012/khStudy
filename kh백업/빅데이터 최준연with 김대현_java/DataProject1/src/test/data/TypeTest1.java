package test.data;
/**
 * 
 * @author ���ؿ�
 * ���� : 
 * 1. ������ �⺻���� int Ÿ������ byte�� ������ �� ĳ���������� ������ ������ �����.
 * 2. �⺻���� double�� ��ȯ�Ͽ� �����ϰ� �ٽ� float������ ��ȯ�ǹǷ� ������ �߻����� �ʴ´�.
 * 3. �׳� String�� new String�� ���̴� ��ü�� �����ϴ��� ���ϴ����� ���̷� �����Ͱ��� �ܼ��� ������(==)�� ���ϰ� �Ǹ�
 * 	    �ּҰ��� �����͸� �ν��Ͽ� �̸� �ٸ��� ���� .equals�� ����ϸ� �ּҰ��� �ƴ� ������ �����͸��� ���ϰ� �ǹǷ� ���ٴ� ����� ���´�.
 * 4. ~ �� 0�� 1��, 1�� 0���� �ٲٴ� ��Ʈ������.
 * 5. ��Ʈ�� ĳ���� �� ���� ����� ������ ���� �� ��Ʈ�� ĳ������ ����� ���ϸ� ���� 8�� 9�� ���´�.
 */
public class TypeTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 21; //������ �� ���� �����ϸ� byte������ ����.
		byte b2 = 2;
		byte b3 = (byte) (b + b2);
//		short s = 21478364;
		int i = 21478364;
		long l = 21478364;
		float f = 0.12345F;
		float f2 = 0.9876F;
		float result = f + f2; //�⺻���� double�� ��ȯ�Ͽ� �����ϰ� �ٽ� float������ ��ȯ�ȴ�.
		System.out.println(result);
		
		String s = "acbd";
		String s1 = new String("efg");
		String s2 = s + s1;
		String s3 = new String(s2);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		
		if (s2 == s3) { // ������ ������ ���� ���ϴ� ���� �ƴ� �ڽ��� ���α��� ������ ������ �ٸ��ٰ� ������ ���̴�.
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		if (s2.equals(s3)) { // �����ϰ� �ڽ� �ȿ� ����ִ� �����Ͱ��� ���ϴ� ���̱� ������ ���ٰ� ������ ���̴�.
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		byte by1 = 3;
		by1 = (byte) -by1;
		int ii = -by1;
		byte by2 = 4;
		byte by3 = (byte) (by1 + by2);
		by3 = (byte) (by3 + 1);
		by3++; //by3 = by3 + 1;
		
		l = -1;
		l = ~l;
		System.out.println(l);
		
		double d1 = 3.5;
		double d2 = 5.5;
		int iResult = (int) d1 + (int)d2;
		System.out.println(iResult);
		iResult = (int) (d1 + d2);
		System.out.println(iResult);
		
//		int[] iArray = {3}; //���� 3�� �ִ� ��
		int[] iArray = new int[3]; //3�ڸ��� �ִ� ��
		Object o = iArray; //�迭������ Object������ �� ��ȯ
		
		
	}

}
