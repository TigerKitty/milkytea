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
        this.setTitle("��¼/ע��");
        label1 = new JLabel();
        label2 = new JLabel();//�û���
        label3 = new JLabel();//����
        label4 = new JLabel();//ȷ������
        label5 = new JLabel();//�û�����
        textField1 = new JTextField();
        textField2 = new JPasswordField();
        textField3 = new JPasswordField();
        textField4 = new JTextField();
        button1 = new JButton();//����
        button2 = new JButton();//�û�ע��
        button3 = new JButton();//����ע��
        button4 = new JButton();//���ص���
        button5 = new JButton();//�̼ҵ���

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.PLAIN, 10));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6b22\u8fce\u4f7f\u7528\u5976\u8336\u5916\u5356\u7cfb\u7edf");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 12f));
        contentPane.add(label1);
        label1.setBounds(150, 30, 250, 40);

        //---- label2 ----�û���
        label2.setText("\u7528\u6237\u540d\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(150, 110), label2.getPreferredSize()));

        //---- label3 ----����
        label3.setText("\u5bc6\u7801\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        contentPane.add(label3);
        label3.setBounds(160, 165, label3.getPreferredSize().width, 20);

        //---- label4 ----ȷ������
        label4.setText("\u786e\u8ba4\u5bc6\u7801\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 3f));
        contentPane.add(label4);
        label4.setBounds(135, 220, label4.getPreferredSize().width, 17);
        contentPane.add(textField1);

        label4.setVisible(false);

        //---- label5 ----�û�����
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

        //---- button1 ----�û�����
        button1.setText("\u7528\u6237\u767b\u5165");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 4f));
        contentPane.add(button1);
        button1.setBounds(180, 235, 205, 40);
        button1.addActionListener(
                //�����ڲ��ࣺ�ֲ��ڲ���
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        //�õ��û���������
                        String username=textField1.getText();//��ȡ�û���
                        String password= new String(textField2.getPassword());//��ȡ����

                        Connection conn=null;
                        String url="jdbc:oracle:thin:@112.74.59.255:1521:orcl";
                        Statement stmt=null;//SQL������ƴSQL
                        /*
                         * 1�������û����Ѽ��ܺ����������ݿ��õ�
                         * 2����������ܺ������ݿ���ȡ����������бȶ�
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
                            if (rs.next()) {//�Խ���������жϣ��ж����ݿ��Ƿ��и��û�
                                String encodePassword = rs.getString(1);//��ȡ���ݿ��н��м����˵�����
                                if (MD5.checkpassword(password, encodePassword)) {//���û������������ܺ�����ݿ��ȡ����������бȽ�
                                    //���ص��봰�ڣ���ʾSellForm����
                                    //setVisible(false);
                                    new SellFrame();
                                    Login.username = username;
                                } else {
                                    JFrame frame = new JFrame("����ʧ��");
                                    JOptionPane.showMessageDialog(frame, "�������",
                                            "����ʧ��", JOptionPane.WARNING_MESSAGE);
                                    textField2.setText("");
                                }
                            } else {
                                JFrame frame = new JFrame("����ʧ��");
                                JOptionPane.showMessageDialog(frame, "�û�������",

                                        "����ʧ��", JOptionPane.WARNING_MESSAGE);
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
                            //�ͷ���Դ
                            try {
                                rs.close();
                                stmt.close();
                                conn.close();//������
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                    }
                }
        );

        //---- button5 ----�̼ҵ���
        button5.setText("\u5546\u5bb6\u767b\u5165");
        button5.setFont(button5.getFont().deriveFont(button5.getFont().getSize() + 4f));
        contentPane.add(button5);
        button5.setBounds(180, 295, 205, 40);
        button5.addActionListener(
                //�����ڲ��ࣺ�ֲ��ڲ���
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //�õ��û���������
                        String username=textField1.getText();//��ȡ�û���
                        String password=new String(textField2.getPassword());//��ȡ����

                        Connection conn=null;
                        String url="jdbc:oracle:thin:@112.74.59.255:1521:orcl";
                        Statement stmt=null;//SQL������ƴSQL
                        /*
                         * 1�������û����Ѽ��ܺ����������ݿ��õ�
                         * 2����������ܺ������ݿ���ȡ����������бȶ�
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
                            if (rs.next()){//�Խ���������жϣ��ж����ݿ��Ƿ��и��û�
                                String encodePassword = rs.getString(1);//��ȡ���ݿ��н��м����˵�����
                                String power = rs.getString(2);//��ȡ���û����
                                if(MD5.checkpassword(password,encodePassword)){//���û������������ܺ�����ݿ��ȡ����������бȽ�
                                    if(power.equals("0")){
                                        System.out.println("����ɹ�");
                                        new MerSellFrame();
                                        Login.username = username;
                                    }else{
                                        JFrame frame = new JFrame("����ʧ��");
                                        JOptionPane.showMessageDialog(frame, "�������̼��˺�",
                                                "����ʧ��", JOptionPane.WARNING_MESSAGE);
                                        textField1.setText("");
                                        textField2.setText("");
                                    }

                                }else{
                                    JFrame frame = new JFrame("����ʧ��");
                                    JOptionPane.showMessageDialog(frame, "�������",
                                            "����ʧ��", JOptionPane.WARNING_MESSAGE);
                                    textField2.setText("");
                                }
                            }else {
                                JFrame frame = new JFrame("����ʧ��");
                                JOptionPane.showMessageDialog(frame, "�û�������",

                                        "����ʧ��", JOptionPane.WARNING_MESSAGE);
                                textField1.setText("");
                            }
                        } catch (SQLException ee) {
                            ee.printStackTrace();
                        } catch (NoSuchAlgorithmException ex) {
                            ex.printStackTrace();
                        } catch (UnsupportedEncodingException ex) {
                            ex.printStackTrace();
                        } finally {
                            //�ͷ���Դ
                            try {
                                rs.close();
                                stmt.close();
                                conn.close();//������
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                    }
                }
        );

        //---- button2 ----�û�ע��
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


        //---- button3 ----����ע��
        button3.setText("\u7acb\u5373\u6ce8\u518c");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(160, 335), button3.getPreferredSize()));

        button3.setVisible(false);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username=textField1.getText();//��ȡ�û���
                        String password  = new String(textField2.getPassword());//��ȡ����
                        String password2 = new String(textField3.getPassword());//��ȡ������������
                        String uname=textField4.getText();//��ȡ�û�����
                        boolean b_username=true;
                        boolean b_password=true;

                        //�ж��û����Ƿ�Ϊ2-6λ��Сд��ĸ
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

                        //�ж������Ƿ�Ϊ3-10λ�����ֻ�Сд��ĸ
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
                        Statement stmt=null;//SQL������ƴSQL

                        //��������м��ܺ�����ӽ����ݿ�
                        String sql= null;
                        try {
                            sql = "INSERT INTO users values('"+username+"','"+MD5.encoderByMd5(password)+"','"+uname+"','"+1+"')";
                        } catch (NoSuchAlgorithmException ex) {
                            ex.printStackTrace();
                        } catch (UnsupportedEncodingException ex) {
                            ex.printStackTrace();
                        }
                        if (b_username) {//�ж��û����Ƿ�Ϊ2-6λ��Сд��ĸ
                            if (b_password){//�ж������Ƿ�Ϊ3-10λ�����ֻ�Сд��ĸ
                                if (password.equals(password2)) {//�ж����������Ƿ���ͬ���Ǿͽ����û���Ϣ���
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
                                    JFrame frame = new JFrame("�û�ע��");
                                    JOptionPane.showMessageDialog(frame, "ע��ɹ�",

                                            "�û�ע��", JOptionPane.WARNING_MESSAGE);
                                    textField1.setText("");
                                    textField2.setText("");
                                    textField3.setText("");
                                    textField4.setText("");
                                } else {
                                    JFrame frame = new JFrame("ע��ʧ��");
                                    JOptionPane.showMessageDialog(frame, "�������벻һ��",

                                            "ע��ʧ��", JOptionPane.WARNING_MESSAGE);
                                    textField3.setText("");
                                }
                            }else {
                                JFrame frame = new JFrame("ע��ʧ��");
                                JOptionPane.showMessageDialog(frame, "������3-10λ��Сд��ĸ��������Ϊ����",

                                        "ע��ʧ��", JOptionPane.WARNING_MESSAGE);
                                textField2.setText("");
                            }
                        } else {
                            JFrame frame = new JFrame("ע��ʧ��");
                            JOptionPane.showMessageDialog(frame, "������2-6λ��Сд��ĸ��Ϊ�û���",

                                    "ע��ʧ��", JOptionPane.WARNING_MESSAGE);
                            textField1.setText("");
                        }

                    }
                }
        );

        //---- button4 ----���ص���
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
