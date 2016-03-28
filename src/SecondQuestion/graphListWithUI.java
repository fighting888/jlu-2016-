package src.SecondQuestion;

import java.util.ArrayList;
import java.util.List;

import src.UI.MainFrame;

public class graphListWithUI {
	
	public List<Vertex> getVertexs() {
		return vertexs;
	}

	public void setVertexs(List<Vertex> vertexs) {
		this.vertexs = vertexs;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public List<Vertex> vertexs = new ArrayList<>();
	
	public List<Edge> edges = new ArrayList<>();
	
	public List<Edge> highLightEdge = new ArrayList<>();
	
	public List<Vertex> highLightVertexs = new ArrayList<>();

	public void insertPost(Vertex vertex, Edge edge) {
		if (vertex.adjacent == null) {
			vertex.adjacent = edge;
			edge.link = null;
		} else {
			Edge pEdge = vertex.adjacent;
			while (pEdge.link != null) {
				pEdge = pEdge.link;
			}
			pEdge.link = edge;
			edge.link = null;
		}
	}
	
	public void printGraph() {
		Edge edge = new Edge();
		for(Vertex vertex : vertexs) {
			System.out.print("[" + vertex.VerName + "] ->> ");
			if (vertex.adjacent != null) {
				edge = vertex.adjacent;
				do {
					System.out.print("[" + edge.VerAdj + "]");
					if (edge.link != null) {
						System.out.print(" -> ");
					}
					edge = edge.link;
				} while (edge != null);
			}
			System.out.println();
		}
	}
	
	public void CriticalPath() {
		int graphsize = MainFrame.getGraphsize();
		int[] ve = new int[graphsize];
		int[] vl = new int[graphsize];
		int k;
		Edge edge = new Edge();
		for (int i = 0;i < graphsize; ++i) {
			ve[i] = 0;
		}
		
		for (int i = 0;i < graphsize - 1; ++i) {
			edge = vertexs.get(i).adjacent;
			while (edge != null) {
				k = edge.VerAdj;
				if (ve[i] + edge.cost > ve[k]) {
					ve[k] = ve[i] + edge.cost;
				}
				edge = edge.link;
			}
		}
		
		for (int i = 0;i < graphsize; ++i) {
			vl[i] = ve[graphsize-1];
		}
		for(int i = graphsize - 2;i >= 0; --i) {
			edge = vertexs.get(i).adjacent;
			while (edge != null) {
				k = edge.VerAdj;
				if (vl[k] - edge.cost < vl[i]) {
					vl[i] = vl[k] - edge.cost;
				}
				edge = edge.link;
			}
		}
		
		for (int i = 0;i < graphsize; ++i) {
			edge = vertexs.get(i).adjacent;
			while (edge != null) {
				k = edge.VerAdj;
				int e = ve[i];
				int l = vl[k] - edge.cost;
				if (l == e) {
					System.out.println("<" + i + "," + k + "> is Critical Activity");
					Edge pEdge = vertexs.get(i).adjacent;
					highLightVertexs.add(vertexs.get(i));
					highLightVertexs.add(vertexs.get(k));
					while (pEdge.VerAdj != k) {
						pEdge = pEdge.link;
					}
					if (pEdge != null) {
						highLightEdge.add(edge);
					}
				}
				edge = edge.link;
			}
		}
	}

	public boolean checkMinus(int[] weight) {
		for (int i : weight) {
			if (i <= 0) {
				return false;
			}
		}
		return true;
	}
	public boolean isClose(int GRAPHSIZE) {
		int[] weight = findWeight(GRAPHSIZE);		
		for (int i : weight) {
			if (i == 0) {
				Edge pEdge = vertexs.get(i).adjacent;
				
					--i;
				
				while (pEdge != null) {
					weight[pEdge.VerAdj]--;
					pEdge = pEdge.link;
				}
			}
		}
		
		for (int i : weight) {
			System.out.println(i + "  " + i);
		}
		if (checkMinus(weight)) {
			System.out.println("回路闭合");
			return true;
		} else {
			System.out.println("回路不闭合");
			return false;
		}
	}
	
	@SuppressWarnings("unused")
	public int[] findWeight(int GRAPHSIZE) {
		int[] count = new int[GRAPHSIZE];
		for (int c : count) {
			c = 0;
		}
		for (Vertex i : vertexs) {
			Edge pEdge = i.adjacent;
			while (pEdge != null) {
				++count[pEdge.VerAdj];
				pEdge = pEdge.link;
			}
		}
		return count;
	}
}
















