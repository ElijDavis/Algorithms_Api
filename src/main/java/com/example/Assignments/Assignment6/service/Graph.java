package com.example.Assignments.Assignment6.service;

import java.util.LinkedList;
//import java.util.List;
import java.util.Random;
import java.util.Stack;

import com.example.Assignments.def.CGraph;
import com.example.Assignments.def.DFSGraph;

public class Graph {

	private int[][] edges; // adjacency matrix
	private LinkedList<Integer>[] adjlist; // adjacency list
	private Object[] labels; // vertex label, i.e, vertex 0, its label = "A", vertex 1, its label = "B"

	public Graph() {
		// default constructor
		edges = new int[0][0];
		adjlist = new LinkedList[0];
		labels = new Object[0];
	}

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
		// In an unweighted graph, w = 1 if there exists an edge from source to target 
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

	public void getAdjList() {
		// Complete the method to create an adjacency list for the graph
		// Feel free to change the return type
		for (int i = 0; i < adjlist.length; i++) {
			adjlist[i] = new LinkedList<>();
			for (int j = 0; j < edges[i].length; j++) {
				if (isEdge(i, j)) {
					int vert = j;
					adjlist[i].add(vert);
				}
			}
		}
	}
	

	public void print() {
		// Print adjacency list
		int n = edges.length;
		for (int i = 0; i < n; i++) {
			System.out.println("Vertex " + i + ":" + adjlist[i].toString());
		}
	}
	

	/*public void dfs() {// DFS
		// Complete this method to traverse a graph using DFS
		// Start DFS from a randomly selected node in the graph
		// Print nodes in order as visited by DFS
		// Note: Follow the pseudocode of DFS() in slides.
		int[] nodes = new int[n];
		int[] visited_ = new boolean[n];
		Stack<String> stack = new Stack<>();
		Random rando = new Random();
		int rand = rando.nextInt(n);
		int k = 0;
		stack.add(rand); // add the first random element to the stack
		while(stack.length > 0){ // while not empty
			// getUnvisitedNeighbor(stack.peek(), visited_) is w
			if(getUnvisitedNeighbor(stack.peek(), visited_) > 0){
				nodes[k] = (stack.peek()); // add this to the list to print out
				visited_[k] = true; // add the same element into the visited list
				stack.add(getUnvisitedNeighbor(stack.peek(), visited_)); // add the newely unvisited node to the stack to check for neighboors
				//visited_.add(true);
				k++;
			}else{
				stack.pop();
			}
		}

		for(int i = 0; i < n; i++){ //i < nodes.length
			System.out.print(nodes[i]);
		}
	}*/


	public void dfs() {// DFS
		// Complete this method to traverse a graph using DFS
		// Start DFS from a randomly selected node in the graph
		// Print nodes in order as visited by DFS
		// Note: Follow the pseudocode of DFS() in slides.
		int n = size();
		int[] nodes = new int[n]; // Array to store the visited nodes
		boolean[] visited = new boolean[n]; // Array to track visited nodes
		Stack<Integer> stack = new Stack<>(); // Stack to perform DFS
	
		// Select a random starting node
		Random random = new Random();
		int startNode = random.nextInt(n);
	
		// Start DFS from the random node
		stack.push(startNode);
		int index = 0; // Index to track the position in the nodes array
	
		// Perform DFS
		while (!stack.isEmpty()) {
			int currentVertex = stack.pop();
			if (!visited[currentVertex]) {
				// Mark the current vertex as visited
				visited[currentVertex] = true;
				// Store the visited node in the nodes array
				nodes[index++] = currentVertex;
	
				// Get neighbors of the current vertex
				int[] neighbors = neighbors(currentVertex);
				// Push unvisited neighbors onto the stack
				for (int neighbor : neighbors) {
					if (!visited[neighbor]) {
						stack.push(neighbor);
					}
				}
			}
		}
	
		// Print the visited nodes
		for (int i = 0; i < index; i++) {
			System.out.print(getLabel(nodes[i]) + " ");
		}
		System.out.println();
	}


	/////////////////////////////////////////////////////////////////////
	/// The functions below are helper functions to create a graph and it's points
	/////////////////////////////////////////////////////////////////////

	public Graph createGraph(CGraph input) {
		// Create a graph with n vertices, labels, and edges
		Graph graph = new Graph(input.n);
		for (int i = 0; i < input.n; i++) {
			graph.setLabel(i, input.labels[i]);
		}
		for (int[] edge : input.edges) {
			graph.addEdge(edge[0], edge[1], edge[2]);
		}
		return graph;
	}

	public String DFS(DFSGraph input) {
		// Perform DFS on the graph starting from startVertex
		StringBuilder result = new StringBuilder();
		boolean[] visited = new boolean[input.graph.size()];
		Stack<Integer> stack = new Stack<>();
		stack.push(input.startVertex);
		
		while (!stack.isEmpty()) {
			int vertex = stack.pop();
			if (!visited[vertex]) {
				visited[vertex] = true;
				result.append(input.graph.getLabel(vertex)).append(" ");
				int[] neighbors = input.graph.neighbors(vertex);
				for (int neighbor : neighbors) {
					if (!visited[neighbor]) {
						stack.push(neighbor);
					}
				}
			}
		}
		
		return result.toString().trim();
	}

	public String getAdjacencyList(Graph graph) {
		// Get the adjacency list of the graph
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < graph.size(); i++) {
			result.append(graph.getLabel(i)).append(": ");
			int[] neighbors = graph.neighbors(i);
			for (int j = 0; j < neighbors.length; j++) {
				result.append(graph.getLabel(neighbors[j]));
				if (j < neighbors.length - 1) {
					result.append(", ");
				}
			}
			result.append("\n");
		}
		return result.toString().trim();
	}
	


	public static void main(String args[]) {

		// An example to create a graph using the Graph class
		// You should create a new graph to represent the one given in Assignment 6
		// Then test the function dfs() and getAdjList() on the graph you create 
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
		// Test adjacency list
		t.getAdjList();
		t.print();
		// Test DFS
		t.dfs();
		
		System.out.println("directed graph from assignment page");

		// graph from assignment
		final Graph directed = new Graph(7);
		/* vertices */
		directed.setLabel(0, 0);
		directed.setLabel(1, 1);
		directed.setLabel(2, 2);
		directed.setLabel(3, 3);
		directed.setLabel(4, 4);
		directed.setLabel(5, 5);
		directed.setLabel(6, 6);
		/* directed edges (for the adjacency list, im thinking of having different levels of weights depending on what the source vertex is))*/
			// 0 to ...
		directed.addEdge(0, 6,1);
			// 1 to ...
		directed.addEdge(1, 0,1);
			// 2 to ...
		directed.addEdge(2, 3,1);
		directed.addEdge(2, 0,1);
			// 4 to ...
		directed.addEdge(4, 1,1);
		directed.addEdge(4, 3,1);
		directed.addEdge(4, 6,1);
			// 5 to ...
		directed.addEdge(5, 0,1);
		directed.addEdge(5, 1,1);
		directed.addEdge(5, 3,1);
			// 6 to ...
		directed.addEdge(6, 3,1);
		// Test adjacency list
		directed.getAdjList();
		directed.print();
		// Test DFS
		directed.dfs();
	
	}

}
