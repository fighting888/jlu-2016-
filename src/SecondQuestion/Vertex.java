package src.SecondQuestion;

public class Vertex {
	

	public int VerName;
	
	public Edge adjacent;
	
	private int x, y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Vertex() {
		
	}
	
	public Vertex(int VerName) {
		this.VerName = VerName;
		this.adjacent = new Edge();
	}

	
}
