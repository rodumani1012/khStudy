package c0717.decimal_format;

import java.text.DecimalFormat;

public class MainDacimal {

	public static void main(String[] args) {
		//DecimalFormat
		
		// ���� 3�ڸ����� �ĸ��� ��´�.
		System.out.println("--------����--------");
		
		DecimalFormat df1 = new DecimalFormat("#,###");
		
		int intValue = 1000000;
		String result1 = df1.format(intValue);
		System.out.println("����=" + intValue + " ��� =" + result1);
		
		long longValue = 5000000000000L;
		String result2 = df1.format(longValue);
		System.out.println("����=" + longValue + " ��� =" + result2);
		
		// �Ҽ��� ù°�ڸ� ������ �츰��.
		DecimalFormat df2 = new DecimalFormat("#.#");
		
		float floatValue = 1000.235F;
		String result3 = df2.format(floatValue);
		System.out.println("����=" + floatValue + " ��� =" + result3);
		
		// �Ҽ��� ��°�ڸ� ������ �츰��.
		DecimalFormat df4 = new DecimalFormat("#.###");
		
		float floatValue4 = 1000.235F;
		String result4 = df4.format(floatValue4);
		System.out.println("����=" + floatValue4 + " ��� =" + result4);
	}

}
