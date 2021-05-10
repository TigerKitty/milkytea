package dao.profit;

import entity.profit.MonthlyStatisBean;
import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MonthlyStatis {
    public List monthlystatis(String box2Value) {
        List<MonthlyStatisBean> list4=new ArrayList<MonthlyStatisBean>();
        String sql ="select count(distinct ordid) as moq,sum(detailnum) as msv,sum(detailprice) as ms,sum(detailprofit) as mp from detailorder where detailorder.ordid in(select ordid  from (select ordid,substr(ordertime,1,7) from comorder where substr(ordertime,1,7)=?))";
        Dbutil dbutil = new Dbutil();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = dbutil.getPs(sql);
        try {
            preparedStatement.setString(1,box2Value);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                MonthlyStatisBean monthlyStatisBean=new MonthlyStatisBean();
                Integer morderquantity=resultSet.getInt("moq");
                Integer msalesvolume=resultSet.getInt("msv");
                Integer msales=resultSet.getInt("ms");
                Integer mprofit=resultSet.getInt("mp");
                monthlyStatisBean.setMorderquantity(morderquantity);
                monthlyStatisBean.setMsalesvolume(msalesvolume);
                monthlyStatisBean.setMsales(msales);
                monthlyStatisBean.setMprofit(mprofit);
                list4.add(monthlyStatisBean);
            }
            return list4;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list4;
    }
}
