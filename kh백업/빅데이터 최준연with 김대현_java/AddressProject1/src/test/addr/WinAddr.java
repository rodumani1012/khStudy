package test.addr;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WinAddr extends Frame{

	public static void main(String[] args) {
		Frame win = new WinAddr();
		win.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent w)
			{	System.exit(0);}
		});
		win.setSize(300, 500);
		win.setVisible(true);
	}
	private ListAdapter adapter;
	private List listView;
	private Label label;
	private TextField inputTxt;
	private Button insertBtn;
	private Button deleteBtn;
	private Button updateBtn;
	public WinAddr()
	{	//adapter객체 생성		
		adapter = new ListAdapter();
		listView = new List(10);
		label = new Label("이름");
		inputTxt = new TextField(20);
		insertBtn = new Button("INSERT");
		deleteBtn = new Button("DELETE");
		updateBtn = new Button("UPDATE");
		
		add(listView);
		Panel panelS, panelSN, panelSS;
		panelS = new Panel(new GridLayout(2, 1));
		panelSN = new Panel();
		panelSS = new Panel();
		
		add(panelS, "South");
		panelS.add(panelSN);
		panelS.add(panelSS);
		
		panelSN.add(label);
		panelSN.add(inputTxt);

		panelSS.add(insertBtn);
		panelSS.add(deleteBtn);
		panelSS.add(updateBtn);
		
		listener();
	}
	private void listener() {
		listView.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 이벤트 객체를 통해 
				//->listView에서 선택된 아이템의 이름을 inputTxt에 지정
				String name = listView.getSelectedItem();
				inputTxt.setText(name);
			}
		});
		ActionListener buttonListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//이벤트객체의 ActionCommand 값을 통해 
				String command = e.getActionCommand();
				String name = inputTxt.getText();
				int i = listView.getSelectedIndex();
				//조건문으로 insert(), delete(), update()를 실행
				switch (command.charAt(0)) {
				case 'I':
					adapter.insert(name);
					break;
				case 'D':					
					adapter.delete(i);
					break;
				case 'U':
					adapter.update(i, name);
					break;

				default:
					break;
				}
				//실행 후 listView를 클리어하고 adapter의 값을 listView에 출력
				listView.clear();
				for (String name1 : adapter.all()) {
					listView.add(name1);
				}
				// inputTxt를 clear
				inputTxt.setText("");
			}
		};
		insertBtn.addActionListener(buttonListener );
		deleteBtn.addActionListener(buttonListener);
		updateBtn.addActionListener(buttonListener);
	}
}
