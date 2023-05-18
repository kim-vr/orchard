package orchard.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import orchard.model.Fruit;
import orchard.model.Tree;

public class TreeView {
	public static Image getFruitImage(Fruit fruit) {
		Image fruitImage;
		if (fruit == Fruit.APPLE) {
			fruitImage = new Image("/apple.png", 30, 30, true, true);
		}
		else if (fruit == Fruit.PEAR) {
			fruitImage = new Image("/pear.png", 30, 30, true, true);
		}
		else if (fruit == Fruit.CHERRY) {
			fruitImage = new Image("/cherry.png", 30, 30, true, true);
		}
		else {
			fruitImage = new Image("/plum.png", 30, 30, true, true);
		}
		return fruitImage;
	}
	
	public static GridPane putFruitsOnTree(Tree tree) {
		GridPane gridPaneFruits = new GridPane();
		for (int i = 0; i< tree.getNumberOfFruits()/2; i++) {
			for (int j = 0; j < tree.getNumberOfFruits() / (tree.getNumberOfFruits()/2); j++) {
				gridPaneFruits.add(new ImageView(getFruitImage(tree.getAssociatedFruit())), i, j);
			}
		}
		gridPaneFruits.setAlignment(Pos.TOP_CENTER);
		gridPaneFruits.setPadding(new Insets(35));
		return gridPaneFruits;
	}
}
