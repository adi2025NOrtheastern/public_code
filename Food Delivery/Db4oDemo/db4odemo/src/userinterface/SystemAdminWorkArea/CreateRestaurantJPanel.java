/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.SystemAdminWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Restaurant.Restaurant;
import Business.Restaurant.RestaurantDirectory;
import Business.Role.AdminRole;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author cnakhare
 */
public class CreateRestaurantJPanel extends javax.swing.JPanel {

    /**
     * Creates new form createRestaurantJPanel
     */
    JFileChooser chooser;
    File file;
    BufferedImage img;
    private RestaurantDirectory restaurantDirectory;
    private JPanel container;
    private EcoSystem system;
    public CreateRestaurantJPanel(JPanel container, EcoSystem system,RestaurantDirectory restaurantDirectory) {
        initComponents();
        this.restaurantDirectory = restaurantDirectory;
        this.container = container;
        this.system = system;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        restaurantNameTextField = new javax.swing.JTextField();
        restaurantAddressTextField = new javax.swing.JTextField();
        restaurantPhoneNoTextField = new javax.swing.JTextField();
        addRestaurantBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        managerNameTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();

        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Restaurant");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Address");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Phone Number");

        restaurantNameTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        restaurantAddressTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        restaurantPhoneNoTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        addRestaurantBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addRestaurantBtn.setText("Add");
        addRestaurantBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRestaurantBtnActionPerformed(evt);
            }
        });

        backBtn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("Username");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Password");

        usernameTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setText("Manager Name");

        managerNameTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        passwordTextField.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(restaurantPhoneNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(managerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(restaurantAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(restaurantNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backBtn)
                        .addGap(287, 287, 287)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(addRestaurantBtn)))
                .addGap(98, 692, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(backBtn))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(managerNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(restaurantNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(restaurantAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(restaurantPhoneNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(addRestaurantBtn)
                .addContainerGap(193, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addRestaurantBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRestaurantBtnActionPerformed
        // TODO add your handling code here:
        String name = restaurantNameTextField.getText();
        String address = restaurantAddressTextField.getText();
        String phone = restaurantPhoneNoTextField.getText();
        String username = usernameTextField.getText();
        String password = String.valueOf(passwordTextField.getPassword());
        String managerName = managerNameTextField.getText();
        boolean check=system.checkIfUserIsUnique(username);
        if(check == false)
        {
            JOptionPane.showMessageDialog(null, "username exists, try other!");
            return;
        }
            Employee employee = system.getEmployeeDirectory().createEmployee(managerName);
            
            Restaurant restaurant = system.getRestaurantDirectory().createRestaurant(name,phone,address);
            //Employee employee = system.getEmployeeDirectory().createEmployee(restaurant.getRestaurantId());
            restaurant.setManager(employee);
            UserAccount account = system.getUserAccountDirectory().createUserAccount(username, password, employee, new AdminRole());
            JOptionPane.showMessageDialog(null, "Restaurant added!");
            restaurantNameTextField.setText("");
            restaurantAddressTextField.setText("");
            restaurantPhoneNoTextField.setText("");
            usernameTextField.setText("");
            passwordTextField.setText("");
            
            managerNameTextField.setText("");
         
    }//GEN-LAST:event_addRestaurantBtnActionPerformed
    
    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        container.remove(this);
         Component[] componentArray = container.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ManageRestaurantJPanel manageRestaurantJPanel = (ManageRestaurantJPanel) component;
        manageRestaurantJPanel.populate();

        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRestaurantBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField managerNameTextField;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JTextField restaurantAddressTextField;
    private javax.swing.JTextField restaurantNameTextField;
    private javax.swing.JTextField restaurantPhoneNoTextField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
