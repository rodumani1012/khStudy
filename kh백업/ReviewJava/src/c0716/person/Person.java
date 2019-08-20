package c0716.person;

public class Person {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void printInfo() {
		System.out.print("Name=[" + name + "]");
		System.out.println("Age=[" + age + "]");
		
	}
	
	
}
