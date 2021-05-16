package dao.order;

import entity.dsx.orderBean;
import swing.login.Login;
import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.prefs.PreferenceChangeEvent;


public class getDaily {
    /*
用来查询日期，返回一个日期列表
 */
   public static List getDailyList() {
       Dbutil dbutil = new Dbutil();
       String sql = "select distinct substr(ordertime,1,10) as daytime from comorder WHERE status='2' and username=? order by daytime";
       PreparedStatement ps = dbutil.getPs(sql);
       List<String> list = new ArrayList<String>();
       try {
//           String username = Login.username;
//           ps.setString(1,username);
           ps.setString(1,"hzg");
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
    public static List getListByDaily(String date){
        Dbutil dbutil=new Dbutil();
        List list=new ArrayList<orderBean>();
        String sql="SELECT *" +
                " FROM(SELECT c.ordid,p.proname,p.sellprice,d.detailnum,d.detailprice,c.ordertime, c.username\n" +
                " FROM product p,comorder c,detailorder d\n" +
                " WHERE p.proid=d.proid and c.ordid=d.ordid and status='2')\n" +
                " WHERE  username=? AND ordertime LIKE ?";
        System.out.println("SQL:"+sql);
        PreparedStatement ps=dbutil.getPs(sql);
        try {
            ps.setString(2,date+"%");
            ps.setString( 1,"hzg");
            ResultSet rs = dbutil.getRs(ps.executeQuery());
            while (rs.next()){
                orderBean orderBean = new orderBean();
                orderBean.setOrdid(rs.getString("ordid"));
                orderBean.setProname(rs.getString("proname"));
                orderBean.setSellprice(rs.getString("sellprice"));
                orderBean.setDetailnum(rs.getString("detailnum"));
                orderBean.setDetailprice(rs.getString("detailprice"));
                orderBean.setOrdertime((rs.getString("ordertime")));
                //orderBean.setUsername(rs.getString("username"));

                list.add(orderBean);
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
        List list=new ArrayList<orderBean>();
        String sql="SELECT *" +
                " FROM(SELECT c.ordid,p.proname,p.sellprice,d.detailnum,d.detailprice,c.ordertime, c.username\n" +
                " FROM product p,comorder c,detailorder d\n" +
                " WHERE p.proid=d.proid and c.ordid=d.ordid and status='2')\n" +
                " WHERE  username=?";
        System.out.println("SQL:"+sql);
        PreparedStatement ps=dbutil.getPs(sql);
        try {
            ps.setString( 1,"hzg");
            ResultSet rs = dbutil.getRs(ps.executeQuery());
            while (rs.next()){
                orderBean orderBean = new orderBean();
                orderBean.setOrdid(rs.getString("ordid"));
                orderBean.setProname(rs.getString("proname"));
                orderBean.setSellprice(rs.getString("sellprice"));
                orderBean.setDetailnum(rs.getString("detailnum"));
                orderBean.setDetailprice(rs.getString("detailprice"));
                orderBean.setOrdertime((rs.getString("ordertime")));
                //orderBean.setUsername(rs.getString("username"));

                list.add(orderBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}