package swing.addProduct;

import entity.sale.MilkTeaBean;
import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class getTabel {
    public static Object[][] queryDate(){
        Dbutil dbutil = new Dbutil();
        List<MilkTeaBean> list = new ArrayList<MilkTeaBean>();
        String sql = "select proid,proname,sellprice,buyprice,profit from product";
        PreparedStatement preparedStatement = dbutil.getPs(sql);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                MilkTeaBean milkTeaBean = new MilkTeaBean();
                milkTeaBean.setProid(resultSet.getString("proid"));
                milkTeaBean.setProname(resultSet.getString("proname"));
                milkTeaBean.setSellprice(resultSet.getString("sellprice"));
                milkTeaBean.setBuyprice(resultSet.getString("buyprice"));
                milkTeaBean.setProfit(resultSet.getString("profit"));
                list.add(milkTeaBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Object[][] Date = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            Date[i][0] = list.get(i).getProid();
            Date[i][1] = list.get(i).getProname();
            Date[i][2] = list.get(i).getSellprice();
            Date[i][3] = list.get(i).getBuyprice();
            Date[i][4] = list.get(i).getProfit();
        }
        return Date;
    }
}
