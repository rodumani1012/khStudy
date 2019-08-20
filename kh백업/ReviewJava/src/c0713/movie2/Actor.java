package c0713.movie2;

public class Actor {
	private String name;
	private String gender;
	private String birthDate;
	private String nationality;
	
	public Actor(String name, String gender, String birthDate, String nationality) {
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.nationality = nationality;
	}

	public void printInfo() {
		System.out.println("Actor Information-------------------------------------------------------");
		System.out.print("Name = [" + name + "]");
		System.out.print("\tGender = [" + gender + "]");
		System.out.print("\tBirthdate = [" + birthDate + "]");
		System.out.println("\tNationality = [" + nationality + "]");
		System.out.println("------------------------------------------------------------------------");

		
	}

}
