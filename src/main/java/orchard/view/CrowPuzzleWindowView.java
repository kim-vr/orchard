package orchard.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import orchard.model.Board;
import orchard.view.board.CrowView;

public class CrowPuzzleWindowView {
	private Scene crowScene;
	private BorderPane borderPaneCrow = new BorderPane();
	private Button quit = new Button("Go back");
	private CrowView crowView;
	private StackPane pile = new StackPane();
	private HBox pileAndPuzzle = new HBox();
	private ImageView imagePicked;
	
	public CrowPuzzleWindowView(Board board) {
		this.crowView = new CrowView(board);
		this.imagePicked = new ImageView(new Image("/puzzlePieces/flippedPuzzlePiece.png", 150, 150, true, true));
		this.imagePicked.setTranslateX(30);
		this.imagePicked.setTranslateY(-30);
		pileCreation();
		pileAndPuzzleCreation();
		borderPaneCrowCreation();
		setGameScene();
	}
	
	public void setImagePicked(Image image) {
		this.imagePicked.setImage(image);
	}
	
	public ImageView getImagePicked() {
		return this.imagePicked;
	}
	
	
	public CrowView getCrowView() {
		return this.crowView;
	}
	
	public void pileCreation() {
		this.pile.getChildren().add(new ImageView(new Image("/puzzlePieces/flippedPuzzlePiece.png", 150, 150, true, true)));
		this.pile.getChildren().add(this.imagePicked);
		this.pile.setPadding(new Insets(0, 0, 0, 200));
	}
	
	public void pileAndPuzzleCreation() {
		this.pileAndPuzzle.getChildren().addAll(this.crowView.getStackPaneCrow(), this.pile);
	}
	
	
	public static BackgroundImage getCrowBackground(Image image) {
		return new BackgroundImage(image,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
	}
	
	public void borderPaneCrowCreation() {
		BackgroundImage background = getCrowBackground(new Image("/crowBackground.png", 910, 682, false, true));
		this.borderPaneCrow.setBackground(new Background(background));
		this.borderPaneCrow.setCenter(this.pileAndPuzzle);
		this.borderPaneCrow.setBottom(quit);
	}
	
	public Button getQuitButton() {
		return this.quit;
	}
	
	public Scene getCrowScene(){
		return this.crowScene;
	}
	
	private void setGameScene() {
		this.crowScene = new Scene(this.borderPaneCrow, 910, 682);
	}
}
