/*
 * Created by JFormDesigner on Mon Apr 26 13:04:24 CST 2021
 */

package swing.MainFrame;


import javax.swing.*;
import java.awt.*;

/**
 * @author 1
 */
public class OnlineMainFrame extends JFrame {
    public static void main(String[] args) {
        OnlineMainFrame mainFrame=new OnlineMainFrame();
    }
    public OnlineMainFrame() {
        initComponents();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        JMenu menu = new JMenu("点奶茶");
        menuBar1.add(menu);
        JMenu menu1 = new JMenu("查看订单状态");
        menuBar1.add(menu1);
        JMenu menu2 = new JMenu("查看订单记录");
        menuBar1.add(menu2);
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        setJMenuBar(menuBar1);
        contentPane.setPreferredSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;

    // JFormDesigner - End of variables declaration  //GEN-END:variables

}

