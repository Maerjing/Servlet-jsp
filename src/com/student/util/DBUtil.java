package com.student.util;

import java.sql.*;

public class DBUtil {

    private static String URL = "jdbc:mysql://localhost:3306/mydemo?serverTimezone=UTC&useSSL=false";
    private static String USERNAME = "root";
    private static String PASSWORD = "w2213768002";
    public static Connection connection = null;
    public static PreparedStatement preparedStatement = null;
    public static ResultSet resultSet = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
//传值与查询语句
    public static PreparedStatement creatStatement(String sql, Object params[]) throws SQLException, ClassNotFoundException {
        preparedStatement = getConnection().prepareStatement(sql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
        }
        return preparedStatement;
    }

    public static void closeException(Connection connection,ResultSet resultSet,Statement statement){
        try {
            if (resultSet!=null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //通用增删改
    public static boolean executeUpdata(String sql, Object params[]) {
        try {
            preparedStatement = creatStatement(sql, params);
            int count =preparedStatement.executeUpdate();
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeException(connection,resultSet,preparedStatement);
        }
    }

    //查询
    public static ResultSet executeQuery(String sql, Object params[]) {
        try {
            preparedStatement = creatStatement(sql, params);
            resultSet =preparedStatement.executeQuery();
            return resultSet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
