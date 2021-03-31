/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userrecords;

import java.sql.*;

public class DBConnector {
    private Connection connection;
    
    public DBConnector (){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
	}catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
	} 
        
        try{
            this.connection = DriverManager.getConnection("jdbc:" + Util.DATABASE_TYPE+"://" + Util.DATASE_HOST+ ":" + Util.DATABASE_PORT+ "/"+Util.DATABASE_NAME,Util.DATABASE_USER, Util.DATABASE_USER_PASS);
	}catch(SQLException sqlex) {
            System.out.println(sqlex.getMessage());
	}        
    }
    
    public Connection connect(){
        return this.connection;
    }
}
