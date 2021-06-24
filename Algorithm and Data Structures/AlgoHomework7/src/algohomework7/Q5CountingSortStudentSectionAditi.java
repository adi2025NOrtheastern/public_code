/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework7;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
/**
 *
 * @author aditi
 */
public class Q5CountingSortStudentSectionAditi {
 
  void countSort(Map<String,Integer> map, int n) {
    int len = map.size();
    Map<String,Integer> outputmap = new LinkedHashMap<>();
    int[] output = new int[len+1];
    //int[] inputkeys = new int[4];
    int[] array1= new int[len];
    int n1=0;
      System.out.println("map->" + map +"size"+map.values().size());
    for(Integer i: map.values())
    {
        array1[n1++]=(int) i;    
        System.out.println(array1[n1-1]+" "+ i);
        //System.out.print(array[n1-1]+",");
    }
    System.out.println("Array keys->");
      for(int i=0;i<array1.length;i++){
          System.out.print(array1[i]+" "+array1.length+" ");
      }
      //int[] array1={4,3,2,4,2,3,4,4,1,3,2,3,1,3,1,2,3,2,4,4};
    int max = array1[0];
    for (int i = 1; i < len; i++) {
      if ((array1[i]) > max)
        max = array1[i];
    }
      System.out.println("Max= "+max);
    int[] count = new int[max + 1];

    for (int i = 0; i < max; ++i) {
      count[i] = 0;
    }
    for (int i = 0; i < len; i++) {
      count[array1[i]]++;
        System.out.println("Count array->");
        printArrayInt(count);
    }
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

      System.out.println("q5 Before placing in output array");
      System.out.print("Output  is-> ");
        printArrayInt(output);
        System.out.println("");
        System.out.print("Count is-> ");
        printArrayInt(count);
        System.out.println("");
    for (int i = len - 1; i >= 0; i--) {
      output[count[array1[i]] - 1] = array1[i];
      
      count[array1[i]]--;
        System.out.print("Output is-> ");
        printArrayInt(output);
        System.out.println("");
        System.out.print("Count is-> ");
        printArrayInt(count);
        System.out.println("");
    }
      System.out.println("Sorted output");
      printArrayInt(output);
      System.out.println("");
    for (int i = 0; i < len; i++) {
      String name=getKey(map,output[i]);
        //System.out.println("Name ="+name);
      map.remove(name);
      outputmap.put(name,output[i]);
        System.out.print(name+"->"+output[i]+" ");
    }
    System.out.println("Sorted map ");
     // System.out.println("Sorted map ->"+outputmap);
  }

  
  public <String, Integer> String getKey(Map<String, Integer> map, Integer value) {
    for (Entry<String, Integer> entry : map.entrySet()) {
        if (entry.getValue().equals(value)) {
            return entry.getKey();
        }
    }
    return null;
}
  
  void printArrayInt(int[] ar){
      for(int i=0;i<ar.length;i++)
      System.out.print(ar[i]+" ,");
  }
  
  void printArrayChar(char[] ar){
      for(char o: ar)
      System.out.print(o+" |");
  }
  public static void main(String args[]) {
    Map<String,Integer> inputData = new  LinkedHashMap<>();
    inputData.put("Anderson",2);
    inputData.put("Brown",3);
    inputData.put("Davis",3);
    inputData.put("Garcia",4);
    inputData.put("Harris",1);
    inputData.put("Jackson",3);
    inputData.put("Johnson",4);
    inputData.put("Jones",3);
    inputData.put("Martin",1);
    inputData.put("Martinez",2);
    inputData.put("Miller",2);
    inputData.put("Moore",1);
    inputData.put("Robinson",2);
    inputData.put("Smith",4);
    inputData.put("Taylor",3);
    inputData.put("Thomas",4);
    inputData.put("Thompson",4);
    inputData.put("White",2);
    inputData.put("Williams",3);
    inputData.put("Wilson",4);
    Q5CountingSortStudentSectionAditi cs = new Q5CountingSortStudentSectionAditi();
    cs.countSort(inputData,4); //as 4 sections - range
    //System.out.println("After Sorting, Array is: ");
    //for(char c: inputData)
        //  System.out.print(c+" ,");
  }
}
