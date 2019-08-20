package c0717.arraylist;

public class Person {
	private String name;
	private int age;
	
	public Person() {
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void printInfo() {
		System.out.print("name=[" + name + "]");
		System.out.println("\tage=[" + age + "]");
		
	}
	
}
