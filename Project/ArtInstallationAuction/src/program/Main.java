package program;

import database.SqlDB;
import gui.log.LogginGui;
import independent.Storage;

public class Main {
	
	SqlDB sql = new SqlDB();
    Storage polka = new Storage();
	
	public static void main(String[] args) { 
		LogginGui log = new LogginGui();
		log.pusk(args);
	}

}
