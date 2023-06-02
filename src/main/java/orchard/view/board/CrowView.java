package orchard.view.board;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import orchard.model.Board;
import orchard.model.Crow;
import orchard.model.Piece;

public class CrowView {
	private final ImageView imageEmptyCrow;
	private StackPane stackPaneCrow = new StackPane();
	private GridPane gridPanePuzzle = new GridPane();
	private final List<ImageView> listPiecesOfPuzzle = new ArrayList<>(9);
	private final List<Piece> puzzlePieces;
	
	public CrowView(Board board) {
		this.puzzlePieces = board.crow().getPuzzlePileList();
		this.imageEmptyCrow = new ImageView(new Image("/crowPuzzle.png", 450, 450, true, true));
		initializeListPiecesOfPuzzle();
		stackPaneCrowCreation();
		gridPanePuzzleCreation(this.puzzlePieces);
	}
	
	public void initializeListPiecesOfPuzzle() {
		for (int i = 1; i<10; i++) {
			ImageView piece = new ImageView(new Image("/puzzlePieces/puzzlePiece" + i + ".png", 150, 150, true, true));
			piece.setVisible(false);
			this.listPiecesOfPuzzle.add(piece);
		}
	}
	
	public void gridPanePuzzleCreation(List<Piece> puzzlePieces) {
		int i = 0;
		for (Piece piece : puzzlePieces) {
			this.gridPanePuzzle.add(this.listPiecesOfPuzzle.get(i), piece.getCoordinateX(), piece.getCoordinateY());
			i++;
		}
		this.gridPanePuzzle.setAlignment(Pos.CENTER);
		this.gridPanePuzzle.setBorder(
				  new Border(
				    new BorderStroke(
				      Color.RED,
				      BorderStrokeStyle.SOLID,
				      new CornerRadii(5),
				      new BorderWidths(10)
				    )
				  )
				);
	}
	
	public void stackPaneCrowCreation() {
		this.stackPaneCrow.getChildren().addAll(this.imageEmptyCrow, this.gridPanePuzzle);
	}
	
	public StackPane getStackPaneCrow() {
		this.gridPanePuzzle.setBorder(
				  new Border(
				    new BorderStroke(
				      Color.RED,
				      BorderStrokeStyle.SOLID,
				      new CornerRadii(5),
				      new BorderWidths(10)
				    )
				  )
				);
		return this.stackPaneCrow;
	}
	
	public List<ImageView> getListPiecesOfPuzzle(){
		return this.listPiecesOfPuzzle;
	}
	
	public GridPane getGridPanePuzzle(){
		return this.gridPanePuzzle;
	}
	
	public void addAPiece(ImageView piece) {
		int i = 0;
		for (ImageView puzzlePiece : this.listPiecesOfPuzzle) {
			if (puzzlePiece == piece) {
				this.listPiecesOfPuzzle.get(i).setVisible(true);
			}
		}
	}
}
