package dao.sale;

import entity.MilkTeaBean;
import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 从数据库获取商品到下拉框中，供选择
 */
public class FindProduct {
    public List findprodyct() {
        List<MilkTeaBean>list=new ArrayList<MilkTeaBean>();
        String sql = "select proid,proname from product";
        Dbutil dbutil = new Dbutil();
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = dbutil.getPs(sql);
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                MilkTeaBean milkTeaBean=new MilkTeaBean();
                String proid=resultSet.getString("proid");
                String proname=resultSet.getString("proname");
                milkTeaBean.setProid(proid);
                milkTeaBean.setProname(proname);
                list.add(milkTeaBean);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
