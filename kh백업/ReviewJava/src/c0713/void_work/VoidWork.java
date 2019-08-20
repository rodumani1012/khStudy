package c0713.void_work;

public class VoidWork {
	private int coffeePrice;
	private char hakjum;
	private boolean marriageYn;
	private String message;
	
	public void setCoffeePrice(int coffeePrice) {
		this.coffeePrice = coffeePrice;
	}
	public void setHakjum(char hakjum) {
		this.hakjum = hakjum;
	}
	public void setMarriageYn(boolean marriageYn) {
		this.marriageYn = marriageYn;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public void printInfo() {
		System.out.println("VoidWork Information -----------------------------------------------");
		printCoffeePrice();
		printHakjum();
		printMarryageYn();
		printMessage();
//		System.out.print("coffeePrice = [" + coffeePrice + "]");
//		System.out.print("\thakjum = [" + hakjum + "]");
//		System.out.print("\tmarriageYn = [" + marriageYn + "]");
//		System.out.println("\tmessage = [" + message + "]");
		
	}
	
//	Method : input - X
	public void printCoffeePrice() {
		System.out.print("coffeePrice = [" + coffeePrice + "]");		
	}
	public void printHakjum() {
		System.out.print("\thakjum = [" + hakjum + "]");
		
	}
	public void printMarryageYn() {
		System.out.print("\tmarriageYn = [" + marriageYn + "]");
		
	}
	public void printMessage() {
		System.out.println("\tmessage = [" + message + "]");
		
	}
	

}
