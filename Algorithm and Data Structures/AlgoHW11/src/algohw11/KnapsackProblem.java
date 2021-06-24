/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohw11;

/**
 *
 * @author aditi
 */
public class KnapsackProblem {
     static char[] item = {'A','B','C','D','E'};
        
    static void knapsackDo(int[] value, int[] size,int knapsckCap)
    {
        int n= value.length ;
        int tempC; int tempB;
        int[] B = new int[knapsckCap +1];
        int[] L = new int[knapsckCap +1];
        
        
         //print row i 
         System.out.println("");
         System.out.print("B[k]");
          for(int k=1;k<B.length;k++)
          {
              System.out.print(B[k] + " ");
          }
          System.out.println("");
          System.out.print("L[k]");
          for(int k=1;k<L.length;k++)
          {
              L[k]=-1;
              System.out.print(L[k] + " ");
          }  
        
        for(int i =0 ;i<n;i++)
        {
            for(int c=1; c<=knapsckCap; c++)
            {
                if(c >= size[i])
                {
                  tempC = c- size[i];
                  tempB = value[i] + B[tempC];
                  if(tempB > B[c])
                  {
                      B[c] = tempB;
                      L[c] = i;
                  }
                  
                  
                  
                }
            }
            
          //print row i 
            System.out.println("");
          System.out.print("B[k]");
          for(int k=1;k<B.length;k++)
          {
              System.out.print(B[k] + " ");
          }
           System.out.println("");
            System.out.print("L[k]");
          for(int k=1;k<L.length;k++)
          {
              if(L[k]==-1)
              {
                  System.out.print("- ");
              }
              else System.out.print(item[L[k]] + " ");
          }  
          
            System.out.println("");
          
        }
        
        
        
        
        
    }
    
    
    public static void main(String[] args) {
        
        int[] value = {4,5,10,11,12};
        int[] size = {3,4,7,8,9};
        //char[] item = {'A','B','C','D','E'};
        
        
        knapsackDo(value, size, 17);
        
         knapsackDo(value, size, 36);
    }
}
