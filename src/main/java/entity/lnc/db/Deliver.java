package entity.lnc.db;

public class Deliver {
    //    String phone;
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }
    public String phone0="18007886230";
    public String phone1="18177028834";
    public String phone2="15246604968";//小狗
    //    public String phone3="15177326017";//辣椒
    public String getPhone(int phone){
        if (phone == 0) {
            return phone0;
        }else if(phone == 1){
            return phone1;
        } else{
            return phone2;
        }
    }
}
