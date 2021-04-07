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
        //lets create a simple menu using swich case
        DBConnector db = new DBConnector();
        Connection connection = db.connect();
        /**
         * Select an option
         * A: Save a record
         * B: Search
         * C: Read all records
         * D: Delete a record
         */
        
        String option = "A";
        System.out.println("Select an option");
        System.out.println("A: Save a record");
        System.out.println("B: Search");
        System.out.println("C: Read all the records");
        System.out.println("D: Delete");
        Scanner readOption = new Scanner(System.in);
        
        option = readOption.nextLine();
        switch (option){
            case "A":
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
        
                User user = new User(name,email,age);        
                user.save(connection);
                break;
            case "B":
                //receive the input from the user
                Scanner emailScanner = new Scanner(System.in);
                String searchEmail = null;
                System.out.println("Please input the search email:");
                searchEmail = emailScanner.nextLine();
                //create a User class Object 
                User userSearch = new User();
                userSearch.setEmail(searchEmail);
                userSearch.searchByEnmail(connection);                
                break;
            case "C":
                //do something 
                User readUser = new User();
                readUser.read(connection);
                break;
            case "D":
                //do something
                break;
            default:
                System.out.println("Invalid entry");
                
                
        }
        
 
        
    }
    
}
