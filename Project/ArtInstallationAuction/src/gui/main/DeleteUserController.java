/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.main;

import com.jfoenix.controls.JFXButton;

import User_single.User_Info;
import javafx.scene.control.TextField;

import static gui.main.HomePageController.decorator1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import program.Main;

/**
 * FXML Controller class
 *
 * @author UpToDate
 */
public class DeleteUserController implements Initializable {

    @FXML
    private TextField UserNameField;
    @FXML
    private JFXButton ButtonLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("DeleteUserController ...");
    }

    @FXML
    private void DeleteAction(ActionEvent event) throws SQLException {
        if ("".equals(UserNameField.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("Fill all fields ...");
            alert.setTitle("Error");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/img/WARNING_PNG.png"));
            alert.showAndWait();
            return;
        }
        if(UserNameField.getText().equals("root")){
            Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("You cannot Delete yourself !");
            alert.setTitle("Error");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/img/WARNING_PNG.png"));
            alert.showAndWait();
            return;
        }
        
        Main.polka.deleteUserLog(UserNameField.getText());
        
        boolean deleted = true;
        for (int a = 0; a < Main.polka.getUsers().size(); a++)
        {
        	if (Main.polka.getUsers().get(a).getLogin().equals(UserNameField.getText()))
        		deleted = false;
        }
        if (deleted) {
            UserNameField.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
            alert.setHeaderText("User Deleted successfully");
            alert.setTitle("Notification");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
            alert.setHeaderText("User-Name not valid, Tyr Agian");
            alert.setTitle("Error");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/img/Error01.png"));
            alert.showAndWait();
        }

    }

    @FXML
    private void goToUsers(Event event) {
    	System.out.println("Users label clicked");
        try {
            //Load new FXML and assign it to scene
        	gui.main.HomePageController.root2 = FXMLLoader.load(getClass().getResource(Paths.USERSVIEW));
            decorator1.setContent(gui.main.HomePageController.root2);
            decorator1.setTitle("Users");
            //set foucus in the window not in close and maximize button
            gui.main.HomePageController.root2.requestFocus();
        } catch (Exception ex) {
            System.out.println("Error load Users FXML !");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
