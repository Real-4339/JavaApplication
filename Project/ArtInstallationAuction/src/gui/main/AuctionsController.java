package gui.main;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import independent.User;
//import hotel.Room;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
//import project.DataBase;
import program.Main;

public class AuctionsController implements Initializable {
	User guest;
	private int index;
	@FXML
    private Label backLabel;
    @FXML
    private JFXButton Logobtn;
    @FXML
    private Label usernameLabel;
    @FXML
    private Hyperlink logoutLink;
    @FXML
    private TableView tabel2;
    @FXML
    private TableColumn c1;
    @FXML
    private TableColumn c2;
    @FXML
    private TableColumn c3;
    @FXML
    private TableColumn c4;
    @FXML
    private TableColumn c5;
    @FXML
    private TableColumn c6;

    /**
     * Initializes the controller class.
     */
      @Override
	  public void initialize(URL url, ResourceBundle rb) { //set userName label with the string in login
    	index = User_single.User_Info.getInstance().getID();
  	   guest = Main.polka.findUser(User_single.User_Info.getInstance().getLogin());
  	   usernameLabel.setText(guest.getName());
    
        c1.setCellValueFactory(new PropertyValueFactory("ID"));
        c2.setCellValueFactory(new PropertyValueFactory("Name"));
        c3.setCellValueFactory(new PropertyValueFactory("Creator"));
        c4.setCellValueFactory(new PropertyValueFactory("Price"));
        c5.setCellValueFactory(new PropertyValueFactory("Count"));
        //c6.setCellValueFactory(new PropertyValueFactory("isEmpty"));	
        
        try {
            tabel2.getItems().addAll(Main.polka.getProducts());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void logout(Event event) {
    	Stage stage = (Stage)Main.hash.get(index).get(0);
    	Main.polka.deleteActiveUser(index);
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
        //new homepage.HomePageController().goTO_check_in(event);
    }

    @FXML
    private void goTo_auction_buying(ActionEvent event) {
    	Main.polka.UserTO(User_single.User_Info.getInstance(), guest);
        try {
        	Main.setRoot(Paths.AUCTIONBUYVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
        } catch (Exception ex) {
            System.out.println("Error load RoomBooking FXML !");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
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
    private void goTo_Guests(ActionEvent event) {
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
