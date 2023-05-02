package orchad.model;

public enum Fruit {
	    CHERRY("urlCherry"),
	    PEAR("urlPear"),
	    PLUM("urlPlum"),
	    APPLE("urlApple");
	    
	    private String fruitUrl;

	    private Fruit(String fruitUrl) {
	        this.fruitUrl = fruitUrl;
	    }
	    
	    public String getFruitUrl() {
	        return this.fruitUrl;
	    }
	   
}
