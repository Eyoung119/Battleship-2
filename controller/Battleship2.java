package controllers;

import java.io.File;

import javafx.application.Platform;
import models.Board;
import models.Player;
import models.cellState;
import viewer.Viewer;

public class Battleship2 {
	private static Viewer viewer = new Viewer();
	private static Board[] boards = new Board[2];
	private static Player[] players = new Player[2];
	private static ShotController shotCon;
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
		boards[0] = new Board();
		boards[1] = new Board();
		try {
			viewer.run(boards);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void exitBtn() {
		Platform.exit();
	}
	
	public void takeTurn() {
		
	}
	
	public void saveGame() {
		serializer.write(boards);
	}
	
	public void loadGame(File file) {
		boards = serializer.read(file);
	}
	
	public void updateDisplay() {
		
	}
}
