/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userrecords;

import java.sql.*;

/**
 *
 * @author User
 */
public class User {
    private String fullName;
    private String email;
    private int age;
    
    //
    public User (){} //default constructor 
    public User (String name, String email, int age){
        this.fullName = name;
        this.email = email;
        this.age = age;
    }
    //we could have getters and setter here 
    public void save(Connection connection){
        //gets all the data and saves it it into a database
        //TO-DO
        PreparedStatement preparedStatement = null;
        
        try{
            preparedStatement = connection.prepareStatement("INSERT INTO users (full_name,email,age) VALUES (?,?,?)");
            preparedStatement.setString(1, this.fullName);
            preparedStatement.setString(2, this.email);
            preparedStatement.setInt(3, this.age);
            //execute the query
            preparedStatement.executeUpdate();
            System.out.println("The record has been saved");
        }catch(SQLException sqle){
            System.out.println(sqle.getMessage());
        }
    }
    
    public void read(){
        //reads records from a database
    }
    
    public void search(){
        //reads records from a database
    }
    
    public void delete(){
        //reads records from a database
    }
    
    public void update(){
        //reads records from a database
    }
}
