package independent;

import database.SqlDB;

import java.sql.SQLException;
import java.util.ArrayList;

// Class to storage user data
public class Storage {
	private SqlDB sql;
	ArrayList<User> people = new ArrayList<User>();
	
	public Storage () {
		
	}
	
	public Storage (SqlDB sql) {
 		this.sql = sql;
	}
	
	public ArrayList<User> getUsers () {
		return people;
	}
	
	// Fun to get users from DB
	public void updateUsers () throws SQLException {
		sql.User_out(people);
	}
	
	// Fun to input a new User into DB
	public void setArray (String login, String pass, String fname,String sname) throws SQLException {
	  this.people.add(new User(login, pass, fname, sname, 0, 0));
	  sql.User_in(people);
	}
	
	// Fun to input a new User into DB, but also with Email
	public void setArrayEmail (String login, String pass, String fname,String sname, String email) throws SQLException {
		this.people.add(new User(login, pass, fname, sname, email, 0, 0));
		 sql.User_in(people);
	}
	
}
