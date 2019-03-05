package application;

import controllers.Battleship2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private static Stage stage = new Stage();
	private Battleship2 control = new Battleship2();

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			stage = primaryStage;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/viewer/GameGUI.fxml"));
			loader.setController(control);
			Parent root = loader.load();
			
		    
	        Scene scene = new Scene(root, 359, 374);
	    
	        primaryStage.setTitle("Battleship 2: MORE");
	        //BattleShipSceneBuilder.boardDisplayTest()
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static Stage getStage() {
		return stage;
	}
}
