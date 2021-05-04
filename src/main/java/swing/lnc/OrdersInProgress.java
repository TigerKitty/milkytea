/*
 * Created by JFormDesigner on Mon May 03 20:39:13 CST 2021
 */

package swing.lnc;

import entity.lnc.ComOrder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class OrdersInProgress extends JFrame {
    public static void main(String[] args) {
        new OrdersInProgress();
    }
    public OrdersInProgress() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(queryData1(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
//        TableColumn Column1 = table1.getColumnModel().getColumn(3);
//        Column1.setPreferredWidth(150);
//        Column1.setMaxWidth(150);
//        Column1.setMinWidth(150);
//        TableColumn Column2 = table1.getColumnModel().getColumn(2);
//        Column2.setPreferredWidth(150);
//        Column2.setMaxWidth(150);
//        Column2.setMinWidth(150);
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        DefaultTableModel tableMode2 = new DefaultTableModel(queryData2(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table2.setModel(tableMode2);
//        TableColumn Column3 = table2.getColumnModel().getColumn(3);
//        Column3.setPreferredWidth(150);
//        Column3.setMaxWidth(150);
//        Column3.setMinWidth(150);
//        TableColumn Column4 = table2.getColumnModel().getColumn(2);
//        Column4.setPreferredWidth(150);
//        Column4.setMaxWidth(150);
//        Column4.setMinWidth(150);
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();


        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u672a\u6d3e\u9001\u8ba2\u5355");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 13f));
        contentPane.add(label1);
        label1.setBounds(215, 10, 150, 25);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 55, 550, 125);

        //---- label2 ----
        label2.setText("\u6b63\u5728\u6d3e\u9001\u8ba2\u5355");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 13f));
        contentPane.add(label2);
        label2.setBounds(210, 210, 185, 25);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(25, 255, 550, 135);

        //---- button1 ----
        button1.setText("\u5f00\u59cb\u6d3e\u9001");
        contentPane.add(button1);
        button1.setBounds(635, 130, 95, 40);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count=table1.getSelectedRow();//获取你选中的行号（记录）
                        if(count == -1){
                            return;
                        }
                        String ordid= table1.getValueAt(count, 0).toString();//读取你获取行号的某一列的值（也就是字段）
                        Connection conn = null;
                        String url = "jdbc:oracle:thin:@112.74.59.255:1521:orcl";
                        PreparedStatement pstmt = null;//sql语句对象
                        String sql = "update comorder set status= ? where ordid = ?";//占位符
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            conn = DriverManager.getConnection(url,"naicha","lanqiaoNAICHA");
                            pstmt = conn.prepareStatement(sql);
                            pstmt.setString(1,"1");
                            pstmt.setString(2,ordid);
                            pstmt.executeUpdate();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        DefaultTableModel tableMode1 = new DefaultTableModel(queryData1(), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableMode1);

                        DefaultTableModel tableMode2 = new DefaultTableModel(queryData2(), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table2.setModel(tableMode2);
                    }
                }
        );

        //---- button2 ----
        button2.setText("\u5237\u65b0");
        contentPane.add(button2);
        button2.setBounds(635, 215, 95, 40);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel tableModel = new DefaultTableModel(queryData1(), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableModel);

                        DefaultTableModel tableMode2 = new DefaultTableModel(queryData2(), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table2.setModel(tableMode2);
                    }
                }
        );

        //---- button3 ----
        button3.setText("\u64a4\u9500");
        contentPane.add(button3);
        button3.setBounds(635, 300, 95, 40);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count=table2.getSelectedRow();//获取你选中的行号（记录）
                        if(count == -1){
                            return;
                        }
                        String ordid= table2.getValueAt(count, 0).toString();//读取你获取行号的某一列的值（也就是字段）
                        System.out.println("aaaaaaa" +ordid);
                        Connection conn = null;
                        String url = "jdbc:oracle:thin:@112.74.59.255:1521:orcl";
                        PreparedStatement pstmt = null;//sql语句对象
                        String sql = "update comorder set status= ? where ordid = ?";//占位符
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            conn = DriverManager.getConnection(url,"naicha","lanqiaoNAICHA");
                            pstmt = conn.prepareStatement(sql);
                            pstmt.setString(1,"0");
                            pstmt.setString(2,ordid);
                            pstmt.executeUpdate();
                        } catch (ClassNotFoundException ex) {
                            ex.printStackTrace();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        DefaultTableModel tableMode1 = new DefaultTableModel(queryData1(), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableMode1);

                        DefaultTableModel tableMode2 = new DefaultTableModel(queryData2(), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table2.setModel(tableMode2);
                    }
                }
        );

        contentPane.setPreferredSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    //方法一，得到status为0的记录
    public Object[][] queryData1() {
        java.util.List<ComOrder> list = new ArrayList<ComOrder>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@112.74.59.255:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT * FROM comorder";
//        System.out.println("即将执行的sql：" + sql);
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "naicha", "lanqiaoNAICHA");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //循环一次就是一个对象
                if(Integer.parseInt(rs.getString("status")) == 0){
                    ComOrder co = new ComOrder();
                    co.setOrdid(rs.getString("ordid"));
                    co.setUsername(getRealName(rs.getString("USERNAME")));
                    co.setOrdertime(rs.getString("ordertime"));
                    co.setTrantime(rs.getString("trantime"));
                    co.setStatus("未派送");
                    list.add(co);
                }
            }
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源：数据库连接很昂贵
            try {
                rs.close();
                stmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        data = new Object[list.size()][head.length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getOrdid();
                data[i][1] = list.get(i).getUsername();
                data[i][2] = list.get(i).getOrdertime();
                data[i][3] = list.get(i).getTrantime();
                data[i][4] = list.get(i).getStatus();
            }
        }
        return data;
    }
    //方法二，得到status为1的记录
    public Object[][] queryData2() {
        java.util.List<ComOrder> list = new ArrayList<ComOrder>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@112.74.59.255:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT * FROM comorder";
//        System.out.println("即将执行的sql：" + sql);
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "naicha", "lanqiaoNAICHA");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                //循环一次就是一个对象
                if(Integer.parseInt(rs.getString("status")) == 1){
                    ComOrder co = new ComOrder();
                    co.setOrdid(rs.getString("ordid"));
                    co.setUsername(getRealName(rs.getString("USERNAME")));
                    co.setOrdertime(rs.getString("ordertime"));
                    co.setTrantime(rs.getString("trantime"));
                    co.setStatus("正在派送");
                    list.add(co);
                }
            }
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源：数据库连接很昂贵
            try {
                rs.close();
                stmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        data = new Object[list.size()][head.length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getOrdid();
                data[i][1] = list.get(i).getUsername();
                data[i][2] = list.get(i).getOrdertime();
                data[i][3] = list.get(i).getTrantime();
                data[i][4] = list.get(i).getStatus();
            }
        }
        return data;
    }

    //方法三，根据username得到uname
    public String getRealName(String username){
        Connection conn = null;
        String url = "jdbc:oracle:thin:@112.74.59.255:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = sql = "select uname from users where username = '" + username + "'";
//        System.out.println("即将执行的sql：" + sql);
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "naicha", "lanqiaoNAICHA");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            rs.next();
            return rs.getString(1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private Object[][] data = null;
    private String head[] = {"订单号", "用户名", "下单时间", "派送时间","状态"};
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
