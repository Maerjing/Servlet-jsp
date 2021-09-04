package com.student.dao.impl;

import com.student.dao.ILoginDaoImpl;
import com.student.entity.LoginUsers;
import com.student.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoginDaoImpl implements ILoginDaoImpl {
    public boolean isExist(String name, String pwd) {
        LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
        return loginDaoImpl.login(name, pwd) == null ? false : true;
    }

    public LoginUsers login(String name, String pwd) {
        LoginUsers loginUsers = null;
        ResultSet resultSet = null;
        try {
            String sql = "select * from login where uname=? and upwd=?";
            Object params[] = {name, pwd};
            resultSet = DBUtil.executeQuery(sql, params);
            while (resultSet.next()) {
                String uname = resultSet.getString("uname");
                String upwd = resultSet.getString("upwd");
                loginUsers = new LoginUsers(uname, upwd);
            }
            return loginUsers;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeException(DBUtil.connection, resultSet, DBUtil.preparedStatement);
        }
    }

    public boolean addLoginUser(LoginUsers loginUsers) {
        try {
            String sql = "INSERT INTO login VALUES (?,?)";
            Object[] params = {loginUsers.getUname(), loginUsers.getUpwd()};
            return DBUtil.executeUpdata(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<LoginUsers> queryAllLoginUsers() {
        ResultSet resultSet = null;
        LoginUsers loginUsers = null;
        List<LoginUsers> loginUsers1=new ArrayList<>();
        try {
            String sql = "select * from login";
            resultSet = DBUtil.executeQuery(sql, null);
            while (resultSet.next()) {
                String name = resultSet.getString("uname");
                String pwd = resultSet.getString("upwd");
                loginUsers=new LoginUsers(name,pwd);
                loginUsers1.add(loginUsers);
            }
            return loginUsers1;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }finally {
            DBUtil.closeException(DBUtil.connection,resultSet,DBUtil.preparedStatement);
        }
    }
}
