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
public class Qnoooo6bRobinKarpAditi {

    public static void main(String[] args) {
        String text = "ABCADBABCBABABCDABCDABDE";
        System.out.println("Text =" + text);
        String pattern = "BAB";
        System.out.println("Pattern: " + pattern);
        System.out.println("Index of pattern starts at: " + search(text, pattern));

        text = "ABCADBABCBABABCDABCDABDE";

        pattern = "CBDEE";
        System.out.println("Text =" + text);

        System.out.println("Pattern: " + pattern);

        System.out.println("Index of pattern starts at: " + search(text, pattern));

    }

    
    
    
    
    public static int search(String t, String p) {
        int M = p.length();
        int N = t.length();
        int dM = 1, h1 = 0, h2 = 0;
        int q = 3;//3355439; // table size
        int d = 256; // radix
        for (int j = 1; j < M; j++) // precompute d^M % q
        {
            dM = (d * dM) % q;
        }
        for (int j = 0; j < M; j++) {
            h1 = (h1 * d + p.charAt(j)) % q; // hash of pattern
            h2 = (h2 * d + t.charAt(j)) % q; // hash of text
        }
        if (h1 == h2) {
            return 0; // match found
        }
        for (int i = M; i < N; i++) {
            h2 = (h2 - t.charAt(i - M)) % q; // remove high order digit
            h2 = (h2 * d + t.charAt(i)) % q; // insert low order digit
            if (h1 == h2) {
                return i - M; // match found
            }
        }
        return -1; // not found
    }

    // d is the number of characters in the input alphabet 
    public final static int d = 256;

    public static int search1(String pat, String txt, int q) {
        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern 
        int t = 0; // hash value for txt 
        int h = 1;

        // The value of h would be "pow(d, M-1)%q" 
        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first 
        // window of text 
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one 
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of text 
            // and pattern. If the hash values match then only 
            // check for characters on by one 
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        break;
                    }
                }

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1] 
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // Calculate hash value for next window of text: Remove 
            // leading digit, add trailing digit 
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + M)) % q;

                // We might get negative value of t, converting it 
                // to positive 
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
        return -1;
    }
}
