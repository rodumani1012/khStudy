package c0716.song;

public class MainSong {

	public static void main(String[] args) {
		Singer singer = new Singer("������", "����", "1993.07.11", "�ο�");
		String name;
		String sex;
		String birthDate;
		String company;
				
		String title;
		String album;
		String composer;
		String lyricist;
		String releaseDate;
		Song s1 = new Song("������", "������", "����ȸ, �����","������", "20170324", singer);
		s1.printInfo();
		
		
		
	}

}
