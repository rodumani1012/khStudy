package c0713.book;

public class Book {
	String category, title, author, publisher;
	int price;
	
	public String getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void printInfo() {
		System.out.println("Book Information------------------------");
		System.out.print("category=[" + category + "]");
		System.out.print("\ttitle=[" + title + "]");
		System.out.print("\tauthor=[" + author + "]");
		System.out.print("\tpublisher=[" + publisher + "]");
		System.out.print("\tprice=[" + price + "]");
		
	}
	
	
}
