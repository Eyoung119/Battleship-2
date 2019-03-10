package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import models.Board;
import models.Player;
import models.cellState;
import viewer.Viewer;

public class Battleship2 {
	private static Viewer viewer = new Viewer();
	private static Board[] boards = new Board[2];
	private static Player[] players = new Player[2];
	private static ShotController shotCon;
	private static Serializer serializer = new Serializer();

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
		Player p1 = new Player(player1Name.getEditor().getText());

		TextInputDialog player2Name = new TextInputDialog("Player 2");

		player2Name.setHeaderText("Enter Player 2's Name:");
		player2Name.setContentText("Name:");
		Optional<String> result2 = player2Name.showAndWait();
		Player p2 = new Player(player2Name.getEditor().getText());

		players[0] = p1;
		players[1] = p2;

		boards[0] = new Board(players[0]);
		boards[1] = new Board(players[1]);
		try {
			shotCon = new ShotController(boards);

			for (int x = 0; x < 2; x++) {
				placeShip("Carrier", 5, x);
				placeShip("Battleship", 4, x);
				placeShip("Cruiser", 3, x);
				placeShip("Submarine", 3, x);
				placeShip("Destroyer", 2, x);
			}
			viewer.run(boards);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void exitBtn() {
		Platform.exit();
	}

	public void takeTurn() {
		System.out.println("Test");
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

	public void placeShip(String ship, int size, int player) {
		ArrayList<Character> letters = new ArrayList<>();
		for (int i = 65; i < 75; i++) {
			Character y = (char) i;
			letters.add(y);
		}
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 1; i < 11; i++) {
			numbers.add(i);
		}
		ArrayList<String> orientations = new ArrayList<>();
		orientations.add("Left");
		orientations.add("Right");
		orientations.add("Up");
		orientations.add("Down");
		int shipX = 0;
		int shipY = 0;
		boolean isValid;
		String orientation = null;
		
		do {
			ChoiceDialog<Character> dialog = new ChoiceDialog<>('A', letters);
			shipX = 0;
			dialog.setTitle(players[player].getName() + "'s " + ship);
			dialog.setHeaderText(null);
			dialog.setContentText("Select the first coordinate for your " + ship + ":");
			Optional<Character> result3 = dialog.showAndWait();
			if (result3.isPresent()) {
				shipX = result3.get() - 64;
			}
			
			ChoiceDialog<Integer> dialog2 = new ChoiceDialog<>(1, numbers);
			shipY = 0;
			dialog2.setTitle(players[player].getName() + "'s " + ship);
			dialog2.setHeaderText(null);
			dialog2.setContentText("Select the second coordinate for your " + ship + ":");
			Optional<Integer> result4 = dialog2.showAndWait();
			if (result4.isPresent()) {
				shipY = result4.get();
			}
			
			ChoiceDialog<String> dialog3 = new ChoiceDialog<>("Left", orientations);
			dialog3.setTitle(players[player].getName() + "'s " + ship);
			dialog3.setHeaderText(null);
			dialog3.setContentText("Select the orientation for your " + ship + ":");
			orientation = null;
			isValid = true;
			Optional<String> result5 = dialog3.showAndWait();
			if (result5.isPresent()) {
				orientation = result5.get();
				shipX--;
				shipY--;
				switch (orientation) {
				case "Up":
					if (shipX - (size - 1) < 1) {
						isValid = false;
					}
					try {						
						for (int x = 0; x < size; x++) {
							if (boards[player].getCells()[shipX - x][shipY].getCellState() == cellState.SHIP) {
								isValid = false;
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						isValid = false;
					}
					break;
				case "Down":
					if (shipX + (size - 1) > 10) {
						isValid = false;
					}
					try {						
						for (int x = 0; x < size; x++) {
							if (boards[player].getCells()[shipX + x][shipY].getCellState() == cellState.SHIP) {
								isValid = false;
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						isValid = false;
					}
					break;
				case "Left":
					if (shipY - (size - 1) < 1) {
						isValid = false;
					}
					try {						
						for (int x = 0; x < size; x++) {
							if (boards[player].getCells()[shipX][shipY - x].getCellState() == cellState.SHIP) {
								isValid = false;
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						isValid = false;
					}
					break;
				case "Right":
					if (shipY + (size - 1) > 10) {
						isValid = false;
					}
					try {						
						for (int x = 0; x < size; x++) {
							if (boards[player].getCells()[shipX][shipY + x].getCellState() == cellState.SHIP) {
								isValid = false;
							}
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						isValid = false;
					}
					break;
				}
			}
		}while(!isValid);switch(orientation)

	{
		case "Up":
			for (int i = 0; i < size; i++) {				
				boards[player].getCells()[shipX - i][shipY].setCellState(cellState.SHIP);
				boards[player].getCells()[shipX - i][shipY].setShip(players[0].getShips().get(ship));
			}
			break;
		case "Down":
			for (int i = 0; i < size; i++) {				
				boards[player].getCells()[shipX + i][shipY].setCellState(cellState.SHIP);
				boards[player].getCells()[shipX + i][shipY].setShip(players[0].getShips().get(ship));
			}
			break;
		case "Left":
			for (int i = 0; i < size; i++) {				
				boards[player].getCells()[shipX][shipY - i].setCellState(cellState.SHIP);
				boards[player].getCells()[shipX][shipY - i].setShip(players[0].getShips().get(ship));
			}
			break;
		case "Right":
			for (int i = 0; i < size; i++) {				
				boards[player].getCells()[shipX][shipY + i].setCellState(cellState.SHIP);
				boards[player].getCells()[shipX][shipY + i].setShip(players[0].getShips().get(ship));
			}
			break;
		}
	}
}
