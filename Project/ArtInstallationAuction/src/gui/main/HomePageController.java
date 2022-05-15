package gui.main;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;

import gui.log.LogController;
import independent.User;

import java.io.IOException;
//import hotel.Room;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import program.Main;
//import static login.LoginController.decorator;
//import static login.LoginController.window;
//import project.switchScreen; implements Initializable

public class HomePageController implements Initializable {
	User guest;
	private int index;
	public static Scene scene2;
	public static Stage window2;
	public static Parent root2;
	//@FXML
    //private TextField usernameLabel1;
	@FXML
    private JFXButton logOut;
	@FXML
    private JFXButton check_in_Buttton;
    @FXML
    private JFXButton check_out_Buttton;
    @FXML
    private JFXButton room_booking_Buttton;
    @FXML
    private JFXButton cancel_booking_Buttton;
    @FXML
    private Label usernameLabel11;
    @FXML
    private Label usernameLabel1;
    @FXML
    private Label usernameLabel111;
    @FXML
    private Label rank_Label;
    @FXML
    private ProgressIndicator available_par;
    @FXML
    private ProgressIndicator reserved_par;
    @FXML
    private JFXButton roomBTN;
    @FXML
    private JFXButton guestsBTN;
    //=============
    public static JFXDecorator decorator1;
    
    

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    //@Override
	
	  public void initialize(URL url, ResourceBundle rb) { //set userName label with the string in login
	  //usernameLabel.setText(login.LoginController.user.getUsername());\
		  
	   index = User_single.User_Info.getInstance().getID();
	   guest = Main.polka.findUser(User_single.User_Info.getInstance().getLogin());
	   usernameLabel1.setText(guest.getName());
	  
	  if (guest.getLogin().equals("root")) {
	  rank_Label.setText("Admin"); 
      }
	  else { 
		  rank_Label.setText("User"); 
	  }
	  
	  
	  double available_Percentage = (Main.polka.getProducts().size());
	  available_par.setProgress(available_Percentage / 3.6); // 90
	  
	  //double reserved_Percentage = (90 - availableRooms.size()); 
	  //reserved_par.setProgress(reserved_Percentage / 90); // 90
	  
	  }

    @FXML
    public void logout(ActionEvent event) {
        System.out.println("Log-Out label clicked");
        
        Stage stage = (Stage)Main.hash.get(index).get(0);
        stage.close();
        
		/*
		 * try { //Load new FXML and assign it to scene Parent root =
		 * FXMLLoader.load(getClass().getResource(Paths.LOGINVIEW)); //create empty new
		 * stage Stage window2 = new Stage(); //set layout properties JFXDecorator
		 * decorator = new JFXDecorator(window2, root, false, false, true); //Create new
		 * scene and add new layout in it Scene scene = new Scene(decorator); // add css
		 * file to the scene String uri =
		 * getClass().getResource("dectaorStyle.css").toExternalForm();
		 * scene.getStylesheets().add(uri); //stage properties int width = 690, height =
		 * 620; window2.setScene(scene); window2.setMaxHeight(height);
		 * window2.setMinHeight(height); window2.setMaxWidth(width);
		 * window2.setMinWidth(width); Image icon = new
		 * Image(getClass().getResourceAsStream("/img/login_icon.png"));
		 * window2.getIcons().add(icon); window2.show(); //set foucus in the window not
		 * in close and maximize button root.requestFocus(); //close the old stage
		 * ((Stage) ((Node) event.getSource()).getScene().getWindow()).close();
		 * 
		 * } catch (Exception ex) { System.out.println("Error load login FXML !");
		 * System.out.println(ex.getMessage()); ex.printStackTrace(); }
		 */
    }

    @FXML
    public void goTO_user_settings(Event event) {
        System.out.println("User setting button clicked");
        Main.polka.UserTO(User_single.User_Info.getInstance(), guest);
        try {
        	//Main.setStageTitle("Settings");
        	Main.setRoot(Paths.SETTINGSVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
        } catch (Exception ex) {
            System.out.println("Error load Checkin FXML !");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void goTo_auction_buying(Event event) {
        System.out.println("Buying Auction button clicked");

        try {
            
        } catch (Exception ex) {
            System.out.println("Error load RoomBooking FXML !");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void goTo_cancel_auction(Event event) {
        System.out.println("Cancel button clicked");
        Main.polka.UserTO(User_single.User_Info.getInstance(), guest);
        //Main.setStageTitle("Cancel");
    	try {
			Main.setRoot(Paths.CANCELBOOKINGVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    public void goTo_Delete_account(Event event) {
        System.out.println("Delete button clicked");
        Main.polka.UserTO(User_single.User_Info.getInstance(), guest);
        try {
        	//Main.setStageTitle("Delete");
    		Main.setRoot(Paths.DELETEACCVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
        } catch (Exception ex) {
            System.out.println("Error load Checkout FXML !");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void goTo_Users(Event event) { // admin settings
    	
    	
    	try {
            //Load new FXML and assign it to scene
            root2 = FXMLLoader.load(getClass().getResource(Paths.USERSVIEW));
            //create empty new stage
            window2 = new Stage();
            //set layout properties
            decorator1 = new JFXDecorator(window2, root2, false, false, true);
            //Create new scene and add new layout in it
            scene2 = new Scene(decorator1);
            // add css file to the scene 
            String uri = getClass().getResource("dectaorStyle.css").toExternalForm();
            scene2.getStylesheets().add(uri);
            //stage properties
            int width = 690, height = 620;
            window2.setScene(scene2);
            window2.setMaxHeight(height);
            window2.setMinHeight(height);
            window2.setMaxWidth(width);
            window2.setMinWidth(width);
            Image icon = new Image(getClass().getResourceAsStream("/img/AUCTION.png"));
            window2.getIcons().add(icon);
            window2.show();
            //set foucus in the window not in close and maximize button
            
        } catch (Exception ex) {
            System.out.println("Error load Users FXML !");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    	
		
}

    @FXML
    public void goTo_Auctions(Event event) {
        System.out.println("Auctions button clicked");
        Main.polka.UserTO(User_single.User_Info.getInstance(), guest);
        try {
        	
        	Main.setRoot(Paths.AUCTIONVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
        	//Main.setStageTitle("Auction");

        } catch (Exception ex) {
            System.out.println("Error load Auction FXML !");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
		 
    }

    @FXML
    public void goTo_Guests(Event event) {
        
        System.out.println("Guests button clicked");
        Main.polka.UserTO(User_single.User_Info.getInstance(), guest);
        try {
        	Main.setRoot(Paths.GUESTSVIEW, (Stage)Main.hash.get(index).get(0), (Scene)Main.hash.get(index).get(1));
        	//Main.setStageTitle("Guests");
        } catch (Exception ex) {
            System.out.println("Error load Guests FXML !");
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

}
