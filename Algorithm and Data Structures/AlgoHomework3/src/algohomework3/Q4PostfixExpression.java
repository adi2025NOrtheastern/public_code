/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework3;

/**
 *
 * @author aditi
 */
public class Q4PostfixExpression {
    public static void main(String[] args) {
        StackGenericLLAditi<Integer> s;
        s = new StackGenericLLAditi<>();
        
        String input="10 2 8 * + 3 -";
        System.out.println("input=\"10 2 8 * + 3 -\";");
        String a[]= input.split(" ");
        for(String i: a)
        {
            System.out.println("Evaluating : " + i);
            if(i.equals("*") )
            {
                int i1=s.pop();
                int i2=s.pop() ;
                i2=i2 * i1;
                s.push(i2);
                s.print();
            }
            else if(i.equals("+") )
            {
                int i1=s.pop();
                int i2=s.pop() ;
                i2=i2 + i1;
                s.push(i2);
                 s.print();
            }
            else if(i.equals("-") )
            {
                int i1=s.pop();
                int i2=s.pop() ;
                i2=i2 - i1;
                s.push(i2);
                 s.print();
            }
            else if(i.equals("/") )
            {
                int i1=s.pop();
                int i2=s.pop() ;
                i2=i2 / i1;
                s.push(i2);
                 s.print();
            }
            else{
                s.push(Integer.parseInt(i));
                 s.print();
            }
        }
        System.out.println("Result is: "+s.pop());
        
    }
}
