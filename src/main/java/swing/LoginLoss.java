/*
 * Created by JFormDesigner on Sat Apr 24 15:57:48 CST 2021
 */

package swing;

import java.awt.*;
import javax.swing.*;

/**
 * @author 1
 */
public class LoginLoss extends JFrame {
    public LoginLoss() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u51fa\u73b0\u9519\u8bef\u4e86");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(165, 95), button1.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        //调用时显示面板,
        setVisible(true);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
