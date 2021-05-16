/*
 * Created by JFormDesigner on Fri May 14 22:34:43 CST 2021
 */

package swing.lnc;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class CautionFrame extends JFrame {
    public CautionFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u8bf7\u9009\u62e9\u8ba2\u5355\uff01");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1);
        label1.setBounds(65, 20, 140, 75);

        contentPane.setPreferredSize(new Dimension(250, 160));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
