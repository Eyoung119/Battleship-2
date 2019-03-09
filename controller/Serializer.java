package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import models.Board;

public class Serializer {

	
	public void write(File file, Board[] item) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(item);
		}
		catch(Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Load Game");
			alert.setHeaderText(null);
			alert.setContentText("There was an exception while saving the game.");
			alert.showAndWait();
			e.printStackTrace();
		}
		finally {
			try {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Save Game");
				alert.setHeaderText(null);
				alert.setContentText("Game saved succesfully!");
				alert.showAndWait();
				fos.close();
				oos.close();
			} catch (IOException ioe) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Load Game");
				alert.setHeaderText(null);
				alert.setContentText("There was an exception while saving the game.");
				alert.showAndWait();
				ioe.printStackTrace();
			}
		}
	}
	
	public Board[] read(File file) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Board[] item = null;
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			item = (Board[]) ois.readObject();
		}
		catch(Exception e) {
			
		}
		finally {
			try {				
				fis.close();
				ois.close();
			} catch (IOException ioe) {
				System.out.println("There was an IOException, RIP.");
				ioe.printStackTrace();
			}
		}
		
		return item;
	}
	
}
