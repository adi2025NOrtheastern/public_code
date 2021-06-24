package algohomework4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aditi
 */
public class TOHAditi {
  
    public static void towerOfHanaoi(int disc, String start, String intermediate, String end) {
        if (disc == 1) {
           System.out.println("Moving disk 1 from " + start + " to " + end);
        } else {
           towerOfHanaoi(disc - 1, start, end, intermediate);
           System.out.println("Moving disk " + disc + " from " + start + " to " + end);
           towerOfHanaoi(disc - 1, intermediate, start, end);
        }
     }

   public static void main (String[] args)
   {
      int n = 6;  

      towerOfHanaoi(6, "A", "B", "C");
   }
}

