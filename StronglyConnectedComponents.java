import java.util.*;

class StronglyConnectedComponents {
	private static void visit (Vertex s, LinkedList<Vertex> ordered_vertices, Graph graph) {
		boolean[] inside = new boolean[Main.N];
		Stack stack = new Stack(Main.N);
		stack.push(s);

		loop:
		while (!stack.isEmpty()) {
			Vertex v = stack.pop();
			v.visited = true;

			for (Vertex u : graph.adj.get(v)) {
				if (!u.visited) {
					u.parent = v;
					stack.push(v);
					stack.push(u);
					continue loop;
				}
			}
			if (!inside[v.index - 1]) {
				ordered_vertices.addFirst(v);
				inside[v.index - 1] = true;
			}
		}
	}

	private static void visit_scc (Vertex s, LinkedList<List<Vertex>> scc, Graph graph) {
		boolean[] inside = new boolean[Main.N];
		Stack stack = new Stack(Main.N);
		stack.push(s);

		loop:
		while (!stack.isEmpty()) {
			Vertex v = stack.pop();
			v.visited = true;
			for (Vertex u : graph.adjT.get(v)) {
				if (!u.visited) {
					stack.push(v);
					stack.push(u);
					continue loop;
				}
			}
			if (!inside[v.index - 1]) {
				scc.getLast().add(v);
				inside[v.index - 1] = true;
			}
		}
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

		for (Vertex v : graph.vertices) {
			v.visited = false;
		}

		for (Vertex v : ordered_vertices) {
			if (!v.visited) {
				scc.add(new LinkedList<Vertex>());
				visit_scc(v, scc, graph);
			}
		}

		return scc;
	}
}