/*
 * Created by JFormDesigner on Mon May 03 20:39:13 CST 2021
 *//*

package swing.lnc;
import entity.lnc.db.ComOrder;
import entity.lnc.db.Deliver;
import util.Dbutil;
import util.lnc.ReadFile;
import util.lnc.SendMassage;
import util.lnc.WriteFile;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

*/
/**
 * 商家正在进行的订单：商家在此界面查看正在进行的订单，订单状态为“0” 或者“1”
 * 可以将订单状态由未派送改为正在派送，也可以撤销派送，变回未派送
 * 自动刷新
 * 联系配送员
 * 实现语音播报
 *//*

public class OrdersInProgressFrame extends JFrame {
    public static void main(String[] args) {
        new OrdersInProgressFrame();
    }
    public OrdersInProgressFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        DefaultTableModel tableMode1 = new DefaultTableModel(queryData(0), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableMode1);
        DefaultTableModel tableMode2 = new DefaultTableModel(queryData(1), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table2.setModel(tableMode2);

//利用线程实现自动刷新
        FleshThread fleshThread = new FleshThread(this);
        fleshThread.start();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u672a\u6d3e\u9001\u8ba2\u5355");//未派送订单标签
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
        label2.setText("\u6b63\u5728\u6d3e\u9001\u8ba2\u5355");//正在派送订单标签
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
        button1.setText("\u5f00\u59cb\u6d3e\u9001");//“开始派送”按钮
        contentPane.add(button1);
        button1.setBounds(635, 130, 95, 40);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count=table1.getSelectedRow();//获取你选中的行号（记录）
                        if(count < 0 || count >=table1.getRowCount()){//没选中任何行则没有变化
                            return;
                        }
                        String ordid= table1.getValueAt(count, 0).toString();//读取你获取行号的某一列的值（也就是字段）
                        Dbutil dbutil = new Dbutil();//连接数据库
                        String sql = "update comorder set status= ? ,trantime = ? where ordid = ?";//?占位符
                        PreparedStatement pstmt = dbutil.getPs(sql);
                        try {
                            pstmt.setString(1,"1");
                            pstmt.setString(2,getCurrentTime());
                            pstmt.setString(3,ordid);
                            pstmt.executeUpdate();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }finally {
                            try {
                                pstmt.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }

                        //发送短信
                        Deliver deliver = new Deliver();
                        SendMassage sendMassage = new SendMassage();
                        String send = sendMassage.sendSMS(deliver.phone3,ordid);
                        System.out.println(send);


                        //刷新表格

                        DefaultTableModel tableMode1 = new DefaultTableModel(queryData(0), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableMode1);

                        DefaultTableModel tableMode2 = new DefaultTableModel(queryData(1), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table2.setModel(tableMode2);

                        //播报语音
                        String s = "订单号为" + ordid + "的外卖开始配送";
                        new WriteFile().writeFile(s);
                        try {
                            new ReadFile().readFile();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
        );

        //---- button2 ----
        button2.setText("\u5237\u65b0");//“更新”按钮，刷新两个表
        contentPane.add(button2);
        button2.setBounds(635, 215, 95, 40);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel tableModel = new DefaultTableModel(queryData(0), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableModel);

                        DefaultTableModel tableMode2 = new DefaultTableModel(queryData(1), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table2.setModel(tableMode2);
                    }
                }
        );

        //---- button3 ----
        button3.setText("\u64a4\u9500\u6d3e\u9001");//“撤销派送”按钮
        contentPane.add(button3);
        button3.setBounds(635, 300, 95, 40);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count=table2.getSelectedRow();//获取你选中的行号（记录）
                        if(count < 0 || count >=table2.getRowCount()){//没选中任何行则没有变化
                            return;
                        }
                        String ordid= table2.getValueAt(count, 0).toString();//读取你获取行号的某一列的值（也就是字段）
                        Dbutil dbutil = new Dbutil();//连接数据库
                        String sql = "update comorder set status= ?  where ordid = ?";//?占位符
                        PreparedStatement pstmt = dbutil.getPs(sql);
                        try {
                            pstmt.setString(1,"0");
                            pstmt.setString(2,ordid);
                            pstmt.executeUpdate();

                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }finally {
                            try {
                                pstmt.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }

                        DefaultTableModel tableMode1 = new DefaultTableModel(queryData(0), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableMode1);

                        DefaultTableModel tableMode2 = new DefaultTableModel(queryData(1), head) {
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

    //方法一，得到status为0或者1的记录
    public Object[][] queryData(int num) {//num用于控制未派送表和正在派送表的结果，0表示未派送表，1表示正在派送表
        java.util.List<ComOrder> list = new ArrayList<ComOrder>();
        Dbutil dbutil = new Dbutil();
        String sql = "SELECT * FROM comorder Order by ordertime";
        PreparedStatement pstmt = dbutil.getPs(sql);
        try {
            ResultSet rs = dbutil.getRs(pstmt.executeQuery());
            if(num == 0){
                while (rs.next()) {
                    //循环一次就是一个对象
                    if(Integer.parseInt(rs.getString("status")) == num){
                        ComOrder co = new ComOrder();
                        co.setOrdid(rs.getString("ordid"));
                        co.setUsername(getRealName(rs.getString("USERNAME")*/
/*方法二*//*
));
                        co.setOrdertime(rs.getString("ordertime"));
                        co.setTrantime(rs.getString("trantime"));
                        co.setStatus("未派送");
                        list.add(co);
                    }
                }
            }else if(num == 1){
                while (rs.next()) {
                    //循环一次就是一个对象
                    if(Integer.parseInt(rs.getString("status")) == num){
                        ComOrder co = new ComOrder();
                        co.setOrdid(rs.getString("ordid"));
                        co.setUsername(getRealName(rs.getString("USERNAME")*/
/*方法二*//*
));
                        co.setOrdertime(rs.getString("ordertime"));
                        co.setTrantime(rs.getString("trantime"));
                        co.setStatus("正在派送");
                        list.add(co);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
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

    //方法二，根据username得到uname
    public String getRealName(String username){
        java.util.List<ComOrder> list = new ArrayList<ComOrder>();
        Dbutil dbutil = new Dbutil();
        String sql = sql = "select uname from users where username = ?";
        PreparedStatement pstmt = dbutil.getPs(sql);

        try {
            pstmt.setString(1,username);
            ResultSet rs = dbutil.getRs(pstmt.executeQuery());
            rs.next();
            return rs.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            try {
                pstmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    //方法三，获取当前时间
    public String getCurrentTime(){
        Date ss = new Date();
        //        System.out.println("一般日期输出：" + ss);
//        System.out.println("时间戳：" + ss.getTime());
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format0.format(ss.getTime());//这个就是把时间戳经过处理得到期望格式的时间
        return time;
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

    public String[] getHead() {
        return head;
    }


    public JTable getTable1() {
        return table1;
    }

    public JTable getTable2() {
        return table2;
    }

}
class FleshThread extends Thread{
    private OrdersInProgressFrame oipf;
    public FleshThread(OrdersInProgressFrame oipf){
        this.oipf = oipf;
    }
    @Override
    public void run() {
        while(true){
            try {
                sleep(5000);
                DefaultTableModel tableModel = new DefaultTableModel(oipf.queryData(0),oipf.getHead()) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                DefaultTableModel tableMode2 = new DefaultTableModel(oipf.queryData(1), oipf.getHead()) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                oipf.getTable1().setModel(tableModel);
                oipf.getTable2().setModel(tableMode2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
*/
