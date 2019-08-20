package c0718.test;

public class Member {
	private String id, password, name, email, regdate;
	
	public Member() {
		
	}

	public Member(String id, String password, String name, String email, String regdate) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.regdate = regdate;
	}

	public Member(String id, String password, String email, String regdate) {
		this.id = id;
		this.password = password;
		this.email = email;
		this.regdate = regdate;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public void printInfo() {
		System.out.print("���̵�=[" + id + "]");
		System.out.print("\t��й�ȣ=[" + password + "]");
		System.out.print("\t�̸�=[" + name + "]");
		System.out.print("\t�̸���=[" + email + "]");
		System.out.println("\t�������=[" + regdate + "]");
	}
	
}
