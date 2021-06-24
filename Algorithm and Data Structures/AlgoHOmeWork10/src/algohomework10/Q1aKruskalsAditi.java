/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework10;

import algohomework10.Q1bPrimAditi.Edge;
import algohomework10.Q1bPrimAditi.Vertex;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author aditi
 */
public class Q1aKruskalsAditi {

    /**
     * Comparator to sort edges by weight in non decreasing order
     */
    public class EdgeComparator implements Comparator<Edge<Integer>> {
        @Override
        public int compare(Edge<Integer> edge1, Edge<Integer> edge2) {
            if (edge1.getWeight() <= edge2.getWeight()) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public List<Edge<Integer>> findMSTofGraph(Graph<Integer> graph) {
        List<Edge<Integer>> allEdges = graph.getAllEdges();
        EdgeComparator edgeComparator = new EdgeComparator();

        //sort all edges in non decreasing order
        Collections.sort(allEdges, edgeComparator);
        DisjointSets disjointSet = new DisjointSets();

        //create as many disjoint sets as the total vertices
        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            disjointSet.makeSet(vertex.getId());
        }

        List<Edge<Integer>> resultEdge = new ArrayList<Edge<Integer>>();

        for (Edge<Integer> edge : allEdges) {
            //get the sets of two vertices of the edge
            long root1 = disjointSet.findSet(edge.getVertex1().getId());
            long root2 = disjointSet.findSet(edge.getVertex2().getId());

            //check if the vertices are in same set or different set
            //if verties are in same set then ignore the edge
            if (root1 == root2) {
                System.out.println("Ignoring edge "+edge);
                continue;
            } else {
                //if vertices are in different set then add the edge to result and union these two sets into one
                resultEdge.add(edge);
                System.out.println("Adding edge "+edge);
                disjointSet.union(edge.getVertex1().getId(), edge.getVertex2().getId());
            }

        }
        return resultEdge;
    }

    public static void main(String args[]) {
        Graph<Integer> graph = new Graph<Integer>(false);
        System.out.println("MApping: a->1,b->2,c->3,d->4,e->5,f->6");
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 4, 1);
        
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 2);
        
        graph.addEdge(3,4,1);
        graph.addEdge(3,5,5);
        graph.addEdge(3,6,4);
        
        graph.addEdge(4,5,6);
        graph.addEdge(5,6,3);
        Q1aKruskalsAditi mst = new Q1aKruskalsAditi();
        List<Edge<Integer>> result = mst.findMSTofGraph(graph);
        for (Edge<Integer> edge : result) {
            System.out.println(edge.getVertex1() + " " + edge.getVertex2());
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