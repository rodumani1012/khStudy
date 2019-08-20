package class10_class.ep02_constructor.footballplayer;

public class MainFootballPlayer {

	public static void main(String[] args) {

		// Object 1
		FootballPlayer fp1 = new FootballPlayer();
		fp1.setName("Kim");
		fp1.setUniformNumber("7");
		fp1.setTeamName("Real Madrid");
		fp1.setSpeed(5);
		fp1.setTech(5);
		fp1.printInfo();

		// Object 2
		FootballPlayer fp2 = new FootballPlayer("Part", "맨유");
		fp2.setUniformNumber("15");
		fp2.setSpeed(4);
		fp2.setTech(3);
		fp2.printInfo();

		// Object 3
		FootballPlayer fp3 = new FootballPlayer("Lee", "19", "Barcelona", 4, 5);
		fp3.printInfo();

	}

}
