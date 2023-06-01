package orchard.view.board;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import orchard.model.Board;
import orchard.model.Die;

public class DieView {
	private GridPane gridPaneDie;
	private ImageView imageCurrentFace;
	private final Button rollTheDieBtn = new Button("Roll the die !");
	private final Button goBackBtn = new Button("Go back");
	private Label error = new Label("");
	
	public DieView(Board board) {
		setImageOfCurrentFace(board.die());
		setGridPaneDie();
	}
	
	public Button getButtonRoll() {
		return this.rollTheDieBtn;
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
		this.gridPaneDie.add(this.imageCurrentFace, 0, 0);
		this.gridPaneDie.add(this.rollTheDieBtn, 0, 1);
		this.gridPaneDie.add(this.error, 0, 2);
		this.gridPaneDie.setAlignment(Pos.CENTER);
		
		this.goBackBtn.setVisible(false);
		GridPane.setHalignment(this.rollTheDieBtn, HPos.CENTER);
		GridPane.setHalignment(this.error, HPos.CENTER);
		GridPane.setHalignment(this.imageCurrentFace, HPos.CENTER);
	}
	
	public GridPane getGridPaneDie() {
		return this.gridPaneDie;
	}
	
	
}
