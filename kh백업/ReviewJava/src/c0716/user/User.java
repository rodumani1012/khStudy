package c0716.user;

public class User {
	private String id, name, grade;
	private int lucci;
	private Kart kart;
	
	public User() {
		
	}
	
	public User(String id, String name, String grade, int lucci) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.lucci = lucci;
	}
	
	public User(String id, String name, String grade, int lucci, Kart kart) {
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.lucci = lucci;
		this.kart = kart;
	}


	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getGrade() {
		return grade;
	}
	public int getLucci() {
		return lucci;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setLucci(int lucci) {
		this.lucci = lucci;
	}
	
	public void printInfo() {
		System.out.println("유저 정보------------------------------------------------------");
		System.out.print("id=[" + id + "]");
		System.out.print("\tname=[" + name + "]");
		System.out.print("\tgrade=[" + grade + "]");
		System.out.println("\tlucci=[" + lucci + "]");
		System.out.println("---------------------------------------------------------------");
	}
	
	public void printInfoA() {
		System.out.println("유저 정보------------------------------------------------------");
		System.out.print("id=[" + id + "]");
		System.out.print("\tname=[" + name + "]");
		System.out.print("\tgrade=[" + grade + "]");
		System.out.println("\tlucci=[" + lucci + "]");
		System.out.println("---------------------------------------------------------------");
		kart.printInfo();
	}

	public void go() {
		String kartName = kart.getName();
		System.out.println("["+ id + "]" + kartName + " go()");
		printInfoA();
	}

	public void stop() {
		String kartName = kart.getName();
		System.out.println("["+ id + "]" + kartName + " stop()");
		printInfoA();
	}

	public void getLucci100() {
		String kartName = kart.getName();
		System.out.println("["+ id + "]" + kartName + " getLucci100()");
		lucci = lucci + 100;
		printInfoA();
	}
	
	
	
}
