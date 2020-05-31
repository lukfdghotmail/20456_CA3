/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dorsetscreen;
import java.sql.*;
import dorsetdata.ConnectionModule;
import javax.swing.JOptionPane;
/**
 *
 * @author lukfd
 */
public class TimetableScreen extends javax.swing.JInternalFrame {
    Connection conector = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form TimetableScreen
     */
    public TimetableScreen() {
        initComponents();
        conector = ConnectionModule.conector();
    }
private void consultar() {
        String sql = "select * from tbusuarios where iduser=?";
        try {
            pst = conector.prepareStatement(sql);
            pst.setString(1, txtiduser.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtactivities_1.setText(rs.getString(31));
                txtactivities_2.setText(rs.getString(32));
                txtactivities_3.setText(rs.getString(33));
                txtactivities_4.setText(rs.getString(34));                
            } else {
                JOptionPane.showMessageDialog(null, "User not found");
                txtiduser.setText(null);
                txtactivities_1.setText(null);
                txtactivities_2.setText(null);
                txtactivities_3.setText(null);
                txtactivities_4.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void adicionar() {
        String sql = "update tbusuarios set activities_1=?, activities_2=?, activities_3=?, activities_4=?, where iduser=?";
        try {
            pst = conector.prepareStatement(sql);
            pst.setString(1, txtactivities_1.getText());
            pst.setString(2, txtactivities_2.getText());
            pst.setString(3, txtactivities_3.getText());
            pst.setString(4, txtactivities_4.getText());
            pst.setString(5, txtiduser.getText());

            //validating selected fields
            if ((txtiduser.getText().isEmpty())|| (txtactivities_1.getText().isEmpty()) || (txtactivities_2.getText().isEmpty()) || (txtactivities_3.getText().isEmpty()) || (txtactivities_4.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Fill in all fields");
            } else {

                // coment: add new user
                int added = pst.executeUpdate();
                System.out.println(added);
                if (added > 0) {
                    JOptionPane.showMessageDialog(null, "Updated successfully");
                    txtiduser.setText(null);
                    txtactivities_1.setText(null);
                    txtactivities_2.setText(null);
                    txtactivities_3.setText(null);
                    txtactivities_4.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        txtiduser = new javax.swing.JTextField();
        txtactivities_3 = new javax.swing.JTextField();
        btnConfirm = new javax.swing.JButton();
        btnSearch = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        txtactivities_1 = new javax.swing.JTextField();
        lblIdUser2 = new javax.swing.JLabel();
        lblIdUser3 = new javax.swing.JLabel();
        txtactivities_2 = new javax.swing.JTextField();
        lblIdUser4 = new javax.swing.JLabel();
        txtactivities_4 = new javax.swing.JTextField();
        lblIdUser5 = new javax.swing.JLabel();
        lblIdUser6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Timetable");

        txtiduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtiduserActionPerformed(evt);
            }
        });

        txtactivities_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtactivities_3ActionPerformed(evt);
            }
        });

        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/iconmonstr-check-mark-8-64.png"))); // NOI18N
        btnConfirm.setToolTipText("Add Payment");
        btnConfirm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirm.setPreferredSize(new java.awt.Dimension(80, 80));
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/iconmonstr-magnifier-10-64.png"))); // NOI18N
        btnSearch.setToolTipText("Consult Payment");
        btnSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearch.setPreferredSize(new java.awt.Dimension(80, 80));
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTitle.setText("Timetable - 2020");

        txtactivities_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtactivities_1ActionPerformed(evt);
            }
        });

        lblIdUser2.setText("Trimester_1");

        lblIdUser3.setText("Trimester_2");

        txtactivities_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtactivities_2ActionPerformed(evt);
            }
        });

        lblIdUser4.setText("Trimester_3");

        txtactivities_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtactivities_4ActionPerformed(evt);
            }
        });

        lblIdUser5.setText("Trimester_4");

        lblIdUser6.setText("User ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(208, 208, 208))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblIdUser2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtactivities_1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblIdUser3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtactivities_2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblIdUser4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtactivities_3, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblIdUser5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtactivities_4, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(lblIdUser6)
                        .addGap(18, 18, 18)
                        .addComponent(txtiduser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdUser6)
                    .addComponent(txtiduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdUser2)
                    .addComponent(txtactivities_1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtactivities_2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdUser3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtactivities_3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdUser4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdUser5)
                    .addComponent(txtactivities_4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtiduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtiduserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtiduserActionPerformed

    private void txtactivities_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtactivities_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtactivities_3ActionPerformed

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtactivities_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtactivities_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtactivities_1ActionPerformed

    private void txtactivities_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtactivities_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtactivities_2ActionPerformed

    private void txtactivities_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtactivities_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtactivities_4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel lblIdUser2;
    private javax.swing.JLabel lblIdUser3;
    private javax.swing.JLabel lblIdUser4;
    private javax.swing.JLabel lblIdUser5;
    private javax.swing.JLabel lblIdUser6;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtactivities_1;
    private javax.swing.JTextField txtactivities_2;
    private javax.swing.JTextField txtactivities_3;
    private javax.swing.JTextField txtactivities_4;
    private javax.swing.JTextField txtiduser;
    // End of variables declaration//GEN-END:variables
}