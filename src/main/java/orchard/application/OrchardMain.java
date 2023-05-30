package orchard.application;

import javafx.application.Application;
import javafx.stage.Stage;
import orchard.controller.GameController;
import orchard.model.Board;
import orchard.view.OrchardView;

public class OrchardMain extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Board board = new Board();
        OrchardView gameView = new OrchardView(board);
        GameController.startGame(board, gameView);
        primaryStage.setScene(gameView.boardView().getGameScene());
        primaryStage.setTitle("Orchard");
        primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
