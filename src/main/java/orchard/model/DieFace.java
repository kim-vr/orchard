package orchard.model;

public enum DieFace {
	RED(Fruit.CHERRY),
	YELLOW(Fruit.PEAR),
	BLUE(Fruit.PLUM),
	GREEN(Fruit.APPLE);

	private Fruit associatedSymbol;

	DieFace(Fruit associatedSymbol) {
		this.associatedSymbol = associatedSymbol;
	}

	public Fruit getAssociatedSymbol() {
		return associatedSymbol;
	}
	
}
