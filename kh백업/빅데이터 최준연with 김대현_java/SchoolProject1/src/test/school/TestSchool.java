package test.school;
/**
 * ������ 7-17 Manager�� School ��
 * @author ���ؿ�
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
//		p[0].name = "ȫ�浿"; //interface ������ ����� ���ִ� ���¿��� ������ �ȵȴ�.
//		System.out.println(p[0].name);
	}

}
