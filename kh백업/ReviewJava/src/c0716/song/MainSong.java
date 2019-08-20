package c0716.song;

public class MainSong {

	public static void main(String[] args) {
		Singer singer = new Singer("아이유", "여자", "1993.07.11", "로엔");
		String name;
		String sex;
		String birthDate;
		String company;
				
		String title;
		String album;
		String composer;
		String lyricist;
		String releaseDate;
		Song s1 = new Song("밤편지", "밤편지", "김제회, 김희원","아이유", "20170324", singer);
		s1.printInfo();
		
		
		
	}

}
