package User_single;

public class User_Info {
	
	static int ID;
	static String login;
	static String pass;
	static String Fname;
	static String Sname;
	static String Email;
	static String Adress;
	static int Card;
	static String Iban;
	static double Balance;
	static double Spent;
	
	private static User_Info Instance;
	
	public static User_Info getInstance() {
        if (Instance == null){
                Instance = new User_Info();
        }
        return Instance;
	}
	
	public void setLogin(String log) {
        this.login = log;
	}
	
	public void setPass(String pass) {
        this.pass = pass;
	}
	public void setFname(String Fname) {
        this.Fname = Fname;
	}
	public void setSname(String Sname) {
        this.Sname = Sname;
	}
	public void setEmail(String Email) {
        this.Email = Email;
	}
	public void setAdress(String Adress) {
        this.Adress = Adress;
	}
	
	public void setCard(int Card) {
        this.Card = Card;
	}
	
	public void setIban(String Iban) {
        this.Iban = Iban;
	}
	
	public void setBalance (double Balance) {
        this.Balance = Balance;
	}
	
	public void setSpent (double Spent) {
        this.Spent = Spent;
	}
	
	public void setID (int ID) {
        this.ID = ID;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getPass() {
		return pass;
	}
	public String getFname() {
		return Fname;
	}
	public String getSname() {
		return Sname;
	}
	public String getEmail() {
		return Email;
	}
	public String getAdress() {
		return Adress;
	}
	
	public int getCard() {
        return Card;
	}
	
	public String getIban() {
		return Iban;
	}
	
	public double getBalance () {
		return Balance;
	}
	
	public double getSpent () {
		return Spent;
	}
	
	public int getID () {
		return ID;
	}
}
