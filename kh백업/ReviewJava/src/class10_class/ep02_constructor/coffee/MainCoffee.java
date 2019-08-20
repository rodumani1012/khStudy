package class10_class.ep02_constructor.coffee;

public class MainCoffee {

	public static void main(String[] args) {
		
		//Object 1
		Coffee coffee1 = new Coffee();
		coffee1.setName("아메리카노");
		coffee1.setPrice(4000);
		coffee1.printInfo();
		
		//Object 2
		Coffee coffee2 = new Coffee("카푸치노",5000);		
		coffee2.printInfo();

	}

}
