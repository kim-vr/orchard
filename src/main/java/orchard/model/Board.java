package orchard.model;

import java.util.List;

public class Board {
    private List<Tree> trees;
    private Die die;
    private int numberOfRounds;
    
    public Board() {
        this.trees = trees();
        this.die = new Die();
        this.numberOfRounds = 0;
    }
    
    public List<Tree> trees(){
        return this.trees;
    }
    
}