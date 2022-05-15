package gui.log;

import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RegistrationWindow extends Stage {
	 
	    public RegistrationWindow() throws Exception {
	    	System.out.println(getClass());
	    	Stage stage = new Stage();
	        Parent root = FXMLLoader.load(getClass().getResource("/resources/register_form2.fxml"));
	        stage.setTitle("User Registration");
	        stage.setScene(new Scene(root));
	        stage.show();
	    }
	    
	    @FXML
		public void textOut(ActionEvent event) throws SQLException {
			
		}
	    

}
