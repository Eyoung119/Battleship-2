package models;

public class Cell {
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
