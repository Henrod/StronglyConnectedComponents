import java.util.*;

class Graph {
	static int time;
	static enum Color {
		WHITE, GRAY, BLACK;
	}

	List<Vertex> vertices;
	HashMap<Vertex, List<Vertex>> adj;

	public Graph (List<Vertex> vertices, HashMap<Vertex, List<Vertex>> adj) {
		this.vertices = vertices;
		this.adj = adj;
	}

	private void visit (Vertex v) {
		time += 1;
		v.d = time;
		v.color = Color.GRAY;

		for (Vertex u : adj.get(v)) {
			if (u.color == Color.WHITE) {
				u.parent = v;
				visit(u);
			}
		}

		time += 1;
		v.f = time;
		v.color = Color.BLACK;
	}

	private void visit_scc (Vertex v, LinkedList<List<Vertex>> scc, HashMap<Vertex, List<Vertex>> adjGt) {
		v.color = Color.GRAY;

		for (Vertex u : adjGt.get(v)) {
			if (u.color == Color.WHITE) {
				visit_scc(u, scc, adjGt);
			}
		}

		scc.getLast().add(v);
		v.color = Color.BLACK;
	}

	public List<List<Vertex>> stronglyConnectedComponents () {
		LinkedList<List<Vertex>> scc = new LinkedList<List<Vertex>>();

		for (Vertex v : vertices) {
			v.color = Color.WHITE;
			v.parent = null;
		}

		time = 0;

		for (Vertex v : vertices) {
			if (v.color == Color.WHITE) {
				visit(v);
			}
		}

		HashMap<Vertex, List<Vertex>> adjGt = new HashMap<>();
		for (Vertex v : vertices) {
			v.color = Color.WHITE;
			adjGt.put(v, new LinkedList<Vertex>());
		}
		for (Vertex v : adj.keySet()) {
			for (Vertex u : adj.get(v)) {
				adjGt.get(u).add(v);
			}
		}

		Collections.sort(vertices);

		for (Vertex v : vertices) {
			if (v.color == Color.WHITE) {
				scc.add(new LinkedList<Vertex>());
				visit_scc(v, scc, adjGt);
			}
		}

		return scc;
	}
}
