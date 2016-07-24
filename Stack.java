import java.lang.Exception;

class Stack {
	private Vertex[] stack;
	private int top;

	public Stack(int N) {
		stack = new Vertex[N];
		top = -1;
	}

	public void push(Vertex v) {
		stack[++top] = v;
	}

	public Vertex pop() {
		Vertex v = stack[top--];
		stack[top + 1] = null;

		return v;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i <= top; i++) {
			sb.append(stack[i].toString());
		}
		return sb.toString();
	}
}