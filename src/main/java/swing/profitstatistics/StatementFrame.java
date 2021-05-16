/*
 * Created by JFormDesigner on Wed May 05 16:53:44 CST 2021
 */

package swing.profitstatistics;

import dao.profit.DailyState;
import dao.profit.DailyStatis;
import dao.profit.MonthlyState;
import dao.profit.MonthlyStatis;
import entity.profit.DailyStateBean;
import entity.profit.DailyStatisBean;
import entity.profit.MonthlyStateBean;
import entity.profit.MonthlyStatisBean;
import swing.lnc.OrdersInProgressFrame;
import swing.record.record;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author lbr
 * 利润统计界面
 */
public class StatementFrame extends JFrame {
    public static void main(String[] args) {
        StatementFrame statementFrame =new StatementFrame();
    }
    public StatementFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
//        menuBar1 = new JMenuBar();
//        menuBar2 = new JMenuBar();
//        menu1 = new JMenu();
//        menuItem1 = new JMenuItem();//日统计菜单项
//        menuItem1.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent actionEvent) {
//                        label1.setVisible(true);
//                        label2.setVisible(false);
//                        comboBox1.setVisible(true);
//                        comboBox2.setVisible(false);
//                        button1.setVisible(true);
//                        button5.setVisible(true);
//                        button3.setVisible(false);
//                        button4.setVisible(false);
//                        button6.setVisible(false);
//                        scrollPane1.setVisible(false);
//                        scrollPane2.setVisible(false);
//                    }
//                }
//        );
//        menuItem2 = new JMenuItem();//月统计菜单项
//        menuItem2.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent actionEvent) {
//                        label1.setVisible(false);
//                        label2.setVisible(true);
//                        comboBox1.setVisible(false);
//                        comboBox2.setVisible(true);
//                        button1.setVisible(false);
//                        button5.setVisible(false);
//                        button3.setVisible(true);
//                        button4.setVisible(true);
//                        button6.setVisible(true);
//                        scrollPane1.setVisible(false);
//                        scrollPane2.setVisible(false);
//                    }
//                }
//        );
        this.setTitle("利润统计");
        label1 = new JLabel();
        /*
        下拉框显示每天时间
         */
        List<DailyStateBean> list1;
        DailyState dailyState=new DailyState();
        list1=dailyState.dailystate();
        comboBoxDate1=new String[list1.size()];
        for(int i=0;i<list1.size();i++){
            comboBoxDate1[i]=list1.get(i).getDailytime();
        }
        comboBox1=new JComboBox(comboBoxDate1);

        table1 = new JTable();//显示每天统计数据的表格
        button1 = new JButton();//统计数据按钮
        /*
        下拉框选择某天后点击统计数据，将统计到的"时间（日）","日订单量","日销量","日销售额","日利润"显示在table1
         */
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        scrollPane1.setVisible(true);
                        scrollPane2.setVisible(false);
                        int index = comboBox1.getSelectedIndex();
                        String box1Value = comboBoxDate1[index];
                        List<DailyStatisBean> list3 ;
                        DailyStatis dailyStatis=new DailyStatis();
                        list3=dailyStatis.dailystatis(box1Value);
                        String []name1 ={"时间（日）","日订单量","日销量","日销售额","日利润"};
                        Object tableDate1[][]=new Object[list3.size()][name1.length];
                        for(int i=0;i<list3.size();i++) {
                            for (int j = 0; j < name1.length; j++) {
                                tableDate1[i][0] = box1Value;
                                tableDate1[i][1] = list3.get(i).getDorderquantity();
                                tableDate1[i][2] = list3.get(i).getDsalesvolume();
                                tableDate1[i][3] = list3.get(i).getDsales();
                                tableDate1[i][4] = list3.get(i).getDprofit();
                            }
                        }
                        DefaultTableModel tableModel = new DefaultTableModel(tableDate1, name1) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableModel);
                    }
                }
        );
        scrollPane1 = new JScrollPane();
        label2 = new JLabel();
        button5 = new JButton();//日数据导出按钮
        button6 = new JButton();//月数据导出按钮

        /*
         选中日统计数据将其加入日报表界面的表格
         */
        table1.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {
                    }

                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {
                        DailyStatisBean dailyStatisBean1=new DailyStatisBean();
                        int count=table1.getSelectedRow();
                        String dtime1=table1.getValueAt(count,0).toString();
                        Integer dorderquantity1=Integer.parseInt(table1.getValueAt(count,1).toString());
                        Integer dsalesvolume1=Integer.parseInt(table1.getValueAt(count,2).toString());
                        Integer dsales1=Integer.parseInt(table1.getValueAt(count,3).toString());
                        Integer dprofit1=Integer.parseInt(table1.getValueAt(count,4).toString());
                        dailyStatisBean1.setDtime(dtime1);
                        dailyStatisBean1.setDorderquantity(dorderquantity1);
                        dailyStatisBean1.setDsalesvolume(dsalesvolume1);
                        dailyStatisBean1.setDsales(dsales1);
                        dailyStatisBean1.setDprofit(dprofit1);
                        list5.add(dailyStatisBean1);
                    }

                    @Override
                    public void mouseReleased(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseExited(MouseEvent mouseEvent) {

                    }
                }
        );
        /*
        点击导出数据，跳转到日报表界面
         */
        button5.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        AllDayStatisFrame allDayStatisFrame=new AllDayStatisFrame(list5);
                        allDayStatisFrame.setVisible(true);
                    }
                }
        );

        /*
        下拉框显示每月时间
         */
        List<MonthlyStateBean> list2;
        MonthlyState monthlyState=new MonthlyState();
        list2=monthlyState.monthlystate();
        comboBoxDate2=new String[list2.size()];
        for(int i=0;i<list2.size();i++){
            comboBoxDate2[i]=list2.get(i).getMonthlytime();
        }
        comboBox2=new JComboBox(comboBoxDate2);

        table2 = new JTable();//显示每月统计数据的表格
        button3 = new JButton();//统计数据按钮
        /*
        下拉框选择某月后点击统计数据，将统计到的"时间（月）","月订单量","月销量","月销售额","月利润"显示在table2
         */
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        scrollPane1.setVisible(false);
                        scrollPane2.setVisible(true);
                        int index1 = comboBox2.getSelectedIndex();
                        String box2Value = comboBoxDate2[index1];
                        List<MonthlyStatisBean> list4 ;
                        MonthlyStatis monthlyStatis=new MonthlyStatis();
                        list4=monthlyStatis.monthlystatis(box2Value);
                        String []name2 ={"时间（月）","月订单量","月销量","月销售额","月利润"};
                        Object tableDate2[][]=new Object[list4.size()][name2.length];
                        for(int i=0;i<list4.size();i++) {
                            for (int j = 0; j < name2.length; j++) {
                                tableDate2[i][0] = box2Value;
                                tableDate2[i][1] = list4.get(i).getMorderquantity();
                                tableDate2[i][2] = list4.get(i).getMsalesvolume();
                                tableDate2[i][3] = list4.get(i).getMsales();
                                tableDate2[i][4] = list4.get(i).getMprofit();
                            }
                        }
                        DefaultTableModel tableModel2 = new DefaultTableModel(tableDate2, name2) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table2.setModel(tableModel2);
                    }
                }
        );
        button4 = new JButton();//图表统计
        scrollPane2 = new JScrollPane();

        /*
        每种奶茶月销量图表统计
         */
        button4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        int index1 = comboBox2.getSelectedIndex();
                        String box = comboBoxDate2[index1];
                        MSoleNUM mSoleNUM=new MSoleNUM("奶茶月销量图",box) ;
                        mSoleNUM.setVisible(true);
                        mSoleNUM.pack();//以合适的大小显示
                    }
                }
        );

        /*
         选中月统计数据将其加入月报表界面的表格
         */
        table2.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent mouseEvent) {
                    }

                    @Override
                    public void mousePressed(MouseEvent mouseEvent) {
                        MonthlyStatisBean monthlyStatisBean1=new MonthlyStatisBean();
                        int count=table2.getSelectedRow();
                        String mtime1=table2.getValueAt(count,0).toString();
                        Integer morderquantity1=Integer.parseInt(table2.getValueAt(count,1).toString());
                        Integer msalesvolume1=Integer.parseInt(table2.getValueAt(count,2).toString());
                        Integer msales1=Integer.parseInt(table2.getValueAt(count,3).toString());
                        Integer mprofit1=Integer.parseInt(table2.getValueAt(count,4).toString());
                        monthlyStatisBean1.setMtime(mtime1);
                        monthlyStatisBean1.setMorderquantity(morderquantity1);
                        monthlyStatisBean1.setMsalesvolume(msalesvolume1);
                        monthlyStatisBean1.setMsales(msales1);
                        monthlyStatisBean1.setMprofit(mprofit1);
                        list6.add(monthlyStatisBean1);
                    }

                    @Override
                    public void mouseReleased(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent mouseEvent) {

                    }

                    @Override
                    public void mouseExited(MouseEvent mouseEvent) {

                    }
                }
        );
        /*
        点击导出数据，跳转到月报表界面
         */
        button6.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        AllMonthStatisFrame allMonthStatisFrame=new AllMonthStatisFrame(list6);
                        allMonthStatisFrame.setVisible(true);
                    }
                }
        );

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 12));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
//        {
////
////            //======== menu1 ========
////            {
////                menu1.setText("\u5229\u6da6\u7edf\u8ba1");
////                menu1.setFont(menu1.getFont().deriveFont(menu1.getFont().getStyle() | Font.BOLD, menu1.getFont().getSize() + 3f));
////
////                //---- menuItem1 ----
////                menuItem1.setText("日统计");
////                menu1.add(menuItem1);
////
////                //---- menuItem2 ----
////                menuItem2.setText("月统计");
////                menu1.add(menuItem2);
////            }
////            menuBar1.add(menu1);
////        }
        menuBar1 = new JMenuBar();
        JMenuItem menu1 = new JMenu("日统计");
        menuBar1.add(menu1);
        menu1.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) { }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        label1.setVisible(true);
                        label2.setVisible(false);
                        comboBox1.setVisible(true);
                        comboBox2.setVisible(false);
                        button1.setVisible(true);
                        button5.setVisible(true);
                        button3.setVisible(false);
                        button4.setVisible(false);
                        button6.setVisible(false);
                        scrollPane1.setVisible(false);
                        scrollPane2.setVisible(false);
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });

        JMenuItem menu2 = new JMenu("月统计");
        menuBar1.add(menu2);
        menu2.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) { }
                    @Override
                    public void mousePressed(MouseEvent e) {  label1.setVisible(false);
                        label2.setVisible(true);
                        comboBox1.setVisible(false);
                        comboBox2.setVisible(true);
                        button1.setVisible(false);
                        button5.setVisible(false);
                        button3.setVisible(true);
                        button4.setVisible(true);
                        button6.setVisible(true);
                        scrollPane1.setVisible(false);
                        scrollPane2.setVisible(false);}
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });
        setJMenuBar(menuBar1);

        contentPane.add(button5);
        //---- label1 ----
        label1.setText("\u4e0b\u5355\u65f6\u95f4\uff1a");
        label1.setFont(label1.getFont().deriveFont(Font.BOLD, label1.getFont().getSize() + 2f));
        contentPane.add(label1);
        label1.setBounds(135, 5, 85, 40);
        contentPane.add(comboBox1);
        comboBox1.setBounds(220, 10, 120, 30);

        //---- button1统计数据（日） ----
        button1.setText("\u7edf\u8ba1\u6570\u636e");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 3f));
        contentPane.add(button1);
        button1.setBounds(380, 10, 110, 30);

        //======== scrollPane1 ========
        {

            //---- table1显示日统计数据表格 ----
            table1.setFont(table1.getFont().deriveFont(table1.getFont().getSize() + 5f));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(55, 50, 695, 105);

        //---- label2 ----
        label2.setText("\u5e74\u6708\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 2f));
        contentPane.add(label2);
        label2.setBounds(100, 5, 60, 40);
        contentPane.add(comboBox2);
        comboBox2.setBounds(170, 10, 125, 30);

        //---- button3统计数据（月） ----
        button3.setText("\u7edf\u8ba1\u6570\u636e");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getStyle() | Font.BOLD, button3.getFont().getSize() + 2f));
        contentPane.add(button3);
        button3.setBounds(320, 10, 105, 30);

        //---- button4 图表统计----
        button4.setText("\u56fe\u8868\u7edf\u8ba1");
        button4.setFont(button4.getFont().deriveFont(button4.getFont().getStyle() | Font.BOLD, button4.getFont().getSize() + 3f));
        contentPane.add(button4);
        button4.setBounds(455, 10, 105, 30);

        //---- button5导出数据（日） ----
        button5.setText("导出数据");
        button5.setFont(button5.getFont().deriveFont(button5.getFont().getStyle() | Font.BOLD, button5.getFont().getSize() + 3f));
        contentPane.add(button5);
        button5.setBounds(530, 10, 105, 30);

        //---- button6导出数据（月） ----
        button6.setText("导出数据");
        button6.setFont(button6.getFont().deriveFont(button6.getFont().getStyle() | Font.BOLD, button6.getFont().getSize() + 3f));
        contentPane.add(button6);
        button6.setBounds(590, 10, 105, 30);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(55, 50, 695, 110);

        contentPane.setPreferredSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(getOwner());
        label1.setVisible(true);
        label2.setVisible(false);
        comboBox1.setVisible(true);
        comboBox2.setVisible(false);
        button1.setVisible(true);
        button5.setVisible(true);
        button3.setVisible(false);
        button4.setVisible(false);
        button6.setVisible(false);
        scrollPane1.setVisible(false);
        scrollPane2.setVisible(false);

        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar1;
    private JMenuBar menuBar2;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JLabel label1;
    private JComboBox comboBox1;
    private JButton button1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label2;
    private JComboBox comboBox2;
    private JButton button3;
    private JButton button4;
    private JScrollPane scrollPane2;
    private JTable table2;
    private  String[]comboBoxDate1;
    private  String[]comboBoxDate2;
    private JButton button5;
    private JButton button6;
    List<DailyStatisBean> list5=new ArrayList<DailyStatisBean>();
    List<MonthlyStatisBean> list6=new ArrayList<MonthlyStatisBean>();
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}