package DFSBFS;
import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private String name;
	private boolean visited;
	private List<Vertex> adjList;
	
	public Vertex(String name) {
		this.name = name;
		this.adjList = new ArrayList<>();
	}
	
	public String toString() {
		return name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getAdjList() {
		return adjList;
	}

	public void setAdjList(List<Vertex> adjList) {
		this.adjList = adjList;
	}
	
	public void addNeightbor(Vertex vertex) {
		adjList.add(vertex);
	}
}
