package orchard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import orchard.model.Board;
import orchard.view.CrowPuzzleWindowView;
import orchard.view.OrchardView;
import orchard.view.board.CrowView;

public class CrowController {
	private CrowView crowView;
	private CrowPuzzleWindowView crowWindow;
	private List<ImageView> listPiecesNotVisible;
	
	public void dieOnCrowControl(Stage primaryStage, OrchardView gameView, Board board) {
		this.crowWindow = gameView.crowView();
		this.crowView = gameView.crowView().getCrowView();
		this.listPiecesNotVisible = crowView.getListPiecesOfPuzzle();
		Button goBackButton = crowWindow.getQuitButton();
		primaryStage.setScene(this.crowWindow.getCrowScene());
		pickAPiece();
		
		goBackButton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				primaryStage.setScene(gameView.boardView().getGameScene());
			}
		});
	}
	
	public void pickAPiece() {
		Random random = new Random();
		ImageView randomPieceImage = this.listPiecesNotVisible.get(random.nextInt(this.listPiecesNotVisible.size()));
		
		if (!randomPieceImage.isVisible()) {
			randomPieceImage.setVisible(true);
			
			for (int i = 0; i<this.listPiecesNotVisible.size(); i++) {
				if (randomPieceImage == listPiecesNotVisible.get(i)){
					this.listPiecesNotVisible.remove(i);
				}
			}
		}
	}
	
}
