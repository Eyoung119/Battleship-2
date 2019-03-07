package models;

import java.io.Serializable;
import java.util.HashMap;

public class Player implements Serializable {
	private String name;
	private HashMap<String, Ship> ships = new HashMap<String, Ship>();
	
	public Player(String name) {
		setName(name);
		ships.put("Carrier", new Ship(shipType.CARRIER));
		ships.put("Battleship", new Ship(shipType.BATTLESHIP));
		ships.put("Cruiser", new Ship(shipType.CRUISER));
		ships.put("Submarine", new Ship(shipType.SUBMARINE));
		ships.put("Destroyer", new Ship(shipType.DESTROYER));
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public HashMap<String, Ship> getShips() {
		return ships;
	}
}
