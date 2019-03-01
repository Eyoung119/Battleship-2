package controllers;

import models.Board;
import models.Player;

public class Battleship2 {
	private Board[] boards = new Board[2];
	private Player[] players = new Player[2];
	private ShotController shotCon;
//	private Viewer display;
	private Serializer serializer;
	
	public void run() {
		
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
