package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import models.Board;

public class Serializer {

	private File file = new File(".txt");
	
	private void write(Board item) throws IOException {
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
			
		}
		finally {
			fos.close();
			oos.close();
		}
	}
	
	private Board read() throws IOException {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		Board item = null;
		try {
			if(!file.exists()) {
				write(new Board());
			}
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			item = (Board) ois.readObject();
		}
		catch(Exception e) {
			
		}
		finally {
			fis.close();
			ois.close();
		}
		
		return item;
	}
	
}
