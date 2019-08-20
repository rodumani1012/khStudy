package c0716.movie;


public class MainMovie {

	public static void main(String[] args) {
		String actorName = "해리슨 포드";
		String actorGender = "남자";
		String actorBrithdate = "1942.07.13";
		String actorNationality = "미국";
		Actor actor = new Actor(actorName, actorGender, actorBrithdate, actorNationality);
		actor.printInfo();
		
		String title = "Star Wars : The Force Awakens";
		String category = "SF";
		String director = "J.J 에이브럼스";
		int runningTime = 135;
		Movie m1 = new Movie(title, category, director, runningTime, actor);
		m1.printInfo();
		

	}

}
