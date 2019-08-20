package c0716.array_example;

public class Person {
	private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

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
		System.out.print("이름 = [" + name + "]");
		System.out.println("\t나이 = [" + age + "]");
	}

}
