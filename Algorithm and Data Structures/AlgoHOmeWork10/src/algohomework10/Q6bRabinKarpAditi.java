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
public class Q6bRabinKarpAditi {
    
    public static void main(String[] args) {
        String text = "ABCADBABCBABABCDABCDABDE";
        System.out.println("Text =" + text);
        String pattern = "BAB";
        System.out.println("Pattern: " + pattern);
        System.out.println("Index of pattern starts at: " + rabinKarpsearch(text, pattern));

        
        
        text = "ABCADBABCBABABCDABCDABDE";

        pattern = "CBDEE";
        System.out.println("Text =" + text);

        System.out.println("Pattern: " + pattern);

         System.out.println("Index of pattern starts at: " + rabinKarpsearch(text, pattern));

         
         text="aabaaaaaaaaaaaaaaaaabaaac" ;
         pattern="aaaaaaaaaaaaaaaaabaaac";
          System.out.println("Index of pattern starts at: " + rabinKarpsearch(text, pattern));

    }
    
    
  public static int rabinKarpsearch(String text, String pattern) {
    if (text == null || pattern == null || pattern.length() > text.length()) {
      return -1;
    }

    if (text.equals(pattern)) {
      return 0;
    }

    HashClass n = new HashClass(pattern, pattern.length());
    HashClass h = new HashClass(text, pattern.length());
    
    int idx = -1;
    for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
      if (n.hash == h.hash) {
        if (text.substring(h.start, h.end).equals(pattern)) {
          idx = i;
          break;
        }
      }
      h.moveWindow();
    }
    return idx;
  }

  private static final class HashClass {
    private static final int MOD = (int) Math.pow(10, 9) + 7;
		
    private long hash;

    private final String s;

    private final long pow;
    
    private int start;

    private int end;



    
    void moveWindow() {
      if (end < s.length()) {
        this.hash = (hash - s.charAt(start) * pow % MOD + MOD) % MOD;
        this.hash = (hash * 101 % MOD + s.charAt(end)) % MOD;
        this.start++;
        this.end++;
      }
    }
   public  HashClass(String s, int size) {
      this.s = s;
      this.start = 0;
      this.end = size;
      int len = (end - start);
      long[] longpowArray = new long[size + 1];
      longpowArray[0] = 1;
      for (int i = 1; i <= size; i++) {
        longpowArray[i] = longpowArray[i - 1] * 101 % MOD;
      }
      pow = size > 0 ? longpowArray[size - 1] : 1;
      for (int i = start; i < end; i++) {
        this.hash += s.charAt(i) * longpowArray[len - i - 1];
        this.hash %= MOD;
      }
    }

    
  }
}