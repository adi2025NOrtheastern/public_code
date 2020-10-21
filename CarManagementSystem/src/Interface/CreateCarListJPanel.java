/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.Car;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import Business.Uber;
import java.util.UUID;

/**
 *
 * @author aditi
 */
public class CreateCarListJPanel extends javax.swing.JPanel {

    
    Uber uobj;
    JSplitPane splitPane;
    JPanel rightJPnael;
    
    /**
     * Creates new form CreateCarJPanel
     */
    public CreateCarListJPanel(Uber uobj, JSplitPane splitPane, JPanel rjp) {
        initComponents();
        this.uobj=uobj;
        this.splitPane=splitPane;
        this.rightJPnael=rjp;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnCreateCar = new javax.swing.JButton();
        txtCarName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtManufacturer = new javax.swing.JTextField();
        txtCarTypr = new javax.swing.JTextField();
        txtModelNumber = new javax.swing.JTextField();
        txtSerialNo = new javax.swing.JTextField();
        txtManufactureYear = new javax.swing.JTextField();
        txtSeat = new javax.swing.JTextField();
        txtCertiDate = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        chckAvailable = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        comboCarType = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setText("< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 204));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Car");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Car Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Manufacturer");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Car Type");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Model Number ");

        btnCreateCar.setBackground(new java.awt.Color(0, 255, 51));
        btnCreateCar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnCreateCar.setText("Create");
        btnCreateCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateCarActionPerformed(evt);
            }
        });

        txtCarName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCarName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarNameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Serial Number");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Manufacture Year");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("City");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Number of Seats");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Expiry date Certificate");

        txtManufacturer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtManufacturer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManufacturerActionPerformed(evt);
            }
        });

        txtCarTypr.setEditable(false);
        txtCarTypr.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCarTypr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCarTyprActionPerformed(evt);
            }
        });

        txtModelNumber.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtModelNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModelNumberActionPerformed(evt);
            }
        });

        txtSerialNo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSerialNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerialNoActionPerformed(evt);
            }
        });

        txtManufactureYear.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtManufactureYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtManufactureYearActionPerformed(evt);
            }
        });

        txtSeat.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSeatActionPerformed(evt);
            }
        });

        txtCertiDate.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCertiDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCertiDateActionPerformed(evt);
            }
        });

        txtCity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityActionPerformed(evt);
            }
        });

        chckAvailable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        chckAvailable.setText("Available");

        jLabel11.setText("(DD/MM/YYYY)");

        comboCarType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        comboCarType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Passenger", "Transport", "Other" }));
        comboCarType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCarTypeActionPerformed(evt);
            }
        });

        jLabel12.setText("(YYYY)");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(73, 73, 73))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(203, 203, 203))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(chckAvailable, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtManufactureYear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSerialNo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtModelNumber, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCertiDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSeat, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCreateCar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCarTypr, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(148, 148, 148)
                                    .addComponent(txtCarName, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCarType, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))))
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnBack)))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCarName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtManufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCarTypr, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCarType, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtModelNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSerialNo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtManufactureYear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCertiDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel8))
                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(chckAvailable))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnCreateCar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(178, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        splitPane.setRightComponent(rightJPnael);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnCreateCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateCarActionPerformed

        //validations
        try{
        if(txtCarName.getText()==null || "".equals(txtCarName.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Car Name");
            return;
        }
        
        if(txtManufacturer.getText()==null || "".equals(txtManufacturer.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Manufacturer");
            return;
        }
        
        if(txtCarTypr.getText()==null || "".equals(txtCarTypr.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Car type");
            return;
        }
        
        if(txtModelNumber.getText()==null || "".equals(txtModelNumber.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Model Number");
            return;
        }
        
        if(txtSerialNo.getText()==null || "".equals(txtSerialNo.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Serial Number");
            return;
        }
        
        if(txtManufactureYear.getText()==null || "".equals(txtManufactureYear.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Manufacture Year");
            return;
        }
        
        if(txtSeat.getText()==null || "".equals(txtSeat.getText())){
            JOptionPane.showMessageDialog(null, "Please enter Seat number");
            return;
        }
        
        if(txtCertiDate.getText()==null || "".equals(txtCertiDate.getText())){
            JOptionPane.showMessageDialog(null, "Please enter expiry date of certificate");
            return;
        }
        
        if(txtCity.getText()==null || "".equals(txtCity.getText())){
            JOptionPane.showMessageDialog(null, "Please enter City Name");
            return;
        }

        boolean match = txtCarName.getText().matches("[a-zA-Z0-9\\s]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Car Name correctly");
            return;
        }

        match = txtManufacturer.getText().matches("[a-zA-Z\\s]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Manufacturer correctly");
            return;
        }
        
        match = txtCarTypr.getText().matches("[a-zA-Z\\s]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Car Type correctly");
            return;
        }
        
        match = txtModelNumber.getText().matches("[a-zA-Z0-9]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Model Number correctly");
            return;
        }
        
        match = txtSerialNo.getText().matches("[a-zA-Z0-9]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Serail Number correctly");
            return;
        }
        
        match = txtManufactureYear.getText().matches("[0-9][0-9][0-9][0-9]");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Manufacture year correctly");
            return;
        }
        
        SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
	    sdfrmt.setLenient(false);
            Date javaDate = sdfrmt.parse(txtCertiDate.getText()); 
      //  match = txtCertiDate.getText().matches("[1-12]\\[1-31]\\[0-9][0-9][0-9][0-9]");
        //if(match == false){
            //JOptionPane.showMessageDialog(null, "Enter Certificate Expiry Date correctly");
            //return;
       // }
        ///*  to do *****////////////////////////////////////////////////////////
        ///////////////////////////////////////////////
        ///////////////////////////////////////////////////
        //////////////////////////////////////////////////
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        //formatter.parse(txtCertiDate.getText());
        
        match = txtCity.getText().matches("[a-zA-Z\\s]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter City correctly");
            return;
        }
        
        match = txtSeat.getText().matches("[0-9]+");
        if(match == false){
            JOptionPane.showMessageDialog(null, "Enter Seat number correctly");
            return;
        }
        
        Car car1 = new Car();
        car1.setCarName(txtCarName.getText());
        car1.setCarType(txtCarTypr.getText());
        car1.setCity(txtCity.getText());
        car1.setMaintenanceCertiDate(txtCertiDate.getText());
        car1.setManufactureYear(txtManufactureYear.getText());
        car1.setManufacturer(txtManufacturer.getText());
        car1.setModelNumber(txtModelNumber.getText());
        car1.setSerialNumber(txtSerialNo.getText());
        car1.setSeatCount(Integer.parseInt(txtSeat.getText()));
        UUID idOne = UUID.randomUUID();
        String uid=(String.valueOf(idOne));
        car1.setUniqueId(uid);
        if(chckAvailable.isSelected()){
            uobj.getAvailableCarList().add(car1);
            uobj.setModifiedDate(new Date().toString());
            car1.setAvailable("A");
        }
        else{
            uobj.getBookedCarList().add(car1);
            uobj.setModifiedDate(new Date().toString());
            car1.setAvailable("U");
        }
        //this.availableCarList.add(car);
        
        
        JOptionPane.showMessageDialog(null, "Created successfully and Unique id is -"+uid);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Date is wrong");
        }
    }//GEN-LAST:event_btnCreateCarActionPerformed

    private void txtCarNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarNameActionPerformed

    private void txtManufacturerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManufacturerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManufacturerActionPerformed

    private void txtCarTyprActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCarTyprActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCarTyprActionPerformed

    private void txtModelNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModelNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelNumberActionPerformed

    private void txtSerialNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerialNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerialNoActionPerformed

    private void txtManufactureYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtManufactureYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtManufactureYearActionPerformed

    private void txtSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSeatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSeatActionPerformed

    private void txtCertiDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCertiDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCertiDateActionPerformed

    private void txtCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityActionPerformed

    private void comboCarTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCarTypeActionPerformed
        // TODO add your handling code here:
        int select = comboCarType.getSelectedIndex();
        if(select ==0){
            txtCarTypr.setText("");
            return;
        }
        txtCarTypr.setText(comboCarType.getItemAt(comboCarType.getSelectedIndex()));
    }//GEN-LAST:event_comboCarTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreateCar;
    private javax.swing.JCheckBox chckAvailable;
    private javax.swing.JComboBox<String> comboCarType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCarName;
    private javax.swing.JTextField txtCarTypr;
    private javax.swing.JTextField txtCertiDate;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtManufactureYear;
    private javax.swing.JTextField txtManufacturer;
    private javax.swing.JTextField txtModelNumber;
    private javax.swing.JTextField txtSeat;
    private javax.swing.JTextField txtSerialNo;
    // End of variables declaration//GEN-END:variables
}
