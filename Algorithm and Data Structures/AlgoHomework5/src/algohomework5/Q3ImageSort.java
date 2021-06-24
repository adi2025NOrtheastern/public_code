/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework5;

import java.io.File; 
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import javax.imageio.ImageIO;
//import stdlib.jar;
/**
 *
 * @author aditi
 */
public class Q3ImageSort {
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
        double[] intensityHeap= new double[width * height];
        double[] intensityMerge= new double[width * height];
                int h=0,m=0;
         for( int i=0;i<width;i++)
         {
             for(int j=0;j<height;j++)
             {
        int rgbA = img.getRGB(i,j); 
        int redA = (rgbA >> 16) & 0xff; 
        int greenA = (rgbA >> 8) & 0xff; 
        int blueA = (rgbA) & 0xff; 
        double I = 0.2989 * redA + 0.5870 * greenA+ 0.1140 * blueA;
        intensityHeap[h++]=I;
        intensityMerge[m++]=I;
        
             }
         }
        System.out.println("Intially.. heap ");
         printInputArray(intensityHeap);
         long start = System.nanoTime();
         heapSort(intensityHeap);
         long finish = System.nanoTime();
         long timeElapsed1 = finish - start;
        
         System.out.println("After heap..");
         printInputArray(intensityHeap);
         
         System.out.println("Intially.. before merge ");
         printInputArray(intensityMerge);
         start = System.nanoTime();
         mergeSort(intensityMerge,0,intensityMerge.length-1);
          finish = System.nanoTime();
          long timeElapsed2 = finish - start;
          
         System.out.println("After merge..");
         printInputArray(intensityMerge);
         System.out.println("elapsed time in heap " + timeElapsed1);
         System.out.println("elapsed time in merge " + timeElapsed2);
        //set the pixel value 
        //p = (a<<24) | (r<<16) | (g<<8) | b; 
        //img.setRGB(0, 0, p); 
        
        
        
  
        //write image 
      //  try
        { 
           // f = new File("C:\\OutHeap.jpg"); 
            
           // ImageIO.write(img, "jpg", f); 
            
            //f = new File("C:\\OutMerge.jpg"); 
            
            //ImageIO.write(img, "jpg", f); 
            
        } 
       // catch(IOException e) 
        { 
           // System.out.println(e); 
        } 
    } 
     
   
    static public void heapSort(double arr[]) {
      int n = arr.length; 
      
      for (int i = n / 2 - 1; i >= 0; i--) {
        heapify(arr, n, i);
      }  
      
      for (int i = n - 1; i >= 0; i--) {
        double temp = arr[0];
        arr[0] = arr[i];
        arr[i] = temp;         
        heapify(arr, i, 0);
      }
    }
  
   static void heapify(double arr[], int n, int i) {
      
      int largest = i;
      int l = 2 * i + 1;
      int r = 2 * i + 2;
  
      if (l < n && arr[l] > arr[largest])
        largest = l;
  
      if (r < n && arr[r] > arr[largest])
        largest = r;
       
      if (largest != i) {
        double swap = arr[i];
        arr[i] = arr[largest];
        arr[largest] = swap;  
        heapify(arr, n, largest);
      }
    }
  
    static void printInputArray(double arr[]) {
      int n = arr.length;
      for (int i = 0; i < n; ++i){
        System.out.print(arr[i] + " ");
      }
      System.out.println();
    }
  
    public static void mergeSort(double arr[], int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;
            mergeSort(arr, left, m);
            mergeSort(arr, m + 1, right);
            merge(arr, left, m, right);
        }
    }
   
   public static void merge(double arr[], int leftIndex, int mid, int rightIndex) {

        int a2 = rightIndex - mid;
        double right[] = new double[a2];
        
        int a1 = mid - leftIndex + 1;        
        double left[] = new double[a1];
        
        for (int j = 0; j < a2; ++j) {
            right[j] = arr[mid + 1 + j];
        }
        
        for (int i = 0; i < a1; ++i) {
            left[i] = arr[leftIndex + i];
        }
        
        int i = 0, j = 0,k = leftIndex;
        while (i < a1 && j < a2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < a1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < a2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    
  }



