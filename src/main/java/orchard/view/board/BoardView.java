package orchard.view.board;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import orchard.model.Basket;
import orchard.model.Board;
import orchard.model.Fruit;
import orchard.model.Tree;

public class BoardView {
	
	private GridPane gridPaneTrees = new GridPane();
	private GridPane gridPaneBaskets = new GridPane();
	private AnchorPane placeTreesBaskets = new AnchorPane();
	private List<TreeView> listTreeView;
	private List<BasketView> listBasketView;

	public BoardView(Board board) {
		this.listTreeView = new ArrayList<>(4);
		this.listBasketView = new ArrayList<>(4);
		//anchorPaneCreation(board.baskets(), board.trees());
		gridPaneTreesCreation(board.trees());
		gridPaneBasketsCreation(board.baskets());
	}
	
	public GridPane getGridPaneTrees() {
		return gridPaneTrees;
	}
	
	public GridPane getGridPaneBaskets() {
		return gridPaneBaskets;
	}
	
	public TreeView getTree(Fruit associatedFruit) {
		for (TreeView tree : this.listTreeView) {
			if (tree.getAssociatedFruitType() == associatedFruit) {
				return tree;
			}
		}
		return null;
	}
	
	public BasketView getBasket(Fruit associatedFruit) {
		for (BasketView basket : this.listBasketView) {
			if (basket.getAssociatedFruit() == associatedFruit) {
				return basket;
			}
		}
		return null;
	}
	
	public void gridPaneBasketsCreation(List<Basket> baskets) {
		int count=0;
		for (Basket basket : baskets) {
			BasketView basketView = new BasketView(basket);
			this.listBasketView.add(basketView);
			this.gridPaneBaskets.add(basketView.getGridPaneBasket(), count, 0);
			basketView.getGridPaneBasket().setBorder(
					  new Border(
					    new BorderStroke(
					      Color.PURPLE,
					      BorderStrokeStyle.SOLID,
					      new CornerRadii(5),
					      new BorderWidths(10)
					    )
					  )
					);
			count = count + 1;
		}
		this.gridPaneBaskets.setAlignment(Pos.BOTTOM_CENTER);
		this.gridPaneBaskets.setBorder(
				  new Border(
				    new BorderStroke(
				      Color.BLUE,
				      BorderStrokeStyle.SOLID,
				      new CornerRadii(5),
				      new BorderWidths(10)
				    )
				  )
				);
	}
	
		
	public void gridPaneTreesCreation(List<Tree> trees) {
		int count=0;
		for (Tree tree : trees) {
			ImageView imageviewTree = new ImageView(new Image("/tree.png", 250, 250, true, true));
			TreeView treeView = new TreeView(tree);
			GridPane fruits = treeView.getGridPaneFruits();
			this.gridPaneTrees.add(imageviewTree, count, 0);
			this.gridPaneTrees.add(fruits, count, 0);
			count = count + 1;
			this.listTreeView.add(treeView);
		}
		this.gridPaneTrees.setAlignment(Pos.BOTTOM_CENTER);
		this.gridPaneTrees.setBorder(
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
	
//	public void anchorPaneCreation(List<Basket> baskets, List<Tree> trees) {
//		gridPaneTreesCreation(trees);
//		gridPaneBasketsCreation(baskets);
//		this.gridPaneBaskets.setScaleX(100);
//		this.placeTreesBaskets.getChildren().add(this.gridPaneTrees);
//		this.placeTreesBaskets.getChildren().add(this.gridPaneBaskets);
//		//this.placeTreesBaskets.setAlignment(Pos.BOTTOM_CENTER);
//		StackPane.setAlignment(gridPaneBaskets, Pos.BOTTOM_RIGHT);
//		this.placeTreesBaskets.setMinHeight(400);
//		this.placeTreesBaskets.setBorder(
//				  new Border(
//				    new BorderStroke(
//				      Color.WHITE,
//				      BorderStrokeStyle.SOLID,
//				      new CornerRadii(5),
//				      new BorderWidths(10)
//				    )
//				  )
//				);
//	}
//	
//	public AnchorPane stackTreesBaskets() {
//		return this.placeTreesBaskets;
//	}

}
