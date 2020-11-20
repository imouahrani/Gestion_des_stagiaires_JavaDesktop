/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modele.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controleur.*;
import java.awt.print.PrinterException;
import java.io.FileNotFoundException;
import modele.*;
import java.text.*;
import javax.print.*;

/**
 *
 * @author user
 */
public class Stagiaire extends javax.swing.JFrame {

    ConnectFormation cf = new ConnectFormation();

    public Stagiaire() {
        initComponents();
        setLocationRelativeTo(this);
        try {
            while (cf.rs.next()) {

                combformation.addItem(cf.rs.getObject("intitulefor").toString());

            }
        } catch (SQLException ex) {
            Logger.getLogger(Stagiaire.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void afficher(int ligne) {
        tfmatricule.setText(tablestagiaire.getValueAt(ligne, 0).toString());
        jtnom.setText(tablestagiaire.getValueAt(ligne, 1).toString());
        jtprenom.setText(tablestagiaire.getValueAt(ligne, 2).toString());
        jtnaissance.setText(tablestagiaire.getValueAt(ligne, 3).toString());
        jttel.setText(tablestagiaire.getValueAt(ligne, 4).toString());
        jtadresse.setText(tablestagiaire.getValueAt(ligne, 5).toString());
        combformation.setSelectedItem(tablestagiaire.getValueAt(ligne, 6).toString());

        if (tablestagiaire.getValueAt(ligne, 7).equals("Etudiant")) {
            rbetudiant.setSelected(true);
            rbpro.setSelected(false);

        } else {
            rbpro.setSelected(true);
            rbetudiant.setSelected(false);
        }

        //affichage de la photo selectonné dans la jtable
        ConnectStagiaire cos = new ConnectStagiaire();

        try {
            PreparedStatement ps1;

            ps1 = cos.c.connectbd().prepareStatement("select * from stagiaire where matricule= '" + tablestagiaire.getValueAt(tablestagiaire.getSelectedRow(), 0) + "'");
            cos.rs = ps1.executeQuery();

            while (cos.rs.next()) {//parcour de rs
                //réccupérer limage sous forme de tableau de type bite

                byte img[] = cos.rs.getBytes("photost");
                //mettre la photo dans un objet de type image icon

                ImageIcon im = new ImageIcon(img);
                //reccupérer l image de limage icon

                Image imgrecup = im.getImage();
                //adopter la taille de limage au jlbel

                Image nouvimg = imgrecup.getScaledInstance(lphoto.getWidth(), lphoto.getHeight(), Image.SCALE_SMOOTH);
                //appliquer l image a notre image icon

                ImageIcon imgfinal = new ImageIcon(nouvimg);
                lphoto.setIcon(imgfinal);
                lstr.setText(cos.rs.getObject("path").toString());

            }
        } catch (SQLException ex) {
            Logger.getLogger(Stagiaire.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void reset() {
        tfmatricule.setText(null);
        jtnom.setText(null);
        jtprenom.setText(null);
        jtnaissance.setText(null);
        jttel.setText(null);
        jtadresse.setText(null);
        combformation.setSelectedItem(null);
        rbetudiant.setSelected(false);
        rbpro.setSelected(false);
        lphoto.setIcon(null);
    }

    public void refresh() {
        DefaultTableModel dtm = new DefaultTableModel();
        dtm.setColumnCount(0);
        dtm.setRowCount(0);
        ConnectStagiaire cs = new ConnectStagiaire();
        dtm.addColumn("matricule");
        dtm.addColumn("nomst");
        dtm.addColumn("prenomst");
        dtm.addColumn("datest");
        dtm.addColumn("telst");
        dtm.addColumn("adressest");
        dtm.addColumn("formst");
        dtm.addColumn("statutst");

        try {
            cs.ps = cs.c.connectbd().prepareStatement("select * from stagiaire");
            cs.rs = ps.executeQuery();

            while (cs.rs.next()) {

                dtm.addRow(new Object[]{
                    cs.rs.getObject("matricule"),
                    cs.rs.getObject("nomst"),
                    cs.rs.getObject("prenomst"),
                    cs.rs.getObject("datest"),
                    cs.rs.getObject("telst"),
                    cs.rs.getObject("adressest"),
                    cs.rs.getObject("formst"),
                    cs.rs.getObject("statutst")});

            }
        } catch (SQLException ex) {
            Logger.getLogger(Stagiaire.class.getName()).log(Level.SEVERE, null, ex);
        }
        tablestagiaire.setModel(dtm);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        baffiche = new javax.swing.JButton();
        bajout = new javax.swing.JButton();
        bsupp = new javax.swing.JButton();
        bmodif = new javax.swing.JButton();
        bacct = new javax.swing.JButton();
        bimp = new javax.swing.JButton();
        bnotes = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtnom = new javax.swing.JTextField();
        jtprenom = new javax.swing.JTextField();
        jtnaissance = new javax.swing.JTextField();
        jttel = new javax.swing.JTextField();
        jtadresse = new javax.swing.JTextField();
        jpphoto = new javax.swing.JPanel();
        lphoto = new javax.swing.JLabel();
        rbetudiant = new javax.swing.JRadioButton();
        rbpro = new javax.swing.JRadioButton();
        bphoto = new javax.swing.JButton();
        lstr = new javax.swing.JLabel();
        combformation = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablestagiaire = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        combrecherche = new javax.swing.JComboBox<>();
        jtrecherche = new javax.swing.JTextField();
        brecherche = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        tfmatricule = new javax.swing.JTextField();
        ldate = new javax.swing.JLabel();
        tfdateaujourdhuis = new javax.swing.JTextField();
        fondstagiaire = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        baffiche.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        baffiche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/Ouvrir.png"))); // NOI18N
        baffiche.setText("Afficher");
        baffiche.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bafficheMouseClicked(evt);
            }
        });
        baffiche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bafficheActionPerformed(evt);
            }
        });

        bajout.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        bajout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/Ajouter.png"))); // NOI18N
        bajout.setText("Ajouter");
        bajout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajoutActionPerformed(evt);
            }
        });

        bsupp.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        bsupp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/Supprimer.png"))); // NOI18N
        bsupp.setText("Supprimer");
        bsupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsuppActionPerformed(evt);
            }
        });

        bmodif.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        bmodif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/modifier.png"))); // NOI18N
        bmodif.setText("Modifier");
        bmodif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodifActionPerformed(evt);
            }
        });

        bacct.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        bacct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/actualiser.PNG"))); // NOI18N
        bacct.setText("Acctualier");
        bacct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bacctActionPerformed(evt);
            }
        });

        bimp.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        bimp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/imprimer.png"))); // NOI18N
        bimp.setText("Imprimer");
        bimp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bimpActionPerformed(evt);
            }
        });

        bnotes.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        bnotes.setText("Notes");
        bnotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnotesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bacct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bimp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bnotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bmodif, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bsupp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bajout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(baffiche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(baffiche)
                .addGap(18, 18, 18)
                .addComponent(bajout)
                .addGap(18, 18, 18)
                .addComponent(bsupp)
                .addGap(40, 40, 40)
                .addComponent(bmodif)
                .addGap(28, 28, 28)
                .addComponent(bacct)
                .addGap(34, 34, 34)
                .addComponent(bimp)
                .addGap(18, 18, 18)
                .addComponent(bnotes, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 200, 490));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Veuillez renseigner les champs", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("Nom:");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Prénom:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Date de naissance:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Téléphone:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Adresse:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel6.setText("Formation:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel7.setText("Statut:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jtnom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtnomActionPerformed(evt);
            }
        });
        jPanel3.add(jtnom, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 173, -1));
        jPanel3.add(jtprenom, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 170, -1));
        jPanel3.add(jtnaissance, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 170, -1));
        jPanel3.add(jttel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 170, -1));
        jPanel3.add(jtadresse, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 175, -1));

        jpphoto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpphoto.add(lphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 95, 113));

        jPanel3.add(jpphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, -1));

        rbetudiant.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rbetudiant.setText("Etudiant");
        rbetudiant.setOpaque(false);
        rbetudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbetudiantActionPerformed(evt);
            }
        });
        jPanel3.add(rbetudiant, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        rbpro.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        rbpro.setText("Professionnel");
        rbpro.setOpaque(false);
        rbpro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbproActionPerformed(evt);
            }
        });
        jPanel3.add(rbpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        bphoto.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        bphoto.setText("Changer la photo");
        bphoto.setOpaque(false);
        bphoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bphotoActionPerformed(evt);
            }
        });
        jPanel3.add(bphoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, -1, -1));
        jPanel3.add(lstr, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 190, 15));

        combformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combformationActionPerformed(evt);
            }
        });
        jPanel3.add(combformation, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 164, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel10.setText("Age:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        lage.setText("......");
        jPanel3.add(lage, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 70, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 500, 330));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tablestagiaire.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablestagiaire.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablestagiaireMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablestagiaire);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 570, 120));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel9.setText("Recherche par:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, 30));

        combrecherche.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        combrecherche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Identifiant", "Nom", " " }));
        getContentPane().add(combrecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, -1));

        jtrecherche.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtrechercheFocusGained(evt);
            }
        });
        jtrecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtrechercheActionPerformed(evt);
            }
        });
        getContentPane().add(jtrecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 150, 30));

        brecherche.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/rechercher.png"))); // NOI18N
        brecherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brechercheActionPerformed(evt);
            }
        });
        getContentPane().add(brecherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Matricule:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 80, 30));

        tfmatricule.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfmatriculeFocusGained(evt);
            }
        });
        tfmatricule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfmatriculeActionPerformed(evt);
            }
        });
        getContentPane().add(tfmatricule, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 140, 30));

        ldate.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        ldate.setText("Date:");
        getContentPane().add(ldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));
        getContentPane().add(tfdateaujourdhuis, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 120, 20));

        fondstagiaire.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        fondstagiaire.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ihm/FondGrand.png"))); // NOI18N
        fondstagiaire.setText("jLabel1");
        fondstagiaire.setOpaque(true);
        getContentPane().add(fondstagiaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 860, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtnomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtnomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtnomActionPerformed

    private void bmodifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodifActionPerformed
        if (JOptionPane.showConfirmDialog(this, "vous etes sur de modifier?", "confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {

                ConnectStagiaire cos = new ConnectStagiaire();

                // TODO add your handling code here:
                String req = "update stagiaire set nomst = ?, prenomst=?, datest = ?, telst = ?, adressest = ?, formst = ?, statutst = ?, photost = ?  where matricule = '"
                        + tfmatricule.getText() + "'";

                PreparedStatement ps;

                ps = cos.c.connectbd().prepareStatement(req);
                ps.setString(1, jtnom.getText());
                ps.setString(2, jtprenom.getText());
                ps.setString(3, jtnaissance.getText());
                ps.setString(4, jttel.getText());
                ps.setString(5, jtadresse.getText());
                ps.setString(6, combformation.getSelectedItem().toString());
                if (rbetudiant.isSelected()) {
                    ps.setString(7, rbetudiant.getText());

                } else {
                    ps.setString(7, rbpro.getText());

                    /*reccuperer la photo*/
                }
                InputStream is = new FileInputStream(lstr.getText());
                ps.setBlob(8, is);
                ps.execute();

                JOptionPane.showMessageDialog(this, "modification avec succès!");
                refresh();
                reset();
            } catch (SQLException ex) {
                Logger.getLogger(FenetreEnseignant.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "modification non réussie!");

            } catch (FileNotFoundException ex) {
                Logger.getLogger(Stagiaire.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
    }//GEN-LAST:event_bmodifActionPerformed

    private void combformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combformationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combformationActionPerformed

    private void rbproActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbproActionPerformed
        if (rbpro.isSelected()) {
            rbetudiant.setSelected(false);
        }
    }//GEN-LAST:event_rbproActionPerformed

    private void jtrechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtrechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtrechercheActionPerformed

    private void jtrechercheFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtrechercheFocusGained


    }//GEN-LAST:event_jtrechercheFocusGained

    private void tfmatriculeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfmatriculeFocusGained
        String ch = combformation.getSelectedIndex() + 1 + jtnom.getText().substring(0, 3).toUpperCase() + (jtprenom.getText().charAt(0) + "").toUpperCase() + jtnaissance.getText().substring(8);
        String ch1;

        if (rbetudiant.isSelected()) {

            ch1 = ch + rbetudiant.getText().substring(0, 1).toUpperCase();
        } else {

            ch1 = ch + rbpro.getText().substring(0, 1).toUpperCase();

        }
        int ch3 = tablestagiaire.getRowCount();
        tfmatricule.setText(ch1 + ch3);
    }//GEN-LAST:event_tfmatriculeFocusGained

    private void rbetudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbetudiantActionPerformed
        if (rbetudiant.isSelected()) {
            rbpro.setSelected(false);
        }
    }//GEN-LAST:event_rbetudiantActionPerformed
    String str; //reccuperer le chemin ou se trouve la photo
    private void bphotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bphotoActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        //préciser le dossier ou se trouvent les images
        fileChooser.setCurrentDirectory(new File("D:\\JAVA ADMIN INSTALLABLE\\Table avec images\\PHTOS STAGIAIRES"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image", "jpg", "png", "gif");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File fichierselectionne = fileChooser.getSelectedFile();
            String path = fichierselectionne.getAbsolutePath();
            ImageIcon img = new ImageIcon(path);
            Image imgrec = img.getImage();
            Image nimage = imgrec.getScaledInstance(lphoto.getWidth(),
                    lphoto.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imgfinal = new ImageIcon(imgrec);
            lphoto.setIcon(imgfinal);
            str = path;
            lstr.setText(str);
        } else if (result == JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Aucun choix effectué");
        }    }//GEN-LAST:event_bphotoActionPerformed
    PreparedStatement ps;
    private void bajoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajoutActionPerformed
        Connecte c = new Connecte();
        String req = "insert into stagiaire(matricule, nomst, prenomst, datest, telst, adressest, formst, statutst, photost, path)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = (PreparedStatement) c.connectbd().prepareStatement(req);
            ps.setString(1, tfmatricule.getText());
            ps.setString(2, jtnom.getText());
            ps.setString(3, jtprenom.getText());
            ps.setString(4, jtnaissance.getText());
            ps.setString(5, jttel.getText());
            ps.setString(6, jtadresse.getText());
            ps.setString(7, combformation.getSelectedItem().toString());
            if (rbetudiant.isSelected()) {
                ps.setString(8, rbetudiant.getText());

            } else {
                ps.setString(8, rbpro.getText());

                /*reccuperer la photo*/
            }
            InputStream is = new FileInputStream(str);
            ps.setBlob(9, is);

        } catch (Exception e) {
        }

        try {
            ps.setString(10, lstr.getText());

            ps.execute();

            JOptionPane.showMessageDialog(this, "ajout reussie");
            refresh();
        } catch (SQLException ex) {
            Logger.getLogger(Stagiaire.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "echec d'ajout" + ex.getMessage());

        }


    }//GEN-LAST:event_bajoutActionPerformed

    private void tfmatriculeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfmatriculeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfmatriculeActionPerformed

    private void bafficheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bafficheActionPerformed
        DefaultTableModel dtm = new DefaultTableModel();
        ConnectStagiaire cs = new ConnectStagiaire();
        dtm.addColumn("matricule");
        dtm.addColumn("nomst");
        dtm.addColumn("prenomst");
        dtm.addColumn("datest");
        dtm.addColumn("telst");
        dtm.addColumn("adressest");
        dtm.addColumn("formst");
        dtm.addColumn("statutst");

        try {
            while (cs.rs.next()) {

                dtm.addRow(new Object[]{
                    cs.rs.getObject("matricule"),
                    cs.rs.getObject("nomst"),
                    cs.rs.getObject("prenomst"),
                    cs.rs.getObject("datest"),
                    cs.rs.getObject("telst"),
                    cs.rs.getObject("adressest"),
                    cs.rs.getObject("formst"),
                    cs.rs.getObject("statutst")});

            }
            tablestagiaire.setModel(dtm);
        } catch (SQLException ex) {
            Logger.getLogger(Stagiaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bafficheActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked


    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tablestagiaireMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablestagiaireMouseClicked
        afficher(tablestagiaire.getSelectedRow());
        Calcules ca = new Calcules();
        lage.setText("" + ca.calculeAge(Integer.parseInt(tfdateaujourdhuis.getText().substring(6)), Integer.parseInt(jtnaissance.getText().substring(6))));

    }//GEN-LAST:event_tablestagiaireMouseClicked

    private void bsuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsuppActionPerformed
        if (JOptionPane.showConfirmDialog(this, "vous etes sure de supp", "confirmation", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            try {
                PreparedStatement ps1;
                ConnectStagiaire cos = new ConnectStagiaire();
                //lstr.setText(cos.rs.getObject("path").toString());

                ps1 = cos.c.connectbd().prepareStatement("delete from stagiaire where matricule ='" + tfmatricule.getText() + "'");
                ps1.execute();

                JOptionPane.showMessageDialog(this, "supp reussie!");
                refresh();
                reset();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "echec de supp!");

            }
        }

    }//GEN-LAST:event_bsuppActionPerformed

    private void bafficheMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bafficheMouseClicked


    }//GEN-LAST:event_bafficheMouseClicked

    private void bimpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bimpActionPerformed

        MessageFormat header = new MessageFormat("Liste de stagiaires");
        MessageFormat footer = new MessageFormat("page, {0, number, integer}");
        try {
            tablestagiaire.print(JTable.PrintMode.NORMAL, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(Stagiaire.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_bimpActionPerformed

    private void bnotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnotesActionPerformed

        Notes n = new Notes();
        n.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_bnotesActionPerformed

    private void brechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brechercheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brechercheActionPerformed

    private void bacctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bacctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bacctActionPerformed

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
            java.util.logging.Logger.getLogger(Stagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stagiaire().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bacct;
    private javax.swing.JButton baffiche;
    private javax.swing.JButton bajout;
    private javax.swing.JButton bimp;
    private javax.swing.JButton bmodif;
    private javax.swing.JButton bnotes;
    private javax.swing.JButton bphoto;
    private javax.swing.JButton brecherche;
    private javax.swing.JButton bsupp;
    private javax.swing.JComboBox<String> combformation;
    private javax.swing.JComboBox<String> combrecherche;
    private javax.swing.JLabel fondstagiaire;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpphoto;
    private javax.swing.JTextField jtadresse;
    private javax.swing.JTextField jtnaissance;
    public static javax.swing.JTextField jtnom;
    public static javax.swing.JTextField jtprenom;
    private javax.swing.JTextField jtrecherche;
    private javax.swing.JTextField jttel;
    private javax.swing.JLabel lage;
    private javax.swing.JLabel ldate;
    private javax.swing.JLabel lphoto;
    private javax.swing.JLabel lstr;
    private javax.swing.JRadioButton rbetudiant;
    private javax.swing.JRadioButton rbpro;
    private javax.swing.JTable tablestagiaire;
    private javax.swing.JTextField tfdateaujourdhuis;
    public static javax.swing.JTextField tfmatricule;
    // End of variables declaration//GEN-END:variables
}
