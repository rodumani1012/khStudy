package c0713.movie2;

public class MainMovie {

	public static void main(String[] args) {
		String title = "Star Wars : The Force Awakens";
		String category = "SF";
		String director = "J.J 에이브럼스";
		int runningTime = 135;
		String actor = "해리슨 포드";
		Movie m1 = new Movie(title, category, director, runningTime, actor);
		m1.printInfo();
		
		System.out.println();
		
		String actorName = "해리슨 포드";
		String actorGender = "남자";
		String actorBrithdate = "1942.07.13";
		String actorNationality = "미국";
		Actor actor1 = new Actor(actorName, actorGender, actorBrithdate, actorNationality);
		actor1.printInfo();
		
		String title1 = "Star Wars : The Force Awakens";
		String category1 = "SF";
		String director1 = "J.J 에이브럼스";
		int runningTime1 = 135;
		MovieNew m2 = new MovieNew(title1, category1, director1, runningTime1, actor1);
		m2.printInfo();
	}

}
