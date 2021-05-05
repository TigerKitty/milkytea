/*
 * Created by JFormDesigner on Tue May 04 15:33:45 CST 2021
 */

package swing.Underway;
import util.Dbutil;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class underway extends JFrame {
    public static void main(String[] args) {
        new underway();
    }
    public underway() {
        initComponents();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        DefaultTableModel tableMode = new DefaultTableModel(queryData(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableMode);
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(60, 60, scrollPane1.getPreferredSize().width, 213);

        //---- button1 ----
        button1.setText("\u5237\u65b0");
        contentPane.add(button1);
        button1.setBounds(150, 300, 90, button1.getPreferredSize().height);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel tableMode = new DefaultTableModel(queryData(), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableMode);
                    }
                }
        );

        //---- button2 ----
        button2.setText("\u786e\u8ba4\u6536\u8d27");
        contentPane.add(button2);
        button2.setBounds(330, 300, 90, 23);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm" );//设置日期格式
                        int count=table1.getSelectedRow();//获取你选中的行号（记录）
                        String ordid= table1.getValueAt(count, 0).toString();//读取你获取行号的某一列的值（也就是字段）
                        String receivetime = df.format(new Date());
                        System.out.println(receivetime);
                        Dbutil dbutil = new Dbutil();
                        String sql = "update comorder set status=? , receivetime = ? where ordid = ?";
                        PreparedStatement ptem = dbutil.getPs(sql);
                        try {
                            ptem.setString(1,"2");
                            ptem.setString(2,receivetime);
                            ptem.setString(3,ordid);
                            ptem.executeUpdate();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        } finally {
                            try {
                                ptem.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                }
        );


        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(60, 60, 452, 213);

        //---- button3 ----
        button3.setText("\u5237\u65b0");
        contentPane.add(button3);
        button3.setBounds(240, 300, 90, 23);
        button3.setVisible(false);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel tableMode = new DefaultTableModel(queryData(), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table2.setModel(tableMode);
                    }
                }
        );


        //---- button4 ----
        button4.setText("\u6d3e\u9001\u8ba2\u5355");
        button4.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 22));
        contentPane.add(button4);
        button4.setBounds(125, 10, 150, button4.getPreferredSize().height);
        button4.setBounds(125, 10, 150, button4.getPreferredSize().height);
        button4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button1.setVisible(true);
                        button2.setVisible(true);
                        button3.setVisible(false);
                        scrollPane2.setVisible(false);
                        scrollPane1.setVisible(true);
                        num = 1;
                    }
                }
        );

        //---- button5 ----
        button5.setText("\u672a\u6d3e\u9001\u8ba2\u5355");
        button5.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 22));
        contentPane.add(button5);
        button5.setBounds(285, 10, 160, 35);
        button5.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        button1.setVisible(false);
                        button2.setVisible(false);
                        button3.setVisible(true);
                        scrollPane2.setVisible(true);
                        scrollPane1.setVisible(false);
                        num = 0;
                    }
                }
        );

        contentPane.setPreferredSize(new Dimension(570, 390));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public Object[][] queryData() {
        java.util.List<Comorder> list = new ArrayList<Comorder>();
            Dbutil dbutil = new Dbutil();
            String sql = "SELECT *\n" +
                    "FROM(SELECT c.ordid,u.uname,c.ordertime,c.trantime,c.receivetime,c.status\n" +
                    "FROM comorder c,users u\n" +
                    "WHERE c.username=u.username)\n" +
                    "WHERE uname=? and status=?";

        ResultSet rs = null;
            PreparedStatement ptem = dbutil.getPs(sql);
        try {
            ptem.setString(1,"黄志国");
            ptem.setString(2, String.valueOf(num));
            rs=ptem.executeQuery();
            while (rs.next()) {//每循环一次给用户赋值
                //将数据库中用户的信息存放在集合中
                Comorder comorder = new Comorder();
                comorder.setOrdid(rs.getString("ordid"));
                comorder.setUsername(rs.getString("uname"));
                comorder.setOrdertime(rs.getString("ordertime"));
                comorder.setTrantime(rs.getString("trantime"));
                comorder.setReceivetime((rs.getString("receivetime")));
                comorder.setStatus(rs.getString("status"));
                list.add(comorder);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        data = new Object[list.size()][head.length];
        for (int i = 0; i < list.size(); i++) {//将集合中的信息放入二维数组中
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getOrdid();
                data[i][1] = list.get(i).getUsername();
                data[i][2] = list.get(i).getOrdertime();
                data[i][3] = list.get(i).getTrantime();
                data[i][4] = list.get(i).getReceivetime();
                data[i][5] = list.get(i).getStatus();
            }
        }
        return data;
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private Object[][] data = null;
    private String head[] = {"订单编号", "用户名", "下单时间","配送时间","到达时间","订单状态"};
    private int num = 1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
