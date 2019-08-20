package class10_class.ep03_has_a.ep02_actor;

public class MovieNew {

	// Variable
	private String title; // 영화제목
	private String category; // 영화 카테고리
	private String director; // 감독
	private int runningTime; // 상영시간
	private Actor actor; // 배우

	// Constructor
	public MovieNew() {

	}

	public MovieNew(String category, String title) {
		this.category = category;
		this.title = title;
	}

	public MovieNew(String title, String category, String director,
			int runningTime, Actor actor) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.runningTime = runningTime;
		this.actor = actor;
	}

	// Method
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public void printInfo() {
		System.out.println("Movie Information -----------------------------");
		System.out.print("\ttitle=[" + title + "] ");
		System.out.print(" category=[" + category + "] ");
		System.out.print(" director=[" + director + "] ");
		System.out.println(" runningTime=[" + runningTime + "](분)");
		actor.printInfo();
	}

}
