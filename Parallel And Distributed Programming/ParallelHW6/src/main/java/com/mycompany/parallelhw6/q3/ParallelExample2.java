/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw6.q3;
  import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aditi
 */

  
public class ParallelExample2 {

    public static void main(String[] args) {

        System.out.println("Normal...");

        List<String> alpha = getData();
        alpha.stream().forEach(System.out::println);

        System.out.println("Parallel...");

        List<String> alpha2 = getData();
        alpha2.parallelStream().forEach(System.out::println);
        
    }

    private static List<String> getData() {

        List<String> alpha = new ArrayList<>();

        int n = 97;  // 97 = a , 122 = z
        while (n <= 122) {
            char c = (char) n;
            alpha.add(String.valueOf(c));
            n++;
        }

        return alpha;

    }


}
