package orchard.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Die {
	private DieFace currentFace;
	private final List<DieFace> faces;
	
	public Die() {
		this.currentFace = DieFace.RED;
		this.faces = facesInitialisation();
	}
	
	public List<DieFace> facesInitialisation() {
		List<DieFace> faces;
		faces = new ArrayList<>(5);
		faces.add(DieFace.RED);
		faces.add(DieFace.YELLOW);
		faces.add(DieFace.BLUE);
		faces.add(DieFace.GREEN);
		/*faces.add(DieFace.RAVEN);*/
		
		return faces;
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
	
	public DieFace rollDie(List<DieFace> faces) {
		Random random = new Random();
		return faces.get(random.nextInt(faces.size()));
	}
}
