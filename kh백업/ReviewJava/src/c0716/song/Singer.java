package c0716.song;

public class Singer {
	private String name, sex, birthDate, company;
	
	public Singer() {

	}

	public Singer(String name, String sex, String birthDate, String company) {
		this.name = name;
		this.sex = sex;
		this.birthDate = birthDate;
		this.company = company;
	}
	
	public void printInfo() {
		System.out.println("가수 정보--------------------------------------------------------");
		System.out.print("name=[" + name + "]");
		System.out.print("\tsex=[" + sex + "]");
		System.out.print("\tbirthDate=[" + birthDate + "]");
		System.out.println("\tcompany=[" + company + "]");
		System.out.println("---------------------------------------------------------------");
	}
	
}
