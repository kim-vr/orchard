package orchard.controller;

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
		this.treeView.pickAFruit(tree);
	}
}
