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
public class UserScreen extends javax.swing.JInternalFrame {

    Connection conector = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    /**
     * Creates new form UserScreen
     */
    public UserScreen() {
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
                txtusuario.setText(rs.getString(2));
                txtFone.setText(rs.getString(3));
                txtLogin.setText(rs.getString(4));
                txtSenha.setText(rs.getString(5));
                cboPerfil.setSelectedItem(rs.getString(6));
                txtfee.setText(rs.getString(7));
                cboCourse.setSelectedItem(rs.getString(8));
                txtmodule.setText(rs.getString(13));
            } else {
                JOptionPane.showMessageDialog(null, "User not found");
                txtusuario.setText(null);
                txtFone.setText(null);
                txtLogin.setText(null);
                txtSenha.setText(null);
                cboPerfil.setSelectedItem(null);
                txtfee.setText(null);
                cboCourse.setSelectedItem(null);
                txtmodule.setText(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void adicionar() {
        String sql = "insert into tbusuarios(idUser, usuario, fone, login, senha, perfil, fee, course, module) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = conector.prepareStatement(sql);
            pst.setString(1, txtiduser.getText());
            pst.setString(2, txtusuario.getText());
            pst.setString(3, txtFone.getText());
            pst.setString(4, txtLogin.getText());
            pst.setString(5, txtSenha.getText());
            pst.setString(6, cboPerfil.getSelectedItem().toString());
            pst.setString(7, txtfee.getText());
            pst.setString(8, cboCourse.getSelectedItem().toString());
            pst.setString(9, txtmodule.getText());
            //validating selected fields
            if ((txtiduser.getText().isEmpty())||(txtusuario.getText().isEmpty())|| (txtFone.getText().isEmpty()) || (txtLogin.getText().isEmpty()) || (txtSenha.getText().isEmpty())|| (txtfee.getText().isEmpty()) || (txtmodule.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Fill in all fields");
            } else {

                // coment: add new user
                int added = pst.executeUpdate();
                System.out.println(added);
                if (added > 0) {
                    JOptionPane.showMessageDialog(null, "User added successfully");
                    txtiduser.setText(null);
                    txtusuario.setText(null);
                    txtFone.setText(null);
                    txtLogin.setText(null);
                    txtSenha.setText(null);
                    cboPerfil.setSelectedItem(null);
                    txtfee.setText(null);
                    cboCourse.setSelectedItem(null);
                    txtmodule.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void alterar() {
        String sql = "update tbusuarios set usuario=?, fone=?, login=?, senha=?, perfil=?, fee=?, course=?, module=? where iduser=?";
        try {
            pst = conector.prepareStatement(sql);
            pst.setString(1, txtusuario.getText());
            pst.setString(2, txtFone.getText());
            pst.setString(3, txtLogin.getText());
            pst.setString(4, txtSenha.getText());
            pst.setString(5, cboPerfil.getSelectedItem().toString());
            pst.setString(6, txtfee.getText());
            pst.setString(7, cboCourse.getSelectedItem().toString());
            pst.setString(8, txtmodule.getText());
            pst.setString(9, txtiduser.getText());

            //validating selected fields
            if ((txtiduser.getText().isEmpty())||(txtusuario.getText().isEmpty())|| (txtFone.getText().isEmpty()) || (txtLogin.getText().isEmpty()) || (txtSenha.getText().isEmpty()) || (txtfee.getText().isEmpty()) || (txtmodule.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Fill in all fields");
            } else {

                // coment: add new user
                int added = pst.executeUpdate();
                System.out.println(added);
                if (added > 0) {
                    JOptionPane.showMessageDialog(null, "Data updated successfully");
                    txtiduser.setText(null);
                    txtusuario.setText(null);
                    txtFone.setText(null);
                    txtLogin.setText(null);
                    txtSenha.setText(null);
                    cboPerfil.setSelectedItem(null);
                    txtfee.setText(null);
                    cboCourse.setSelectedItem(null);
                    txtmodule.setText(null);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void remover() {
        int confirmation=JOptionPane.showConfirmDialog(null, "Are you sure you want to remove this user?", "Attention", JOptionPane.YES_NO_OPTION);
        String sql = "delete from tbusuarios where iduser=?";
        try {
            pst = conector.prepareStatement(sql);
            pst.setString(1, txtiduser.getText());
            int removed = pst.executeUpdate();
                if(removed>0){
                    JOptionPane.showMessageDialog(null, "User successfully removed");
                    txtiduser.setText(null);
                    txtusuario.setText(null);
                    txtFone.setText(null);
                    txtLogin.setText(null);
                    txtSenha.setText(null);
                    cboPerfil.setSelectedItem(null);
                    txtmodule.setText(null);
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

        lblidUser = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblFone = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        txtiduser = new javax.swing.JTextField();
        txtusuario = new javax.swing.JTextField();
        txtFone = new javax.swing.JTextField();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JPasswordField();
        cboPerfil = new javax.swing.JComboBox<>();
        btnCreate = new javax.swing.JButton();
        btnconsultar = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblcourse = new javax.swing.JLabel();
        cboCourse = new javax.swing.JComboBox<>();
        lblfee = new javax.swing.JLabel();
        txtfee = new javax.swing.JTextField();
        lblFone1 = new javax.swing.JLabel();
        txtmodule = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Users");
        setPreferredSize(new java.awt.Dimension(640, 480));

        lblidUser.setText("*ID");

        lblUsuario.setText("*Name");

        lblFone.setText("*Phone");

        lblLogin.setText("*Login");

        lblSenha.setText("*Password");

        lblPerfil.setText("*Profile");

        cboPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Student", "Lecturer", "Staff" }));
        cboPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboPerfilActionPerformed(evt);
            }
        });

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/iconmonstr-text-28-64.png"))); // NOI18N
        btnCreate.setToolTipText("Add User");
        btnCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnconsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/iconmonstr-magnifier-10-64.png"))); // NOI18N
        btnconsultar.setToolTipText("Search");
        btnconsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnconsultar.setPreferredSize(new java.awt.Dimension(80, 80));
        btnconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconsultarActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/iconmonstr-refresh-2-64.png"))); // NOI18N
        btnUpdate.setToolTipText("Update");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.setPreferredSize(new java.awt.Dimension(80, 80));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/iconmonstr-folder-26-64.png"))); // NOI18N
        btnRemove.setToolTipText("Remove User");
        btnRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRemove.setPreferredSize(new java.awt.Dimension(80, 80));
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        jLabel1.setText("*Required Fields");

        lblcourse.setText("*Course");

        cboCourse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "D_BSc_Science in Computing_1_Year", "D_BSc_Science in Computing_2_Year", "D_BSc_Science in Computing_3_Year", "C_BSc_Science in Computing_1_Year", "C_BSc_Science in Computing_2_Year", "C_BSc_Science in Computing_3_Year", "L_BSc_Science in Computing_1_Year", "L_BSc_Science in Computing_2_Year", "L_BSc_Science in Computing_3_Year", "D_BSc_Business_1_Year", "D_BSc_Business_2_Year", "D_BSc_Business_3_Year", "C_BSc_Business_1_Year", "C_BSc_Business_2_Year", "C_BSc_Business_3_Year", "L_BSc_Business_1_Year", "L_BSc_Business_2_Year", "L_BSc_Business_3_Year", "D_BSc_Finance_1_Year", "D_BSc_Finance_2_Year", "D_BSc_Finance_3_Year", "C_BSc_Finance_1_Year", "C_BSc_Finance_2_Year", "C_BSc_Finance_3_Year", "L_BSc_Finance_1_Year", "L_BSc_Finance_2_Year", "L_BSc_Finance_3_Year" }));
        cboCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCourseActionPerformed(evt);
            }
        });

        lblfee.setText("*Fee");

        txtfee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfeeActionPerformed(evt);
            }
        });

        lblFone1.setText("*Module");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblidUser, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblFone1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtmodule, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(lblFone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtiduser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(lblPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lblfee, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtfee)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(111, 111, 111))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(lblLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(btnCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnconsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCreate, btnRemove, btnUpdate, btnconsultar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblidUser)
                    .addComponent(txtiduser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblfee)
                    .addComponent(txtfee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPerfil)
                    .addComponent(cboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsuario)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFone)
                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblcourse, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFone1)
                    .addComponent(txtmodule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogin)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblSenha)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnconsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCreate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCreate, btnRemove, btnUpdate, btnconsultar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconsultarActionPerformed
        // TODO add your handling code here:
        consultar();
    }//GEN-LAST:event_btnconsultarActionPerformed

    private void cboPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboPerfilActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        adicionar();
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        alterar();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        remover();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void cboCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCourseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboCourseActionPerformed

    private void txtfeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfeeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnconsultar;
    private javax.swing.JComboBox<String> cboCourse;
    private javax.swing.JComboBox<String> cboPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblFone;
    private javax.swing.JLabel lblFone1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblcourse;
    private javax.swing.JLabel lblfee;
    private javax.swing.JLabel lblidUser;
    private javax.swing.JTextField txtFone;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtSenha;
    private javax.swing.JTextField txtfee;
    private javax.swing.JTextField txtiduser;
    private javax.swing.JTextField txtmodule;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}
