/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aditi
 */
public class Q10JAVA {
   //  Public class reverse {
    public static void main(String[] args) {
        int[][] array = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 }
        };
        int rows = array.length;
        int cols = array[0].length;
        int[][] reverse = new int[rows][cols];
        for(int i = rows-1; i >= 0; i--) {
            for(int j = cols-1; j >= 0; j--) {
                reverse[rows-1-i][cols-1-j] = array[i][j];
            }
        }
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(reverse[i][j]);
                if(j < cols-1)
                    System.out.print(", ");
            }
            System.out.println();
        }
    } }

//}
