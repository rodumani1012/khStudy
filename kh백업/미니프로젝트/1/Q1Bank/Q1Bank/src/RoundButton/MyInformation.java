package RoundButton;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.biz.BankBiz;
import com.dto.BankDto;

public class MyInformation extends JFrame {

   private BankBiz biz = new BankBiz();
   private JPanel contentPane;
   JPanel panel_banner;
   private JTextField nameField;
   private JPasswordField passwordField;
   private JButton updateBtn, deleteBtn, cancelBtn;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               MyInformation frame = new MyInformation();
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
   public MyInformation() {
   }

   public MyInformation(BankDto logindto) {
      this.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            dispose(); // 본인(자기)만 꺼지게 하는 것
         }
      });

      setBounds(100, 100, 800, 600);
      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      Dimension frameSize = this.getSize(); // 프레임 사이즈
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
      this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
      contentPane.setLayout(null);

      ImageIcon img_banner = new ImageIcon("images/banner_myInfo.png");
      Image preImg01 = img_banner.getImage();
      JLabel label_banner = new JLabel(
            new ImageIcon(preImg01.getScaledInstance(800, 100, java.awt.Image.SCALE_SMOOTH)));
      panel_banner = new JPanel();
      panel_banner.add(label_banner);
      panel_banner.setBounds(0, -5, 800, 100);
      contentPane.add(panel_banner);

      JLabel accountLabel = new JLabel("계 좌 번 호");
      accountLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
      accountLabel.setBounds(185, 167, 130, 38);
      contentPane.add(accountLabel);

      JLabel nameLabel = new JLabel("이        름");
      nameLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
      nameLabel.setBounds(185, 236, 130, 38);
      contentPane.add(nameLabel);

      JLabel passwordLabel = new JLabel("비 밀 번 호");
      passwordLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
      passwordLabel.setBounds(185, 310, 130, 38);
      contentPane.add(passwordLabel);

      JLabel accountLabel2 = new JLabel();
      accountLabel2.setText(logindto.getAccount());
      accountLabel2.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
      accountLabel2.setBounds(367, 167, 372, 38);
      contentPane.add(accountLabel2);

      nameField = new JTextField();
      nameField.setFont(new Font("굴림", Font.PLAIN, 18));
      nameField.setText(logindto.getName());
      nameField.setBounds(367, 239, 200, 35);
      contentPane.add(nameField);
      nameField.setColumns(10);
      nameField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent ke) {
            if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
               passwordField.requestFocus();
            }
         }
      });

      passwordField = new JPasswordField();
      LimitFont lf = new LimitFont();
      passwordField.setFont(new Font("굴림", Font.PLAIN, 18));
      passwordField.setBounds(367, 313, 200, 35);
      passwordField.setDocument(lf);
      contentPane.add(passwordField);
      passwordField.addKeyListener(new KeyAdapter() {
         @Override
         public void keyTyped(KeyEvent ke) {
            JTextField src = (JTextField) ke.getSource();
            if (src.getText().length() >= 4) {
               ke.consume();
            }

            if (ke.getKeyChar() == KeyEvent.VK_ENTER) {
               updateBtn.requestFocus();
            }
         }
      });

      JCheckBox pwchk = new JCheckBox("비밀번호 확인");
      pwchk.setFont(new Font("굴림", Font.PLAIN, 18));
      pwchk.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            if (pwchk.isSelected()) {
               passwordField.setEchoChar((char) 0);
            } else {
               passwordField.setEchoChar('●');
            }
         }
      });
      pwchk.setBounds(366, 357, 186, 27);
      contentPane.add(pwchk);

      updateBtn = new JButton("수  정");
      updateBtn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (passwordField.getText().length() == 4) {
               int res = biz.Memberupdate(accountLabel2.getText(), nameField.getText(), passwordField.getText());
               if (res > 0) {
                  JOptionPane.showMessageDialog(null, "수정되었습니다.\n다시 로그인 해주세요!");
                  MainGUI_beforeLogin mainGUI_beforeLogin = new MainGUI_beforeLogin();
                  mainGUI_beforeLogin.setVisible(true);
                  dispose();
               } else {
                  JOptionPane.showMessageDialog(null, "※ 이름과 비밀번호는 필수입력 사항입니다!");
               }
            }else {
               JOptionPane.showMessageDialog(null, "※비밀번호는 4자리를 입력해주세요.");
            }
         }
      });
      updateBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
      updateBtn.setBounds(142, 474, 130, 55);
      contentPane.add(updateBtn);

      deleteBtn = new JButton("탈  퇴");
      deleteBtn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (passwordField.getText().length() == 4) {
               if (JOptionPane.showConfirmDialog(null, "정말 탈퇴하시겠습니까?", "탈퇴", JOptionPane.YES_NO_OPTION,
                     JOptionPane.WARNING_MESSAGE) == 0) {
                  biz.Memberdelete(accountLabel2.getText(), passwordField.getText());
                  JOptionPane.showMessageDialog(null, "탈퇴되었습니다. \n 이용해주셔서 감사합니다.");
                  MainGUI_beforeLogin mainGUI_beforeLogin = new MainGUI_beforeLogin();
                  mainGUI_beforeLogin.setVisible(true);
                  dispose();
               }
            } else {
               JOptionPane.showMessageDialog(null, "※ 이름과 비밀번호는 필수입력 사항입니다!");
            }
         }

      });
      deleteBtn.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
         }
      });
      deleteBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
      deleteBtn.setBounds(342, 474, 130, 55);
      contentPane.add(deleteBtn);

      cancelBtn = new JButton("닫  기");
      cancelBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 22));
      cancelBtn.setBounds(542, 474, 130, 55);
      cancelBtn.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            MainGUI_afterLogin after = new MainGUI_afterLogin(logindto);
            after.setVisible(true);
            dispose();
         }
      });
      contentPane.add(cancelBtn);

   }
}