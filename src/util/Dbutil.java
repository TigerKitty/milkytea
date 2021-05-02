package util;

import java.sql.*;

/**
 * hzg create 2021/4/20 11:02
 * 数据库连接对象封装，便于连接数据库
 */
public class Dbutil {
    private static Connection conn=null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    static{
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@112.74.59.255:1521:orcl";
            String user = "NAICHA";
            String password = "lanqiaoNAICHA";
            conn = DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement getPs(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            return ps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getRs(ResultSet rs){
        this.rs = rs;
        return this.rs;
    }

    /**
     * 关闭所有流
     */
    public void closeAll() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

