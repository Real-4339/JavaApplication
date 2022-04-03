package database;

import java.sql.*;
import java.util.ArrayList;
import independent.User;


public class SqlDB {
	Connection connection;
    Statement statement;
    
    public SqlDB(boolean a){
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:I:\\\\oop\\\\Project\\\\ArtInstallationAuction\\\\src\\\\database\\\\SQL.db");
            statement = connection.createStatement();
        }
        catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            System.out.println("Error, could not connect to DataBase :( ");
        }
    }
    
    public SqlDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            System.out.println("\nConnecting to database ...");
            connection = DriverManager.getConnection("jdbc:sqlite:I:\\oop\\Project\\ArtInstallationAuction\\src\\database\\SQL.db");
            statement = connection.createStatement();
            System.out.println("DataBase was connected ->\n _       __          __                                \n" +
                    "| |     / /  ___    / /  _____  ____    ____ ___   ___ \n" +
                    "| | /| / /  / _ \\  / /  / ___/ / __ \\  / __ `__ \\ / _ \\\n" +
                    "| |/ |/ /  /  __/ / /  / /__  / /_/ / / / / / / //  __/\n" +
                    "|__/|__/   \\___/ /_/   \\___/  \\____/ /_/ /_/ /_/ \\___/ \n" +
                    "                                                       ");
        }
        catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
            System.out.println("Error, could not connect to DataBase :( ");
        }
    }
    
    public void User_out(ArrayList<User> guys) throws SQLException {
        String SQLREQUEST = "Select * from User";
        ResultSet res = statement.executeQuery(SQLREQUEST);
        while(res.next()){
            guys.add(new User(res.getString("Login"), res.getString("Password"), res.getString("FirstName"), res.getString("SecondName"), res.getDouble("Balance"), res.getDouble("Spent")));
        }
    }
    
    public boolean validate(String emailId, String password) throws SQLException { 
    	
    	
    	
    	return false;
    }

}