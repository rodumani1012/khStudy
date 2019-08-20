package test.date;
/**
 * 
 * @author 최준연
 *일정관리 프로그램 일부
 *1. 날짜를 표현할 객체 만들기
 *-----------------------
 *절차
 *1. 오늘의 날짜 : 서기 2018년 7월 4일 수요일 (음력 ?월 ?일, 마야달력....) -> 2018년 7월 4일 수요일 : 모델링
 *2. 연, 월, 일 -> 변수
 *3. ....함수 (적절한 함수 설정)
 *4. syso ("2018년 7월 4일");
 *5. syso (연도 + "년" + 월 + "월" + 일 + "일");
 *6. 변수를 -> 영어로 : year, month, day
 *7. 데이터 타입 :      int , int , int
 *8. coding .....
 *8-1 year, month, day를 선언하고 초기화한다.
 *8-2 오늘 날짜의 해당 값 -> 각 변수에 대입한다.
 *8-2-1 2018/7/4 => year = 2018; month = 7; day = 4;
 *8-3 해당 변수를 출력한다.
 *8-3-1 syso(year + "년" + month + "월" + day + "일");
 */
public class TestDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		 year, month, day를 선언하고 초기화한다.
//		 오늘 날짜의 해당 값 -> 각 변수에 대입한다.
//		 2018/7/4 => year = 2018; month = 7; day = 4;
//		  해당 변수를 출력한다.
//		 syso(year + "년" + month + "월" + day + "일");
		int year = 2018, month = 1, day = 1;
		year = 2018;  month = 7; day = 4;
		System.out.println(year + "년 " + month + "월 " + day + "일");
		

		int [] date = new int[args.length];
		date[0] = Integer.parseInt(args[0]);
		date[1] = Integer.parseInt(args[1]);
		date[2] = Integer.parseInt(args[2]);
		System.out.println(date[0] + "년 " + date[1] + "월 " + date[2] + "일");
		// 추상화 작업이 안되어 있으면 변수가 무수히 많을때 사람이 각각의 의미를 기억할 수 없음
		// 1. 추상화 작업 : 날짜를 Date 클래스 선언
	      // myBrithDay, moterBirthDay, fatherBirthDay.....
		// 2. 객체만들기 : 내생일 객체를 만들어 내생일 변수에 대입
		   Date myBirthDay = new Date();
		   myBirthDay.print();
		   Date motherBirthDay = new Date();
		   motherBirthDay.print();
		   
		   
	}

}
