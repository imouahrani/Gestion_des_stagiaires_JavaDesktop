/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.util.Locale;
import modele.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class FenetreEnseignant extends javax.swing.JFrame {

    /**
     * Creates new form FenetreEnseignant
     */
    Connecte co = new Connecte();
    Statement st;
    ResultSet rs;
    DefaultTableModel dtm = new DefaultTableModel();

    public FenetreEnseignant() {
        initComponents();
        setLocationRelativeTo(this);
        try {
            st = co.connectbd().createStatement();
            rs = st.executeQuery("select * from enseignant");
            //Création du modèle
            dtm.addColumn("Id");

            dtm.addColumn("Nom");
            dtm.addColumn("Prénom");
            dtm.addColumn("Age");
            dtm.addColumn("Diplôme");

            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getObject("idEns"), rs.getObject("nomEns"),
                    rs.getObject("prenomEns"),
                    rs.getObject("ageEns"),
                    rs.getObject("diplomeEns")});

            }
            tableEnseignant.setModel(dtm);

        } catch (SQLException ex) {
            Logger.getLogger(FenetreEnseignant.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //methode daffichage d'un tuple
    public void afficher(int ligne) {

        tfnom.setText(tableEnseignant.getValueAt(ligne, 1).toString());
        tfpre.setText(tableEnseignant.getValueAt(ligne, 2).toString());
        tfage.setText(tableEnseignant.getValueAt(ligne, 3).toString());
        tfdip.setSelectedItem(tableEnseignant.getValueAt(ligne, 4));
    }

    public void reset() {

        tfnom.setText(null);
        tfpre.setText(null);
        tfage.setText(null);
        tfdip.setSelectedItem("Licence");
    }

    public void refresh() {
        dtm.setColumnCount(0);
        dtm.setRowCount(0);

        try {
            st = co.connectbd().createStatement();
            rs = st.executeQuery("select * from enseignant");
            //Création du modèle
            dtm.addColumn("idEns");
            dtm.addColumn("Nom");
            dtm.addColumn("Prénom");
            dtm.addColumn("Age");
            dtm.addColumn("Diplôme");

            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getObject("idEns"), rs.getObject("nomEns"),
                    rs.getObject("prenomEns"),
                    rs.getObject("ageEns"),
                    rs.getObject("diplomeEns")});

            }
            tableEnseignant.setModel(dtm);

        } catch (SQLException ex) {
            Logger.getLogger(FenetreEnseignant.class.getName()).log(Level.SEVERE, null, ex);
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

        jMenuItem1 = new javax.swing.JMenuItem();
        ltitre = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfnom = new javax.swing.JTextField();
        tfpre = new javax.swing.JTextField();
        tfage = new javax.swing.JTextField();
        tfdip = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        bajout = new javax.swing.JButton();
        bsupp = new javax.swing.JButton();
        bmodif = new javax.swing.JButton();
        brecherche = new javax.swing.JButton();
        tfrecherche = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableEnseignant = new javax.swing.JTable();
        tfid = new javax.swing.JTextField();
        lfond = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ltitre.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        ltitre.setForeground(new java.awt.Color(204, 204, 204));
        ltitre.setText("GESTION DES ENSEIGNANTS");
        getContentPane().add(ltitre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Renseignez les champs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Nom:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Prénom:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Age:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Diplôme:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        tfnom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfnomFocusLost(evt);
            }
        });
        tfnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnomActionPerformed(evt);
            }
        });
        jPanel1.add(tfnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 160, -1));

        tfpre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfpreFocusLost(evt);
            }
        });
        jPanel1.add(tfpre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 160, -1));
        jPanel1.add(tfage, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 160, -1));

        tfdip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Licence", "Master", "Doctorat", " " }));
        tfdip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdipActionPerformed(evt);
            }
        });
        jPanel1.add(tfdip, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 40, 310, 200));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mise a jour", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/Ajouter.png"))); // NOI18N
        bajout.setText("Ajouter");
        bajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajoutActionPerformed(evt);
            }
        });
        jPanel2.add(bajout, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 107, -1));

        bsupp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/Supprimer.png"))); // NOI18N
        bsupp.setText("Supprimer");
        bsupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsuppActionPerformed(evt);
            }
        });
        jPanel2.add(bsupp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 107, -1));

        bmodif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/modifier.png"))); // NOI18N
        bmodif.setText("Modifier");
        bmodif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodifActionPerformed(evt);
            }
        });
        jPanel2.add(bmodif, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 107, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 270, 200));

        brecherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/rechercher.png"))); // NOI18N
        brecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brechercheActionPerformed(evt);
            }
        });
        getContentPane().add(brecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 60, -1, -1));

        tfrecherche.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfrechercheFocusGained(evt);
            }
        });
        getContentPane().add(tfrecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, 170, 30));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableEnseignant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableEnseignant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEnseignantMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableEnseignant);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 680, 170));

        tfid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfidActionPerformed(evt);
            }
        });
        getContentPane().add(tfid, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, -1, -1));

        lfond.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/FondPetit.png"))); // NOI18N
        getContentPane().add(lfond, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 490));

        jMenu1.setText("Fichier");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Nouveau");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Quitter");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnomActionPerformed

    private void tfdipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdipActionPerformed

    private void tableEnseignantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEnseignantMouseClicked
        afficher(tableEnseignant.getSelectedRow());
    }//GEN-LAST:event_tableEnseignantMouseClicked

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        reset();    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void bajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajoutActionPerformed
        try {
            st = co.connectbd().createStatement();
            st.executeUpdate("insert into enseignant(nomEns, prenomEns, ageEns, diplomeEns) "
                    + "values('" + tfnom.getText() + "','" + tfpre.getText() + "','" + tfage.getText()
                    + "','" + tfdip.getSelectedItem() + "')");

        } catch (SQLException ex) {
            Logger.getLogger(FenetreEnseignant.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Echec insertion non réussie");

        }
    }//GEN-LAST:event_bajoutActionPerformed

    private void tfidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfidActionPerformed

    private void bsuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsuppActionPerformed
        if (JOptionPane.showConfirmDialog(this, "vous etes sur de supp?", "confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                st.executeUpdate("delete from enseignant where idEns ='" + tableEnseignant.getValueAt(tableEnseignant.getSelectedRow(), 0) + "'");

                JOptionPane.showMessageDialog(this, "suppression avec succès!");
                refresh();
                reset();
            } catch (SQLException ex) {
                Logger.getLogger(FenetreEnseignant.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Echec de suppression!");

            }
        }


    }//GEN-LAST:event_bsuppActionPerformed

    private void bmodifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodifActionPerformed
        if (JOptionPane.showConfirmDialog(this, "vous etes sur de modifier?", "confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                // TODO add your handling code here:
                st.executeUpdate("update enseignant set nomEns = '" + tfnom.getText() + "', prenomEns='" + tfpre.getText() + "', ageEns ='" + tfage.getText() + "',diplomeEns ='" + tfdip.getSelectedItem() + "' where idEns = '" + tableEnseignant.getValueAt(tableEnseignant.getSelectedRow(), 0) + "'");

                JOptionPane.showMessageDialog(this, "modification avec succès!");
                refresh();
                reset();
            } catch (SQLException ex) {
                Logger.getLogger(FenetreEnseignant.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "modification non réussie!");

            }
        }
    }//GEN-LAST:event_bmodifActionPerformed

    private void brechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brechercheActionPerformed

        boolean trouve;

        try {
            st = co.connectbd().createStatement();
            rs = st.executeQuery("select * from enseignant where nomEns = '" + tfrecherche.getText() + "'");
            dtm.setRowCount(0);
            while (rs.next()) {
                dtm.addRow(new Object[]{rs.getObject("idEns"), rs.getObject("nomEns"),
                    rs.getObject("prenomEns"),
                    rs.getObject("ageEns"),
                    rs.getObject("diplomeEns")});

            }
            if (dtm.getRowCount() != 0) {
                JOptionPane.showMessageDialog(this, "Enseignant trouvé!!");

                trouve = true;
                afficher(0);
                
                

            } else {
                JOptionPane.showMessageDialog(this, "Enseignant nexite pas !");

            }
        } catch (SQLException ex) {
            Logger.getLogger(FenetreEnseignant.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_brechercheActionPerformed

    private void tfnomFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfnomFocusLost
        tfnom.setText(tfnom.getText().toUpperCase());
    }//GEN-LAST:event_tfnomFocusLost

    private void tfpreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfpreFocusLost

        tfpre.setText(tfpre.getText().substring(0, 1).toUpperCase() + tfpre.getText().substring(1).toLowerCase());

    }//GEN-LAST:event_tfpreFocusLost

    private void tfrechercheFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfrechercheFocusGained

tfnom.setText(null);
refresh();
    }//GEN-LAST:event_tfrechercheFocusGained

    /*
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
            java.util.logging.Logger.getLogger(FenetreEnseignant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FenetreEnseignant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FenetreEnseignant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FenetreEnseignant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FenetreEnseignant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bajout;
    private javax.swing.JButton bmodif;
    private javax.swing.JButton brecherche;
    private javax.swing.JButton bsupp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lfond;
    private javax.swing.JLabel ltitre;
    private javax.swing.JTable tableEnseignant;
    private javax.swing.JTextField tfage;
    private javax.swing.JComboBox<String> tfdip;
    private javax.swing.JTextField tfid;
    private javax.swing.JTextField tfnom;
    private javax.swing.JTextField tfpre;
    private javax.swing.JTextField tfrecherche;
    // End of variables declaration//GEN-END:variables
}