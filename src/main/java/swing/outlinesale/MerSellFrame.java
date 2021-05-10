/*
 * Created by JFormDesigner on Mon May 03 11:41:30 CST 2021
 */

package swing.outlinesale;

import dao.sale.FindProduct;
import dao.sale.ObtainPrice;
import entity.sale.MilkTeaBean;
import listener.sale.JoinShopCar;
import listener.sale.WarnFrame;
import swing.addProduct.addProduct;
import swing.lnc.OrdersInProgressFrame;
import swing.onlinesale.SellFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
        button5=new JButton();
        button6=new JButton();
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
        //--button5
        button5.setText("+");
        jPanel.add(button5);
        button5.setBounds(new Rectangle(new Point(10, 15), button5.getPreferredSize()));
        //--button6
        button6.setText("-");
        jPanel.add(button6);
        button6.setBounds(new Rectangle(new Point(10, 45), button5.getPreferredSize()));

        Object tableDate[][]=new Object[0][4];
        String []name ={"商品编号","商品名称","商品数量","商品价格"};
        tableModel=new DefaultTableModel(tableDate,name);
        table=new JTable(tableModel);
        jScrollPane=new JScrollPane(table);
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
                            jScrollPane = new JScrollPane(table);
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
        //加数量
        button5.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jScrollPane.setVisible(false);
                        int m=table.getSelectedRow();
                        milkTeaBeans.get(m).setNumber(milkTeaBeans.get(m).getNumber()+1);
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
                        jScrollPane = new JScrollPane(table);
                        jScrollPane.setBounds(0, 0, 530, 450);
                        contentPane.add(jScrollPane);
                        jScrollPane.setVisible(true);
                    }
                }
        );
        //减数量
        button6.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jScrollPane.setVisible(false);
                        int m=table.getSelectedRow();
                        milkTeaBeans.get(m).setNumber(milkTeaBeans.get(m).getNumber()-1);
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
                        jScrollPane = new JScrollPane(table);
                        jScrollPane.setBounds(0, 0, 530, 450);
                        contentPane.add(jScrollPane);
                        jScrollPane.setVisible(true);
                    }
                }
        );
        menuBar1 = new JMenuBar();
        JMenuItem menu = new JMenu("添加商品");
        menuBar1.add(menu);
        menu.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) { }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        new addProduct();
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });
        JMenuItem menu1 = new JMenu("订单管理");
          menuBar1.add(menu1);
          menu1.addMouseListener(
                  new MouseListener() {
                      @Override
                      public void mouseClicked(MouseEvent e) { }
                      @Override
                      public void mousePressed(MouseEvent e) {
                          new OrdersInProgressFrame();
                      }
                      @Override
                      public void mouseReleased(MouseEvent e) { }
                      @Override
                      public void mouseEntered(MouseEvent e) { }
                      @Override
                      public void mouseExited(MouseEvent e) { }
                  });
//        item=new JMenuItem("正在进行的订单");
//        menu1.add(item);
//        item1=new JMenuItem("已完成订单记录");
//        menu1.add(item1);
        JMenu menu2 = new JMenu("利润统计");
        menuBar1.add(menu2);
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        setJMenuBar(menuBar1);
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
    private JButton button5;//加数量
    private JButton button6;//减数量
    private static JTable table;
    private static DefaultTableModel tableModel;
    private static JScrollPane jScrollPane;
    private JComboBox comboBox;
    private  String[]comboBoxDate;
    private static List<MilkTeaBean>milkTeaBeans;
    private String[]proid;
    private List <MilkTeaBean>list;
    private int n;
    private static Container contentPane;
    private JMenuBar menuBar1;
    private JMenuItem item;
    private JMenuItem item1;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
