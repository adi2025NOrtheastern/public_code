/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aditi
 */

public class Q1bPrimAditi {

  
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
     
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 4, 1);
        
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 2);
        
        graph.addEdge(3,4,1);
        graph.addEdge(3,5,5);
        graph.addEdge(3,6,4);
        
        graph.addEdge(4,5,6);
        graph.addEdge(5,6,3);
        
        
        
        Q1bPrimAditi prims = new Q1bPrimAditi();
        System.out.println("MApping: a->1,b->2,c->3,d->4,e->5,f->6");
        Collection<Edge<Integer>> edges = prims.primMST(graph);
        for(Edge<Integer> edge : edges){
            System.out.println(edge);
        }
    }
    
    
    static class Vertex<T> {
    long id;
    private T data;
    private List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();
    
    Vertex(long id){
        this.id = id;
    }
    
    public long getId(){
        return id;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public T getData(){
        return data;
    }
    
    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
        edges.add(e);
        adjacentVertex.add(v);
    }
    
    public String toString(){
        return String.valueOf(id);
    }
    
    public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }
    
    public List<Edge<T>> getEdges(){
        return edges;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
    public int getDegree(){
        return edges.size();
    }
    
    @Override
    public int hashCode() {
        final int prime = 3;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    
}


static class Graph<T>{

    private List<Edge<T>> edgeList;
    private Map<Long,Vertex<T>> mapVertex;
    boolean edgeDirectedFlag = false;
    
    public Graph(boolean edgeDirectedFlag){
        edgeList = new ArrayList<Edge<T>>();
        mapVertex = new HashMap<Long,Vertex<T>>();
        this.edgeDirectedFlag = edgeDirectedFlag;
    }
    
    public void addEdge(long id1, long id2){
        addEdge(id1,id2,0);
    }
    
    
    public void addVertex(Vertex<T> vertex){
        if(mapVertex.containsKey(vertex.getId())){
            return;
        }
        mapVertex.put(vertex.getId(), vertex);
        for(Edge<T> edge : vertex.getEdges()){
            edgeList.add(edge);
        }
    }
    
    
    
    public Vertex<T> getVertex(long id){
        return mapVertex.get(id);
    }
    
    public Vertex<T> addSingleVertex(long id){
        if(mapVertex.containsKey(id)){
            return mapVertex.get(id);
        }
        Vertex<T> v = new Vertex<T>(id);
        mapVertex.put(id, v);
        return v;
    }
    public void addEdge(long id1,long id2, int weight){
        Vertex<T> vertex1 = null;
        if(mapVertex.containsKey(id1)){
            vertex1 = mapVertex.get(id1);
        }else{
            vertex1 = new Vertex<T>(id1);
            mapVertex.put(id1, vertex1);
        }
        Vertex<T> vertex2 = null;
        if(mapVertex.containsKey(id2)){
            vertex2 = mapVertex.get(id2);
        }else{
            vertex2 = new Vertex<T>(id2);
            mapVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<T>(vertex1,vertex2,edgeDirectedFlag,weight);
        edgeList.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!edgeDirectedFlag){
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }
    
    public List<Edge<T>> getAllEdges(){
        return edgeList;
    }
    
    public Collection<Vertex<T>> getAllVertex(){
        return mapVertex.values();
    }
    public void setDataForVertex(long id, T data){
        if(mapVertex.containsKey(id)){
            Vertex<T> vertex = mapVertex.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(Edge<T> edge : getAllEdges()){
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}


static class Edge<T>{
    private boolean edgeDirectedFlag = false;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;
    
    Edge(Vertex<T> vertex1, Vertex<T> vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean edgeDirectedFlag){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.edgeDirectedFlag = edgeDirectedFlag;
    }
    
    Edge(Vertex<T> vertex1, Vertex<T> vertex2,boolean edgeDirectedFlag,int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.edgeDirectedFlag = edgeDirectedFlag;
    }
    
    Vertex<T> getVertex2(){
        return vertex2;
    }
    
    Vertex<T> getVertex1(){
        return vertex1;
    }
    
    
    
    int getWeight(){
        return weight;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (vertex1 == null) {
            if (other.vertex1 != null)
                return false;
        } else if (!vertex1.equals(other.vertex1))
            return false;
        if (vertex2 == null) {
            if (other.vertex2 != null)
                return false;
        } else if (!vertex2.equals(other.vertex2))
            return false;
        return true;
    }
public boolean edgeDirectedFlag(){
        return edgeDirectedFlag;
    }
    @Override
    public int hashCode() {
        final int prime = 3;
        int result = 1;
        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
        return result;
    }

    

    @Override
    public String toString() {
        return "Edge , vertex1 -> vertex2=" + vertex1
                + "-> " + vertex2 + ", weight=" + weight + "]";
    }
}

    
}


