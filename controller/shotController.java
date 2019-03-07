package controllers;

import models.Board;
import models.Cell;
import models.cellState;

public class ShotController {
	private Board[] boards;
	private int currentPlayer = 0;
	
	public ShotController(Board[] boards) {
		setBoards(boards);
	}
	
	public void setBoards(Board[] boards) {
		this.boards = boards;
	}
	
	private void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	
	public void shot (int currentPlayer) {
		setCurrentPlayer(currentPlayer);
	}
	
	public boolean spyPlane (int currentPlayer, Cell[] cells) {
		setCurrentPlayer(currentPlayer);
		for (Cell c : cells) {
			if (c.getCellState() == cellState.SHIP) {
				return true;
			}
		}
		return false;
	}
	
	public void mortarStrike (int currentPlayer) {
		setCurrentPlayer(currentPlayer);
	}
	
	public void missileBarrage (int currentPlayer) {
		setCurrentPlayer(currentPlayer);
	}
	
	public void sonar (int currentPlayer) {
		setCurrentPlayer(currentPlayer);
	}
	
	public void doubleShot (int currentPlayer) {
		setCurrentPlayer(currentPlayer);
		shot(currentPlayer);
		shot(currentPlayer);
	}
}
