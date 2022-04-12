package gui.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import program.Main;

public class MainGui extends Stage{
	
	private Button buy = new Button("Buy an installation");
	private Button refill = new Button("Fund your account");
	private TextField refillField = new TextField();
	private TextField rate = new TextField();
	private Label rateLabel = new Label("Your rate: ");
	private TextArea output = new TextArea();
	private ScrollPane scroll = new ScrollPane();
	
	private String user;
	private int index;
	
	public MainGui(String login, int index) {
		super();
		setTitle("Clash");
		this.user = login;
		this.index = index;
		
		//Main.setStageTitle("Clash");
		
		FlowPane pane = new FlowPane();
		
		pane.getChildren().add(buy);
		pane.getChildren().add(rateLabel);
		pane.getChildren().add(rate);
		pane.getChildren().add(output);
		pane.getChildren().add(refill);
		pane.getChildren().add(refillField);
		
		scroll.setContent(pane);	
		
		refill.setOnAction(e -> {
			try {
				Main.polka.inputMoney(user, Integer.parseInt(refillField.getText()), index);
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		setScene(new Scene(scroll, 500, 300));
		show();
		//Main.setRoot(pane, 500, 350);
		
	}

}
