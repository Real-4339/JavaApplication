package gui.log;

import java.sql.SQLException;

import database.SqlDB;
import independent.Storage;
import javafx.application.Platform;
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
        private Button RegisterButton;
	    
	    @FXML
	    private Button ReturnToLogButton;
	    
	    @FXML
	    private TextField FirstNameField;
	    
	    @FXML
	    private TextField SecondNameField;

	    @FXML
	    private TextField EmailField;
	    
	    @FXML
	    private TextField LoginField;
	    
	    @FXML
	    private TextField PasswordField;
	    
	    @FXML
	    private TextField ConfirmPasswordField;
	    
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
	        userInfo.updateUsers();
	        
	        
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
	             
	    		 System.out.println(user.getUsers().get(i).getLogin() +" "+ user.getUsers().get(i).getPass());
	    		 
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
	   			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/register_form2.fxml"));
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
	public void Register(ActionEvent event) throws SQLException {
		Window window = RegisterButton.getScene().getWindow();
		
		System.out.println(FirstNameField.getText());
        System.out.println(SecondNameField.getText());
        System.out.println(EmailField.getText());
        System.out.println(LoginField.getText());
        System.out.println(PasswordField.getText());
        System.out.println(ConfirmPasswordField.getText());
        
        if (FirstNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, window, "Form Error!",
                "Please enter your First Name");
            return;
        }
        if (SecondNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, window, "Form Error!",
                "Please enter a your Second Name");
            return;
        }
        
        if (LoginField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, window, "Form Error!",
                "Please enter your Future Login");
            return;
        }
        if (PasswordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, window, "Form Error!",
                "Please enter a password in a field");
            return;
        }
        if (!ConfirmPasswordField.getText().equals(PasswordField.getText()))
        {
       	 showAlert(Alert.AlertType.ERROR, window, "Form Error!",
       			 "Oops! Password does not matches");
       	 return;
        }
        
        
        SqlDB sql = new SqlDB(true);
        Storage store = new Storage(sql);
        
        
        // Old fun to call sql fun to add a user
//        if (EmailField.getText().isBlank()) {
//        	
//        	store.setArray(LoginField.getText(), PasswordField.getText(), FirstNameField.getText(), SecondNameField.getText());
//        	Stage stage = (Stage) RegisterButton.getScene().getWindow();
//    		stage.close();
//        	return;
//        }
//        
//    	store.setArrayEmail(LoginField.getText(), PasswordField.getText(), FirstNameField.getText(), SecondNameField.getText(), EmailField.getText());
//    	Stage stage = (Stage) RegisterButton.getScene().getWindow();
//		stage.close();
        
        //Thread that controlling closing reg. form and adding User 
        Thread th = new Thread() {
        	public void run()  {
        		if (EmailField.getText().isBlank()) {
              
                  	try {
						store.setArray(LoginField.getText(), PasswordField.getText(), FirstNameField.getText(), SecondNameField.getText());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                  	Stage stage = (Stage) RegisterButton.getScene().getWindow();
                  	Platform.runLater(() -> stage.close()); 
                  	return;
                  }
                  
              	try {
					store.setArrayEmail(LoginField.getText(), PasswordField.getText(), FirstNameField.getText(), SecondNameField.getText(), EmailField.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
              	Stage stage = (Stage) RegisterButton.getScene().getWindow();
              	Platform.runLater(() -> stage.close()); 
        	}
        };
        
        th.setDaemon(true);
        th.start();
        
	}
	
	@FXML
	public void back(ActionEvent event) throws SQLException {
		Stage stage = (Stage) ReturnToLogButton.getScene().getWindow();
		stage.close();
	}
	
}
