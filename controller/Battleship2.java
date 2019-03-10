package controller;

import java.io.File;
import java.util.Optional;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import models.Board;
import models.Player;
import viewer.Viewer;

public class Battleship2 {
	private static Viewer viewer = new Viewer();
	private static Board[] boards = new Board[2];
	private static Player[] players = new Player[2];
	private static shotController shotCon;
	private static Serializer serializer;

	public void loadBtn() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));
		fileChooser.setInitialDirectory(new File("saves"));
		File file = fileChooser.showOpenDialog(null);
		if (file != null) {			
			boards = serializer.read(file);
			try {
				shotCon = new ShotController(boards);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Load Game");
				alert.setHeaderText(null);
				alert.setContentText("Game loaded succesfully!");
				alert.showAndWait();
				viewer.run(boards);			
			} catch (Exception e) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Load Game");
				alert.setHeaderText(null);
				alert.setContentText("There was an exception while loading the game.");
				alert.showAndWait();
				e.printStackTrace();
			}
		}
	}

	public void startBtn() {
		TextInputDialog player1Name = new TextInputDialog("Player 1");

		player1Name.setHeaderText("Enter Player 1's Name:");
		player1Name.setContentText("Name:");
		Optional<String> result = player1Name.showAndWait();

		if (result.isPresent()) {

			Player p1 = new Player(player1Name.getEditor().getText());

			TextInputDialog player2Name = new TextInputDialog("Player 2");

			player2Name.setHeaderText("Enter Player 2's Name:");
			player2Name.setContentText("Name:");
			Optional<String> result2 = player2Name.showAndWait();

			if (result2.isPresent()) {

				Player p2 = new Player(player2Name.getEditor().getText());

				players[0] = p1;
				players[1] = p2;

				boards[0] = new Board(players[0]);
				boards[1] = new Board(players[1]);

				try {
					shotCon = new ShotController(boards);
					
					ArrayList<Character> letter = new ArrayList<Character>();
					for (int i = 65; i < 75; i++) {
						Character y = (char) i;
						letter.add(y);
					}
					ArrayList<Integer> number = new ArrayList<Integer>();
					for (int i = 1; i < 11; i++) {
						number.add(i);
					}
					ArrayList<String> orientations = new ArrayList<String>();
						orientations.add("Left");
						orientations.add("Right");
						orientations.add("Up");
						orientations.add("Down");
						
					
					ChoiceDialog<Character> dialog = new ChoiceDialog<>('A', letter);
					int carrierX = 0;
					dialog.setTitle("Carrier");
					dialog.setHeaderText(null);
					dialog.setContentText("Select the first cordinate for your carrier");
					Optional<Character> result3 = dialog.showAndWait();
					if(result3.isPresent()) {
						carrierX = result3.get() - 64;
					}
					
					ChoiceDialog<Integer> dialog2 = new ChoiceDialog<>(1, number);
					int carrierY = 0;
					dialog2.setTitle("Carrier");
					dialog2.setHeaderText(null);
					dialog2.setContentText("Select the first cordinate for your carrier");
					Optional<Integer> result4 = dialog2.showAndWait();
					if(result4.isPresent()) {
						carrierX = result4.get();
					}
					
					ChoiceDialog<String> dialog3 = new ChoiceDialog<>("Left", orientations);
					dialog3.setTitle("Carrier");
					dialog3.setHeaderText(null);
					dialog3.setContentText("Select the first cordinate for your carrier");
					boolean isValid;
					String orientation = null;
					do {
						isValid = true;
						Optional<String> result5 = dialog3.showAndWait();
						if(result5.isPresent()) {
							orientation = result5.get();
							switch (orientation) {
							case "Left":
								if(carrierX - 4 < 0) {
									isValid = false;
								}
								break;
							case "Right":
								if(carrierX + 4 < 0) {
									isValid = false;
								}
								break;
							case "Up":
								if(carrierX - 4 < 0) {
									isValid = false;
								}
								break;
							case "Down":
								if(carrierX + 4 < 0) {
									isValid = false;
								}
								break;
							}
						}
					
					} while (!isValid);
					carrierX--;
					carrierY--;
					switch (orientation) {
					case "Left":
						for (int i = 0; i < 4; i++) {
							boards[0].getCells()[carrierX - i][carrierY].setCellState(cellState.SHIP);
							boards[0].getCells()[carrierX - i][carrierY].setShip(players[0].getShips().get("Carrier"));
						}
						break;
					case "Right":
						for (int i = 0; i < 4; i++) {
							boards[0].getCells()[carrierX + i][carrierY].setCellState(cellState.SHIP);
							boards[0].getCells()[carrierX + i][carrierY].setShip(players[0].getShips().get("Carrier"));
						}
						break;
					case "Up":
						for (int i = 0; i < 4; i++) {
							boards[0].getCells()[carrierX][carrierY - i].setCellState(cellState.SHIP);
							boards[0].getCells()[carrierX][carrierY - i].setShip(players[0].getShips().get("Carrier"));
						}
						break;
					case "Down":
						for (int i = 0; i < 4; i++) {
							boards[0].getCells()[carrierX][carrierY + i].setCellState(cellState.SHIP);
							boards[0].getCells()[carrierX][carrierY + i].setShip(players[0].getShips().get("Carrier"));
						}
						break;
					
					}	
					viewer.run(boards);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void exitBtn() {
		Platform.exit();
	}

	public void takeTurn() {

	}

	public void saveGame() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Save Game");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));
		fileChooser.setInitialDirectory(new File("saves"));
		File saveFile = fileChooser.showSaveDialog(null);
		
		if (saveFile != null) {
			serializer.write(saveFile, boards);
		}
	}

	public void updateDisplay() {

	}
}
