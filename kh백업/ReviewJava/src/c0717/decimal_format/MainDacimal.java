package c0717.decimal_format;

import java.text.DecimalFormat;

public class MainDacimal {

	public static void main(String[] args) {
		//DecimalFormat
		
		// 정수 3자리마다 컴마를 찍는다.
		System.out.println("--------정수--------");
		
		DecimalFormat df1 = new DecimalFormat("#,###");
		
		int intValue = 1000000;
		String result1 = df1.format(intValue);
		System.out.println("원본=" + intValue + " 결과 =" + result1);
		
		long longValue = 5000000000000L;
		String result2 = df1.format(longValue);
		System.out.println("원본=" + longValue + " 결과 =" + result2);
		
		// 소수점 첫째자리 까지만 살린다.
		DecimalFormat df2 = new DecimalFormat("#.#");
		
		float floatValue = 1000.235F;
		String result3 = df2.format(floatValue);
		System.out.println("원본=" + floatValue + " 결과 =" + result3);
		
		// 소수점 셋째자리 까지만 살린다.
		DecimalFormat df4 = new DecimalFormat("#.###");
		
		float floatValue4 = 1000.235F;
		String result4 = df4.format(floatValue4);
		System.out.println("원본=" + floatValue4 + " 결과 =" + result4);
	}

}
