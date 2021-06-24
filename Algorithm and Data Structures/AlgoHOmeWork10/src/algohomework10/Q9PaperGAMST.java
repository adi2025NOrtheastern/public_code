/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework10;

/**
 *
 * @author aditi
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Vijini
 */

//Main class
public class Q9PaperGAMST {

   
    static Graph<Integer> graph;
    static Population population ;//= new Population(grpa);
    static Individual fittest;
    static Individual secondFittest;
    int generationCount = 0;

    public static void main(String[] args) {

         graph = new Graph<>(false);
     
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 4, 1);
        
        graph.addEdge(2, 3, 1);
        graph.addEdge(2, 4, 2);
        
        graph.addEdge(3,4,1);
        graph.addEdge(3,5,5);
        graph.addEdge(3,6,4);
        
        graph.addEdge(4,5,6);
        graph.addEdge(5,6,3);
        
         population = new Population(graph);
        
        Random rn = new Random();

        Q9PaperGAMST demo = new Q9PaperGAMST();

        //Initialize population
        demo.population.initializePopulation(10);

        //Calculate fitness of each individual
        demo.population.calculateFitness();

        System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);

        //While population gets an individual with maximum fitness
        while (demo.population.fittest < 5) {
            ++demo.generationCount;

            //Do selection
            demo.selection();

            //Do crossover
            demo.crossover();

            //Do mutation under a random probability
            if (rn.nextInt()%7 < 8) {
                demo.mutation();
            }

            //Add fittest offspring to population
            demo.addFittestOffspring();

            //Calculate new fitness value
            demo.population.calculateFitness();

            System.out.println("Generation: " + demo.generationCount + " Fittest: " + demo.population.fittest);
        }

        System.out.println("\nSolution found in generation " + demo.generationCount);
        System.out.println("Fitness: "+demo.population.getFittest().fitness);
        System.out.print("Genes: ");
        for (int i = 0; i < 5; i++) { //5
            System.out.print(demo.population.getFittest().genes);
        }

        System.out.println("");

    }

    //Selection
    void selection() {

        //Select the most fittest individual
        fittest = population.getFittest();

        //Select the second most fittest individual
        secondFittest = population.getSecondFittest();
    }

    //Crossover
    void crossover() {
        Random rn = new Random();

        //Select a random crossover point
        int crossOverPoint = rn.nextInt(population.individuals[0].geneLength);

        //Swap values among parents
        for (int i = 0; i < crossOverPoint; i++) {
            Graph<Integer> temp = fittest.genes;//genes[i];
            fittest.genes = secondFittest.genes;
            secondFittest.genes = temp;

        }

    }

    //Mutation
    void mutation() {
        Random rn = new Random();

        //Select a random mutation point
        int mutationPoint = rn.nextInt(population.individuals[0].geneLength);

        //Flip values at the mutation point
       fittest.genes.edgeList.remove(0);
       fittest.genes.edgeList.add(graph.edgeList.get(mutationPoint));

        mutationPoint = rn.nextInt(population.individuals[0].geneLength);

        secondFittest.genes.edgeList.remove(0);
       secondFittest.genes.edgeList.add(graph.edgeList.get(mutationPoint));
    }

    //Get fittest offspring
    Individual getFittestOffspring() {
        if (fittest.fitness > secondFittest.fitness) {
            return fittest;
        }
        return secondFittest;
    }


    //Replace least fittest individual from most fittest offspring
    void addFittestOffspring() {

        //Update fitness values of offspring
        fittest.calcFitness();
        secondFittest.calcFitness();

        //Get index of least fit individual
        int leastFittestIndex = population.getLeastFittestIndex();

        //Replace least fittest individual from most fittest offspring
        population.individuals[leastFittestIndex] = getFittestOffspring();
    }

    
    
    
//Individual class
static class Individual {

    int fitness = 0;
    Graph<Integer> genes = new Graph<>(false);
    int geneLength = 5;

    public Individual(Graph<Integer> inputGraph) {
        Random rn = new Random();

        //Set genes randomly for each individual
        //randomly assgin vertex
        for (int i = 0; i < geneLength; i++) {
            i = Math.abs(rn.nextInt() % 5);  //considering 8 vetices
            System.out.println("i value: "+ i + "inputGraph :"+ inputGraph.getAllVertex().size());
            genes.addVertex(inputGraph.getVertex(i));   //[i] = Math.abs(rn.nextInt() % 2);
            if(genes.getAllVertex().size() == geneLength)
            {
                break;
            }
        }

        fitness = 0;
    }

    //Calculate fitness
    public void calcFitness() {

        fitness = 0;
        for (int i = 0; i < 5; i++) {
            for(Edge v: genes.getAllEdges()) {
                fitness+= v.getWeight();
            }
        }
    }

}

//Population class
static class Population {

    int popSize = 10;
    Individual[] individuals = new Individual[10];
    int fittest = 0;
    Graph<Integer> input;

    public Population(Graph<Integer> input){
        this.input=input;
    }
    
    
    //Initialize population
    public void initializePopulation(int size) {
        for (int i = 0; i < individuals.length; i++) {
            individuals[i] = new Individual(input);
        }
    }

    //Get the fittest individual
    public Individual getFittest() {
        int maxFit = Integer.MIN_VALUE;
        int maxFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (maxFit <= individuals[i].fitness) {
                maxFit = individuals[i].fitness;
                maxFitIndex = i;
            }
        }
        fittest = individuals[maxFitIndex].fitness;
        return individuals[maxFitIndex];
    }

    //Get the second most fittest individual
    public Individual getSecondFittest() {
        int maxFit1 = 0;
        int maxFit2 = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (individuals[i].fitness > individuals[maxFit1].fitness) {
                maxFit2 = maxFit1;
                maxFit1 = i;
            } else if (individuals[i].fitness > individuals[maxFit2].fitness) {
                maxFit2 = i;
            }
        }
        return individuals[maxFit2];
    }

    //Get index of least fittest individual
    public int getLeastFittestIndex() {
        int minFitVal = Integer.MAX_VALUE;
        int minFitIndex = 0;
        for (int i = 0; i < individuals.length; i++) {
            if (minFitVal >= individuals[i].fitness) {
                minFitVal = individuals[i].fitness;
                minFitIndex = i;
            }
        }
        return minFitIndex;
    }

    //Calculate fitness of each individual
    public void calculateFitness() {

        for (int i = 0; i < individuals.length; i++) {
            individuals[i].calcFitness();
        }
        getFittest();
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
        System.out.println("Veretx is" + vertex.getData());
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


