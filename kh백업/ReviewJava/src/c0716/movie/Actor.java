package c0716.movie;

public class Actor {
	private String name, gender, birthdate, nationality;
	
	public Actor(String name, String gender, String birthdate, String nationality) {
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.nationality = nationality;
	}
	
	public void printInfo() {
		System.out.println("Actor Information-------------------------------------------------------");
		System.out.print("Name = [" + name + "]");
		System.out.print("\tGender = [" + gender + "]");
		System.out.print("\tBirthdate = [" + birthdate + "]");
		System.out.println("\tNationality = [" + nationality + "]");
		System.out.println("------------------------------------------------------------------------");

		
	}
}
