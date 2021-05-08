/*
 * Created by JFormDesigner on Thu May 06 20:40:33 CST 2021
 */

package swing.record;


import entity.record.RecordBean;

import util.Dbutil;

import java.awt.*;
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
    public static void main(String[] args) { record record=new record();
    }
    public record() {
        initComponents();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(105, 90, 520, 155);

        //---- label1 ----
        label1.setText("\u63a5\u5355\u8bb0\u5f55");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 9f));
        contentPane.add(label1);
        label1.setBounds(315, 25, 135, 35);

        contentPane.setPreferredSize(new Dimension(725, 435));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        Dbutil dbutil=new Dbutil();
        list=new ArrayList<RecordBean>();
        String sql="select c.ordid,c.username,c.ordertime,p.proname,d.detailnum,d.detailprice,c.status from product p,comorder c,detailorder d where p.proid=d.proid and c.ordid=d.ordid and c.status=2";
        System.out.println("执行的SQL："+sql);
        preparedStatement=dbutil.getPs(sql);
        try {
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){

                RecordBean RecordBean=new RecordBean();
                RecordBean.setOrdid(resultSet.getString("ordid"));
                RecordBean.setUsername(resultSet.getString("username"));
                RecordBean.setOrdertime(resultSet.getString("ordertime"));
                RecordBean.setProname(resultSet.getString("proname"));
                RecordBean.setDetailnum(resultSet.getString("detailnum"));
                RecordBean.setDetailprice(resultSet.getString("detailprice"));
                RecordBean.setStatus(resultSet.getString("status"));
                list.add(RecordBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[][]tableDate=new Object[list.size()][7];
        for(int i=0;i<list.size();i++){
            tableDate[i][0]=list.get(i).getOrdid();
            tableDate[i][1]=list.get(i).getUsername();
            tableDate[i][2]=list.get(i).getOrdertime();
            tableDate[i][3]=list.get(i).getProname();
            tableDate[i][4]=list.get(i).getDetailnum();
            tableDate[i][5]=list.get(i).getDetailprice();
            tableDate[i][6]=list.get(i).getStatus();

        }
        String []name ={"订单编号","用户ID","下单时间","奶茶名称","数量","金额","订单状态"};
        DefaultTableModel tableModel=new DefaultTableModel(tableDate,name){
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private RecordBean RecordBean;
    private List<RecordBean>list;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
