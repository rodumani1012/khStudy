package class10_class.ep01_calssdesign.user;

public class MainUser {

	public static void main(String[] args) {

		User user1 = new User();
		user1.setId("myId");
		user1.setName("kim");
		user1.setEmail("myemail@email.com");
		user1.setGrade(1);
		user1.setMarriageYn(false);
		System.out.println();
		user1.printInfo();

	}

}
