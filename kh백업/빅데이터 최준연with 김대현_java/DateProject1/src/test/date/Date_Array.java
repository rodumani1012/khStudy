package test.date;
/**
 * 
 * @author 최준연
 * 설명 :  
 * 추상화
 * 1. 어떤 data가 필요해? => 연, 월, 일
 * 2. 이런 데이터들을 뭐라고 부룰까? => 날짜(Date) 라고 묶자
 * 2-1 class Date {
 * 		int	 year = 2018;
 * 		int	 month= 7;
 * 		int	 day  = 6;
 *	   }
 *
 * 은닉화
 * 1. data를 숨기기 위해 => private
 * 2. getter/setter
 * 3. 생성자 <- 객체 초기화
 * 3-1 상속된 data는  => inheritance method 또는 super()
 * 4. toString() 
 */
public class Date_Array {
//member variable 선언 : 자동으로 초기화 되므로 초기값을 선언안해도 된다.
	private int year; //초기화를 시켜줘도 되고 안시켜줘도 된다.  ex) int year = 2018;
	private int month;
	private int day;
	private int[] lastDayOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public Date_Array() {
		year = 1900; month = 1; day = 1;
	}
	public Date_Array(int year, int month, int day) {
		// TODO Auto-generated constructor stub
		this.setYear(year);
		this.setMonth(month);
		this.setDay(day);
	}
	@Override
	public String toString() {
		return year + "년 " + month + "월 " + day + "일";
	}
	//method 정의
	public void print() {
		System.out.println(this);
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public void setYear(int year) {
		this.year = year;
		setDay(day);
	}
	/**
	 * 설명 : 날짜 중 월에 해당하며 1 ~ 12 범위의 값을 가진다.
	 * 		1미만이나 12 초과의 값이 들어올 경우 1 또는 12의 값으로 수정한다.
	 * @param month : 1 <= month <= 12이하의 값은 정상
	 * 				   나머지는 작을 경우 1로, 클 경우는 12로 변경
	 */
	public void setMonth(int month) {
		if (month < 1) {
			month = 1;
		} else if (month > 12) {
			month = 12;
		}
		this.month = month;
		setDay(day);
//		this.month = (this.month<=1)? month=1:((this.month>=12)? month=12: month);
			
		
	}

	public void setDay(int day) {
		checkLunar();
		if (day < 1) {
			day = 1;
		} else if (day > lastDayOfMonth[month-1]) {
			day = lastDayOfMonth[month-1];  // -1을 하는 이유는 사람은 1월 2월 3월... 이지만 컴퓨터는 0월 1월 2월 .. 순이기 때문이다
											// 즉 사람에게 1월은 컴퓨터에게 2월을 보여주고 있는 셈이다.
		}
		this.day = day;
	}
	private void checkLunar() {
		//방법 1. if else
//		if (year % 4 == 0) {
//			if (year % 100 == 0) {
//				if (year % 400 == 0) { //400으로 나눠짐
//					lastDayOfMonth[1] = 29;
//				}else //연도가 100으로 나눠지지만 400으로는 나눠지지 않음
//					lastDayOfMonth[1] = 28;
//			}else // 연도가 4로 나눠지지만 100으로 나눠지지 않음
//				lastDayOfMonth[1] = 29;
//		}else // 연도가 4로 나눠지지 않음
//			lastDayOfMonth[1] = 28;
		
		//방법 2. if else와 논리연산
		if ((year%4 == 0)&&(year%100 != 0)||(year%400 ==0))
			lastDayOfMonth[1] = 29;
		else //else if ((year%4 != 0) || (year%100 == 0)&&(year%400 != 0))
			lastDayOfMonth[1] = 28;
		
		//가장 좋은 방법 3. 삼항연산자
		lastDayOfMonth[1] = ((year%4 == 0 )&&(year%100 != 0)||(year%400 == 0)) ? 29 : 28;
		
		
	}
}
