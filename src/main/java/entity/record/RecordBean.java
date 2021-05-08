package entity.record;

public class RecordBean {
    private String ordid;
    private String username;
    private String ordertime;
    private String proname;
    private String detailnum;
    private String detailprice;
    private String status;

    public RecordBean() {
    }

    public RecordBean(String ordid, String username, String ordertime, String proname, String detailnum, String detailprice, String status) {
        this.ordid = ordid;
        this.username = username;
        this.ordertime = ordertime;
        this.proname = proname;
        this.detailnum = detailnum;
        this.detailprice = detailprice;
        this.status = status;
    }

    public String getOrdid() {
        return ordid;
    }

    public void setOrdid(String ordid) { this.ordid = ordid; }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }


    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
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


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




}

