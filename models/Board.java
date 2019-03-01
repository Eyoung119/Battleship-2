package models;

import java.io.Serializable;

public class Board implements Serializable {
	private Cell[][] cells = new Cell[10][10];
	
	public Board() {
		
	}
	
	public Cell[][] getCells() {
		return cells;
	}
	
	public void placeShips() {
		for (Cell[] x : cells) {
			for (Cell y : x) {
				y = new Cell(cellState.EMPTY);
			}
		}
		//This method is INCOMPLETE!!!
		//When GUI is finished, complete logic for placing ships.
	}
}
