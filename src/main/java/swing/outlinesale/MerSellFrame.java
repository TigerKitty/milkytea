/*
 * Created by JFormDesigner on Mon May 03 11:41:30 CST 2021
 */

package swing.outlinesale;

import dao.sale.FindProduct;
import dao.sale.ObtainPrice;
import entity.sale.MilkTeaBean;
import listener.sale.JoinShopCar;
import listener.sale.WarnFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class MerSellFrame extends JFrame {

    public static void main(String[] args) {
        MerSellFrame merSellFrame=new MerSellFrame();
    }
    public MerSellFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        //======== this ========
        contentPane = getContentPane();
        contentPane.setLayout(null);
        jPanel=new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.WHITE);
        jPanel.setBounds(530,0,320,500);
        contentPane.add(jPanel);
        label1=new JLabel();
        label2=new JLabel();
        label3=new JLabel();
        list=new ArrayList<MilkTeaBean>();
        FindProduct findProduct=new FindProduct();
        list=findProduct.findprodyct();
        comboBoxDate=new String[list.size()];
        for(int i=0;i<list.size();i++){
            comboBoxDate[i]=list.get(i).getProid()+":"+list.get(i).getProname();
        }
        comboBox=new JComboBox(comboBoxDate);
        textField2=new JTextField();
        textField3=new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3 =new JButton();
        button4=new JButton();
        label1.setText("\u5976\u8336\u540d\u79f0\uff1a");
        jPanel.add(label1);
        label1.setBounds(new Rectangle(new Point(30, 150), label1.getPreferredSize()));
        jPanel.add(comboBox);
        comboBox.setBounds(105, 150, 130, comboBox.getPreferredSize().height);

        //---lable2---//
        label2.setText("\u5976\u8336\u4ef7\u683c\uff1a");
        jPanel.add(label2);
        label2.setBounds(new Rectangle(new Point(30, 210), label2.getPreferredSize()));
        jPanel.add(textField2);
        textField2.setBounds(105, 210, 130, textField2.getPreferredSize().height);
        //--lable--3//
        label3.setText("\u5976\u8336\u6570\u91cf");
        jPanel.add(label3);
        label3.setBounds(new Rectangle(new Point(30, 180), label3.getPreferredSize()));
        jPanel.add(textField3);
        textField3.setBounds(105, 180, 130, textField3.getPreferredSize().height);
        //---- button1 ----
        button1.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
        jPanel.add(button1);
        button1.setBounds(new Rectangle(new Point(60, 280), button1.getPreferredSize()));
        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        jPanel.add(button2);
        button2.setBounds(new Rectangle(new Point(170, 280), button1.getPreferredSize()));
        //---button3--
        button3.setText("\u652f\u4ed8");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(440, 460), button3.getPreferredSize()));
        //--button4--
        button4.setText("\u5220\u9664");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(370, 460), button4.getPreferredSize()));

        Object tableDate[][]=new Object[0][4];
        String []name ={"商品编号","商品名称","商品数量","商品价格"};
        tableModel=new DefaultTableModel(tableDate,name);
        table=new JTable(tableModel);
        final JScrollPane jScrollPane=new JScrollPane(table);
        jScrollPane.setBounds(0,0,530,450);
        contentPane.add(jScrollPane);
        comboBox.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int index=comboBox.getSelectedIndex();
                        String select=comboBoxDate[index];
                        proid=select.split(":");
                        ObtainPrice obtainPrice=new ObtainPrice();
                        String sellpricr=obtainPrice.obtainprice(proid[0]);
                        textField2.setText(sellpricr);
                        textField3.setText("1");
                    }
                }
        );
        //���빺�ﳵ
        milkTeaBeans=new ArrayList<MilkTeaBean>();
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(textField3.getText().equals("")){
                            WarnFrame.shopwarnFrame();
                        }
                        else {
                            jScrollPane.setVisible(false);
                            milkTeaBeans = JoinShopCar.joinOutlineArr(milkTeaBeans,proid[0],proid[1],Integer.parseInt(textField3.getText())+"",textField2.getText());
                            Object tableDate[][] = new Object[milkTeaBeans.size()][4];
                            for (int i = 0; i < milkTeaBeans.size(); i++) {
                                tableDate[i][0] = milkTeaBeans.get(i).getProid();
                                tableDate[i][1] = milkTeaBeans.get(i).getProname();
                                tableDate[i][2] = milkTeaBeans.get(i).getNumber();
                                tableDate[i][3] = milkTeaBeans.get(i).getSellprice();
                            }
                            String[] name = {"商品编号", "商品名称", "商品数量", "商品价格"};
                            tableModel = new DefaultTableModel(tableDate, name);
                            table = new JTable(tableModel);
                            JScrollPane jScrollPane = new JScrollPane(table);
                            jScrollPane.setBounds(0, 0, 530, 450);
                            contentPane.add(jScrollPane);
                            jScrollPane.setVisible(true);
                            textField2.setText("");
                            textField3.setText("");
                        }
                    }
                }
        );
        //����
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //textField2.setText("");
                        textField3.setText("");
                    }
                }
        );
        //֧��
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int sumprice=0;
                        for(int j=0;j<milkTeaBeans.size();j++){
                            sumprice=sumprice+milkTeaBeans.get(j).getNumber()*Integer.parseInt(milkTeaBeans.get(j).getSellprice());
                        }
                        Object tableDate[][]=new Object[milkTeaBeans.size()][4];
                        for(int i=0;i<milkTeaBeans.size();i++){
                            tableDate[i][0]=milkTeaBeans.get(i).getProid();
                            tableDate[i][1]=milkTeaBeans.get(i).getProname();
                            tableDate[i][2]=milkTeaBeans.get(i).getNumber();
                            tableDate[i][3]=milkTeaBeans.get(i).getSellprice();
                        }
                        MerPayFrame merPayFrame=new MerPayFrame(sumprice,tableDate);
                    }
                }
        );
        //����Ʒ�ӹ��ﳵ�Ƴ�
        n=-1;
        button4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        n=table.getSelectedRow();
                        if(n!=-1) {
                            tableModel.removeRow(n);
                            milkTeaBeans.remove(n);
                        }
                        else {
                            WarnFrame.deletewarnFrame();
                        }
                    }
                }
        );
        contentPane.setPreferredSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //清空购物车
    public  static void Clear(){
        milkTeaBeans.clear();
        tableModel.setRowCount(0);
        /*Object tableDate1[][] = new Object[0][4];
        String[] name = {"奶茶编号", "奶茶名称", "奶茶数量", "奶茶售价"};
        tableModel = new DefaultTableModel(tableDate1, name);
        table = new JTable(tableModel);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(0, 0, 530, 450);
        contentPane.add(jScrollPane);**/
    }
    private JPanel jPanel;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private static JTable table;
    private static DefaultTableModel tableModel;
    private JComboBox comboBox;
    private  String[]comboBoxDate;
    private static List<MilkTeaBean>milkTeaBeans;
    private String[]proid;
    private List <MilkTeaBean>list;
    private int n;
    private static Container contentPane;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
