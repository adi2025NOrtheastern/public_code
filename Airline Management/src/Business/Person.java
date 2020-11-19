/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author aditi
 */
public class Person {
   
    private String fName;
    private String lName;
    private String role; //customer, crew, travelAgent
    private long moblieNum;
    //private String password;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getMoblieNum() {
        return moblieNum;
    }

    public void setMoblieNum(long moblieNum) {
        this.moblieNum = moblieNum;
    }
    
    public Person()
    {
        
    }
    
    public Person(String role)
    {
        this.role=role;
    }
    
    
}
