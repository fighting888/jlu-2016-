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

	public int[] visited;
	public boolean isClose(int v, int[] visited) {
		visited = new int[MainFrame.getGraphsize()];
		for (int i : visited) {
			visited[i] = 0;
		}
		visited[v] = 1; //表示访问过了
		int w = getFirstNeighbour(v);
		while (w != -1) {
			if (visited[w] != 1) {
				isClose(w, visited);
			} else if (visited[w] == 1) {
				return false;
			}
			w = getNextNeighbour(v, w);
		}
		return true;
	}
	
	public int getFirstNeighbour(int v) {
		if (v == -1) {
			return -1;
		}
		Edge edge = vertexs.get(v).adjacent;
		if (edge != null) {
			return edge.VerAdj;
		} else {
			return -1;
		}
	}
	
	public int getNextNeighbour(int v1, int v2) {
		if (v1 != -1 && v2 != -1) {
			Edge edge = vertexs.get(v2).adjacent;
			while (edge.VerAdj != v2 && edge != null) {
				edge = edge.link;
			}
			if (edge == null) {
				return -1;
			}
			edge = edge.link;
			if (edge == null) {
				return -1;
			}
			return edge.VerAdj;
		}
		return -1;
	}
}