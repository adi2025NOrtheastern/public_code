/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework10;
import java.util.*; 
import java.lang.*; 
import java.io.*; 
/**
 *
 * @author aditi
 */
public class Q7BellManfordAditi {
 
// Driver method to test above function 
	public static void main(String[] args) 
	{ 
		int V = 5; // Number of vertices in graph 
		int E = 8; // Number of edges in graph 

		Graph graph; 
    graph = new Graph(V, E);

    
    // add edge 1-2 (or B-C in above figure) 
		graph.edge[2].source = 1; 
		graph.edge[2].toVertext = 2; 
		graph.edge[2].weight = 3; 
                
		// add edge 0-1 (or A-B in above figure) 
		graph.edge[0].source = 0; 
		graph.edge[0].toVertext = 1; 
		graph.edge[0].weight = -1; 

		// add edge 0-2 (or A-C in above figure) 
		graph.edge[1].source = 0; 
		graph.edge[1].toVertext = 2; 
		graph.edge[1].weight = 4; 

		// add edge 1-4 (or A-E in above figure) 
		graph.edge[4].source = 1; 
		graph.edge[4].toVertext = 4; 
		graph.edge[4].weight = 2;

		// add edge 1-3 (or B-D in above figure) 
		graph.edge[3].source = 1; 
		graph.edge[3].toVertext = 3; 
		graph.edge[3].weight = 2; 

		// add edge 3-1 (or D-B in above figure) 
		graph.edge[6].source = 3; 
		graph.edge[6].toVertext = 1; 
		graph.edge[6].weight = 1;  

		// add edge 3-2 (or D-C in above figure) 
		graph.edge[5].source = 3; 
		graph.edge[5].toVertext = 2; 
		graph.edge[5].weight = 5; 

		

		// add edge 4-3 (or E-D in above figure) 
		graph.edge[7].source = 4; 
		graph.edge[7].toVertext = 3; 
		graph.edge[7].weight = -3; 

		graph.BellmanFord(graph, 0); 
	} 
// 
   
}
// A class to represent a connected, directed and weighted graph 
 class Graph { 
	// A class to represent a weighted edge in graph 
	class Edge { 
		int source, toVertext, weight; 
		Edge() 
		{ 
			source = toVertext = weight = 0; 
		} 
	}; 

	int V, E; 
	Edge edge[]; 

	// Creates a graph with V vertices and E edges 
	Graph(int v, int e) 
	{ 
		V = v; 
		E = e; 
		edge = new Edge[e]; 
		for (int i = 0; i < e; ++i) 
			edge[i] = new Edge(); 
	} 

	// The main function that finds shortest distances from source 
	// to all other vertices using Bellman-Ford algorithm. The 
	// function also detects negative weight cycle 
	void BellmanFord(Graph graph, int source) 
	{ 
		int V = graph.V, E = graph.E; 
		int dist[] = new int[V]; 

		// Step 1: Initialize distances from source to all other 
		// vertices as INFINITE 
		for (int i = 0; i < V; ++i) 
			dist[i] = Integer.MAX_VALUE; 
		dist[source] = 0; 

		// Step 2: Relax all edges |V| - 1 times. A simple 
		// shortest path from source to any other vertex can 
		// have at-most |V| - 1 edges 
		for (int i = 1; i < V; ++i) { 
			for (int j = 0; j < E; ++j) { 
				int u = graph.edge[j].source; 
				int v = graph.edge[j].toVertext; 
				int weight = graph.edge[j].weight; 
                                System.out.println("dist[u] + weight + dist[v]"+ dist[u]+" " + weight+ " "+dist[v]);
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) 
                                {dist[v] = dist[u] + weight; 
                                }
                                printArr(dist, V);
                                }
                       System.out.println("After iteration :"+i);
                        printArr(dist, V);
			
		} 

		// Step 3: check for negative-weight cycles. The above 
		// step guarantees shortest distances if graph doesn't 
		// contain negative weight cycle. If we get a shorter 
		// path, then there is a cycle. 
		for (int j = 0; j < E; ++j) { 
			int u = graph.edge[j].source; 
			int v = graph.edge[j].toVertext; 
			int weight = graph.edge[j].weight; 
			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { 
				System.out.println("Graph contains negative weight cycle"); 
				return; 
			} 
		} 
		printArr(dist, V); 
	} 

	// A utility function used to print the solution 
	void printArr(int dist[], int V) 
	{ 
		System.out.println("Vertex Distance from Source"); 
		for (int i = 0; i < V; ++i) 
			System.out.println(i + "\t\t" + dist[i]); 
	} 

	
}
