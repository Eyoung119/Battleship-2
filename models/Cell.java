package models;

import java.io.Serializable;

public class Cell implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private cellState state=cellState.EMPTY;
//	SpriteMap sprite;
	
	public Cell() {
		
	}
	
	public cellState getCellState() {
		return state;
	}
	
	public void setCellState(cellState state) {
		this.state = state;
	}
}
