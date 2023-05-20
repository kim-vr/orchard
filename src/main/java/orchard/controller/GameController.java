package orchard.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import orchard.model.Board;
import orchard.view.OrchardView;

public class GameController {
    
	public static void game(Board board, OrchardView gameView, Stage stage) {
		stage.setScene(gameView.dieView().getDieScene());
		rollDieButton(board, gameView, stage);
	}
	
	public static void rollDieButton(Board board, OrchardView gameView, Stage stage) {
		Button btnRollDie = gameView.dieView().getButton();
		System.out.println("Dé trouvé");
		btnRollDie.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				board.die().rollDie();
				System.out.println(board.die().currentFace());
				gameView.dieView().setImageOfCurrentFace(board.die());
				gameView.dieView().updateGridPaneImage();
//				try {
//					TimeUnit.SECONDS.sleep(6);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
				gameView.boardView().setImageOfCurrentFace(board.die());
				gameView.boardView().updateImage();
				stage.setScene(gameView.boardView().getGameScene());
				board.getTree(board.die().currentFace().getAssociatedSymbol()).pickAFruit();
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