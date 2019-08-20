package class10_class.ep02_constructor.footballplayer;

public class FootballPlayer {

	// Variable
	private String name; // 이름
	private String teamName; // 팀명
	private String uniformNumber; // 유니폼 번호
	private int speed; // 속도(범위 : 1~5)
	private int tech; // 기술(범위 : 1~5)

	// Constructor
	public FootballPlayer() {

	}

	public FootballPlayer(String name, String teamName) {
		this.name = name;
		this.teamName = teamName;
	}

	public FootballPlayer(String name, String teamName, String uniformNumber,
			int speed, int tech) {
		this.name = name;
		this.teamName = teamName;
		this.uniformNumber = uniformNumber;
		this.speed = speed;
		this.tech = tech;
	}

	// Method
	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	public void setUniformNumber(String number) {
		uniformNumber = number;
	}

	public String getUniformNumber() {
		return uniformNumber;
	}

	public void setTeamName(String newTeamName) {
		teamName = newTeamName;
	}

	public String getTeamNamer() {
		return teamName;
	}

	public void setSpeed(int newSpeed) {
		this.speed = newSpeed;
	}

	public int getSpeed() {
		return speed;
	}

	public void setTech(int newTech) {
		tech = newTech;
	}

	public int getTech() {
		return tech;
	}

	public void printInfo() {
		System.out
				.println("FootballPlayer Information -----------------------------");
		System.out.print("Player Name=[" + name + "] ");
		System.out.print(" Team Name=[" + teamName + "] ");
		System.out.print(" Uniform Number=[" + uniformNumber + "] ");
		System.out.print(" Speed=[" + speed + "] ");
		System.out.println(" Tech=[" + tech + "] ");
	}

}
