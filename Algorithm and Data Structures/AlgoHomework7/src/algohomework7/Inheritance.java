/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algohomework7;

/**
 *
 * @author aditi
 */
public class Inheritance {
    
    public static void main(String[] args) {
        Shape s= new Rect(10,20);
        Shape s2= new Square(2);
        System.out.println(s.area());
        System.out.println(s2.area());
    }
}

class Shape{
    int i;
    public int area(){
        return 0;
    }
}


class Rect extends Shape{
    int l;
    int b;

    public Rect(int i, int i0) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        l=i;
                b=i0;
    }
public int area(){
        return l*b;
    }
}

class Square extends Shape{
    int i;

    public Square(int i) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   this.i=i;
    
    }
    public int area(){
        return i*i;
    }
}