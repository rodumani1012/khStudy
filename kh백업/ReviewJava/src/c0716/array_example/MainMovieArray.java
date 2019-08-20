package c0716.array_example;

public class MainMovieArray {

	public static void main(String[] args) {
//		Movie m1 = new Movie("Starwars:깨어난포스", "SF", "J.J.에이브럼스", 135);
//		m1.printInfo();
//		Movie m2 = new Movie("007 스펙터", "액션", "샘 멘데스", 148);
//		m2.printInfo(); 
		
		Movie[] movieArray;
		movieArray = new Movie[2];
		movieArray[0] = new Movie("Starwars:깨어난포스", "SF", "J.J.에이브럼스", 135);
		movieArray[1] = new Movie("007 스펙터", "액션", "샘 멘데스", 148);
		
		for (int i = 0; i < movieArray.length; i++) {
			movieArray[i].printInfo();
		}
	}

}
