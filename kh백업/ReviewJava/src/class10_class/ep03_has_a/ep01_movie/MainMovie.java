package class10_class.ep03_has_a.ep01_movie;

public class MainMovie {

	public static void main(String[] args) {

		String title = "Star Wars : The Force Awakens";
		String category = "SF";
		String director = "J.J. 에이브럼스";
		int runningTime = 135;
		String actor = "해리슨 포드";
		Movie m1 = new Movie(title, category, director, runningTime, actor);
		m1.printInfo();
	}

}
