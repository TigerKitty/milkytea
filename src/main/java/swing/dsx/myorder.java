/*
 * Created by JFormDesigner on Sun May 09 20:55:53 CST 2021
 */


package swing.dsx;

import entity.dsx.orderBean;
import util.Dbutil;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author 1
 */
public class myorder extends JFrame {
    public static void main(String[] args) { myorder myorder=new myorder(); }
    public myorder() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        this.setTitle("历史订单");
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setFont(new Font(Font.DIALOG, Font.BOLD, 8));
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6211\u7684\u8ba2\u5355");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD, label1.getFont().getSize() + 6f));
        contentPane.add(label1);
        label1.setBounds(195, 30, 125, 45);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 70, scrollPane1.getPreferredSize().width, 118);

        contentPane.setPreferredSize(new Dimension(515, 345));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        Dbutil dbutil=new Dbutil();
        list=new ArrayList<orderBean>();
        String sql="SELECT *" +
                " FROM(SELECT c.ordid,p.proname,p.sellprice,d.detailnum,d.detailprice,c.ordertime, c.username\n" +
                " FROM product p,comorder c,detailorder d\n" +
                " WHERE p.proid=d.proid and c.ordid=d.ordid and status='0')\n" +
                " WHERE  username=?";
        ResultSet rs = null;
        PreparedStatement ptem = dbutil.getPs(sql);
        try {
            ptem.setString( 1,"hzg");
            rs=ptem.executeQuery();
            while (rs.next()) {//每循环一次给用户赋值
                //将数据库中用户的信息存放在集合中
                orderBean orderBean = new orderBean();
                orderBean.setOrdid(rs.getString("ordid"));
                orderBean.setProname(rs.getString("proname"));
                orderBean.setSellprice(rs.getString("sellprice"));
                orderBean.setDetailnum(rs.getString("detailnum"));
                orderBean.setDetailprice(rs.getString("detailprice"));
                orderBean.setOrdertime((rs.getString("ordertime")));
                orderBean.setUsername(rs.getString("username"));

                list.add(orderBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[][]tableDate=new Object[list.size()][7];
        for(int i=0;i<list.size();i++){
            tableDate[i][0] = list.get(i).getOrdid();
            tableDate[i][1] = list.get(i).getProname();
            tableDate[i][2] = list.get(i).getSellprice();
            tableDate[i][3] = list.get(i).getDetailnum();
            tableDate[i][4] = list.get(i).getDetailprice();
            tableDate[i][5] = list.get(i).getOrdertime();
            tableDate[i][6] = list.get(i).getUsername();

        }
        String []name ={"订单编号","名称", "售价", "数量","合计","下单时间","用户名"};
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
        table1.getColumnModel().getColumn(5).setPreferredWidth(100);
        table1.getColumnModel().getColumn(6).setPreferredWidth(50);
        table1.setModel(tableModel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private Object[][] tableDate= null;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<orderBean> list;
    private orderBean orederBean1;
    private JTable table;
    private List<orderBean> list1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
