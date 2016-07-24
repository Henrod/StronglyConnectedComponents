import java.util.*;

class Main {

	public static int N;

	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		List<Edge> edges = new LinkedList<>();
		while (sc.hasNext()) {
			Edge edge = new Edge();
			edge.u = sc.nextInt() - 1;
			edge.v = sc.nextInt() - 1;
			edges.add(edge);
		}

		Graph graph = new Graph(N, edges);
		List<List<Vertex>> scc = StronglyConnectedComponents.compute(graph);
		Collections.sort(scc, new Comparator<List<Vertex>>() {
			public int compare(List<Vertex> list_1, List<Vertex> list_2) {
				return list_2.size() - list_1.size();
			}
		});

		for (int i = 0; i < 5; i++) {
			if (i < scc.size()) {
				System.out.print(scc.get(i).size() + " ");
			} else {
				System.out.print("0 ");
			}
		}
	}
}
