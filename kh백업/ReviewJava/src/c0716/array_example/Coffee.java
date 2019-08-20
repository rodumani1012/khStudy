package c0716.array_example;

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
		System.out.println("커피 정보------------------------");
		System.out.print("커피이름=[" + name + "]");
		System.out.println("\t가격=[" + price + "]");
		System.out.println("------------------------------");
	}

}
