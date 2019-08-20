package c0713.movie2;

public class Movie {
	private String title, category, director, actor;
	private int runningTime;
	
	public Movie(String title, String category, String director, int runningTime, String actor) {
		this.title = title;
		this.category = category;
		this.director = director;
		this.actor = actor;
		this.runningTime = runningTime;
	}

	public void printInfo() {
		System.out.println("---------------------------------------------------------------");
		System.out.print("title=[" + title + "]");
		System.out.print("\tcategory=[" + category + "]");
		System.out.print("\tdirector=[" + director + "]");
		System.out.print("\trunningTime=[" + runningTime + "]");
		System.out.println("\tactor=[" + actor + "]");
		System.out.println("---------------------------------------------------------------");
		
	}
	
	
}
