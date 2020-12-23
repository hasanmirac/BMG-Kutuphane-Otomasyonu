package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import javax.swing.*;

/**
 *
 * @author hasan
 */
public class DbHelper {
   
    Connection conneciton;
    
    public static Connection ConnectDb(){
    try {
        
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/virtuallibrary","postgres" ,"12345");
            return connection;
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception);
            return null;
        }
    
}
}

