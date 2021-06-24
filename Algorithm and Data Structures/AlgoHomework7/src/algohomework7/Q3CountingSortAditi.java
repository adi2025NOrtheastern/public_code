/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework7;
import java.util.Arrays;
/**
 *
 * @author aditi
 */
public class Q3CountingSortAditi {
 
  void countSort(char array[]) {
    int len = array.length;
    char[] output = new char[len +1];
    
    int max = array[0]-65;
    for (int i = 1; i < len; i++) {
      if ((array[i]-65) > max)
        max = array[i]-65;
    }
    int[] count = new int[max + 1];

    for (int i = 0; i < max; ++i) {
      count[i] = 0;
    }
    for (int i = 0; i < len; i++) {
      count[array[i]-65]++;
    }
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

      System.out.println("Before placing in output array");
      System.out.print("Output is-> ");
        printArrayChar(output);
        System.out.println("");
        System.out.print("Count is-> ");
        printArrayInt(count);
        System.out.println("");
    for (int i = len - 1; i >= 0; i--) {
      output[count[array[i]-65] - 1] = array[i];
      count[array[i]-65]--;
        System.out.print("Output is-> ");
        printArrayChar(output);
        System.out.println("");
        System.out.print("Count is-> ");
        printArrayInt(count);
        System.out.println("");
    }
    for (int i = 0; i < len; i++) {
      array[i] = output[i];
    }
  }

  void printArrayInt(int[] ar){
      for(int o: ar)
      System.out.print(o+" ,");
  }
  
  void printArrayChar(char[] ar){
      for(char o: ar)
      System.out.print(o+" |");
  }
  public static void main(String args[]) {
    char[] inputData = {'A','B','D','C','E','D','D','F','F','C','A','B','E','E','E','C','C','E','F','D','D','A','A','F' };
    Q3CountingSortAditi cs = new Q3CountingSortAditi();
    cs.countSort(inputData);
    System.out.println("After Sorting, Array is: ");
    for(char c: inputData)
          System.out.print(c+" ,");
  }
}
