package com.th.dao;

import com.th.bean.User;
import com.th.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {


    public User login(String username, String password) {
        User user = null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from t_user where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                System.out.println("登陆成功");
            }else {
                System.out.println("用户名或密码错误");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(conn,ps,rs);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }


    public void addUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into t_user(username,password,email,telephone,sex) values(?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getTelephone());
            ps.setString(5,user.getSex());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                JdbcUtils.close(conn,ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        String username = "muller";
        String password = "111222";
        String email = "nuller@byaren.com";
        String telephone = "12345678910";
        String sex = "male";
        UserDao userDao = new UserDao();
        /*User user  = userDao.login(username,password);
        if(user!=null){
            System.out.println("success");
        }*/
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setTelephone(telephone);
        user.setSex(sex);
        userDao.addUser(user);
    }



}
