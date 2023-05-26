package orchard.model;

public class Tree {
	
    private final Fruit associatedFruit;
    private int numberOfFruits;
    
    public Tree(Fruit associatedFruit) {
        this.associatedFruit = associatedFruit;
        this.numberOfFruits = 10;
    }
    
    public Fruit getAssociatedFruit() {
        return associatedFruit;
    }

    public int getNumberOfFruits() {
        return numberOfFruits;
    }
    
    public void pickAFruit() {
        this.numberOfFruits = this.numberOfFruits - 1;
    }
    
    public boolean treeIsEmpty() {
        return numberOfFruits == 0;
    }
    
}