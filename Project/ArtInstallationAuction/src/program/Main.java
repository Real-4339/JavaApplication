package program;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import database.SqlDB;
import independent.Storage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	// Making main storage and sql connection for a program
	public static SqlDB sql = new SqlDB();
	public static Storage polka = new Storage(sql);
	
	//public static ArrayList<ArrayList> array = new ArrayList();
	public static Hashtable<Integer, ArrayList> hash = new Hashtable<>();
	
    private static Scene scene;
    private static Stage stage;
    
    public static void CloseStage() {stage.close();}
    
    public void start(Stage stage) throws IOException {
    	
    	 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/resources/log_form.fxml"));
	     Parent root1 = (Parent) fxmlLoader.load();
	     stage.setTitle("Login");
	     stage.setScene(new Scene(root1, 800, 500));
	     stage.show();
    }
    
    public static void startMain(int index) throws IOException {
    	ArrayList arr = new ArrayList();
 
    	Scene scene = new Scene(loadFXML("/resources/HomePage")); // , 1400, 800
    	Stage stage = new Stage();
    	stage.setTitle("Home");
        stage.setScene(scene);
        
        stage.show();
        arr.add(stage);
        arr.add(scene);
        hash.put(index, arr);
        //System.out.println(hash.size() + " size");
    }
    // Strategy ?
    public static void startMainRoot(int index) throws IOException {
    	ArrayList arr = new ArrayList();
 
    	Scene scene = new Scene(loadFXML("/resources/HomePageRoot")); // , 1400, 800
    	Stage stage = new Stage();
    	stage.setTitle("Home");
        stage.setScene(scene);
        
        stage.show();
        arr.add(stage);
        arr.add(scene);
        hash.put(index, arr);
        //System.out.println(hash.size() + " size");
    }
    
    public static void setStageTitle(String text) {
    	stage.setTitle(text);
    }
    
    public static void setRoot(String fxml, Stage stage, Scene scene) throws IOException {
    	scene.setRoot(loadFXML1(fxml));
    	stage.setScene(scene);
    	stage.show();
    }
    
    public static void setRoot1(String fxml) throws IOException {
    	scene.setRoot(loadFXML1(fxml));
    }

    public static void setRoot(FlowPane panel, int a, int b) throws IOException {
        stage.setScene(new Scene(panel, a, b));
    }
    
    public static void setRoot(String fxml, int a, int b) throws IOException {
        stage.setScene(new Scene(loadFXML(fxml), a, b));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    private static Parent loadFXML1(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
