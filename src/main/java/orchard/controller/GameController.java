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
		rollDieGame(board, gameView, stage);
		pickFruitGame(board, gameView, stage);
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
		Button btnOk = gameView.dieView().getButtonOk();
		GameWindowView boardWindow = gameView.boardView();
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
	}
	
	public static void startGame(Board board, OrchardView gameView, Stage stage) {
		Button startBtn = gameView.boardView().getStartGameBtn();
		startBtn.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				startBtn.setVisible(false);
				game(board, gameView, stage);
			}
		});
	}
	
	public void gameOver(Board board) {
		if(board.allTreesEmpty()) {
			System.out.println("Jeu gagné !");
			//TODO
		}
	}

}