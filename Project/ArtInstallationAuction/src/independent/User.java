package independent;

public class User {
    private String login;
    private String password;
    private String firstName;
    private String secondName;
    private double balance;
    private double spent;

    public String getLogin(){return login;}
    public String getPass(){return password;}
    public String getfirstName(){return firstName;}
    public String getsecName(){return secondName;}
   
    public double getBalance(){return balance;}
    public double getSpent(){return spent;}
   
    
    private void setLogin(String Login){ login = Login;}
    private void setPass(String Password){ password = Password;}
    private void setfirstName(String Name){ firstName = Name;}
    private void setsecName(String Name){ secondName = Name;}
    
    private void setBalance(double Balance){ balance = Balance;}
    private void setSpent(double Spent){ spent = Spent;}


    public User (String login, String pass, String firstName, String secName, int balance)
    {
       this.setfirstName(firstName);
       this.setsecName(secName);
       this.setLogin(login);
       this.setPass(pass);
       this.setBalance(balance);
    }

    public User (String login, String pass, String firstName, String secName, double balance, double spent)
    {
    	this.setfirstName(firstName);
        this.setsecName(secName);
        this.setLogin(login);
        this.setPass(pass);
       this.setBalance(balance);
       this.setSpent(spent);
    }

    public User (String login, String pass, String firstName, String secName, int balance, int spent)
    {
    	this.setfirstName(firstName);
        this.setsecName(secName);
        this.setLogin(login);
        this.setPass(pass);
       this.setBalance(balance);
       this.setSpent(spent);
    }

    public void MinimizeBalance (double price)
    {
       balance -= price;
       spent += price;
    }

    @Override
    public String toString() {
       return "User{" +
               "name='" + firstName + '\'' +
               ", login='" + login + '\'' +
               ", balance=" + balance +
               ", spent=" + spent +
               '}';
    }
 }
