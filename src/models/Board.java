package models;

import java.io.Serializable;

public class Board implements Serializable {
	
	private Player player;
	private Cell[][] cells = new Cell[10][10];
	private Cell[][] filter = new Cell[10][10];
	private int turn = 0;
	
	public Board(Player player) {
		setPlayer(player);
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[x].length; y++) {
				cells[x][y] = new Cell();
				filter[x][y] = new Cell();
			}
		}
	}
	
	public Cell[][] getCells() {
		return cells;
	}
	
	public Cell[][] getFilter() {
		return filter;
	}
	
	public int getTurn() {
		return turn;
	}
	
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public void placeShips() {
		//This method is INCOMPLETE!!!
		//When GUI is finished, complete logic for placing ships.
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
}