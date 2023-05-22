package orchard.view.board;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import orchard.model.Board;
import orchard.model.Die;
import orchard.model.DieFace;

public class GameWindowView {
	private final Button startGameBtn = new Button("Commencer la partie");
	private Scene boardScene;
	private Image currentDie;
	private BorderPane borderPaneBoard;
	private BorderPane bottom;
	private Label nbRoundsLabel;
	
	
	public GameWindowView(Board board) {
		setImageOfCurrentFace(board.die());
		
		this.nbRoundsLabel = new Label();
		this.nbRoundsLabel.setPadding(new Insets(30, 0, 0, 0));
		
		setNbRoundsLabel(board);
		borderPaneBottomCreation();
		setBorderPane(board);
		setGameScene();
	}

	public void borderPaneBottomCreation() {
		this.bottom = new BorderPane();
		ImageView imageviewCurrentFace = new ImageView(this.currentDie);
		this.bottom.setPrefSize(910, 90);
		this.bottom.setRight(imageviewCurrentFace);
		this.bottom.setLeft(this.nbRoundsLabel);
		this.bottom.setCenter(this.startGameBtn);
		this.bottom.setPadding(new Insets(10 ,0 ,0 ,0));
		
	}
	
	public void setNbRoundsLabel(Board board) {
		this.nbRoundsLabel.setText("Nombre de tours : " + board.numberOfRounds());
	}
	
	public void setImageOfCurrentFace(Die die) {
		if (die.currentFace() == DieFace.RED) {
			this.currentDie = new Image("/redDie.png", 100, 100, true, true);
		}
		else if (die.currentFace() == DieFace.YELLOW) {
			this.currentDie = new Image("/yellowDie.png", 100, 100, true, true);
		}
		else if (die.currentFace() == DieFace.GREEN) {
			this.currentDie = new Image("/greenDie.png", 100, 100, true, true);
		}
		else {
			this.currentDie = new Image("/blueDie.png", 100, 100, true, true);
		}
	}
	
	public void updateImage() {
		this.bottom.setRight(new ImageView(this.currentDie));
		this.borderPaneBoard.setBottom(this.bottom);
	}
	
	public static BackgroundImage getGameBackground(Image image) {
		return new BackgroundImage(image,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
	}
	
	public Scene getGameScene(){
		return this.boardScene;
	}
	
	public void setGameScene() {
		this.boardScene = new Scene(this.borderPaneBoard, 910, 682);
	}
	
	public void setBorderPane(Board board){
		BoardView treesView;
		BackgroundImage background = getGameBackground(new Image("/gameBackground.png", 910, 682, false, true));
		this.borderPaneBoard = new BorderPane();
		treesView = new BoardView(board);
		
		this.borderPaneBoard.setBottom(this.bottom);
		this.borderPaneBoard.setBackground(new Background(background));
		this.borderPaneBoard.setCenter(treesView.getGridPaneTrees()); 
	}

	public Button getStartGameBtn() {
		return this.startGameBtn;
	}
    
}