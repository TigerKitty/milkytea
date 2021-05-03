package swing.login;

import dao.Check;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
/*
 * Created by JFormDesigner on Thu Apr 22 21:47:23 CST 2021
 */

/**
 * @author unknown
 */
public class Login extends JFrame {
    public static void main(String[] args) {
        new Login();
    }
    public Login() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        textField1 = new JTextField("hzg");
        label1 = new JLabel();
        button2 = new JButton();
        textField2 = new JTextField("123");
        label2 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(85, 140), button1.getPreferredSize()));
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        login();
                    }
                }
        );
        contentPane.add(textField1);
        textField1.setBounds(145, 65, 95, textField1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("username");
        contentPane.add(label1);
        label1.setBounds(85, 65, 55, label1.getPreferredSize().height);

        //---- button2 ----
        button2.setText("\u9000\u51fa");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(185, 140), button2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(145, 105, 95, textField2.getPreferredSize().height);

        //---- label2 ----
        label2.setText("password");
        contentPane.add(label2);
        label2.setBounds(85, 105, 50, label2.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        //调用时显示面板,
        setVisible(true);
        //关闭窗口时，同时关闭本次运行
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    private void login(){
        //获取用户名和密码
        String username = textField1.getText();
        String password = textField2.getText();
        //获取查询结果
        Check checkLogin = new Check();
        try {
            int loginRes = checkLogin.Login(username,password);
            if (loginRes == 1){
                setVisible(false);
                //new SellGoods();
            }else{
                new LoginLoss();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            new LoginLoss();
        }
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JTextField textField1;
    private JLabel label1;
    private JButton button2;
    private JTextField textField2;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
