package orchard.view.board;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import orchard.controller.FruitController;
import orchard.model.Fruit;
import orchard.model.Tree;

public class TreeView {
	private Fruit associatedFruitType;
	private GridPane gridPaneFruits;
	
	public TreeView(Tree tree) {
		putFruitsOnTree(tree);
		this.associatedFruitType = tree.getAssociatedFruit();
	}
	
	public GridPane getGridPaneFruits() {
		return gridPaneFruits;
	}
	
	public Image getFruitImage(Fruit fruit) {
		Image fruitImage;
		fruitImage = new Image("/fruits/" + fruit.getFruit() + ".png", 30, 30, true, true);
		return fruitImage;
	}
	
	public void putFruitsOnTree(Tree tree) {
		this.gridPaneFruits = new GridPane();
		for (int column = 0; column < (tree.getNumberOfFruits()/2); column++) {
			for (int line = 0; line < tree.getNumberOfFruits() / (tree.getNumberOfFruits()/2); line++) {
				ImageView fruit = new ImageView(getFruitImage(tree.getAssociatedFruit()));
				this.gridPaneFruits.add(fruit, column, line);
			}
		}
		this.gridPaneFruits.setAlignment(Pos.TOP_CENTER);
		this.gridPaneFruits.setPadding(new Insets(35));
	}

	public Fruit getAssociatedFruitType() {
		return associatedFruitType;
	}
}
