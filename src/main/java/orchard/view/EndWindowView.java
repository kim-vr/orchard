package orchard.view;

import java.io.InputStream;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import orchard.model.Board;

public class EndWindowView {
	//this.result.setFont(Font.font("Arial",FontWeight.BOLD, 20));
	Button leave = new Button("Leave");
	Button playAgain = new Button("Play again");
	Label result = new Label("");
	Label nbRounds = new Label("");
	GridPane gridPaneMenu;
	Scene endGameScene;
	
	public EndWindowView(Board board) {
		setLabelRounds(board);
		setGridPaneEndGame();
		setEndGameScene();
	}
	
	public void setLabelResult(boolean won) {
		InputStream fontStream = getClass().getResourceAsStream("/gameFont.ttf");
		Font customFont = Font.loadFont(fontStream, 50);
		this.result.setFont(customFont);
		this.result.setTextFill(Color.rgb(72, 64, 56));
		if (won) {
			this.result.setText("You won !!!");
		} else {
			this.result.setText("You lost !!!");
		}
	}
	
	public void setLabelRounds(Board board) {
		this.nbRounds.setText("This game lasted " + board.numberOfRounds() + " rounds");
	}
	
	
	
	public void setGridPaneEndGame() {
		this.gridPaneMenu = new GridPane();
		BackgroundImage background = GameWindowView.getGameBackground(new Image("/endGameBackground.png", 910, 682, false, true));
		this.gridPaneMenu.setBackground(new Background(background));
		this.gridPaneMenu.add(result, 0, 0);
		this.gridPaneMenu.add(nbRounds, 0, 1);
		this.gridPaneMenu.add(playAgain, 0, 2);
		this.gridPaneMenu.add(leave, 0, 3);
		this.gridPaneMenu.setAlignment(Pos.CENTER);
		GridPane.setHalignment(this.result, HPos.CENTER);
		GridPane.setHalignment(this.nbRounds, HPos.CENTER);
		GridPane.setHalignment(this.leave, HPos.CENTER);
		GridPane.setMargin(this.leave, new Insets(10, 0, 0, 0));
		GridPane.setHalignment(this.playAgain, HPos.CENTER);
		GridPane.setMargin(this.playAgain, new Insets(30, 0, 0, 0));
	}
	
	public void setEndGameScene() {
		this.endGameScene = new Scene(this.gridPaneMenu, 910, 682);
	}
	
	public Scene getEndGameScene() {
		return this.endGameScene;
	}
	
	public Button getButtonLeave() {
		return this.leave;
	}
	
	public Button getButtonPlayAgain() {
		return this.playAgain;
	}
}
