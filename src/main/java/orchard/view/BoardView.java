package orchard.view;

import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import orchard.model.Tree;

public class BoardView {
	
	public static GridPane gridPaneTreesCreation(List<Tree> trees) {
		GridPane gp = new GridPane();
		int i=0;
		for (Tree tree : trees) {
			ImageView imageviewTree = new ImageView(new Image("/tree.png", 250, 250, true, true));
			GridPane fruits = TreeView.putFruitsOnTree(tree);
			gp.add(imageviewTree, i, 0);
			gp.add(fruits, i, 0);
			i++;
		}
		gp.setAlignment(Pos.BOTTOM_CENTER);
		return gp;
	}
}
