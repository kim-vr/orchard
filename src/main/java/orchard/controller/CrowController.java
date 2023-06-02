package orchard.controller;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import orchard.model.Board;
import orchard.model.Crow;
import orchard.model.Piece;
import orchard.view.CrowPuzzleWindowView;
import orchard.view.OrchardView;
import orchard.view.board.CrowView;

public class CrowController {
	private Crow crow;
	private CrowView crowView;
	private CrowPuzzleWindowView crowWindow;
	private List<ImageView> listPiecesNotVisible;
	private ImageView randomPieceImageView;
	
	public void dieOnCrowControl(Stage primaryStage, OrchardView gameView, Board board) {
		this.crow = board.crow();
		this.crowWindow = gameView.crowView();
		this.crowView = gameView.crowView().getCrowView();
		this.listPiecesNotVisible = crowView.getListImageView();
		primaryStage.setScene(this.crowWindow.getCrowScene());
		pickAPiece();
	}
	
	public void pickAPiece() {
		Random random = new Random();
		Image randomPieceImage = this.listPiecesNotVisible.get(random.nextInt(this.listPiecesNotVisible.size())).getImage();
		int j = 0;
		for (ImageView image : this.crowView.getListImageView()) {
			if (image.getImage() == randomPieceImage) {
				this.crowWindow.getImagePicked().setImage(randomPieceImage);
				this.randomPieceImageView = this.crowWindow.getImagePicked();
				this.crowView.getListImageView().get(j).setVisible(true);
			}
			j++;
		}

			
			for (int i = 0; i<this.listPiecesNotVisible.size(); i++) {
				if (this.randomPieceImageView == listPiecesNotVisible.get(i)){
					this.listPiecesNotVisible.remove(i);
					this.crow.addAPiece(this.crow.getPuzzlePileList().get(i));
				}
			}
	}
	
	public void buttonsCrow(Stage primaryStage, OrchardView gameView) {
		this.crowWindow = gameView.crowView();
		this.crowView = gameView.crowView().getCrowView();
		Button goBackButton = this.crowWindow.getQuitButton();
		Button puzzleButton = this.crowView.getPuzzleButton();
		goBackButton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				primaryStage.setScene(gameView.boardView().getGameScene());
			}
		});
		
		puzzleButton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				primaryStage.setScene(gameView.crowView().getCrowScene());
			}
		});
	}
	
}
