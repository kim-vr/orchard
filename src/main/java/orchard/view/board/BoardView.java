package orchard.view.board;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import orchard.model.Board;
import orchard.model.Fruit;
import orchard.model.Tree;

public class BoardView {
	
	private GridPane gridPaneTrees;
	private List<TreeView> listTreeView;

	public BoardView(Board board) {
		this.listTreeView = new ArrayList<>(4);
		gridPaneTreesCreation(board.trees());
	}
	
	public GridPane getGridPaneTrees() {
		return gridPaneTrees;
	}
	
	public TreeView getTree(Fruit associatedFruit) {
		for (TreeView tree : this.listTreeView) {
			if (tree.getAssociatedFruitType() == associatedFruit) {
				return tree;
			}
		}
		return null;
	}
	
		
	public void gridPaneTreesCreation(List<Tree> trees) {
		this.gridPaneTrees = new GridPane();
		int i=0;
		for (Tree tree : trees) {
			ImageView imageviewTree = new ImageView(new Image("/tree.png", 250, 250, true, true));
			TreeView treeView = new TreeView(tree);
			GridPane fruits = treeView.getGridPaneFruits();
			this.gridPaneTrees.add(imageviewTree, i, 0);
			this.gridPaneTrees.add(fruits, i, 0);
			i = i + 1;
			this.listTreeView.add(treeView);
		}
		this.gridPaneTrees.setAlignment(Pos.BOTTOM_CENTER);
	}

}
