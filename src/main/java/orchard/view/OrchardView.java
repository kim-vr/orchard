package orchard.view;

import orchard.model.Board;
import orchard.view.board.GameWindowView;

public class OrchardView {
	private final GameWindowView boardView;
	
	public OrchardView(Board board) {
		this.boardView = new GameWindowView(board);
	}
	
	public GameWindowView boardView() {
		return this.boardView;
	}
	
}
