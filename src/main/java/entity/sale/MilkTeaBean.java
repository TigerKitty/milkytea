package entity.sale;

/**
 * 封装购买奶茶所需要的各个信息
 */
public class MilkTeaBean {
    private String proid;
    private String proname;
    private String sellprice;
    private String buyprice;
    private String profit;

    public String getBuyprice() {
        return buyprice;
    }

    public void setBuyprice(String buyprice) {
        this.buyprice = buyprice;
    }

    public String getProfit() {
        return profit;
    }

    public void setProfit(String profit) {
        this.profit = profit;
    }

    private int number;

    public MilkTeaBean() {
    }

    public MilkTeaBean(String proid, String proname, String sellprice,String buyprice,String profit, int number) {
        this.proid = proid;
        this.proname = proname;
        this.sellprice = sellprice;
        this.buyprice = buyprice;
        this.profit = profit;

        this.number=number;
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getSellprice() {
        return sellprice;
    }

    public void setSellprice(String sellprice) {
        this.sellprice = sellprice;
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
