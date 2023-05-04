package orchard.model;

public enum Fruit {
	    CHERRY("Cherry"),
	    PEAR("Pear"),
	    PLUM("Plum"),
	    APPLE("Apple");
	    
	    private String fruit;

	    private Fruit(String fruit) {
	        this.fruit = fruit;
	    }
	    
	    public String getFruit() {
	        return this.fruit;
	    }
	   
}
