package entity.profit;

/*
用于封装"时间（月）","月订单量","月销量","月销售额","月利润"
 */
public class MonthlyStatisBean {
    private String mtime;
    private int morderquantity;
    private int msalesvolume;
    private int msales;
    private int mprofit;

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public int getMorderquantity() {
        return morderquantity;
    }

    public void setMorderquantity(int morderquantity) {
        this.morderquantity = morderquantity;
    }

    public int getMsalesvolume() {
        return msalesvolume;
    }

    public void setMsalesvolume(int msalesvolume) {
        this.msalesvolume = msalesvolume;
    }

    public int getMsales() {
        return msales;
    }

    public void setMsales(int msales) {
        this.msales = msales;
    }

    public int getMprofit() {
        return mprofit;
    }

    public void setMprofit(int mprofit) {
        this.mprofit = mprofit;
    }
}
