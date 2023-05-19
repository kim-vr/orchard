package orchard.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import orchard.model.Die;

public class GameWindowView {
    private final Button startGameBtn = new Button("Commencer la partie");

    public BorderPane borderPaneBottomCreation(Die die, DieWindowView dieFX) {
        BorderPane bp = new BorderPane();
        ImageView imageviewCurrentFace = new ImageView(dieFX.getImageOfCurrentFace(die));
        bp.setPrefSize(910, 90);
        bp.setRight(imageviewCurrentFace);
        bp.setCenter(this.startGameBtn);
        bp.setPadding(new Insets(10 ,0 ,0 ,0));
        
        return bp;
        
    }
    
    public static BackgroundImage getGameBackground(Image image) {
        return new BackgroundImage(image,
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                  BackgroundSize.DEFAULT);
    }
    
}