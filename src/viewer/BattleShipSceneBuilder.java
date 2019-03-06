package viewer;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import models.Board;
import models.cellState;

public class BattleShipSceneBuilder {
	private final String BORDER = "-fx-background-color: #000000";
	private final String SHIP_TILE_HIT = "-fx-background-color: red";
	private final String SHIP_TILE_NOT_HIT = "-fx-background-color: grey";
	private final String OCEAN_TILE_HIT = "-fx-background-color: #99ccff";
	private final String OCEAN_TILE_NOT_HIT = "-fx-background-color: #6699ff";

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

	int numofsquares = 12;
	private Board[] boardInput;

	public void passBoard(Board[] b) {
		boardInput = b;
		numofsquares= b[0].getCells().length+2;
	}
	

	public Scene boardDisplayTest(Board[] boardInput) {
		GridPane root = new GridPane();
		System.out.println(boardInput);
		for (int i = 0; i < numofsquares; i++) {
			for (int j = 0; j < numofsquares; j++) {
				if ((i == 0 || i == numofsquares - 1) && (j == 0 || j == numofsquares - 1)) {
					Label label = new Label();
					label.setStyle(BORDER);
					label.setMinSize(25, 25);
					root.setConstraints(label, i, j);
					root.getChildren().addAll(label);
				} else {
					if (i == 0 || i == 11) {
						Label label = new Label();
						label.setStyle(BORDER);
						label.setMinSize(25, 50);
						root.setConstraints(label, i, j);
						root.getChildren().addAll(label);
					} else {
						if (j == 0 || j == 11) {
							Label label = new Label();
							label.setStyle(BORDER);
							label.setMinSize(50, 25);
							root.setConstraints(label, i, j);
							root.getChildren().addAll(label);
						} else {
							Label label = new Label();
							if (boardInput[0].getCells()[i - 1][j - 1].getCellState() == cellState.SHIP) {
								label.setStyle(SHIP_TILE_NOT_HIT);
							}
							if (boardInput[0].getCells()[i - 1][j - 1].getCellState() == cellState.EMPTY) {
								label.setStyle(OCEAN_TILE_NOT_HIT);
							}
							if (boardInput[0].getCells()[i - 1][j - 1].getCellState() == cellState.MISS) {
								label.setStyle(OCEAN_TILE_HIT);
							}
							if (boardInput[0].getCells()[i - 1][j - 1].getCellState() == cellState.HIT) {
								label.setStyle(SHIP_TILE_HIT);
							}
							label.setMinSize(48, 48);
							label.setAlignment(Pos.CENTER);
							root.setConstraints(label, j, i);
							root.getChildren().addAll(label);
						}
					}
				}
			}
		}
		Label test = new Label();
		test.setStyle("-fx-background-color: yellow");
		test.setMinSize(25, 25);
		root.setConstraints(test, numofsquares+1, 1);
		root.getChildren().addAll(test);
		int offset=numofsquares+2;
		for (int i = 0; i < numofsquares; i++) {
			for (int j = 0; j < numofsquares; j++) {
				if ((i == 0 || i == numofsquares - 1) && (j == 0 || j == numofsquares - 1)) {
					Label label = new Label();
					label.setStyle(BORDER);
					label.setMinSize(25, 25);
					root.setConstraints(label, i+offset, j);
					root.getChildren().addAll(label);
				} else {
					if (i == 0 || i == 11) {
						Label label = new Label();
						label.setStyle(BORDER);
						label.setMinSize(25, 50);
						root.setConstraints(label, i+offset, j);
						root.getChildren().addAll(label);
					} else {
						if (j == 0 || j == 11) {
							Label label = new Label();
							label.setStyle(BORDER);
							label.setMinSize(50, 25);
							root.setConstraints(label, i+offset, j);
							root.getChildren().addAll(label);
						} else {
							Label label = new Label();
							if (boardInput[1].getCells()[i - 1][j - 1].getCellState() == cellState.SHIP) {
								label.setStyle(SHIP_TILE_NOT_HIT);
							}
							if (boardInput[1].getCells()[i - 1][j - 1].getCellState() == cellState.EMPTY) {
								label.setStyle(OCEAN_TILE_NOT_HIT);
							}
							if (boardInput[1].getCells()[i - 1][j - 1].getCellState() == cellState.MISS) {
								label.setStyle(OCEAN_TILE_HIT);
							}
							if (boardInput[1].getCells()[i - 1][j - 1].getCellState() == cellState.HIT) {
								label.setStyle(SHIP_TILE_HIT);
							}
							label.setMinSize(48, 48);
							label.setAlignment(Pos.CENTER);
							root.setConstraints(label, j+offset, i);
							root.getChildren().addAll(label);
						}
					}
				}
			}
		}
		
		Label P1Name=new Label(boardInput[0].getPlayer().getName());
		P1Name.setMinSize(50, 50);
		root.setConstraints(P1Name, 1, 14,5,1);
		Label P2Name=new Label(boardInput[1].getPlayer().getName());
		P1Name.setMinSize(50, 50);
		root.setConstraints(P2Name, numofsquares+3, 14,5, 1);
		root.getChildren().addAll(P1Name,P2Name);
		
		Button saveBtn = new Button("Save");
		root.setConstraints(saveBtn, numofsquares+1, 2);
		root.getChildren().add(saveBtn);
		
		
		Button saveBtn = new Button("Save");
		root.setConstraints(saveBtn, numofsquares+1, 2);
		root.getChildren().add(saveBtn);
		
		saveBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
			}
		});
		
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, 1700, 900);
		return scene;

	}

	public Board[] getBoard() {
		return boardInput;
	}
}
