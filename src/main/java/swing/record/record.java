package swing.record;

import dao.order.getDaily;

import dao.record.getDate;
import entity.record.RecordBean;

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
public class record extends JFrame {
    public static void main(String[] args) {  record record=new record(); }
    public record() {
        initComponents();
    }
    private void initComponents() {
        this.setTitle("接单记录");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();
        datelist = getDate.getDateList();
        comboBoxDate=new String[datelist.size()];
        for(int i=0;i<datelist.size();i++){
            comboBoxDate[i]=datelist.get(i);
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
        scrollPane1.setBounds(125, 90, 550, 300);

        //---- label1 ----
        label1.setText("接单记录");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 9f));
        contentPane.add(label1);
        label1.setBounds(355, 25, 135, 35);

        contentPane.add(comboBox);
        comboBox.setBounds(145, 30, 120, 30);
        comboBox.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int index=comboBox.getSelectedIndex();
                        String select=comboBoxDate[index];
                        list = getDate.getListByDate(select);
                        Object[][]tableDate=new Object[list.size()][6];
                        for(int i=0;i<list.size();i++){
                            tableDate[i][0]=list.get(i).getOrdid();
                            tableDate[i][1]=list.get(i).getUsername();
                            tableDate[i][2]=list.get(i).getOrdertime();
                            tableDate[i][3]=list.get(i).getProname();
                            tableDate[i][4]=list.get(i).getDetailnum();
                            tableDate[i][5]=list.get(i).getDetailprice();
                        }
                        DefaultTableModel tableModel=new DefaultTableModel(tableDate,name){
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableModel);
                        table1.getColumnModel().getColumn(0).setPreferredWidth(100);
                        table1.getColumnModel().getColumn(1).setPreferredWidth(50);
                        table1.getColumnModel().getColumn(2).setPreferredWidth(100);
                        table1.getColumnModel().getColumn(3).setPreferredWidth(60);
                        table1.getColumnModel().getColumn(4).setPreferredWidth(15);
                        table1.getColumnModel().getColumn(5).setPreferredWidth(15);
                    }
                }
        );
        contentPane.setPreferredSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        list = getDate.getList();
        Object[][]tableDate=new Object[list.size()][6];
        for(int i=0;i<list.size();i++){
            tableDate[i][0]=list.get(i).getOrdid();
            tableDate[i][1]=list.get(i).getUsername();
            tableDate[i][2]=list.get(i).getOrdertime();
            tableDate[i][3]=list.get(i).getProname();
            tableDate[i][4]=list.get(i).getDetailnum();
            tableDate[i][5]=list.get(i).getDetailprice();
        }
        DefaultTableModel tableModel=new DefaultTableModel(tableDate,name){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
        table1.getColumnModel().getColumn(0).setPreferredWidth(100);
        table1.getColumnModel().getColumn(1).setPreferredWidth(50);
        table1.getColumnModel().getColumn(2).setPreferredWidth(100);
        table1.getColumnModel().getColumn(3).setPreferredWidth(60);
        table1.getColumnModel().getColumn(4).setPreferredWidth(15);
        table1.getColumnModel().getColumn(5).setPreferredWidth(15);
        // table1.getColumnModel().getColumn(6).setPreferredWidth(50);
        table1.setModel(tableModel);
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private RecordBean RecordBean;
    private List<RecordBean>list;
    private JComboBox comboBox;
    private  String[]comboBoxDate;
    private List<String>  datelist;
    private String []name={"订单编号","用户ID","下单时间","奶茶名称","数量","金额",};
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
