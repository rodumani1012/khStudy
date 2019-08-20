package class10_class.ep02_constructor.movie;

public class MainMovie {

	public static void main(String[] args) {

		// Object 1
		Movie m1 = new Movie();
		m1.setTitle("Star Wars : The Force Awakens");
		m1.setCategory("SF");
		m1.setDirector("J.J. 에이브럼스");
		m1.setRunningTime(135);
		m1.printInfo();

		// Object 2
		Movie m2 = new Movie("SF", "아바타");
		m2.setDirector("제임스 카메론");
		m2.setRunningTime(162);
		m2.printInfo();

		// Object 3
		Movie m3 = new Movie("블랙 팬서", "액션", "라이언 쿠글러", 135);
		m3.printInfo();
	}

}
