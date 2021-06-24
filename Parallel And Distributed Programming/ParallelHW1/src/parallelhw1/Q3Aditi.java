
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aditi
 */
/*

3. Create file Data.txt and add this line: 
“Temperature is Sunny but cold 30 degrees tomorrow”. 
Write a program that reads text line from file using BufferedReader and 
FileReader:  
	a) print it on the console
	b) add it to a list
	c) read it from the list and change it to lower-case
	d) count the number of strings
	e) count the number of letters
	e) add it to hashMap with key/value (string, frequency) 
		Note: first use HashSet to get frequencies, 
	f) sort the map using TreeMap
	g) iterate through the map and print and provide Catch clause
	   for FileNotFoundException (file not found), and  IOException (invalid file).


*/
public class Q3Aditi {
    public static void main(String[] args) {
        try {
            System.out.println("Reading using BufferedReader..");
            BufferedReader br;
            br = new BufferedReader(new FileReader("Data.txt"));
            //Reading
            String line = br.readLine();
            System.out.println("Printing...");
            System.out.println(line);
            List<String> list = new ArrayList<>();
            //add to list
            list.add(line);
            //readfrom list and change to lower case
            String lowerLine =  list.get(0).toLowerCase();
            System.out.println("To lower case-> " + lowerLine);
            //count the number of Strings
            String[] token = line.split(" ");
            System.out.println("Number of Strings : "+ token.length);
            //count number of letters
            int count =0;
            for(String s : token)
            {
                count+= s.length();
            }
            System.out.println("Number of Letters: "+ count);
            //add it to hashMap with key/value (string, frequency) before this count frequency using set
            Set<String> set = new HashSet<>(Arrays.asList(token));
            System.out.println("HashSet contents: "+ set);
            Map<String,Integer> map = new HashMap<>();
            for(String s: set)
            {
                //map.put(s, map.getOrDefault(s, 0) + 1);
              map.put(s, Collections.frequency(Arrays.asList(token), s))  ;
            //System.out.println(s + ": " + Collections.frequency(list, s));
       
            }
            System.out.println("Printing Hashmap: "+ map);
            
            //) sort the map using TreeMap
            Map<String,Integer> treeMap = new TreeMap<>(map);
            
            //iterate through the map and print
            System.out.println("Printing TreeMap..");
            for(Map.Entry<String,Integer> me: treeMap.entrySet())
            {
                System.out.println("key: "+ me.getKey() + " value: "+me.getValue());
            }
            System.out.println("Printing TreeMap on lowercase strings..");
            //System.out.println(lowerLine);
            map.clear();
            List<String> a = Arrays.asList(lowerLine.split(" "));
            for(String s: a){
                map.put(s, map.getOrDefault(s,0)+1);
            }
                
            Map<String,Integer> treeMap1 = new TreeMap<>(map);
            
            for(Map.Entry<String,Integer> me: treeMap1.entrySet())
            {
                System.out.println("key: "+ me.getKey() + " value: "+me.getValue());
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Q3Aditi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("File not found!");
            System.out.println(ex);
        } catch (IOException ex) {
            Logger.getLogger(Q3Aditi.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Invalid file!");
        }
    }
}
