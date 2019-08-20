package class10_class.ep03_has_a.ep01_movie;

public class Movie {

	// Variable
	private String title; // 영화제목
	private String category; // 영화 카테고리
	private String director; // 감독
	private int runningTime; // 상영시간
	private String actor; // 배우

	// Constructor
	public Movie() {

	}

	public Movie(String category, String title) {
		this.category = category;
		this.title = title;
	}

	public Movie(String title, String category, String director,
			int runningTime, String actor) {
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

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public void printInfo() {
		System.out.println("Movie Information -----------------------------");
		System.out.print("\ttitle=[" + title + "] ");
		System.out.print(" category=[" + category + "] ");
		System.out.print(" director=[" + director + "] ");
		System.out.print(" runningTime=[" + runningTime + "](분)");
		System.out.println(" actor=[" + actor + "]");
	}

}
