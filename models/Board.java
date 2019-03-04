package models;

import java.io.Serializable;

public class Board implements Serializable {
	private Cell[][] cells = new Cell[10][10];
	
	public Board() {
	}
	
	public Cell[][] getCells() {
		return cells;
	}
	public void setCells( Cell[][] c) {
		cells=c;
	}
	
	public void placeShips() {
		//Note from lorelei: While using the method you used works great for reading inputs, you wont be able to edit input of
		//the array like that. You MUST use this method to assign values the way you intended
		for(int i=0;i<cells.length;i++) {
			for(int j=0;j<cells[i].length;j++) {
				cells[i][j]=new Cell(cellState.HIT);
			}
		}
		//This method is INCOMPLETE!!!
		//When GUI is finished, complete logic for placing ships.
	}
}
