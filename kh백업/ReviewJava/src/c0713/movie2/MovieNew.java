package c0713.movie2;

public class MovieNew {
	private String title1, category1, director1;
	private int runningTime1;
	private Actor actor1;
	
	public MovieNew(String title1, String category1, String director1, int runningTime1, Actor actor1) {
		this.title1 = title1;
		this.category1 = category1;
		this.director1 = director1;
		this.runningTime1 = runningTime1;
		this.actor1 = actor1;
	}

	public String getTitle1() {
		return title1;
	}

	public String getCategory1() {
		return category1;
	}

	public String getDirector1() {
		return director1;
	}

	public int getRunningTime1() {
		return runningTime1;
	}

	public Actor getActor1() {
		return actor1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public void setDirector1(String director1) {
		this.director1 = director1;
	}

	public void setRunningTime1(int runningTime1) {
		this.runningTime1 = runningTime1;
	}

	public void setActor1(Actor actor1) {
		this.actor1 = actor1;
	}

	public void printInfo() {
		System.out.println("---------------------------------------------------------------");
		System.out.print("title=[" + title1 + "]");
		System.out.print("\tcategory=[" + category1 + "]");
		System.out.print("\tdirector=[" + director1 + "]");
		System.out.println("\trunningTime=[" + runningTime1 + "]");
		System.out.println("---------------------------------------------------------------");
		actor1.printInfo();
		
	}
	
	
	
}
