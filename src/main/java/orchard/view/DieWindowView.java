package orchard.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import orchard.model.Die;
import orchard.model.DieFace;

public class DieWindowView {
	private Scene dieWindow;
	private GridPane gridPaneDie;
	private Image imageCurrentFace;
	private Button rollTheDieBtn;
	
	public Button getButton() {
		return this.rollTheDieBtn;
	}
	
	public Image getImageOfCurrentFace(Die die) {
		setImageOfCurrentFace(die);
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
}
