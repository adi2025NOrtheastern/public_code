/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author raunak
 */
public class PersonDirectory {
    
    private ArrayList<Employee> employeeList;

    public PersonDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee createEmployee(String name){
        Employee employee = new Employee();
        employee.setName(name);
        employeeList.add(employee);
        return employee;
    }
    
    public void removeEmployee(Employee e)
    {
        employeeList.remove(e);
    }
    
    
    public List<Employee> getDoctorList(){
        List<Employee> doctorList= null;
        if(employeeList != null || !(employeeList.isEmpty()) )
        {
           for(Employee emp : employeeList){
           //match a doctor role
           if(emp.getRole().equals("Doctor Role")){
               doctorList.add(emp);
           }
           
       }
            
        }
        return doctorList;
    }
    
    
    public List<Employee> getNurseList(){
        List<Employee> nurseList= null;
        if(employeeList != null || !(employeeList.isEmpty()) )
        {
           for(Employee emp : employeeList){
           //match a doctor role
           if(emp.getRole().equals("Nurse Role")){
               nurseList.add(emp);
           }
           
       }
            
        }
        return nurseList;
    }
    
}