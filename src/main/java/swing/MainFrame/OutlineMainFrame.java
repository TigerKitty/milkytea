package swing.MainFrame;

import javax.swing.*;
import java.awt.*;

public class OutlineMainFrame extends JFrame{
    public static void main(String[] args) {
        OutlineMainFrame mainFrame=new OutlineMainFrame();
    }
    public OutlineMainFrame() {
        initComponents();
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        JMenuItem menu = new JMenu("点奶茶");
        menuBar1.add(menu);
        JMenuItem menu1 = new JMenu("订单管理");
        menuBar1.add(menu1);
        item=new JMenuItem("正在进行的订单");
        menu1.add(item);
        item1=new JMenuItem("已完成订单记录");
        menu1.add(item1);
        JMenu menu2 = new JMenu("利润统计");
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
    private JMenuItem item;
    private JMenuItem item1;

    // JFormDesigner - End of variables declaration  //GEN-END:variables

}
