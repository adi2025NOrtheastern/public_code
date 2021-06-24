/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework9;

/**
 *
 * @author aditi
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryMinHeap<T> {

    private Map<T,Integer> mapPositionNode = new HashMap<>();
    private List<Node> nodesList = new ArrayList<>();
    
        
    public class Node {
        int weight;
        T key;
    }

    /**
     * Checks where the key exists in heap or not
     */
    public boolean containsData(T key){
        return mapPositionNode.containsKey(key);
    }

    
    

    /**
     * Checks with heap is empty or not
     */
    public boolean empty(){
        return nodesList.size() == 0;
    }

    /**
     * Get the heap min without extracting the key
     */
    public T min(){
        return nodesList.get(0).key;
    }
    /**
     * Decreases the weight of given key to newWeight
     */
    public void decrease(T data, int newWeight){
        Integer position = mapPositionNode.get(data);
        nodesList.get(position).weight = newWeight;
        int parent = (position -1 )/2;
        while(parent >= 0){
            if(nodesList.get(parent).weight > nodesList.get(position).weight){
                swap(nodesList.get(parent), nodesList.get(position));
                updatePositionMap(nodesList.get(parent).key,nodesList.get(position).key,parent,position);
                position = parent;
                parent = (parent-1)/2;
            }else{
                break;
            }
        }
    }

    
    /**
     * Add key and its weight to they heap
     */
    public void add(int weight,T key) {
        Node node = new Node();
        node.weight = weight;
        node.key = key;
        nodesList.add(node);
        int size = nodesList.size();
        int current = size - 1;
        int parentIndex = (current - 1) / 2;
        mapPositionNode.put(node.key, current);

        while (parentIndex >= 0) {
            Node parentNode = nodesList.get(parentIndex);
            Node currentNode = nodesList.get(current);
            if (parentNode.weight > currentNode.weight) {
                swap(parentNode,currentNode);
                updatePositionMap(parentNode.key,currentNode.key,parentIndex,current);
                current = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            } else {
                break;
            }
        }
    }

   
    /**
     * Returns the min node of the heap
     */
    public Node extractMinNode() {
        int size = nodesList.size() -1;
        Node minNode = new Node();
        minNode.key = nodesList.get(0).key;
        minNode.weight = nodesList.get(0).weight;

        int lastNodeWeight = nodesList.get(size).weight;
        nodesList.get(0).weight = lastNodeWeight;
        nodesList.get(0).key = nodesList.get(size).key;
        mapPositionNode.remove(minNode.key);
        mapPositionNode.remove(nodesList.get(0));
        mapPositionNode.put(nodesList.get(0).key, 0);
        nodesList.remove(size);

        int currentIndex = 0;
        size--;
        while(true){
            int left = 2*currentIndex + 1;
            int right = 2*currentIndex + 2;
            if(left > size){
                break;
            }
            if(right > size){
                right = left;
            }
            int smallerIndex = nodesList.get(left).weight <= nodesList.get(right).weight ? left : right;
            if(nodesList.get(currentIndex).weight > nodesList.get(smallerIndex).weight){
                swap(nodesList.get(currentIndex), nodesList.get(smallerIndex));
                updatePositionMap(nodesList.get(currentIndex).key,nodesList.get(smallerIndex).key,currentIndex,smallerIndex);
                currentIndex = smallerIndex;
            }else{
                break;
            }
        }
        return minNode;
    }
    
     public static void main(String[] args) {
        
    }
    
     /**
     * Get the weight of given key
     */
    public Integer findWeight(T key) {
        Integer position = mapPositionNode.get(key);
        if( position == null ) {
            return null;
        } else {
            return nodesList.get(position).weight;
        }
    }

    /**
     * Extract min value key from the heap
     */
    public T extractMin(){
        Node node = extractMinNode();
        return node.key;
    }

    private void printPositionMap(){
        System.out.println(mapPositionNode);
    }

    private void swap(Node node1,Node node2){
        int weight = node1.weight;
        T data = node1.key;
        
        node1.key = node2.key;
        node1.weight = node2.weight;
        
        node2.key = data;
        node2.weight = weight;
    }

    private void updatePositionMap(T data1, T data2, int pos1, int pos2){
        mapPositionNode.remove(data1);
        mapPositionNode.remove(data2);
        mapPositionNode.put(data1, pos1);
        mapPositionNode.put(data2, pos2);
    }
    
    public void printHeap(){
        for(Node n : nodesList){
            System.out.println(n.weight + " " + n.key);
        }
    }
    
   
}
