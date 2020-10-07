package Astar;

public class Node {
	public static final int NUM_ROWS = 5;
	public static final int NUM_COLS = 8;
	public static final int HORI_VERTI_MOVE = 10;
	public static final int DIAG_MOVE = 14;
	//distance from root
	private int g;
	//heuristic distance from destination
	private int h;
	
	private int rowIndex;
	private int colIndex;
	
	//previous node (this is how we track the shortest path)
	private Node pred;
	
	//the node maybe an obstacle/block
	private boolean isBlock;

	public Node(int rowIndex, int colIndex) {
		super();
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}
	
	public boolean isBlock() {
		return isBlock;
	}
	
	public void setBlock (boolean block) {
		isBlock = block;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public int getColIndex() {
		return colIndex;
	}

	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}

	public Node getPred() {
		return pred;
	}

	public void setPred(Node pred) {
		this.pred = pred;
	}
	
	public int getF() {
		return g+h;
	}
	
	//check if two nodes are equal
	public boolean equals(Object obj) {
		Node node = (Node) obj;
		return rowIndex==node.getRowIndex() && colIndex == node.getColIndex();
	}
	
	
}
