package entity.sale.profit;

public class DailyStateBean {
    private String time;
    private int orderquantity;
    private int dailysalesvolume;
    private int dailysales;
    private int dailyprofit;

    public String getTime() {
        return time;
    }

    public void setTime(String ordertime) {
        this.time = ordertime;
    }

    public int getOrderquantity() {
        return orderquantity;
    }

    public void setOrderquantity(int orderquantity) {
        this.orderquantity = orderquantity;
    }

    public int getDailysalesvolume() {
        return dailysalesvolume;
    }

    public void setDailysalesvolume(int dailysalesvolume) {
        this.dailysalesvolume = dailysalesvolume;
    }

    public int getDailysales() {
        return dailysales;
    }

    public void setDailysales(int dailysales) {
        this.dailysales = dailysales;
    }

    public int getDailyprofit() {
        return dailyprofit;
    }

    public void setDailyprofit(int dailyprofit) {
        this.dailyprofit = dailyprofit;
    }
}
