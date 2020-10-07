package DFSBFS;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	//O(V+E)
	public void traverse(Vertex root) {
		Queue<Vertex> queue = new LinkedList<>();
		
		root.setVisited(true);
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Vertex actual = queue.remove();
			System.out.println("Visited vertex: "+ actual);
			for (Vertex v : actual.getAdjList()) {
				if (!v.isVisited()) {
					v.setVisited(true);
					queue.add(v);
				}
			}
		}
	}
}
