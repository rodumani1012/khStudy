package test.school;

public interface Person {
	String name = "이름"; //앞에 public static final이 자동으로 붙음
	void printName(); 	//일반적인 데이터 타입에는 public static final, 함수에는 public abstract
}

abstract class Person1 {
	public static final String name = "이름";
	public abstract void printName();
}