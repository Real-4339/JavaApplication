package database;

import java.sql.*;
import java.util.ArrayList;

import independent.Product;
import independent.User;


public class SqlDB {
	Connection connection;
    Statement statement;
    
    // An anonymous connection to a DB 
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
    
    // The first and only first connection to a DB , need to be used only in opening main app 
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
    
    // Fun to get info from a DB to a List
    public void User_out(ArrayList<User> guys) throws SQLException {
        String SQLREQUEST = "Select * from User";
        ResultSet res = statement.executeQuery(SQLREQUEST);
        while(res.next()){
            guys.add(new User(res.getInt("UserId") ,res.getString("Login"), res.getString("Password"), res.getString("FirstName"), res.getString("SecondName"), res.getString("Email"), res.getDouble("Balance"), res.getDouble("Spent")));
        }
    }
    
   // 
    public void Products_out(ArrayList<Product> list) throws SQLException {
        String SQLREQUEST = "Select * from Product";
        ResultSet res = statement.executeQuery(SQLREQUEST);
        while(res.next()){
        	list.add(new Product(res.getInt("Id") ,res.getString("Name"), res.getString("Creator"), res.getDouble("Price"), res.getInt("Count")));
        }
    }
    
    // Fun to put info to a DB from a List
    public void User_in(ArrayList<User> guy) throws SQLException {
        statement.executeUpdate("INSERT INTO User(Login, Password, FirstName, SecondName, Balance, Spent)" 
        + "VALUES ('"+ guy.get(guy.size()-1).getLogin()+"', '"+ guy.get(guy.size()-1).getPass()+"', '" 
        + guy.get(guy.size()-1).getName()+"', '"+ guy.get(guy.size()-1).getSurname()+"', 0, 0)");
    }
    // Fun to put info to a DB from a List, but with email
    public void User_inEmail(ArrayList<User> guy) throws SQLException {
        statement.executeUpdate("INSERT INTO User(Login, Password, FirstName, SecondName, Email, Balance, Spent)" 
        + "VALUES ('"+ guy.get(0).getLogin()+"', '"+ guy.get(0).getPass()+"', '" 
        + guy.get(0).getName()+"', '"+ guy.get(0).getSurname()+"', '"+ guy.get(0).getEmail()+"', 0, 0)");
    }
    
    public void User_updateBalance(String guy, int balance, int index) throws SQLException {
    	String SQLREQUEST = "UPDATE User SET Balance =? WHERE Login = ?";
    	PreparedStatement state = connection.prepareStatement(SQLREQUEST);
    	state.setInt(1, balance);
    	state.setString(2, guy);
    	state.executeUpdate();
    	
    	//statement.executeUpdate(SQLREQUEST);
    	//statement = connection.prepareStatement(SQLREQUEST); 
    }
    
    public void User_delete(int index) throws SQLException {
    	String SQLREQUEST = "DELETE FROM User WHERE UserId = ?";
    	PreparedStatement state = connection.prepareStatement(SQLREQUEST);
    	state.setInt(1, index);
    	state.executeUpdate();
    	
    	//statement.executeUpdate(SQLREQUEST);
    	//statement = connection.prepareStatement(SQLREQUEST); 
    }
    
    
  
}
