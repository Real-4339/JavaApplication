package independent;

import database.SqlDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map.Entry;

import Patterns.Follower;
import Patterns.Report;
import Patterns.Winner;
import User_single.User_Info;

// Class to storage user data
public class Storage {
	private SqlDB sql;
	//private Product product = new Product("Mini liberty statue", 123, 0);
	ArrayList<User> all = new ArrayList<User>();
	ArrayList<User> active = new ArrayList<User>();
	
	private ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Follower> followers = new ArrayList<>();
	
	public ArrayList getProducts(){return products;}
	
	public Storage () {
		
	}
	
	public Storage (SqlDB sql) {
 		this.sql = sql;
	}
	
	public ArrayList<User> getUsers () {
		return all;
	}
	
	public int findUserID (String login) {
		for (int a = 0; a < active.size(); a++)
		{
			if (active.get(a).getLogin().equals(login)) {
				 return active.get(a).getID();
			}
		}
		return -1;
	}
	
	public User findUser (String login) {
		
		for (int a = 0; a < active.size(); a++)
		{
			if (active.get(a).getLogin().equals(login)) {
				 return active.get(a);
			}
		}
		return null;
	}
	
	public ArrayList<User> getActiveUsers () {
		return active;
	}
	
	public void updateProducts() throws SQLException {
		products = null;
		products = new ArrayList();
		sql.Products_out(products);
	}
	
	// Fun to get users from DB
	public void updateUsers () throws SQLException {
		all = null;
		all = new ArrayList();
		sql.User_out(all);
	}
	
	public int updateActiveUsersInt (String text) throws SQLException {
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
		
		int b = 0;

		for (int a = 0; a < active.size(); a++) {
	        if (active.get(a).getLogin().contains(tex)) {
	        	b = a;
	        	return b;
	        }
	    }
		return -1;
	}

	public void updateActiveUsers (String text) throws SQLException {
		User user = new User();
		int index = 0;
		 
		
		for (int a = 0; a < all.size(); a++) {
	        if (all.get(a).getLogin().equals(text)) {
	        	index = a;
	        }
	    }
		
		user = all.get(index);
		active.add(user);
		UserTO(User_Info.getInstance(), user);
	}
	
	public void deleteUser (int index) throws SQLException {
		
		
		for (int a = 0; a < all.size(); a++) {
	        if (all.get(a).getID() == index) {
	        	all.remove(a);
	        }
	    }
		
		for(int a = 0; a < active.size(); a++)
		{
			if (active.get(a).getID() == index) {
				active.remove(a);
	        }
		}
		
		sql.User_delete(index);
		updateUsers();
	}
	
public void deleteActiveUser (int index) {
		
		
		for(int a = 0; a < active.size(); a++)
		{
			if (active.get(a).getID() == index) {
				active.remove(a);
	        }
		}
		
	}
	
public void deleteUserLog (String login) throws SQLException {
		
		int index = -1;
		for (int a = 0; a < all.size(); a++) {
	        if (all.get(a).getLogin().equals(login)) {
	        	index = all.get(a).getID();
	        	all.remove(a);
	        }
	    }
		
		for(int a = 0; a < active.size(); a++)
		{
			if (active.get(a).getLogin().equals(login)) {
				active.remove(a);
	        }
		}
		
		sql.User_delete(index);
		updateUsers();
	}
	
	// Fun to input a new User into DB
	public void setArray (String login, String pass, String fname, String sname) throws SQLException {
		System.out.println(login + " " + pass + " " + fname);
	  this.all.add(new User(login, pass, fname, sname, 0, 0));
	  sql.User_in(all);
	  updateUsers ();
	}
	
	public void UserTO(User_Info user, User user1) {
		if (user1.getEmail() != null) user.setEmail(user1.getEmail());
		user.setID(user1.getID());
		user.setFname(user1.getName());
		user.setSname(user1.getSurname());
		user.setLogin(user1.getLogin());
		user.setPass(user1.getPass());
		
	}
	
	// Fun to input a new User into DB, but also with Email
	public void setArrayEmail (String login, String pass, String fname,String sname, String email) throws SQLException {
		this.all.add(new User(login, pass, fname, sname, email, 0, 0));
		 sql.User_in(all);
		 updateUsers ();
	}
	
	
	public boolean ControlExistence(int id) {
		
		for (int a = 0; a < getProducts().size(); a++)
		{
			 if (products.get(a).getID() == id) { 
				 return true; 
			 }
		}
		
		
		return false;
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
	
	public boolean ControlAuction(User user, int id) {
		for(int a = 0; a < user.getParticipans().size(); a++)
		{
			if (user.getParticipans().get(a).getID() == id)
			{
				  System.out.println("id: " + id + " " + user.getParticipans().get(a).getID());
				  return true;
			}
			
		}
		return false;
	}
	
	public int buy(User user, int id, int Bid) {
		Product product = null;
		int index = 0;
		for(int a = 0; a < products.size(); a++)
		{
			if (products.get(a).getID() == id)
			{
				//if (products.get(a).getCount() == 0) return 9; // there are no more 
				  products.get(a).setBidCount(1);
				  //products.get(a).setCount(products.get(a).getCount() - 1);
				  product = products.get(a);
				  index = a;
				  products.get(a).setVisitors(Bid, user);
			}
		}
		
		for(int a = 0; a < active.size(); a++) {
			if (active.get(a) == user)
			{
				active.get(a).setParticipating(product);
			
				active.get(a).setFollower(new Report());
				
				System.out.println(product.getBidCount() +" count");
				
				if (product.getBidCount() == 3) {
					return 7; // already 3
				}
				
				//active.get(a).setFollower(id, new Report());
			}
		}
		return 0;
	}
	
	public void inform(int id) {
		User user = null;
		Product product = null;
		int index = -1;
		int max = -1;
		int count = 0;
		int ind = 0;
		
		for (int a = 0; a < products.size(); a++) {
			if (products.get(a).getID() == id) {
				product = products.get(a);
				index = a;
			}
		}
		
		for (Entry<Integer, User> e : product.getVisitors().entrySet()) 
            if(e.getKey() > max) {
            	max = e.getKey();
            	user = e.getValue();
            }

		for (int a = 0; a < user.getFollowers().size(); a++) {
			if (user.getParticipans().get(a).getID() == id){
				products.get(index).getVisitors().get(max).getFollowers().remove(a);
				products.get(index).getVisitors().get(max).getFollowers().add(new Winner());
			}
		}
	        
		
	}
	
	public String buy (String login, int money) throws SQLException {
		return "";
	}
	
//	public String buy (String login, int money) throws SQLException {
//		//product = new Product("Mini liberty statue", 123, product.getCount()+1);  
//		ArrayList list_01 = new ArrayList<>();
//		list_01.add(login);
//		list_01.add(money);
//		products.add(list_01);
//		if (product.getCount() >= 3) {
//			System.out.println("IN >=3 ");
//			int max = 0;
//			for(int a = 0; a < products.size(); a++) {
//			    for(int i = 0; i < 2; i++)
//			    {
//			    	if((int) products.get(a).get(1) > max) {
//			    		max = (int) products.get(a).get(1);
//			    	}
//			    }
//			}
//			 int persone = 0;
//			 String personne = "";
//			for(int a = 0; a < products.size(); a++) {
//			    for(int i = 0; i < 2; i++)
//			    {
//			    	if((int) products.get(a).get(1) == max) {
//			    		persone = a;
//			    		personne = (String) products.get(a).get(0);
//			    	}
//			    }
//			}
//			System.out.println("Persone: " + persone);
//			System.out.println("Personne: " + personne);
//			
//			String winner = personne + " Won";
//			for (int a = 0; a < active.size(); a++) {
//		        if (active.get(a).getLogin().equals(personne)) {
//		        	active.get(a).MinimizeBalance(max);
//		        }
//		    }
//			product.setCount(0);
//			return winner;
//		}
//		return "Waiting...";
//	}
	
}
