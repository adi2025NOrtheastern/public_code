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
public class Q6DijkstraAditi {

    public Map<Vertex<Integer>,Integer> shortestPath(Graph<Integer> graph, Vertex<Integer> sourceVertex){

        //heap + map data structure
        BinaryMinHeap<Vertex<Integer>> minHeap = new BinaryMinHeap<>();

        //stores shortest distanceMap from root to every vertex
        Map<Vertex<Integer>,Integer> distanceMap = new HashMap<>();

        //stores parentMap of every vertex in shortest distanceMap
        Map<Vertex<Integer>, Vertex<Integer>> parentMap = new HashMap<>();

        //initialize all vertex with infinite distanceMap from source vertex
        for(Vertex<Integer> vertex : graph.getAllVertex()){
            minHeap.add(Integer.MAX_VALUE, vertex);
        }

        //set distanceMap of source vertex to 0
        minHeap.decrease(sourceVertex, 0);

        //put it in map
        distanceMap.put(sourceVertex, 0);

        //source vertex parentMap is null
        parentMap.put(sourceVertex, null);

        //iterate till heap is not empty
        while(!minHeap.empty()){
            //get the min value from heap node which has vertex and distanceMap of that vertex from source vertex.
            BinaryMinHeap<Vertex<Integer>>.Node heapNode = minHeap.extractMinNode();
            Vertex<Integer> current = heapNode.key;

            //update shortest distanceMap of current vertex from source vertex
            distanceMap.put(current, heapNode.weight);

            //iterate through all edges of current vertex
            for(Edge<Integer> edge : current.getEdges()){

                //get the adjacent vertex
                Vertex<Integer> adjacent = findVertexOfEdge(current, edge);

                //if heap does not contain adjacent vertex means adjacent vertex already has shortest distanceMap from source vertex
                if(!minHeap.containsData(adjacent)){
                    continue;
                }

                //add distanceMap of current vertex to edge weight to get distanceMap of adjacent vertex from source vertex
                //when it goes through current vertex
                int newDistance = distanceMap.get(current) + edge.getWeight();

                //see if this above calculated distanceMap is less than current distanceMap stored for adjacent vertex from source vertex
                if(minHeap.findWeight(adjacent) > newDistance) {
                    minHeap.decrease(adjacent, newDistance);
                    parentMap.put(adjacent, current);
                }
            }
        }
        System.out.println("Parent Map->"+ parentMap);
        return distanceMap;
    }

    private Vertex<Integer> findVertexOfEdge(Vertex<Integer> v, Edge<Integer> e){
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
        
        

        Q6DijkstraAditi dsp = new Q6DijkstraAditi();
        Vertex<Integer> sourceVertex = graph.getVertex(1);
        System.out.println("MApping: a->1,b->2,c->3,d->4,e->5,f->6,g->7");
        Map<Vertex<Integer>,Integer> distanceMap = dsp.shortestPath(graph, sourceVertex);
        
        System.out.print("Distance Map-> "+distanceMap);
    }
}

class Vertex<T> {
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


class Graph<T>{

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


class Edge<T>{
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
