package gui.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import program.Main;

public class MainGui extends Stage{
	
	private Button buy = new Button("Buy an installation");
	private Button refill = new Button("Fund your account");
	private TextField refillField = new TextField();
	private TextField rateField = new TextField();
	private Label rateLabel = new Label("Your rate: ");
	private TextArea output = new TextArea();
	private ScrollPane scroll = new ScrollPane();
	
	private String user;
	private int index;
	private boolean flag = false;
	//static public int persone = 0;
	//static public String personne;
	
	public MainGui(String login, int index) {
		super();
		setTitle("Clash");
		this.user = login;
		this.index = index;
		
		//Main.setStageTitle("Clash");
		
		FlowPane pane = new FlowPane();
		
		pane.getChildren().add(buy);
		pane.getChildren().add(rateLabel);
		pane.getChildren().add(rateField);
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
		
		buy.setOnAction(e -> {
			if (!flag) {
				System.out.println("IN flag ");
				Task<String> t = new Task<String>() {
	 				protected String call() throws NumberFormatException, SQLException {
				        flag = true;
	 					return Main.polka.buy(login, Integer.parseInt(rateField.getText()));
	 				}
	 				protected void succeeded() {
	 					Platform.runLater(() -> output.appendText(getValue()));
	 				}
	 			};
	 			Thread th = new Thread(t);
	 			th.setDaemon(true); // the thread won't block exiting JVM
	 			th.start();
				
//				try {
//					Main.polka.buy(login, Integer.parseInt(rateField.getText()));
//				} catch (NumberFormatException | SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				flag = true;
			}
			
		});
		
		setScene(new Scene(scroll, 500, 300));
		show();
		//Main.setRoot(pane, 500, 350);
		
	}

}
