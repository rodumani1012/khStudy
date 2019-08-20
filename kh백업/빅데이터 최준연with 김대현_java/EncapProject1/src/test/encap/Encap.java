package test.encap;
/**
 * 
 * @author 최준연
 * 설명 : 
 * 아무것도 안적으면 기본 생성자로 출력되고 파라멘트한 생성자대로 입력하면 그 값이 출력된다.
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
	//기본 생성자
	public Encap() {
		name = "김개똥"; age = 18; 
	}
	// 생성자 오버로딩(over-loading constructor)
	public Encap(String string, int i) {
		name = string; age = i; 
	}
	public void print() {
		System.out.println(name + " : " + age);
	}
	
}
