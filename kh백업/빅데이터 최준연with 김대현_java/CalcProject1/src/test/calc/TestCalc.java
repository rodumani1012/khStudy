package test.calc;
/**
 * 
 * @author 
 * 설명 : class를 통해 getter setter를 만들고 계산기를 만들어보자
 */
public class TestCalc {

	public static void main(String[] args) {
		Calc c = new Calc();
		c.setOpr1(5);
		c.setOpr2(2);
		c.setOp('+');
		System.out.println("" + c + "=" + c.plus());
		
	}

}
