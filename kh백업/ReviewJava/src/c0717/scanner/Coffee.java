package c0717.scanner;

public class Coffee {
	private String name;
	private int price;
	
	public Coffee() {

	}
	
	public Coffee(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void printInfo() {
		System.out.print("이름=[" + name + "]");
		System.out.println("\t가격=[" + price + "]"); 
	}
	
}
