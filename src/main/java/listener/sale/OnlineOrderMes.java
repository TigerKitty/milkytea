package listener.sale;

import dao.sale.DaoCreate;
import dao.sale.DaoInsert;
import entity.sale.BillOrdBean;
import entity.sale.DetailOrdBean;
import entity.sale.MilkTeaBean;

import java.util.List;

/**
 * 包含有关线上下订单信息添加的方法
 */
public class OnlineOrderMes {
    /**
     * 将订单信息加入到comorder数据库表中
     */
    public static void insertComOrd(String orderid,String ordertime,String trantime){
        //将此订单所需信息封装
        BillOrdBean bb = new BillOrdBean();
        bb.setOrdertime(ordertime);
        bb.setTrantime(trantime);
        bb.setStatus("0");
        bb.setOrdid(orderid);
        //这里需要获取登录的信息
        bb.setUsername("hzg");
        //将信息加入到comorder数据库表
        DaoInsert.insComOrder(bb);
    }

    /**
     * 将订单的详情信息加入到detailorder数据库表
     */
    public static void insertDetailOrd(String orderid,List<MilkTeaBean> list){
        DetailOrdBean dob = new DetailOrdBean();
        //循环遍历列表中的实体类获取到所用的信息再进行插入
        for(MilkTeaBean mb : list){
            String proid = mb.getProid();
            String num = mb.getNumber()+"";
            String price = (Integer.valueOf(mb.getSellprice())* mb.getNumber())+"";
            String profit = DaoCreate.getProProfit(proid,mb.getNumber());
            dob.setOrdid(orderid);
            dob.setProid(proid);
            dob.setDetailnum(num);
            dob.setDetailprice(price);
            dob.setDetailprofit(profit);
            System.out.println(dob.toStirng());
            //插入数据
            DaoInsert.insDetailOrd(dob);
        }
    }
}
