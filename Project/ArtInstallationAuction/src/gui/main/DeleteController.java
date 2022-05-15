package gui.main;

import com.jfoenix.controls.JFXButton;

import independent.User;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import program.Main;

public class DeleteController implements Initializable{
	User guest;
	private int index;
    @FXML
    private Label usernameLabel;
    @FXML
    private Hyperlink logoutLink;
    @FXML
    private TextField roomNoField;
    @FXML
    private JFXButton YesBTN;
    @FXML
    private JFXButton nobtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
	
	  public void initialize(URL url, ResourceBundle rb) { //set userName label with the string in login
    	index = User_single.User_Info.getInstance().getID();
  	   guest = Main.polka.findUser(User_single.User_Info.getInstance().getLogin());
  	   usernameLabel.setText(guest.getName());
    }
    
    @FXML
    private void logout(Event event) {
    	Stage stage = (Stage)Main.hash.get(index).get(0);
        stage.close();
    }

    @FXML
    public void goToHomePage(Event event) {
    	//Main.setStageTitle("Home");
    	Main.polka.UserTO(User_single.User_Info.getInstance(), guest);
    	if (guest.getLogin().equals("root")) {
    		try {
    			Main.setRoot(Paths.HOMEPAGEROOTVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    	else {
	    	try {
				Main.setRoot(Paths.HOMEPAGEVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

    @FXML
    private void goTO_user_settings(ActionEvent event) {
    	//Main.setStageTitle("Settings");
    	Main.polka.UserTO(User_single.User_Info.getInstance(), guest);
    	try {
			Main.setRoot(Paths.SETTINGSVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    private void goTo_auction_buying(ActionEvent event) {
        
    }

    @FXML
    private void goTo_cancel_auction(ActionEvent event) {
    	//Main.setStageTitle("Cancel");
    	Main.polka.UserTO(User_single.User_Info.getInstance(), guest);
    	try {
			Main.setRoot(Paths.CANCELBOOKINGVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    private void goTo_Delete_account(Event event) {
    	//Main.setStageTitle("Delete");
    	Main.polka.UserTO(User_single.User_Info.getInstance(), guest);
    	try {
			Main.setRoot(Paths.DELETEACCVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    @FXML
    private void DeleteAction(ActionEvent event) throws SQLException {
        Main.polka.deleteUser(index);
        Stage stage = (Stage)Main.hash.get(index).get(0);
        stage.close();
    }

    @FXML
    private void goTo_Auctions(ActionEvent event) {
    	//Main.setStageTitle("Auction");
    	Main.polka.UserTO(User_single.User_Info.getInstance(), guest);
    	try {
			Main.setRoot(Paths.AUCTIONVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    private void goTo_guests(ActionEvent event) {
    	//Main.setStageTitle("Guests");
    	Main.polka.UserTO(User_single.User_Info.getInstance(), guest);
    	try {
			Main.setRoot(Paths.GUESTSVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
