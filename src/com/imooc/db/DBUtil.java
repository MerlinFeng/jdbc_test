package com.imooc.db;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.sql.*;

/**
 * Created by Administrator on 2017/5/5.
 */
public class DBUtil {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static  Connection connection = null;

    static {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASSWORD);

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }

    public static void main(String[] args) throws Exception{

//        Statement statement = connection.createStatement();
//
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM god");
//        while (resultSet.next()){
//            System.out.println(resultSet.getString("user_name"));
//        }

    }
}
