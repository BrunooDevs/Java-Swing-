package Public;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import sistema.util.LoginDAO;

/**
 *
 * @author Owner
 */
public class PanelRegistro extends javax.swing.JPanel {

    private Color color1 = new Color(85, 195, 220);
    private JPanel Panelingresar;
    private JScrollPane jScrollpane;
    private PanelUserPass panelusuerpass;
    private ImageIcon imgalerta;
    private LoginDAO dao;

    public PanelRegistro(JPanel Panelingresar, JScrollPane jScrollpane, LoginDAO dao) {
        initComponents();

        this.Panelingresar = Panelingresar;
        this.jScrollpane = jScrollpane;
        this.dao = dao;

        IniciarComponentes();

    }

    public void IniciarComponentes() {
        jButton1.setBorder(new CirculoBoton(25));
        jButton2.setBorder(new CirculoBoton(25));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btningresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtusuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtusuario1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtusuario2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtusuario3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtusuario4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtusuario5 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(620, 680));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(620, 680));

        btningresar.setFont(new java.awt.Font("Nirmala UI", 3, 24)); // NOI18N
        btningresar.setText(">");
        btningresar.setContentAreaFilled(false);
        btningresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btningresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btningresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btningresarMouseExited(evt);
            }
        });
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 3, 36)); // NOI18N
        jLabel3.setText("Registro");

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Iniciar Sesion");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Olvide mi contraseña");
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtusuario.setFont(new java.awt.Font("Roboto Medium", 3, 16)); // NOI18N
        txtusuario.setForeground(new java.awt.Color(85, 195, 220));
        txtusuario.setCaretColor(new java.awt.Color(204, 204, 204));
        txtusuario.setSelectionColor(new java.awt.Color(85, 195, 220));
        txtusuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtusuarioMousePressed(evt);
            }
        });
        txtusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuarioActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto Medium", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellidos:");

        txtusuario1.setFont(new java.awt.Font("Roboto Medium", 3, 16)); // NOI18N
        txtusuario1.setForeground(new java.awt.Color(85, 195, 220));
        txtusuario1.setCaretColor(new java.awt.Color(204, 204, 204));
        txtusuario1.setSelectionColor(new java.awt.Color(85, 195, 220));
        txtusuario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtusuario1MousePressed(evt);
            }
        });
        txtusuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuario1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Domicilio:");

        txtusuario2.setFont(new java.awt.Font("Roboto Medium", 3, 16)); // NOI18N
        txtusuario2.setForeground(new java.awt.Color(85, 195, 220));
        txtusuario2.setCaretColor(new java.awt.Color(204, 204, 204));
        txtusuario2.setSelectionColor(new java.awt.Color(85, 195, 220));
        txtusuario2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtusuario2MousePressed(evt);
            }
        });
        txtusuario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuario2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Fecha de nacimiento:");

        txtusuario3.setFont(new java.awt.Font("Roboto Medium", 3, 16)); // NOI18N
        txtusuario3.setForeground(new java.awt.Color(85, 195, 220));
        txtusuario3.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtusuario3.setCaretColor(new java.awt.Color(204, 204, 204));
        txtusuario3.setSelectionColor(new java.awt.Color(85, 195, 220));
        txtusuario3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtusuario3MousePressed(evt);
            }
        });
        txtusuario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuario3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Telefono:");

        txtusuario4.setFont(new java.awt.Font("Roboto Medium", 3, 16)); // NOI18N
        txtusuario4.setForeground(new java.awt.Color(85, 195, 220));
        txtusuario4.setCaretColor(new java.awt.Color(204, 204, 204));
        txtusuario4.setSelectionColor(new java.awt.Color(85, 195, 220));
        txtusuario4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtusuario4MousePressed(evt);
            }
        });
        txtusuario4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuario4ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Correo:");

        txtusuario5.setFont(new java.awt.Font("Roboto Medium", 3, 16)); // NOI18N
        txtusuario5.setForeground(new java.awt.Color(85, 195, 220));
        txtusuario5.setToolTipText("");
        txtusuario5.setCaretColor(new java.awt.Color(204, 204, 204));
        txtusuario5.setSelectionColor(new java.awt.Color(85, 195, 220));
        txtusuario5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                txtusuario5MousePressed(evt);
            }
        });
        txtusuario5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuario5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(238, 238, 238))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btningresar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1))
                                .addGap(5, 5, 5)
                                .addComponent(txtusuario5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtusuario2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtusuario3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtusuario4))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtusuario, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                            .addComponent(txtusuario1))))
                .addGap(137, 137, 137))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel3)
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtusuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(txtusuario3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtusuario4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtusuario5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtusuario2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btningresar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btningresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btningresarMouseEntered
        // TODO add your handling code here:
        btningresar.setForeground(color1);
    }//GEN-LAST:event_btningresarMouseEntered

    private void btningresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btningresarMouseExited
        // TODO add your handling code here:
        btningresar.setForeground(Color.BLACK);
    }//GEN-LAST:event_btningresarMouseExited

    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed

        int bandera = 1;

        imgalerta = new ImageIcon(getClass().getResource("/images/error-campos.png"));

        btningresar.setBorder(new CirculoBoton(25));

        if (txtusuario.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite su Nombre",
                    "ERROR", JOptionPane.DEFAULT_OPTION, imgalerta);
            bandera = 0;
        } else {
            if (txtusuario1.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite Sus Apellidos",
                        "ERROR", JOptionPane.DEFAULT_OPTION, imgalerta);
                bandera = 0;
            }
            if (txtusuario3.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Digite Una Fecha",
                        "ERROR", JOptionPane.DEFAULT_OPTION, imgalerta);
                bandera = 0;
            } else {
                if (txtusuario4.getText().length() < 10 || txtusuario4.getText().length() > 11) {
                    JOptionPane.showMessageDialog(null, "El numero telefonico es de 10 digitos",
                            "ERROR", JOptionPane.DEFAULT_OPTION, imgalerta);
                    bandera = 0;
                } else {
                    if (txtusuario5.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Digite un correo valido",
                                "ERROR", JOptionPane.DEFAULT_OPTION, imgalerta);
                        bandera = 0;
                    } else {
                        if (txtusuario2.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Digite un domicilio",
                                    "ERROR", JOptionPane.DEFAULT_OPTION, imgalerta);
                            bandera = 0;
                        }

                    }

                }
            }
        }

        if (bandera == 1) {

            String nombre = txtusuario.getText();
            String apellidos = txtusuario1.getText();
            String fechaNac = txtusuario3.getText();
            String tel = txtusuario4.getText();
            String correo = txtusuario5.getText();
            String domicilio = txtusuario2.getText();

            panelusuerpass = new PanelUserPass(Panelingresar, jScrollpane, dao, nombre, apellidos,
                    fechaNac, tel, correo, domicilio);

            txtusuario.setText("");
            txtusuario1.setText("");
            txtusuario3.setText("");
            txtusuario4.setText("");
            txtusuario5.setText("");
            txtusuario2.setText("");

            jScrollpane.removeAll();
            panelusuerpass.setSize(620, 680);
            jScrollpane.add(panelusuerpass);
            jScrollpane.revalidate();
            jScrollpane.repaint();

        }

        /*
        if (dao.checkUser(txtusuario.getText(), txtcontra.getText()) == true) {
            if (dao.rol(txtusuario.getText(), txtcontra.getText()) == 1) {
                PanelAdmin ventana = new PanelAdmin();
                this.setVisible(false);
                ventana.setVisible(true);
                transaccionthread.setBandera(false);
                this.dispose();
            }
            if (dao.rol(txtusuario.getText(), txtcontra.getText()) == 2) {
                usuario = new Usuario();
                id_persona = dao.getIdPersona(txtusuario.getText());
                id_rol = dao.rol(txtusuario.getText(), txtcontra.getText());
                usuario.setId_persona(id_persona);
                usuario.setId_rol(id_rol);
                usuario.setUsername(txtusuario.getText());
                PanelPaciente ventana = null;
                try {
                    ventana = new PanelPaciente(this);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                ventana.setVisible(true);

                txtusuario.setText("Ingrese su usuario");
                txtcontra.setText("*********");
                this.setVisible(false);
                this.dispose();
            }
            if (dao.rol(txtusuario.getText(), txtcontra.getText()) == 3) {

                id_persona = dao.getIdPersona(txtusuario.getText());//obtener el ID_User de la tabla Usuario
                id_rol = dao.rol(txtusuario.getText(), txtcontra.getText());//obtener el ID_Rol de la tabla Usuario
                doctor.setId_persona(id_persona);
                doctor.setId_rol(id_rol);
                doctor.setUsername(txtusuario.getText());
                PanelMedico ventana = new PanelMedico(this);
                ventana.setVisible(true);

                txtusuario.setText("Ingrese su usuario");
                txtcontra.setText("*********");
                this.setVisible(false);
                this.dispose();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Error Usuario o Contraseña Inexistentes");
        }
        
         */
    }//GEN-LAST:event_btningresarActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:

        jButton1.setForeground(color1);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        jScrollpane.removeAll();
        jScrollpane.setVisible(true);

        Panelingresar.setSize(620, 680);
        jScrollpane.add(Panelingresar);
        jScrollpane.revalidate();
        jScrollpane.repaint();
        Panelingresar.setVisible(true);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setForeground(color1);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setForeground(Color.BLACK);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtusuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusuarioMousePressed
        // TODO add your handling code here:
        /*
        if (txtusuario.getText().equals("Ingrese su usuario")) {
            txtusuario.setText("");
            txtusuario.setForeground(Color.BLACK);
        }

        if (String.valueOf(txtcontra.getPassword()).isEmpty()) {
            txtcontra.setText("*********");
            txtcontra.setForeground(Color.GRAY);
        }
         */
    }//GEN-LAST:event_txtusuarioMousePressed

    private void txtusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuarioActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtusuarioActionPerformed

    private void txtusuario1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusuario1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario1MousePressed

    private void txtusuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario1ActionPerformed

    private void txtusuario2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusuario2MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario2MousePressed

    private void txtusuario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario2ActionPerformed

    private void txtusuario3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusuario3MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario3MousePressed

    private void txtusuario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuario3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario3ActionPerformed

    private void txtusuario4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusuario4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario4MousePressed

    private void txtusuario4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuario4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario4ActionPerformed

    private void txtusuario5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusuario5MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario5MousePressed

    private void txtusuario5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuario5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusuario5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btningresar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtusuario;
    private javax.swing.JTextField txtusuario1;
    private javax.swing.JTextField txtusuario2;
    private javax.swing.JTextField txtusuario3;
    private javax.swing.JTextField txtusuario4;
    private javax.swing.JTextField txtusuario5;
    // End of variables declaration//GEN-END:variables
}
