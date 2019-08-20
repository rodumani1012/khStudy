package class10_class.ep01_calssdesign.user;

public class User {

	private String id; // 아이디
	private String name; // 이름
	private String email; // 이메일
	public int grade; // 사용자 등급. 1~5단계.
	private boolean marriageYn; // 결혼여부

	public String getId() {
		return id;
	}

	public void setId(String newId) {
		id = newId;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String newEmail) {
		email = newEmail;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int newGrade) {
		grade = newGrade;
	}

	public boolean getMarriageYn() {
		return marriageYn;
	}

	public void setMarriageYn(boolean newMarriageYn) {
		marriageYn = newMarriageYn;
	}

	public void printInfo() {
		System.out.println("User Information -----------------------------");
		System.out.println("Id=[" + id + "]");
		System.out.println("Name=[" + name + "]");
		System.out.println("Email=[" + email + "]");
		System.out.println("Grade=[" + grade + "]");
		System.out.println("MarriageYn=[" + marriageYn + "]");

	}

}
