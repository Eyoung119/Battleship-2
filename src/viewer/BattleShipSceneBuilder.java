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
	private final String ALPHABET="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public String shotCall;
	public int x;
	public int y;
	private int[][] b1;
	private int[][] b2;
	int numofsquares = 12;
	private Board[] boardInput;
	

	public void passBoard(Board[] b) {
		boardInput = b;
		numofsquares = b[0].getCells().length + 2;
		b1 = new int[b[0].getCells().length][b[0].getCells().length];
		b2 = new int[b[0].getCells().length][b[0].getCells().length];
	}

	@SuppressWarnings({ "static-access" })
	public Scene boardDisplayTest(Board[] boardInput, int currentPlayer) {
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
						Label label = new Label((ALPHABET.charAt(j-1))+"");
						label.setFont(new Font("Arial", 20));
						label.setTextFill(Color.ANTIQUEWHITE);
						label.setStyle(BORDER);
						label.setMinSize(25, 50);
						root.setConstraints(label, i, j);
						root.getChildren().addAll(label);
					} else {
						if (j == 0 || j == 11) {
							Label label = new Label(i+"");
							label.setFont(new Font("Arial", 20));
							label.setTextFill(Color.ANTIQUEWHITE);
							label.setStyle(BORDER);
							label.setMinSize(50, 25);
							root.setConstraints(label, i, j);
							root.getChildren().addAll(label);
						} else {
							Label label = new Label();
							if (boardInput[currentPlayer].getCells()[i - 1][j - 1].getCellState() == cellState.SHIP) {
								label.setStyle(SHIP_TILE_NOT_HIT);
							}
							if (boardInput[currentPlayer].getCells()[i - 1][j - 1].getCellState() == cellState.EMPTY) {
								label.setStyle(OCEAN_TILE_NOT_HIT);
							}
							if (boardInput[currentPlayer].getCells()[i - 1][j - 1].getCellState() == cellState.MISS) {
								label.setStyle(OCEAN_TILE_HIT);
							}
							if (boardInput[currentPlayer].getCells()[i - 1][j - 1].getCellState() == cellState.HIT) {
								label.setStyle(SHIP_TILE_HIT);
							}
							label.setMinSize(48, 48);
							label.setAlignment(Pos.CENTER);
							root.setConstraints(label, j, i);

							label.setOnMouseClicked(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent event) {
									int b1x = 0;
									int b1y = 0;
									for (int i = 0; i < b1.length; i++) {
										for (int j = 0; j < b1[i].length; j++) {
											if (root.getChildren().indexOf(event.getSource()) == b1[i][j]) {
												b1x = i;
												b1y = j;
											}
										}
									}
									System.out.println(b1x + " " + b1y + " " + boardInput[0].getPlayer());
									// Put your click method here. Uncomment this method and put your own in.
									// METHODNAME(int x, int y,boardInput[0].getPlayer());

									// dont forget about the second array
									// |
									// |
									// |
									// V

								}
							});

//							label.setOnMouseEntered(new EventHandler<MouseEvent>() {
//								@Override
//								public void handle(MouseEvent event) {
//									label.setStyle(SHIP_TILE_HIT);
//									root.getChildren();
//									System.out.println(root.getChildren().indexOf(event.getSource()));
//								}
//
//							});
							x = i;
							y = j;
//							label.setOnMouseExited(new EventHandler<MouseEvent>() {
//								@Override
//								public void handle(MouseEvent event) {
//									if (boardInput[0].getCells()[x - 1][y - 1].getCellState() == cellState.SHIP) {
//										label.setStyle(SHIP_TILE_NOT_HIT);
//									}
//									if (boardInput[0].getCells()[x - 1][y - 1].getCellState() == cellState.EMPTY) {
//										label.setStyle(OCEAN_TILE_NOT_HIT);
//									}
//									if (boardInput[0].getCells()[x - 1][y - 1].getCellState() == cellState.MISS) {
//										label.setStyle(OCEAN_TILE_HIT);
//									}
//									if (boardInput[0].getCells()[x - 1][y - 1].getCellState() == cellState.HIT) {
//										label.setStyle(SHIP_TILE_HIT);
//									}
//								}
//							});
							root.getChildren().addAll(label);
							b1[i - 1][j - 1] = root.getChildren().indexOf(label);
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
						Label label = new Label((ALPHABET.charAt(j-1))+"");
						label.setFont(new Font("Arial", 20));
						label.setTextFill(Color.ANTIQUEWHITE);
						label.setStyle(BORDER);
						label.setMinSize(25, 50);
						root.setConstraints(label, i + offset, j);
						root.getChildren().addAll(label);
					} else {
						if (j == 0 || j == 11) {
							Label label = new Label(i+"");
							label.setFont(new Font("Arial", 20));
							label.setTextFill(Color.ANTIQUEWHITE);
							label.setStyle(BORDER);
							label.setMinSize(50, 25);
							root.setConstraints(label, i + offset, j);
							root.getChildren().addAll(label);
						} else {
							Label label = new Label();
							if (boardInput[currentPlayer == 0 ? 1 : 0].getFilter()[i - 1][j - 1]
									.getCellState() == cellState.SHIP) {
								label.setStyle(SHIP_TILE_NOT_HIT);
							}
							if (boardInput[currentPlayer == 0 ? 1 : 0].getFilter()[i - 1][j - 1]
									.getCellState() == cellState.EMPTY) {
								label.setStyle(OCEAN_TILE_NOT_HIT);
							}
							if (boardInput[currentPlayer == 0 ? 1 : 0].getFilter()[i - 1][j - 1]
									.getCellState() == cellState.MISS) {
								label.setStyle(OCEAN_TILE_HIT);
							}
							if (boardInput[currentPlayer == 0 ? 1 : 0].getFilter()[i - 1][j - 1]
									.getCellState() == cellState.HIT) {
								label.setStyle(SHIP_TILE_HIT);
							}
							label.setMinSize(48, 48);
							label.setAlignment(Pos.CENTER);
							root.setConstraints(label, j + offset, i);

							label.setOnMouseClicked(new EventHandler<MouseEvent>() {
								@Override
								public void handle(MouseEvent event) {
									int b2x = 0;
									int b2y = 0;
									for (int i = 0; i < b2.length; i++) {
										for (int j = 0; j < b2[i].length; j++) {
											if (root.getChildren().indexOf(event.getSource()) == b2[i][j]) {
												b2x = i;
												b2y = j;
											}
										}
									}
									System.out.println(b2x + " " + b2y + " " + boardInput[1].getPlayer());
									// Put your click method here. Uncomment this method and put your own in.
									// METHODNAME(int x, int y,boardInput[1].getPlayer());

								}
							});
//
//							label.setOnMouseEntered(new EventHandler<MouseEvent>() {
//								@Override
//								public void handle(MouseEvent event) {
//									label.setStyle(SHIP_TILE_HIT);
//									root.getChildren();
//									System.out.println(root.getChildren().indexOf(event.getSource()));
//								}
//							});
							x = i;
							y = j;
//							label.setOnMouseExited(new EventHandler<MouseEvent>() {
//								@Override
//								public void handle(MouseEvent event) {
//									if (boardInput[0].getCells()[x - 1][y - 1].getCellState() == cellState.SHIP) {
//										label.setStyle(SHIP_TILE_NOT_HIT);
//									}
//									if (boardInput[0].getCells()[x - 1][y - 1].getCellState() == cellState.EMPTY) {
//										label.setStyle(OCEAN_TILE_NOT_HIT);
//									}
//									if (boardInput[0].getCells()[x - 1][y - 1].getCellState() == cellState.MISS) {
//										label.setStyle(OCEAN_TILE_HIT);
//									}
//									if (boardInput[0].getCells()[x - 1][y - 1].getCellState() == cellState.HIT) {
//										label.setStyle(SHIP_TILE_HIT);
//									}
//								}
//							});
							root.getChildren().addAll(label);
							b2[i - 1][j - 1] = root.getChildren().indexOf(label);
						}
					}
				}
			}
		}
		Label P1Name = new Label(boardInput[currentPlayer].getPlayer().getName());
		P1Name.setFont(new Font("Arial", 20));
		P1Name.setMinSize(50, 50);
		P1Name.setTextFill(Color.ANTIQUEWHITE);
		root.setConstraints(P1Name, 1, 14, 50, 1);

		Label P2Name = new Label(boardInput[currentPlayer == 0 ? 1 : 0].getPlayer().getName());
		P2Name.setFont(new Font("Arial", 20));
		P2Name.setMinSize(50, 50);
		P2Name.setTextFill(Color.ANTIQUEWHITE);
		root.setConstraints(P2Name, numofsquares + 3, 14, 50, 1);
		root.getChildren().addAll(P1Name, P2Name);

		Label saveBtn = new Label();
		saveBtn.setStyle("-fx-background-color: #363940");
		saveBtn.setMinSize(50, 50);
		root.setConstraints(saveBtn, numofsquares + 1, 2);
		root.getChildren().add(saveBtn);


		root.setStyle("-fx-background-color: #363940");
		root.setAlignment(Pos.CENTER);
		Scene scene = new Scene(root, 1700, 900);
		return scene;
}
	
	public Scene passPlayer() {
		VBox root = new VBox();
		Label label = new Label("Please Pass Your Turn. You have eight seconds to.");
		label.setMinSize(400, 400);
		label.setAlignment(Pos.CENTER);
		label.setStyle(OCEAN_TILE_HIT);

		label.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
			}
		});
		root.getChildren().add(label);
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