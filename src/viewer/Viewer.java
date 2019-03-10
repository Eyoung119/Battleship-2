package viewer;

import application.Main;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import models.Board;

public class Viewer extends Application {
private BattleShipSceneBuilder BS=new BattleShipSceneBuilder();
private static Board[] viewerBoard;
private static int currentPlayer;


//Create a viewer and pass in Board from run()
//This will create a new window displaying the values
	public void run(Board[] b, int currentPlayer) {
		viewerBoard=b;
		System.out.println(viewerBoard);
		this.currentPlayer = currentPlayer;
		BS.passBoard(b);
		try {			
			start(Main.getStage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			primaryStage.setScene(BS.boardDisplayTest(viewerBoard, currentPlayer));
			primaryStage.setTitle("BattleShip 2: More");
			primaryStage.setMaximized(true);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
			Platform.exit();
		}
	}

}
