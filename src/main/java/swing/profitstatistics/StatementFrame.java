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

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        label1.setVisible(true);
                        label2.setVisible(false);
                        comboBox1.setVisible(true);
                        comboBox2.setVisible(false);
                        button1.setVisible(true);
                        button2.setVisible(true);
                        button3.setVisible(false);
                        button4.setVisible(false);
                        scrollPane1.setVisible(false);
                        scrollPane2.setVisible(false);
                    }
                }
        );
        menuItem2 = new JMenuItem();
        menuItem2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        label1.setVisible(false);
                        label2.setVisible(true);
                        comboBox1.setVisible(false);
                        comboBox2.setVisible(true);
                        button1.setVisible(false);
                        button2.setVisible(false);
                        button3.setVisible(true);
                        button4.setVisible(true);
                        scrollPane1.setVisible(false);
                        scrollPane2.setVisible(false);
                    }
                }
        );
        label1 = new JLabel();

        List<DailyStateBean> list1;
        DailyState dailyState=new DailyState();
        list1=dailyState.dailystate();
        comboBoxDate1=new String[list1.size()];
        for(int i=0;i<list1.size();i++){
            comboBoxDate1[i]=list1.get(i).getDailytime();
        }
        comboBox1=new JComboBox(comboBoxDate1);
        table1 = new JTable();
        button1 = new JButton();

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
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        label2 = new JLabel();

        List<MonthlyStateBean> list2;
        MonthlyState monthlyState=new MonthlyState();
        list2=monthlyState.monthlystate();
        comboBoxDate2=new String[list2.size()];
        for(int i=0;i<list2.size();i++){
            comboBoxDate2[i]=list2.get(i).getMonthlytime();
        }
        comboBox2=new JComboBox(comboBoxDate2);
        table2 = new JTable();
        button3 = new JButton();
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
        button4 = new JButton();
        scrollPane2 = new JScrollPane();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 12));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u5229\u6da6\u7edf\u8ba1");
                menu1.setFont(menu1.getFont().deriveFont(menu1.getFont().getStyle() | Font.BOLD, menu1.getFont().getSize() + 3f));

                //---- menuItem1 ----
                menuItem1.setText("\u65e5\u62a5\u8868");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("\u6708\u62a5\u8868");
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("\u4e0b\u5355\u65f6\u95f4\uff1a");
        label1.setFont(label1.getFont().deriveFont(Font.BOLD, label1.getFont().getSize() + 2f));
        contentPane.add(label1);
        label1.setBounds(155, 5, 85, 40);
        contentPane.add(comboBox1);
        comboBox1.setBounds(245, 10, 120, 30);

        //---- button1 ----
        button1.setText("\u7edf\u8ba1\u6570\u636e");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getStyle() | Font.BOLD, button1.getFont().getSize() + 3f));
        contentPane.add(button1);
        button1.setBounds(395, 10, 110, 30);

        //---- button2 ----
        button2.setText("\u56fe\u8868\u7edf\u8ba1");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getStyle() | Font.BOLD, button2.getFont().getSize() + 3f));
        contentPane.add(button2);
        button2.setBounds(525, 10, 110, 30);

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setFont(table1.getFont().deriveFont(table1.getFont().getSize() + 5f));
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(55, 50, 695, 105);

        //---- label2 ----
        label2.setText("\u5e74\u6708\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 2f));
        contentPane.add(label2);
        label2.setBounds(165, 5, 60, 40);
        contentPane.add(comboBox2);
        comboBox2.setBounds(235, 10, 125, 30);

        //---- button3 ----
        button3.setText("\u7edf\u8ba1\u6570\u636e");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getStyle() | Font.BOLD, button3.getFont().getSize() + 2f));
        contentPane.add(button3);
        button3.setBounds(405, 10, 95, 30);

        //---- button4 ----
        button4.setText("\u56fe\u8868\u7edf\u8ba1");
        button4.setFont(button4.getFont().deriveFont(button4.getFont().getStyle() | Font.BOLD, button4.getFont().getSize() + 3f));
        contentPane.add(button4);
        button4.setBounds(530, 10, 115, 30);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(55, 50, 695, 110);

        contentPane.setPreferredSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(getOwner());
        label1.setVisible(false);
        label2.setVisible(false);
        comboBox1.setVisible(false);
        comboBox2.setVisible(false);
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        button4.setVisible(false);
        scrollPane1.setVisible(false);
        scrollPane2.setVisible(false);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JLabel label1;
    private JComboBox comboBox1;
    private JButton button1;
    private JButton button2;
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
