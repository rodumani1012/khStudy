package test.encap;
/**
 * 
 * @author ���ؿ�
 * ���� : 
 * �ƹ��͵� �������� �⺻ �����ڷ� ��µǰ� �Ķ��Ʈ�� �����ڴ�� �Է��ϸ� �� ���� ��µȴ�.
 */
public class Encap {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//�⺻ ������
	public Encap() {
		name = "�谳��"; age = 18; 
	}
	// ������ �����ε�(over-loading constructor)
	public Encap(String string, int i) {
		name = string; age = i; 
	}
	public void print() {
		System.out.println(name + " : " + age);
	}
	
}
