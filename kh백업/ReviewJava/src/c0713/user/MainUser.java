package c0713.user;

public class MainUser {

	public static void main(String[] args) {
		User user = new User();
		user.setId("myId");
		user.setName("kim");
		user.setEmail("fkasdjkl@gmail.com");
		user.setGrade(1);
		user.setMarriageYn(true);
		user.printInfo();
		
		System.out.println();
		
		User user2 = new User("myId", "kim", "fjalksd@email.com", 1, false);
		user2.printInfo();
		
		System.out.println();
		
		String id = "yourId";
		String name = "Lee";
		String email = "djfalkdsj@naver.com";
		int grade = 5;
		boolean marriageYn = true;
		User user3 = new User(id, name, email, grade, marriageYn);
		user3.printInfo();
	}

}
