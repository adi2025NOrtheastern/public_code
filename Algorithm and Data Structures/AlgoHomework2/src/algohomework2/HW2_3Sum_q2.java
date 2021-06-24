/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework2;

/**
 *
 * @author aditi
 */
public class HW2_3Sum_q2 {
 public static int func_3Sum(int[] a)
 {
 int N = a.length;
 int count = 0;
 for (int i = 0; i < N; i++)
 for (int j = i; j < N; j++)
 for (int k = j; k < N; k++)
 if (a[i] + a[j] + a[k] == 0)
 count++;
 return count;
 }
 public static void main(String[] args)
 {
 
 int[] a = {30, -40, -20, -10, 40, 0, 10, 5};
     System.out.println("Number of 3-sum pairs are : "+func_3Sum(a));
 }
}