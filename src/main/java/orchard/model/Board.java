package orchard.model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Tree> trees;
    private Die die;
    private int numberOfRounds;
    private List<Basket> baskets;
    private Crow crow;
    
    public Board() {
        treesInitialisation();
        basketsInitialisation();
        this.trees = trees();
        this.die = new Die();
        this.numberOfRounds = 0;
        this.crow = new Crow();
    }
    
    
    public List<Tree> trees(){
        return this.trees;
    }
    
    public List<Basket> baskets(){
    	return this.baskets;
    }
    
    public Die die() {
        return this.die;
    }
    
    public int numberOfRounds() {
        return numberOfRounds;
    }
    
    public Crow crow() {
        return crow;
    }
    
    public void treesInitialisation() {
        this.trees = new ArrayList<>(4);
        this.trees.add(new Tree(Fruit.CHERRY));
        this.trees.add(new Tree(Fruit.PEAR));
        this.trees.add(new Tree(Fruit.PLUM));
        this.trees.add(new Tree(Fruit.APPLE));
    }
    
    public void basketsInitialisation() {
        this.baskets = new ArrayList<>(4);
        this.baskets.add(new Basket(Fruit.CHERRY));
        this.baskets.add(new Basket(Fruit.PEAR));
        this.baskets.add(new Basket(Fruit.PLUM));
        this.baskets.add(new Basket(Fruit.APPLE));
    }
    
    public Tree getTree(Fruit fruit) {
		for (Tree tree : this.trees) {
			if (tree.getAssociatedFruit() == fruit) {
				return tree;
			}
		}
		return trees.get(1);
	}
    
    public Basket getBasket(Fruit fruit) {
		for (Basket basket : this.baskets) {
			if (basket.getAssociatedFruit() == fruit) {
				return basket;
			}
		}
		return baskets.get(1);
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