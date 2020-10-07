package Astar;

import java.util.Comparator;

//this class is used to compare two node objects
public class NodeComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		if (o1.getF()<o2.getF()) return -1;
		if (o1.getF()>o2.getF()) return 1;
		return 0;
	}
	
	
}
