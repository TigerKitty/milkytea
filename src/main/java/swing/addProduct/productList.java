package swing.addProduct;

import entity.sale.MilkTeaBean;
import listener.sale.JoinShopCar;
import listener.sale.WarnFrame;
import swing.Underway.UnderwayFrame;

import util.Dbutil;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Sun May 02 13:45:46 CST 2021
 */

/**
 * 线上销售界面
 */
public class productList extends JFrame {
    public static void main(String[] args) {
        productList sellFrame=new productList();
    }
    public productList() {
        initComponents();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        //======== this ========
        this.setTitle("商品管理");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        jPanel=new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.WHITE);
        jPanel.setBounds(530,0,320,500);
        contentPane.add(jPanel);

        label =new JLabel();
        label1=new JLabel();
        label2=new JLabel();
        label3=new JLabel();
        label4=new JLabel();//

        label5=new JLabel();
        label6=new JLabel();
        label7=new JLabel();

        label5_name = "\u6dfb\u52a0\u5546\u54c1";
        textField = new JTextField();//奶茶编号
        textField1=new JTextField();//奶茶名称
        textField2=new JTextField();//奶茶售价
        textField3=new JTextField();//奶茶造价
        textField4=new JTextField();//奶茶利润

        button1 = new JButton();//确认添加
        button6 = new JButton();//确认修改
        button7 = new JButton();//确认删除

        button2 = new JButton();//重置
        button3=new JButton();//删除商品
        button4=new JButton();//修改商品
        button5=new JButton();//添加商品
        //----lable---//
        label.setText("\u5976\u8336\u7f16\u53f7");
        jPanel.add(label);
        label.setBounds(new Rectangle(new Point(30, 150), label.getPreferredSize()));
        jPanel.add(textField);
        textField.setBounds(105, 150, 130, textField.getPreferredSize().height);

        //----lable1---//
        label1.setText("\u5976\u8336\u540d\u79f0");
        jPanel.add(label1);
        label1.setBounds(new Rectangle(new Point(30, 180), label1.getPreferredSize()));
        jPanel.add(textField1);
        textField1.setBounds(105, 180, 130, textField1.getPreferredSize().height);
        //---lable2---//
        label2.setText("\u5976\u8336\u552e\u4ef7");
        jPanel.add(label2);
        label2.setBounds(new Rectangle(new Point(30, 210), label2.getPreferredSize()));
        jPanel.add(textField2);
        textField2.setBounds(105, 210, 130, textField.getPreferredSize().height);
        //--lable--3//
        label3.setText("\u5976\u8336\u9020\u4ef7");
        jPanel.add(label3);
        label3.setBounds(new Rectangle(new Point(30, 240), label3.getPreferredSize()));
        jPanel.add(textField3);
        textField3.setBounds(105, 240, 130, textField3.getPreferredSize().height);
        //--lable--4//
        label4.setText("\u5976\u8336\u5229\u6da6");
        jPanel.add(label4);
        label4.setBounds(new Rectangle(new Point(30, 270), label4.getPreferredSize()));
        jPanel.add(textField4);
        textField4.setBounds(105, 270, 130, textField4.getPreferredSize().height);

        //--lable--5//右上角“添加商品”标识
        label5.setText(label5_name);
        jPanel.add(label5);
        label5.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 30));
        label5.setBounds(new Rectangle(new Point(70, 70), label5.getPreferredSize()));
        //--lable--6//右上角“修改商品”标识
        label6.setText("\u4fee\u6539\u5546\u54c1");
        jPanel.add(label6);
        label6.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 30));
        label6.setBounds(new Rectangle(new Point(70, 70), label6.getPreferredSize()));
        label6.setVisible(false);
        //--lable--7//右上角“删除商品”标识
        label7.setText("\u5220\u9664\u5546\u54c1");
        jPanel.add(label7);
        label7.setFont(new Font("\u5b8b\u4f53", Font.BOLD, 30));
        label7.setBounds(new Rectangle(new Point(70, 70), label7.getPreferredSize()));
        label7.setVisible(false);


        //---- button1 ----确认添加
        button1.setText("\u786e\u8ba4\u6dfb\u52a0");
        jPanel.add(button1);
        button1.setBounds(new Rectangle(new Point(40, 320), button1.getPreferredSize()));
        //---- button6 ----确认修改
        button6.setText("\u786e\u8ba4\u4fee\u6539");
        jPanel.add(button6);
        button6.setBounds(new Rectangle(new Point(40, 320), button6.getPreferredSize()));
        button6.setVisible(false);
        //---- button7 ----确认删除
        button7.setText("\u786e\u8ba4\u5220\u9664");
        jPanel.add(button7);
        button7.setBounds(new Rectangle(new Point(40, 320), button7.getPreferredSize()));
        button7.setVisible(false);
        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        jPanel.add(button2);
        button2.setBounds(new Rectangle(new Point(150, 320), button1.getPreferredSize()));
        //---button3--//删除商品按钮
        button3.setText("\u5220\u9664\u5546\u54c1");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(430, 460), button3.getPreferredSize()));
        //---button4--//修改商品按钮
        button4.setText("\u4fee\u6539\u5546\u54c1");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(330, 460), button4.getPreferredSize()));
        //---button5--//添加商品按钮
        button5.setText("\u6dfb\u52a0\u5546\u54c1");
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(230, 460), button5.getPreferredSize()));

        final DefaultTableModel tableModel=new DefaultTableModel(getTabel.queryDate(),name){
            public boolean isCellEditable(int row,int column){
                return false;
            }
        };
        table = new JTable(tableModel);
        jScrollPane=new JScrollPane(table);
        jScrollPane.setBounds(0,0,530,450);
        contentPane.add(jScrollPane);

        System.out.println(getTabel.queryDate().length);
        System.out.println(tableModel.getColumnCount());
        //---table---//商品信息表
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                int n=table.getSelectedRow();
                String id=table.getValueAt(n,0).toString();
                String name=table.getValueAt(n,1).toString();
                String sellprice=table.getValueAt(n,2).toString();
                String buyprice = table.getValueAt(n,3).toString();
                String profit = table.getValueAt(n,4).toString();
                textField.setText(id);
                textField1.setText(name);
                textField2.setText(sellprice);
                textField3.setText(buyprice);
                textField4.setText(profit);
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) { }
        });
        textField.setEnabled(false);
        textField4.setEnabled(false);
        //添加商品
        button5.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        label5.setVisible(true);
                        label6.setVisible(false);
                        label7.setVisible(false);
                        button1.setVisible(true);
                        button6.setVisible(false);
                        button7.setVisible(false);
                        textField.setText("");
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        textField.setEnabled(true);
                        textField1.setEnabled(true);
                        textField2.setEnabled(true);
                        textField3.setEnabled(true);

                    }
                }
        );
        //修改商品
        button4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        label5.setVisible(false);
                        label6.setVisible(true);
                        label7.setVisible(false);
                        button1.setVisible(false);
                        button6.setVisible(true);
                        button7.setVisible(false);
                        textField.setText("");
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        textField.setEnabled(false);
                        textField1.setEnabled(true);
                        textField2.setEnabled(true);
                        textField3.setEnabled(true);
                    }
                }
        );
        //删除商品
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        label5.setVisible(false);
                        label6.setVisible(false);
                        label7.setVisible(true);
                        button1.setVisible(false);
                        button6.setVisible(false);
                        button7.setVisible(true);
                        textField.setText("");
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                        textField.setEnabled(false);
                        textField1.setEnabled(false);
                        textField2.setEnabled(false);
                        textField3.setEnabled(false);

                    }
                }
        );
        //确认添加
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String proid = textField.getText();//获取奶茶编号
                        String proname = textField1.getText();//获取奶茶名称
                        String sellprice = textField2.getText();//获取奶茶售价
                        String buyprice = textField3.getText();//获取奶茶造价
                        String profit = (Integer.parseInt(sellprice)-Integer.parseInt(buyprice))+"";//获取单价利润
                        if (proname.trim().length()==0||sellprice.trim().length()==0||buyprice.trim().length()==0||profit.trim().length()==0){
                            JFrame frame = new JFrame("商品添加失败");
                            JOptionPane.showMessageDialog(frame, "商品信息输入有误",
                                    "商品添加失败", JOptionPane.WARNING_MESSAGE);
                        }else{
                            Connection conn=null;
                            String url="jdbc:oracle:thin:@112.74.59.255:1521:orcl";
                            Statement stmt=null;//SQL语句对象，拼SQL
                            //对密码进行加密后再添加进数据库
                            String sql = "INSERT INTO product values('"+ proid+"','"+ proname+"','"+sellprice+"','"+ buyprice+"','"+ profit+"')";
                            if (true){//如果数据库中无该商品，就进行商品信息添加

                                try{
                                    Class.forName("oracle.jdbc.driver.OracleDriver");//
                                    conn= DriverManager.getConnection(url,"naicha","lanqiaoNAICHA");
                                    stmt=conn.createStatement();
                                    stmt.executeQuery(sql);
                                    DefaultTableModel tableMode = new DefaultTableModel(getTabel.queryDate(), name) {
                                        public boolean isCellEditable(int row, int column) {
                                            return false;
                                        }
                                    };
                                    table.setModel(tableMode);
                                    JFrame frame = new JFrame("添加商品");
                                    JOptionPane.showMessageDialog(frame, "商品添加成功",

                                            "添加商品", JOptionPane.WARNING_MESSAGE);
                                    textField3.setText("");
                                    textField.setText("");
                                    textField1.setText("");
                                    textField2.setText("");
                                    textField3.setText("");
                                    textField4.setText("");
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
                }
        );
        //确认修改
        button6.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String proid = textField.getText();//获取id
                        String proname = textField1.getText();//获取奶茶名称
                        String sellprice = textField2.getText();//获取奶茶售价
                        String buyprice = textField3.getText();//获取奶茶造价
                        String profit = (Integer.parseInt(sellprice)-Integer.parseInt(buyprice))+"";//获取单价利润
                        if (proname.trim().length()==0||sellprice.trim().length()==0||buyprice.trim().length()==0||profit.trim().length()==0){
                            JFrame frame = new JFrame("商品修改失败");
                            JOptionPane.showMessageDialog(frame, "商品信息输入有误",
                                    "商品修改失败", JOptionPane.WARNING_MESSAGE);
                        }else {
                            Connection conn = null;
                            String url = "jdbc:oracle:thin:@112.74.59.255:1521:orcl";
                            PreparedStatement stmt = null;//SQL语句对象，拼SQL
                            //对密码进行加密后再添加进数据库
                            String sql = "update  product set proname=?,sellprice=?,buyprice=?,profit=? WHERE proid=?";
                            if (true) {//如果数据库中无该商品，就进行商品信息添加
                                System.out.println("商品添加成功");
                                try {
                                    Class.forName("oracle.jdbc.driver.OracleDriver");//
                                    conn = DriverManager.getConnection(url, "naicha", "lanqiaoNAICHA");
                                    stmt = conn.prepareStatement(sql);
                                    stmt.setString(1, proname);
                                    stmt.setString(2, sellprice);
                                    stmt.setString(3, buyprice);
                                    stmt.setString(4, profit);
                                    stmt.setString(5, proid);
                                    stmt.executeUpdate();
                                    DefaultTableModel tableMode = new DefaultTableModel(getTabel.queryDate(), name) {
                                        public boolean isCellEditable(int row, int column) {
                                            return false;
                                        }
                                    };
                                    table.setModel(tableMode);
                                    JFrame frame = new JFrame("修改商品");
                                    JOptionPane.showMessageDialog(frame, "商品已修改",
                                            "修改商品", JOptionPane.WARNING_MESSAGE);
                                    textField.setText("");
                                    textField1.setText("");
                                    textField2.setText("");
                                    textField3.setText("");
                                    textField4.setText("");
                                } catch (ClassNotFoundException ex) {
                                    ex.printStackTrace();
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            } else {
                                System.out.println("已有该编号商品");
                                textField1.setText("");
                            }
                        }
                    }
                }
        );
        //确认删除
        button7.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String proid = textField.getText();//获取id
                        if (proid.trim().length()==0){
                            JFrame frame = new JFrame("商品删除失败");
                            JOptionPane.showMessageDialog(frame, "请选择要删除的商品",
                                    "商品删除失败", JOptionPane.WARNING_MESSAGE);
                        }else {
                            Connection conn = null;
                            String url = "jdbc:oracle:thin:@112.74.59.255:1521:orcl";
                            PreparedStatement stmt = null;//SQL语句对象，拼SQL
                            //对密码进行加密后再添加进数据库
                            String sql = "DELETE FROM product WHERE proid=?";
                            try {
                                Class.forName("oracle.jdbc.driver.OracleDriver");//
                                conn = DriverManager.getConnection(url, "naicha", "lanqiaoNAICHA");
                                stmt = conn.prepareStatement(sql);
                                stmt.setString(1, proid);
                                stmt.executeUpdate();
                                DefaultTableModel tableMode = new DefaultTableModel(getTabel.queryDate(), name) {
                                    public boolean isCellEditable(int row, int column) {
                                        return false;
                                    }
                                };
                                table.setModel(tableMode);
                                JFrame frame = new JFrame("删除商品");
                                JOptionPane.showMessageDialog(frame, "商品已删除",

                                        "删除商品", JOptionPane.WARNING_MESSAGE);
                                textField.setText("");
                                textField1.setText("");
                                textField2.setText("");
                                textField3.setText("");
                                textField4.setText("");
                            } catch (ClassNotFoundException ex) {
                                ex.printStackTrace();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
        );

        //----button2---//重置
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField.setText("");
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        textField4.setText("");
                    }
                }
        );

        //======== this ========
        contentPane.setLayout(null);
        setJMenuBar(menuBar1);
        contentPane.setPreferredSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private JPanel jPanel;
    private JTable table;
    private JTextField textField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    private JLabel label;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private String label5_name;

    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;

    private JScrollPane jScrollPane;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private MilkTeaBean milkTeaBean1;
    private List<MilkTeaBean>list;//
    private List<MilkTeaBean>list1;
    private JMenuBar menuBar1;
    private JMenuItem item;
    private JMenuItem item1;
    private Object[][]tableDate=null;
    private String []name ={"奶茶编号","奶茶名称","奶茶售价","奶茶造价","奶茶利润"};
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
