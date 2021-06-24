/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework7;
import java.util.*;
/**
 *
 * @author aditi
 */
public class Q4StringBuilder {
    
    
    public static void main(String[] args) {
        char arr[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O'
                    ,'P','Q','R','S','T','U','V','X','Y','Z'};
        List<Long> timeStr = new ArrayList<>();
        List<Long> timeStrBuilder = new ArrayList<>();
        String s="";
        int j;
        for(int i=0;i<300000;i++) //300000 todo
        {
            //build string s
            s="";
            j=300;
            while(j>0)
            {
                int k;
                k = (int)(arr.length * Math.random());
                s+= arr[k];
                j--;
            }//while end
            //System.out.println("String is ->"+ s);
            StringBuilder sb = new StringBuilder(s);
            long start1 = System.nanoTime();
         //call String reverse
         String output = "";
 
        for (int l = s.length() - 1; l >= 0; l--) {
        output = output + s.charAt(l);
        }
         
          long mid = System.nanoTime();
         // call String builder reverse
         sb.reverse().toString();
         long finish = System.nanoTime();
         long timeElapsedString = mid- start1;
         timeStr.add(timeElapsedString);
         long timeElapsedStringBuilder = finish - mid;
         timeStrBuilder.add(timeElapsedStringBuilder);
            
            
            
            
        }//main for loop 3lakh times
        
        System.out.println("STring time->" + timeStr);
        System.out.println("STring Builder time->" + timeStrBuilder);
        
        
    }
    
    
}
