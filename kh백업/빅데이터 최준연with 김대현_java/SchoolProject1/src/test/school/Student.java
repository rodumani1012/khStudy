package test.school;

import java.io.Serializable;

public class Student implements Person, Serializable { //abstract와 달리 여러개를 상속 받을 수 있다는 것을 보여줌
	public void printName() {
		System.out.println("학생이름");
	}
}
