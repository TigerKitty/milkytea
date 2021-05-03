package swing.onlinesale;

import dao.sale.Create;
import dao.sale.DaoInsBillOrd;
import entity.sale.BillOrdBean;
import entity.sale.MilkTeaBean;
import util.ShowQRCode;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun May 02 15:45:20 CST 2021
 */
/**
 * 结账面板
 */
public class BillFrame extends JFrame {
    public BillFrame(List<MilkTeaBean>list) {
        initComponents(list);
    }

    private void initComponents(List<MilkTeaBean>list) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2=new JLabel();
        textField1 = new JTextField();
        textField2=new JTextField();
        button1 = new JButton();//结账按钮

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u603b\u91d1\u989d\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(40, 95), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(105, 95, 140, textField1.getPreferredSize().height);
        int sumpirce=0;
        for(int i=0;i<list.size();i++){
            sumpirce=sumpirce+list.get(i).getNumber()*Integer.parseInt(list.get(i).getSellprice());
        }
        textField1.setText(""+sumpirce);
        textField1.setEnabled(false);
        //---label2---//
        label2.setText("\u914d\u9001\u65f6\u95f4\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(40, 125), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(105, 125, 140, textField2.getPreferredSize().height);
        Date date1=new Date();
        Date date2=new Date(date1.getTime()+600000);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm");
        final String ordertime = format.format(date1);//下单时间
        final String trantime=format.format(date2);//配送时间

        textField2.setText(trantime);
        textField2.setForeground(new Color(204,204,204));

        //---- button1 ----
        button1.setText("\u7ed3\u8d26");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(230, 165), button1.getPreferredSize()));
        //---支付---//
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        util.Main main = new util.Main();
                        main.test_trade_precreate(Integer.parseInt(textField1.getText()));
                        List<File> list = new ArrayList<File>();
                        list= ShowQRCode.getFileSort("E:\\");
                        String endfileurl=list.get(list.size()-1).getAbsolutePath();
                        QRcodePayFrame QRcodePayFrame =new QRcodePayFrame(endfileurl);
                        //将此订单所需信息封装
                        final BillOrdBean bb = new BillOrdBean();
                        bb.setOrdertime(ordertime);
                        bb.setTrantime(trantime);
                        bb.setStatus("0");
                        //生成订单号(用户名称暂时写死)
                        String orderID = Create.CreateOrdid("hzg");
                        bb.setOrdid(orderID);
                        //这里需要获取登录的信息
                        bb.setUsername("hzg");
                        DaoInsBillOrd.insOrder(bb);
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
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
