package orchard.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import orchard.model.Board;
import orchard.view.board.CrowView;

public class CrowPuzzleWindowView {
	private Scene crowScene;
	private BorderPane borderPaneCrow = new BorderPane();
	private Button quit = new Button("Go back");
	private CrowView crowView;
	
	public CrowPuzzleWindowView(Board board) {
		this.crowView = new CrowView(board);
		borderPaneCrowCreation();
		setGameScene();
	}
	
	public CrowView getCrowView() {
		return this.crowView;
	}
	
	
	public static BackgroundImage getCrowBackground(Image image) {
		return new BackgroundImage(image,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
	}
	
	public void borderPaneCrowCreation() {
		BackgroundImage background = getCrowBackground(new Image("/crowBackground.png", 910, 682, false, true));
		this.borderPaneCrow.setBackground(new Background(background));
		this.borderPaneCrow.setCenter(this.crowView.getStackPaneCrow());
		this.crowView.getStackPaneCrow().setBorder(
				  new Border(
				    new BorderStroke(
				      Color.WHITE,
				      BorderStrokeStyle.SOLID,
				      new CornerRadii(5),
				      new BorderWidths(10)
				    )
				  )
				);
		this.borderPaneCrow.setBottom(quit);
	}
	
	public Button getQuitButton() {
		return this.quit;
	}
	
	public Scene getCrowScene(){
		return this.crowScene;
	}
	
	private void setGameScene() {
		this.crowScene = new Scene(this.borderPaneCrow, 910, 682);
	}
}
