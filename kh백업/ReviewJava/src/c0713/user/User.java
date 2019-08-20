package c0713.user;

public class User {
	
	public String id;
	public String name;
	public String email;
	public int grade;
	public boolean marriageYn;
	
	public User(){
		
	}
	
	public User(String id, String name, String email, int grade, boolean marriageYn){
		this.id = id;
		this.name = name;
		this.email = email;
		this.grade = grade;
		this.marriageYn = marriageYn;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getGrade() {
		return grade;
	}
	public boolean isMarriageYn() {
		return marriageYn;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setMarriageYn(boolean marriageYn) {
		this.marriageYn = marriageYn;
	}
	
	public void printInfo() {
		System.out.println("User Information------------------------");
		System.out.println("Id=[" + id + "]");
		System.out.println("Name=[" + name + "]");
		System.out.println("Email=[" + email + "]");
		System.out.println("Grade=[" + grade + "]");
		System.out.println("MarriageYn=[" + marriageYn + "]");
	}
}
