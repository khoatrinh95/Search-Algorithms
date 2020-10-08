package Astar;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStar {

	// our search space
	private Node[][] board;

	// our starting point
	private Node start;

	// our destination
	private Node end;

	// list of nodes that have already been checked
	private List<Node> checkedList;

	// list of nodes that have NOT been checked
	private Queue<Node> uncheckedList;

	public AStar(int startrow, int startcol, int endrow, int endcol) {
		super();
		this.board = new Node[Node.NUM_ROWS][Node.NUM_COLS];
		this.checkedList = new ArrayList<>();
		this.uncheckedList = new PriorityQueue<>(new NodeComparator());
		// we use priority queue because we would like to get the node with the lowest f
		// in each iteration
		// so PQ using heap ADT will be efficient
		// this PQ will use NodeComparator to determine which node to be the root
		// (lowest f)
		createBoard(startrow, startcol, endrow, endcol);
	}

	private void createBoard(int startrow, int startcol, int endrow, int endcol) {
		for (int row = 0; row < Node.NUM_ROWS; row++) {
			for (int col = 0; col < Node.NUM_COLS; col++) {
				Node node = new Node(row, col);
				board[row][col] = node;
			}
		}

		// set obstacles
		board[1][7].setBlock(true);
		board[2][7].setBlock(true);
		board[2][6].setBlock(true);
		board[2][5].setBlock(true);
		board[2][4].setBlock(true);
		board[2][3].setBlock(true);

		// create starting node and destination
		start = board[startrow][startcol];
		end = board[endrow][endcol];

	}

	// this method will iterate through the predecessor nodes and print out the path
	public void showPath() {
		System.out.println("SHORTEDT PATH FOUND: \n\n");
		Node node = end;

		while (node != null) {
			System.out.println(node);
			node = node.getPred();
		}
	}

	// manhattan distance
	// this method will generate the Manhattan distance between two nodes
	// we take the sum of the horizontal and vertical distance between the two nodes
	// multiplied by 10
	public int manhattanHeuristic(Node n1, Node n2) {
		return ((Math.abs(n1.getRowIndex() - n2.getRowIndex()) + Math.abs(n1.getColIndex() - n2.getColIndex())) * 10);
	}

	private List<Node> getAllNeighbors(Node node) {

		// we store the neighbors in an arraylist
		List<Node> neighbors = new ArrayList<>();

		int row = node.getRowIndex();
		int col = node.getColIndex();

		// node above
		if (row - 1 >= 0 && !board[row - 1][col].isBlock()) {
			board[row - 1][col].setG(node.getG() + Node.HORI_VERTI_MOVE);
			board[row - 1][col].setH(manhattanHeuristic(board[row - 1][col], end));
			neighbors.add(board[row - 1][col]);
		}

		// node below
		if (row + 1 < Node.NUM_ROWS && !board[row + 1][col].isBlock()) {
			board[row + 1][col].setG(node.getG() + Node.HORI_VERTI_MOVE);
			board[row + 1][col].setH(manhattanHeuristic(board[row + 1][col], end));
			neighbors.add(board[row + 1][col]);
		}

		// node on the left
		if (col - 1 >= 0 && !board[row][col - 1].isBlock()) {
			board[row][col - 1].setG(node.getG() + Node.HORI_VERTI_MOVE);
			board[row][col - 1].setH(manhattanHeuristic(board[row][col - 1], end));
			neighbors.add(board[row][col - 1]);
		}

		// node on the right
		if (col + 1 < Node.NUM_COLS && !board[row][col + 1].isBlock()) {
			board[row][col + 1].setG(node.getG() + Node.HORI_VERTI_MOVE);
			board[row][col + 1].setH(manhattanHeuristic(board[row][col + 1], end));
			neighbors.add(board[row][col + 1]);
		}

		// node on upper left
		if (row - 1 >= 0 && col - 1 >= 0 && !board[row - 1][col - 1].isBlock()) {
			board[row - 1][col - 1].setG(node.getG() + Node.DIAG_MOVE);
			board[row - 1][col - 1].setH(manhattanHeuristic(board[row - 1][col - 1], end));
			neighbors.add(board[row - 1][col - 1]);
		}

		// node on upper right
		if (row - 1 >= 0 && col + 1 < Node.NUM_COLS && !board[row - 1][col + 1].isBlock()) {
			board[row - 1][col + 1].setG(node.getG() + Node.DIAG_MOVE);
			board[row - 1][col + 1].setH(manhattanHeuristic(board[row - 1][col + 1], end));
			neighbors.add(board[row - 1][col + 1]);
		}

		// node on bottom left
		if (row + 1 < Node.NUM_ROWS && col - 1 >= 0 && !board[row + 1][col - 1].isBlock()) {
			board[row + 1][col - 1].setG(node.getG() + Node.DIAG_MOVE);
			board[row + 1][col - 1].setH(manhattanHeuristic(board[row + 1][col - 1], end));
			neighbors.add(board[row + 1][col - 1]);
		}

		// node on bottom right
		if (row + 1 < Node.NUM_ROWS && col + 1 < Node.NUM_COLS && !board[row + 1][col + 1].isBlock()) {
			board[row + 1][col + 1].setG(node.getG() + Node.DIAG_MOVE);
			board[row + 1][col + 1].setH(manhattanHeuristic(board[row + 1][col + 1], end));
			neighbors.add(board[row + 1][col + 1]);
		}
		
		return neighbors;
	}
	
	public void search() {
		
		//start with the starting node
		start.setH(manhattanHeuristic(start, end));
		uncheckedList.add(start);
		
		//the algorithm ends when the uncheckedlist is empty
		while(!uncheckedList.isEmpty()) {
			
			//returns the node with the smallest f = h+g value
			//method poll returns the head of the PQ which is the min
			Node current = uncheckedList.poll();
			System.out.println(current+ "Precedor is: "+current.getPred());
			
			//if we find the destination, the algorithm ends
			if (current.equals(end)) return;
			
			//update the lists
			uncheckedList.remove(current);
			checkedList.add(current);
			
			//visit all the neighbor nodes
			for (Node n : getAllNeighbors(current)) {
				
				//if we encounter a node that has already been assessed, we move on
				if (checkedList.contains(n)) continue;
				
				//if we encounter a node that has node been assessed, we add it to the unchecked list
				if (!checkedList.contains(n)) uncheckedList.add(n);
				
				//set the precedor node of the current node so we can track
				n.setPred(current);
			}
		}
	}
}
