package src.SecondQuestion;

public class Edge {

	public int getStx() {
		return stx;
	}

	public void setStx(int stx) {
		this.stx = stx;
	}

	public int getSty() {
		return sty;
	}

	public void setSty(int sty) {
		this.sty = sty;
	}

	public int getEnx() {
		return enx;
	}

	public void setEnx(int enx) {
		this.enx = enx;
	}

	public int getEny() {
		return eny;
	}

	public void setEny(int eny) {
		this.eny = eny;
	}

	public int VerAdj;
	
	private int stx, sty, enx, eny;
	
	public int cost;
	
	public Edge link;
	
	
	
	public Edge() {
		// TODO Auto-generated constructor stub
	}
	
	public Edge(int VerAdj, int cost) {
		// TODO Auto-generated constructor stub
		this.VerAdj = VerAdj;
		this.cost = cost;
		
	}
}
