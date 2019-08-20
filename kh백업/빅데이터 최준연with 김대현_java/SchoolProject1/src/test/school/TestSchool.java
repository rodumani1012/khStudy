package test.school;
/**
 * 교과서 7-17 Manager가 School 임
 * @author 최준연
 *
 */
public class TestSchool {

	public static void main(String[] args) {
		Person[] p = new Person[3];
		Person student = new Student();
		Person staff = new Staff();
		Person teacher = new Teacher();
		p[0] = student;
		p[1] = staff;
		p[2] = teacher;
		for (int i = 0; i < p.length; i++) {
			p[i].printName();
		}
		for (Person person : p) {
			person.printName();
		}
//		p[0].name = "홍길동"; //interface 때문에 상수가 되있는 상태여서 대입이 안된다.
//		System.out.println(p[0].name);
	}

}
