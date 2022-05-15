/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.main;

import static gui.main.HomePageController.decorator1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import program.Main;


/**
 * FXML Controller class
 *
 * @author UpToDate
 */
public class ViewUsersController implements Initializable {

    @FXML
    private TableColumn c1;
    @FXML
    private TableColumn c2;
    @FXML
    private TableColumn c3;
    @FXML
    private TableView table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        c1.setCellValueFactory(new PropertyValueFactory("Login"));
        c2.setCellValueFactory(new PropertyValueFactory("Pass"));
        c3.setCellValueFactory(new PropertyValueFactory("Balance"));
        
        table.getItems().addAll(Main.polka.getUsers());
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
