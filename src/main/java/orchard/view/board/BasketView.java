package orchard.view.board;

import java.util.List;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import orchard.model.Basket;
import orchard.model.Fruit;

public class BasketView {
	private final ImageView basketImage;
	private Label nbFruitsInBasket;
	private final Fruit associatedFruit;
	private GridPane paneBasket = new GridPane();
	private VBox pileOfFruits = new VBox();
	
	public BasketView(Basket basket) {
		this.basketImage = new ImageView(new Image("/basket.png", 100, 100, true, true));
		this.nbFruitsInBasket = new Label("empty basket");
		this.associatedFruit = basket.getAssociatedFruit();
		//putFruitsInBasket();
		gridPaneBasketCreation();
	}
	
	public void gridPaneBasketCreation() {
		this.paneBasket.add(this.pileOfFruits, 0, 0);
		this.paneBasket.add(this.basketImage, 0, 0);
		this.paneBasket.add(this.nbFruitsInBasket, 0, 0);
		this.paneBasket.setPadding(new Insets(0, 100, 0, 0));
		GridPane.setHalignment(nbFruitsInBasket, HPos.CENTER);
		GridPane.setHalignment(basketImage, HPos.LEFT);
	}
	
	public GridPane getGridPaneBasket() {
		return this.paneBasket;
	}
	
	public void setNbFruits(Basket basket) {
		this.nbFruitsInBasket.setText(basket.getNumberOfFruits() + " fruits");
	}
	
	public Image getFruitImage(Fruit fruit) {
		Image fruitImage;
		fruitImage = new Image("/fruits/" + fruit.getFruit() + ".png", 40, 40, true, true);
		return fruitImage;
	}
	
	public Fruit getAssociatedFruit() {
		return this.associatedFruit;
	}
	
	public void putFruitsInBasket() {
		for (int row = 0; row < 4; row++) {
			HBox hboxRow = new HBox();
			for (int column = 0; column < (4-row); column++) {
				hboxRow.getChildren().add(new ImageView(getFruitImage(this.associatedFruit)));
			}
			this.pileOfFruits.getChildren().add(hboxRow);
		}
	}
}
