package swing.addProduct;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed May 05 21:54:54 CST 2021
 */



/**
 * @author 1
 */
public class addProduct extends JFrame {
    public static void main(String[] args) {
        new addProduct();
    }
    public addProduct() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();//标题：商品添加
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5976\u8336\u7f16\u53f7\uff1a");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 2f));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(160, 55), label1.getPreferredSize()));


        //---- label2 ----
        label2.setText("\u5976\u8336\u540d\u79f0\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 2f));
        contentPane.add(label2);
        label2.setBounds(160, 110, 75, 19);

        //---- label3 ----
        label3.setText("\u5976\u8336\u552e\u4ef7\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 2f));
        contentPane.add(label3);
        label3.setBounds(160, 165, 75, 19);

        //---- label4 ----
        label4.setText("\u5976\u8336\u9020\u4ef7\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 2f));
        contentPane.add(label4);
        label4.setBounds(160, 220, 75, 19);

        //---- label5 ----
        label5.setText("\u5355\u4ef6\u5229\u6da6\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 2f));
        contentPane.add(label5);
        label5.setBounds(160, 275, 75, 19);

        //---- label6 ----
        label6.setText("\u5546\u54c1\u6dfb\u52a0");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 4f));
        contentPane.add(label6);
        label6.setBounds(5, 5, 120, 20);


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

        //---- textField5 ----
        textField5.setFont(textField5.getFont().deriveFont(textField5.getFont().getSize() + 2f));
        contentPane.add(textField5);
        textField5.setBounds(235, 270, 150, 30);

        //---- button1 ----确认添加
        button1.setText("\u786e\u8ba4\u6dfb\u52a0");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 2f));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(125, 340), button1.getPreferredSize()));
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String proid = textField1.getText();//获取奶茶编号
                        String proname = textField2.getText();//获取奶茶名称
                        String sellprice = textField3.getText();//获取奶茶售价
                        String buyprice = textField4.getText();//获取奶茶造价
                        String profit = textField5.getText();//获取单价利润

                        Connection conn=null;
                        String url="jdbc:oracle:thin:@112.74.59.255:1521:orcl";
                        Statement stmt=null;//SQL语句对象，拼SQL

                        //对密码进行加密后再添加进数据库
                        String sql = "INSERT INTO users values('"+proid+"','"+ proname+"','"+sellprice+"','"+ buyprice+"','"+ profit+"')";
                        if (true){//如果数据库中无该商品，就进行商品信息添加
                            System.out.println("商品添加成功");
                            try{
                                Class.forName("oracle.jdbc.driver.OracleDriver");//
                                conn= DriverManager.getConnection(url,"naicha","lanqiaoNAICHA");
                                stmt=conn.createStatement();
                                stmt.executeQuery(sql);
                            } catch (ClassNotFoundException ex) {
                                ex.printStackTrace();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                        else{
                            System.out.println("已有该编号商品");
                            textField1.setText("");
                        }
                    }
                }
        );


        //---- button2 ----重置，重置输入信息
        button2.setText("\u91cd\u7f6e");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 2f));
        contentPane.add(button2);
        button2.setBounds(260, 340, 88, 30);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        textField5.setText("");
                    }
                }
        );

        //---- button3 ----返回，点击返回商品信息表
        button3.setText("\u8fd4\u56de");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 2f));
        contentPane.add(button3);
        button3.setBounds(395, 340, 88, 30);

        contentPane.setPreferredSize(new Dimension(605, 480));
        pack();
        setLocationRelativeTo(getOwner());

        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton button1;
    private JLabel label6;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
