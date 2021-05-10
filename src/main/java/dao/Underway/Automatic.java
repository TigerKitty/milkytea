package dao.Underway;

import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Automatic {
    //自动收货方法
    public static String[] automatic(){
        List<String> list = new ArrayList<String>();
        String times[]=null;
        Dbutil dbutil = new Dbutil();
        String sql = "SELECT TRANTIME\n" +
                "FROM comorder\n" +
                "WHERE status=?";
        ResultSet rs = null;
        PreparedStatement ptm = dbutil.getPs(sql);
        try {
            ptm.setString(1, String.valueOf(1));
            rs=ptm.executeQuery();
            while(rs.next()){
                String date = rs.getString("trantime");
                list.add(date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        times=new String[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            times[i]=list.get(i);
        }
        return times;
    }
    public static void right(){
        String times[] = automatic();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm" );//设置日期格式
        Date date , mydate;
        Dbutil dbutil = new Dbutil();
        String ordid = null;
        for (int i = 0; i < times.length; i++) {
            try {
                ResultSet rs = null;
                String sql = "SELECT ordid FROM comorder WHERE trantime =? and status=?";
                PreparedStatement ptm = dbutil.getPs(sql);
                try {
                    ptm.setString(1, (String) times[i]);
                    ptm.setString(2, String.valueOf(1));
                    rs = ptm.executeQuery();
                    rs.next();
                        ordid = rs.getString(1);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        ptm.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
                date = df.parse((String) times[i]);
                mydate = df.parse(df.format(new Date()));
                long day=(mydate.getTime()-date.getTime())/(60*60*1000);//与当前时间的间隔(小时)
                if(day>=1){
                    String sql1 = "update comorder set status=? where ordid = ?";
                    PreparedStatement ptem = dbutil.getPs(sql1);
                    try {
                        ptem.setString(1,"2");
                        ptem.setString(2,ordid);
                        ptem.executeUpdate();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } finally {
                        try {
                            ptem.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
