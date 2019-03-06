package models;

import java.io.Serializable;

public class Player implements Serializable {
	private String name;
	
	public Player(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
