package entity.profit;

/*
用于封装奶茶名称及其销量
 */
public class ProductDean {
    private String proname;
    private String pronumber;

    public ProductDean() {
    }

    public ProductDean(String proname, String pronumber) {
        this.proname = proname;
        this.pronumber = pronumber;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getPronumber() {
        return pronumber;
    }

    public void setPronumber(String pronumber) {
        this.pronumber = pronumber;
    }
}
