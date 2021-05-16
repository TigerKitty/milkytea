package swing.login;

import swing.MainFrame.OnlineMainFrame;
import swing.onlinesale.SellFrame;
import swing.outlinesale.MerSellFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon May 03 20:57:43 CST 2021
 */

/**
 * @author 1
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
        this.setTitle("登录/注册");
        label1 = new JLabel();
        label2 = new JLabel();//用户名
        label3 = new JLabel();//密码
        label4 = new JLabel();//确认密码
        label5 = new JLabel();//用户姓名
        textField1 = new JTextField();
        textField2 = new JPasswordField();
        textField3 = new JPasswordField();
        textField4 = new JTextField();
        button1 = new JButton();//登入
        button2 = new JButton();//用户注册
        button3 = new JButton();//立即注册
        button4 = new JButton();//返回登入
        button5 = new JButton();//商家登入

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6b22\u8fce\u4f7f\u7528\u5976\u8336\u5916\u5356\u7cfb\u7edf");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 12f));
        contentPane.add(label1);
        label1.setBounds(150, 30, 250, 40);

        //---- label2 ----用户名
        label2.setText("\u7528\u6237\u540d\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(150, 110), label2.getPreferredSize()));

        //---- label3 ----密码
        label3.setText("\u5bc6\u7801\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        contentPane.add(label3);
        label3.setBounds(160, 165, label3.getPreferredSize().width, 20);

        //---- label4 ----确认密码
        label4.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 3f));
        contentPane.add(label4);
        label4.setBounds(135, 220, label4.getPreferredSize().width, 17);
        contentPane.add(textField1);

        label4.setVisible(false);

        //---- label5 ----用户姓名
        label5.setText("\u7528\u6237\u59d3\u540d\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 3f));
        contentPane.add(label5);
        label5.setBounds(135, 275, 80, 20);

        label5.setVisible(false);

        textField1.setBounds(215, 105, 150, 35);
        contentPane.add(textField2);
        textField2.setBounds(215, 160, 150, 35);
        contentPane.add(textField3);
        textField3.setBounds(215, 215, 150, 35);
        textField4.setBounds(215, 270, 150, 35);

        textField3.setVisible(false);
        textField4.setVisible(false);

        //---- button1 ----用户登入
        button1.setText("\u7528\u6237\u767b\u5165");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 4f));
        contentPane.add(button1);
        button1.setBounds(180, 235, 205, 40);
        button1.addActionListener(
                //匿名内部类：局部内部类
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        //拿到用户名和密码
                        String username=textField1.getText();//获取用户名
                        String password= new String(textField2.getPassword());//获取密码

                        Connection conn=null;
                        String url="jdbc:oracle:thin:@112.74.59.255:1521:orcl";
                        Statement stmt=null;//SQL语句对象，拼SQL
                        /*
                         * 1、根据用户名把加密后的密码从数据库拿到
                         * 2、把密码加密后于数据库例取出的密码进行比对
                         * */
                        String sql="SELECT password FROM users WHERE username='"+username+"'";
                        ResultSet rs=null;
                        try {
                            try {
                                Class.forName("oracle.jdbc.driver.OracleDriver");
                            } catch (ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                            conn = DriverManager.getConnection(url, "naicha", "lanqiaoNAICHA");
                            stmt = conn.createStatement();
                            rs = stmt.executeQuery(sql);
                            if (rs.next()) {//对结果集进行判断，判断数据库是否有该用户
                                String encodePassword = rs.getString(1);//获取数据库中进行加密了的密码
                                if (MD5.checkpassword(password, encodePassword)) {//将用户输入的密码加密后和数据库获取到的密码进行比较
                                    //隐藏登入窗口，显示SellForm窗口
                                    //setVisible(false);
                                    new SellFrame();
                                    Login.username = username;
                                } else {
                                    JFrame frame = new JFrame("登入失败");
                                    JOptionPane.showMessageDialog(frame, "密码错误",
                                            "登入失败", JOptionPane.WARNING_MESSAGE);
                                    textField2.setText("");
                                }
                            } else {
                                JFrame frame = new JFrame("登入失败");
                                JOptionPane.showMessageDialog(frame, "用户名错误",

                                        "登入失败", JOptionPane.WARNING_MESSAGE);
                                textField1.setText("");
                            }

                        } catch (SQLException ee) {
                            ee.printStackTrace();
                            /*
                            } catch (NoSuchAlgorithmException ex) {
                                ex.printStackTrace();
                            } catch (UnsupportedEncodingException ex) {
                                ex.printStackTrace();
                            * */

                        } catch (NoSuchAlgorithmException ex) {
                            ex.printStackTrace();
                        } catch (UnsupportedEncodingException ex) {
                            ex.printStackTrace();
                        } finally {
                            //释放资源
                            try {
                                rs.close();
                                stmt.close();
                                conn.close();//关连接
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                    }
                }
        );

        //---- button5 ----商家登入
        button5.setText("\u5546\u5bb6\u767b\u5165");
        button5.setFont(button5.getFont().deriveFont(button5.getFont().getSize() + 4f));
        contentPane.add(button5);
        button5.setBounds(180, 295, 205, 40);
        button5.addActionListener(
                //匿名内部类：局部内部类
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //拿到用户名和密码
                        String username=textField1.getText();//获取用户名
                        String password=new String(textField2.getPassword());//获取密码

                        Connection conn=null;
                        String url="jdbc:oracle:thin:@112.74.59.255:1521:orcl";
                        Statement stmt=null;//SQL语句对象，拼SQL
                        /*
                         * 1、根据用户名把加密后的密码从数据库拿到
                         * 2、把密码加密后于数据库例取出的密码进行比对
                         * */
                        String sql="SELECT password,power FROM users WHERE username='"+username+"'";

                        ResultSet rs=null;
                        try {
                            try {
                                Class.forName("oracle.jdbc.driver.OracleDriver");//
                            } catch (ClassNotFoundException ex) {
                                ex.printStackTrace();
                            }
                            conn = DriverManager.getConnection(url, "naicha", "lanqiaoNAICHA");
                            stmt = conn.createStatement();
                            rs = stmt.executeQuery(sql);
                            if (rs.next()){//对结果集进行判断，判断数据库是否有该用户
                                String encodePassword = rs.getString(1);//获取数据库中进行加密了的密码
                                String power = rs.getString(2);//获取该用户身份
                                if(MD5.checkpassword(password,encodePassword)){//将用户输入的密码加密后和数据库获取到的密码进行比较
                                    if(power.equals("0")){
                                        System.out.println("登入成功");
                                        new MerSellFrame();
                                        Login.username = username;
                                    }else{
                                        JFrame frame = new JFrame("登入失败");
                                        JOptionPane.showMessageDialog(frame, "请输入商家账号",
                                                "登入失败", JOptionPane.WARNING_MESSAGE);
                                        textField1.setText("");
                                        textField2.setText("");
                                    }

                                }else{
                                    JFrame frame = new JFrame("登入失败");
                                    JOptionPane.showMessageDialog(frame, "密码错误",
                                            "登入失败", JOptionPane.WARNING_MESSAGE);
                                    textField2.setText("");
                                }
                            }else {
                                JFrame frame = new JFrame("登入失败");
                                JOptionPane.showMessageDialog(frame, "用户名错误",

                                        "登入失败", JOptionPane.WARNING_MESSAGE);
                                textField1.setText("");
                            }
                        } catch (SQLException ee) {
                            ee.printStackTrace();
                        } catch (NoSuchAlgorithmException ex) {
                            ex.printStackTrace();
                        } catch (UnsupportedEncodingException ex) {
                            ex.printStackTrace();
                        } finally {
                            //释放资源
                            try {
                                rs.close();
                                stmt.close();
                                conn.close();//关连接
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                    }
                }
        );

        //---- button2 ----用户注册
        button2.setText("\u7528\u6237\u6ce8\u518c");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 4f));
        contentPane.add(button2);
        button2.setBounds(180, 355, 205, 40);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText("");
                        textField2.setText("");
                        label4.setVisible(true);
                        label5.setVisible(true);
                        textField3.setVisible(true);
                        textField4.setVisible(true);
                        button1.setVisible(false);
                        button2.setVisible(false);
                        button3.setVisible(true);
                        button4.setVisible(true);
                        button5.setVisible(false);
                    }
                }
        );


        //---- button3 ----立即注册
        button3.setText("\u7acb\u5373\u6ce8\u518c");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(160, 335), button3.getPreferredSize()));

        button3.setVisible(false);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username=textField1.getText();//获取用户名
                        String password  = new String(textField2.getPassword());//获取密码
                        String password2 = new String(textField3.getPassword());//获取二次输入密码
                        String uname=textField4.getText();//获取用户姓名
                        boolean b_username=true;
                        boolean b_password=true;

                        //判断用户名是否为2-6位的小写字母
                        if(username.trim().length()>=2&&username.trim().length()<=6) {
                            for (int i = 0; i < username.length(); i++) {
                                if (!Character.isLowerCase(username.charAt(i))) {
                                    b_username = false;
                                    break;
                                } else {
                                    b_username = true;
                                }
                            }
                        }else{
                            b_username = false;
                        }

                        //判断密码是否为3-10位的数字或小写字母
                        if(password.trim().length()>=3&&password.trim().length()<=10) {
                            for (int i = 0; i < password.length(); i++) {
                                if (!Character.isDigit(password.charAt(i))&&!Character.isLowerCase(password.charAt(i))) {
                                    b_password = false;
                                    break;
                                } else {
                                    b_password = true;
                                }
                            }
                        }else{
                            b_password=false;
                        }

                        Connection conn=null;
                        String url="jdbc:oracle:thin:@112.74.59.255:1521:orcl";
                        Statement stmt=null;//SQL语句对象，拼SQL

                        //对密码进行加密后再添加进数据库
                        String sql= null;
                        try {
                            sql = "INSERT INTO users values('"+username+"','"+MD5.encoderByMd5(password)+"','"+uname+"','"+1+"')";
                        } catch (NoSuchAlgorithmException ex) {
                            ex.printStackTrace();
                        } catch (UnsupportedEncodingException ex) {
                            ex.printStackTrace();
                        }
                        if (b_username) {//判断用户名是否为2-6位的小写字母
                            if (b_password){//判断密码是否为3-10位的数字或小写字母
                                if (password.equals(password2)) {//判断两次密码是否相同，是就进行用户信息添加
                                    try {
                                        Class.forName("oracle.jdbc.driver.OracleDriver");//
                                        conn = DriverManager.getConnection(url, "naicha", "lanqiaoNAICHA");
                                        stmt = conn.createStatement();
                                        stmt.executeQuery(sql);
                                    } catch (ClassNotFoundException ex) {
                                        ex.printStackTrace();
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    }
                                    JFrame frame = new JFrame("用户注册");
                                    JOptionPane.showMessageDialog(frame, "注册成功",

                                            "用户注册", JOptionPane.WARNING_MESSAGE);
                                    textField1.setText("");
                                    textField2.setText("");
                                    textField3.setText("");
                                    textField4.setText("");
                                } else {
                                    JFrame frame = new JFrame("注册失败");
                                    JOptionPane.showMessageDialog(frame, "密码输入不一致",

                                            "注册失败", JOptionPane.WARNING_MESSAGE);
                                    textField3.setText("");
                                }
                            }else {
                                JFrame frame = new JFrame("注册失败");
                                JOptionPane.showMessageDialog(frame, "请输入3-10位的小写字母或数字作为密码",

                                        "注册失败", JOptionPane.WARNING_MESSAGE);
                                textField2.setText("");
                            }
                        } else {
                            JFrame frame = new JFrame("注册失败");
                            JOptionPane.showMessageDialog(frame, "请输入2-6位的小写字母作为用户名",

                                    "注册失败", JOptionPane.WARNING_MESSAGE);
                            textField1.setText("");
                        }

                    }
                }
        );

        //---- button4 ----返回登入
        button4.setText("\u8fd4\u56de\u767b\u5165");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(310, 335), button4.getPreferredSize()));
        contentPane.add(textField4);
        button4.setVisible(false);
        button4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText("");
                        textField2.setText("");
                        label4.setVisible(false);
                        label5.setVisible(false);
                        textField3.setVisible(false);
                        textField4.setVisible(false);
                        button1.setVisible(true);
                        button2.setVisible(true);
                        button3.setVisible(false);
                        button4.setVisible(false);
                        button5.setVisible(true);
                    }
                }
        );



        contentPane.setPreferredSize(new Dimension(565, 460));
        pack();
        setLocationRelativeTo(getOwner());

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JPasswordField textField2;
    private JPasswordField textField3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JTextField textField4;
    private JLabel label5;
    public static String username;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
