package class10_class.ep03_has_a.ep02_actor;

public class Actor {

	// Variable
	private String name; // 배우명
	private String gender; // 성별
	private String birthdate; // 생년월일
	private String nationality; // 국적

	// Constructor
	public Actor(String name, String gender, String birthdate,
			String nationality) {
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.nationality = nationality;
	}

	// Method
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public void printInfo() {
		System.out.println("\tActor Information -----------------------------");
		System.out.print("\tname=[" + getName() + "] ");
		System.out.print(" gender=[" + getGender() + "] ");
		System.out.print(" birthdate=[" + getBirthdate() + "] ");
		System.out.println(" nationality=[" + getNationality() + "] ");
	}

}
