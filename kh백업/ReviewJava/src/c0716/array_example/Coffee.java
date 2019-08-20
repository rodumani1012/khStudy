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
		System.out.println("Ŀ�� ����------------------------");
		System.out.print("Ŀ���̸�=[" + name + "]");
		System.out.println("\t����=[" + price + "]");
		System.out.println("------------------------------");
	}

}
