package Viewer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Viewer extends Application {
	public void run() {
		launch("");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("BattleShip-2.fxml"));
		    
	        Scene scene = new Scene(root, 300, 275);
	    
	        primaryStage.setTitle("FXML Welcome");
	        primaryStage.setScene(scene);
	        primaryStage.show();
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root, 1500, 900);
//			//Scene p2=new Scene(root,1500,900);
//			scene.getStylesheets().add(getClass().getResource("BattleShip-2.fxml").toExternalForm());
//			primaryStage.setTitle("BattleShip 2: More");
//			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
			Platform.exit();
		}
	}

}
