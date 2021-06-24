/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework10;

import java.util.Arrays;

/**
 *
 * @author aditi
 */
public class Q8aGreedyAditi {
    
 final int MAX = 105;
    int[] A;

    public Q8aGreedyAditi(){
        A= new int[MAX];
    }
    
    public static void main(String[] args) {
        int[] inputA= {8,7,6,5,4,3,2,1};
        int T=15, N, numberOfThings = 0, currentTime = 0;
        N = inputA.length;
        Arrays.sort(inputA);
        for(int i = 0;i < N;++i)
        {
            currentTime += inputA[i];
            if(currentTime > T)
                break;
            numberOfThings++;
        }
        System.out.println("numberOfThings: " +numberOfThings);
      
    }
}