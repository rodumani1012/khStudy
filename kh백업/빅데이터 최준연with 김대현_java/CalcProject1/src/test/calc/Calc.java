package test.calc;

public class Calc {
	private int opr1, opr2;
	private char op;
	
	public int getOpr1() {
		return opr1;
	}
	public int getOpr2() {
		return opr2;
	}
	public char getOp() {
		return op;
	}
	public void setOpr1(int opr1) {
		this.opr1 = opr1;
	}
	public void setOpr2(int opr2) {
		this.opr2 = opr2;
	}
	public void setOp(char op) {
		this.op = op;
	}
	public int plus() {
		return opr1 + opr2;
	}
	public int minus() {
		return opr1 - opr2;
	}
	public int mul() {
		return opr1 * opr2;
	}
	public int div() {
		return opr1 / opr2;
	}
	public int per() {
		return opr1 % opr2;
	}
	
	@Override
	public String toString() {
		return ""+ opr1 + "" + op + "" + opr2;
	}
	public void print() {
		System.out.println(this);
	}
}

