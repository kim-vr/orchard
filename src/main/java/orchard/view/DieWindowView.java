package orchard.view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import orchard.model.Board;
import orchard.model.Die;
import orchard.model.DieFace;
import orchard.view.board.GameWindowView;

public class DieWindowView {
	private GridPane gridPaneDie;
	private ImageView imageCurrentFace;
	private final Button rollTheDieBtn = new Button("Roll the die !");
	private Scene dieScene;
	private final Button goBackBtn = new Button("Go back");
	private Label error = new Label("");
	
	public DieWindowView(Board board) {
		setImageOfCurrentFace(board.die());
		setGridPaneDie();
		setDieScene();
	}
	
	public Button getButtonRoll() {
		return this.rollTheDieBtn;
	}
	
	public Button getButtonOk() {
		return this.goBackBtn;
	}
	
	public ImageView getImageOfCurrentFace() {
		return this.imageCurrentFace;
	}
	
	public Label getError() {
		return error;
	}

	public void setError(String message) {
		this.error.setText(message);
	}
	
	public void setImageOfCurrentFace(Die die) {
		Image imageFace = new Image("/dieFaces/" + die.currentFace().getName() + "Die.png", 100, 100, true, true);
		this.imageCurrentFace = new ImageView(imageFace);
	}
	
	public void updateGridPaneImage() {
		this.gridPaneDie.add(this.imageCurrentFace, 0, 0);
	}
	
	public void setGridPaneDie() {
		this.gridPaneDie = new GridPane();
		BackgroundImage background = GameWindowView.getGameBackground(new Image("/dieBackground.png", 910, 682, false, true));
		this.gridPaneDie.setBackground(new Background(background));
		this.gridPaneDie.add(this.imageCurrentFace, 0, 0);
		this.gridPaneDie.add(this.rollTheDieBtn, 0, 1);
		this.gridPaneDie.add(this.goBackBtn, 0, 1);
		this.gridPaneDie.add(this.error, 0, 2);
		this.gridPaneDie.setAlignment(Pos.CENTER);
		
		this.goBackBtn.setVisible(false);
		GridPane.setHalignment(this.rollTheDieBtn, HPos.CENTER);
		GridPane.setHalignment(this.goBackBtn, HPos.CENTER);
		GridPane.setHalignment(this.error, HPos.CENTER);
		GridPane.setHalignment(this.imageCurrentFace, HPos.CENTER);
	}
	
	public GridPane getGridPaneDie() {
		return this.gridPaneDie;
	}
	
	public Scene getDieScene() {
		return this.dieScene;
	}
	
	public void setDieScene() {
		this.dieScene = new Scene(this.gridPaneDie, 910, 682);
	}
	
	
}
