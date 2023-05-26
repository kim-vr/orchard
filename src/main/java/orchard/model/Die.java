package orchard.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Die {
	private DieFace currentFace;
	private List<DieFace> faces;
	
	public Die() {
		facesInitialisation();
		this.currentFace = DieFace.RED;
		this.faces = faces();
	}
	
	public void facesInitialisation() {
		this.faces = new ArrayList<>(Arrays.asList(DieFace.values()));
	}
	
	public DieFace currentFace() {
		return this.currentFace;
	}
	
	public List<DieFace> faces() {
		return this.faces;
	}
	
	public void setCurrentFace(DieFace face) {
		this.currentFace = face;
	}
	
	public void rollDie() {
		Random random = new Random();
		this.currentFace = this.faces.get(random.nextInt(this.faces.size()));
	}
}
