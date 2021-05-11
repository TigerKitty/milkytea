package entity.dsx;

public class orderBean {

    private  String username;
    private  String ordid;
    private  String proname;
    private  String sellprice;
    private  String detailnum;
    private  String detailprice;
    private  String ordertime;
    private  String status;




    public orderBean(String username, String ordid, String proname, String sellprice, String detailnum, String detailprice, String ordertime, String status) {
        this.username = username;
        this.ordid = ordid;
        this.proname = proname;
        this.sellprice = sellprice;
        this.detailnum = detailnum;
        this.detailprice= detailprice;
        this.ordertime = ordertime;
        this.status = status;

    }

    public orderBean() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrdid() {
        return ordid;
    }

    public void setOrdid(String ordid) {
        this.ordid = ordid;
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

    public String getDetailnum() {
        return detailnum;
    }

    public void setDetailnum(String detailnum) {
        this.detailnum = detailnum;
    }

    public String getDetailprice() {
        return detailprice;
    }

    public void setDetailprice(String detailprice) {
        this.detailprice = detailprice;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
