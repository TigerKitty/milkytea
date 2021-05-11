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
 * �̼����ڽ��еĶ������̼��ڴ˽���鿴���ڽ��еĶ���������״̬Ϊ��0�� ���ߡ�1��
 * ���Խ�����״̬��δ���͸�Ϊ�������ͣ�Ҳ���Գ������ͣ����δ����
 * �Զ�ˢ��
 * ��ϵ����Ա
 * ʵ����������
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

//�����߳�ʵ���Զ�ˢ��
        FleshThread fleshThread = new FleshThread(this);
        fleshThread.start();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u672a\u6d3e\u9001\u8ba2\u5355");//δ���Ͷ�����ǩ
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
        label2.setText("\u6b63\u5728\u6d3e\u9001\u8ba2\u5355");//�������Ͷ�����ǩ
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
        button1.setText("\u5f00\u59cb\u6d3e\u9001");//����ʼ���͡���ť
        contentPane.add(button1);
        button1.setBounds(635, 130, 95, 40);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count=table1.getSelectedRow();//��ȡ��ѡ�е��кţ���¼��
                        if(count < 0 || count >=table1.getRowCount()){//ûѡ���κ�����û�б仯
                            return;
                        }
                        String ordid= table1.getValueAt(count, 0).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
                        Dbutil dbutil = new Dbutil();//�������ݿ�
                        String sql = "update comorder set status= ? ,trantime = ? where ordid = ?";//?ռλ��
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

                        //���Ͷ���
                        Deliver deliver = new Deliver();
                        SendMassage sendMassage = new SendMassage();
                        String send = sendMassage.sendSMS(deliver.phone3,ordid);
                        System.out.println(send);


                        //ˢ�±��

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

                        //��������
                        String s = "������Ϊ" + ordid + "��������ʼ����";
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
        button2.setText("\u5237\u65b0");//�����¡���ť��ˢ��������
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
        button3.setText("\u64a4\u9500\u6d3e\u9001");//���������͡���ť
        contentPane.add(button3);
        button3.setBounds(635, 300, 95, 40);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count=table2.getSelectedRow();//��ȡ��ѡ�е��кţ���¼��
                        if(count < 0 || count >=table2.getRowCount()){//ûѡ���κ�����û�б仯
                            return;
                        }
                        String ordid= table2.getValueAt(count, 0).toString();//��ȡ���ȡ�кŵ�ĳһ�е�ֵ��Ҳ�����ֶΣ�
                        Dbutil dbutil = new Dbutil();//�������ݿ�
                        String sql = "update comorder set status= ?  where ordid = ?";//?ռλ��
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

    //����һ���õ�statusΪ0����1�ļ�¼
    public Object[][] queryData(int num) {//num���ڿ���δ���ͱ���������ͱ�Ľ����0��ʾδ���ͱ�1��ʾ�������ͱ�
        java.util.List<ComOrder> list = new ArrayList<ComOrder>();
        Dbutil dbutil = new Dbutil();
        String sql = "SELECT * FROM comorder Order by ordertime";
        PreparedStatement pstmt = dbutil.getPs(sql);
        try {
            ResultSet rs = dbutil.getRs(pstmt.executeQuery());
            if(num == 0){
                while (rs.next()) {
                    //ѭ��һ�ξ���һ������
                    if(Integer.parseInt(rs.getString("status")) == num){
                        ComOrder co = new ComOrder();
                        co.setOrdid(rs.getString("ordid"));
                        co.setUsername(getRealName(rs.getString("USERNAME")*/
/*������*//*
));
                        co.setOrdertime(rs.getString("ordertime"));
                        co.setTrantime(rs.getString("trantime"));
                        co.setStatus("δ����");
                        list.add(co);
                    }
                }
            }else if(num == 1){
                while (rs.next()) {
                    //ѭ��һ�ξ���һ������
                    if(Integer.parseInt(rs.getString("status")) == num){
                        ComOrder co = new ComOrder();
                        co.setOrdid(rs.getString("ordid"));
                        co.setUsername(getRealName(rs.getString("USERNAME")*/
/*������*//*
));
                        co.setOrdertime(rs.getString("ordertime"));
                        co.setTrantime(rs.getString("trantime"));
                        co.setStatus("��������");
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

    //������������username�õ�uname
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

    //����������ȡ��ǰʱ��
    public String getCurrentTime(){
        Date ss = new Date();
        //        System.out.println("һ�����������" + ss);
//        System.out.println("ʱ�����" + ss.getTime());
        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time = format0.format(ss.getTime());//������ǰ�ʱ�����������õ�������ʽ��ʱ��
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
    private String head[] = {"������", "�û���", "�µ�ʱ��", "����ʱ��","״̬"};
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
