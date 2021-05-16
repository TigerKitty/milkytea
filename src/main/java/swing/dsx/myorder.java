/*
 * Created by JFormDesigner on Thu May 06 20:40:33 CST 2021
 */

package swing.dsx;


import dao.order.getDaily;
import entity.dsx.orderBean;

import javafx.scene.control.ComboBox;
import util.Dbutil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
;

/**
 * @author 1
 */
public class myorder extends JFrame {
    public static void main(String[] args) { myorder myorder=new myorder(); }
    public myorder() {
        initComponents();
    }
    private void initComponents() {
        this.setTitle("历史记录");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        list2 = getDaily.getDailyList();
        comboBoxDate=new String[list2.size()];
        for(int i=0;i<list2.size();i++){
            comboBoxDate[i]=list2.get(i);
        }
        comboBox=new JComboBox(comboBoxDate);
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        //======== scrollPane1 ========
        {
            table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(130, 150, 550, 155);

        //---- label1 ----
        label1.setText("\u6211\u7684\u8ba2\u5355");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 18f));
        contentPane.add(label1);
        label1.setBounds(338, 25, 135, 35);

        contentPane.add(comboBox);
        comboBox.setBounds(340, 80, 122, 30);
        comboBox.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int index=comboBox.getSelectedIndex();
                        String select=comboBoxDate[index];
                        list = getDaily.getListByDaily(select);
                        Object[][]tableDate=new Object[list.size()][6];
                        for(int i=0;i<list.size();i++){
                            tableDate[i][0] = list.get(i).getOrdid();
                            tableDate[i][1] = list.get(i).getProname();
                            tableDate[i][2] = list.get(i).getSellprice();
                            tableDate[i][3] = list.get(i).getDetailnum();
                            tableDate[i][4] = list.get(i).getDetailprice();
                            tableDate[i][5] = list.get(i).getOrdertime();
                            //tableDate[i][6] = list.get(i).getUsername();
                        }
                        DefaultTableModel tableModel=new DefaultTableModel(tableDate,name){
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableModel);
                        table1.getColumnModel().getColumn(0).setPreferredWidth(100);
                        table1.getColumnModel().getColumn(1).setPreferredWidth(70);
                        table1.getColumnModel().getColumn(2).setPreferredWidth(15);
                        table1.getColumnModel().getColumn(3).setPreferredWidth(15);
                        table1.getColumnModel().getColumn(4).setPreferredWidth(15);
                        table1.getColumnModel().getColumn(5).setPreferredWidth(125);
                    }
                }
        );
        contentPane.setPreferredSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        list = getDaily.getList();
        Object[][]tableDate=new Object[list.size()][6];
        for(int i=0;i<list.size();i++){
            tableDate[i][0] = list.get(i).getOrdid();
            tableDate[i][1] = list.get(i).getProname();
            tableDate[i][2] = list.get(i).getSellprice();
            tableDate[i][3] = list.get(i).getDetailnum();
            tableDate[i][4] = list.get(i).getDetailprice();
            tableDate[i][5] = list.get(i).getOrdertime();
            //tableDate[i][6] = list.get(i).getUsername();
        }
        DefaultTableModel tableModel=new DefaultTableModel(tableDate,name){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
        table1.getColumnModel().getColumn(0).setPreferredWidth(100);
        table1.getColumnModel().getColumn(1).setPreferredWidth(70);
        table1.getColumnModel().getColumn(2).setPreferredWidth(15);
        table1.getColumnModel().getColumn(3).setPreferredWidth(15);
        table1.getColumnModel().getColumn(4).setPreferredWidth(15);
        table1.getColumnModel().getColumn(5).setPreferredWidth(125);
       // table1.getColumnModel().getColumn(6).setPreferredWidth(50);
        table1.setModel(tableModel);
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private orderBean orderBean;
    private List<orderBean>list;
    private JComboBox comboBox;
    private  String[]comboBoxDate;
    private List<String>  list2;
    private String []name={"订单编号","名称", "售价", "数量","合计","下单时间"};
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
