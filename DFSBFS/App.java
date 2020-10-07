package DFSBFS;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFS bfs = new BFS();
		DFS dfs = new DFS();
		Vertex a = new Vertex("A");
		Vertex b = new Vertex("B");
		Vertex c = new Vertex("C");
		Vertex d = new Vertex("D");
		Vertex e = new Vertex("E");
		Vertex f = new Vertex("F");
		Vertex g = new Vertex("G");
		Vertex h = new Vertex("H");
		
		a.addNeightbor(b);
		a.addNeightbor(f);
		a.addNeightbor(g);
		
		b.addNeightbor(a);
		b.addNeightbor(c);
		b.addNeightbor(d);
		
		c.addNeightbor(b);
		
		d.addNeightbor(b);
		d.addNeightbor(e);
		
		f.addNeightbor(a);
		
		g.addNeightbor(a);
		g.addNeightbor(h);
		
		h.addNeightbor(g);
		
//		bfs.traverse(a);
		dfs.traverseRecursion(a);
		
	}

}
