package improtant;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainGregorianCalendar {

	public static void main(String[] args) {
		GregorianCalendar c = new GregorianCalendar();
		
		int yearInt = c.get(Calendar.YEAR);
		int monthInt = c.get(Calendar.MONTH); // ��ǻ�ͻ� ���� 0~11 �� �Ǿ�����
		int dateInt = c.get(Calendar.DATE);
		int hourInt = c.get(Calendar.HOUR_OF_DAY);
		int minuteInt = c.get(Calendar.MINUTE);
		int secondInt = c.get(Calendar.SECOND);
		
		System.out.println("�� = [" + yearInt + "]");
		if (monthInt < 10) {
			System.out.println("�� = [" + "0" + (monthInt + 1) + "]");
		}
//		System.out.println("�� = [" + (monthInt + 1) + "]");
		System.out.println("�� = [" + dateInt + "]");
		System.out.println("�� = [" + hourInt + "]");
		System.out.println("�� = [" + minuteInt + "]");
		System.out.println("�� = [" + secondInt + "]");
		
		// 01��, 02��, 03�� .... 09���� ǥ���ϰ� ������
		if (monthInt < 10) {
			System.out.println("�� = [" + "0" + (monthInt + 1) + "]");
		}
	
	}

}
