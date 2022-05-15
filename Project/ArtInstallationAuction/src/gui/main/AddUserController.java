package gui.main;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.PasswordField;
import com.jfoenix.controls.JFXToggleButton;
import static gui.main.HomePageController.decorator1;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import program.Main;

/**
 * FXML Controller class
 *
 * @author UpToDate
 */
public class AddUserController implements Initializable {

    @FXML
    private TextField UserNameField;
    @FXML
    private PasswordField PasswordField;
    @FXML
    private JFXButton ButtonLogin;
    @FXML
    private ImageView key_pic_Login_Btn;
    @FXML
    private JFXToggleButton isAdminButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void NewUserAction(Event event) {
        if ("".equals(UserNameField.getText()) || "".equals(PasswordField.getText())) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("Fill all fields ...");
            alert.setTitle("Error");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/img/Error01.png"));
            alert.showAndWait();
            return;
        }

        try {
            System.out.println("1");
            boolean AdminStatus = isAdminButton.isSelected();
            System.out.println("2");
            
            for(int a = 0; a < Main.polka.getUsers().size(); a++) {
            	if (Main.polka.getUsers().get(a).getLogin().equals(UserNameField.getText())) {
            		Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "", ButtonType.OK);
                    alert.setHeaderText("That username is taken. Try another.");
                    alert.setTitle("Error");
                    ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/img/Error01.png"));
                    alert.showAndWait();
                    return;
            	}
            }
            
            System.out.println(UserNameField.getText() + " " + PasswordField.getText() + " " + AdminStatus);
            
            if (AdminStatus)
            	Main.polka.setArray(UserNameField.getText(), PasswordField.getText(), "root", "User");
            else
            	Main.polka.setArray(UserNameField.getText(), PasswordField.getText(), "Guest", "User"); 
            
            
            PasswordField.setText("");
            UserNameField.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "", ButtonType.OK);
            alert.setHeaderText("User added successfully");
            alert.setTitle("Notification");
            alert.showAndWait();
//            ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void isAdminButtonAction(ActionEvent event) {
        if (isAdminButton.isSelected()) {
            isAdminButton.setText("Admin");
        } else {
            isAdminButton.setText("User");
        }
    }

    @FXML
    public void goToUsers(Event event) {

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
