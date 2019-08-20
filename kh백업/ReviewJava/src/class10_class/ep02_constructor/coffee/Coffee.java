package class10_class.ep02_constructor.coffee;

public class Coffee {
	
	//Variable
	private String name;		//커피명
	private int price;			//가격
	
	//Constructor
	public Coffee() {
		
	}
		
	public Coffee(String name, int price){
			this.name = name;
			this.price = price;
	}

	//Method
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
	
	public void printInfo(){
		System.out.println("Coffee Information -----------------------------");
		System.out.print("Name=[" + name + "] ");
		System.out.println(" Price=[" + price + "]");
	}

}