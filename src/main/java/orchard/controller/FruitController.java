package orchard.controller;

import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FruitController implements EventHandler<MouseEvent>{
	
	private ImageView fruit;
	
	
	public FruitController(ImageView fruit) {
		this.fruit = fruit;
	}
	
	@Override
	public void handle(MouseEvent event) {
		this.fruit.setVisible(false);
	}
}
