package Viewer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import models.*;

public class Viewer extends Application {
private BattleShipSceneBuilder BS=new BattleShipSceneBuilder();
private static Board viewerBoard;


//Create a viewer and pass in Board from run()
//This will create a new window displaying the values
	public void run(Board b) {
		viewerBoard=b;
		System.out.println(viewerBoard);
		BS.passBoard(b);
		launch("");
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			primaryStage.setScene(BS.boardDisplayTest(viewerBoard));
			primaryStage.setTitle("BattleShip 2: More");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
			Platform.exit();
		}
	}

}
