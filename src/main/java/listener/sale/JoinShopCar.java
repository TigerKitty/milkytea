package listener.sale;

import entity.sale.MilkTeaBean;

import java.util.List;

/**
 * 用于加入购物车时，同一种奶茶数量累加
 */
public class JoinShopCar {
    public static List<MilkTeaBean> joinArrays(List<MilkTeaBean> list, String proid,String number){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getProid().equals(proid)){
                list.get(i).setNumber(list.get(i).getNumber()+Integer.valueOf(number));
                return list;
            }
        }
        return  list;
    }
}
