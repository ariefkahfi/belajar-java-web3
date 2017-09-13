package com.arief.web.jdbc.ConnectionDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateConection {

    public static Connection create(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String host = "jdbc:mysql://localhost:3306/servletdb1";
            String user = "arief";
            String pass = "arief";
            return DriverManager.getConnection(host,user,pass);
        }catch (SQLException ex){
            ex.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}
