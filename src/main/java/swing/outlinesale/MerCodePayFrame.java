/*
 * Created by JFormDesigner on Mon May 03 15:23:29 CST 2021
 */

package swing.outlinesale;

import java.awt.*;
import javax.swing.*;

/**
 * ��ʾ��ά��֧����������
 */
public class MerCodePayFrame extends JFrame {
    public MerCodePayFrame(String fileurl) {
        initComponents(fileurl);
    }

    private void initComponents(String fileurl) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        this.setTitle("����֧����ɨ��֧��");
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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
