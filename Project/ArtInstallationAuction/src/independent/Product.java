package independent;

import java.util.ArrayList;
import java.util.Hashtable;

import Patterns.Follower;

public class Product {
	
	 private int ID;
	 private String name;
	 private String Creator;
	 private double price;
	 private int count;
	 private int BidCount;
	 private Hashtable<Integer, User> Visitors = new Hashtable<Integer, User>();
	 
	 public Hashtable<Integer, User> getVisitors(){
		 return Visitors;
	 }
	 public void setVisitors(int bid, User user){
		  Visitors.put(bid, user);
	 }
	 
	 public int getBidCount() {return BidCount;}
	    public void setBidCount(int count) {
	    	System.out.println(BidCount + " before");
	    	BidCount += count;
	    	System.out.println(BidCount + " after");
	    }
	 
	 public int getID(){return ID;}
	 public void setID(int id){ID = id;}
	 
	 public String getName(){return name;}
	 private void setName(String Name){ name = Name;}
	 
	 public String getCreator(){return Creator;}
	 private void setCreator(String Name){ Creator = Name;}
	 
	 public double getPrice(){return price;}
	 private void setPrice(double Price){ price = Price;}
	 
	 public int getCount(){return count;}
	 void setCount(int Count){ count = Count;}

	 public Product () {}
	    
     public Product (int ID, String name, String Creator, double price, int count)
     {
       this.setID(ID);
       this.setName(name);
       this.setCreator(Creator);
       this.setPrice(price);
       this.setCount(count);
     }
	 
}
