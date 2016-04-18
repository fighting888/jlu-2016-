package src.SecondQuestion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
	
	@SuppressWarnings("unused")
	public boolean isClose(int n) {
		int[] count = new int[n];
		for (int c : count) {
			c = 0;
		}
		for (Vertex vertex : vertexs) {
			Edge pEdge = vertex.adjacent;
			while (pEdge != null) {
				count[pEdge.VerAdj]++;
				pEdge = pEdge.link;
			}
		}
		Stack<Integer> top = new Stack<>();
		top.add(-1);
		for (int i = 0;i < n; ++i) {
			if (count[i] == 0) {
				count[i] = top.peek();
				top.add(i);
			}
		}
		
		//topoOrder
		for (int i = 0;i < n; ++i) {
			if (top.peek() == -1) {
				System.out.println("��·�պ�");
				MainFrame.contentPanel.getDrawLabel().setText("��·�պ�");
				return true;
			} else {
				int j = top.peek();
				top.pop();
				Edge pEdge = vertexs.get(j).adjacent;
				while (pEdge != null) {
					int k = pEdge.VerAdj;
					count[k] = count[k] - 1;
					if (count[k] == 0) {
						count[k] = top.peek();
						top.add(k);
					}
					pEdge = pEdge.link;
				}
			}
		}
		return false;
	}
	
	public boolean isSelfClose(int n, int m) {
		Edge pEdge = vertexs.get(n).adjacent;
		Edge qEdge = vertexs.get(m).adjacent;
		while (pEdge != null) {
			if (m == pEdge.VerAdj) {
				MainFrame.contentPanel.getDrawLabel().setText("·���Ի�������ʧ��");
				return true;
			}
			pEdge = pEdge.link;
		}
		while (qEdge != null) {
			if (n == qEdge.VerAdj) {
				MainFrame.contentPanel.getDrawLabel().setText("·���Ի�������ʧ��");
				return true;
			}
			qEdge = qEdge.link;
		}
		return false;
	}
	
	public boolean isIsolate() {
		System.out.println("is isolate");
		for (Vertex vertex : vertexs) {
			if (inValue(vertex.VerName) == 0 && outValue(vertex.VerName) == 0) {
				MainFrame.contentPanel.getDrawLabel().setText("���ڹ����㣬�޷�����");
				return true;
			}
		}
		return false;
	}
	
	public int inValue(int x) {
		int count = 0;
		for (Vertex vertex : vertexs) {
			Edge pEdge = vertex.adjacent;
			while (pEdge != null) {
				if (pEdge.VerAdj == x) {
					count++;
				}
				pEdge = pEdge.link;
			}
		}
		System.out.println(x + "���" + count);
		return count;
	}
	
	public int outValue(int x) {
		int count = 0;
		Edge pEdge = vertexs.get(x).adjacent;
		while (pEdge != null) {
			count++;
			pEdge = pEdge.link;
		}
		System.out.println(x + "����" + count);
		return count;
	}
}
















