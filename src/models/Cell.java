package models;

import java.io.Serializable;

public class Cell implements Serializable {
	private cellState state = cellState.EMPTY;
//	SpriteMap sprite;
	
	public Cell() {
	}
	
	public cellState getCellState() {
		return state;
	}
	
	public void setCellState(cellState state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return state.toString();
	}
}
