package Astar;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStar {
	
	//our search space
	private Node[][] board;
	
	//our starting point
	private Node start;
	
	//our destination
	private Node end;
	
	//list of nodes that have already been checked
	private List<Node> checkedList;
	
	//list of nodes that have NOT been checked
	private Queue<Node> uncheckedList;

	public AStar(int startrow, int startcol, int endrow, int endcol) {
		super();
		this.board = new Node[Node.NUM_ROWS][Node.NUM_COLS];
		this.checkedList = new ArrayList<>();
		this.uncheckedList = new PriorityQueue<>(new NodeComparator()); 
		//we use priority queue because we would like to get the node with the lowest f in each iteration
		//so PQ using heap ADT will be efficient
		//this PQ will use NodeComparator to determine which node to be the root (lowest f)
		createBoard(startrow,startcol,endrow,endcol);
	}
	
	private void createBoard(int startrow, int startcol, int endrow, int endcol) {
		for (int row=0; row<Node.NUM_ROWS; row++) {
			for (int col=0; col<Node.NUM_COLS;col++) {
				Node node = new Node(row,col);
				board[row][col] = node;
			}
		}
		
		//set obstacles 
		board[1][7].setBlock(true);
		board[2][7].setBlock(true);
		board[2][6].setBlock(true);
		board[2][5].setBlock(true);
		board[2][4].setBlock(true);
		board[2][3].setBlock(true);
		
		//create starting node and destination
		start = board[startrow][startcol];
		end = board[endrow][endcol];
		
	}
	
}
