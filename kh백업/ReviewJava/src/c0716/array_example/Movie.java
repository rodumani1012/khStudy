package c0716.array_example;

public class Movie {
	private String title, category, director;
	private int runningTime;
	
		public Movie() {
	}



		public Movie(String title, String category, String director, int runningTime) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.runningTime = runningTime;
	}



		//Method : getter & setter
		public String getTitle() {
		return title;
	}



	public String getCategory() {
		return category;
	}



	public String getDirector() {
		return director;
	}



	public int getRunningTime() {
		return runningTime;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public void setDirector(String director) {
		this.director = director;
	}



	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}



	public void printInfo() {
		System.out.println("---------------------------------------------------------------");
		System.out.print("title=[" + title + "]");
		System.out.print("\tcategory=[" + category + "]");
		System.out.print("\tdirector=[" + director + "]");
		System.out.print("\trunningTime=[" + runningTime + "]");
		System.out.println("---------------------------------------------------------------");
	}

}
