package c0716.array_example;

public class MainSingleArrayPerson {

	public static void main(String[] args) {
		Person[] personArray;
		personArray = new Person[3];

		personArray[0] = new Person();
		personArray[0].setName("Hong");
		personArray[0].setAge(25);

		personArray[1] = new Person("Lee", 40);
		personArray[2] = new Person("Park", 35);

		personArray[0].printInfo();
		personArray[1].printInfo();
		personArray[2].printInfo();

		System.out.println();

		for (int i = 0; i < personArray.length; i++) {
			System.out.println(personArray[i]); // �迭���� ����Ǿ��ִ� ���� �ּҰ�
			personArray[i].printInfo();
		}

	}

}
