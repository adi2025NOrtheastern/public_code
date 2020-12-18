/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Medicine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aditi
 */
public class MedicineDirectory {
    
    
    List<Medicine> medicineList;

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }
    
    
    public MedicineDirectory(){
        medicineList= new ArrayList<>();
    }
    
    
    
}
