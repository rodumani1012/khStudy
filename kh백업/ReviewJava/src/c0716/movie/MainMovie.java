package c0716.movie;


public class MainMovie {

	public static void main(String[] args) {
		String actorName = "�ظ��� ����";
		String actorGender = "����";
		String actorBrithdate = "1942.07.13";
		String actorNationality = "�̱�";
		Actor actor = new Actor(actorName, actorGender, actorBrithdate, actorNationality);
		actor.printInfo();
		
		String title = "Star Wars : The Force Awakens";
		String category = "SF";
		String director = "J.J ���̺귳��";
		int runningTime = 135;
		Movie m1 = new Movie(title, category, director, runningTime, actor);
		m1.printInfo();
		

	}

}
