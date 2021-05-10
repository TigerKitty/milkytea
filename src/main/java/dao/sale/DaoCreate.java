package dao.sale;

import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 此类包含销售，下订单过程中的各种生成方法
 */
public class DaoCreate {
    /**
     * 生成订单号，用于线上销售
     * @param username
     * @return String 订单号
     */
    public static String CreateOnlineOrdid(String username, Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String day = sdf.format(date);//下单日期
        System.out.println("date="+date);
        String orderid = username+day;
        Dbutil dbutil = new Dbutil();
        String sql = "SELECT COUNT(*) count FROM comorder WHERE ordid LIKE ?";
        PreparedStatement ps = dbutil.getPs(sql);
        int format = 0;
        try {
            ps.setString(1,orderid+"%");
            ResultSet rs = dbutil.getRs(ps.executeQuery());
            if (rs.next()){
                String str = rs.getString("count");
                //将查出来的个数加一
                format = Integer.valueOf(str)+1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回最终得出的订单号
        return orderid+format;
    }
    /**
     * 生成订单号，用于线下销售
     * @param
     * @return String 订单号
     */
    public static String CreateOutlineOrdid(String name){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String day = sdf.format(date);//下单日期
        System.out.println("date="+date);
        String orderid = name+day;
        Dbutil dbutil = new Dbutil();
        String sql = "SELECT COUNT(*) count FROM comorder WHERE ordid LIKE ?";
        PreparedStatement ps = dbutil.getPs(sql);
        int format = 0;
        try {
            ps.setString(1,orderid+"%");
            ResultSet rs = dbutil.getRs(ps.executeQuery());
            if (rs.next()){
                String str = rs.getString("count");
                //将查出来的个数加一
                format = Integer.valueOf(str)+1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //返回最终得出的订单号
        return orderid+format;
    }
    /**
     * 获取奶茶的利润信息
     *  @param proid
     *  @return String profi利润
     */
    public static String getProProfit(String proid,int num){
        String profit = "";
        Dbutil dbutil = new Dbutil();
        String sql = "SELECT profit FROM product WHERE proid=?";
        PreparedStatement ps = dbutil.getPs(sql);
        try {
            ps.setString(1,proid);
            ResultSet rs = dbutil.getRs(ps.executeQuery());
            if (rs.next()){
                profit = rs.getString("profit");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        profit = Integer.valueOf(profit)*num+"";
        return profit;
    }
    /**
     * 获取奶茶的名称信息
     *  @param proid
     *  @return String profi利润
     */
    public static String getProName(String proid){
        String proName = "";
        Dbutil dbutil = new Dbutil();
        String sql = "SELECT proname FROM product WHERE proid=?";
        PreparedStatement ps = dbutil.getPs(sql);
        try {
            ps.setString(1,proid);
            ResultSet rs = dbutil.getRs(ps.executeQuery());
            if (rs.next()){
                proName = rs.getString("proname");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proName;
    }
}
