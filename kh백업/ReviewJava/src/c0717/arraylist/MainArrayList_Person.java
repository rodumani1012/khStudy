package c0717.arraylist;

import java.util.ArrayList;

public class MainArrayList_Person {

	public static void main(String[] args) {
		ArrayList<Person> personList = new ArrayList<Person>();
		
		System.out.println("empty=[" + personList.isEmpty() + "]");
		System.out.println("size=[" + personList.size() + "]");
		
		Person p1 = new Person("홍길동", 15);
		Person p2 = new Person("장길산", 42);
		personList.add(p1);
		personList.add(p2);
		
		for (int i = 0; i < personList.size(); i++) {
			Person list = personList.get(i);
			list.printInfo();
		}
	}

}
