package independent;

import database.SqlDB;

import java.sql.SQLException;
import java.util.ArrayList;

// Class to storage user data
public class Storage {
	private SqlDB sql;
	ArrayList<User> all = new ArrayList<User>();
	ArrayList<User> active = new ArrayList<User>();
	
	public Storage () {
		
	}
	
	public Storage (SqlDB sql) {
 		this.sql = sql;
	}
	
	public ArrayList<User> getUsers () {
		return all;
	}
	
	// Fun to get users from DB
	public void updateUsers () throws SQLException {
		sql.User_out(all);
	}
	
	public int updateActiveUsers (String text) throws SQLException {
		User user = new User();
		int index = 0;
		
		for (int a = 0; a < all.size(); a++) {
	        if (all.contains(text)) {
	        	index = a;
	        }
	    }
		
		user = all.get(index);
		active.add(user);
		
		String tex = user.getLogin();
		
		for (int a = 0; a < active.size(); a++) {
	        if (active.contains(tex)) {
	        	return a;
	        }
	    }
		return -1;
	}
	
	// Fun to input a new User into DB
	public void setArray (String login, String pass, String fname,String sname) throws SQLException {
	  this.all.add(new User(login, pass, fname, sname, 0, 0));
	  sql.User_in(all);
	  updateUsers ();
	}
	
	// Fun to input a new User into DB, but also with Email
	public void setArrayEmail (String login, String pass, String fname,String sname, String email) throws SQLException {
		this.all.add(new User(login, pass, fname, sname, email, 0, 0));
		 sql.User_in(all);
		 updateUsers ();
	}
	
	public void inputMoney (String man, int money, int index) throws SQLException {
		int balance = 0;
		
		for (int a = 0; a < active.size(); a++) {
	        if (active.get(a).getLogin().equals(man)) {
	        	balance = (int)active.get(a).getBalance();
	        	
	        }
	    }
		
		balance += money;
		sql.User_updateBalance(man, balance, index);
		updateUsers ();
	}
	
}
