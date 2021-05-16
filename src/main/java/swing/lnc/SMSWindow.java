/*
 * Created by JFormDesigner on Fri May 14 20:54:10 CST 2021
 */

package swing.lnc;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class SMSWindow extends JFrame {
    public SMSWindow(String send) {
        initComponents(send);
    }

    private void initComponents(String send) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText(send);
        contentPane.add(label1);
        label1.setBounds(70, 20, 115, 55);

        contentPane.setPreferredSize(new Dimension(225, 140));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
