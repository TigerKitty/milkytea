package entity.sale.profit;

public class MonthlyStateBean {
    private String monthlytime;
    private int monthlyorderquantity;
    private int monthlysalesvolume;
    private int monthlysales;
    private int monthlyprofit;

    public String getMonthlytime() {
        return monthlytime;
    }

    public void setMonthlytime(String monthlytime) {
        this.monthlytime = monthlytime;
    }

    public int getMonthlyorderquantity() {
        return monthlyorderquantity;
    }

    public void setMonthlyorderquantity(int monthlyorderquantity) {
        this.monthlyorderquantity = monthlyorderquantity;
    }

    public int getMonthlysalesvolume() {
        return monthlysalesvolume;
    }

    public void setMonthlysalesvolume(int monthlysalesvolume) {
        this.monthlysalesvolume = monthlysalesvolume;
    }

    public int getMonthlysales() {
        return monthlysales;
    }

    public void setMonthlysales(int monthlysales) {
        this.monthlysales = monthlysales;
    }

    public int getMonthlyprofit() {
        return monthlyprofit;
    }

    public void setMonthlyprofit(int monthlyprofit) {
        this.monthlyprofit = monthlyprofit;
    }
}
