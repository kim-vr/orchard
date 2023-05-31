package orchard.view;

import orchard.model.Board;

public class OrchardView {
	private final GameWindowView boardView;
	
	public OrchardView(Board board) {
		this.boardView = new GameWindowView(board);
	}
	
	public GameWindowView boardView() {
		return this.boardView;
	}
	
}
