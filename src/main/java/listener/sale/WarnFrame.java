package listener.sale;

import javax.swing.*;

/*
**用户没有输入数量时或购物车为零，提交订单时弹出警告框
 */
public class WarnFrame {
    public static void shopwarnFrame(){
        JFrame frame = new JFrame("加入购物车失败");
        JOptionPane.showMessageDialog(frame, "请添加数量",

                "加入购物车失败", JOptionPane.WARNING_MESSAGE);
    }
    public static void orderwarnFrame(){
        JFrame frame = new JFrame("提交订单失败");
        JOptionPane.showMessageDialog(frame, "您的购物车为零，请选购商品",

                "提交订单失败", JOptionPane.WARNING_MESSAGE);
    }
}
