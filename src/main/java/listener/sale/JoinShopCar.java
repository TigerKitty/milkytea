package listener.sale;

import entity.sale.MilkTeaBean;

import java.util.List;

/**
 * 用于加入购物车时，同一种奶茶数量累加
 */
public class JoinShopCar {
    /**
     * 用于线上销售加入购物车时，同一种奶茶数量累加
     */
    public static List<MilkTeaBean> joinArrays(List<MilkTeaBean> list, String proid,String proname,String number,String sellprice){
        if (list.size()!=0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getProid().equals(proid)) {
                    list.get(i).setNumber(list.get(i).getNumber() + Integer.valueOf(number));
                    return list;
                } else if (i==list.size()-1) {
                    MilkTeaBean milkTeaBean1 = new MilkTeaBean();
                    milkTeaBean1.setProid(proid);
                    milkTeaBean1.setProname(proname);
                    milkTeaBean1.setNumber(Integer.parseInt(number));
                    milkTeaBean1.setSellprice(sellprice);
                    list.add(milkTeaBean1);
                    return list;
                }
            }
        }
        else {
            MilkTeaBean milkTeaBean1 = new MilkTeaBean();
            milkTeaBean1.setProid(proid);
            milkTeaBean1.setProname(proname);
            milkTeaBean1.setNumber(Integer.parseInt(number));
            milkTeaBean1.setSellprice(sellprice);
            list.add(milkTeaBean1);
        }
        return  list;
    }
    /**
     * 用于线下销售加入购物车时，同一种奶茶数量累加
     */
    public static List<MilkTeaBean> joinOutlineArr(List<MilkTeaBean> list, String proid,String proname,String number,String sellprice){
        if (list.size()!=0) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getProid().equals(proid)) {
                    list.get(i).setNumber(list.get(i).getNumber() + Integer.valueOf(number));
                    return list;
                } else if (i==list.size()-1) {
                    MilkTeaBean milkTeaBean1 = new MilkTeaBean();
                    milkTeaBean1.setProid(proid);
                    milkTeaBean1.setProname(proname);
                    milkTeaBean1.setNumber(Integer.parseInt(number));
                    milkTeaBean1.setSellprice(sellprice);
                    list.add(milkTeaBean1);
                    return list;
                }
            }
        }
        else {
            MilkTeaBean milkTeaBean1 = new MilkTeaBean();
            milkTeaBean1.setProid(proid);
            milkTeaBean1.setProname(proname);
            milkTeaBean1.setNumber(Integer.parseInt(number));
            milkTeaBean1.setSellprice(sellprice);
            list.add(milkTeaBean1);
        }
        return  list;
    }
}
