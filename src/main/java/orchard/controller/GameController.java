package orchard.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import orchard.model.Board;
import orchard.model.Die;
import orchard.model.Tree;
import orchard.view.OrchardView;
import orchard.view.board.DieView;
import orchard.view.board.GameWindowView;

public class GameController {
    
	public static void game(Board board, OrchardView gameView, Stage stage) {
		rollDieGame(board, gameView, stage);
	}
	
	public static void rollDieGame(Board board, OrchardView gameView, Stage stage) {
		DieView dieView = gameView.boardView().getDieView();
		Button btnRollDie = dieView.getButtonRoll();
		Die die = board.die();
		Label error = dieView.getError();
		
		btnRollDie.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				Tree treeToPickFruitOn = board.getTree(die.currentFace().getAssociatedSymbol());
				
				die.rollDie();
				dieView.setImageOfCurrentFace(die);
				dieView.updateGridPaneImage();
				if (!treeToPickFruitOn.treeIsEmpty()) {
					pickFruitGame(board, gameView, treeToPickFruitOn);
				} else error.setText("Empty tree, roll the die again !");
			}
		});
	}
	
	public static void pickFruitGame(Board board, OrchardView gameView, Tree tree) {
		GameWindowView boardWindow = gameView.boardView();
		tree.pickAFruit();
		boardWindow.getBoardView().getTree(tree.getAssociatedFruit()).pickAFruit(tree);
		board.addARound();
		boardWindow.setNbRoundsLabel(board);
	}
	
	public static void startGame(Board board, OrchardView gameView, Stage stage) {
		GameWindowView boardWindow = gameView.boardView();
		Button startBtn = boardWindow.getStartGameBtn();
		startBtn.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				startBtn.setVisible(false);
				boardWindow.replaceButtonByNextTurnButton();
				game(board, gameView, stage);
			}
		});
	}
	
	public static void gameOver(Board board) {
		if(board.allTreesEmpty()) {
			System.out.println("You won !");
		}
	}

}