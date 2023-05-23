package orchard.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import orchard.model.Board;
import orchard.model.Die;
import orchard.model.Tree;
import orchard.view.DieWindowView;
import orchard.view.OrchardView;
import orchard.view.board.GameWindowView;

public class GameController {
    
	public static void game(Board board, OrchardView gameView, Stage stage) {
		if (gameOver(board) != true) {
			rollDieGame(board, gameView, stage);
			pickFruitGame(board, gameView, stage);
		} else {
			stage.close();
		}
	}
	
	public static void rollDieGame(Board board, OrchardView gameView, Stage stage) {
		Button btnRollDie = gameView.dieView().getButtonRoll();
		Button btnOk = gameView.dieView().getButtonOk();
		DieWindowView dieWindow = gameView.dieView();
		Die die = board.die();
		
		stage.setScene(gameView.dieView().getDieScene());
		
		btnRollDie.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				
				btnRollDie.setVisible(false);
				die.rollDie();
				dieWindow.setImageOfCurrentFace(die);
				dieWindow.updateGridPaneImage();
				btnOk.setVisible(true);
			}
		});
	}
	
	public static void pickFruitGame(Board board, OrchardView gameView, Stage stage) {
		GameWindowView boardWindow = gameView.boardView();
		DieWindowView dieWindow = gameView.dieView();
		Button btnOk = gameView.dieView().getButtonOk();
		Button btnRollDie = gameView.dieView().getButtonRoll();
		Button nextTurnBtn = boardWindow.getNextTurnBtn();
		Die die = board.die();
		Tree treeToPickFruitOn = board.getTree(die.currentFace().getAssociatedSymbol());
		
		btnOk.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				boardWindow.setImageOfCurrentFace(die);
				boardWindow.updateImage();
				stage.setScene(boardWindow.getGameScene());
				treeToPickFruitOn.pickAFruit();
			}
		});
		
		nextTurnBtn.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				btnOk.setVisible(false);
				btnRollDie.setVisible(true);
				stage.setScene(dieWindow.getDieScene());
				board.addARound();
				boardWindow.setNbRoundsLabel(board);
			}
		});
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
	
	public static boolean gameOver(Board board) {
		if(board.allTreesEmpty()) {
			System.out.println("Jeu gagné !");
			return true;
		}
		return false;
	}

}