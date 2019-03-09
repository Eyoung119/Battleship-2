package models;

import java.io.Serializable;

public class Cell implements Serializable {
	private static final long serialVersionUID = 1L;
	private cellState state = cellState.EMPTY;
	private Ship ship;
	
	public Cell() {
		
	}
	
	public cellState getCellState() {
		return state;
	}
	
	public void setCellState(cellState state) {
		this.state = state;
	}
	
	public void setShip(Ship ship) {
		this.ship = ship;
	}
	
	public Ship getShip() {
		return ship;
	}
	
	@Override
	public String toString() {
		return state.toString();
	}
}
