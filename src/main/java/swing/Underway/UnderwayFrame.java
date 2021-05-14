/*
 * Created by JFormDesigner on Tue May 04 15:33:45 CST 2021
 */

package swing.Underway;
import dao.Underway.Automatic;
import dao.Underway.GetDate;
import dao.Underway.Jtype;
import dao.Underway.Refresh;
import util.Dbutil;;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 * @author 1 用户查看正在进行的订单
 */
public class UnderwayFrame extends JFrame {
    public static Dbutil dbutil = new Dbutil();
    public static final GetDate getDate = new GetDate();
    public static Automatic automatic = new Automatic();
    public static final Refresh refresh = new Refresh();
    public static final Jtype jtype=new Jtype();
    public static void main(String[] args) {
        new UnderwayFrame();
        Runnable runnable = new MyRunnable(jtype.table1);
        Thread thread = new Thread(runnable);
        thread.start();
    }
    public UnderwayFrame() {
        initComponents();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        this.setTitle("我的订单信息");
        jtype.jtype();
        automatic.Automatic(jtype.table1);
        refresh.Refresh(jtype.table1);
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            jtype.scrollPane1.setViewportView(jtype.table1);
        }
        contentPane.add(jtype.scrollPane1);
        jtype.scrollPane1.setBounds(125, 100, 650, 350);

        //---- button1 ----
        jtype.button1.setText("\u5237\u65b0");//刷新按钮
        contentPane.add(jtype.button1);
        jtype.button1.setBounds(200, 500, 150, 60);
        jtype.button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        refresh.Refresh(jtype.table1);
                    }
                }
        );

        //---- button2 ----
        jtype.button2.setText("\u786e\u8ba4\u6536\u8d27");//确认收货
        contentPane.add(jtype.button2);
        jtype.button2.setBounds(550, 500, 150, 60);
        jtype.button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm" );//设置日期格式
                        int count=jtype.table1.getSelectedRow();//获取你选中的行号（记录）
                        String ordid= jtype.table1.getValueAt(count, 0).toString();//读取你获取行号的某一列的值（也就是字段）
                        String receivetime = df.format(new Date());

                        String sql = "update comorder set status=? , receivetime = ? where ordid = ?";
                        PreparedStatement ptem = dbutil.getPs(sql);
                        try {
                            ptem.setString(1,"2");
                            ptem.setString(2,receivetime);
                            ptem.setString(3,ordid);
                            ptem.executeUpdate();
                            refresh.Refresh(jtype.table1);
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
            jtype.scrollPane2.setViewportView(jtype.table2);
        }
        contentPane.add(jtype.scrollPane2);
        jtype.scrollPane2.setBounds(125, 100, 650, 350);

        //---- button3 ----
        jtype.button3.setText("\u5237\u65b0");//刷新
        contentPane.add(jtype.button3);
        jtype.button3.setBounds(350, 500, 150, 60);
        jtype.button3.setVisible(false);
        jtype.button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        refresh.Refresh(jtype.table2);
                    }
                }
        );


        //---- button4 ----
        jtype.button4.setText("\u6d3e\u9001\u8ba2\u5355");//正在派送
        jtype.button4.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 22));
        contentPane.add(jtype.button4);
        jtype.button4.setBounds(200, 20, 200, 60);
        jtype.button4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getDate.num=1;
                        jtype.button1.setVisible(true);
                        jtype.button2.setVisible(true);
                        jtype.button3.setVisible(false);
                        jtype.scrollPane2.setVisible(false);
                        jtype.scrollPane1.setVisible(true);
                        refresh.Refresh(jtype.table1);
                    }
                }
        );

        //---- button5 ----
        jtype.button5.setText("\u672a\u6d3e\u9001\u8ba2\u5355");//未派送订单
        jtype.button5.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 22));
        contentPane.add(jtype.button5);
        jtype.button5.setBounds(500, 20, 200, 60);
        jtype.button5.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        getDate.num=0;
                        jtype.button1.setVisible(false);
                        jtype.button2.setVisible(false);
                        jtype.button3.setVisible(true);
                        jtype.scrollPane2.setVisible(true);
                        jtype.scrollPane1.setVisible(false);
                        refresh.Refresh(jtype.table2);
                    }
                }
        );

        contentPane.setPreferredSize(new Dimension(900, 600));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables


    // JFormDesigner - End of variables declaration  //GEN-END:variables
}