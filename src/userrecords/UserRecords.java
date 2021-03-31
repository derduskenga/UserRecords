/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userrecords;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class UserRecords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name, email;
        int age;
        System.out.println("Enter your full name");
        name = scanner.nextLine();
        System.out.println("Enter your email address");
        email = scanner.nextLine();
        System.out.println("Enter your age");
        age = scanner.nextInt();
        
        //connect to database
        //create object of User class
        //call save method to save the record 
        DBConnector db = new DBConnector();
        Connection connection = db.connect();
        
        User user = new User(name,email,age);
        
        user.save(connection);
        
    }
    
}
