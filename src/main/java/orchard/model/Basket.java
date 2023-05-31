package orchard.model;

public class Basket {

	private final Fruit associatedFruit;
    private int numberOfFruits;
    
    public Basket(Fruit associatedFruit) {
        this.associatedFruit = associatedFruit;
        this.numberOfFruits = 0;
    }
    
    public Fruit getAssociatedFruit() {
        return associatedFruit;
    }

    public int getNumberOfFruits() {
        return numberOfFruits;
    }
    
    public void addAFruit() {
        this.numberOfFruits = this.numberOfFruits + 1;
    }
    
    public boolean basketIsEmpty() {
        return numberOfFruits == 0;
    }
}
