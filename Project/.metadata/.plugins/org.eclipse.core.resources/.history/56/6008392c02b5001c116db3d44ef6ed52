package independent;

import database.SqlDB;

import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public void setUsers () throws SQLException {
		sql.User_out(people);
	}
	
}
