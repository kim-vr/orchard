package orchard.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tree> trees;
    private Die die;
    private int numberOfRounds;
    
    public Board() {
        treesInitialisation();
        this.trees = trees();
        this.die = new Die();
        this.numberOfRounds = 0;
    }
    
    
    public List<Tree> trees(){
        return this.trees;
    }
    
    public Die die() {
        return this.die;
    }
    
    public int numberOfRounds() {
        return numberOfRounds;
    }
    
    public void treesInitialisation() {
        this.trees = new ArrayList<>();
        this.trees.add(new Tree(Fruit.CHERRY));
        this.trees.add(new Tree(Fruit.PEAR));
        this.trees.add(new Tree(Fruit.PLUM));
        this.trees.add(new Tree(Fruit.APPLE));
    }
    
    public Tree getTree(Fruit fruit) {
		for (Tree tree : this.trees) {
			if (tree.getAssociatedFruit() == fruit) {
				return tree;
			}
		}
		return trees.get(1);
	}
    
    public void addARound() {
        this.numberOfRounds += 1;
    }
    
    public void setDie(DieFace face) {
        this.die.setCurrentFace(face);
    }
    

    public boolean allTreesEmpty() {
        boolean treesEmpty = true;
        for(Tree tree : trees) {
            if (!tree.treeIsEmpty()) {
                treesEmpty = false;
            }
        }
        return treesEmpty;
    }
    
}