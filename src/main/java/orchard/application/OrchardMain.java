package orchard.application;

import javafx.application.Application;
import javafx.stage.Stage;
import orchard.controller.GameController;
import orchard.model.Board;
import orchard.view.OrchardView;

public class OrchardMain extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GameController game = new GameController();
        game.startGame(primaryStage);
        primaryStage.setScene(game.gameView().boardView().getGameScene());
        primaryStage.setTitle("Orchard");
        primaryStage.setResizable(false);
        primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
