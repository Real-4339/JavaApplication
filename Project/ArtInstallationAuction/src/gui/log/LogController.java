package gui.log;

import java.sql.SQLException;

import database.SqlDB;
import independent.Storage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Window;


public class LogController {
	 @FXML
	    private TextField loginNameField;

	    @FXML
	    private PasswordField passwordField;

	    @FXML
	    private Button submitButton;

	    @FXML
	    public void login(ActionEvent event) throws SQLException {

	        Window owner = submitButton.getScene().getWindow();

	        System.out.println(loginNameField.getText());
	        System.out.println(passwordField.getText());

	        if (loginNameField.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter your Login id");
	            return;
	        }
	        if (passwordField.getText().isEmpty()) {
	            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
	                "Please enter a password");
	            return;
	        }

	        String loginName = loginNameField.getText();
	        String password = passwordField.getText();

	        //Starting first DB connection and initializing User list 
	        SqlDB sql = new SqlDB();
	        Storage userInfo = new Storage(sql);
	        userInfo.setUsers();
	        
	        
	        boolean flag = this.validate(loginName, password, userInfo);

	        if (!flag) {
	            infoBox("Please enter correct Login and Password", null, "Failed");
	        } else {
	            infoBox("Login Successful!", null, "Failed");
	        }
	    }

	    public static void infoBox(String infoMessage, String headerText, String title) {
	        Alert alert = new Alert(AlertType.CONFIRMATION);
	        alert.setContentText(infoMessage);
	        alert.setTitle(title);
	        alert.setHeaderText(headerText);
	        alert.showAndWait();
	    }

	    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
	        Alert alert = new Alert(alertType);
	        alert.setTitle(title);
	        alert.setHeaderText(null);
	        alert.setContentText(message);
	        alert.initOwner(owner);
	        alert.show();
	    }
	    
	    private boolean validate(String log, String pass, Storage user) {
	    	
	    	 for (int i = 0; i < user.getUsers().size(); i++) {
	             if (log.equals(user.getUsers().get(i).getLogin()) && pass.equals(user.getUsers().get(i).getPass())){
	            	 return true;
	             }
	         }
	    	 return false;
	    }
}
