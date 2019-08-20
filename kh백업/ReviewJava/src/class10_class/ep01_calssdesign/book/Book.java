package class10_class.ep01_calssdesign.book;

public class Book {

	// Variable
	private String category; // 분류
	private String title; // 제목
	private String author; // 작가
	private String publisher; // 출판사
	private int price; // 가격

	// Method
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void printInfo() {
		System.out.println("Book Information -----------------------------");
		System.out.print("category=[" + category + "]");
		System.out.print(" title=[" + title + "]");
		System.out.print(" author=[" + author + "]");
		System.out.print(" publisher=[" + publisher + "]");
		System.out.println(" price=[" + price + "]");
	}

}