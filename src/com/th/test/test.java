package com.th.test;

import com.th.bean.User;
import com.th.dao.UserDao;
import com.th.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
       User user = userDao.login("messi","123");
        if (user!=null){
            System.out.println("success");
        }
    }



}
