package Views.Usuario;

import Model.UsuarioDao;
import static Public.Login.doctor;
import static Public.Login.usuario;
import classes.Doctor;
import classes.Usuario;
import classes.GestionCeldas;
import classes.GestionEncabezadoTabla;

import classes.ModeloTabla;
import classes.Usuario;
import classes.Utilidades;
import com.mysql.cj.log.Log;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.FlowLayout;
import java.awt.Font;
import static java.awt.SystemColor.desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import static java.lang.Math.E;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import sistema.util.Database;

public class PanelCitas extends javax.swing.JPanel {

    private UsuarioDao dao;

    private ModeloTabla modelo;//modelo definido en la clase ModeloTabla

    private int filasTabla;
    private int columnasTabla;
    private ImageIcon imgalerta;
    private ImageIcon ok;
    private Usuario Datosusuario;

    //List<Usuario> listaPacientes = new ArrayList<Usuario>();//lista que simula la información de la BD
    private ArrayList<Usuario> listaMisCitas;
    private List<Usuario> foliosPacientes;
    private List<Doctor> Especialidades;

    private String Opcion;
    private JFrame v;

    //insercion de la tabla 
    private int folioEntero = 0;
    private int numerocama = 0;
    private String medico = null;
    private String Diagnostico = null;
    private String tratamiento = null;

    //colores
    private Color colorAgenda = new Color(158, 58, 175);
    private Color colorAzul = new Color(0, 158, 191);

    //panel agendarcita
    private PanelAgendarCita panelagendarcita;
    private PanelDashboard paneldashboar;

    private JPanel panelcentro;

    public PanelCitas(UsuarioDao dao, Usuario Datosusuario, JPanel panelcentro, PanelDashboard paneldashboar) throws UnsupportedEncodingException {
        initComponents();
        this.dao = dao;
        this.Datosusuario = Datosusuario;
        this.panelcentro = panelcentro;
        this.paneldashboar = paneldashboar;
        jButton2.setBorder(new CirculoBoton(50));
        jButton1.setBorder(new CirculoBoton(50));

        panelagendarcita = new PanelAgendarCita(panelcentro, this, Datosusuario, dao, paneldashboar);
        // String itemSeleecionado = jComboBox1.getSelectedItem().toString();
        iniciarComponentes();
//      setLocationRelativeTo(null);
        construirTabla();

    }
//////////////////
    ////////////
    //////////////
    ///////////

    public void iniciarComponentes() {

    
        foliosPacientes = dao.getFolios(usuario.getId_persona());
        jLabel8.setVisible(false);
        jComboBox1.setVisible(false);
        
   
        
        jComboBox1.setBounds(10, 10, 80, 20);
        for (int i = 0; i < foliosPacientes.size(); i++) {
                 jComboBox1.addItem(foliosPacientes.get(i).getFolio() + "");
        }

        // Accion a realizar cuando el JComboBox cambia de item seleccionado.
        jComboBox1.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {

                String result = "";
                BufferedReader in = null;
                HttpURLConnection connection = null;
                String itemSeleecionado = jComboBox1.getSelectedItem().toString();
                URL getUrl = null;
                imgalerta = new ImageIcon(getClass().getResource("/images/error-campos.png"));

                try {
                    getUrl = new URL("http://localhost:8080/HospitalServidor");

                    // Abre la conexión con la URL
                    connection = (HttpURLConnection) getUrl.openConnection();

                    // Antes de conectar, establezca atributos de solicitud generales
                    connection.setRequestProperty("accept", "*/*");
                    connection.setRequestProperty("connection", "Keep-Alive");
                    connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                    connection.setRequestProperty("Charsert", "UTF-8");

                    // Configure el tipo de contenido de esta conexión, el formulario del formulario es "application / x-www-form-urlencoded", json es "application / json", etc.
                    // Ajuste el tipo de contenido según sus necesidades
                    connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                    // Establecer el tiempo de espera para conectarse al servidor host: 15000 milisegundos
                    connection.setConnectTimeout(15000);
                    // Establecer el tiempo para leer los datos devueltos por el control remoto: 60000 milisegundos
                    connection.setReadTimeout(60000);

                    // Establecer el método de conexión: get
                    connection.setRequestMethod("GET");

                    // Establezca la conexión real, tenga en cuenta que connection.getOutputStream se conectará implícitamente.
                    connection.connect();

                    // Defina la secuencia de entrada de BufferedReader para leer la respuesta de la URL
                    if (connection.getResponseCode() == 200) {

                        Desktop.getDesktop().browse(new URI("http://localhost:8080/HospitalServidor" + "?folio=" + itemSeleecionado + ""));
                        jLabel8.setVisible(false);
                        jComboBox1.setVisible(false);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(PanelCitas.class.getName()).log(Level.SEVERE, null, ex);

                    JOptionPane.showMessageDialog(null, "SERVIDOR NO DISPONIBLE",
                            "ERROR DE CONEXION", JOptionPane.DEFAULT_OPTION, imgalerta);
                    
                    jLabel8.setVisible(false);
                    jComboBox1.setVisible(false);
                    
                } catch (URISyntaxException ex) {
                    Logger.getLogger(PanelCitas.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

    }

    /**
     * Metodo que permite construir la tabla de personas se crean primero las
     * columnas y luego se asigna la información
     */
    public void construirTabla() {

        listaMisCitas = dao.getAllUsersCitas(usuario.getId_persona());
        ArrayList<String> titulosList = new ArrayList<>();

        titulosList.add("NUMERO DE FOLIO");
        titulosList.add("FECHA DE VISITA");
        titulosList.add("HORA DE VISITA");
        titulosList.add("ESPECIALIDAD");
        titulosList.add("SINTOMAS");
        titulosList.add("ESTADO");

        //se asignan las columnas al arreglo para enviarse al momento de construir la tabla
        String titulos[] = new String[titulosList.size()];
        for (int i = 0; i < titulos.length; i++) {
            titulos[i] = titulosList.get(i);
        }

        /*obtenemos los datos de la lista y los guardamos en la matriz
		 * que luego se manda a construir la tabla
         */
        Object[][] data = obtenerMatrizDatos(titulosList);
        construirTabla(titulos, data);

    }

    /**
     * Permite simular el llenado de personas en una lista que posteriormente
     * alimentará la tabla
     *
     * @return
     */
    /**
     * Llena la información de la tabla usando la lista de personas trabajada
     * anteriormente, guardandola en una matriz que se retorna con toda la
     * información para luego ser asignada al modelo
     *
     * @param titulosList
     * @return
     */
    private Object[][] obtenerMatrizDatos(ArrayList<String> titulosList) {

        /*se crea la matriz donde las filas son dinamicas pues corresponde
		 * a todos los usuarios, mientras que las columnas son estaticas
		 * correspondiendo a las columnas definidas por defecto
         */
        String informacion[][] = new String[listaMisCitas.size()][titulosList.size()];

        for (int x = 0; x < informacion.length; x++) {
            // System.out.println(informacion[x][Utilidades.FOLIO]);
            informacion[x][Utilidades.FOLIO] = listaMisCitas.get(x).getFolio() + "";
            informacion[x][Utilidades.fecha] = listaMisCitas.get(x).getFecha() + "";
            informacion[x][Utilidades.hora] = listaMisCitas.get(x).getHora() + "";
            informacion[x][Utilidades.especialidad] = listaMisCitas.get(x).getEspecialidad() + "";
            informacion[x][Utilidades.sintomas] = listaMisCitas.get(x).getSintomas() + "";
            informacion[x][Utilidades.estado] = listaMisCitas.get(x).isEstado() + "";

        }

        return informacion;
    }

    /**
     * Con los titulos y la información a mostrar se crea el modelo para poder
     * personalizar la tabla, asignando tamaño de celdas tanto en ancho como en
     * alto así como los tipos de datos que va a poder soportar.
     *
     * @param titulos
     * @param data
     */
    private void construirTabla(String[] titulos, Object[][] data) {

        modelo = new ModeloTabla(titulos, data);
        //se asigna el modelo a la tabla
        jTable2.setModel(modelo);

        filasTabla = jTable2.getRowCount();
        columnasTabla = jTable2.getColumnCount();

        //se asigna el tipo de dato que tendrán las celdas de cada columna definida respectivamente para validar su personalización
        jTable2.getColumnModel().getColumn(Utilidades.FOLIO).setCellRenderer(new GestionCeldas("numerico"));
        jTable2.getColumnModel().getColumn(Utilidades.fecha).setCellRenderer(new GestionCeldas("texto"));
        jTable2.getColumnModel().getColumn(Utilidades.hora).setCellRenderer(new GestionCeldas("texto"));
        jTable2.getColumnModel().getColumn(Utilidades.especialidad).setCellRenderer(new GestionCeldas("texto"));
        jTable2.getColumnModel().getColumn(Utilidades.sintomas).setCellRenderer(new GestionCeldas("texto"));
        jTable2.getColumnModel().getColumn(Utilidades.estado).setCellRenderer(new GestionCeldas("numerico"));

        //se recorre y asigna el resto de celdas que serian las que almacenen datos de tipo texto
        for (int i = 0; i < titulos.length; i++) {//se resta 7 porque las ultimas 7 columnas se definen arriba
            System.out.println(i);
            jTable2.getColumnModel().getColumn(i).setCellRenderer(new GestionCeldas("texto"));
        }

        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.setRowHeight(25);//tamaño de las celdas
        jTable2.setGridColor(new java.awt.Color(0, 0, 0));
        //Se define el tamaño de largo para cada columna y su contenido
        jTable2.getColumnModel().getColumn(Utilidades.FOLIO).setPreferredWidth(100);//documento
        jTable2.getColumnModel().getColumn(Utilidades.fecha).setPreferredWidth(100);//nombre
        jTable2.getColumnModel().getColumn(Utilidades.hora).setPreferredWidth(100);//direccion
        jTable2.getColumnModel().getColumn(Utilidades.especialidad).setPreferredWidth(110);//telefono
        jTable2.getColumnModel().getColumn(Utilidades.sintomas).setPreferredWidth(100);//profesion
        jTable2.getColumnModel().getColumn(Utilidades.estado).setPreferredWidth(100);//profesion
        //personaliza el encabezado
        JTableHeader jtableHeader = jTable2.getTableHeader();
        jtableHeader.setDefaultRenderer(new GestionEncabezadoTabla());
        jTable2.setTableHeader(jtableHeader);

        //se asigna la tabla al scrollPane
        jScrollPane3.setViewportView(jTable2);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 0, 51));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBackground(new java.awt.Color(255, 51, 255));

        jTable2.setBackground(new java.awt.Color(0, 255, 0));
        jTable2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jScrollPane3.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 894, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 158, 191));
        jLabel2.setText("CITAS MEDICAS");

        jComboBox1.setFont(new java.awt.Font("Roboto Light", 1, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(85, 195, 220));
        jLabel8.setText("Seleccione un Folio");

        jButton2.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton2.setText("AGENDAR CITA");
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

        jButton1.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jButton1.setText("COMPROBANTES");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(408, 408, 408)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(426, 426, 426)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(626, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(512, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        panelagendarcita.setVisible(true);
        // panelcentro.removeAll();
        panelagendarcita.setSize(700, 900);

        /*
        
        
        if(resp == 0){
            
         JOptionPane.showConfirmDialog(null, "¿yes?");
            
        }
         */

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        // TODO add your handling code here:
        jButton2.setForeground(colorAgenda);
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
        jButton2.setForeground(colorAzul);

    }//GEN-LAST:event_jButton2MouseExited

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        // TODO add your handling code here:
        jButton1.setForeground(colorAgenda);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        // TODO add your handling code here:
        jButton1.setForeground(colorAzul);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jLabel8.setVisible(true);
        jComboBox1.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
