package orchard.view.board;

import java.util.ArrayList;
import java.util.List;

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
import orchard.model.Crow;
import orchard.model.Piece;

public class CrowView {
	private final ImageView imageEmptyCrow;
	private StackPane stackPaneCrow = new StackPane();
	private GridPane gridPanePuzzle = new GridPane();
	private final List<ImageView> listPiecesOfPuzzle = new ArrayList<>(9);
	//private final Crow crow;
	
	public CrowView() {
		this.imageEmptyCrow = new ImageView(new Image("/crowPuzzle.png", 200, 200, true, true));
		initializeListPiecesOfPuzzle();
	}
	
	public void initializeListPiecesOfPuzzle() {
		for (int i = 1; i<10; i++) {
			ImageView piece = new ImageView(new Image("/puzzlePieces/puzzlePiece" + i + ".png"));
			piece.setVisible(false);
			this.listPiecesOfPuzzle.add(piece);
		}
	}
	
	public void gridPanePuzzle(List<Piece> puzzlePieces) {
		int i = 0;
		for (Piece piece : puzzlePieces) {
			this.gridPanePuzzle.add(this.listPiecesOfPuzzle.get(i), piece.getCoordinateY(), piece.getCoordinateX());
			i++;
		}
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
		//gridPanePuzzle();
		this.stackPaneCrow.getChildren().addAll(this.imageEmptyCrow);
	}
	
	public StackPane getStackPaneCrow() {
		return this.stackPaneCrow;
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
