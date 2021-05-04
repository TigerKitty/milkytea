package entity.sale;
/**
 * 用于封装详细订单需要插入的数据
 */
public class DetailOrdBean {
    private String ordid;
    private String proid;
    private String detailnum;
    private String detailprice;
    private String detailprofit;

    public String getOrdid() {
        return ordid;
    }

    public void setOrdid(String ordid) {
        this.ordid = ordid;
    }

    public String getProid() {
        return proid;
    }

    public void setProid(String proid) {
        this.proid = proid;
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

    public String getDetailprofit() {
        return detailprofit;
    }

    public void setDetailprofit(String detailprofit) {
        this.detailprofit = detailprofit;
    }
    public String toStirng(){
        return "DetailOrderBean:{ordid="+ordid+","+
                "proid="+proid+","+
                "detailnum="+detailnum+","+
                "detailprice="+detailprice+","+
                "detailprofit="+detailprofit+"}";
    }
}
