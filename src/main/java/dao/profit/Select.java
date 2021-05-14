package dao.profit;

import entity.profit.ProductDean;
import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Select {
    public static List<ProductDean> selectm() {
        String sql="select proname,pronumber\n" +
                "from(select product.proid as proid,count(product.proname) as pronumber \n" +
                "from detailorder,comorder,product \n" +
                "where detailorder.ordid=comorder.ordid and substr(comorder.ordertime,6,2)=? and product.proid=detailorder.proid\n" +
                "group by product.proid) a,product\n" +
                "where product.proid=a.proid(+)";
        Dbutil dbutil=new Dbutil();
        PreparedStatement preparedStatement= dbutil.getPs(sql);
        List<ProductDean>list=new ArrayList<ProductDean>();
        try {
            preparedStatement.setString(1,"05");
            ResultSet res=preparedStatement.executeQuery();

            while (res.next()){
                ProductDean productDean=new ProductDean();
                if(res.getString("pronumber")!=null) {
                    String proname = res.getString("proname");
                    String pronumber = res.getString("pronumber");
                    productDean.setProname(proname);
                    productDean.setPronumber(pronumber);
                }
                else {
                    String proname = res.getString("proname");
                    String pronumber = "0";
                    productDean.setProname(proname);
                    productDean.setPronumber(pronumber);
                }
                list.add(productDean);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }

    }
    public static List<ProductDean> selecty() {
        String sql="select proname,pronumber\n" +
                "from(select product.proid as proid,count(product.proname) as pronumber \n" +
                "from detailorder,comorder,product \n" +
                "where detailorder.ordid=comorder.ordid and substr(comorder.ordertime,1,4)=? and product.proid=detailorder.proid\n" +
                "group by product.proid) a,product\n" +
                "where product.proid=a.proid(+)";
        Dbutil dbutil=new Dbutil();
        PreparedStatement preparedStatement= dbutil.getPs(sql);
        List<ProductDean>list=new ArrayList<ProductDean>();
        try {
            preparedStatement.setString(1,"2021");
            ResultSet res=preparedStatement.executeQuery();

            while (res.next()){
                ProductDean productDean=new ProductDean();
                if(res.getString("pronumber")!=null) {
                    String proname = res.getString("proname");
                    String pronumber = res.getString("pronumber");
                    productDean.setProname(proname);
                    productDean.setPronumber(pronumber);
                }
                else {
                    String proname = res.getString("proname");
                    String pronumber = "0";
                    productDean.setProname(proname);
                    productDean.setPronumber(pronumber);
                }
                list.add(productDean);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }

    }
}
