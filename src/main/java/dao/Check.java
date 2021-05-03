package dao;

import util.Dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 登录
 */
public class Check {
    /**
     * 查询对比账号密码，并返回结果
     */
    public int Login(String username,String password) throws SQLException {
        //连接数据库并查询
        Dbutil dbutil = new Dbutil();
        String sql="SELECT * FROM users WHERE username=? AND password=?";
        System.out.println(sql);
        PreparedStatement ps = dbutil.getPs(sql);
        try {
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = dbutil.getRs(ps.executeQuery());
            if(rs.next()){
                System.out.println(rs.getString("username"));
                return 1;//登录成功
            }else{
                return 0;//登录失败
            }
        } finally {
            //dbutil.closeAll();
        }
    }
}
