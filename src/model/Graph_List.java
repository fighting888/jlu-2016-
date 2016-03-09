package model;

import java.util.Scanner;

import org.omg.PortableInterceptor.IORInterceptor_3_0;


public class Graph_List {

	private static Vertex[] Head;
	
	private int graphsize;
	
	public static Scanner scanner;
	
	public static void main(String[] args) {
		Graph_List graph_List = new Graph_List();
		graph_List.init();
		graph_List.print();
		graph_List.CriticalPath();
//		scanner = new Scanner(System.in);
//		int e;
//		e = scanner.nextInt();
//		System.out.println(e);
	}
	
	public void CriticalPath() {
		int[] ve = new int[graphsize];
		int[] vl = new int[graphsize];
		int k;
		Edge edge = new Edge();
		for (int i = 0;i < graphsize; ++i) {
			ve[i] = 0;
		}
		//计算最早发生时间
		for (int i = 0;i < graphsize - 1; ++i) {
			edge = Head[i].adjacent;
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
			edge = Head[i].adjacent;
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
			edge = Head[i].adjacent;
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
	
	public int init() {
		int e, from, to, weight;
		System.out.println("Input graph size");
		scanner = new Scanner(System.in);
		graphsize = scanner.nextInt();	
		if (graphsize < 0) {
			return 0;
		}
		Head = new Vertex[graphsize];
		for (int i = 0;i < graphsize; ++i) {
			Head[i] = new Vertex();
			Head[i].VerName = i;
		}
		System.out.println("Input edge size");
		e = scanner.nextInt();
		if (e > graphsize * (graphsize - 1)) {
			return 0;
		}
		for (int i = 0; i < e; i++) {
			from = scanner.nextInt();
			to = scanner.nextInt();
			weight = scanner.nextInt();
			if (!checkNumber(from)||!checkNumber(to)||weight < 0) {
				return 0;
			}
			Edge pEdge = new Edge(to, weight);
			
			Edge qEdge = Head[from].adjacent;
			
			if (qEdge == null) {
				Head[from].adjacent = pEdge;
			} else {
				while (qEdge.link != null) {
					qEdge = qEdge.link;					
				}
				qEdge.link = pEdge;
			}
		}
		if (!checkRepeat()) {
			System.out.println("Input Error, Try Again");
			return 0;
		}
		return 1;
		
	}
	
	public void print() {
		Edge edge = new Edge();
		for(int i = 0;i < graphsize; i++) {
			System.out.print("[" + Head[i].VerName + "] ->> ");
			if (Head[i].adjacent != null) {
				edge = Head[i].adjacent;
				do {
					System.out.print("[" + edge.VerAdj + "]");
					if (edge.link != null) {
						System.out.print(" -> ");
					}
					edge = edge.link;
				} while (edge != null);
				System.out.println();
			}
		}
		
	}
	
	public boolean checkNumber(int number) {
		return (number >= 0 && number < graphsize) ? true : false;
	}
	
	public boolean checkRepeat() {
		int count = 1;
		int[] list = new int[100];
		Edge edge = new Edge();
		for (Vertex i : Head) {
			list[0] = i.VerName;
			edge = i.adjacent;
			for (int j = 1; edge != null; j++) {
				list[j] = edge.VerAdj;
				count++;
				edge = edge.link;
			}
			if (!repeat(list, count)) {
				return false;
			}
			count = 1;
		}
		return true;
	}
	
	public boolean repeat(int[] list, int count) {
		for (int i = 0;i < count - 1; ++i) {
			for (int j = i + 1;j < count; ++j) {
				if (list[i] == list[j]) {
					return false;
				}
			}
		}
		return true;
	}
//	public static int[] visited;
//	public boolean checkLoop(int v, int[] visited) {
//		visited = new int[graphsize];
//		for (int i : visited) {
//			visited[i] = 0;
//		}
//		visited[v] = 1; //表示访问过了
//		int w = getFirstNeighbour(v);
//		while (w != -1) {
//			if (visited[w] != 1) {
//				checkLoop(w, visited);
//			} 
//			w = getNextNeighbour(v, w);
//		}
//		return false;
//	}
	
	
	
	public int getFirstNeighbour(int v) {
		if (v == -1) {
			return -1;
		}
		Edge edge = Head[v].adjacent;
		if (edge != null) {
			return edge.VerAdj;
		} else {
			return -1;
		}
	}
	
	public int getNextNeighbour(int v1, int v2) {
		if (v1 != -1 && v2 != -1) {
			Edge edge = Head[v1].adjacent;
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
	
	

