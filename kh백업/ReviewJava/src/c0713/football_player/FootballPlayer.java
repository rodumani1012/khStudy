package c0713.football_player;

public class FootballPlayer {
	private String name, uniformNumber, teamName;
	private int speed, tech;
	
	public FootballPlayer() {
		
	}
	
	public FootballPlayer(String name, String teamName) {
		this.name = name;
		this.teamName = teamName;
	}
	
	public FootballPlayer(String name, String unitformNumber, String teamName, int speed, int tech) {
		this.name = name;
		this.uniformNumber = unitformNumber;
		this.teamName = teamName;
		this.speed = speed;
		this.tech = tech;
	}

	public String getName() {
		return name;
	}
	public String getUniformNumber() {
		return uniformNumber;
	}
	public String getTeamName() {
		return teamName;
	}
	public int getSpeed() {
		return speed;
	}
	public int getTech() {
		return tech;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setUniformNumber(String uniformNumber) {
		this.uniformNumber = uniformNumber;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void setTech(int tech) {
		this.tech = tech;
	}
	public void printInfo() {
		System.out.println("FootballPlayer Information -----------------------------------------------");
		System.out.print("Name = [" + name + "]");
		System.out.print("\tUniformNumber = [" + uniformNumber + "]");
		System.out.print("\tTeamName = [" + teamName + "]");
		System.out.print("\tSpeed = [" + speed + "]");
		System.out.println("\tTech = [" + tech + "]");
		
		
	}

	

	
}
