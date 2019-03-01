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

	public void run() {
		launch("");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Label bulb = new Label();
			VBox root = new VBox();
			root.setAlignment(Pos.CENTER);

			bulb.setMinSize(1700, 900);
			bulb.setStyle("-fx-background-color: black");
			root.getChildren().addAll(bulb);

			Scene scene = new Scene(root,1700, 900);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setScene(scene);
			primaryStage.setTitle("BattleShip 2: More");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
			Platform.exit();
		}
	}

}
