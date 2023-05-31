package orchard.controller;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import orchard.model.Board;
import orchard.model.Die;
import orchard.model.Tree;
import orchard.view.GameWindowView;
import orchard.view.OrchardView;
import orchard.view.board.DieView;

public class GameController {
    
	public static void game(Board board, OrchardView gameView) {
		DieController dieController = new DieController(board, gameView);
		TreeController treeController = new TreeController();
		DieView dieView = gameView.boardView().getDieView();
		
		if (!board.allTreesEmpty()) {
			Button btnRollDie = dieView.getButtonRoll();
			Label error = dieView.getError();
			
			btnRollDie.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
				
				@Override
				public void handle(MouseEvent event) {
					dieController.rollDieControl(board, gameView);
					
					Tree treeToPickFruitOn = board.getTree(board.die().currentFace().getAssociatedSymbol());
					boolean treeEmpty = treeToPickFruitOn.treeIsEmpty();
					
					if (treeEmpty) {
						error.setVisible(treeEmpty);
						error.setText("Empty tree, roll the die again !");
					}
					else {
						treeController.setTree(treeToPickFruitOn);
						treeController.pickFruitControl(board, gameView);
					}
					if (board.allTreesEmpty()) {
						gameOver();
					} else {
						board.addARound();
						gameView.boardView().setNbRoundsLabel(board);
					}
				}	
			});
		}
	}
	
	public static void startGame(Board board, OrchardView gameView) {
		GameWindowView boardWindow = gameView.boardView();
		Button startBtn = boardWindow.getStartGameBtn();
		startBtn.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				startBtn.setVisible(false);
				boardWindow.replaceButtonByNextTurnButton();
				game(board, gameView);
			}
		});
	}
	
	public static void gameOver() {
		System.out.println("You won !");
	}

}