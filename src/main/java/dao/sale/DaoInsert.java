package dao.sale;

import entity.sale.BillOrdBean;
import entity.sale.DetailOrdBean;
import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * 用户结账后，利用此方法向数据库的订单表中中插入对应的订单数据
 */
public class DaoInsert {
    /**
     * 线上：向comorder表中插入信息
     */
    public static boolean insComOrder(BillOrdBean bb){
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
    /**
     * 线上：向detailorder表中插入信息
     */
    public static boolean insDetailOrd(DetailOrdBean dob){
        Dbutil dbutil = new Dbutil();
        String sql = "INSERT INTO detailorder VALUES(?,?,?,?,?)";
        PreparedStatement ps = dbutil.getPs(sql);
        try {
            ps.setString(1,dob.getOrdid());
            ps.setString(2,dob.getProid());
            ps.setString(3,dob.getDetailnum());
            ps.setString(4,dob.getDetailprice());
            ps.setString(5,dob.getDetailprofit());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *线下：向comorder表中插入信息
     */
    public static boolean insOutlineComMes(BillOrdBean bb) {
        Dbutil dbutil = new Dbutil();
        String sql = "INSERT INTO comorder (ordid,username,ordertime,status) VALUES(?,?,?,?)";
        PreparedStatement ps = dbutil.getPs(sql);
        try {
            ps.setString(1,bb.getOrdid());
            ps.setString(2,bb.getUsername());
            ps.setString(3,bb.getOrdertime());
            ps.setString(4,bb.getStatus());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
