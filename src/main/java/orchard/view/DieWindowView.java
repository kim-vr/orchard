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
	private Scene dieWindow;
	private GridPane gridPaneDie;
	private Image imageCurrentFace;
	private Button rollTheDieBtn;
	
	public DieWindowView(Board board) {
		setGridPaneDie(board.die());
		setImageOfCurrentFace(board.die());
		this.gridPaneDie = getGridPaneDie();
		this.imageCurrentFace = getImageOfCurrentFace(board.die());
		this.rollTheDieBtn = getButton();
		this.dieWindow = getDieWindow();
	}
	
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
	public void setGridPaneDie(Die die) {
		this.gridPaneDie = new GridPane();
		this.rollTheDieBtn = new Button("Roll the die !");
		this.gridPaneDie.add(new ImageView(getImageOfCurrentFace(die)), 0, 0);
		this.gridPaneDie.add(this.rollTheDieBtn, 0, 1);
		this.gridPaneDie.setAlignment(Pos.CENTER);
	}
	public GridPane getGridPaneDie() {
		return this.gridPaneDie;
	}
	
	public Scene getDieWindow() {
		this.dieWindow = new Scene(this.gridPaneDie, 400, 400);
		return this.dieWindow;
	}
}
