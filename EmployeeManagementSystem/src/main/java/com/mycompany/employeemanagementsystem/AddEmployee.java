/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.employeemanagementsystem;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.text.*;
/**
 *
 * @author ashley
 */
public class AddEmployee extends javax.swing.JFrame {
    ArrayList<Job> jobs;
    ArrayList<Employee> employees;
    DecimalFormat formatter;
    /**
     * Creates new form AddEmployee
     */
    public AddEmployee() {
        initComponents();
        
        formatter = new DecimalFormat("#,###.00");
        
        jobs = new ArrayList<Job>();
        employees = new ArrayList<Employee>();
        
        populateArrayList();
        
        String [] jobsArray = new String[jobs.size()] ;
        
        for (int i=0; i< jobs.size(); i++){
            jobsArray[i] = jobs.get(i).getNameOfJob() + ", R" + formatter.format(jobs.get(i).getSalary());
           
        }
            
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(jobsArray));
    }
    
    
    public void populateArrayList(){
        try{
            
            FileInputStream file = new FileInputStream("Jobs.dat");
            ObjectInputStream inputFile = new ObjectInputStream(file);
            
            // check if its not the end of file
            boolean endOfFile = false;
            
            while(!endOfFile){
                try{
                    
                    jobs.add((Job) inputFile.readObject());
                
                }catch(EOFException e){
                    endOfFile = true;
                    
                }catch(Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage());
                }
                
            }
            
            inputFile.close();
        
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        try{
            
            FileInputStream file2 = new FileInputStream("Employees.dat");
            ObjectInputStream inputFile2 = new ObjectInputStream(file2);
            
            // check if its not the end of file
            boolean endOfFile = false;
            
            while(!endOfFile){
                try{
                    
                    employees.add((Employee) inputFile2.readObject());
                
                }catch(EOFException e){
                    endOfFile = true;
                    
                }catch(Exception f){
                    JOptionPane.showMessageDialog(null, f.getMessage() + "test");
                }
                
            }
            
            inputFile2.close();
        
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    public void saveEmployeesToFile(){
        
        try{
            FileOutputStream file = new FileOutputStream("Employees.dat");
            ObjectOutputStream outputFile = new ObjectOutputStream(file);
            
            for (int i=0; i< employees.size(); i++){
                outputFile.writeObject(employees.get(i));
            }
            
            outputFile.close();
            JOptionPane.showMessageDialog(null, "Successfully saved!");
            this.dispose();
            
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        employeeNameTextField = new javax.swing.JTextField();
        employeeSurnameTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        staffNumberTextField = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New Employee");

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 3, 24)); // NOI18N
        jLabel1.setText("Add a new Employee by entering the data below");

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel2.setText("Enter employee surnname:");

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel3.setText("Enter employee name:");

        employeeNameTextField.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        employeeNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeNameTextFieldActionPerformed(evt);
            }
        });

        employeeSurnameTextField.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        employeeSurnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employeeSurnameTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel4.setText("Enter the staff number:");

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        jLabel5.setText("Choose a job:");

        staffNumberTextField.setFont(new java.awt.Font("Liberation Sans", 1, 15)); // NOI18N
        staffNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffNumberTextFieldActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(staffNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(51, 51, 51)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(employeeSurnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(employeeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(13, 13, 13))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(employeeNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(employeeSurnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(staffNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeNameTextFieldActionPerformed

    private void employeeSurnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employeeSurnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employeeSurnameTextFieldActionPerformed

    private void staffNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_staffNumberTextFieldActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (employeeNameTextField.getText().isEmpty() || employeeSurnameTextField.getText().isEmpty() ||
                staffNumberTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter all fields" );
        }else {
            String name = employeeNameTextField.getText().trim();
            String surname = employeeSurnameTextField.getText().trim();
            int jobIndex = jComboBox1.getSelectedIndex();
            Job job = jobs.get(jobIndex);
            int staffNr  = Integer.parseInt(staffNumberTextField.getText().trim());
            Employee employee = new Employee(name, surname, job, staffNr);
            
            employees.add(employee);
            
            saveEmployeesToFile();
        }
            

    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField employeeNameTextField;
    private javax.swing.JTextField employeeSurnameTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField staffNumberTextField;
    // End of variables declaration//GEN-END:variables
}
