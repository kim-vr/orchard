package orchard.view.board;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import orchard.model.Fruit;
import orchard.model.Tree;

public class TreeView {
	private List<Image> associatedFruitList;
	private Fruit associatedFruitType;
	private GridPane gridPaneFruits;
	
	public TreeView(Tree tree) {
		putFruitsOnTree(tree);
		this.associatedFruitType = tree.getAssociatedFruit();
	}
	
	public List<Image> getAssociatedFruitList() {
		return associatedFruitList;
	}
	
	public GridPane getGridPaneFruits() {
		return gridPaneFruits;
	}
	
	public static Image getFruitImage(Fruit fruit) {
		Image fruitImage;
		fruitImage = new Image("/" + fruit.getFruit() + ".png", 30, 30, true, true);
		return fruitImage;
	}
	
	public void pickAFruit(Tree tree) {
		int nbFruits = tree.getNumberOfFruits();
		int row;
		int column;
		//to get the coordinates of the fruit we want to pick
		if (tree.getNumberOfFruits() > 5) {
			row = 1;
			column = (nbFruits-5)-1;
		} else {
			row = 0;
			column = nbFruits-1;
		}
		getNodeByCoordinate(row, column).setVisible(false);
	}
	
	public Node getNodeByCoordinate(Integer row, Integer column) {
	    for (Node fruit : this.gridPaneFruits.getChildren()) {
	        if(GridPane.getRowIndex(fruit).equals(row) && GridPane.getColumnIndex(fruit).equals(column)) {
	            return fruit;
	        }
	    }
	    return null;
	}
	
	public void putFruitsOnTree(Tree tree) {
		this.associatedFruitList = new ArrayList<>(tree.getNumberOfFruits());
		this.gridPaneFruits = new GridPane();
		for (int column = 0; column< (tree.getNumberOfFruits()/2); column++) {
			for (int line = 0; line < tree.getNumberOfFruits() / (tree.getNumberOfFruits()/2); line++) {
				this.gridPaneFruits.add(new ImageView(getFruitImage(tree.getAssociatedFruit())), column, line);
				this.associatedFruitList.add(getFruitImage(tree.getAssociatedFruit()));
			}
		}
		this.gridPaneFruits.setAlignment(Pos.TOP_CENTER);
		this.gridPaneFruits.setPadding(new Insets(35));
	}

	public Fruit getAssociatedFruitType() {
		return associatedFruitType;
	}
}
