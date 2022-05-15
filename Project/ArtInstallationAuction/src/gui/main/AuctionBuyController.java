package gui.main;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import independent.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import program.Main;

public class AuctionBuyController implements Initializable {
	
	
	User guest;
	private int index;
	@FXML
    private Label usernameLabel;
	@FXML
    private Label backLabel;
	@FXML
    private Hyperlink logoutLink;
	@FXML
    private TextField AuctionID;
	@FXML
    private TextField BidField;
	@FXML
    private JFXButton BuyButton;
	@FXML
    private JFXButton clearButton;
	@FXML
    private TableView tabel2;
	@FXML
    private TableView statustable;
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
	
	
	@Override
	 public void initialize(URL url, ResourceBundle rb) {   //set userName label with the string in login
  	   index = User_single.User_Info.getInstance().getID();
	   guest = Main.polka.findUser(User_single.User_Info.getInstance().getLogin());
	   usernameLabel.setText(guest.getName());
  
      c1.setCellValueFactory(new PropertyValueFactory("ID"));
      c2.setCellValueFactory(new PropertyValueFactory("Name"));
      c3.setCellValueFactory(new PropertyValueFactory("Creator"));
      c4.setCellValueFactory(new PropertyValueFactory("Price"));
      c5.setCellValueFactory(new PropertyValueFactory("Count"));
      c6.setCellValueFactory(new PropertyValueFactory("inform"));
       
      try {
          tabel2.getItems().addAll(guest.getParticipans());
          statustable.getItems().addAll(guest.getFollowers());
          
          guest.getParticipans().forEach(product -> {
        	  if (product.getBidCount() >= 3) {
        		  System.out.println("Error");
        	  }
          });
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
	  private void BuyAction(Event event) {
	  	if (AuctionID.getText().equals("") || BidField.getText().equals("")) {
	  		Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("Fill all fields ...");
            alert.setTitle("Error");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/img/WARNING_PNG.png"));
            alert.showAndWait();
            return;
	  	}
	  	boolean exist = Main.polka.ControlExistence(Integer.parseInt(AuctionID.getText()));
	  	if (!exist) {
	  		Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("We dont have that Installation, check the ID one more time.");
            alert.setTitle("Error");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/img/WARNING_PNG.png"));
            alert.showAndWait();
            return;
	  	}
	  	
	  	exist = Main.polka.ControlAuction(guest, Integer.parseInt(AuctionID.getText()));
	  	if (exist) {
	  		Alert alert = new Alert(Alert.AlertType.WARNING, "", ButtonType.OK);
            alert.setHeaderText("You alreary participating.");
            alert.setTitle("Error");
            ((Stage) alert.getDialogPane().getScene().getWindow()).getIcons().add(new Image("/img/WARNING_PNG.png"));
            alert.showAndWait();
            return;
	  	}
	  	
	  	int test = Main.polka.buy(guest, Integer.parseInt(AuctionID.getText()), Integer.parseInt(BidField.getText()));
	  	if (test == 7) { // already 3 users
	  		System.out.println("TUT");
	  		Main.polka.inform(Integer.parseInt(AuctionID.getText()));
	  	} 
	  	
	  	guest = Main.polka.findUser(User_single.User_Info.getInstance().getLogin());
	  	
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
	  private void clearText(Event event) {
		  AuctionID.setText("");
		  BidField.setText("");
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
	  System.out.println("Buying Auction button clicked");
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
