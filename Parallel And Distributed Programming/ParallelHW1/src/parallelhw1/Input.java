/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parallelhw1;

/**
 *
 * @author aditi
 */
public class Input {
    int index;
    int[] input = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    public Input(){
        index = 0;
    }

    public void print(int index){
        System.out.println(input[index]);
    }

    synchronized public int getIndex(){
        if(index == 15)
            return -1;
        return index++;
    }
}

