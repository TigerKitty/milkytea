package dao.sale;

import entity.sale.BillOrdBean;
import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 用户结账后，利用此方法向数据库的订单表中中插入对应的订单数据
 */
public class DaoInsBillOrd {
    /**
     * 向order表中插入信息
     */
    public static boolean insOrder(BillOrdBean bb){
        Dbutil dbutil = new Dbutil();
        String sql = "INSERT INTO comorder (ordid,username,ordertime,trantime,status) VALUES(?,?,?,?,?)";
        PreparedStatement ps = dbutil.getPs(sql);
        try {
            ps.setString(1,bb.getOrdid());
            ps.setString(2,bb.getUsername());
            ps.setString(3,bb.getOrdertime());
            ps.setString(4,bb.getTrantime());
            ps.setString(5,bb.getStatus());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
