package orchard.view;

import javafx.scene.Scene;
import orchard.model.Board;
import orchard.view.board.GameWindowView;

public class OrchardView {
	private Scene currentScene;
	private final GameWindowView boardView;
	private final DieWindowView dieView;
	
	public OrchardView(Board board) {
		this.boardView = new GameWindowView(board);
		this.dieView = new DieWindowView(board);
		this.currentScene = this.boardView.getGameScene();
		//this.currentScene = this.dieView.getDieScene();
	}
	
	public void setCurrentScene(Scene scene) {
		this.currentScene = scene;
	}
	
	public Scene currentScene() {
		return this.currentScene;
	}
	
	public GameWindowView boardView() {
		return this.boardView;
	}
	
	public DieWindowView dieView() {
		return this.dieView;
	}
}
