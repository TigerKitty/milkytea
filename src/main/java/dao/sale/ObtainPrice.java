package dao.sale;

import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 查询对应商品id的价格
 */
public class ObtainPrice {
    public String obtainprice(String proid){
        String sql="select sellprice from product where proid=?";
        Dbutil dbutil=new Dbutil();
        ResultSet resultSet=null;
        PreparedStatement preparedStatement=dbutil.getPs(sql);
        try {
            preparedStatement.setString(1,proid);
            resultSet=preparedStatement.executeQuery();
            if (resultSet.next()){
                String sellprice=resultSet.getString("sellprice");
                return sellprice;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "0";
    }
}
