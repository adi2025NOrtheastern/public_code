/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PharmacyWorkerMainWorkArea;

import userinterface.LabTechnicianRole.*;
import Business.Appointment.Appointment;
import Business.Appointment.Prescription;
import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LabEnterprise.Lab;
import Business.Enterprise.LabEnterprise.LabTest;
import Business.Enterprise.PharmacyEnterprise.Pharmacy;
import Business.Medicine.Medicine;
import Business.Organization.LabOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.Type.Lab;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import Business.Utility.Validation;
import Business.WorkQueue.DoctorWorkRequest;
import Business.WorkQueue.PharmacyWorkRequest;
import Business.WorkQueue.LabTestWorkRequest;
import Business.WorkQueue.ReceptionistWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.NurseRole.NurseWorkAreaJPanel;

/**
 *
 * @author raunak
 */
public class PharmacyWorkerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private LabOrganization labOrganization;
   // private LabTest labTest;
    private Employee labTechnician;
    private Appointment appointment;
    private Patient patient;
    private WorkRequest request;
    private Enterprise enterprise;
    /**
     * Creates new form LabAssistantWorkAreaJPanel
     */
    public PharmacyWorkerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business, WorkRequest request, Enterprise enterprise)
    {  initComponents();
        
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.business = business;
        //this.labOrganization = (LabOrganization)organization;
       // this.labTest = labTest;
        //this.labTechnician = labTechnician;
        this.appointment = ((PharmacyWorkRequest)request).getAppointment();
        this.request=request;
        this.enterprise = enterprise;
        populatecbox();
        populateMedicine();
        //populateTable();
        
        technicianNameTxt.setEditable(false);
        technicianNameTxt.setText(userAccount.getEmployee().getName());
        totalPriceTxt.setEditable(false);
        Date date = new Date();
     // String timeFormatString = "hh:mm:ss a";
      //DateFormat timeFormat = new SimpleDateFormat(timeFormatString);
      //String currentTime = timeFormat.format(date);
     // System.out.println("Current time: "+currentTime);
      String dateFormatString = "YYYY-MM-dd";
      DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
      String currentDate = dateFormat.format(date);
      //System.out.println("Current date: "+currentDate);
      
        
      //  if(labTest.getStatus().equals("Completed"))
     //   {
     //       cmbStatusType.setSelectedIndex(1);
     //       cmbStatusType.setEnabled(false);
     //   }
    //    txtDrRemarks.setText(request.getMessage());
    }
    
    
     public void populateMedicine(){
         DefaultTableModel model = (DefaultTableModel) medicineQuantityTbl.getModel();
        model.setRowCount(0);
        Double totalPrice = 0.0;
        for (Map.Entry<Medicine, Integer> entry : appointment.getPrescription().getMedicineListquanity().entrySet()){
         Object[] row = new Object[5];
            row[0] = entry.getKey();
            row[1] = entry.getValue();
            Medicine medicine = null;
            for(Medicine med : ((Pharmacy) enterprise).getMedicineList().getMedicineList()){
                if(med.equals(entry.getKey())){
            row[2] = med.getPrice();       
               medicine = med;
                    break;
                }
            }
            if(medicine == null){   
            }
            else{
            row[3] = entry.getValue() * medicine.getPrice();
            totalPrice += entry.getValue() * medicine.getPrice();
            }
            row[4] = appointment.getPrescription().getPhmacy().getName();
            model.addRow(row);
            
    }
        totalPriceTxt.setText(String.valueOf(totalPrice));
    }

    
    
    
     public void populatecbox(){
        cmbStatusType.removeAllItems();
         cmbStatusType.addItem("Select");
        //for (Appointment.AppointmentStatus type : Appointment.AppointmentStatus.values()){
            cmbStatusType.addItem("Processed");
           
        //}
    }
     
//    public void populateTable(){
//        DefaultTableModel model = (DefaultTableModel)labTestTbl.getModel();
//        
//        model.setRowCount(0);
//        
//        for(WorkRequest request : labOrganization.getWorkQueue().getWorkRequestList()){
//            Object[] row = new Object[4];
//            row[0] = request;
//            row[1] = request.getSender().getEmployee().getName();
//            row[2] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
//            row[3] = request.getStatus();
//            
//            model.addRow(row);
//        }
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        technicianNameTxt = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        cmbStatusType = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        medicineQuantityTbl = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        totalPriceTxt = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, -1, -1));

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Status :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, -1, 20));
        add(technicianNameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 160, 30));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, -1, -1));

        cmbStatusType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbStatusType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatusTypeActionPerformed(evt);
            }
        });
        add(cmbStatusType, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 160, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BillingPayment.PNG"))); // NOI18N
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, 290, 180));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Worker Name :");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, -1, 20));

        medicineQuantityTbl.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        medicineQuantityTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Medicine Name", "Quantity", "Unit Price", "Total Price", "Pharmacy Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(medicineQuantityTbl);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 720, 180));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Total Price :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 90, -1));

        totalPriceTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPriceTxtActionPerformed(evt);
            }
        });
        add(totalPriceTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 160, -1));

        jPanel14.setBackground(new java.awt.Color(232, 201, 232));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 91, Short.MAX_VALUE)
        );

        add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel13.setBackground(new java.awt.Color(96, 83, 150));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Order Completion");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 270, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
       
        
         userProcessContainer.remove(this);
        Component[] componentArray =userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PharmacyMainWorkAreaJPanel sysAdminwajp = (PharmacyMainWorkAreaJPanel) component;
        sysAdminwajp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
               try{
                   //String testName = testNameTxt.getText();
                   int index = cmbStatusType.getSelectedIndex();
                   if(index==0)
                   {
                       JOptionPane.showMessageDialog(null, "Please select Status!");
            return;
                   }
                   
                   
                   /*if(labTest.getStatus() != null && labTest.getStatus().equals("Completed"))
                           {
                               JOptionPane.showMessageDialog(null, "Lab test is already completed!");
            return; 
                           }*/
                   
           Date date1=new Date();        
                   String dateFormatString = "YYYY-MM-dd";
      DateFormat dateFormat = new SimpleDateFormat(dateFormatString);
      String currentDate = dateFormat.format(date1);
       
        try{   SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd");
         date1=formatter1.parse("2020-12-15");
        }
        catch(ParseException ex)
        {
            JOptionPane.showMessageDialog(null, "Please enter date properly!");
            return;
        }
        
        Prescription prescription = appointment.getPrescription();
        prescription.setStatus("Processed");
        prescription.setAmount(Double.parseDouble(totalPriceTxt.getText()));
        //labTest.setStatus("Completed");
        //labTest.setTestCharge(testCharge);
        //String technicianName = technicianNameTxt.getText();
        //if(testName.equals("") || testDate.equals("") || technicianName.equals(""))
//       Appointment app= appointment; //(Appointment)cmbStatusType.getSelectedItem();
       //to do work request to send to doctor
        //add in work queue for assigned doctor
       
        //ReceptionistWorkRequest lwr = ((PharmacyWorkRequest)(request));//.getPatient()
        
        request.setResolveDate(date1);
        //drWorkReq.setPatient(lwr.getPatient());
        //drWorkReq.setAppointment(lwr.getAppointment());
       // drWorkReq.setRequestDate(new Date());
        //drWorkReq.setResolveDate(new Date());
        //drUserAcc.getWorkQueue().getWorkRequestList().add(drWorkReq);
        JOptionPane.showMessageDialog(null, "Medicines provided.", "Information", JOptionPane.INFORMATION_MESSAGE);
       // txtPatientName.setText("");
       // txtAppointmetDate.setText("");
        //txtAppointmentType.setSelectedIndex(0);
       // cmbDoctor.setSelectedIndex(0);
       
       
       request.setStatus("Complete");
       
       
       
       
       //
      // DefaultTableModel dtm = (DefaultTableModel)labTestTbl.getModel();
       //dtm.setRowCount(0);        
       //for (Appointment.AppointmentStatus type : Appointment.AppointmentStatus.values()){
      /*      Object[] row = new Object[6];
            row[0]= labTest.getName();
            row[1]= labTest.getTestCharge();
            row[2]= currentDate;
            row[3]= labTest.getLabTechnician().getName();
            row[4]= cmbStatusType.getSelectedItem();
            row[5]= appointment.getPatient().getName();
            dtm.addRow(row);*/
        //}
        
        
        //send report to doctor email
      // //Validation.sendEmailAttachment(request.getSender().getEmployee().getEmailID(),"Reports for patient",
         //      "Please find reports attached",lblFileUpload.getText());
        
        
       }
       catch (Exception e)
       {
           JOptionPane.showMessageDialog(null, "Please fill in all fields properly");
       }
       
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void cmbStatusTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatusTypeActionPerformed
        //String str=String.valueOf(cmbStatusType.getSelectedItem());
    }//GEN-LAST:event_cmbStatusTypeActionPerformed

    private void totalPriceTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPriceTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalPriceTxtActionPerformed

   /* public void populatelabTestDetails(){
        DefaultTableModel model = (DefaultTableModel)labTestTbl.getModel();
        model.setRowCount(0);
        Object row[]=new Object[4];
            row[0] = labTest.getName();
            row[1] = labTest.getType();
            row[2] = labTest.getCreatedOn();
            row[3] = labTechnician.getName();
            row[4] = labTest.getStatus();
            model.addRow(row);
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox<String> cmbStatusType;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable medicineQuantityTbl;
    private javax.swing.JTextField technicianNameTxt;
    private javax.swing.JTextField totalPriceTxt;
    // End of variables declaration//GEN-END:variables
}
