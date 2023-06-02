package orchard.model;

import java.util.ArrayList;
import java.util.List;

public class Crow {
	private List<Piece> puzzlePileList = new ArrayList<>(9);
	private List<Piece> puzzleCrowList = new ArrayList<>(9);
	
	public Crow() {
		instanciatePuzzlePile();
	}
	
	public List<Piece> getPuzzlePileList(){
		return this.puzzlePileList;
	}
	
	public List<Piece> getPuzzleCrowList(){
		return this.puzzleCrowList;
	}
	
	public void addAPiece(Piece piece) {
		int i = 0;
		for (Piece puzzlePiece : this.puzzlePileList) {
			if (puzzlePiece == piece) {
					this.puzzlePileList.remove(i);
					this.puzzleCrowList.add(piece);
					i++;
			}
		}
	}
	
	public void instanciatePuzzlePile() {
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				this.puzzlePileList.add(new Piece(j, i));
			}
		}
	}
}
