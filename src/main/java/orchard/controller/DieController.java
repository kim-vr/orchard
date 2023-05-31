package orchard.controller;

import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import orchard.model.Board;
import orchard.model.Die;
import orchard.model.Tree;
import orchard.view.OrchardView;
import orchard.view.board.DieView;

public class DieController {
	private Die die;
	private DieView dieView;
	
	public DieController(Board board, OrchardView gameView) {
		this.die = board.die();
		this.dieView = gameView.boardView().getDieView();
	}

	public void rollDieControl(Board board, OrchardView gameView) {
		Label error = dieView.getError();
		error.setVisible(false);
		die.rollDie();
		dieView.setImageOfCurrentFace(die);
		GridPane.setHalignment(dieView.getImageOfCurrentFace(), HPos.CENTER);
		dieView.updateGridPaneImage();
	}
}
