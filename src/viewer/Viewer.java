package viewer;

import application.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Board;

public class Viewer extends Application {
private BattleShipSceneBuilder BS=new BattleShipSceneBuilder();
private static Board[] viewerBoard;
private static int currentPlayer;
Scene activeScene=null;


//Create a viewer and pass in Board from run()
//This will create a new window displaying the values
	public void run(Board[] b, int currentPlayer) {
		viewerBoard=b;
		System.out.println(viewerBoard);
		this.currentPlayer = currentPlayer;
		BS.passBoard(b);
		activeScene =BS.boardDisplayTest(viewerBoard, currentPlayer);
		try {
			start(Main.getStage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void passPlayer() throws InterruptedException {
		activeScene=BS.passPlayer();
		try {			
			start(Main.getStage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(8000);
		Main.getControl().swapturns();
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			primaryStage.setScene(activeScene);
			primaryStage.setTitle("BattleShip 2: More");
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
			Platform.exit();
		}
	}
	
}
