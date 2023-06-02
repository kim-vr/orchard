package orchard.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import orchard.model.Crow;
import orchard.view.CrowPuzzleWindowView;
import orchard.view.OrchardView;
import orchard.view.board.CrowView;

public class CrowController {
	private Crow crow;
	private CrowView crowView;
	private CrowPuzzleWindowView crowWindow;
	
	public void dieOnCrowControl(Stage primaryStage, OrchardView gameView) {
		this.crowWindow = gameView.crowView();
		Button goBackButton = crowWindow.getQuitButton();
		primaryStage.setScene(this.crowWindow.getCrowScene());
		
		goBackButton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				primaryStage.setScene(gameView.boardView().getGameScene());
			}
		});
	}
	
	
}
