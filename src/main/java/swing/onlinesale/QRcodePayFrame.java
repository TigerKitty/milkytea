package swing.onlinesale;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Sun May 02 18:18:07 CST 2021
 */



/**
 * 二维码显示界面
 */
public class QRcodePayFrame extends JFrame {
    public QRcodePayFrame(String fileurl) {
        initComponents(fileurl);
    }

    private void initComponents(String fileurl) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        ImageIcon icon1=new ImageIcon(fileurl);
        JLabel label1=new JLabel(icon1);
        label1.setBounds(50,30,icon1.getIconWidth(),icon1.getIconHeight());
        contentPane.add(label1);
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
    }
}
