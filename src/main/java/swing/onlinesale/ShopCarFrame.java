package swing.onlinesale;

import entity.sale.MilkTeaBean;
import listener.sale.WarnFrame;
import swing.onlinesale.BillFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Sun May 02 14:36:59 CST 2021
 */



/**
 * ���ﳵ����
 */
public class ShopCarFrame extends JFrame {
    private static List<MilkTeaBean>list;

    public ShopCarFrame(List<MilkTeaBean>list) {
        this.list=list;
        initComponents(list);
    }
    private void initComponents(final List<MilkTeaBean>list) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        //======== this ========
        contentPane = getContentPane();
        contentPane.setLayout(null);
        Object[][]tableDate=new Object[list.size()][4];
        for(int i=0;i<list.size();i++){
            tableDate[i][0]=list.get(i).getProid();
            tableDate[i][1]=list.get(i).getProname();
            tableDate[i][2]=list.get(i).getNumber();
            tableDate[i][3]=list.get(i).getSellprice();
        }
        String []name ={"�̲���","�̲�����","��������","�̲��ۼ�"};
        tableModel=new DefaultTableModel(tableDate,name);
        table=new JTable(tableModel);
        jScrollPane=new JScrollPane(table);
        jScrollPane.setBounds(0,0,800,450);
        contentPane.add(jScrollPane);
        button1 = new JButton();
        button2 = new JButton();
        //---- button1 ----
        button1.setText("\u5220\u9664");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(630, 460), button1.getPreferredSize()));
        //---- button2 ----
        button2.setText("\u63d0\u4ea4\u8ba2\u5355");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(700, 460), button2.getPreferredSize()));
        //---�Ƴ����ﳵ---//
        n=-1;
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        n=table.getSelectedRow();
                        if(n!=-1) {
                            tableModel.removeRow(n);
                            list.remove(n);
                        }
                        else {
                            WarnFrame.deletewarnFrame();
                        }
                    }
                }
        );
        //---�ύ����---//
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(list.size()==0){
                            WarnFrame.orderwarnFrame();
                        }
                        else {
                            BillFrame order = new BillFrame(list);
                        }
                    }
                }
        );
        contentPane.setPreferredSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
        //tDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //����ɹ�����չ��ﳵ
    public static void ClearShopCar(){
        tableModel.setRowCount(0);
        list.clear();
    }
    private static JTable table;
    private JButton button1;
    private JButton button2;
    private static JScrollPane jScrollPane;
    private static Container contentPane;
    private static DefaultTableModel tableModel;
    private int n;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}