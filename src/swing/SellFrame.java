package swing;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Sun May 02 13:45:46 CST 2021
 */



/**
 * @author 1
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
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        jPanel=new JPanel();
        jPanel.setLayout(null);
        jPanel.setBackground(Color.WHITE);
        Object[][]tableDate=new Object[1][3];
        tableDate[0][0]=1;
        tableDate[0][1]="烧仙草";
        tableDate[0][2]=8;
        String []name ={"奶茶编号","奶茶名称","奶茶售价"};
        DefaultTableModel tableModel=new DefaultTableModel(tableDate,name);
        table=new JTable(tableModel);
        jScrollPane=new JScrollPane(table);
        jScrollPane.setBounds(0,0,530,450);
        jPanel.setBounds(530,0,320,500);
        contentPane.add(jPanel);
        contentPane.add(jScrollPane);
        label1 = new JLabel();
        label=new JLabel();
        label2=new JLabel();
        textField = new JTextField();
        textField1=new JTextField();
        textField2=new JTextField();
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
        //---table事件---//
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int n=table.getSelectedRow();
                String name=table.getValueAt(n,1).toString();
                String price=table.getValueAt(n,2).toString();
                textField.setText(name);
                textField1.setText(price);

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
        //--重置事件--(button)---//
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField.setText("");
                        textField1.setText("");
                        textField2.setText("");
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
    private JPanel jPanel;
    private JTable table;
    private JTextField textField;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JScrollPane jScrollPane;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
