package orchard.model;

public enum Fruit {
	    CHERRY("cherry"),
	    PEAR("pear"),
	    PLUM("plum"),
	    APPLE("apple");
	    
	    private String fruit;

	    private Fruit(String fruit) {
	        this.fruit = fruit;
	    }
	    
	    public String getFruit() {
	        return this.fruit;
	    }
	   
}
