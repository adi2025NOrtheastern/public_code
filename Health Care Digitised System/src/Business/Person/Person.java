/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

/**
 *
 * @author raunak
 */
public class Person {  //dont use
    
    private String name;
    private int id;
    private static int count = 1;
    private String phoneNum;
    private String emailID;
    //private double visitingCharge;

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    
    
    public Person() {
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
    
    
}
