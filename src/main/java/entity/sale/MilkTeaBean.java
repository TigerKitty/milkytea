package entity.sale;

public class MilkTeaBean {
    private String proid;
    private String proname;
    private String sellprice;
    private int number;

    public MilkTeaBean() {
    }

    public MilkTeaBean(String proid, String proname, String sellprice, int number) {
        this.proid = proid;
        this.proname = proname;
        this.sellprice = sellprice;
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
