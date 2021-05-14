package dao.Underway;

import swing.login.Login;
import util.Dbutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/*用于提取数据库中用户正在进行的订单，然后保存与二维数组中。
 * */
public class GetDate {
    public static int num = 1;
    public static String head[] = {"订单编号", "用户名", "下单时间","配送时间","到达时间","订单状态"};
    private Object[][] data = null;
    private String status;
    public Object[][] UsersData() {
        java.util.List<Userinfo> list = new ArrayList<Userinfo>();
        Dbutil dbutil = new Dbutil();
        String sql = "SELECT *\n" +
                "FROM(SELECT c.ordid,u.uname,u.username,c.ordertime,c.trantime,c.receivetime,c.status\n" +
                "FROM comorder c,users u\n" +
                "WHERE c.username=u.username)\n" +
                "WHERE username=? and status=?";
        ResultSet rs = null;
        PreparedStatement ptem = dbutil.getPs(sql);
        try {
            String username = Login.username;
            ptem.setString(1,username);
            ptem.setString(2, String.valueOf(num));
            rs=ptem.executeQuery();
            while (rs.next()) {//每循环一次给用户赋值
                //将数据库中用户的信息存放在集合中
                Userinfo userinfo = new Userinfo();
                userinfo.setOrdid(rs.getString("ordid"));
                userinfo.setUsername(rs.getString("uname"));
                userinfo.setOrdertime(rs.getString("ordertime"));
                userinfo.setTrantime(rs.getString("trantime"));
                userinfo.setReceivetime((rs.getString("receivetime")));
                if(num==0) {
                    status = "未在派送";
                    userinfo.setStatus(status);
                }else if(num==1){
                    status = "正在派送";
                    userinfo.setStatus(status);
                }
                list.add(userinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        data = new Object[list.size()][head.length];
        for (int i = 0; i < list.size(); i++) {//将集合中的信息放入二维数组中
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getOrdid();
                data[i][1] = list.get(i).getUsername();
                data[i][2] = list.get(i).getOrdertime();
                data[i][3] = list.get(i).getTrantime();
                data[i][4] = list.get(i).getReceivetime();
                data[i][5] = list.get(i).getStatus();
            }
        }
        return data;
    }
}

