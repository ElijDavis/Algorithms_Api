import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Stack;

public class Graph {

	private int[][] edges; // adjacency matrix
	private LinkedList<Integer>[] adjlist; // adjacency list
	private Object[] labels; // vertex label, i.e, vertex 0, its label = "A", vertex 1, its label = "B"

	public Graph(int n) {
		// n: size of nodes
		// weighted graph
		edges = new int[n][n];
		// edges[i][j] saves the weight of edge i->j, assume weight > 0
		// for unweighted graph
		// set edges[i][j] to 1 if there exists an edge i->j
		// set edges[i][j] to 0 otherwise
		adjlist = new LinkedList[n];
		// adjlist saves the adjacency list of the graph
		// adjlist[i] saves a list of neighboring vertices of vertex i
		
		labels = new Object[n];
	}

	public void setLabel(int vertex, Object label) {
		// vertex: vertex index, label: vertex name
		labels[vertex] = label;

	}

	public Object getLabel(int vertex) {
		return labels[vertex];
	}

	public int size() {
		return edges.length;
	}

	public void addEdge(int source, int target, int w) {
		// add an edge from vertex source to vertex target with w as weight
		edges[source][target] = w;

		// edges[target][source] = w;
		// In an undirected graph, set the symmetry element in the matrix with the same
		// weight
	}

	public boolean isEdge(int source, int target) {
		// if edges[i][j] > 0, there exists an edge from vertex i to vertex j
		return edges[source][target] > 0;
	}

	public void removeEdge(int source, int target) {
		edges[source][target] = 0;
		// edges[target][source] = 0;
		// In an undirected graph, set the symmetry element in the matrix to 0
	}

	public int getWeight(int source, int target) {
		return edges[source][target];
	}

	public int[] neighbors(int vertex) {
		// find neighbors of a given vertex
		int count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				count++;
		}
		final int[] answer = new int[count];
		count = 0;
		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0)
				answer[count++] = i;
		}
		return answer;
	}

	public int getUnvisitedNeighbor(int vertex, boolean[] visited) {
		// find an unvisited neighbor of a given vertex
		// if there exist multiple unvisited neighbors, return the first one found
		// if all neighbors are visited, return -1

		for (int i = 0; i < edges[vertex].length; i++) {
			if (edges[vertex][i] > 0 && visited[i] == false)
				return i;
		}
		return -1;
	}


	
	/*public void bfs() {// BFS
		// Complete this method to traverse a graph using BFS
		// Start BFS from a randomly selected node in the graph
		// Print nodes in order as visited by BFS
		// Note: Follow the pseudocode of BFS() in slides. 
		int n = size();
    	int[] nodes = new int[n];

		Random random = new Random();
    	int startNode = random.nextInt(n);

		Queue<Integer> strQueue = new LinkedList<>();
		while(!strQueue.isEmpty()){
			nodes[k] = strQueue.remove();
		}
	}*/

	/*public void bfs() {// BFS
	// Complete this method to traverse a graph using BFS
	// Start BFS from a randomly selected node in the graph
    // Print nodes in order as visited by BFS
	// Note: Follow the pseudocode of BFS() in slides. 
    int n = size();
    int[] nodes = new int[n]; // Array to store the visited nodes
    boolean[] visited = new boolean[n]; // Array to track visited nodes
    Queue<Integer> queue = new LinkedList<>(); // Queue to perform BFS

    // Select a random starting node
    Random random = new Random();
    int startNode = random.nextInt(n);

    // Enqueue the starting node and mark it as visited
    queue.offer(startNode);
    visited[startNode] = true;
    int index = 0; // Index to track the position in the nodes array

    while (!queue.isEmpty()) {
        int currentVertex = queue.poll();
        // Store the visited node in the nodes array
        nodes[index++] = currentVertex;

        // Get neighbors of the current vertex
        int[] neighbors = neighbors(currentVertex);
        // Enqueue unvisited neighbors
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                queue.offer(neighbor);
                visited[neighbor] = true; // Mark neighbor as visited
            }
        }
    }
    for (int i = 0; i < index; i++) {
        System.out.print(getLabel(nodes[i]) + " ");
    }
    System.out.println();
}*/



public void bfs() {
    int n = size();
    boolean[] visited = new boolean[n]; // Array to track visited nodes
    Queue<Integer> queue = new LinkedList<>(); // Queue to perform BFS

    // Select a random starting node
    Random random = new Random();
    int startNode = random.nextInt(n);

    // Enqueue the starting node and mark it as visited
    queue.offer(startNode);
    visited[startNode] = true;

    // Print the label of the starting node
    System.out.print(getLabel(startNode) + " ");

    while (!queue.isEmpty()) {
        int currentVertex = queue.poll();

        // Get neighbors of the current vertex
        int[] neighbors = neighbors(currentVertex);
        // Enqueue unvisited neighbors
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                queue.offer(neighbor);
                visited[neighbor] = true; // Mark neighbor as visited
                // Print the label of the visited neighbor
                System.out.print(getLabel(neighbor) + " ");
            }
        }
    }
    System.out.println();
}


	
	public static void main(String args[]) {

		// An example to create a graph using the Graph class

		final Graph t = new Graph(6);
		t.setLabel(0, "A");
		t.setLabel(1, "B");
		t.setLabel(2, "C");
		t.setLabel(3, "D");
		t.setLabel(4, "E");
		t.setLabel(5, "F");
		t.addEdge(0, 1, 1);
		t.addEdge(0, 5, 1);
		t.addEdge(1, 2, 1);
		t.addEdge(1, 3, 1);
		t.addEdge(1, 5, 1);
		t.addEdge(2, 3, 1);
		t.addEdge(4, 3, 1);
		t.addEdge(4, 2, 1);
		t.addEdge(5, 4, 1);

		// Test BFS
		t.bfs();

		
		
	
	}

}
