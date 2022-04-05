package database;

import java.sql.*;

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
    
    

}
