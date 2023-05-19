package orchard.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import orchard.model.Board;
import orchard.view.DieWindowView;
import orchard.view.GameWindowView;

public class GameController {
    
    public void game(Board board, DieWindowView dieFX) {
        System.out.println("Jeu lancé");
        rollDieButton(board, dieFX);
        board.getTree(board.die().currentFace().getAssociatedSymbol()).pickAFruit();
    }
    
    public void rollDieButton(Board board, DieWindowView dieFX) {
        dieFX.setGridPaneDie(board.die());
        Button btnRollDie = dieFX.getButton();
        System.out.println("Dé trouvé");
        btnRollDie.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                board.die().rollDie();
                System.out.println(board.die().currentFace());
                dieFX.setImageOfCurrentFace(board.die());
            }
        });
    }
    
    public void startGame(Board board, DieWindowView dieFX) {
        GameWindowView gameView = new GameWindowView();
        Button startBtn = gameView.getStartGameBtn();
        startBtn.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                game(board, dieFX);
            }
        });
    }
    
    public void gameOver(Board board) {
        if(board.allTreesEmpty()) {
            System.out.println("Jeu gagné !");
            //TODO
        }
    }

}