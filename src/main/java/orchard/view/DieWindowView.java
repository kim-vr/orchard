package orchard.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import orchard.model.Board;
import orchard.model.Die;
import orchard.model.DieFace;

public class DieWindowView {
	private GridPane gridPaneDie;
	private Image imageCurrentFace;
	private final Button rollTheDieBtn = new Button("Roll the die !");
	private Scene dieScene;
	private final Button okBtn = new Button("ok");
	
	public DieWindowView(Board board) {
		setImageOfCurrentFace(board.die());
		setGridPaneDie();
		setDieScene();
	}
	
	public Button getButtonRoll() {
		return this.rollTheDieBtn;
	}
	
	public Button getButtonOk() {
		return this.okBtn;
	}
	
	public Image getImageOfCurrentFace() {
		return this.imageCurrentFace;
	}
	
	public void setImageOfCurrentFace(Die die) {
		if (die.currentFace() == DieFace.RED) {
			this.imageCurrentFace = new Image("/redDie.png", 100, 100, true, true);
		}
		else if (die.currentFace() == DieFace.YELLOW) {
			this.imageCurrentFace = new Image("/yellowDie.png", 100, 100, true, true);
		}
		else if (die.currentFace() == DieFace.GREEN) {
			this.imageCurrentFace = new Image("/greenDie.png", 100, 100, true, true);
		}
		else {
			this.imageCurrentFace = new Image("/blueDie.png", 100, 100, true, true);
		}
	}
	public void updateGridPaneImage() {
		this.gridPaneDie.add(new ImageView(this.imageCurrentFace), 0, 0);
	}
	
	public void setGridPaneDie() {
		this.gridPaneDie = new GridPane();
		this.gridPaneDie.add(new ImageView(this.imageCurrentFace), 0, 0);
		this.gridPaneDie.add(this.rollTheDieBtn, 0, 1);
		this.gridPaneDie.add(this.okBtn, 0, 1);
		this.okBtn.setVisible(false);
		this.gridPaneDie.setAlignment(Pos.CENTER);
	}
	public GridPane getGridPaneDie() {
		return this.gridPaneDie;
	}
	
	public Scene getDieScene() {
		return this.dieScene;
	}
	
	public void setDieScene() {
		this.dieScene = new Scene(this.gridPaneDie, 400, 400);
	}
	
	
}
