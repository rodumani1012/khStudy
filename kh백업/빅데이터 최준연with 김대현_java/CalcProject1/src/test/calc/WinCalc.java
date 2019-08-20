package test.calc;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WinCalc extends Frame{

	public static void main(String[] args) {
		Frame win = new WinCalc();
		win.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent w)
			{	System.exit(0);}
		});
		win.setSize(800, 300);
		win.setVisible(true);
	}


	private TextField opr1Txt;
	private TextField opr2Txt;
	private TextField opTxt;
	private TextField resultTxt;
	private Calc c;

	
	public WinCalc() {
		c = new Calc();
		setLayout(new FlowLayout());
		
		opr1Txt = new TextField(5);
		opr2Txt = new TextField(5);
		opTxt = new TextField(2);
		resultTxt = new TextField(8);
		
		add(opr1Txt);	add(opTxt);	add(opr2Txt);	
		add(new Label(" = "));	add(resultTxt);

		opr1Txt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				/*
				 * to-do : 
				 * 1. opr1Txt.???() -> ���ڿ��� �� opr1��
				 * 2. c.???()�� ����Ͽ� 1������ opr1������ ����
				 */
				String text = opr1Txt.getText();
//				String -> int
				int i = Integer.parseInt(text);
				c.setOpr1(i);
			}
			public void focusGained(FocusEvent e) {}
		});
		opr2Txt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				/*
				 * to-do : 
				 * 1. opr2Txt.???() -> ���ڿ��� �� opr1��
				 * 2. c.???()�� ����Ͽ� 1������ opr1������ ����
				 */
				String text = opr2Txt.getText();
				int opr2 = Integer.parseInt(text);
				c.setOpr2(opr2);
			}
			public void focusGained(FocusEvent e) {}
		});
		opTxt.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				run();
			}
			public void focusGained(FocusEvent e) {}
		});
	}


	protected void run() {
		/*
		 * to-do : ���ǹ��� �̿��Ͽ� �����Լ��� �����ϰ� �� ����� resultTxt�� �־��
		 * 1. ���� ? op���� �����̳�?  <- c.???()�� �̿��Ͽ� op���� ����
		 * 2. 1�� ���ǿ� ���� c.???()�� ������ ����� resultTxt�� ����
		 */
		char op = opTxt.getText().charAt(0);
		switch (op) {
		case '+':
			resultTxt.setText("" + c.plus());
			break;
		case '-':
			resultTxt.setText("" + c.minus());
			break;
		case '*':
			resultTxt.setText("" + c.mul());
			break;
		case '/':
			resultTxt.setText("" + c.div());
			break;
		case '%':
			resultTxt.setText("" + c.per());
			break;

		default:
			resultTxt.setText("�� ����");
			break;
		}
		
	}
	
	
}
