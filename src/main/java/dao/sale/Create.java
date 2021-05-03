package dao.sale;

import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 此类包含销售，下订单过程中的各种生成方法
 */
public class Create {
    /**
     * 生成订单号
     * @param username
     * @return String 订单号
     */
    public static String CreateOrdid(String username){
        Dbutil dbutil = new Dbutil();
        String sql = "SELECT COUNT(*) count FROM comorder WHERE ordid LIKE ?";
        PreparedStatement ps = dbutil.getPs(sql);
        int format = 0;
        try {
            ps.setString(1,username+"%");
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
        return username+format;
    }
}
