/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework3;

import java.util.Stack;

/**
 *
 * @author aditi
 */
public class Q6InfixEvaluateAditi {

    public static int precedence(String c) {
        if (c.equals("+") || c.equals("-")) {
            return 1;
        }
        if (c.equals("*") || c.equals("/")) {
            return 2;
        }
        return 0;
    }

    public static double operate(double d2, double d1, String s) {
        double d=0;
        switch (s) {
            case "+":
                d = d2 + d1;
                break;
            case "-":
                d = d2 - d1;
                break;
            case "*":
                d = d2 * d1;
                break;
            case "/":
                d = d2 / d1;
                break;
        }
        return d;
    }

    
    
     
    
    public static double evaluate(String input) {
        //StackGenericLLAditi<String> ops = new StackGenericLLAditi<String>();
        //StackGenericLLAditi<Double> vals = new StackGenericLLAditi<Double>();
        Stack<String> ops = new Stack<>();
        Stack<Double> vals= new Stack<>();
        for (String s : input.split(" ")) {
            System.out.println("s is " +s);
            if (s.equals("(")) {
                ops.push(s);
                System.out.println("push (");
            }
            else if (Character.isDigit(s.charAt(0))) {
                vals.push(Double.parseDouble(s));
                System.out.println("push val-" + s);
            } else if (s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")) {
                if (ops.isEmpty()) {
                    ops.push(s);
                    System.out.println("push ops");
                } else {

                    int pre = precedence(s);
                    String top = ops.pop();
                    int pretop = precedence(top);
                    if (pretop > pre) {
                        String top2 = top;
                        while (pretop > pre) {
                            double d1 = vals.pop();
                            double d2 = vals.pop();
                            d2 = operate(d2, d1, top);
                            vals.push(d2);
                            System.out.println("push "+ d2);
                            top2 = ops.pop();
                            pretop = precedence(top2);
                        }
                        ops.push(top2);
                        System.out.println("push " + top2);
                        ops.push(s);
                         System.out.println("push " + s);
                    } else {
                        ops.push(top);
                        ops.push(s);
                         System.out.println("push " + top);
                          System.out.println("push " + s);
                    }
                }

            } else if (s.equals(")")) {
                String op = ops.pop();
                while (!"(".equals(op)) {
                    /*if (op.equals("+")) {
                        vals.push(vals.pop() + vals.pop());
                        
                    } else if (op.equals("*")) {
                        vals.push(vals.pop() * vals.pop());
                    } else if (op.equals("-")) {
                        vals.push(vals.pop() - vals.pop());
                    } else if (op.equals("/")) {
                        vals.push(vals.pop() / vals.pop());
                    }*/
                    double d1 = vals.pop();
                            double d2 = vals.pop();
                            d2 = operate(d2, d1, op);
                            vals.push(d2);
                            System.out.println("push " + d2);
                    op = ops.pop();
                    //System.out.println("op is-" + op);
                }
            }
            System.out.println("Operator stack- "+ops.toString());
            System.out.println("Operand Stack- "+vals.toString());
            //else vals.push(Double.parseDouble(s));
        }
        while (!ops.isEmpty()) {
            String op = ops.pop();
            /*if (op.equals("+")) {
                vals.push(vals.pop() + vals.pop());
            } else if (op.equals("*")) {
                vals.push(vals.pop() * vals.pop());
            } else if (op.equals("-")) {
                vals.push(vals.pop() - vals.pop());
            } else if (op.equals("/")) {
                vals.push(vals.pop() / vals.pop());
            }*/
            double d1 = vals.pop();
                            double d2 = vals.pop();
                            d2 = operate(d2, d1, op);
                            vals.push(d2);
                            System.out.println("push " + d2);
            
            //op = ops.pop();
        }
        return vals.pop();
    }

    
    public static String evaluateString(String input) {
        //StackGenericLLAditi<String> ops = new StackGenericLLAditi<String>();
        //StackGenericLLAditi<Double> vals = new StackGenericLLAditi<Double>();
        Stack<String> ops = new Stack<>();
        Stack<String> vals= new Stack<>();
        for (String s : input.split(" ")) {
            System.out.println("s is " +s);
            if (s.equals("(")) {
                ops.push(s);
                System.out.println("push (");
            }
            else if (Character.isAlphabetic(s.charAt(0))) {
                vals.push((s));
                System.out.println("push val-" + s);
            } else if (s.equals("+") || s.equals("*") || s.equals("/") || s.equals("-")) {
                if (ops.isEmpty()) {
                    ops.push(s);
                    System.out.println("push ops");
                } else {

                    int pre = precedence(s);
                    String top = ops.pop();
                    int pretop = precedence(top);
                    if (pretop > pre) {
                        String top2 = top;
                        while (pretop > pre) {
                            String d1 = vals.pop();
                            String d2 = vals.pop();
                            d2 = d2 +" "+ top +" "+ d1;
                            vals.push(d2);
                            System.out.println("push "+ d2);
                            if(!ops.isEmpty())
                            {top2 = ops.pop();
                            pretop = precedence(top2);
                            if(pretop==pre)
                            {
                                ops.push(top2);
                            }
                            }
                            else { break;}
                        }
                        //ops.push(top2);//---here
                        //System.out.println("push " + top2);
                        //ops.push(top2);
                        ops.push(s);
                         System.out.println("push " + s);
                    } else {
                        ops.push(top);
                        ops.push(s);
                         System.out.println("push " + top);
                          System.out.println("push " + s);
                    }
                }

            } else if (s.equals(")")) {
                String op = ops.pop();
                while (!"(".equals(op)) {
                    /*if (op.equals("+")) {
                        vals.push(vals.pop() + vals.pop());
                        
                    } else if (op.equals("*")) {
                        vals.push(vals.pop() * vals.pop());
                    } else if (op.equals("-")) {
                        vals.push(vals.pop() - vals.pop());
                    } else if (op.equals("/")) {
                        vals.push(vals.pop() / vals.pop());
                    }*/
                    String d1 = vals.pop();
                            String d2 = vals.pop();
                            d2 = d2 +" "+ op+" " + d1;
                            vals.push(d2);
                            System.out.println("push " + d2);
                    op = ops.pop();
                    //System.out.println("op is-" + op);
                }
            }
            //else vals.push(Double.parseDouble(s));
            System.out.println("Operator stack- "+ops.toString());
            System.out.println("Operand Stack- "+vals.toString());
        }
        while (!ops.isEmpty()) {
            String op = ops.pop();
            /*if (op.equals("+")) {
                vals.push(vals.pop() + vals.pop());
            } else if (op.equals("*")) {
                vals.push(vals.pop() * vals.pop());
            } else if (op.equals("-")) {
                vals.push(vals.pop() - vals.pop());
            } else if (op.equals("/")) {
                vals.push(vals.pop() / vals.pop());
            }*/
            String d1 = vals.pop();
                            String d2 = vals.pop();
                            d2 = d2 +" "+ op+" " + d1;
                            vals.push(d2);
                            System.out.println("push " + d2);
            
            //op = ops.pop();
        }
        return vals.pop();
    }
    
    
    public static void main(String[] args) {

        String input1 = "( A + B ) * C + D / ( E + F * G ) - H";
        String input2 = "( 300 + 23 ) * ( 43 - 21 ) / ( 84 + 7 )";
        String input3 = "( 4 + 8 ) * ( 6 - 5 ) / ( ( 3 - 2 ) * ( 2 + 2 ) )";
        
        System.out.println("For input "+input2 + "output -> " + evaluate(input2) );
        System.out.println("For input "+input3 + "output -> " + evaluate(input3) );
        System.out.println("For input "+input1 + "output -> " + evaluateString(input1) );
    }
}
