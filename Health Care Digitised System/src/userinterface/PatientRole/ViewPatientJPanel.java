/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PatientRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Location.LocationPoint;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.GoogleMAP.AddressJPanel;
import userinterface.ReceptionistRole.ReceptionistWorkAreaJPanel;

/**
 *
 * @author Suhani
 */
public class ViewPatientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewPatientJPanel
     */
   
    JPanel userProcessContainer;
    UserAccount userAccount;
    Organization organization;
    Enterprise enterprise;
    EcoSystem system;
    Patient patient;
    LocationPoint locationPoint;
    public ViewPatientJPanel(JPanel userProcessContainer, UserAccount userAccount, Organization organization, Enterprise enterprise, EcoSystem system, Patient patient) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        this.system = system;
        this.patient = patient;
        populateData();
        populateMobileCarrierComboBox();
    }
    
    private void populateData() {
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        txtPatientName.setEditable(false);
        txtGender.setEnabled(false);
        txtPhoneNumber.setEditable(false);
        txtBloodGroup.setEnabled(false);
        txtAddress.setEditable(false);
        txtEmail.setEditable(false);
        txtUserName.setEditable(false);
        txtPassword.setEditable(false);
        txtPatientName.setText(patient.getName());
        txtGender.setSelectedItem(patient.getPatientSex());
        txtPhoneNumber.setText(patient.getPhoneNum());
        txtUserName.setText(patient.getUserAccount().getUsername());
        txtPassword.setText(patient.getUserAccount().getPassword());
        txtBloodGroup.setSelectedItem(patient.getBloodGroup());
        txtEmail.setText(patient.getEmailID());
        txtAddress.setText(patient.getAddress().getLatitude() + ", " + patient.getAddress().getLongitude());
        contactCarrier.setSelectedItem(patient.getCarrier() == null ? "TMobile" :patient.getCarrier() );
    }

    
    public void populateMobileCarrierComboBox() {
        contactCarrier.removeAllItems();
        contactCarrier.addItem("ATT");
        contactCarrier.addItem("Sprint");
        contactCarrier.addItem("TMobile");
        contactCarrier.addItem("Verizon");
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        lblPatientName = new javax.swing.JLabel();
        txtPatientName = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        txtGender = new javax.swing.JComboBox();
        lblPhoneNumber = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        txtBloodGroup = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        txtAddress = new javax.swing.JTextField();
        btnSetLocation = new javax.swing.JButton();
        lblemail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        contactCarrier = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("<< Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        lblPatientName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPatientName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPatientName.setText("Patient Name:");
        add(lblPatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 130, 130, -1));

        txtPatientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatientNameActionPerformed(evt);
            }
        });
        add(txtPatientName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 194, -1));

        lblGender.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblGender.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGender.setText("Gender:");
        add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 89, -1));

        txtGender.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--", "Male", "Female", "Other" }));
        add(txtGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 194, -1));

        lblPhoneNumber.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPhoneNumber.setText("Phone Number:");
        add(lblPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 140, -1));
        add(txtPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 194, -1));

        lblUserName.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUserName.setText("UserName:");
        add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 89, -1));
        add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 199, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Password:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 86, -1));
        add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, 200, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Blood Group:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        txtBloodGroup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Select--", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
        add(txtBloodGroup, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 194, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Patient Address:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, 124, -1));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 480, -1, -1));

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, 85, -1));

        txtAddress.setEditable(false);
        add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 196, -1));

        btnSetLocation.setText("Set Location");
        btnSetLocation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetLocationActionPerformed(evt);
            }
        });
        add(btnSetLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 440, 166, -1));

        lblemail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblemail.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblemail.setText("Email:");
        add(lblemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 66, -1));
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 200, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(25, 56, 82));
        jLabel11.setText("Carrier:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, 20));

        contactCarrier.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        contactCarrier.setForeground(new java.awt.Color(25, 56, 82));
        contactCarrier.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        contactCarrier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactCarrierActionPerformed(evt);
            }
        });
        contactCarrier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactCarrierKeyTyped(evt);
            }
        });
        add(contactCarrier, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 194, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/BedMangmt.PNG"))); // NOI18N
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 160, 271, 217));

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

        add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, -1));

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

        add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(96, 83, 150));
        jLabel13.setText("View Patient");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 270, 37));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray =userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ReceptionistWorkAreaJPanel sysAdminwajp = (ReceptionistWorkAreaJPanel) component;
        sysAdminwajp.populatePatients();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtPatientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatientNameActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if(txtPatientName.getText().isEmpty() || txtGender.getSelectedIndex() == 0 ||
            txtPhoneNumber.getText().isEmpty() ||
            txtBloodGroup.getSelectedIndex() == 0
            || txtAddress.getText().isEmpty()
            || txtEmail.getText().isEmpty()
                ){
            JOptionPane.showMessageDialog(null, "All fields are mandatory", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        enterprise.getPatientDirectory().updatePatient(patient.getId(), txtPatientName.getText(), txtPhoneNumber.getText(),
                txtGender.getSelectedItem().toString(), txtBloodGroup.getSelectedItem().toString(), locationPoint, txtEmail.getText());

        JOptionPane.showMessageDialog(null, "Patient updated successfully!", "Warning", JOptionPane.INFORMATION_MESSAGE);

        //txtPatientName.setText("");
        //txtPhoneNumber.setText("");
        //txtGender.setSelectedIndex(0);
        //txtUserName.setText("");
        //txtPassword.setText("");
        // txtBloodGroup.setSelectedIndex(0);
        //txtAddress.setText("");
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        txtPatientName.setEditable(true);
        txtGender.setEnabled(true);
        txtPhoneNumber.setEditable(true);
        txtBloodGroup.setEnabled(true);
        txtEmail.setEditable(true);
        txtEmail.setEnabled(true);
        txtAddress.setEditable(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

    public void populateLongituteLatitude(LocationPoint locationPoint) {
        this.locationPoint = locationPoint;
        txtAddress.setText(locationPoint.getLatitude() + ", " + locationPoint.getLongitude());
    }
    
    private void btnSetLocationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetLocationActionPerformed
        AddressJPanel muajp = new AddressJPanel(userProcessContainer);
        userProcessContainer.add("AddressJPanel", muajp);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnSetLocationActionPerformed

    private void contactCarrierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactCarrierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactCarrierActionPerformed

    private void contactCarrierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactCarrierKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_contactCarrierKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSetLocation;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox contactCarrier;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblPatientName;
    private javax.swing.JLabel lblPhoneNumber;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblemail;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JComboBox txtBloodGroup;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JComboBox txtGender;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPatientName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables

}