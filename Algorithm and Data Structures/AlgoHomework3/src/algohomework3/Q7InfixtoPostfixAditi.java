/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q7InfixtoPostfixAditi {
    
  static  int   precedence(char c){
        if(c=='+'|| c=='-') return 1;
        else if(c=='*' || c=='/') return 2;
        else return 0;
    }
    private static String calculatePostFix(String number1, String number2, String str){
        String a;
            
                if(str.charAt(0)=='+'){
                    a = number1 +number1 +"+";
                    
                }else if(str.charAt(0)=='-'){
                    a= number1+number2+"-" ;
                    
                }else if(str.charAt(0)=='*'){
                    a = number1 +number2+"*";
                    
                }else{
                    a = number1 +number2+"/";
                   
        }
        return a;
    }
    
       
    private static List<String> evaluateString(String s){
        Stack<Character> stack = new Stack<>();
        List<String> expList = new ArrayList<>();
        boolean flag = false;
        for(int i=0;i<s.length();i++){
            char word = s.charAt(i);
            System.out.println("word -"+word);
            if(word==' '){
                continue;
            }
            if(word=='('){
                stack.push(word);
                flag = false;
            }else if(word=='+' || word=='-' || word=='*' || word=='/'){
                flag = false;
                if(stack.isEmpty()){
                    stack.push(word);
                }
                else{
                    int prec= precedence(word);
                    char top= (stack.peek());
                    int prec2=precedence(top);
                    if(prec>prec2)
                    {
                        //stack.push(top);
                        stack.push(word);
                }
                    else{
                        while(!stack.isEmpty() && precedence(stack.peek())>=precedence(word)){
                        expList.add(stack.pop()+"");
                    }
                    stack.push(word);
                }
            }
            }
            else if(word==')'){
                flag = false;
                while(!stack.isEmpty()){
                    if(stack.peek()=='('){
                        stack.pop();
                        break;
                    }else{
                        expList.add(stack.pop()+"");
                    }
                }
            }
            else{
                expList.add(word+"");
            }
               /* else{
                    while(!stack.isEmpty() && precedence(stack.peek())>=precedence(word)){
                        expList.add(stack.pop()+"");
                    }
                    stack.push(word);
                }*/
               System.out.println("Stack is-> " +stack.toString());
               System.out.println("List is-> " + expList.toString());
            }
        
        while(!stack.isEmpty()){
            expList.add(stack.pop()+"");
        }
        return expList;
    }

    public static void main(String[] args) {
        String input = "A * B / C + ( D + E - ( F * ( G / H ) ) )";
        List<String> output=evaluateString(input);
        System.out.println("answer--> " );
        for(String a: output){
            System.out.print(a);
        }
    }
/**
 *
 * @author aditi
 */

    
}
