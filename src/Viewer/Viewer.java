package Viewer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class Viewer extends Application {
private BattleShipSceneBuilder BS=new BattleShipSceneBuilder();
	public void run() {
		launch("");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
		

			primaryStage.setScene(BS.boards());
			primaryStage.setTitle("BattleShip 2: More");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
			Platform.exit();
		}
	}

}
