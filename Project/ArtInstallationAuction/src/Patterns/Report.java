package Patterns;

public class Report implements Follower{
	
	String inform = "Waiting..";
	
	public String getInform() {return inform;}
	
	public void inform() {
		
		System.out.println(" Open ");
	}
}
