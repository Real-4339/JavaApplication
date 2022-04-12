package independent;

import java.util.Hashtable;

public class Product {
	
	 private String name;
	 private double price;
	 private int count;
	 
	 
	 public String getName(){return name;}
	 private void setName(String Name){ name = Name;}
	 
	 public double getPrice(){return price;}
	 private void setPrice(double Price){ price = Price;}
	 
	 public int getCount(){return count;}
	 void setCount(int Count){ count = Count;}

	 public Product () {}
	    
     public Product (String name, double price, int count)
     {
       this.setName(name);
       this.setPrice(price);
       this.setCount(count);
     }
	 
}
