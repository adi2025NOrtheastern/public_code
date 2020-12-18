/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Appointment;

import Business.Patient.Patient;
import Business.Person.Person;
import java.util.Date;

/**
 *
 * @author preranaurs
 */
public class PatientHistoryDetails {
    private String medAlergies;
    private Patient patient;
    private String previousDiagnosis;
    private Person person;
    private Date createdOn;
    private String surgeryHistory;
    private String familyHistory;
    private String alergy;
    private int id;
    private static int count=10;
    
    public int getId() {
        return id;
    }

    
    public PatientHistoryDetails()
    {
        this.id = id + ++count;
    }
    
    @Override 
    public String toString(){
        return String.valueOf(this.id);
    }

    public String getAlergy() {
        return alergy;
    }

    public void setAlergy(String alergy) {
        this.alergy = alergy;
    }

    public String getSurgeryHistory() {
        return surgeryHistory;
    }

    public void setSurgeryHistory(String surgeryHistory) {
        this.surgeryHistory = surgeryHistory;
    }

    public String getFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(String familyHistory) {
        this.familyHistory = familyHistory;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public String getMedAlergies() {
        return medAlergies;
    }

    public void setMedAlergies(String medAlergies) {
        this.medAlergies = medAlergies;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPreviousDiagnosis() {
        return previousDiagnosis;
    }

    public void setPreviousDiagnosis(String previousDiagnosis) {
        this.previousDiagnosis = previousDiagnosis;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
