package Viewer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
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
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 1500, 900);
			//Scene p2=new Scene(root,1500,900);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			primaryStage.setScene(scene);
			Button lightSwitch = new Button("Don't Touch");
			lightSwitch.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					
				}
			});
			VBox switchBox = new VBox();
			switchBox.setAlignment(Pos.CENTER);
			switchBox.setPadding(new Insets(20, 40, 20, 40));
			switchBox.getChildren().add(lightSwitch);

			root.getChildren().addAll(switchBox);
			primaryStage.setTitle("BattleShip 2: More");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
			Platform.exit();
		}
	}

}
