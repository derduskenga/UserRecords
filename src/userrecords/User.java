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
    //email setter 
    public void setEmail(String email){
        this.email = email;
    }
    //we could have getters and setter here 
    public void save(Connection connection){
        //gets all the data and saves it it into a database
        //TO-DO
        PreparedStatement preparedStatement = null;
        
        try{
            preparedStatement = connection.prepareStatement("INSERT INTO users (full_name,email,age) "
                    + "VALUES (?,?,?)");
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
    public void searchByUserId(Connection connection){
        //TODO
    }
    public void searchByEnmail(Connection connection){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;
        
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email=?");
            preparedStatement.setString(1, this.email);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                //a record was found
                System.out.println("ID is " + resultSet.getString(1));
                System.out.println("Full name " + resultSet.getString(2));
                System.out.println("Email " + resultSet.getString(3));
                System.out.println("Age " + resultSet.getString(4));
            }else{
                System.out.println("No matching records");
            }
        }catch(SQLException sqle){
            System.out.println("Error " + sqle.getMessage());
        }
    }
        
    public void read(Connection con){
        //reads records from a database
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;        
        try{
            preparedStatement = con.prepareStatement("SELECT * FROM users");
            resultSet = preparedStatement.executeQuery();
            System.out.println("|   ID  |   Full name   |   Email   |   Age |");
            while(resultSet.next()){
                //print the record
                System.out.print("  " + resultSet.getString(1) + "  ");
                System.out.print("  " + resultSet.getString(2) + "  ");
                System.out.print("  " + resultSet.getString(3) + "  ");
                System.out.println("  " + resultSet.getString(4) + "  ");
            }
        }catch(SQLException sqle){
            System.out.println("Error " + sqle.getMessage());  
        }
    }   

    
    public void delete(){
        //reads records from a database
    }
    
    public void update(){
        //reads records from a database
    }
}
