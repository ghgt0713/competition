package com.th.utils;

import java.sql.*;

public class JdbcUtils {
    //加载db驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection conn = null;
    //获取Connection对象
    public static Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/competetion?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
        String user = "root";
        String password = "Zth2000esj";
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }

    //关闭资源
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {


        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }

    }

    public static void close(Connection conn, PreparedStatement ps) throws SQLException {


        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

}

