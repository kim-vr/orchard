package orchard.controller;

import orchard.model.Basket;
import orchard.model.Board;
import orchard.view.GameWindowView;
import orchard.view.OrchardView;
import orchard.view.board.BasketView;

public class BasketController {
	private Basket basket;
	private BasketView basketView;
	
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	
	public void addFruitControl(Board board, OrchardView gameView) {
		GameWindowView boardWindow = gameView.boardView();
		this.basketView = boardWindow.getBoardView().getBasket(basket.getAssociatedFruit());
		this.basket.addAFruit();
		this.basketView.setNbFruits(basket);;
	}
}
