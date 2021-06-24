/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework10;

/**
 *
 * @author aditi
 */
public class Q6aBruteforceAditi {
    public static void main(String[] args) {
        String text="ABCADBABCBABABCDABCDABDE";
        System.out.println("Text ="+ text);
        String pattern="BAB";
        System.out.println("Pattern: "+ pattern);
        System.out.println("Index of pattern starts at: " +bruteForceSearch(text,pattern));
        
        
         text="ABCADBABCBABABCDABCDABDE";
        
         pattern="CBDEE";
         System.out.println("Text ="+ text);
        
        System.out.println("Pattern: "+ pattern);
         if(bruteForceSearch(text,pattern) == -1)
         {
              System.out.println("Not found"   );
         }
         else{
        System.out.println("Index of pattern starts at: " +bruteForceSearch(text,pattern));
        
    }
       
    }
    
    public static int bruteForceSearch(String text, String pattern){
 
		int textLen = text.length();
		int patternlen = pattern.length();
                System.out.println("text length"+ textLen);
                System.out.println("pattern length" + patternlen);
		for( int i = 0; i <= textLen - patternlen ; i++){
 
			int j;
 
			for( j=0;j<patternlen;j++){
				if( text.charAt(i+j) != pattern.charAt(j)){
					break;
				}
			}
 
			if( j == patternlen ) return i;
		}
 
		return -1;
}
}
