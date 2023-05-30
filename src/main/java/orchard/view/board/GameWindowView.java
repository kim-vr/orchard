package orchard.view.board;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import orchard.model.Board;

public class GameWindowView {
	private final Button startGameBtn = new Button("Start the game");
	private final Button nextTurnBtn = new Button("Next turn");
	private Scene boardScene;
	private BorderPane borderPaneBoard;
	private BorderPane bottom;
	private Label nbRoundsLabel;
	private VBox vboxCenter;
	private DieView dieView;
	private BoardView boardView;

	public GameWindowView(Board board) {
		this.nbRoundsLabel = new Label("Number of rounds : 0");
		this.nbRoundsLabel.setPadding(new Insets(30, 0, 0, 0));
		borderPaneBottomCreation();
		vboxCenterCreation(board);
		setBorderPaneGame();
		setGameScene();
	}

	private void borderPaneBottomCreation() {
		this.bottom = new BorderPane();
		this.bottom.setPrefSize(910, 90);
		this.bottom.setLeft(this.nbRoundsLabel);
		this.bottom.setCenter(this.startGameBtn);
		this.bottom.setPadding(new Insets(10 ,0 ,0 ,0));
	}
	
	private void vboxCenterCreation(Board board) {
		this.dieView = new DieView(board);
		this.boardView = new BoardView(board);
		GridPane boardPane = boardView.getGridPaneTrees();
		GridPane diePane = this.dieView.getGridPaneDie();
		diePane.setAlignment(Pos.TOP_LEFT);
		diePane.setPadding(new Insets(50, 0, 0, 50));
		boardPane.setPadding(new Insets(150, 0, 0, 0));
		this.vboxCenter = new VBox();
		this.vboxCenter.getChildren().addAll(diePane, boardPane);
		
	}
	
	public void replaceButtonByNextTurnButton() {
		this.bottom.setCenter(nextTurnBtn);
	}
	
	public void setNbRoundsLabel(Board board) {
		this.nbRoundsLabel.setText("Number of rounds : " + board.numberOfRounds());
		this.bottom.setLeft(this.nbRoundsLabel);
	}
	
	public Label getNbRoundsLabel() {
		return this.nbRoundsLabel;
	}
	
	public DieView getDieView() {
		return this.dieView;
	}
	
	public BoardView getBoardView() {
		return this.boardView;
	}
	
	
	public static BackgroundImage getGameBackground(Image image) {
		return new BackgroundImage(image,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
	}
	
	public Scene getGameScene(){
		return this.boardScene;
	}
	
	private void setGameScene() {
		this.boardScene = new Scene(this.borderPaneBoard, 910, 682);
	}
	
	private void setBorderPaneGame(){
		BackgroundImage background = getGameBackground(new Image("/gameBackground.png", 910, 682, false, true));
		this.borderPaneBoard = new BorderPane();
		
		this.borderPaneBoard.setBottom(this.bottom);
		this.borderPaneBoard.setBackground(new Background(background));
		this.borderPaneBoard.setCenter(this.vboxCenter); 
	}

	public Button getStartGameBtn() {
		return this.startGameBtn;
	}
	
	public Button getNextTurnBtn() {
		return this.nextTurnBtn;
	}
    
}