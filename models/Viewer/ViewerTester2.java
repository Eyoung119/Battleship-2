package Viewer;

import models.*;

public class ViewerTester2 {

	public static void main(String[] args) {
		Viewer v = new Viewer();
		Board b = new Board();
		b.placeShips();
		b.getCells()[0][0].setCellState(cellState.MISS);
		System.out.println(b.getCells()[0][0].getCellState());
		v.run(b);
	}
}
