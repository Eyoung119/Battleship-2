package controllers;

import java.util.Random;

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
	
	public void shot (int currentPlayer, int x, int y) {
		setCurrentPlayer(currentPlayer);
		int enemy = currentPlayer == 0 ? 1 : 0;
		if (boards[enemy].getCells()[x][y].getCellState() == cellState.SHIP) {
			boards[enemy].getCells()[x][y].setCellState(cellState.HIT);
			boards[enemy].getCells()[x][y].getShip().setLength(boards[enemy].getCells()[x][y].getShip().getLength() - 1);
		} else {
			boards[enemy].getCells()[x][y].setCellState(cellState.MISS);
		}
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
	
	public void mortarStrike (int currentPlayer, int x1, int x2, int y1, int y2) {
		setCurrentPlayer(currentPlayer);
		shot(currentPlayer, x1, y1);
		shot(currentPlayer, x1, y2);
		shot(currentPlayer, x2, y1);
		shot(currentPlayer, x2, y2);
	}
	
	public void missileBarrage (int currentPlayer, int x, int y) {
		Random rng = new Random();
		setCurrentPlayer(currentPlayer);
		shot(currentPlayer, x, y);
		shot(currentPlayer, rng.nextInt(10), rng.nextInt(10));
		shot(currentPlayer, rng.nextInt(10), rng.nextInt(10));
		shot(currentPlayer, rng.nextInt(10), rng.nextInt(10));
	}
	
	public int sonar (int currentPlayer, int x, int y) {
		setCurrentPlayer(currentPlayer);
		int numShips = 0;
		int enemy = currentPlayer == 0 ? 1 : 0;
		for (int i = x - 1; i < x + 1; i++) {
			for (int j = y - 1; j < y + 1; j++) {
				if (boards[enemy].getCells()[i][j].getCellState() == cellState.SHIP) {
					numShips++;
				}
			}
		}
		
		return numShips;
	}
	
	public void doubleShot (int currentPlayer, int x1, int x2, int y1, int y2) {
		setCurrentPlayer(currentPlayer);
		shot(currentPlayer, x1, y1);
		shot(currentPlayer, x2, y2);
	}
}
