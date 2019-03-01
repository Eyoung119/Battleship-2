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

public class BattleShipSceneBuilder {
	public Scene defaultScreen() {
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		Label bulb = new Label();
		bulb.setMinSize(1700, 900);
		bulb.setStyle("-fx-background-color: black");
		root.getChildren().addAll(bulb);

		Label enemyBoardBackground = new Label();
		// enemyBoardBackground.setX();

		Label playerBoardBackground = new Label();
		Scene scene = new Scene(root, 1700, 900);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		return scene;
	}

	int numofsquares = 11;

	public Scene boards() {
		GridPane root = new GridPane();

		for (int i = 0; i < numofsquares; i++) {
			for (int j = 0; j < numofsquares; j++) {
				if (i == 0 && j == 0) {
					Label label = new Label();
					label.setStyle("-fx-background-color: #000000");
					label.setMinSize(25, 25);
					root.setConstraints(label, 0, 0);
					root.getChildren().addAll(label);
				} else {
					if (i == 0) {
						Label label = new Label();
						label.setStyle("-fx-background-color: #000000");
						label.setMinSize(25, 50);
						root.setConstraints(label, 0, j);
						root.getChildren().addAll(label);
					} else {
						if (j == 0) {
							Label label = new Label();
							label.setStyle("-fx-background-color: #000000");
							label.setMinSize(50, 25);
							root.setConstraints(label, i, 0);
							root.getChildren().addAll(label);
						} else {
							Label label = new Label();
							label.setStyle("-fx-background-color: #6699ff");
							label.setMinSize(49, 49);
							label.setAlignment(Pos.BOTTOM_RIGHT);
							root.setConstraints(label, j, i);
							root.getChildren().addAll(label);
						}
					}
				}
			}
		}

		Label label = new Label();
		label.setStyle("-fx-background-color: #FF0000");
		label.setMinSize(49, 49);
		root.setConstraints(label, 1, 1);
		root.getChildren().addAll(label);
		Scene scene = new Scene(root, 1700, 900);
		return scene;

	}
}