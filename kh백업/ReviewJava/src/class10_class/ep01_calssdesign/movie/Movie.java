package class10_class.ep01_calssdesign.movie;

public class Movie {

	// Variable
	private String title; // 영화제목
	private String category; // 영화 카테고리
	private String director; // 감독
	private int runningTime; // 상영시간

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

	public void printInfo() {
		System.out.println("Movie Information -----------------------------");
		System.out.print("title=[" + title + "] ");
		System.out.print(" category=[" + category + "] ");
		System.out.print(" director=[" + director + "] ");
		System.out.println(" runningTime=[" + runningTime + "](분)");
	}

}