package listener.sale;

import dao.sale.DaoCreate;
import dao.sale.DaoInsert;
import entity.sale.BillOrdBean;
import entity.sale.DetailOrdBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 包含有关线下下订单信息添加的方法
 */
public class OutlineOrderMes {
    /**
     * 将订单信息加入到comorder数据库表中
     */
    public static void insertComOrd(String name,String orderid){
        //生成下单时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        String ordertime = sdf.format(date);
        String status = "3";// “3” 代表线下销售
        //将信息封装
        BillOrdBean billOrdBean = new BillOrdBean();
        billOrdBean.setOrdid(orderid);
        billOrdBean.setUsername(name);
        billOrdBean.setOrdertime(ordertime);
        billOrdBean.setStatus(status);
        //将信息加入comorder数据库表
        DaoInsert.insOutlineComMes(billOrdBean);
    }

    /**
     * 将订单信息加入到detailorder数据库表中
     */
    public static boolean insertDetailOrd(Object[][] tableDate,String orderid){
        if (tableDate.length==0 || tableDate==null){
            return false;
        }
        DetailOrdBean dob = new DetailOrdBean();
        //循环遍历二维数组中的数据封装后再进行插入
        for(Object[] obj : tableDate){
            String proid = (String)obj[0];
            String num = obj[2].toString();
            String singleprice = (String) obj[3];
            String price = Integer.valueOf(singleprice)*Integer.valueOf(num)+"";
            String profit = DaoCreate.getProProfit(proid,Integer.valueOf(num));
            dob.setOrdid(orderid);
            dob.setProid(proid);
            dob.setDetailnum(num);
            dob.setDetailprice(price);
            dob.setDetailprofit(profit);
            System.out.println(dob.toStirng());
            //插入数据
            DaoInsert.insDetailOrd(dob);
        }
        return true;
    }
}
