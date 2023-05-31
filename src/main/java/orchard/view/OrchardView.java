package orchard.view;

import orchard.model.Board;

public class OrchardView {
	private final GameWindowView boardView;
	private final EndWindowView endView;
	
	public OrchardView(Board board) {
		this.boardView = new GameWindowView(board);
		this.endView = new EndWindowView(board);
	}
	
	public GameWindowView boardView() {
		return this.boardView;
	}
	
	public EndWindowView endView() {
		return this.endView;
	}
	
}
