 package RoundButton;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.biz.BankBiz;
import com.dto.BankDto;

public class Nopassbook extends JFrame {

   private BankBiz biz = new BankBiz();
   private JPanel contentPane;
   private JTextField accountField;
   private JTextField inputField;
   private JTextField senderField;
   private JTextField messageField;
   private JLabel accountcheck;
   private JButton inputBtn;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Nopassbook frame = new Nopassbook();
               frame.setVisible(true); 
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public Nopassbook() {
	   
      this.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            dispose(); //본인(자기)만 꺼지게 하는 것
         }
      });
      
      setBounds(100, 100, 400, 600);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      
      ImageIcon imgLogo = new ImageIcon("images/logo2.png");
      Image preImg = imgLogo.getImage(); // ImageIcon을 Image로 변환.
      JLabel lbLogo = new JLabel(new ImageIcon(preImg.getScaledInstance(140, 35, java.awt.Image.SCALE_SMOOTH)));
      lbLogo.setBounds(127, 20, 140, 35);
      contentPane.add(lbLogo);
      
      ImageIcon imgPoint = new ImageIcon("images/icon_NoPass.png");
      Image preImg01 = imgPoint.getImage(); // ImageIcon을 Image로 변환.
      JLabel lbPoint = new JLabel(new ImageIcon(preImg01.getScaledInstance(60, 50,java.awt.Image.SCALE_SMOOTH)));
      lbPoint.setBounds(170, 75, 60, 50);
      contentPane.add(lbPoint);
      
      JLabel nopassLabel = new JLabel("무통장 입금");
      nopassLabel.setFont(new Font("돋움", Font.BOLD, 25));
      nopassLabel.setBounds(140, 130, 159, 30);
      contentPane.add(nopassLabel);
      
      JLabel inputAccLabel = new JLabel("입금 계좌");
      inputAccLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      inputAccLabel.setBounds(45, 220, 99, 30);
      contentPane.add(inputAccLabel);
      
      JLabel inputMoneyLabel = new JLabel("이체 금액");
      inputMoneyLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      inputMoneyLabel.setBounds(45, 297, 78, 30);
      contentPane.add(inputMoneyLabel);
      
      JLabel senderLabel = new JLabel("보내는 사람");
      senderLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      senderLabel.setBounds(45, 352, 99, 18);
      contentPane.add(senderLabel);
      
      JLabel messageLabel = new JLabel("보내는 메세지");
      messageLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      messageLabel.setBounds(45, 402, 114, 30);
      contentPane.add(messageLabel);

      accountcheck = new JLabel("");
      accountcheck.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
      accountcheck.setBounds(180, 263, 186, 18);
      contentPane.add(accountcheck);
      
      accountField = new JTextField();
      LimitFont lf = new LimitFont();
      accountField.setDocument(lf);
      accountField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyReleased(KeyEvent e) {
            if(accountField.getText().length() == 11 || e.getKeyChar() == KeyEvent.VK_ENTER) {
               inputField.requestFocus();
            }
            if(biz.accountCheck(accountField.getText())) {
                accountcheck.setText("해당 계좌가 존재합니다.");
                accountcheck.setForeground(Color.black);
             }else {
                accountcheck.setText("해당 계좌가 존재하지 않습니다.");
                accountcheck.setForeground(Color.red);
             }
         }
      });
      accountField.setBounds(170, 215, 196, 40);
      contentPane.add(accountField);
      accountField.setColumns(10);
      
      inputField = new JTextField();
      LimitFont lf2 = new LimitFont();
      inputField.setDocument(lf2);
      inputField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent e) {
            if(e.getKeyChar() == KeyEvent.VK_ENTER) {
               senderField.requestFocus();
            }
         }
      });
      inputField.setBounds(170, 292, 196, 40);
      contentPane.add(inputField);
      inputField.setColumns(10);
      
      senderField = new JTextField();
      senderField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent e) {
            if(e.getKeyChar() == KeyEvent.VK_ENTER) {
               messageField.requestFocus();
            }
         }
      });
      senderField.setBounds(170, 342, 196, 40);
      contentPane.add(senderField);
      senderField.setColumns(10);
      
      inputBtn = new JButton("입    금");
      inputBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      inputBtn.setBounds(40, 490, 150, 50);
      contentPane.add(inputBtn);
      
      inputBtn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent arg0) {
            String account = accountField.getText();
            String input = inputField.getText();
            String sender = senderField.getText();
            String message = messageField.getText();
            if(account.equals("") || input.equals("") ||sender.equals("")) {
               JOptionPane.showMessageDialog(contentPane, "'입금 계좌', '이체 금액', '보내는 사람'은 필수입력값입니다.");
            } else {
               if(account.length() == 11) {
                  BankDto asisbalancedto = biz.BankBalance(account);
                  BankDto trade_listdto = new BankDto(account,null,sender,message,Integer.parseInt(input),0,0);
                  String res = biz.NoPassbookDeposit(account, asisbalancedto, trade_listdto);
                  
                  if(res.equals("11")) {
                     JOptionPane.showMessageDialog(contentPane, account+"계좌에 입금되었습니다!");
                     dispose();
                     MainGUI_beforeLogin main = new MainGUI_beforeLogin();
                     main.setVisible(true);
                  }else {
                     JOptionPane.showMessageDialog(contentPane, "거래가 취소되었습니다.");
                  }
                  
               }else {
                  JOptionPane.showMessageDialog(contentPane, "옳지 않은 계좌형식입니다.");
               }
            }
         }
      });

      
      messageField = new JTextField();
      messageField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent e) {
            if(e.getKeyChar() == KeyEvent.VK_ENTER) {
               inputBtn.requestFocus();
            }
         }
      });
      messageField.setBounds(170, 397, 196, 40);
      contentPane.add(messageField);
      messageField.setColumns(10);
      
      
      JButton cancleBtn = new JButton("취    소");
      cancleBtn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            dispose();
            MainGUI_beforeLogin mainGUI_beforeLogin = new MainGUI_beforeLogin();
            mainGUI_beforeLogin.setVisible(true);
         }
      });
      cancleBtn.setFont(new Font("맑은 고딕", Font.BOLD, 18));
      cancleBtn.setBounds(210,490, 150, 50);
      contentPane.add(cancleBtn);

   }

   @Override
   public void paint(Graphics g) {
      super.paint(g);
      g.drawLine(20, 210, 380, 210);
      g.drawLine(20, 500, 380, 500);
   }
}