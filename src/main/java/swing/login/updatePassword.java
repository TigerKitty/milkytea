package swing.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updatePassword extends JFrame {
    public static void main(String[] args) {
        new updatePassword();
    }
    public updatePassword() {
        initComponents();
    }
    private void initComponents() {
        this.setTitle("修改密码");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();

        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        button1 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8d26\u53f7");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(160, 55), label1.getPreferredSize()));


        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        contentPane.add(label2);
        label2.setBounds(160, 110, 75, 19);

        //---- label3 ----
        label3.setText("\u65b0\u5bc6\u7801");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3);
        label3.setBounds(160, 165, 75, 19);

        //---- label4 ----
        label4.setText("\u786e\u8ba4\u65b0\u5bc6\u7801");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));
        contentPane.add(label4);
        label4.setBounds(160, 220, 75, 19);

        //---- textField1 ----
        textField1.setFont(textField1.getFont().deriveFont(textField1.getFont().getSize() + 2f));
        contentPane.add(textField1);
        textField1.setBounds(235, 50, 150, 30);

        //---- textField2 ----
        textField2.setFont(textField2.getFont().deriveFont(textField2.getFont().getSize() + 2f));
        contentPane.add(textField2);
        textField2.setBounds(235, 105, 150, 30);

        //---- textField3 ----
        textField3.setFont(textField3.getFont().deriveFont(textField3.getFont().getSize() + 2f));
        contentPane.add(textField3);
        textField3.setBounds(235, 160, 150, 30);

        //---- textField4 ----
        textField4.setFont(textField4.getFont().deriveFont(textField4.getFont().getSize() + 2f));
        contentPane.add(textField4);
        textField4.setBounds(235, 215, 150, 30);

        //---- button1 ----确认添加
        button1.setText("\u786e\u8ba4\u4fee\u6539");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 2f));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(125, 340), button1.getPreferredSize()));

        //---- button3 ----返回，点击返回登录
        button3.setText("\u8fd4\u56de");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 2f));
        contentPane.add(button3);
        button3.setBounds(395, 340, 88, 30);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        new Login();
                    }
                }
        );
        contentPane.setPreferredSize(new Dimension(605, 480));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
    }
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JButton button1;
    private JButton button3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
}
