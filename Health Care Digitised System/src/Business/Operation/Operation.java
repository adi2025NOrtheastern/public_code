/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Operation;

import Business.Bed.Bed;
import Business.Employee.Employee;
import Business.Patient.Patient;
import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author aditi
 */
public class Operation {
    private int operationNumber;
    private String operationDate;
    private String operationDescription;
    private double operationCharge;
    private String status; //new -by doctor, success - by doctor, on-going, scheduled- by nurse after bed confirmation
    private String oprType;
    private Patient patient;
    private Employee doctor;
    private Employee person;  // for nurse??
    private static int count =0;
    private Bed bedAssigned;

    public String getOprType() {
        return oprType;
    }

    public void setOprType(String oprType) {
        this.oprType = oprType;
    }
    

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Operation.count = count;
    }

    public Bed getBedAssigned() {
        return bedAssigned;
    }

    public void setBedAssigned(Bed bedAssigned) {
        this.bedAssigned = bedAssigned;
    }
    
    public Operation()
    {
        this.operationNumber= ++count;
        this.status= "New";
        this.bedAssigned= null;
        //this.bedAssigned
    }
    

    public String getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(String operationDate) {
        this.operationDate = operationDate;
    }

    public String getOperationDescription() {
        return operationDescription;
    }

    public void setOperationDescription(String operationDescription) {
        this.operationDescription = operationDescription;
    }

    public double getOperationCharge() {
        return operationCharge;
    }

    public void setOperationCharge(double operationCharge) {
        this.operationCharge = operationCharge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Employee getDoctor() {
        return doctor;
    }

    public void setDoctor(Employee doctor) {
        this.doctor = doctor;
    }

    public int getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(int operationNumber) {
        this.operationNumber = operationNumber;
    }

    public Employee getPerson() {
        return person;
    }

    public void setPerson(Employee person) {
        this.person = person;
    }
    
    
    public enum OperationType{
        Surgery("Surgery"),
        Biopsy("Biospy"),
        Skin("Skin"),
        Cataract("Cataract"),
        Heart("Heart"),
        Lung("Lung"),
        Kidney("Kidney"),
        Hernia("Hernia"),
        Fracture("Fracture"),
        Other("Other");
        
        private String value;
        private OperationType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    
     public enum OperationStatus{
        WaitingConfirmation("Waiting Confirmation"),
        BedAssigned("Bed Assigned"),
        Completed("Completed"),
        Other("Other");
        
        private String value;
        private OperationStatus(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    
    
}
