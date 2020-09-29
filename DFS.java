import java.util.Stack;

public class DFS {
	//DFS using iteration
	//O(V+E)
	public void traverseIterative(Vertex root) {
		Stack<Vertex> stack = new Stack<>();
		
		root.setVisited(true);
		stack.add(root);
		
		while (!stack.isEmpty()) {
			Vertex actual = stack.pop();
			System.out.println("Visited vertex: "+actual);
			
			for (Vertex v : actual.getAdjList()) {
				if (!v.isVisited()) {
					v.setVisited(true);
					stack.push(v);
				}
			}
		}
	}
	
	//DFS using recursion
	//O(V+E)
	public void traverseRecursion(Vertex root) {
		root.setVisited(true);
		System.out.println("Visited vertex: "+ root);
		for (Vertex v: root.getAdjList()) {
			if (!v.isVisited()) {
				traverseRecursion(v);
			}
		}
	}
}
