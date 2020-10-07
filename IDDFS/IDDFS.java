import java.util.Stack;

//Iterative Deepening DFS: visit the nodes in the tree in the same order as 
//DFS but the cumulative order in which nodes are first visited is BFS 
//(basically doing DFS on BFS levels) – combine the advantages of both DFS and BFS
public class IDDFS {
	private Node target;
	private boolean found;

	public IDDFS(Node target) {
		this.target = target;
	}

	private void dfs(Node root, int depth) {
		Stack<Node> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.println("Visited node: " + current);

			if (target.getName().equals(current.getName())) {
				System.out.println("Node found");
				found = true;
				return;
			}
			// check if the current depth level is greater than the
			// depth level we have defined, it means we cannot go deeper in the tree
			// must continue the while loop
			if (current.getDepth() >= depth) {
				continue;
			}

			// we add the neighboring nodes in the stack while increasing their depth by 1
			// this will create the layers of depth
			// Note: this will also increase the previously visited node by one, which is
			// intuitively not correct
			// but it would not matter as those nodes did not yield a match
			for (Node n : current.getAdjList()) {
				n.setDepth(current.getDepth() + 1);
				stack.push(n);
			}
		}
	}

	public void IDDFS(Node root) {
		int depth = 0;

		while (!found) {
			dfs(root, depth);
			depth++;

		}
	}
}
