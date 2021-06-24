/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw6.q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author aditi
 */
public class Q41oldd {
    
    public static void main(String[] args) {
        
        int[][] arr = { { 9, 12, 6, 14, 10, 21, 13}, { 3, 5, 41, 16, 14, 10, 21}, 
		   { 3, 15, 41, 17, 11, 10, 51}, { 3, 15, 41, 17, 11, 10, 51},
		   { 4, 15, 35, 17, 11, 12, 55}, { 2, 16, 31, 18, 12, 11, 42}, 
		   { 2, 15, 35, 10, 11, 12, 19}, { 1, 20, 33, 18, 12, 13, 44} };

        for(int i=0;i<arr.length;i++)   
     {
         System.out.println(" ");
         for(int j=0;j<arr[i].length;j++)
         {
             System.out.print(arr[i][j] + ", ");
         }
     }
       System.out.println(" ");
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
           for(int i=0;i<arr.length;i++)   
     {
        List<Integer> l = new ArrayList<Integer>();
         for(int j=0;j<arr[i].length;j++)
         {
             //System.out.print(arr[i][j] + ", ");
             l.add(arr[i][j]);
         }
         list.add(l);
     }
           
           
          // ExecutorService executor = Executors.newFixedThreadPool(8);
           
         //  ForkJoinPool customThreadPool = new ForkJoinPool(8);
//        try {
//            customThreadPool.submit(
//                    () -> list.parallelStream().sorted()).get();
//        } catch (InterruptedException ex) {
//            System.out.println(ex);
//            Logger.getLogger(Q4.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ExecutionException ex) {
//            System.out.println(ex);
//            Logger.getLogger(Q4.class.getName()).log(Level.SEVERE, null, ex);
//        }
           
     //      list.parallelStream().sorted();
     //  list.parallelStream().sorted((m1,m2)->Integer.compare(m1, m2))).forEachOrdered(System.out::println);

//list.parallelStream().flatMapToInt(Arrays::stream);


//.collect(Collectors.);
        System.out.println("After sorting: "+list.toString());
        
        //List<T> collection = Arrays.stream(arr)  //'array' is two-dimensional
    //.flatMap(Arrays::stream)
    //.collect(Collectors.toList());
//        List inputarray = new ArrayList();
//for (int[] array : arr) {
//    //This will add int[] object into the list, and not the int values.
//    inputarray.add(Arrays.asList(array));
//}
//        System.out.println("Before ");
//        for(Object i : inputarray)
//        {
//            System.out.print(i.toString());
//        }
//        final int parallelism = 8;
// 
//        ForkJoinPool forkJoinPool = null;
//
//        forkJoinPool = new ForkJoinPool(parallelism);
////        forkJoinPool.submit(() ->
////                
////                //parallel stream invoked here
////                inputarray.parallelStream()
////                        .sorted()
////               
////                
////        );//.get(); //this makes it an overall blocking call
////        
//        
//        IntStream intStream = Arrays.asList(arr)
//    .parallelStream()               // "rows" in parallel
//    .flatMapToInt(Arrays::stream)
//                .sorted(); 
//       
//         forkJoinPool.submit(() ->
//        intStream.sorted()
//                 .forEachOrdered(n -> System.out.print(n + " "))
//         );
//        System.out.println("After "+ intStream);
//       // intStream.forEachOrdered(n -> System.out.print(n + " "));
//        
//        if (forkJoinPool != null) {
//            forkJoinPool.shutdown(); //always remember to shutdown the pool
//        }
int n = arr.length;
int m = arr[0].length;
int[][] b = new int[n][m];
int i=0;
for(List<Integer> l: list)
{
    int j=0;
    while(j!=l.size())
    {
    
    b[i][j] = l.get(j);
    j++;
    }
    i++;
}


//     for( i=0;i<arr.length;i++)   
//     {
//         System.out.println(" ");
//         for(int j=0;j<arr[i].length;j++)
//         {
//             System.out.print(arr[i][j] + ", ");
//         }
//     }
     
     for( i=0;i<b.length;i++)   
     {
         System.out.println(" ");
         for(int j=0;j<b[i].length;j++)
         {
             System.out.print(b[i][j] + ", ");
         }
     }
     
     
     
     IntStream stream = Arrays.stream(arr).flatMapToInt(x -> Arrays.stream(x)).sorted();
        System.out.println(stream.toArray().toString());
        
        int a [] = {1,5, 7, 2};
        Arrays.stream(a).parallel().sorted().forEachOrdered(s->System.out.println(s));
        
            Stream<int[]> temp = Arrays.stream(arr);
        List<Integer> listOfIntegers= temp
                .flatMap( x -> Arrays.stream(x).boxed())
                .map(e -> 2*e)
                .collect(Collectors.toList());
 
        System.out.println(listOfIntegers);
        // list.parallelStream().forEach().sorted().forEachOrdered(s->System.out.println(s));\
        
           Stream<int[]> temp1 = Arrays.stream(arr);
          listOfIntegers= temp1
                .flatMap(x -> Arrays.stream(x).boxed())
                .sorted()
                .collect(Collectors.toList());
 
        System.out.println(listOfIntegers);
        
        
        
           Stream<int[]> temp2 = Arrays.stream(arr);
          listOfIntegers= temp2
                .flatMap(x -> Arrays.stream(x).boxed())
                .sorted()
                .collect(Collectors.toList());
 
        System.out.println(listOfIntegers);
        System.out.println("Aditi: initially");
        list
    .parallelStream()
    .forEach(e -> System.out.print(e + " "));
        //sort
        
        
         list
    .parallelStream()
    .forEach(e -> Collections.sort(e));
        
        
         System.out.println("Aditi: after sort");
         
          list
    .parallelStream()
    .forEach(e -> System.out.print(e + " "));
         
//        
//        List<Integer> lint = new ArrayList<>();
//        lint.add(120);
//        lint.add(580);
//        lint.add(20);
//        lint.add(750);
//        System.out.println(lint.toString());
//        list.parallelStream() // in parallel, not just concurrently!
//            //.filter(s -> !s.isEmpty()) // remove empty strings
//            //.distinct() // remove duplicates
//            .sorted() // sort them
//            .forEachOrdered(s -> System.out.println(s)); // print each item
//        
//        System.out.println("After ");
//         System.out.println(lint.toString());
    }
    
    
}
