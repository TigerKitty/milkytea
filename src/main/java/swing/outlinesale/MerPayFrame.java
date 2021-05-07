/*
 * Created by JFormDesigner on Mon May 03 15:09:06 CST 2021
 */

package swing.outlinesale;

import dao.sale.DaoCreate;
import listener.sale.OutlineOrderMes;
import listener.sale.WarnFrame;
import util.ShowQRCode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * 商家结账页面，可选择三种付款方式
 */
public class MerPayFrame extends JFrame {
    static Object[][] tableDate;
    public MerPayFrame(int sumprice, Object[][] tableDate) {
        this.tableDate = tableDate;
        initComponents(sumprice);
    }

    private void initComponents(final int sumprice) {
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        button3=new JButton();
        label1.setText("\u603b\u989d\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(80, 100), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(145, 95, 155, textField1.getPreferredSize().height);
        //---- label2 ----
        label2.setText("\u652f\u4ed8\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(80, 135), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(145, 135, 155, textField2.getPreferredSize().height);
        //---- label3 ----
        label3.setText("\u627e\u96f6\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(80, 175), label3.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(145, 170, 155, textField3.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u73b0\u91d1\u652f\u4ed8");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(60, 215), button1.getPreferredSize()));
        button1.setBackground(Color.BLUE);

        //---- button2 ----
        button2.setText("\u4ed8\u6b3e\u7801\u652f\u4ed8");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(165, 215), button2.getPreferredSize()));
        button2.setBackground(Color.RED);

        //----button3----
        button3.setText("Pos\u673a\u4ed8\u6b3e");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(280, 215), button3.getPreferredSize()));
        button3.setBackground(Color.ORANGE);
        //显示总额
        textField1.setText(""+sumprice);
        textField2.setText(""+sumprice);
        textField3.setText("0");
        textField1.setEnabled(false);
        textField3.setEnabled(false);
        //动态获取找零
        textField2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!textField2.getText().equals("")) {
                    int change = Integer.parseInt(textField2.getText()) - Integer.parseInt(textField1.getText());
                    textField3.setText("" + change);
                }

            }
        });
        //现金支付
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        //生成orderid
                        String name = "outline";
                        String orderid = DaoCreate.CreateOutlineOrdid(name);
                        //将订单信息加入到comorder数据库表中
                        OutlineOrderMes.insertComOrd(name,orderid);
                        //将订单信息加入到detailorder数据库表中
                        OutlineOrderMes.insertDetailOrd(tableDate,orderid);
                    }
                }
        );
        //二维码支付
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        final util.Main main = new util.Main();
                        final String[] no = {""};
                        final int[] payStatus = {0};
                        //给生成二维码添加一个线程
                        Thread t1=new Thread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        //这里一定要变为数组的问题搞不懂为啥
                                        no[0] = main.test_trade_precreate(Integer.parseInt(textField1.getText()));
                                        System.out.println(no[0]);
                                        List<File> list = new ArrayList<File>();
                                        list= ShowQRCode.getFileSort("E:\\");
                                        String endfileurl=list.get(list.size()-1).getAbsolutePath();
                                        MerCodePayFrame codePayFrame=new MerCodePayFrame(endfileurl);
                                    }
                                }
                        );
                        final Object obj = new Object();
                        //给验证支付成功的方法添加一个线程
                        Thread t2=new Thread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        synchronized (obj){
                                            try {
                                                obj.wait(20000);
                                            } catch (InterruptedException ex) {
                                                ex.printStackTrace();
                                            }
                                            //这里一定要变为数组的问题搞不懂为啥
                                            payStatus[0] = main.test_trade_query(no[0]);
                                            System.out.println(payStatus[0]);
                                            if (payStatus[0]==1){
                                                System.out.println("支付成功");
                                                //生成orderid
                                                String name = "outline";
                                                String orderid = DaoCreate.CreateOutlineOrdid(name);
                                                //将订单信息加入到comorder数据库表中
                                                OutlineOrderMes.insertComOrd(name,orderid);
                                                //将订单信息加入到detailorder数据库表中
                                                OutlineOrderMes.insertDetailOrd(tableDate,orderid);
                                            }else {
                                                System.out.println("支付失败");
                                                WarnFrame.outlinePaywarnFrame();
                                            }
                                        }
                                    }
                                }
                        );
                        t1.start();
                        t2.start();
                    }
                }
        );
        //pos机支付
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        MerPosCodePayFrame merPosCodePayFrame=new MerPosCodePayFrame(sumprice,tableDate);
                    }
                }
        );
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    private JButton button3;

}
