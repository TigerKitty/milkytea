/*
 * Created by JFormDesigner on Fri Apr 23 11:47:01 CST 2021
 */

package swing;

import dao.Get;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * @author 1
 */
public class SellGoods extends JFrame {
    public SellGoods() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField2 = new JTextField();
        joinCart = new JButton();
        comboBox4 = new JComboBox();
        scrollPane1 = new JScrollPane();
        shopTable = new JTable();
        label1 = new JLabel();
        label2 = new JLabel();
        button2 = new JButton();
        label3 = new JLabel();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField2);
        textField2.setBounds(295, 25, 60, textField2.getPreferredSize().height);

        //---- 加入购物车 ----
        joinCart.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
        contentPane.add(joinCart);
        joinCart.setBounds(new Rectangle(new Point(430, 25), joinCart.getPreferredSize()));
        joinCart.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setShopTable();
                    }
                }
        );

        String[] comboBoxSelect = {"苹果", "李子", "薯条", "口香糖"};
        comboBox4 = new JComboBox(comboBoxSelect);
        contentPane.add(comboBox4);
        comboBox4.setBounds(new Rectangle(new Point(120, 25), comboBox4.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(shopTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(60, 100, 470, 265);

        //---- label1 ----
        label1.setText("\u6570\u91cf\uff1a");
        contentPane.add(label1);
        label1.setBounds(250, 25, 40, 20);

        //---- label2 ----
        label2.setText("\u5546\u54c1\u540d\u79f0\uff1a");
        contentPane.add(label2);
        label2.setBounds(55, 25, 60, 20);

        //---- 返回按钮 ----
        button2.setText("\u8fd4\u56de");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(575, 340), button2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u8d2d\u7269\u8f66\uff1a");
        contentPane.add(label3);
        label3.setBounds(60, 70, 55, label3.getPreferredSize().height);

        //---- 结账按钮 ----
        button3.setText("\u7ed3\u8d26");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(575, 110), button3.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(650, 405));
        pack();
        setLocationRelativeTo(getOwner());
        //调用时显示面板,
        setVisible(true);
        //关闭窗口时，同时关闭本次运行
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void setShopTable(){
        String[] columnNames = {"商品名称", "数量", "单价", "总价"};
        Object[][] rowData = new Object[8][4];
        Get get = new Get();
        try {
            rowData = get.getCartArrays(rowData,"1","2");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        shopTable = new JTable(rowData,columnNames);
        //scrollPane1.removeAll();
        scrollPane1.setViewportView(shopTable);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTextField textField2;
    private JButton joinCart;
    private JComboBox comboBox4;
    private JScrollPane scrollPane1;
    private JTable shopTable;
    private JLabel label1;
    private JLabel label2;
    private JButton button2;
    private JLabel label3;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
