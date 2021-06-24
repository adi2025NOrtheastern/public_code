/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aditi
 */

public class Q6PrimAditi {

  
    public List<Edge<Integer>> primMST(Graph<Integer> graph){

        //binary heap + map data structure
        BinaryMinHeap<Vertex<Integer>> binaryHeapMin = new BinaryMinHeap<>();

        //stores final outputListEdges
        List<Edge<Integer>> outputListEdges = new ArrayList<>();
        
        //map of vertex to edge which gave minimum weight to this vertex.
        Map<Vertex<Integer>,Edge<Integer>> mapVertexAndEdge = new HashMap<>();

        
        //insert all vertices with infinite value initially.
        for(Vertex<Integer> v : graph.getAllVertex()){
            binaryHeapMin.add(Integer.MAX_VALUE, v);
        }

        //start from any random vertex
        Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();

        //for the start vertex decrease the value in heap + map to 0
        binaryHeapMin.decrease(startVertex, 0);

        //iterate till heap + map has elements in it
        while(!binaryHeapMin.empty()){
            //extract min value vertex from heap + map
            Vertex<Integer> current = binaryHeapMin.extractMin();

            //get the corresponding edge for this vertex if present and add it to final outputListEdges.
            //This edge wont be present for first vertex.
            Edge<Integer> edgeSpaningTree = mapVertexAndEdge.get(current);
            if(edgeSpaningTree != null) {
                outputListEdges.add(edgeSpaningTree);
            }

            //iterate through all the vertexAdjacnt vertices
            for(Edge<Integer> edge : current.getEdges()){
                Vertex<Integer> vertexAdjacnt = getVertexForEdge(current, edge);
                //check if vertexAdjacnt vertex exist in heap + map and weight attached with this vertex is greater than this edge weight
                if(binaryHeapMin.containsData(vertexAdjacnt) && binaryHeapMin.findWeight(vertexAdjacnt) > edge.getWeight()){
                    //decrease the value of vertexAdjacnt vertex to this edge weight.
                    binaryHeapMin.decrease(vertexAdjacnt, edge.getWeight());
                    //add vertex->edge mapping in the graph.
                    mapVertexAndEdge.put(vertexAdjacnt, edge);
                }
            }
        }
        return outputListEdges;
    }

    private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e){
        return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
    }

    public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(false);
     
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 3, 4);
        
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 4, 6);
        graph.addEdge(5, 4, 7);
        
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 6, 11);
        
        graph.addEdge(6, 4, 9);
        graph.addEdge(5, 6, 12);
        graph.addEdge(5, 7, 8);
        graph.addEdge(6, 7, 7);
        
        Q6PrimAditi prims = new Q6PrimAditi();
        System.out.println("MApping: a->1,b->2,c->3,d->4,e->5,f->6,g->7");
        Collection<Edge<Integer>> edges = prims.primMST(graph);
        for(Edge<Integer> edge : edges){
            System.out.println(edge);
        }
    }
    
    
}
