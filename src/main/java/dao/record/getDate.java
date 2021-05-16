package dao.record;

import entity.record.RecordBean;
import swing.login.Login;
import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;


public class getDate {
    /*
用来查询日期，返回一个日期列表
 */
    public static List getDateList() {
        Dbutil dbutil = new Dbutil();
        String sql = "select distinct substr(ordertime,1,10) as daytime from comorder WHERE status IN (2,3) order by daytime";
        PreparedStatement ps = dbutil.getPs(sql);
        List<String> list = new ArrayList<String>();
        try {
//
            ResultSet rs = dbutil.getRs(ps.executeQuery());
            while(rs.next()){
                String str = rs.getString("daytime");
                list.add(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 通过日期模糊查询某一天的订单
     */
    public static List getListByDate(String date){
        Dbutil dbutil=new Dbutil();
        List list=new ArrayList<RecordBean>();
        String sql="select c.ordid,c.username,c.ordertime,p.proname,d.detailnum,d.detailprice,c.status " +
                "from product p,comorder c,detailorder d " +
                "where p.proid=d.proid and c.ordid=d.ordid " +
                "and c.status IN (2,3) AND ordertime LIKE ?";
        System.out.println("SQL:"+sql);
        PreparedStatement ps=dbutil.getPs(sql);
        try {
            ps.setString(1,date+"%");

            ResultSet rs = dbutil.getRs(ps.executeQuery());
            while (rs.next()){
                RecordBean RecordBean=new RecordBean();
                RecordBean.setOrdid(rs.getString("ordid"));
                RecordBean.setUsername(rs.getString("username"));
                RecordBean.setOrdertime(rs.getString("ordertime"));
                RecordBean.setProname(rs.getString("proname"));
                RecordBean.setDetailnum(rs.getString("detailnum"));
                RecordBean.setDetailprice(rs.getString("detailprice"));

                list.add(RecordBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 查询所有订单
     */
    public static List getList(){
        Dbutil dbutil=new Dbutil();
        List list=new ArrayList<RecordBean>();
        String sql="select c.ordid,c.username,c.ordertime,p.proname,d.detailnum,d.detailprice,c.status " +
                "from product p,comorder c,detailorder d " +
                "where p.proid=d.proid and c.ordid=d.ordid " +
                "and c.status IN (2,3)";
        System.out.println("SQL:"+sql);
        PreparedStatement ps=dbutil.getPs(sql);
        try {

            ResultSet rs = dbutil.getRs(ps.executeQuery());
            while (rs.next()){
                RecordBean RecordBean=new RecordBean();
                RecordBean.setOrdid(rs.getString("ordid"));
                RecordBean.setUsername(rs.getString("username"));
                RecordBean.setOrdertime(rs.getString("ordertime"));
                RecordBean.setProname(rs.getString("proname"));
                RecordBean.setDetailnum(rs.getString("detailnum"));
                RecordBean.setDetailprice(rs.getString("detailprice"));

                list.add(RecordBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}