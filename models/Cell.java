package models;

import java.io.Serializable;

public class Cell implements Serializable {
	private cellState state=cellState.EMPTY;
//	SpriteMap sprite;
	
	public Cell(cellState state) {
		setCellState(state);
	}
	
	public cellState getCellState() {
		return state;
	}
	
	public void setCellState(cellState state) {
		this.state = state;
	}
}
