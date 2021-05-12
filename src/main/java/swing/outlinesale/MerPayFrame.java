/*
 * Created by JFormDesigner on Mon May 03 15:09:06 CST 2021
 *//*


package swing.outlinesale;

import dao.sale.DaoCreate;
import listener.sale.OutlineOrderMes;
import listener.sale.WarnFrame;
import swing.login.Login;
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

*/
/**
 * �̼ҽ���ҳ�棬��ѡ�����ָ��ʽ
 *//*

public class MerPayFrame extends JFrame {
    static Object[][] tableDate;
    public MerPayFrame(int sumprice, Object[][] tableDate) {
        this.tableDate = tableDate;
        initComponents(sumprice);

    }

    private void initComponents(final int sumprice) {
        this.setTitle("��ȷ����Ϣ��ѡ���Խ���");
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
        //��ʾ�ܶ�
        textField1.setText(""+sumprice);
        textField2.setText(""+sumprice);
        textField3.setText("0");
        textField1.setEnabled(false);
        textField3.setEnabled(false);
        //��̬��ȡ����
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
        //�ֽ�֧��
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField1.setText("");
                        textField2.setText("");
                        textField3.setText("");
                        //����orderid
                        String name = Login.username;
                        String orderid = DaoCreate.CreateOutlineOrdid(name);
                        //��������Ϣ���뵽comorder���ݿ����
                        OutlineOrderMes.insertComOrd(name,orderid);
                        //��������Ϣ���뵽detailorder���ݿ����
                        OutlineOrderMes.insertDetailOrd(tableDate,orderid);
                        MerSellFrame.Clear();//����֮����չ��ﳵ
                    }
                }
        );
        //��ά��֧��
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        final util.Main main = new util.Main();
                        final String[] no = {""};
                        final int[] payStatus = {0};
                        //�����ɶ�ά�����һ���߳�
                        Thread t1=new Thread(
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        //����һ��Ҫ��Ϊ���������㲻��Ϊɶ
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
                        //����֤֧���ɹ��ķ������һ���߳�
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
                                            //����һ��Ҫ��Ϊ���������㲻��Ϊɶ
                                            payStatus[0] = main.test_trade_query(no[0]);
                                            System.out.println(payStatus[0]);
                                            if (payStatus[0]==1){
                                                System.out.println("֧���ɹ�");
                                                //����orderid
                                                String name = Login.username;
                                                String orderid = DaoCreate.CreateOutlineOrdid(name);
                                                //��������Ϣ���뵽comorder���ݿ����
                                                OutlineOrderMes.insertComOrd(name,orderid);
                                                //��������Ϣ���뵽detailorder���ݿ����
                                                OutlineOrderMes.insertDetailOrd(tableDate,orderid);
                                                MerSellFrame.Clear();//����֮����չ��ﳵ
                                                WarnFrame.outlinePoswarnFrame1();//����֧���ɹ���
                                            }else {
                                                System.out.println("֧��ʧ��");
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
        //pos��֧��
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
*/
