package orchard.controller;

import javafx.stage.Stage;
import orchard.model.Crow;
import orchard.view.CrowPuzzleWindowView;
import orchard.view.board.CrowView;

public class CrowController {
	private Crow crow;
	private CrowView crowView;
	private CrowPuzzleWindowView crowWindow;
	
	public void dieOnCrowControl(Stage primaryStage) {
		primaryStage.setScene(crowWindow.getCrowScene());
	}
	
	
}
