package controller;

import java.io.File;
import java.util.Optional;

import javafx.application.Platform;
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
		fileChooser.setInitialDirectory(new File("saves"));
		File file = fileChooser.showOpenDialog(null);
		if (file != null) {
			boards = serializer.read(file);
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

	public void loadGame(File file) {
		boards = serializer.read(file);
	}

	public void updateDisplay() {

	}
}
