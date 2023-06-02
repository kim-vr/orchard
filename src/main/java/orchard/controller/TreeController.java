package orchard.controller;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import orchard.model.Board;
import orchard.model.Tree;
import orchard.view.GameWindowView;
import orchard.view.OrchardView;
import orchard.view.board.TreeView;

public class TreeController {
	private TreeView treeView;
	private Tree tree;

	
	public void setTree(Tree tree) {
		this.tree = tree;
	}
	
	public void pickFruitControl(Board board, OrchardView gameView) {
		GameWindowView boardWindow = gameView.boardView();
		this.treeView = boardWindow.getBoardView().getTree(tree.getAssociatedFruit());
		this.tree.pickAFruit();
		pickAFruit(tree);
	}
	
	public void pickAFruit(Tree tree) {
		int nbFruits = tree.getNumberOfFruits();
		int row;
		int column;
		//to get the coordinates of the fruit we want to pick
		column = nbFruits/2;
		row = nbFruits%2;
		getNodeByCoordinate(row, column).setVisible(false);
	}
	
	public Node getNodeByCoordinate(Integer row, Integer column) {
	    for (Node fruit : treeView.getGridPaneFruits().getChildren()) {
	        if(GridPane.getRowIndex(fruit).equals(row) && GridPane.getColumnIndex(fruit).equals(column)) {
	            return fruit;
	        }
	    }
	    return null;
	}
}
