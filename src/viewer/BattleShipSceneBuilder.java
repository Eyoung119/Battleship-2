package viewer;

import java.util.Optional;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import models.Board;
import models.cellState;

public class BattleShipSceneBuilder {
	private final String BORDER = "-fx-background-color: #000000";
	private final String SHIP_TILE_HIT = "-fx-background-color: red";
	private final String SHIP_TILE_NOT_HIT = "-fx-background-color: grey";
	private final String OCEAN_TILE_HIT = "-fx-background-color: #99ccff";
	private final String OCEAN_TILE_NOT_HIT = "-fx-background-color: #6699ff";
	public String shotCall;

	int numofsquares = 12;
	private Board[] boardInput;

	public void passBoard(Board[] b) {
		boardInput = b;
		numofsquares = b[0].getCells().length + 2;
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
							label.setOnMouseEntered(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent event) {
									label.setStyle(SHIP_TILE_HIT);
								}
							});

							label.setOnMouseExited(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent event) {
									label.setStyle(OCEAN_TILE_NOT_HIT);
								}
							});
							root.getChildren().addAll(label);
						}
					}
				}
			}
		}
		int offset = numofsquares + 2;
		for (int i = 0; i < numofsquares; i++) {
			for (int j = 0; j < numofsquares; j++) {
				if ((i == 0 || i == numofsquares - 1) && (j == 0 || j == numofsquares - 1)) {
					Label label = new Label();
					label.setStyle(BORDER);
					label.setMinSize(25, 25);
					root.setConstraints(label, i + offset, j);
					root.getChildren().addAll(label);
				} else {
					if (i == 0 || i == 11) {
						Label label = new Label();
						label.setStyle(BORDER);
						label.setMinSize(25, 50);
						root.setConstraints(label, i + offset, j);
						root.getChildren().addAll(label);
					} else {
						if (j == 0 || j == 11) {
							Label label = new Label();
							label.setStyle(BORDER);
							label.setMinSize(50, 25);
							root.setConstraints(label, i + offset, j);
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
							root.setConstraints(label, j + offset, i);
							
							label.setOnMouseEntered(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent event) {
									label.setStyle(SHIP_TILE_HIT);
								}
							});
							label.setOnMouseExited(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent event) {
									label.setStyle(OCEAN_TILE_NOT_HIT);
								}
							});
							root.getChildren().addAll(label);
						}
					}
				}
			}
		}
			Label P1Name=new Label(boardInput[0].getPlayer().getName());
			P1Name.setFont(new Font("Arial", 20));
			P1Name.setMinSize(50, 50);
			P1Name.setTextFill(Color.ANTIQUEWHITE);
			root.setConstraints(P1Name, 1, 14,50,1);
			
			Label P2Name=new Label(boardInput[1].getPlayer().getName());
			P2Name.setFont(new Font("Arial", 20));
			P2Name.setMinSize(50, 50);
			P2Name.setTextFill(Color.ANTIQUEWHITE);
			root.setConstraints(P2Name, numofsquares+3, 14,50, 1);
			root.getChildren().addAll(P1Name,P2Name);

		Button saveBtn = new Button(" Save ");
		root.setConstraints(saveBtn, numofsquares+1, 2);
		root.getChildren().add(saveBtn);
		
		saveBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Main.getControl().saveGame();
			}
		});

		Button shootBtn = new Button("Shoot");
		shootBtn.setAlignment(Pos.CENTER);
		root.setConstraints(shootBtn, numofsquares + 1, 4);
		root.getChildren().add(shootBtn);

		shootBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				TextInputDialog shotname = new TextInputDialog("A1");
				shotname.setHeaderText("Enter Coordinates:");
				shotname.setContentText("Start");
				Optional<String> result = shotname.showAndWait();
				shotCall=shotname.getEditor().getText();
			}
		});

		root.setStyle("-fx-background-color: #363940");
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, 1700, 900);
		return scene;

	}
	
	public String getShotCall() {
		return shotCall;
	}

	public Board[] getBoard() {
		return boardInput;
	}
}
