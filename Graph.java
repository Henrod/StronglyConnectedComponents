import java.util.*;

class Graph {
	List<Vertex> vertices;
	HashMap<Vertex, List<Vertex>> adj;
	HashMap<Vertex, List<Vertex>> adjT;

	public Graph (int N, List<Edge> edges) {
		/* Vertices from 1 to N */
		vertices = new ArrayList<Vertex>(N);
		for (int i = 0; i < N; i++) {
			vertices.add(new Vertex(i + 1));
		}

		/* Empty adjency list for each vertex */
		adj = new HashMap<>();
		adjT = new HashMap<>();
		for (Vertex v : vertices) {
			adj.put(v, new LinkedList<Vertex>());
			adjT.put(v, new LinkedList<Vertex>());
		}

		/* Adjency list: source and destination */
		for (Edge e : edges) {
			Vertex src = vertices.get(e.u);
			Vertex dst = vertices.get(e.v);
			adj.get(src).add(dst);
			adjT.get(dst).add(src);
		}
	}
}
