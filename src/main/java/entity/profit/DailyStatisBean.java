package entity.profit;

/*
用于封装"时间（日）","日订单量","日销量","日销售额","日利润"
 */
public class DailyStatisBean {
    private String dtime;
    private int dorderquantity;
    private int dsalesvolume;
    private int dsales;
    private int dprofit;

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime;
    }

    public int getDorderquantity() {
        return dorderquantity;
    }

    public void setDorderquantity(int dorderquantity) {
        this.dorderquantity = dorderquantity;
    }

    public int getDsalesvolume() {
        return dsalesvolume;
    }

    public void setDsalesvolume(int dsalesvolume) {
        this.dsalesvolume = dsalesvolume;
    }

    public int getDsales() {
        return dsales;
    }

    public void setDsales(int dsales) {
        this.dsales = dsales;
    }

    public int getDprofit() {
        return dprofit;
    }

    public void setDprofit(int dprofit) {
        this.dprofit = dprofit;
    }
}
