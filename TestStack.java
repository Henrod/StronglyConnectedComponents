class TestStack {
	public static void main(String[] args) {
		int N = 5;

		Stack stack = new Stack(N);
		for (int i = 0; i < N; i++) {
			stack.push(new Vertex(i + 1));
			System.out.println(stack.toString());
		}

		while (!stack.isEmpty()) {
			stack.pop();
			System.out.println(stack.toString());
		}
	}
}