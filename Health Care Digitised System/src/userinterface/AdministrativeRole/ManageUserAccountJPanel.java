/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.AdministrativeRole;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.DoctorRole;
import Business.Role.LabTechnicianRole;
import Business.Role.NurseRole;
import Business.Role.PatientRole;
import Business.Role.ReceptionistRole;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import static Business.Utility.EmailClass.sendEmailMessage;
import static Business.Utility.EmailClass.sendTextMessage;
import Business.Utility.Validation;
import java.awt.CardLayout;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ManageUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccountJPanel
     */
    private JPanel container;
    private Enterprise enterprise;
    private UserAccount selectedStaff;
    EcoSystem system;

    public ManageUserAccountJPanel(JPanel container, Enterprise enterprise, EcoSystem system) {
        initComponents();
        this.enterprise = enterprise;
        this.container = container;
        this.system = system;

        popMainOrganizationComboBox();
        //popMainDeptComboBox();
       // employeeJComboBox.removeAllItems();
        //popData();
        createStaffPanel.setVisible(false);
        viewStaffPanel.setVisible(false);
        jLabel6.setVisible(true);
        //visitingChargeLbl.setEnabled(false);
        //visitingChargeTxt.setEnabled(false);
        //visitingChargeLbl.setVisible(false);
        //visitingChargeTxt.setVisible(false);
        
        
        
    }

    
    
    void autopopulate(){
        empNameJTextField.setText("");
        passwordJTextField.setText("Abcd@1234");
        visitingChargeTxt.setText("");
        nameJTextField.setText("");
        phoneNumberTxt.setText("6623605219");
        uEmailTxt.setText("aditijain2025@gmail.com");
    }
    public void popOrganizationComboBox() {
        organizationJComboBox.removeAllItems();
        //organizationJComboBox2.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationJComboBox.addItem(organization);
          //  organizationJComboBox2.addItem(organization);
          //  selectDeptCmb.addItem(organization);// main cmb box of department
        }
    }
    
    public void popOrganizationComboBox2() {
        //organizationJComboBox.removeAllItems();
        organizationJComboBox2.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
           // organizationJComboBox.addItem(organization);
            organizationJComboBox2.addItem(organization);
            //selectDeptCmb.addItem(organization);// main cmb box of department
        }
    }
    
    
    public void popMainOrganizationComboBox() {
        //organizationJComboBox.removeAllItems();
        selectDeptCmb.removeAllItems();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            //organizationJComboBox.addItem(organization);
            //organizationJComboBox2.addItem(organization);
            selectDeptCmb.addItem(organization);// main cmb box of department
        }
    }
    
    
    
   /* public void populateEmployeeComboBox(Organization organization){
        employeeJComboBox.removeAllItems();
        
        for (Employee employee : organization.getEmployeeDirectory().getEmployeeList()){
            employeeJComboBox.addItem(employee);
        }
    }*/
    
    private void populateRoleComboBox(Organization organization){
        roleJComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            roleJComboBox.addItem(role); //.roleValue()
        }
    }
    
    
    private void populateRoleComboBox2(Organization organization){
        roleJComboBox2.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            roleJComboBox2.addItem(role);
        }
    }
    

    public void popData() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);
        Organization selectedOrganization = (Organization) selectDeptCmb.getSelectedItem();
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if(organization.equals(selectedOrganization))
            {
                for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList())
                {
                Object row[] = new Object[3];
                row[0] = ua;
                row[1] = ua.getRole();
                row[2] = organization;//.getName();
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
            }
        }//end if
        }
        
    }
    
    
    
    public void popDataAll() {

        DefaultTableModel model = (DefaultTableModel) userJTable.getModel();

        model.setRowCount(0);
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            for (UserAccount ua : organization.getUserAccountDirectory().getUserAccountList()) {
                Object row[] = new Object[3];
                row[0] = ua;
                row[1] = ua.getRole();
                row[2] = organization;//.getName();
                ((DefaultTableModel) userJTable.getModel()).addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        userJTable = new javax.swing.JTable();
        createStaffPanel = new javax.swing.JPanel();
        closebtn = new javax.swing.JButton();
        empNameJTextField = new javax.swing.JTextField();
        visitingChargeLbl = new javax.swing.JLabel();
        visitingChargeTxt = new javax.swing.JTextField();
        createUserJButton = new javax.swing.JButton();
        nameJTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        organizationJComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        roleJComboBox = new javax.swing.JComboBox();
        contactCarrier = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        phoneNumberTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        uEmailTxt = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        specializationlbl = new javax.swing.JLabel();
        cmbSpecialization = new javax.swing.JComboBox();
        passwordJTextField = new javax.swing.JPasswordField();
        viewStaffPanel = new javax.swing.JPanel();
        closebtn1 = new javax.swing.JButton();
        empNameJTextField2 = new javax.swing.JTextField();
        visitingChargeLbl2 = new javax.swing.JLabel();
        visitingChargeTxt2 = new javax.swing.JTextField();
        updateUserBtn = new javax.swing.JButton();
        nameJTextField2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        organizationJComboBox2 = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        roleJComboBox2 = new javax.swing.JComboBox();
        saveBtn2 = new javax.swing.JButton();
        phoneNumberTxt1 = new javax.swing.JTextField();
        uEmailTxt1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cmbSpecialization1 = new javax.swing.JComboBox();
        specializationlbl1 = new javax.swing.JLabel();
        passwordJTextField2 = new javax.swing.JPasswordField();
        viewStaff1 = new javax.swing.JButton();
        selectDeptCmb = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        addStaffBtn = new javax.swing.JButton();
        viewStaff = new javax.swing.JButton();
        deleteStaffBtn = new javax.swing.JButton();
        backjButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userJTable.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(153, 204, 255)));
        userJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User Name", "Role", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(userJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 68, 757, 179));

        createStaffPanel.setBackground(new java.awt.Color(255, 255, 255));
        createStaffPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Add Staff", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(153, 204, 255))); // NOI18N
        createStaffPanel.setAutoscrolls(true);
        createStaffPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closebtn.setBackground(new java.awt.Color(153, 204, 255));
        closebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        closebtn.setForeground(new java.awt.Color(255, 255, 255));
        closebtn.setText("Close");
        closebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtnActionPerformed(evt);
            }
        });
        createStaffPanel.add(closebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 412, 96, -1));

        empNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empNameJTextFieldActionPerformed(evt);
            }
        });
        createStaffPanel.add(empNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 94, 178, -1));

        visitingChargeLbl.setText("Visiting Charge");
        visitingChargeLbl.setEnabled(false);
        createStaffPanel.add(visitingChargeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 375, -1, -1));

        visitingChargeTxt.setEnabled(false);
        createStaffPanel.add(visitingChargeTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 372, 180, -1));

        createUserJButton.setBackground(new java.awt.Color(153, 204, 255));
        createUserJButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        createUserJButton.setForeground(new java.awt.Color(255, 255, 255));
        createUserJButton.setText("Create Staff");
        createUserJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserJButtonActionPerformed(evt);
            }
        });
        createStaffPanel.add(createUserJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 412, 180, -1));
        createStaffPanel.add(nameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 134, 178, -1));

        jLabel1.setText("User Name");
        createStaffPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 137, -1, -1));

        jLabel2.setText("Password");
        createStaffPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 177, -1, -1));

        jLabel3.setText("Staff Name");
        createStaffPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 97, 131, -1));

        jLabel5.setText("Department");
        createStaffPanel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 22, -1, -1));

        organizationJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBoxActionPerformed(evt);
            }
        });
        createStaffPanel.add(organizationJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 19, 180, -1));

        jLabel4.setText("Staff Type");
        createStaffPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 62, -1, -1));

        roleJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBoxActionPerformed(evt);
            }
        });
        createStaffPanel.add(roleJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 59, 180, -1));

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
        createStaffPanel.add(contactCarrier, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 214, 179, -1));

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(25, 56, 82));
        jLabel9.setText("Phone Number");
        createStaffPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 249, -1, 30));

        phoneNumberTxt.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        phoneNumberTxt.setForeground(new java.awt.Color(25, 56, 82));
        phoneNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberTxtActionPerformed(evt);
            }
        });
        phoneNumberTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneNumberTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneNumberTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneNumberTxtKeyTyped(evt);
            }
        });
        createStaffPanel.add(phoneNumberTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(154, 253, 179, -1));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(25, 56, 82));
        jLabel7.setText("Email Id");
        createStaffPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 293, -1, 20));

        uEmailTxt.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        uEmailTxt.setForeground(new java.awt.Color(25, 56, 82));
        uEmailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uEmailTxtActionPerformed(evt);
            }
        });
        uEmailTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                uEmailTxtKeyTyped(evt);
            }
        });
        createStaffPanel.add(uEmailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 292, 180, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(25, 56, 82));
        jLabel17.setText("Carrier");
        createStaffPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 215, -1, 20));

        specializationlbl.setText("Specialization");
        specializationlbl.setEnabled(false);
        createStaffPanel.add(specializationlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 335, -1, -1));

        cmbSpecialization.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSpecialization.setEnabled(false);
        createStaffPanel.add(cmbSpecialization, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 332, 180, -1));
        createStaffPanel.add(passwordJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 174, 178, -1));

        add(createStaffPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 362, 455));

        viewStaffPanel.setBackground(new java.awt.Color(255, 255, 255));
        viewStaffPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "View Staff", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(153, 204, 255))); // NOI18N
        viewStaffPanel.setAutoscrolls(true);
        viewStaffPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closebtn1.setBackground(new java.awt.Color(153, 204, 255));
        closebtn1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        closebtn1.setForeground(new java.awt.Color(255, 255, 255));
        closebtn1.setText("Close");
        closebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closebtn1ActionPerformed(evt);
            }
        });
        viewStaffPanel.add(closebtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 409, 111, -1));

        empNameJTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empNameJTextField2ActionPerformed(evt);
            }
        });
        viewStaffPanel.add(empNameJTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 99, 180, -1));

        visitingChargeLbl2.setText("Visiting Charge");
        visitingChargeLbl2.setEnabled(false);
        viewStaffPanel.add(visitingChargeLbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 340, -1, -1));

        visitingChargeTxt2.setEnabled(false);
        viewStaffPanel.add(visitingChargeTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 337, 175, -1));

        updateUserBtn.setBackground(new java.awt.Color(153, 204, 255));
        updateUserBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        updateUserBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateUserBtn.setText("Update Staff");
        updateUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserBtnActionPerformed(evt);
            }
        });
        viewStaffPanel.add(updateUserBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 371, 279, -1));
        viewStaffPanel.add(nameJTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 139, 180, -1));

        jLabel11.setText("User Name");
        viewStaffPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 142, -1, -1));

        jLabel12.setText("Password");
        viewStaffPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 182, -1, -1));

        jLabel13.setText("Staff Name");
        viewStaffPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 102, 67, -1));

        jLabel14.setText("Department");
        viewStaffPanel.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 22, -1, -1));

        organizationJComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationJComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationJComboBox2ActionPerformed(evt);
            }
        });
        viewStaffPanel.add(organizationJComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 19, 180, -1));

        jLabel15.setText("Staff Type");
        viewStaffPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 62, -1, -1));

        roleJComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        roleJComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleJComboBox2ActionPerformed(evt);
            }
        });
        viewStaffPanel.add(roleJComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 59, 180, -1));

        saveBtn2.setBackground(new java.awt.Color(153, 204, 255));
        saveBtn2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        saveBtn2.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn2.setText("Save ");
        saveBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtn2ActionPerformed(evt);
            }
        });
        viewStaffPanel.add(saveBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 409, 146, -1));

        phoneNumberTxt1.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        phoneNumberTxt1.setForeground(new java.awt.Color(25, 56, 82));
        phoneNumberTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNumberTxt1ActionPerformed(evt);
            }
        });
        phoneNumberTxt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneNumberTxt1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneNumberTxt1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                phoneNumberTxt1KeyTyped(evt);
            }
        });
        viewStaffPanel.add(phoneNumberTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 223, 177, -1));

        uEmailTxt1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        uEmailTxt1.setForeground(new java.awt.Color(25, 56, 82));
        uEmailTxt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uEmailTxt1ActionPerformed(evt);
            }
        });
        uEmailTxt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                uEmailTxt1KeyTyped(evt);
            }
        });
        viewStaffPanel.add(uEmailTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 270, 180, -1));

        jLabel10.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(25, 56, 82));
        jLabel10.setText("Phone Number");
        viewStaffPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 219, -1, 30));

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(25, 56, 82));
        jLabel8.setText("Email Id");
        viewStaffPanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 271, -1, 20));

        cmbSpecialization1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbSpecialization1.setEnabled(false);
        viewStaffPanel.add(cmbSpecialization1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 299, 176, -1));

        specializationlbl1.setText("Specialization");
        specializationlbl1.setEnabled(false);
        viewStaffPanel.add(specializationlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 302, -1, -1));
        viewStaffPanel.add(passwordJTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 179, 180, -1));

        add(viewStaffPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 330, 455));

        viewStaff1.setBackground(new java.awt.Color(153, 204, 255));
        viewStaff1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewStaff1.setForeground(new java.awt.Color(255, 255, 255));
        viewStaff1.setText("View Department Staff");
        viewStaff1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStaff1ActionPerformed(evt);
            }
        });
        add(viewStaff1, new org.netbeans.lib.awtextra.AbsoluteConstraints(559, 25, -1, -1));

        selectDeptCmb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectDeptCmb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDeptCmbActionPerformed(evt);
            }
        });
        add(selectDeptCmb, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 28, 146, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 204, 255));
        jLabel16.setText("Select Department");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 30, -1, -1));

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        addStaffBtn.setBackground(new java.awt.Color(255, 255, 255));
        addStaffBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addStaffBtn.setForeground(new java.awt.Color(102, 102, 102));
        addStaffBtn.setText("Add  Staff");
        addStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStaffBtnActionPerformed(evt);
            }
        });

        viewStaff.setBackground(new java.awt.Color(255, 255, 255));
        viewStaff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewStaff.setForeground(new java.awt.Color(102, 102, 102));
        viewStaff.setText("View Staff");
        viewStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStaffActionPerformed(evt);
            }
        });

        deleteStaffBtn.setBackground(new java.awt.Color(255, 255, 255));
        deleteStaffBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteStaffBtn.setForeground(new java.awt.Color(102, 102, 102));
        deleteStaffBtn.setText("Delete Staff");
        deleteStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStaffBtnActionPerformed(evt);
            }
        });

        backjButton1.setBackground(new java.awt.Color(153, 204, 255));
        backjButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backjButton1.setForeground(new java.awt.Color(102, 102, 102));
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backjButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(addStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(deleteStaffBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/StaffImage.png"))); // NOI18N
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 401, 154, 230));

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
    }// </editor-fold>//GEN-END:initComponents

    private void createUserJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserJButtonActionPerformed
        String userName = nameJTextField.getText();
        String password = passwordJTextField.getText();
        String name = empNameJTextField.getText();
        String uEmail = uEmailTxt.getText();
        String phoneNo = phoneNumberTxt.getText();
        if(userName.equals("") || userName.equals(null)){
            JOptionPane.showMessageDialog(null, "Enter username!");
            return;
        }
        
        if(password.equals("") || password.equals(null)){
            JOptionPane.showMessageDialog(null, "Enter password!");
            return;
        }
        
        if(name.equals("") || name.equals(null)){
            JOptionPane.showMessageDialog(null, "Enter name!");
            return;
        }
        
        if(uEmail.equals("") || uEmail.equals(null)){
            JOptionPane.showMessageDialog(null, "Enter Email!");
            return;
        }
        
        if(phoneNo.equals("") || phoneNo.equals(null)){
            JOptionPane.showMessageDialog(null, "Enter Phone Number!");
            return;
        }
        
        boolean isUserNameCorrect = Validation.userNameValidator(userName);
        if(isUserNameCorrect == false)
        {
            JOptionPane.showMessageDialog(null, "Enter username properly: only alphabets and numbers allowed!");
            return;
        }
        
        boolean isPasswordCorrect = Validation.passwordValidator(password);
        if(isPasswordCorrect == false)
        {
            JOptionPane.showMessageDialog(null, "Enter password properly!");
            return;
        }
        boolean isNameCorrect = Validation.nameValidator(name);
        if(isNameCorrect == false)
        {
            JOptionPane.showMessageDialog(null, "Enter name properly!");
            return;
        }
        
        boolean isValid=Validation.emailValidator(uEmail);
        if(isValid == false){
             JOptionPane.showMessageDialog(null, "Enter email correctly");
            return;
        }
        
        
        if(!phoneNumberValidity(phoneNumberTxt.getText())){
            JOptionPane.showMessageDialog(null, "Phone number is incorrect, only 10 digits no prefix");
            return;
        }
        
        
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
       
        //check if username is unique
        
        
        
        //check if username is unique
        boolean isUserNameUnique = Validation.checkIfUserNameIsUniqueAcrossNetworks(system,userName);
        System.out.println("isUserNameUnique: "+ isUserNameUnique);
        
        
        if(isUserNameUnique == false)
        {
            JOptionPane.showMessageDialog(null, "Username already exists, try another name!");
            return;
        }
        
        
        //Employee employee = (Employee) employeeJComboBox.getSelectedItem();
        
        Employee employee =organization.getEmployeeDirectory().createEmployee(name);
        //UserAccount account = enterprise.getUserAccountDirectory().createUserAccount(username, password, employee,role);// new AdmRole());
        employee.setEmailID(uEmail);
        employee.setPhoneNum(phoneNo);
        String phoneNumberString = null;
        if (contactCarrier.getSelectedItem().equals("ATT")) {
             phoneNumberString="@txt.att.net";
        } else if (contactCarrier.getSelectedItem().equals("Verizon")) {
            phoneNumberString ="@vmobl.com";
        } else if (contactCarrier.getSelectedItem().equals("Sprint")) {
            phoneNumberString =  "@messaging.sprintpcs.com";
        } else if (contactCarrier.getSelectedItem().equals("TMobile")) {
            phoneNumberString = "@tmomail.net";
        }
        employee.setCarrier(phoneNumberString);
        
        
        
        
        Role role = (Role) roleJComboBox.getSelectedItem();
        role.getClass();
        
        if(role.roleValue().equals("Doctor Role"))
        {
            employee.setVisitingCharge(Double.parseDouble(visitingChargeTxt.getText()));
            employee.setSpecialization((Employee.SpecializationType)cmbSpecialization.getSelectedItem());
        }
        
        employee.setRole(role.roleValue());
        UserAccount account= organization.getUserAccountDirectory().createUserAccount(userName, password, employee, role);
        //organization.ge
        popData();
        
        
        //send email and sms
        
        String contact = "";
        
            if (contactCarrier.getSelectedItem().equals("ATT")) {
                contact = phoneNumberTxt.getText() + "@txt.att.net";
            } else if (contactCarrier.getSelectedItem().equals("Verizon")) {
                contact = phoneNumberTxt.getText() + "@vmobl.com";
            } else if (contactCarrier.getSelectedItem().equals("Sprint")) {
                contact = phoneNumberTxt.getText() + "@messaging.sprintpcs.com";
            } else if (contactCarrier.getSelectedItem().equals("TMobile")) {
                contact = phoneNumberTxt.getText() + "@tmomail.net";
            }
            //registrationRequest.setContactCarrierName(contact);
            sendEmailMessage(uEmail, account);//.getText());
            sendTextMessage(contact);
        
             //JOptionPane.showMessageDialog(null, "User added successfully");
        
        JOptionPane.showMessageDialog(null, "Staff added successfully!");
        //clear text
        empNameJTextField.setText("");
        passwordJTextField.setText("");
        visitingChargeTxt.setText("");
        nameJTextField.setText("");
        phoneNumberTxt.setText("");
        uEmailTxt.setText("");
    }//GEN-LAST:event_createUserJButtonActionPerformed

    public Boolean phoneNumberValidity(String customerContact) {
        String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        Pattern pattern = Pattern.compile(regex);
        
        Matcher matcher = pattern.matcher(customerContact);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
    
    public void populateSpecializationCMB(){
        cmbSpecialization.removeAllItems();;
        for(Employee.SpecializationType type:Employee.SpecializationType.values() )
        {
            cmbSpecialization.addItem(type);
        }
    }
    
    public void populateSpecializationCMB1(){
        cmbSpecialization1.removeAllItems();;
        for(Employee.SpecializationType type:Employee.SpecializationType.values() )
        {
            cmbSpecialization1.addItem(type);
        }
    }
    
    
    
    public void populateMobileCarrierComboBox() {
        contactCarrier.removeAllItems();
        contactCarrier.addItem("ATT");
        contactCarrier.addItem("Sprint");
        contactCarrier.addItem("TMobile");
        contactCarrier.addItem("Verizon");
    }
        public Role createObjectForRole(String roleString){
        Role role = null;
        if(roleString.equals("DoctorRole"))
        {
            role=new DoctorRole();
        }
        else if(roleString.equals("NurseRole"))
        {
            role=new NurseRole();
        }
        else if(roleString.equals("LabTechnicianRole"))
        {
            role=new LabTechnicianRole();
        }
        else if(roleString.equals("PatientRole"))
        {
            role=new PatientRole();
        }
        else if(roleString.equals("ReceptionistRole"))
        {
            role=new ReceptionistRole();
        }
        
        return role;
    }
    
    
    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backjButton1ActionPerformed

    private void organizationJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBoxActionPerformed
        Organization organization = (Organization) organizationJComboBox.getSelectedItem();
        if (organization != null){
            //populateEmployeeComboBox(organization);
            populateRoleComboBox(organization);
        }
    }//GEN-LAST:event_organizationJComboBoxActionPerformed

    private void empNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empNameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empNameJTextFieldActionPerformed

    private void roleJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBoxActionPerformed
        // TODO add your handling code here:
        
        Role role = (Role) roleJComboBox.getSelectedItem();
        if(role!=null){
        //String roleString = role.toString();
        if(role.roleValue().equals("Doctor Role"))
        {
            visitingChargeLbl.setEnabled(true);
            visitingChargeTxt.setEnabled(true);
            visitingChargeLbl.setVisible(true);
            visitingChargeTxt.setVisible(true);
            specializationlbl.setEnabled(true);
        cmbSpecialization.setEnabled(true);
        specializationlbl.setVisible(true);
        cmbSpecialization.setVisible(true);
        }
        else{
            visitingChargeLbl.setEnabled(false);
            visitingChargeTxt.setEnabled(false);
            visitingChargeLbl.setVisible(false);
            visitingChargeTxt.setVisible(false);
            
            specializationlbl.setEnabled(false);
        cmbSpecialization.setEnabled(false);
        specializationlbl.setVisible(false);
        cmbSpecialization.setVisible(false);
        }
        }
    }//GEN-LAST:event_roleJComboBoxActionPerformed

    private void closebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtnActionPerformed
        createStaffPanel.setVisible(false);
    }//GEN-LAST:event_closebtnActionPerformed

    private void addStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStaffBtnActionPerformed
        // TODO add your handling code here:
        createStaffPanel.setVisible(true);
        visitingChargeLbl.setEnabled(false);
        visitingChargeTxt.setEnabled(false);
        visitingChargeLbl.setVisible(false);
        visitingChargeTxt.setVisible(false);
        specializationlbl.setEnabled(false);
        cmbSpecialization.setEnabled(false);
        specializationlbl.setVisible(false);
        cmbSpecialization.setVisible(false);
        
        popOrganizationComboBox();
        populateMobileCarrierComboBox();
        populateSpecializationCMB();
        
       // autopopulate();
        //populateRoleComboBox();
    }//GEN-LAST:event_addStaffBtnActionPerformed

    private void closebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closebtn1ActionPerformed
        // TODO add your handling code here:
        viewStaffPanel.setVisible(false);
    }//GEN-LAST:event_closebtn1ActionPerformed

    private void empNameJTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empNameJTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_empNameJTextField2ActionPerformed

    private void updateUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserBtnActionPerformed
        // TODO add your handling code here:
       // organizationJComboBox2.setEditable(true);
        //roleJComboBox2.setEditable(true);
        empNameJTextField2.setEditable(true);
        nameJTextField2.setEditable(false); // cannot change userName
        passwordJTextField2.setEditable(true);
        
        //if(uaRole.toString().equals("DoctorRole"))
       // {
            //visitingChargeLbl2.setVisible(true);
         //   visitingChargeTxt2.setVisible(true);
            //visitingChargeLbl2.setEditable(false);
           
            
            if(selectedStaff.getRole().roleValue().equals("Doctor Role"))
        {
            visitingChargeTxt2.setEditable(true);
            visitingChargeTxt2.setVisible(true);
            visitingChargeTxt2.setEnabled(true);
            visitingChargeLbl2.setEnabled(true);
            
            specializationlbl1.setEnabled(true);
        cmbSpecialization1.setEnabled(true);
        specializationlbl1.setVisible(true);
        cmbSpecialization1.setVisible(true);
        }
        //}
       //else{
          // visitingChargeLbl2.setVisible(false);
        //   visitingChargeTxt2.setVisible(false);
      // }
      
      uEmailTxt1.setEditable(true);
        phoneNumberTxt1.setEditable(true);
        updateUserBtn.setEnabled(false);
        saveBtn2.setEnabled(true);
        closebtn1.setEnabled(true);
        
       // closebtn1.setEnabled(true);
        
    }//GEN-LAST:event_updateUserBtnActionPerformed

    private void organizationJComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationJComboBox2ActionPerformed
        // TODO add your handling code here:
        Organization organization = (Organization) organizationJComboBox2.getSelectedItem();
        if (organization != null){
            //populateEmployeeComboBox(organization);
            populateRoleComboBox2(organization);
        }
    }//GEN-LAST:event_organizationJComboBox2ActionPerformed

    private void roleJComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleJComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleJComboBox2ActionPerformed

    private void viewStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStaffActionPerformed
        // TODO add your handling code here:
        int row = userJTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        viewStaffPanel.setVisible(true);
        organizationJComboBox2.setEnabled(false);  // not allowed to change department
        roleJComboBox2.setEnabled(false);  // not allowed to change role
        popOrganizationComboBox2(); // department populate
        populateSpecializationCMB1();
        //organizationJComboBox2.setEditable(false);  // not allowed to change department
        //roleJComboBox2.setEditable(false);
        UserAccount selectedUsrAcc = (UserAccount) userJTable.getValueAt(row,0);
        selectedStaff = selectedUsrAcc;
        //populateRoleComboBox2((Organization)userJTable.getValueAt(row, 2));  //based on department
        Role uaRole= selectedUsrAcc.getRole();
        organizationJComboBox2.setSelectedItem((Organization)userJTable.getValueAt(row, 2));  //department at 2nd index
        roleJComboBox2.getModel().setSelectedItem(uaRole);
        empNameJTextField2.setText(selectedUsrAcc.getEmployee().getName());
        nameJTextField2.setText(selectedUsrAcc.getUsername());//username
        passwordJTextField2.setText(selectedUsrAcc.getPassword());
        uEmailTxt1.setText(selectedUsrAcc.getEmployee().getEmailID());
        phoneNumberTxt1.setText(selectedUsrAcc.getEmployee().getPhoneNum());
        organizationJComboBox2.setEditable(false);
        roleJComboBox2.setEditable(false);
        empNameJTextField2.setEditable(false);
        nameJTextField2.setEditable(false);
        passwordJTextField2.setEditable(false);
        uEmailTxt1.setEditable(false);
        phoneNumberTxt1.setEditable(false);
        //uaRole.getClass()
        if(uaRole.roleValue().equals("Doctor Role"))
        {
            visitingChargeLbl2.setVisible(true);
            visitingChargeTxt2.setVisible(true);
            //visitingChargeLbl2.setEditable(false);
            visitingChargeTxt2.setEditable(false);
            visitingChargeTxt2.setText(String.valueOf(selectedUsrAcc.getEmployee().getVisitingCharge()));
        
        specializationlbl1.setEnabled(true);
        cmbSpecialization1.setEnabled(false);
        specializationlbl1.setVisible(true);
        cmbSpecialization1.setVisible(true);
        cmbSpecialization1.setSelectedItem(selectedUsrAcc.getEmployee().getSpecialization().getValue());
        
        
        }
        else{
            visitingChargeLbl2.setVisible(false);
            visitingChargeTxt2.setVisible(false);
            visitingChargeTxt2.setText("");
            specializationlbl1.setVisible(false);
            cmbSpecialization1.setVisible(false);
            
        }
        updateUserBtn.setEnabled(true);
        saveBtn2.setEnabled(false);
        closebtn1.setEnabled(true);
    }//GEN-LAST:event_viewStaffActionPerformed

    private void viewStaff1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStaff1ActionPerformed
        // TODO add your handling code here:
        
        
        //check if department cmb box is selected
        //int row= selectDeptCmb.getS
        //Organization organization = (Organization) selectDeptCmb.getSelectedItem();
        
        
        popData();
    }//GEN-LAST:event_viewStaff1ActionPerformed

    private void saveBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtn2ActionPerformed
        // TODO add your handling code here:
        //change password, staff name, visiting charge 
        String staffName= empNameJTextField2.getText();
        String password = passwordJTextField2.getText();
        String phonenum= phoneNumberTxt1.getText();
        String emailId = uEmailTxt1.getText();
        boolean result = Validation.nameValidator(staffName);
        if(result == false){
            JOptionPane.showMessageDialog(null, "Enter name properly!");
            return;
        }
        
        
        result = Validation.passwordValidator(password);
        if(result == false){
            JOptionPane.showMessageDialog(null, "Enter password properly!");
            return;
        }
        
        
        if(emailId.equals("") || emailId.equals(null)){
            JOptionPane.showMessageDialog(null, "Enter Email!");
            return;
        }
        
        if(phonenum.equals("") || phonenum.equals(null)){
            JOptionPane.showMessageDialog(null, "Enter Phone Number!");
            return;
        }
        
        
        boolean isValid=Validation.emailValidator(emailId);
        if(isValid == false){
             JOptionPane.showMessageDialog(null, "Enter email correctly");
            return;
        }
        
        
        if(!phoneNumberValidity(phoneNumberTxt1.getText())){
            JOptionPane.showMessageDialog(null, "Phone number is incorrect, only 10 digits no prefix");
            return;
        }
        
        double visitingChgr =-1; ;
        if(visitingChargeTxt2.isVisible())
        {
            visitingChgr= Double.parseDouble(visitingChargeTxt2.getText());
        }
        
        
        
        
        
        //update properrty
        selectedStaff.setPassword(password);
        selectedStaff.getEmployee().setName(staffName);
        selectedStaff.getEmployee().setEmailID(emailId);
        selectedStaff.getEmployee().setPhoneNum(phonenum);
        if(selectedStaff.getRole().roleValue().equals("Doctor Role"))
        {
            selectedStaff.getEmployee().setVisitingCharge(visitingChgr);
            Employee.SpecializationType type=(Employee.SpecializationType) cmbSpecialization1.getSelectedItem();
            selectedStaff.getEmployee().setSpecialization(type);
        }
        //show message success
        JOptionPane.showMessageDialog(null, "Updated Successfully!");
        
        
        updateUserBtn.setEnabled(true);
        saveBtn2.setEnabled(false);
        closebtn1.setEnabled(true);
        empNameJTextField2.setEditable(false);
        nameJTextField2.setEditable(false); // cannot change userName
        passwordJTextField2.setEditable(false);
        if(visitingChargeTxt2.isVisible())
        {
            visitingChargeTxt2.setEditable(false);
            cmbSpecialization1.setEnabled(false);
        }
        else{
            visitingChargeTxt2.setEditable(false);
            cmbSpecialization1.setEnabled(false);
        }
        uEmailTxt1.setEditable(false);
        phoneNumberTxt1.setEditable(false);
        
        popData();
    }//GEN-LAST:event_saveBtn2ActionPerformed

    private void deleteStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStaffBtnActionPerformed
        // TODO add your handling code here:
        
        int row = userJTable.getSelectedRow();
        if(row<0){
            JOptionPane.showMessageDialog(null, "Please select a row!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        
         int dialogButton= JOptionPane.YES_NO_CANCEL_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to delete the account details?", "Warning",dialogButton);
            if(dialogResult==JOptionPane.YES_OPTION){
                UserAccount selectedUsrAcc = (UserAccount) userJTable.getValueAt(row,0);
                Organization org = (Organization) userJTable.getValueAt(row,2);
                //reomve account
                
            for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) 
            {
                if(org.equals(organization)){
                organization.getUserAccountDirectory().removeUserAccount(selectedUsrAcc);
                
                organization.getEmployeeDirectory().removeEmployee(selectedUsrAcc.getEmployee());
                
                 popData();
                 JOptionPane.showMessageDialog(null, "Deleted successfully!!");
                }//inner for 
                }//if 
            }

        
       
    }//GEN-LAST:event_deleteStaffBtnActionPerformed

    private void selectDeptCmbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDeptCmbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectDeptCmbActionPerformed

    private void contactCarrierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactCarrierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactCarrierActionPerformed

    private void contactCarrierKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactCarrierKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_contactCarrierKeyTyped

    private void phoneNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxtActionPerformed

    private void phoneNumberTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberTxtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxtKeyPressed

    private void phoneNumberTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberTxtKeyReleased
        // TODO add your handling code here:
        //        if(uContact.getText().trim().length() != 11){
            //          contactFormatMessage.setVisible(true);
            //          contactValid = false;
            //        }
        //        else if (!contactValidity(uContact.getText())) {
            //            contactFormatMessage.setVisible(true);
            //            contactValid = false;
            //        } else {
            //            uContact.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            //            uContact.setForeground(Color.BLACK);
            //            contactFormatMessage.setVisible(false);
            //            contactSuccessLabel.setVisible(true);
            //            contactValid = true;
            //            int delay = 2500; //milliseconds
            //            ActionListener taskPerformer = new ActionListener() {
                //                public void actionPerformed(ActionEvent evt) {
                    //                    contactSuccessLabel.setVisible(false);
                    //                }
                //            };
            //            javax.swing.Timer tick = new javax.swing.Timer(delay, taskPerformer);
            //            tick.setRepeats(false);
            //            tick.start();
            //        }
    }//GEN-LAST:event_phoneNumberTxtKeyReleased

    private void phoneNumberTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberTxtKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxtKeyTyped

    private void uEmailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uEmailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uEmailTxtActionPerformed

    private void uEmailTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uEmailTxtKeyTyped
        // TODO add your handling code here:
        /* if (!validation.emailValidator(uEmailTxt.getText())) {
            emailValidateMessage.setVisible(true);
            emailValid = false;
        } else {
            uEmailTxt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            uEmailTxt.setForeground(Color.BLACK);
            emailValidateMessage.setVisible(false);
            emailSuccessLabel.setVisible(true);
            emailValid = true;
            int delay = 2500; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    emailSuccessLabel.setVisible(false);
                }
            };
            javax.swing.Timer tick = new javax.swing.Timer(delay, taskPerformer);
            tick.setRepeats(false);
            tick.start();
        }*/
    }//GEN-LAST:event_uEmailTxtKeyTyped

    private void uEmailTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uEmailTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uEmailTxt1ActionPerformed

    private void uEmailTxt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_uEmailTxt1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_uEmailTxt1KeyTyped

    private void phoneNumberTxt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNumberTxt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxt1ActionPerformed

    private void phoneNumberTxt1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberTxt1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxt1KeyPressed

    private void phoneNumberTxt1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberTxt1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxt1KeyReleased

    private void phoneNumberTxt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNumberTxt1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNumberTxt1KeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStaffBtn;
    private javax.swing.JButton backjButton1;
    private javax.swing.JButton closebtn;
    private javax.swing.JButton closebtn1;
    private javax.swing.JComboBox cmbSpecialization;
    private javax.swing.JComboBox cmbSpecialization1;
    private javax.swing.JComboBox contactCarrier;
    private javax.swing.JPanel createStaffPanel;
    private javax.swing.JButton createUserJButton;
    private javax.swing.JButton deleteStaffBtn;
    private javax.swing.JTextField empNameJTextField;
    private javax.swing.JTextField empNameJTextField2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameJTextField;
    private javax.swing.JTextField nameJTextField2;
    private javax.swing.JComboBox organizationJComboBox;
    private javax.swing.JComboBox organizationJComboBox2;
    private javax.swing.JPasswordField passwordJTextField;
    private javax.swing.JPasswordField passwordJTextField2;
    private javax.swing.JTextField phoneNumberTxt;
    private javax.swing.JTextField phoneNumberTxt1;
    private javax.swing.JComboBox roleJComboBox;
    private javax.swing.JComboBox roleJComboBox2;
    private javax.swing.JButton saveBtn2;
    private javax.swing.JComboBox selectDeptCmb;
    private javax.swing.JLabel specializationlbl;
    private javax.swing.JLabel specializationlbl1;
    private javax.swing.JTextField uEmailTxt;
    private javax.swing.JTextField uEmailTxt1;
    private javax.swing.JButton updateUserBtn;
    private javax.swing.JTable userJTable;
    private javax.swing.JButton viewStaff;
    private javax.swing.JButton viewStaff1;
    private javax.swing.JPanel viewStaffPanel;
    private javax.swing.JLabel visitingChargeLbl;
    private javax.swing.JLabel visitingChargeLbl2;
    private javax.swing.JTextField visitingChargeTxt;
    private javax.swing.JTextField visitingChargeTxt2;
    // End of variables declaration//GEN-END:variables
}
