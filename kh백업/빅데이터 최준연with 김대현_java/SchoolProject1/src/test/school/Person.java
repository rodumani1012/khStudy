package test.school;

public interface Person {
	String name = "�̸�"; //�տ� public static final�� �ڵ����� ����
	void printName(); 	//�Ϲ����� ������ Ÿ�Կ��� public static final, �Լ����� public abstract
}

abstract class Person1 {
	public static final String name = "�̸�";
	public abstract void printName();
}