package c0716.song;

public class Song {
	private String title, album, composer, lyricist, releaseDate;
	private Singer singer;


	public Song() {

	}
	
	public Song(String title, String album, String composer, String lyricist, String releaseDate, Singer singer) {
		this.title = title;
		this.album = album;
		this.composer = composer;
		this.lyricist = lyricist;
		this.releaseDate = releaseDate;
		this.singer = singer;
	}


	public String getTitle() {
		return title;
	}

	public String getAlbum() {
		return album;
	}

	public String getComposer() {
		return composer;
	}

	public String getLyricist() {
		return lyricist;
	}

	public String getReleaseDate() {
		return releaseDate;
	}
	
	public Singer getSinger() {
		return singer;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void setSinger(Singer singer) {
		this.singer = singer;
	}

	public void printInfo() {
		System.out.println("¾Ù¹ü Á¤º¸--------------------------------------------------------");
		System.out.print("title=[" + title + "]");
		System.out.print("\talbum=[" + album + "]");
		System.out.print("\tcomposer=[" + composer + "]");
		System.out.print("\tlyricist=[" + lyricist + "]");
		System.out.println("\treleaseDate=[" + releaseDate + "]");
		System.out.println("---------------------------------------------------------------");
		singer.printInfo();
	}
	
	
	
	
}
