package dao.profit;

import entity.profit.MonthlyStateBean;
import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonthlyState {
    public List monthlystate() {
        List<MonthlyStateBean> list2=new ArrayList<MonthlyStateBean>();
        String sql = "select distinct substr(ordertime,1,7) as monthtime from comorder order by monthtime";
        Dbutil dbutil = new Dbutil();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = dbutil.getPs(sql);
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                MonthlyStateBean monthlyStateBean=new MonthlyStateBean();
                String monthlytime=resultSet.getString("monthtime");
                monthlyStateBean.setMonthlytime(monthlytime);
                list2.add(monthlyStateBean);
            }
            return list2;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list2;
    }
}
