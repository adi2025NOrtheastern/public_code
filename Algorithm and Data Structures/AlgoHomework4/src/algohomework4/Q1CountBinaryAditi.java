/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework4;

import java.util.HashSet;

/**
 *
 * @author aditi
 */
public class Q1CountBinaryAditi {

    
       public static void countBinary(int n, String binary, HashSet<String> set) {
        if(binary.length()==n) {
           set.add(binary); 
           return;
        }
        countBinary(n, binary + "0", set);
        countBinary(n, binary + "1", set);
    }
    public static int[] countBinary(int n) {
        HashSet<String> set = new HashSet<String>();
        countBinary(n, "", set);
        int result[] =new int[2];
        //int result1 =0;
        for(String str: set) {
            //System.out.println(str);
            if(!isConsecutiveZeros(str)) {
                result[0]++;
                 System.out.println("no 2 consecutive 0s-"+str);
            }
        }
        
         for(String str: set) {
              //System.out.println(str);
            if(!isConsecutiveOnes(str)) {
                result[1]++;
                 System.out.println("no 2 consecutive 1s"+str);
            }
        }
        return result;
    }
      public static boolean isConsecutiveZeros(String str) {
        for(int i=0; i<str.length()-1;i++) {
            if(str.charAt(i)=='0' && str.charAt(i+1) == '0') {
                return true;
            }
        }
        return false;
        
    }
      
      public static boolean isConsecutiveOnes(String str) {
        for(int i=0; i<str.length()-1;i++) {
            if(str.charAt(i)=='1' && str.charAt(i+1) == '1') {
                return true;
            }
        }
        return false;
        
    }
      
      
      public static void main(String[] args) {
          int [] a=countBinary(5);
          System.out.println("For 5 bits no two 1's consecutive count="+a[0]);
          System.out.println("For 5 bits no two 0's consecutive count="+a[1]);
          a=countBinary(4);
          System.out.println("For 4 bits no two 1's consecutive count="+a[0]);
          System.out.println("For 4 bits no two 0's consecutive count="+a[1]);
         // System.out.println("For 4 bits count="+countBinary(4));
    }
}
