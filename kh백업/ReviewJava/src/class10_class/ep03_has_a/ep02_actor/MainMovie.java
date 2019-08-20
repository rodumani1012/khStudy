package class10_class.ep03_has_a.ep02_actor;

public class MainMovie {

	public static void main(String[] args) {

		// Actor
		String actorName = "해리슨 포드";
		String actorGender = "남자";
		String actorBirthdate = "1942.07.13";
		String actorNationality = "미국";

		Actor actor = new Actor(actorName, actorGender, actorBirthdate,
				actorNationality);
		actor.printInfo();

		// MovieNew
		String title = "Star Wars : The Force Awakens";
		String category = "SF";
		String director = "J.J. 에이브럼스";
		int runningTime = 135;

		MovieNew m1 = new MovieNew(title, category, director, runningTime, actor);
		m1.printInfo();
	}

}
