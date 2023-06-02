package orchard.view.board;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import orchard.model.Board;
import orchard.model.Crow;
import orchard.model.Piece;

public class CrowView {
	private final ImageView imageEmptyCrow;
	private StackPane stackPaneCrow = new StackPane();
	private GridPane gridPanePuzzle = new GridPane();
	private final List<Image> listPiecesOfPuzzle = new ArrayList<>(9);
	private final List<Piece> puzzlePieces;
	private final List<ImageView> imageViewList = new ArrayList<>(9);
	private GridPane onMainWindow = new GridPane();
	private final Button puzzle = new Button("Go to puzzle");
	
	public CrowView(Board board) {
		this.puzzlePieces = board.crow().getPuzzlePileList();
		this.imageEmptyCrow = new ImageView(new Image("/crowPuzzle.png", 450, 450, true, true));
		initializeListPiecesOfPuzzle();
		initializeListImageView();
		stackPaneCrowCreation();
		gridPanePuzzleCreation(this.puzzlePieces);
		onMainWindowCreation();
	}
	

	public void initializeListPiecesOfPuzzle() {
		for (int i = 1; i<10; i++) {
			Image piece = new Image("/puzzlePieces/puzzlePiece" + i + ".png", 150, 150, true, true);
			this.listPiecesOfPuzzle.add(piece);
		}
	}
	
	public void initializeListImageView() {
		for (Image piece : this.listPiecesOfPuzzle) {
			this.imageViewList.add(new ImageView(piece));
		}
	}
	
	public void onMainWindowCreation() {
		this.onMainWindow.add(new ImageView(new Image("/crow.png", 200, 200, true, true)), 0, 0);
		this.onMainWindow.add(this.puzzle, 1, 0);
		this.onMainWindow.setPadding(new Insets(10, 0, 0, 250));
	}
	
	public GridPane getOnMainWindow() {
		return this.onMainWindow;
	}
	
	public Button getPuzzleButton() {
		return this.puzzle;
	}
	
	public void gridPanePuzzleCreation(List<Piece> puzzlePieces) {
		int i = 0;
		for (Piece piece : puzzlePieces) {
			this.gridPanePuzzle.add(this.imageViewList.get(i), piece.getCoordinateX(), piece.getCoordinateY());
			i++;
		}
		this.gridPanePuzzle.setAlignment(Pos.CENTER);
	}
	
	public void stackPaneCrowCreation() {
		this.stackPaneCrow.getChildren().addAll(this.imageEmptyCrow, this.gridPanePuzzle);
	}
	
	public StackPane getStackPaneCrow() {
		return this.stackPaneCrow;
	}
	
	public List<Image> getListPiecesOfPuzzle(){
		return this.listPiecesOfPuzzle;
	}
	
	public List<ImageView> getListImageView(){
		return this.imageViewList;
	}
	
	public GridPane getGridPanePuzzle(){
		return this.gridPanePuzzle;
	}
	
	public void addAPiece(ImageView piece) {
		int i = 0;
		for (ImageView puzzlePiece : this.imageViewList) {
			if (puzzlePiece == piece) {
				this.imageViewList.get(i).setVisible(true);
			}
		}
	}
}
