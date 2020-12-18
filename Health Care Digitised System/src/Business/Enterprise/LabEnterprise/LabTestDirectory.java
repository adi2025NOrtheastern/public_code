/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise.LabEnterprise;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aditi
 */
public class LabTestDirectory {
    private List <LabTest> labTestList;

    public LabTestDirectory() {
        labTestList= new ArrayList<>();
        
        
    }

    public List<LabTest> getLabTestList() {
        return labTestList;
    }

    public void setLabTestList(List<LabTest> labTestList) {
        this.labTestList = labTestList;
    }
    
    public LabTest addLabTest(LabTest labTest){
       // LabTest labTest = new LabTest();
        labTestList.add(labTest);
        return labTest;
    }
}
