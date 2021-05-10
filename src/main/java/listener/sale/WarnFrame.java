package listener.sale;

import javax.swing.*;

/**
*用户没有输入数量时或购物车为零，提交订单时弹出警告框
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
    //从购物车删除报错时弹出该框
    public static void deletewarnFrame(){
        JFrame frame = new JFrame("删除失败");
        JOptionPane.showMessageDialog(frame, "您没有选中商品，请选中商品进行删除",

                "删除失败", JOptionPane.WARNING_MESSAGE);
    }
    public static void outlinePaywarnFrame(){
        JFrame frame = new JFrame("支付失败");
        JOptionPane.showMessageDialog(frame, "支付超时，请重新结账生成",

                "支付失败", JOptionPane.WARNING_MESSAGE);
    }
    public static void outlinePoswarnFrame(){
        JFrame frame = new JFrame("支付失败");
        JOptionPane.showMessageDialog(frame, "支付失败",

                "支付失败", JOptionPane.WARNING_MESSAGE);
    }
    public static void outlinePoswarnFrame1(){
        JFrame frame = new JFrame("支付成功");
        JOptionPane.showMessageDialog(frame, "支付成功",

                "支付成功", JOptionPane.WARNING_MESSAGE);
    }

}
