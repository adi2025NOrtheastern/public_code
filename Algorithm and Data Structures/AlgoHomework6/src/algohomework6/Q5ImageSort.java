/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework6;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author aditi
 */
public class Q5ImageSort {
    
     
    static void printInputArray(double arr[]) {
      int n = arr.length;
      for (int i = 0; i < n; ++i){
        System.out.print(arr[i] + "  , ");
      }
      System.out.println();
    }
    
    
    public static void main(String args[])throws IOException 
    { 
    BufferedImage img = null; 
        File f = null; 
  
        //read image 
        try
        { 
            f = new File("C:\\Users\\aditi\\Documents\\Boston.jpeg"); 
            img = ImageIO.read(f); 
        } 
        catch(IOException e) 
        { 
            System.out.println(e); 
        } 
  
        //get image width and height 
        int width = img.getWidth(); 
        int height = img.getHeight(); 
        double[] intensityQuick= new double[width * height];
        double[] intensityInsertion= new double[width * height];
        double[] intensityTim= new double[width * height];
                int h=0,m=0,n=0;
         for( int i=0;i<width;i++)
         {
             for(int j=0;j<height;j++)
             {
        int rgbA = img.getRGB(i,j); 
        int redA = (rgbA >> 16) & 0xff; 
        int greenA = (rgbA >> 8) & 0xff; 
        int blueA = (rgbA) & 0xff; 
        double I = 0.2989 * redA + 0.5870 * greenA+ 0.1140 * blueA;
        intensityQuick[h++]=I;
        intensityInsertion[m++]=I;
        intensityTim[n++]=I;
             }
         }
        System.out.println("Intially.. Quick ");
        Q5aQuickSortPivotLastAditi quickSort = new Q5aQuickSortPivotLastAditi();
         printInputArray(intensityQuick);
         long start = System.nanoTime();
         quickSort.Quicksort(intensityQuick,0, intensityQuick.length-1);
         long finish = System.nanoTime();
         long timeElapsed1 = finish - start;
        
         System.out.println("After Quick..");
         printInputArray(intensityQuick);
         
         System.out.println("Intially.. before Insertion ");
         printInputArray(intensityInsertion);
         Q5bInsertionAditi insertobj= new Q5bInsertionAditi();
         start = System.nanoTime();
         insertobj.insertionSort(intensityInsertion);
          finish = System.nanoTime();
          long timeElapsed2 = finish - start;
          
         System.out.println("After Insertion..");
         printInputArray(intensityInsertion);
         
         
         
         System.out.println("Intially.. before TimSort array  ");
         printInputArray(intensityTim);
         Q5cTimSortAditi timobj= new Q5cTimSortAditi();
         start = System.nanoTime();
         timobj.timSort(intensityTim, intensityTim.length);
          finish = System.nanoTime();
          long timeElapsed3 = finish - start;
          
         System.out.println("After TimSort..");
         printInputArray(intensityInsertion);
         System.out.println("elapsed time in quick " + timeElapsed1);
         System.out.println("elapsed time in insertion " + timeElapsed2);
         
         
         
         System.out.println("elapsed time in tim " + timeElapsed3);
       
        
    } 
}
