package dao.profit;

import entity.sale.profit.DailyStateBean;
import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DailyState {
    public List dailystate() {
        List<DailyStateBean> list1=new ArrayList<DailyStateBean>();
        String sql = "select distinct substr(ordertime,1,10) as daytime from comorder";
        Dbutil dbutil = new Dbutil();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = dbutil.getPs(sql);
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                DailyStateBean dailyStateBean=new DailyStateBean();
                String dailytime=resultSet.getString("daytime");
                dailyStateBean.setDailytime(dailytime);
                list1.add(dailyStateBean);
            }
            return list1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list1;
    }
}
