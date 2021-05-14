/*
 * Created by JFormDesigner on Mon Apr 26 13:04:24 CST 2021
 *//*


package swing.MainFrame;


import swing.Underway.UnderwayFrame;
import swing.onlinesale.SellFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

*/
/**
 * @author 1
 *//*

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
        JMenuItem menu = new JMenu("点奶茶");
        menuBar1.add(menu);
        menu.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) { }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        new SellFrame();
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });
        JMenuItem menu1 = new JMenu("正在进行的订单");
        menuBar1.add(menu1);
        menu1.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) { }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        new UnderwayFrame();
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });
        JMenuItem menu2 = new JMenu("查看订单记录");
        menuBar1.add(menu2);
        menu2.addMouseListener(
                new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) { }
                    @Override
                    public void mousePressed(MouseEvent e) {
                        new UnderwayFrame();
                    }
                    @Override
                    public void mouseReleased(MouseEvent e) { }
                    @Override
                    public void mouseEntered(MouseEvent e) { }
                    @Override
                    public void mouseExited(MouseEvent e) { }
                });
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

*/
