class Vertex {
	public boolean visited;
	public int index;
	public Vertex parent;

	public Vertex (int index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return index + " ";
	}
}
