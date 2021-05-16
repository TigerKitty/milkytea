package dao.profit;

import entity.profit.DailyStatisBean;
import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
获取数据库的"时间（日）","日订单量","日销量","日销售额","日利润"
 */
public class DailyStatis {
    public static List dailystatis(String box1Value) {
        List<DailyStatisBean> list3=new ArrayList<DailyStatisBean>();
        String sql = "select count(distinct ordid) as doq,sum(detailnum) as dsv,sum(detailprice) as ds,sum(detailprofit) as dp from detailorder where detailorder.ordid in(select ordid  from (select ordid,substr(ordertime,1,10) from comorder where substr(ordertime,1,10)=?))";
        Dbutil dbutil = new Dbutil();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = dbutil.getPs(sql);
        try {
            preparedStatement.setString(1,box1Value);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                DailyStatisBean dailyStatisBean=new DailyStatisBean();
                Integer dorderquantity=resultSet.getInt("doq");
                Integer dsalesvolume=resultSet.getInt("dsv");
                Integer dsales=resultSet.getInt("ds");
                Integer dprofit=resultSet.getInt("dp");
                dailyStatisBean.setDorderquantity(dorderquantity);
                dailyStatisBean.setDsalesvolume(dsalesvolume);
                dailyStatisBean.setDsales(dsales);
                dailyStatisBean.setDprofit(dprofit);
                list3.add(dailyStatisBean);
            }
            return list3;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list3;
    }
}
