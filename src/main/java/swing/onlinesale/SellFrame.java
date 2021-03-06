package swing.onlinesale;

import entity.sale.MilkTeaBean;
import listener.sale.JoinShopCar;
import listener.sale.WarnFrame;
import swing.Underway.underwayFrame;
import util.Dbutil;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Sun May 02 13:45:46 CST 2021
 */

/**
 * 线上销售界面
 */
public class SellFrame extends JFrame {
    public static void main(String[] args) {
        SellFrame sellFrame=new SellFrame();
    }
    public SellFrame() {
        initComponents();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        //======== this ========
        this.setTitle("欢迎使用NO.3奶茶店线上点餐系统");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        jPanel=new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.WHITE);
        jPanel.setBounds(530,0,320,500);
        contentPane.add(jPanel);
        label1 = new JLabel();
        label=new JLabel();
        label2=new JLabel();
        label3=new JLabel();
        textField = new JTextField();
        textField1=new JTextField();
        textField2=new JTextField();
        textField3=new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3=new JButton();
        label.setText("\u5976\u8336\u540d\u79f0\uff1a");
        jPanel.add(label);
        label.setBounds(new Rectangle(new Point(30, 180), label.getPreferredSize()));
        jPanel.add(textField);
        textField.setBounds(105, 180, 130, textField.getPreferredSize().height);

        //----lable---//
        label1.setText("\u5976\u8336\u4ef7\u683c\uff1a");
        jPanel.add(label1);
        label1.setBounds(new Rectangle(new Point(30, 240), label1.getPreferredSize()));
        jPanel.add(textField1);
        textField1.setBounds(105, 240, 130, textField1.getPreferredSize().height);
        //---lable2---//
        label2.setText("\u5976\u8336\u6570\u91cf\uff1a");
        jPanel.add(label2);
        label2.setBounds(new Rectangle(new Point(30, 210), label2.getPreferredSize()));
        jPanel.add(textField2);
        textField2.setBounds(105, 210, 130, textField.getPreferredSize().height);
        //--lable--3//
        label3.setText("\u5976\u8336\u7f16\u53f7\uff1a");
        jPanel.add(label3);
        label3.setBounds(new Rectangle(new Point(30, 150), label3.getPreferredSize()));
        jPanel.add(textField3);
        textField3.setBounds(105, 150, 130, textField3.getPreferredSize().height);
        //---- button1 ----
        button1.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
        jPanel.add(button1);
        button1.setBounds(new Rectangle(new Point(60, 280), button1.getPreferredSize()));
        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        jPanel.add(button2);
        button2.setBounds(new Rectangle(new Point(170, 280), button1.getPreferredSize()));
        //---button3--//
        button3.setText("\u67e5\u770b\u8d2d\u7269\u8f66");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(430, 460), button3.getPreferredSize()));
        Dbutil dbutil=new Dbutil();
        list=new ArrayList<MilkTeaBean>();
        String sql="select proid,proname,sellprice from product";
        preparedStatement=dbutil.getPs(sql);
        try {
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                MilkTeaBean milkTeaBean=new MilkTeaBean();
                milkTeaBean.setProid(resultSet.getString("proid"));
                milkTeaBean.setProname(resultSet.getString("proname"));
                milkTeaBean.setSellprice(resultSet.getString("sellprice"));
                list.add(milkTeaBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[][]tableDate=new Object[list.size()][3];
        for(int i=0;i<list.size();i++){
            tableDate[i][0]=list.get(i).getProid();
            tableDate[i][1]=list.get(i).getProname();
            tableDate[i][2]=list.get(i).getSellprice();

        }
        String []name ={"编号","商品名称","商品价格"};
        DefaultTableModel tableModel=new DefaultTableModel(tableDate,name);
        table=new JTable(tableModel);
        jScrollPane=new JScrollPane(table);
        jScrollPane.setBounds(0,0,530,450);
        contentPane.add(jScrollPane);
        //---table???---//
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int n=table.getSelectedRow();
                String id=table.getValueAt(n,0).toString();
                String name=table.getValueAt(n,1).toString();
                String price=table.getValueAt(n,2).toString();
                textField.setText(name);
                textField1.setText(price);
                textField3.setText(id);
                textField2.setText("1");

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }
            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        textField.setEnabled(false);
        textField1.setEnabled(false);
        textField3.setEnabled(false);
        list1=new ArrayList<MilkTeaBean>();
        //--??????--//
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(textField2.getText().equals("")){//?ж???????????????????
                            WarnFrame.shopwarnFrame();//????????????????????????
                        }
                        else {
                            //???÷????ж?????????id??????????????????????????????????
                            list1=JoinShopCar.joinArrays(list1,textField3.getText(),textField.getText(),textField2.getText(),textField1.getText());
                            textField.setText("");
                            textField1.setText("");
                            textField2.setText("");
                            textField3.setText("");
                        }
                    }
                }
        );
        //--???????--(button)---//
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField.setText("");
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                    }
                }
        );
        //--????????button3??--//
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        ShopCarFrame shopCar=new ShopCarFrame(list1);
                    }
                }
        );
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        JMenuItem menu1 = new JMenu("正在进行的订单");
        menuBar1.add(menu1);
        menu1.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) { }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        new underwayFrame();
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });
        JMenuItem menu2 = new JMenu("查看订单记录");
        menuBar1.add(menu2);
        menu2.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) { }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        new underwayFrame();
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });
        //======== this ========
        contentPane.setLayout(null);
        setJMenuBar(menuBar1);
        contentPane.setPreferredSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private JPanel jPanel;
    private JTable table;
    private JTextField textField;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel label;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JScrollPane jScrollPane;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private MilkTeaBean milkTeaBean1;
    private List<MilkTeaBean>list;//
    private List<MilkTeaBean>list1;
    private JMenuBar menuBar1;
    private JMenuItem item;
    private JMenuItem item1;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
