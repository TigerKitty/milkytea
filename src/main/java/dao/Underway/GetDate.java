package dao.Underway;

import swing.login.Login;
import util.Dbutil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/*������ȡ���ݿ����û����ڽ��еĶ�����Ȼ�󱣴����ά�����С�
 * */
public class GetDate {
    public static int num = 1;
    public static String head[] = {"�������", "�û���", "�µ�ʱ��","����ʱ��","����ʱ��","����״̬"};
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
            while (rs.next()) {//ÿѭ��һ�θ��û���ֵ
                //�����ݿ����û�����Ϣ����ڼ�����
                Userinfo userinfo = new Userinfo();
                userinfo.setOrdid(rs.getString("ordid"));
                userinfo.setUsername(rs.getString("uname"));
                userinfo.setOrdertime(rs.getString("ordertime"));
                userinfo.setTrantime(rs.getString("trantime"));
                userinfo.setReceivetime((rs.getString("receivetime")));
                if(num==0) {
                    status = "δ������";
                    userinfo.setStatus(status);
                }else if(num==1){
                    status = "��������";
                    userinfo.setStatus(status);
                }
                list.add(userinfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        data = new Object[list.size()][head.length];
        for (int i = 0; i < list.size(); i++) {//�������е���Ϣ�����ά������
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

