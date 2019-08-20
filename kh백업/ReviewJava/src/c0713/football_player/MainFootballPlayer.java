package c0713.football_player;

public class MainFootballPlayer {

	public static void main(String[] args) {
		FootballPlayer fp1 = new FootballPlayer();
		fp1.setName("Kim");
		fp1.setUniformNumber("7");
		fp1.setTeamName("Real Madrid");
		fp1.setSpeed(5);
		fp1.setTech(5);
		fp1.printInfo();
		
		System.out.println();
		
		FootballPlayer fp2 = new FootballPlayer("Park", "¸ÇÀ¯");
		fp2.setUniformNumber("15");
		fp2.setSpeed(4);
		fp2.setTech(3);
		fp2.printInfo();
		
		System.out.println();
		
		FootballPlayer fp3 = new FootballPlayer("Lee", "19", "Barcelona", 4, 5);
		fp3.printInfo();
		
	}

}
