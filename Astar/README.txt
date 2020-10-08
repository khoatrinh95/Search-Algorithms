In this algorithm, we develop an A* search that looks for the shortest path in a grid of 5x8 and there are certain blocked cells within the grid that act as obstacles. The search will find the shortest path from a starting point to the destination while avoiding all the obstacles by implementing A* algorithm which does the following:

- collect all the neighbouring nodes
- calculate the approximate shortest path of each node using the formula f= g+h, where g is the cost of moving from the starting point to that node and h is the approx. distance from that node to the destination (Note that we use Manhattan distance in this algorithm)
- retrieve the node with the lowest cost (heuristic distance f)
- continue until the retrieved node is the destination
