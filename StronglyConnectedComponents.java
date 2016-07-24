import java.util.*;

class StronglyConnectedComponents {
	private static void visit (Vertex v, LinkedList<Vertex> ordered_vertices, Graph graph) {
		v.visited = true;

		for (Vertex u : graph.adj.get(v)) {
			if (!u.visited) {
				u.parent = v;
				visit(u, ordered_vertices, graph);
			}
		}
		ordered_vertices.addFirst(v);
	}

	private static void visit_scc (Vertex v, LinkedList<List<Vertex>> scc, HashMap<Vertex, List<Vertex>> adjGt) {
		v.visited = true;

		for (Vertex u : adjGt.get(v)) {
			if (!u.visited) {
				visit_scc(u, scc, adjGt);
			}
		}
		scc.getLast().add(v);
	}

	public static List<List<Vertex>> compute(Graph graph) {
		LinkedList<List<Vertex>> scc = new LinkedList<List<Vertex>>();

		for (Vertex v : graph.vertices) {
			v.visited = false;
			v.parent = null;
		}

		LinkedList<Vertex> ordered_vertices = new LinkedList<>();

		for (Vertex v : graph.vertices) {
			if (!v.visited) {
				visit(v, ordered_vertices, graph);
			}
		}

		HashMap<Vertex, List<Vertex>> adjGt = new HashMap<>();
		for (Vertex v : graph.vertices) {
			v.visited = false;
			adjGt.put(v, new LinkedList<Vertex>());
		}
		for (Vertex v : graph.adj.keySet()) {
			for (Vertex u : graph.adj.get(v)) {
				adjGt.get(u).add(v);
			}
		}

		for (Vertex v : ordered_vertices) {
			if (!v.visited) {
				scc.add(new LinkedList<Vertex>());
				visit_scc(v, scc, adjGt);
			}
		}

		return scc;
	}
}