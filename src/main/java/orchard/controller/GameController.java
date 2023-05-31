package orchard.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import orchard.model.Board;
import orchard.model.Tree;
import orchard.view.GameWindowView;
import orchard.view.OrchardView;
import orchard.view.board.DieView;

public class GameController {
	private Board board;
	private OrchardView gameView;
	
	public GameController() {
		this.board = new Board();
		gameView = new OrchardView(this.board);
	}
	
	public OrchardView gameView() {
		return this.gameView;
	}
	
	public Board board() {
		return this.board;
	}
    
	public void game(Stage primaryStage) {
		DieController dieController = new DieController(this.board, this.gameView);
		TreeController treeController = new TreeController();
		DieView dieView = this.gameView.boardView().getDieView();
		
		if (!this.board.allTreesEmpty()) {
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
						error.setText("Empty tree !");
					}
					else {
						treeController.setTree(treeToPickFruitOn);
						treeController.pickFruitControl(board, gameView);
					}
					if (board.allTreesEmpty()) {
						gameOver(primaryStage);
					} else {
						board.addARound();
						gameView.boardView().setNbRoundsLabel(board);
					}
				}	
			});
		}
	}
	
	public void startGame(Stage primaryStage) {
		GameWindowView boardWindow = this.gameView.boardView();
		Button startBtn = boardWindow.getStartGameBtn();
		startBtn.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				startBtn.setVisible(false);
				boardWindow.replaceButtonByNextTurnButton();
				game(primaryStage);
			}
		});
	}
	
	public void gameOver(Stage primaryStage) {
		this.gameView.endView().setLabelResult(true);
		this.gameView.endView().setLabelRounds(board);
		primaryStage.setScene(this.gameView.endView().getEndGameScene());
		
		Button playAgainButton = this.gameView.endView().getButtonPlayAgain();
		Button leaveButton = this.gameView.endView().getButtonLeave();
		
		playAgainButton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				reinitialiseGame();
				primaryStage.setScene(gameView.boardView().getGameScene());
				startGame(primaryStage);
			}
		});
		
		leaveButton.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			
			@Override
			public void handle(MouseEvent event) {
				primaryStage.close();
			}
		});
	}
		
	public void reinitialiseGame() {
		this.board = new Board();
		this.gameView = new OrchardView(board);
	}

}