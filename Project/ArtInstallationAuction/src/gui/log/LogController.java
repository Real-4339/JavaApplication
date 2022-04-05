package gui.log;

import java.sql.SQLException;

import database.SqlDB;
import independent.Storage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
	        SqlDB sql = new SqlDB(true);
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


	@FXML
	public void register(ActionEvent event) throws SQLException {
	   		try {
	   			System.out.println(getClass());
	   			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/register_form.fxml"));
	   	        Parent root1 = (Parent) fxmlLoader.load();
	   	        Stage stage = new Stage();
	   	     stage.setTitle("User Registration");
	   	        stage.setScene(new Scene(root1));  
	   	        stage.show();
	   	    } catch(Exception e) {
	   	        e.printStackTrace();
	   	    }
//		try {
//			RegistrationWindow reg = new RegistrationWindow();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
	
	@FXML
	public void textOut(ActionEvent event) throws SQLException {
		
	}
	
}
