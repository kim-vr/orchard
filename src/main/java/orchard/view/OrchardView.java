package orchard.view;

import orchard.model.Board;

public class OrchardView {
	private final GameWindowView boardView;
	private final EndWindowView endView;
	private final CrowPuzzleWindowView crowView;
	
	public OrchardView(Board board) {
		this.crowView = new CrowPuzzleWindowView(board);
		this.boardView = new GameWindowView(board, this.crowView);
		this.endView = new EndWindowView(board);
	}
	
	public GameWindowView boardView() {
		return this.boardView;
	}
	
	public EndWindowView endView() {
		return this.endView;
	}
	
	public CrowPuzzleWindowView crowView() {
		return this.crowView;
	}
	
}
