/*
 * Created by JFormDesigner on Mon May 03 15:38:39 CST 2021
 *//*


package swing.outlinesale;

import dao.sale.DaoCreate;
import listener.sale.OutlineOrderMes;
import listener.sale.WarnFrame;
import swing.login.Login;
import util.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Visibility;
import javax.swing.*;

*/
/**
 * ��ʾPos���������
 *//*

public class MerPosCodePayFrame extends JFrame {
    public MerPosCodePayFrame(int sumprice,Object[][] tableDate) {
        initComponents(sumprice,tableDate);
    }

    private void initComponents(final int sumprice,final Object[][] tableDate) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        textField1 = new JTextField();
        label1 = new JLabel();
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(textField1);
        textField1.setBounds(125, 105, 125, textField1.getPreferredSize().height);

        //---- label1 ----
        label1.setText("\u6761\u5f62\u7801\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(80, 110), label1.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u786e\u5b9a");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(265, 105), button1.getPreferredSize()));
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String code = textField1.getText();
                        boolean bool = Main.trade_pay(code,sumprice);
                        if(bool){
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
                            //��ӡСƱ
                            OutlineOrderMes.printOrder(tableDate,name);
                        }else{
                            System.out.println("֧��ʧ��");
                            WarnFrame.outlinePaywarnFrame();
                        }
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
    private JTextField textField1;
    private JLabel label1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
*/
