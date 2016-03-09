package model;

public class Vertex {
	public int VerName;
	
	public Edge adjacent;
	
	public Vertex() {
		
	}
	
	public Vertex(int VerName) {
		this.VerName = VerName;
		this.adjacent = new Edge();
	}

	
}
