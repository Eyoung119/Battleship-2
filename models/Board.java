package models;

import java.io.Serializable;

public class Board implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Player player = null;
	private Cell[][] cells = new Cell[10][10];
	
	public Board(Player player) {
		setPlayer(player);
		for (int x = 0; x < cells.length; x++) {
			for (int y = 0; y < cells[x].length; y++) {
				cells[x][y] = new Cell();
			}
		}
	}
	
	public Cell[][] getCells() {
		return cells;
		
	}
	
	public void placeShips() {
		//This method is INCOMPLETE!!!
		//When GUI is finished, complete logic for placing ships.
		//Select space for ships?
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
} 
