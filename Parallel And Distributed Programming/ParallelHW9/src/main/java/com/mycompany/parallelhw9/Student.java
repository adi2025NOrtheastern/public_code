/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw9;

/**
 *
 * @author aditi
 */
public class Student {
    String name;
    int id;
    int homework; 
    int quiz;
    int midterm;
    int project;
    int finaL;
    double total;
    String grade;
    static int nextId =1;
    
    public Student()
    {
        this.name = "Student"+nextId;
        id = nextId;
        nextId++;
       // System.out.println(this);
    }
    
    @Override
    public String toString(){
        return "ID:" + id + " Name : "+name +" homework " + homework 
                +" quiz " + quiz +" midterm " + midterm 
                +" project " +project +" final " +finaL + " total " + total  +"grade " + grade ;
    }
    
    String calculateGrade(){
        //20% homework, 20% quiz, 25% midterm, + 15% project, 20% final
        String grade = "";
        double total = (0.2 * homework + 0.2 * quiz + 0.25 * midterm + 0.15 * project + 0.2 * finaL) ;
        if(total >=90) grade = "A";
        else if (total>= 80 && total < 90) grade ="B";
        else if (total>= 70 && total < 80) grade ="C";
        else if (total>= 60 && total < 70) grade ="D";
       // else if (total>= 60 && total < 70) grade ="E";
        else if (total< 60) grade ="F";
        this.total = total;
        return grade;
    }
    
    
}
