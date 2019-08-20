package class10_class.ep01_calssdesign.movie;

public class MainMovie {

	public static void main(String[] args) {

		// Object 1
		Movie m1 = new Movie();
		m1.setTitle("Star Wars : The Force Awakens"); // 제목
		m1.setCategory("SF"); // 카테고리
		m1.setDirector("J.J. 에이브럼스"); // 감독
		m1.setRunningTime(135); // 상영시간
		m1.printInfo();

		// Object 2
		Movie m2 = new Movie();
		m2.setTitle("블랙 팬서");
		m2.setCategory("액션");
		m2.setDirector("라이언 쿠글러");
		m2.setRunningTime(135);
		System.out.println();
		m2.printInfo();
	}

}
