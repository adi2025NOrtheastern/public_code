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
public class User{
    private int id;
    private String firstName;
    private String lastName;       
    private String course ;
       
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getCourse() {
            return course;
        }

        public void setCourse(String course) {
            this.course = course;
        }
        
    @Override
    public String toString() { 
        if(this.firstName== null)
            return ("****MyStackError: Underflow- NO element!!**Empty Stack**");
        return (getId() + " " + getFirstName() + " " + getLastName() + " " + getCourse());
     
    } 
        
}