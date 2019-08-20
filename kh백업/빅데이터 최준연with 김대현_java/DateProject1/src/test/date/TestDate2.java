package test.date;

import java.util.Random;

/**
 * 
 * @author 최준연
 *일정관리 프로그램 + 시간,장소,이름 추가
 *1. 날짜를 표현할 객체 만들기
 *-----------------------
 *절차
 *1. 오늘의 날짜 : 서기 2018년 7월 4일 수요일 (음력 ?월 ?일, 마야달력....) -> 2018년 7월 4일 수요일 : 모델링
 *2. 연, 월, 일 -> 변수
 *3. ....함수
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
public class TestDate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 추상화 작업이 안되어 있으면 변수가 무수히 많을때 사람이 각각의 의미를 기억할 수 없음
		// 1. 추상화 작업 : 날짜를 Date 클래스 선언
	      // myBrithDay, moterBirthDay, fatherBirthDay.....
		// 2. 객체만들기 : 내생일 객체를 만들어 내생일 변수에 대입
		   Date myBirthDay = new Date();
		   myBirthDay.setYear(1994);
		   myBirthDay.setMonth(10);
		   myBirthDay.setDay(12);
		   myBirthDay.print();
		   
		   // 외계인 생일...
		   Date motherBirthDay = new Date(2000, 1, 31);
//		   motherBirthDay.setYear(2018);
		   motherBirthDay.setMonth(2);
//		   motherBirthDay.setDay(-15);
		   motherBirthDay.print();
		   
		   Appoint myAppoint;
		   myAppoint = new Appoint();
		   myAppoint.print();
		   
		   Date[] d = new Date[2];
		   d[0] = new Date();
		   d[1] = new Appoint();
		   for (int i = 0; i < d.length; i++) {
			   d[i].print();
		   }		   
//		   약속시간이 궁금하다
//		   System.out.println(d[1].getHour());
//		   Appoint a = (Appoint) d[1];
//		   System.out.println(a.getHour());
		   Appoint a1;
		   for (Date date : d) {
			   //instanceof : Runtime type check 논리연산자
			   if (date instanceof Appoint) {
				   a1 = (Appoint) date;
				   System.out.println(a1.getHour());
			}
		}
		   
		   Date[] appoint = new Date[5];
		   Random ran = new Random();
		   for (int i = 0; i < d.length; i++) {
			   int random = ran.nextInt();
			   // int random = (int) (Math.random()*2); //*2, +2, (+2)*100
			   // API에서 random수를 찾는 method를 찾아 어떤 때는 81번 라인을
			   // 어떤 때는 83번 라인을 수행토록 하세요.
			   // 힌트 : 이름을 알 경우 API에서 Index를 찾는다.
			   boolean condition = (random % 2) == 0; 
			   if (condition) {
				   d[i] = new Date();
			} else {
				   d[i] = new Appoint();
			}
		
		   }		   
		   Appoint a2;
		   for (Date date : d) {
			   //instanceof : Runtime type check 논리연산자
			   if (date instanceof Appoint) {
				   a2 = (Appoint) date;
				   System.out.println(a2.getHour());
			}
		}
	}

}
