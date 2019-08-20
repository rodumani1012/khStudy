package test.inner;
/**
 * 주제 : Inner(내부) class 만들기
 * 내부 클래스를 만드는 이유: 
	1. memory나 file의 size를 줄이기 위해
	2. 코딩이 편리하다
	3. 다른 곳에서의 재사용율이 낮은 객체이다.
 * @author 최준연
 * 1. Inner class
 * 특징 1-1 내부 클래스 앞에 private/protected 이 가능하다. 외부클래스 member나 method를 내부에서 쓸 수 있다.
 * 2. Static Inner
 * 특징 2-1 메인클래스에서 객체 생성/사용할 경우 편리한 방식이다. 
 * 3. Local Inner
 * 특징 3-1 해당 method 안에서만 사용할 경우
 * 4. Anonymous class
 * 특징 4-1 In-line class라고 함
 * 	  4-2 인터페이스 또는 추상클래스의 객체가 필요할 경우
 */
public class TestInner {

	public static void main(String[] args) {
		Outer out = new Outer();
		Outer.Inner inner = out.new Inner();
		Outer.StaticInner sInner = new Outer.StaticInner();
		
	}

}

class Outer
{	private int oI = 0; static int sOI = 0;
	static void print(){System.out.println(sOI);}
	public Outer() 
	{	Inner inner = new Inner();
		// Local class 내용이 실행되도록 print(Inner) 호출
		print(inner);
	}	
	// Inner class : 외부클래스 member나 method 접근가능
	class Inner //private/protected 이 가능하다. 
	{	private int iI = 1;
		void print(){System.out.println(iI);}
		Inner(){oI = 10; Outer.this.print();} //this.print();로 쓸경우 Innner와 Outer가 충돌하기 때문에
											  //Outer를 지정하기 위해 Outer.this.print();로 사용
											  //즉, 외부클래스명.this 사용
	}
	
	// Static Inner : 메인클래스에서 객체 생성/사용할 경우 편리(외부클래스와 똑같이 사용가능)
	static class StaticInner
	{	private int iI = 1;
		void print(){System.out.println(iI);}
		StaticInner(){Outer.print(); //oI = 10; non-static이라 안된다.}
		}
	}
	// Local Inner : API내의 interface/abstract class의 객체가 필요시 해당 method 내에서만 사용할 경우
	// 특징 3-1 해당 method 안에서만 사용할 경우
	void print(Inner in)
	{
		
		class Target extends Thread
		{	public void run() {
				System.out.println("Target class.");
			}
			
		}
		// Thread
		Target target = new Target();
		target.start();
		System.out.println(in);
		
		// Anonimous class
		System.out.println(
					new Object()
					{	public String toString()
						{	return "Anonymous class";
						}
					}.toString()						
				);
	}
}
