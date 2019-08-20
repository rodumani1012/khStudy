package c0713.book;

public class MainBook {

	public static void main(String[] args) {
		Book b1 = new Book();
		b1.setCategory("만화");
		b1.setTitle("열혈강호");
		b1.setAuthor("전극진, 양재헌");
		b1.setPublisher("대원씨아이");
		b1.setPrice(45);
		b1.printInfo();
		
	}

}
