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
		//计算最早发生时间
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
		//计算最迟发生时间
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
		//求各个活动的最早开始时间和最迟开始时间，一样的就是关键路径
		for (int i = 0;i < graphsize; ++i) {
			edge = vertexs.get(i).adjacent;
			while (edge != null) {
				k = edge.VerAdj;
				int e = ve[i];
				int l = vl[k] - edge.cost;
				if (l == e) {
					System.out.println("<" + i + "," + k + "> is Critical Activity");
				}
				edge = edge.link;
			}
		}
	}

}
