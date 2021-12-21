
package com.mycompany.facultyfeedbackform;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {
    Connection con = null;
    
    public static Connection connectionDb(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:Faculty.db");
            System.out.println("Connection Success");
            return connection;
            
        }
        catch(Exception e){
            System.out.println("Error Connecting To Sqlite Database"+e);
            return null;
        }
        
    }
}
