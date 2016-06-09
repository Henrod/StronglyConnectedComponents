class Vertex implements Comparable<Vertex> {
	public Graph.Color color;
	public int index;
	public int d, f;
	public Vertex parent;

	public Vertex (int index) {
		this.index = index;
	}

	public int compareTo (Vertex v) {
		return v.f - this.f;
	}
}
