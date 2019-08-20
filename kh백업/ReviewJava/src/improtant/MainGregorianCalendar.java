package improtant;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MainGregorianCalendar {

	public static void main(String[] args) {
		GregorianCalendar c = new GregorianCalendar();
		
		int yearInt = c.get(Calendar.YEAR);
		int monthInt = c.get(Calendar.MONTH); // 컴퓨터상 월은 0~11 로 되어있음
		int dateInt = c.get(Calendar.DATE);
		int hourInt = c.get(Calendar.HOUR_OF_DAY);
		int minuteInt = c.get(Calendar.MINUTE);
		int secondInt = c.get(Calendar.SECOND);
		
		System.out.println("년 = [" + yearInt + "]");
		if (monthInt < 10) {
			System.out.println("월 = [" + "0" + (monthInt + 1) + "]");
		}
//		System.out.println("월 = [" + (monthInt + 1) + "]");
		System.out.println("일 = [" + dateInt + "]");
		System.out.println("시 = [" + hourInt + "]");
		System.out.println("분 = [" + minuteInt + "]");
		System.out.println("초 = [" + secondInt + "]");
		
		// 01월, 02월, 03월 .... 09월로 표현하고 싶을때
		if (monthInt < 10) {
			System.out.println("월 = [" + "0" + (monthInt + 1) + "]");
		}
	
	}

}
