/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.Appointment.Appointment;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.LabEnterprise.Lab;
import Business.Enterprise.LabEnterprise.LabTest;
import Business.Enterprise.LabEnterprise.LabTestDirectory;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Person.Person;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.LabTechnicianWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author preranaurs
 */
public class AssignLabTestJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AssignLabTestJPanel
     */
    private JPanel userProcessContainer;
    private Patient patient;
    private Person person;
    private Appointment appointment;
    private LabTestDirectory labTestList;
    private Lab lab;
    private Network network;
    private UserAccount userAccount;
    private Organization organization;
    private Date createdOn;
    private EcoSystem system;

    public AssignLabTestJPanel(JPanel userProcessContainer, Patient patient, Appointment appointment, Network network, UserAccount userAccount, Organization organization, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.patient = patient;
        this.appointment = appointment;
        this.labTestList = appointment.getLabTestList();
        this.network = network;
        this.userAccount = userAccount;
        this.organization = organization;
        this.system= system;
        populateNetworkLabs();
        populateLabTest();
    }

    void populateNetworkLabs() {
        cmbLabs.removeAllItems();;
        if(system.getNetworkList() == null)
        {
            return;
        }
        for(Network network1: system.getNetworkList())
        {
         

        List<Enterprise> enterprsList = network1.getEnterpriseDirectory().getEnterpriseList();
        if (enterprsList == null || enterprsList.isEmpty()) {
            //nothing
        } else {
            for (Enterprise enterprise : enterprsList) {
                if (enterprise.getEnterpriseType().getValue().equals(Enterprise.EnterpriseType.Lab.getValue())) {
                    {
                        cmbLabs.addItem(enterprise);
                    }
                }
            }

        }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        assignTestTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        testTypeTxt = new javax.swing.JTextField();
        cmbLabs = new javax.swing.JComboBox();
        submitBtn = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        assignTestTbl.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        assignTestTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Date", "Test Name", "Lab ", "Patient Name", "Test Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(assignTestTbl);
        if (assignTestTbl.getColumnModel().getColumnCount() > 0) {
            assignTestTbl.getColumnModel().getColumn(0).setResizable(false);
            assignTestTbl.getColumnModel().getColumn(1).setResizable(false);
            assignTestTbl.getColumnModel().getColumn(2).setResizable(false);
            assignTestTbl.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Assign Lab Test");

        jLabel2.setText("Test Name :");

        jLabel3.setText("Lab :");

        testTypeTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testTypeTxtActionPerformed(evt);
            }
        });

        cmbLabs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbLabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLabsActionPerformed(evt);
            }
        });

        submitBtn.setText("Submit");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/assignLabTest.PNG"))); // NOI18N

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(submitBtn)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(testTypeTxt)
                                .addComponent(cmbLabs, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(backJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(testTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbLabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(submitBtn)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void testTypeTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testTypeTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_testTypeTxtActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        String testType = testTypeTxt.getText();
        //String labName = cmbLabs.getActionCommand();

        //String medsPrescribed= medsPrescribedTxt.getText();
        if (testType.equals("")) {
            JOptionPane.showMessageDialog(null, "Test Name cannot be empty");
        }   else
        { LabTechnicianWorkRequest workreq = new LabTechnicianWorkRequest();
                workreq.setStatus("New");
                appointment.setStatus(Appointment.AppointmentStatus.MarkforTest.getValue());
                workreq.setMessage("New Patient for Lab test, please confirm a Test Date");
                workreq.setStatus("New");
                workreq.setAppointment(appointment);
                workreq.setMessage("Please conduct lab test!");
                workreq.setRequestDate(createdOn == null ? new Date() : createdOn);
                //workreq.setDoctorUserAccount(userAccount);
                workreq.setSender(userAccount);
                workreq.setPatient(patient);
                //workreq.setDoctor(doctor);
                //workreq.setReceiver(userAccount);
                Lab lab = (Lab) cmbLabs.getSelectedItem();
                lab.getWorkQueue().getWorkRequestList().add(workreq);
                LabTest labTest= new LabTest();
                labTest.setLab(lab);
                labTest.setLabTechnician(null);
                labTest.setPatient(patient);
                labTest.setName(testType);
                labTest.setDoctor(appointment.getDoctor());
                labTest.setStatus("New");
                //labTest.setType(testType);
                workreq.setLabTest(labTest);
                appointment.getLabTestList().addLabTest(labTest);
                appointment.setStatus(Appointment.AppointmentStatus.MarkforTest.getValue());
                //UserAccount recepUseracc = null;
                //List<UserAccount> userAccDir=  organization.getUserAccountDirectory().getUserAccountList();
                //List<UserAccount> nurseList = enterprise.getUserAccountDirectory().getUserAccountList();
                //workreq.setReceiver(lab.getUserAccountDirectory().getUserAccountList().get(0));
   }
        populateLabTest();
        //String medsPrescribed= medsPrescribedTxt.getText();
//        if (testType.equals("") || labName.equals("")) {
//            JOptionPane.showMessageDialog(null, "Fields cannot be empty");
//        } else {
//            LabTest labTest = labTestList.addLabTest();
//            labTest.setPatient(patient);
//            labTest.setType(testType);
//            labTest.setLab(lab);
//            //dateTxt.setText("");
//            testTypeTxt.setText("");
//            cmbLabs.setActionCommand(labName);
//            //medsPrescribedTxt.setText("");
//            //appointment.setLabTestList(labTestList);
//            JOptionPane.showMessageDialog(null, "Lab test assigned sucessfully");

//        }
    }//GEN-LAST:event_submitBtnActionPerformed

    public void populateLabTest() {
        DefaultTableModel model = (DefaultTableModel) assignTestTbl.getModel();
        model.setRowCount(0);
        //for (UserAccount ua : system.getUserAccountDirectory().getUserAccountList()) {s
        if(labTestList==null)
        {
            labTestList= new LabTestDirectory();
            appointment.setLabTestList(labTestList);
        }
        if(labTestList.getLabTestList() != null && !labTestList.getLabTestList().isEmpty()){
        for (LabTest labTest : labTestList.getLabTestList()) {
            Object[] row = new Object[5];
            row[0] = new Date();
            row[1] = labTest.getName();
            row[2] = labTest.getLab();
            row[3] = labTest.getPatient();
            row[4] = (labTest.getStatus().equals("") ) ? "New" :labTest.getStatus() ;
            model.addRow(row);
            
        }
        }
    }
    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
          Component [] componentArray = userProcessContainer.getComponents();
        Component c = componentArray[componentArray.length-1];
        DoctorWorkAreaJPanel ms = (DoctorWorkAreaJPanel) c;
        ms.populateRequestTable();

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void cmbLabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLabsActionPerformed
        String str = String.valueOf(cmbLabs.getSelectedItem());
    }//GEN-LAST:event_cmbLabsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable assignTestTbl;
    private javax.swing.JButton backJButton;
    private javax.swing.JComboBox cmbLabs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField testTypeTxt;
    // End of variables declaration//GEN-END:variables
}