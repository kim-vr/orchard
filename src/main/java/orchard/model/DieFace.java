package orchard.model;

public enum DieFace {
	RED(Fruit.CHERRY, "red"),
	YELLOW(Fruit.PEAR, "yellow"),
	BLUE(Fruit.PLUM, "blue"),
	GREEN(Fruit.APPLE, "green"),
	CROW(null, "crow");

	private Fruit associatedSymbol;
	private String name;

	DieFace(Fruit associatedSymbol, String name) {
		this.associatedSymbol = associatedSymbol;
		this.name = name;
	}

	public Fruit getAssociatedSymbol() {
		return associatedSymbol;
	}
	
	public String getName() {
		return name;
	}
}
