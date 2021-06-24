/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.parallelhw6.q3.partc;

/**
 *
 * @author aditi
 */
import java.io.Serializable;
import java.math.BigDecimal;

public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private BigDecimal salary;

    Employee(String generateRandomName, int generateRandomAge, BigDecimal generateRandomSalary) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
       this.name = generateRandomName;
       this.age = generateRandomAge;
       this.salary = generateRandomSalary;
       
    }

    //getters, setters n etc...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

}
