/*
 * Created by JFormDesigner on Mon May 03 11:41:30 CST 2021
 */

package swing.outlinesale;

import dao.sale.FindProduct;
import dao.sale.ObtainPrice;
import entity.sale.MilkTeaBean;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * 商家线下收银界面
 */

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
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
    private JComboBox comboBox;
    private  String[]comboBoxDate;
    private List<MilkTeaBean>milkTeaBeans;
    private String[]proid;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
