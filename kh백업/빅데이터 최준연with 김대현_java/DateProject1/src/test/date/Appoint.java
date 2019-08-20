package test.date;
/**
 * 
 * @author 최준연
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
public class Appoint extends Date {
	private int hour = 11; //시간
	private String place = "학교";//장소
	private String name = "고길동"; //만날 사람이름
	public Appoint() {
		super();
		hour = 11;
		place = "집";
		name = "어머니";
	}
	public Appoint(int year, int month, int day, int hour, String place, String name) {
		super(year, month, day);
		this.hour = hour;
		this.place = place;
		this.name = name;
	}
	public int getHour() {
		return hour;
	}
	public String getPlace() {
		return place;
	}
	public String getName() {
		return name;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "약속정보============\n"
				+ "[일자: " + super.toString()
				+ "]\n[시간 : " + hour + "시]\n[장소 : " + place + "]\n[대상 : " + name + "]"
				+ "\n=================";
				
	}
//	@Override
//	public void print() {
//		System.out.println(this.toString());
//	}
	
	
}
