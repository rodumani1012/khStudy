package test.calc;
/**
 * 
 * @author 
 * ���� : class�� ���� getter setter�� ����� ���⸦ ������
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
