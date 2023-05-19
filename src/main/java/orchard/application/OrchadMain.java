package orchard.application;

import javafx.application.Application;
import javafx.stage.Stage;
import orchard.controller.GameController;
import orchard.model.Board;
import orchard.view.DieWindowView;

public class OrchadMain extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Board board = new Board();
		DieWindowView die = new DieWindowView(board);
		GameController gameManagement = new GameController();
		
		gameManagement.game(board, die);
        primaryStage.setTitle("orchard");
        primaryStage.setScene(die.getDieWindow());
        primaryStage.show();
        
		
	}

	public static void main(String[] args) {
		launch(args);

	}

}
