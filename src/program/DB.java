///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package program;

import java.sql.*;


/**
 *
 * @author Ben
 */
public class DB {
    
    public static Connection LoginConnector(){
        
        try{
            // sqlite DB
            
          // Class.forName("org.sqlite.JDBC");
            //Connection conn = DriverManager.getConnection("jdbc:sqlite://Users/Ben/Dropbox/Programing/DB/Tank.sqlite");    
             // Connection conn = DriverManager.getConnection("jdbc:sqlite:D://Dropbox//Programing//DB//Tank.sqlite");    
//             mysql DB
// accdb

 
           //  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             //String name = "jdbc:ucanaccess://" + "//Users/Ben/Dropbox/Programing/DB/Dbd.accdb";
             String name = "jdbc:ucanaccess://" + "D://Dropbox//Programing//DB//Dbd.accdb";
            // String name = "jdbc:ucanaccess://" + "//MAIN-PC//Main//Programing//DB//dbTEST.accdb";
             
             String user = "";
             String password ="";
             
             Connection conn = DriverManager.getConnection(name,user,password);    
             
            
             
//             Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tank","root","");
            return conn;
            
            
        }
        catch(SQLException e){
            System.out.println("DB연결 실패");
            
            return null; 
        }
        
    }

   
}
