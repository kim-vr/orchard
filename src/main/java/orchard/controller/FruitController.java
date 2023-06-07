package orchard.controller;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import orchard.model.Tree;
import orchard.view.board.TreeView;

public class FruitController implements EventHandler<MouseEvent>{
	
	private ImageView fruit;
	private Tree tree;
	private TreeView treeView;
	
	
	public FruitController(ImageView fruit, Tree tree, TreeView treeView) {
		this.fruit = fruit;
		this.tree = tree;
		this.treeView = treeView;
	}
	
	@Override
	public void handle(MouseEvent event) {
		this.fruit.setVisible(false);
		makeFruitsNotClickable(this.tree);
	}
	
	public void makeFruitsNotClickable(Tree tree) {
		ImageView fruit;
		for (int i=0; i<this.tree.getNumberOfFruits(); i++) {
			fruit = (ImageView) this.treeView.getGridPaneFruits().getChildren().get(i);
			fruit.removeEventFilter(MouseEvent.MOUSE_CLICKED, new FruitController(fruit, this.tree, this.treeView));
		}
	}
}
