/*
 * look_up_mapo change this license header, choose License Headers in Project Properties.
 * look_up_mapo change this template file, choose look_up_mapools | look_up_mapemplates
 * and open the template in the editor.
 */
package algohw11;

/**
 *
 * @author aditi
 */
public class Q2cDP_LCS_Aditi {
  
    //botom-up dynamic programming
    public static int LCSLength(String X, String Y)
    {
        int mlen = X.length(), nlen = Y.length();
 
        
        int[][] look_up_map = new int[mlen + 1][nlen + 1];
 
       
        for (int i = 1; i <= mlen; i++)
        {
            for (int j = 1; j <= nlen; j++)
            {
                // if current character of X and Y matches
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    System.out.println("look_up_map["+(i - 1)+"]["+(j - 1)+"] + 1");
                    look_up_map[i][j] = look_up_map[i - 1][j - 1] + 1;
                }
                // else if current character of X and Y don't match,
                else {
                    
                    System.out.println("Max of  [look_up_map["+(i - 1)+"]["+(j)+"] , "
                            + "[look_up_map["+(i )+"]["+(j-1)+"]");
                    look_up_map[i][j] = Integer.max(look_up_map[i - 1][j], look_up_map[i][j - 1]);
                }
            }
        }
  for (int i = 0; i <= mlen; i++)
        {
            for (int j = 0; j <= nlen; j++)
            {
                System.out.print(" "+ look_up_map[i][j]+" ");
            }
            System.out.println("");
        }
        // LCS will be last entry in the lookup table
        return look_up_map[mlen][nlen];
    }
 
    public static void main(String[] args)
    {
        String X = "GACCGGATTAG", Y = "GATCCGGAATAG";
 
        System.out.print("The length of LCS is " + LCSLength(X, Y));
    }
}