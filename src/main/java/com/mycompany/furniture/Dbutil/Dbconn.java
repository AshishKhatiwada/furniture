/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.furniture.Dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;





/**
 *
 * @author AAA
 */
public class Dbconn {
    static Connection conn = null;
    
    public static Connection getConnection(){
          
        try {
            String dbUrl = System.getenv("JDBC_DATABASE_URL");
            conn =DriverManager.getConnection(dbUrl);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conn;
    }
  public void createtables(){
           String sql = "CREATE TABLE if not exist tbl_user_signup(ID integer serial PRIMARY KEY,Email varchar(255) NOT NULL,Password varchar(50) NOT NULL)";
           
        Statement ps;

        try {
           
            ps = getConnection().createStatement();
            ps.executeUpdate(sql);

       
        } catch (SQLException ex) {
            
        }
    }
   public void inserttables(){
           
           String query = "insert into tbl_user_signup(Email,Password) values('ashish.khatiwada3@gmail.com','ashish')";
       
        PreparedStatement s;
        try {
           
           
            s = getConnection().prepareStatement(query);
           s.executeUpdate();
        } catch (SQLException ex) {
            
        }
    }
}
