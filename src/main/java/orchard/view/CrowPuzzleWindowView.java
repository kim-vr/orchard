package orchard.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import orchard.view.board.CrowView;

public class CrowPuzzleWindowView {
	private Scene crowScene;
	private BorderPane borderPaneCrow = new BorderPane();
	private Button quit = new Button("Go back");
	private CrowView crow = new CrowView();
	
	public CrowPuzzleWindowView() {
		setGameScene();
	}
	
	
	public static BackgroundImage getCrowBackground(Image image) {
		return new BackgroundImage(image,
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          BackgroundSize.DEFAULT);
	}
	
	public void borderPaneCrowCreation() {
		this.borderPaneCrow.setBackground(new Background(getCrowBackground(new Image("/gameBackground.png"))));
		this.borderPaneCrow.setCenter(this.crow.getStackPaneCrow());
	}
	
	public Scene getCrowScene(){
		return this.crowScene;
	}
	
	private void setGameScene() {
		this.crowScene = new Scene(this.borderPaneCrow, 910, 682);
	}
}
