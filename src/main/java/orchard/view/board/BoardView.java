package orchard.view.board;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import orchard.model.Board;
import orchard.model.Tree;

public class BoardView {
	
	private GridPane gridPaneTrees;

	public BoardView(Board board) {
		gridPaneTreesCreation(board.trees());
	}
	
	public GridPane getGridPaneTrees() {
		return gridPaneTrees;
	}
	
		
	public void gridPaneTreesCreation(List<Tree> trees) {
		this.gridPaneTrees = new GridPane();
		int i=0;
		for (Tree tree : trees) {
			ImageView imageviewTree = new ImageView(new Image("/tree.png", 250, 250, true, true));
			GridPane fruits = TreeView.putFruitsOnTree(tree);
			this.gridPaneTrees.add(imageviewTree, i, 0);
			this.gridPaneTrees.add(fruits, i, 0);
			i++;
		}
		this.gridPaneTrees.setAlignment(Pos.BOTTOM_CENTER);
	}

}
