package dao.login;

import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 用于封装获取各类信息的方法
 */
public class Get {
    /**
     * 根据传来的信息查询数据库，获得对应的信息更新数组并返回
     * Object[][] 购物车已有货物, String 商品名,String 商品数量
     * @return Object[][] 包含购物车当前的信息
     */
    public Object[][] getCartArrays(Object[][] cart, String goodName, String goodNum) throws SQLException {
        //将传来的cart扩容一行
        int con = 0;
        int len = cart.length;
        Object[][] newCart = new Object[len+1][4];
        for(Object[] c : cart){
            //复制给扩容的对象
            newCart[con++] = c;
        }
        Dbutil dbutil = new Dbutil();
        //查询商品表对应的商品单价
        //暂时只能拼串
        String sql = "SELECT \"sellprice\" FROM \"stock\"";
        System.out.println(sql);
        PreparedStatement ps = dbutil.getPs(sql);
        try{
            //ps.setString(1,goodName);
            ResultSet rs = dbutil.getRs(ps.executeQuery());
            if(rs.next()){
                //得到单价
                int goodPrice = Integer.valueOf(rs.getString("sellprice"));
                //得到总价
                int totalPrice = goodPrice*Integer.valueOf(goodNum);
                newCart[len][0] = goodName;
                newCart[len][1] = goodNum;
                newCart[len][2] = goodPrice;
                newCart[len][3] = totalPrice;
            }
        }finally {
            //dbutil.closeAll();
        }
        return newCart;
    }
}
