package c0718.test;

public class Coffee {
	String name;
	int price;
	
	public Coffee() {
	}

	public Coffee(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void printInfo() {
		System.out.println("Coffee Information------------------------");
		System.out.print("Name=[" + name + "]");
		System.out.println("\tPrice=[" + price + "]");
	}

}
