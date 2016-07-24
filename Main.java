import java.util.*;

class Main {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		/* Number of vertices in Graph */
		int N = sc.nextInt();
		/* Number of edges in Graph */
		int M = sc.nextInt();

		List<Edge> edges = new LinkedList<>();
		for (int i = 0; i < M; i++) {
			Edge edge = new Edge();
			edge.u = sc.nextInt() - 1;
			edge.v = sc.nextInt() - 1;
			edges.add(edge);
		}

		Graph graph = new Graph(N, edges);
		List<List<Vertex>> scc = StronglyConnectedComponents.compute(graph);

		for (int i = 1; i <= scc.size(); i++) {
			List<Vertex> list = scc.get(i - 1);
			System.out.print("Component " + i + ": ");
			for (Vertex v : list)
				System.out.print(v.toString());
			System.out.println("");
		}
	}
}
