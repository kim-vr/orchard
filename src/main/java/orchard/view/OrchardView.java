package orchard.view;

import javafx.scene.Scene;
import orchard.model.Board;

public class OrchardView {
	private Scene currentScene;
	private final GameWindowView boardView;
	private final DieWindowView dieView;
	
	public OrchardView(Board board) {
		this.boardView = new GameWindowView();
		this.dieView = new DieWindowView(board);
		this.currentScene = this.boardView.getGameScene();
	}
	
	public void setCurrentScene(Scene scene) {
		this.currentScene = scene;
	}
	
	public Scene currentScene() {
		return this.currentScene;
	}
	
	public GameWindowView boardScene() {
		return this.boardView;
	}
	
	public DieWindowView dieScene() {
		return this.dieView;
	}
}
