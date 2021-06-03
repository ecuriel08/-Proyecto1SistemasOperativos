package P1_Operativos_2021;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Semaphore;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * 31/05/2020
 * @author Nicolas Bolinaga
 * @author Eduardo Curiel
 */


public class Interfaz extends javax.swing.JFrame {
    int tiempoDia;
    int diaDespachos;
    int maxBotones;
    int maxBrazos;
    int maxPiernas;
    int maxCuerpos;
    int PBtnMax;
    int PBraMax;
    int PPieMax;
    int PCueMax;
    int EnsamMax;
    int PBtnActivos;
    int PBraActivos;
    int PPieActivos;
    int PCueActivos;
    int EnsamActivos;
    int jefeTrabajo;
    int gerenteDescanso;
    Almacen almacenBoton;
    Almacen almacenBrazo;
    Almacen almacenCuerpo;
    Almacen almacenPierna;
    Almacen almacenPana;
    Almacen dias;
    boolean activo = false;
    Jefe jefe;
    Gerente gerente;
    Sout print;
    Productor[] productoresBotones;
    Productor[] productoresBrazos;
    Productor[] productoresPiernas;
    Productor[] productoresCuerpos;
    Ensamblador[] ensambladores;
    Semaphore mutex;
    Semaphore semCons;
    Semaphore semProdBoton;
    Semaphore semProdBrazo;
    Semaphore semProdPierna;
    Semaphore semProdCuerpo;
    Color clr = new Color(214, 154, 86);
    static boolean gerenteTrabajando = false;
    static boolean jefeTrabajando = false;
    static int panasTotales = 0;
    
    public Interfaz(){
        initComponents();
        readJSON();
        
        
        // ARRAYS --------------------------------------------------------------------
        productoresBotones = new Productor[PBtnMax];
        productoresBrazos = new Productor[PBraMax];
        productoresPiernas = new Productor[PPieMax];
        productoresCuerpos = new Productor[PCueMax];
        ensambladores = new Ensamblador[EnsamMax];

        // ALMACENES -----------------------------------------------------------------
        almacenBoton = new Almacen();
        almacenBrazo = new Almacen();
        almacenCuerpo = new Almacen();
        almacenPierna = new Almacen();
        almacenPana = new Almacen();
        dias = new Almacen();

        // SEMAFOROS ----------------------------------------------------------------
        mutex = new Semaphore(PBtnMax+PBraMax+PPieMax+PCueMax+EnsamMax);
        semCons = new Semaphore(0);
        semProdBoton = new Semaphore(maxBotones);
        semProdBrazo = new Semaphore(maxBrazos);
        semProdPierna = new Semaphore(maxPiernas);
        semProdCuerpo = new Semaphore(maxCuerpos);

        Semaphore contador = new Semaphore(1);
        Semaphore semJefe = new Semaphore(diaDespachos);
        Semaphore semGerente = new Semaphore(0);

        // PRODUCTORES ---------------------------------------------------------------
        for(int i = 0; i < PBtnMax; i++){
          productoresBotones[i] = new Productor(almacenBoton, 1, 4, tiempoDia, semCons, semProdBoton, mutex);
        }
        for(int i = 0; i < PBraMax; i++){
          productoresBrazos[i] = new Productor(almacenBrazo, 1, 1, tiempoDia, semCons, semProdBrazo, mutex);
        }
        for(int i = 0; i < PPieMax; i++){
          productoresPiernas[i] = new Productor(almacenPierna, 2, 1, tiempoDia, semCons, semProdPierna, mutex);
        }
        for(int i = 0; i < PCueMax; i++){
          productoresCuerpos[i] = new Productor(almacenCuerpo, 3, 1, tiempoDia, semCons, semProdCuerpo, mutex);
        }

        // ENSAMBLADORES -----------------------------------------------------------------
        for(int i = 0; i < EnsamMax; i++){
          ensambladores[i] = new Ensamblador(semCons, mutex, semProdBoton, semProdBrazo, semProdPierna, semProdCuerpo, almacenPana,almacenBrazo,almacenPierna,almacenCuerpo,almacenBoton,2,2,1,8,tiempoDia);
        }

        // JEFE y GERENTE ---------------------------------------------------------
        jefe = new Jefe(dias, tiempoDia, jefeTrabajo, semGerente, semJefe, contador);
        gerente = new Gerente(almacenPana, dias, tiempoDia, gerenteDescanso, semGerente,  semJefe, contador, diaDespachos);
        

        // PRINT -----------------------------------------------------------------
        print = new Sout(almacenPana, almacenBrazo, almacenPierna, almacenCuerpo, almacenBoton, tiempoDia, dias);

        maxEmpleadosBrazo.setText("/ " + PBraMax);
        maxEmpleadosCuerpo.setText("/ " + PCueMax);
        maxEmpleadosBoton.setText("/ " + PBtnMax);
        maxEmpleadosPierna.setText("/ " + PPieMax);
        maxEmpleadosPana.setText("/ " + EnsamMax);   
                
        progressBarBrazo.setValue(PBraActivos);
        progressBarCuerpo.setValue(PCueActivos);
        progressBarBoton.setValue(PBtnActivos);
        progressBarPierna.setValue(PPieActivos);
        progressBarEnsam.setValue(EnsamActivos);
        
        progressBarBrazo.setMaximum(PBraMax);
        progressBarCuerpo.setMaximum(PCueMax);
        progressBarBoton.setMaximum(PBtnMax);
        progressBarPierna.setMaximum(PPieMax);
        progressBarEnsam.setMaximum(EnsamMax);
        
        prodsBrazos.setText(Integer.toString(PBraActivos));
        prodsCuerpos.setText(Integer.toString(PCueActivos));
        prodsBotones.setText(Integer.toString(PBtnActivos));
        prodsPiernas.setText(Integer.toString(PPieActivos));
        ensambladoresActivos.setText(Integer.toString(EnsamActivos));
        
        diasFaltan.setText(Integer.toString(diaDespachos));
        seconds.setValue(0);
        seconds.setMaximum(tiempoDia);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        panelFondo = new javax.swing.JPanel();
        panelProduccion = new javax.swing.JPanel();
        productorBrazoPanel = new javax.swing.JPanel();
        productorBrazoLabel = new javax.swing.JLabel();
        crearProdBrazo = new javax.swing.JButton();
        deleteProdBrazo = new javax.swing.JButton();
        prodsBrazos = new javax.swing.JTextField();
        maxEmpleadosBrazo = new javax.swing.JLabel();
        progressBarBrazo = new javax.swing.JProgressBar();
        productorPiernasPanel = new javax.swing.JPanel();
        productorBrazoLabel1 = new javax.swing.JLabel();
        crearProdPierna = new javax.swing.JButton();
        deleteProdPierna = new javax.swing.JButton();
        prodsPiernas = new javax.swing.JTextField();
        maxEmpleadosPierna = new javax.swing.JLabel();
        progressBarPierna = new javax.swing.JProgressBar();
        productorPiernasPanel1 = new javax.swing.JPanel();
        productorBrazoLabel2 = new javax.swing.JLabel();
        crearProdBoton = new javax.swing.JButton();
        deleteProdBoton = new javax.swing.JButton();
        progressBarBoton = new javax.swing.JProgressBar();
        prodsBotones = new javax.swing.JTextField();
        maxEmpleadosBoton = new javax.swing.JLabel();
        productorPiernasPanel2 = new javax.swing.JPanel();
        productorBrazoLabel3 = new javax.swing.JLabel();
        crearProdCuerpo = new javax.swing.JButton();
        deleteProdCuerpo = new javax.swing.JButton();
        prodsCuerpos = new javax.swing.JTextField();
        maxEmpleadosCuerpo = new javax.swing.JLabel();
        progressBarCuerpo = new javax.swing.JProgressBar();
        panelAlmacen = new javax.swing.JPanel();
        almacenBrazoPanel = new javax.swing.JPanel();
        almacenBrazoLabel = new javax.swing.JLabel();
        progressBarAlmacenBrazo = new javax.swing.JProgressBar();
        cantidadAlmacenBrazo = new javax.swing.JTextField();
        maxAlmacenBrazo = new javax.swing.JLabel();
        almacenBotonPanel = new javax.swing.JPanel();
        almacenBotonLabel = new javax.swing.JLabel();
        progressBarAlmacenBoton = new javax.swing.JProgressBar();
        cantidadAlmacenBoton = new javax.swing.JTextField();
        maxAlmacenBoton = new javax.swing.JLabel();
        almacenPiernaPanel = new javax.swing.JPanel();
        almacenPiernaLabel = new javax.swing.JLabel();
        progressBarAlmacenPierna = new javax.swing.JProgressBar();
        cantidadAlmacenPierna = new javax.swing.JTextField();
        maxAlmacenPierna = new javax.swing.JLabel();
        almacenCuerpoPanel = new javax.swing.JPanel();
        almacenBrazoLabel3 = new javax.swing.JLabel();
        progressBarAlmacenCuerpo = new javax.swing.JProgressBar();
        cantidadAlmacenCuerpo = new javax.swing.JTextField();
        maxAlmacenCuerpo = new javax.swing.JLabel();
        panelProduccion1 = new javax.swing.JPanel();
        ensamblajePanaPanel = new javax.swing.JPanel();
        ensambladorPanasLabel = new javax.swing.JLabel();
        crearEnsam = new javax.swing.JButton();
        deleteEnsam = new javax.swing.JButton();
        progressBarEnsam = new javax.swing.JProgressBar();
        ensambladoresActivos = new javax.swing.JTextField();
        maxEmpleadosPana = new javax.swing.JLabel();
        almacenBrazoPanel4 = new javax.swing.JPanel();
        almacenPanaLabel = new javax.swing.JLabel();
        cantidadAlmacenPana = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        panasTotal = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        diasFaltan = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jefeDescansa = new javax.swing.JPanel();
        jefeTrabaja = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        gerDescansa = new javax.swing.JPanel();
        gerTrabaja = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        notice = new javax.swing.JPanel();
        ensamblar = new javax.swing.JButton();
        horas = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        seconds = new javax.swing.JProgressBar();
        counterSeconds = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFondo.setBackground(new java.awt.Color(51, 51, 51));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelProduccion.setBackground(new java.awt.Color(51, 51, 51));
        panelProduccion.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Producción", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Bold", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        productorBrazoPanel.setBackground(new java.awt.Color(204, 204, 204));
        productorBrazoPanel.setLayout(null);

        productorBrazoLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        productorBrazoLabel.setText("Productor de brazos");
        productorBrazoPanel.add(productorBrazoLabel);
        productorBrazoLabel.setBounds(10, 10, 207, 23);

        crearProdBrazo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        crearProdBrazo.setText("Contratar");
        crearProdBrazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearProdBrazoActionPerformed(evt);
            }
        });
        productorBrazoPanel.add(crearProdBrazo);
        crearProdBrazo.setBounds(10, 40, 90, 23);

        deleteProdBrazo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deleteProdBrazo.setText("Despedir");
        deleteProdBrazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProdBrazoActionPerformed(evt);
            }
        });
        productorBrazoPanel.add(deleteProdBrazo);
        deleteProdBrazo.setBounds(110, 40, 80, 23);

        prodsBrazos.setEditable(false);
        prodsBrazos.setBackground(new java.awt.Color(204, 204, 204));
        prodsBrazos.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        prodsBrazos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prodsBrazos.setText("0");
        prodsBrazos.setBorder(null);
        prodsBrazos.setPreferredSize(new java.awt.Dimension(14, 20));
        productorBrazoPanel.add(prodsBrazos);
        prodsBrazos.setBounds(240, 20, 40, 40);

        maxEmpleadosBrazo.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        maxEmpleadosBrazo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxEmpleadosBrazo.setText("/ 5");
        productorBrazoPanel.add(maxEmpleadosBrazo);
        maxEmpleadosBrazo.setBounds(270, 20, 90, 40);

        progressBarBrazo.setForeground(new java.awt.Color(255, 51, 51));
        progressBarBrazo.setMaximum(5);
        progressBarBrazo.setOrientation(1);
        progressBarBrazo.setBorderPainted(false);
        progressBarBrazo.setRequestFocusEnabled(false);
        progressBarBrazo.setString("");
        progressBarBrazo.setStringPainted(true);
        productorBrazoPanel.add(progressBarBrazo);
        progressBarBrazo.setBounds(210, 10, 20, 50);

        productorPiernasPanel.setBackground(new java.awt.Color(204, 204, 204));
        productorPiernasPanel.setLayout(null);

        productorBrazoLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        productorBrazoLabel1.setText("Productor de piernas");
        productorPiernasPanel.add(productorBrazoLabel1);
        productorBrazoLabel1.setBounds(10, 10, 207, 23);

        crearProdPierna.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        crearProdPierna.setText("Contratar");
        crearProdPierna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearProdPiernaActionPerformed(evt);
            }
        });
        productorPiernasPanel.add(crearProdPierna);
        crearProdPierna.setBounds(10, 40, 90, 23);

        deleteProdPierna.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deleteProdPierna.setText("Despedir");
        deleteProdPierna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProdPiernaActionPerformed(evt);
            }
        });
        productorPiernasPanel.add(deleteProdPierna);
        deleteProdPierna.setBounds(110, 40, 80, 23);

        prodsPiernas.setEditable(false);
        prodsPiernas.setBackground(new java.awt.Color(204, 204, 204));
        prodsPiernas.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        prodsPiernas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prodsPiernas.setText("0");
        prodsPiernas.setBorder(null);
        prodsPiernas.setMinimumSize(new java.awt.Dimension(7, 25));
        prodsPiernas.setPreferredSize(new java.awt.Dimension(13, 21));
        productorPiernasPanel.add(prodsPiernas);
        prodsPiernas.setBounds(240, 30, 40, 20);

        maxEmpleadosPierna.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        maxEmpleadosPierna.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxEmpleadosPierna.setText("/ 4");
        productorPiernasPanel.add(maxEmpleadosPierna);
        maxEmpleadosPierna.setBounds(270, 20, 90, 40);

        progressBarPierna.setForeground(new java.awt.Color(255, 51, 51));
        progressBarPierna.setMaximum(4);
        progressBarPierna.setOrientation(1);
        progressBarPierna.setBorderPainted(false);
        progressBarPierna.setRequestFocusEnabled(false);
        progressBarPierna.setString("");
        progressBarPierna.setStringPainted(true);
        productorPiernasPanel.add(progressBarPierna);
        progressBarPierna.setBounds(210, 10, 20, 50);

        productorPiernasPanel1.setBackground(new java.awt.Color(204, 204, 204));
        productorPiernasPanel1.setLayout(null);

        productorBrazoLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        productorBrazoLabel2.setText("Productor de botones");
        productorPiernasPanel1.add(productorBrazoLabel2);
        productorBrazoLabel2.setBounds(10, 10, 207, 23);

        crearProdBoton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        crearProdBoton.setText("Contratar");
        crearProdBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearProdBotonActionPerformed(evt);
            }
        });
        productorPiernasPanel1.add(crearProdBoton);
        crearProdBoton.setBounds(10, 40, 90, 23);

        deleteProdBoton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deleteProdBoton.setText("Despedir");
        deleteProdBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProdBotonActionPerformed(evt);
            }
        });
        productorPiernasPanel1.add(deleteProdBoton);
        deleteProdBoton.setBounds(110, 40, 80, 23);

        progressBarBoton.setForeground(new java.awt.Color(255, 51, 51));
        progressBarBoton.setMaximum(4);
        progressBarBoton.setOrientation(1);
        progressBarBoton.setBorderPainted(false);
        progressBarBoton.setRequestFocusEnabled(false);
        progressBarBoton.setString("");
        progressBarBoton.setStringPainted(true);
        productorPiernasPanel1.add(progressBarBoton);
        progressBarBoton.setBounds(210, 10, 20, 50);

        prodsBotones.setEditable(false);
        prodsBotones.setBackground(new java.awt.Color(204, 204, 204));
        prodsBotones.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        prodsBotones.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prodsBotones.setText("0");
        prodsBotones.setBorder(null);
        prodsBotones.setMinimumSize(new java.awt.Dimension(7, 25));
        prodsBotones.setPreferredSize(new java.awt.Dimension(13, 21));
        productorPiernasPanel1.add(prodsBotones);
        prodsBotones.setBounds(240, 30, 40, 20);

        maxEmpleadosBoton.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        maxEmpleadosBoton.setText(" / 4");
        productorPiernasPanel1.add(maxEmpleadosBoton);
        maxEmpleadosBoton.setBounds(280, 20, 80, 40);

        productorPiernasPanel2.setBackground(new java.awt.Color(204, 204, 204));
        productorPiernasPanel2.setLayout(null);

        productorBrazoLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        productorBrazoLabel3.setText("Productor de cuerpo");
        productorPiernasPanel2.add(productorBrazoLabel3);
        productorBrazoLabel3.setBounds(10, 10, 207, 23);

        crearProdCuerpo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        crearProdCuerpo.setText("Contratar");
        crearProdCuerpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearProdCuerpoActionPerformed(evt);
            }
        });
        productorPiernasPanel2.add(crearProdCuerpo);
        crearProdCuerpo.setBounds(10, 40, 90, 23);

        deleteProdCuerpo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deleteProdCuerpo.setText("Despedir");
        deleteProdCuerpo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProdCuerpoActionPerformed(evt);
            }
        });
        productorPiernasPanel2.add(deleteProdCuerpo);
        deleteProdCuerpo.setBounds(110, 40, 80, 23);

        prodsCuerpos.setEditable(false);
        prodsCuerpos.setBackground(new java.awt.Color(204, 204, 204));
        prodsCuerpos.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        prodsCuerpos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prodsCuerpos.setText("0");
        prodsCuerpos.setBorder(null);
        prodsCuerpos.setMinimumSize(new java.awt.Dimension(7, 25));
        prodsCuerpos.setPreferredSize(new java.awt.Dimension(13, 21));
        productorPiernasPanel2.add(prodsCuerpos);
        prodsCuerpos.setBounds(240, 30, 40, 21);

        maxEmpleadosCuerpo.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        maxEmpleadosCuerpo.setText("/ 4");
        productorPiernasPanel2.add(maxEmpleadosCuerpo);
        maxEmpleadosCuerpo.setBounds(290, 20, 70, 40);

        progressBarCuerpo.setForeground(new java.awt.Color(255, 51, 51));
        progressBarCuerpo.setMaximum(4);
        progressBarCuerpo.setOrientation(1);
        progressBarCuerpo.setBorderPainted(false);
        progressBarCuerpo.setRequestFocusEnabled(false);
        progressBarCuerpo.setString("");
        progressBarCuerpo.setStringPainted(true);
        productorPiernasPanel2.add(progressBarCuerpo);
        progressBarCuerpo.setBounds(210, 10, 20, 50);

        javax.swing.GroupLayout panelProduccionLayout = new javax.swing.GroupLayout(panelProduccion);
        panelProduccion.setLayout(panelProduccionLayout);
        panelProduccionLayout.setHorizontalGroup(
            panelProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProduccionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(productorBrazoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(productorPiernasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productorPiernasPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(productorPiernasPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelProduccionLayout.setVerticalGroup(
            panelProduccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProduccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productorBrazoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productorPiernasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(productorPiernasPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(productorPiernasPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelFondo.add(panelProduccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 380, 370));
        panelProduccion.getAccessibleContext().setAccessibleName("");

        panelAlmacen.setBackground(new java.awt.Color(51, 51, 51));
        panelAlmacen.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Almacen", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Bold", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        almacenBrazoPanel.setBackground(new java.awt.Color(204, 204, 204));
        almacenBrazoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        almacenBrazoLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        almacenBrazoLabel.setText("Brazos");
        almacenBrazoPanel.add(almacenBrazoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 23));

        progressBarAlmacenBrazo.setMaximum(40);
        almacenBrazoPanel.add(progressBarAlmacenBrazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, 23));

        cantidadAlmacenBrazo.setEditable(false);
        cantidadAlmacenBrazo.setBackground(new java.awt.Color(204, 204, 204));
        cantidadAlmacenBrazo.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        cantidadAlmacenBrazo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidadAlmacenBrazo.setText("0");
        cantidadAlmacenBrazo.setBorder(null);
        cantidadAlmacenBrazo.setPreferredSize(new java.awt.Dimension(14, 20));
        almacenBrazoPanel.add(cantidadAlmacenBrazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 22, 30));

        maxAlmacenBrazo.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        maxAlmacenBrazo.setText("/40");
        almacenBrazoPanel.add(maxAlmacenBrazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 60, 30));

        almacenBotonPanel.setBackground(new java.awt.Color(204, 204, 204));
        almacenBotonPanel.setLayout(null);

        almacenBotonLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        almacenBotonLabel.setText("Botones");
        almacenBotonPanel.add(almacenBotonLabel);
        almacenBotonLabel.setBounds(10, 10, 80, 23);

        progressBarAlmacenBoton.setMaximum(60);
        almacenBotonPanel.add(progressBarAlmacenBoton);
        progressBarAlmacenBoton.setBounds(10, 40, 140, 23);

        cantidadAlmacenBoton.setEditable(false);
        cantidadAlmacenBoton.setBackground(new java.awt.Color(204, 204, 204));
        cantidadAlmacenBoton.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        cantidadAlmacenBoton.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidadAlmacenBoton.setText("0");
        cantidadAlmacenBoton.setBorder(null);
        cantidadAlmacenBoton.setPreferredSize(new java.awt.Dimension(14, 20));
        almacenBotonPanel.add(cantidadAlmacenBoton);
        cantidadAlmacenBoton.setBounds(90, 10, 22, 30);

        maxAlmacenBoton.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        maxAlmacenBoton.setText("/60");
        almacenBotonPanel.add(maxAlmacenBoton);
        maxAlmacenBoton.setBounds(110, 10, 50, 30);

        almacenPiernaPanel.setBackground(new java.awt.Color(204, 204, 204));
        almacenPiernaPanel.setLayout(null);

        almacenPiernaLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        almacenPiernaLabel.setText("Piernas");
        almacenPiernaPanel.add(almacenPiernaLabel);
        almacenPiernaLabel.setBounds(10, 10, 70, 23);

        progressBarAlmacenPierna.setMaximum(36);
        almacenPiernaPanel.add(progressBarAlmacenPierna);
        progressBarAlmacenPierna.setBounds(10, 40, 140, 23);

        cantidadAlmacenPierna.setEditable(false);
        cantidadAlmacenPierna.setBackground(new java.awt.Color(204, 204, 204));
        cantidadAlmacenPierna.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        cantidadAlmacenPierna.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidadAlmacenPierna.setText("0");
        cantidadAlmacenPierna.setBorder(null);
        cantidadAlmacenPierna.setPreferredSize(new java.awt.Dimension(14, 20));
        almacenPiernaPanel.add(cantidadAlmacenPierna);
        cantidadAlmacenPierna.setBounds(90, 10, 22, 30);

        maxAlmacenPierna.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        maxAlmacenPierna.setText("/36");
        almacenPiernaPanel.add(maxAlmacenPierna);
        maxAlmacenPierna.setBounds(110, 10, 60, 30);

        almacenCuerpoPanel.setBackground(new java.awt.Color(204, 204, 204));
        almacenCuerpoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        almacenBrazoLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        almacenBrazoLabel3.setText("Cuerpos");
        almacenCuerpoPanel.add(almacenBrazoLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 23));

        progressBarAlmacenCuerpo.setMaximum(15);
        progressBarAlmacenCuerpo.setToolTipText("");
        almacenCuerpoPanel.add(progressBarAlmacenCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, 23));

        cantidadAlmacenCuerpo.setEditable(false);
        cantidadAlmacenCuerpo.setBackground(new java.awt.Color(204, 204, 204));
        cantidadAlmacenCuerpo.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        cantidadAlmacenCuerpo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidadAlmacenCuerpo.setText("0");
        cantidadAlmacenCuerpo.setBorder(null);
        cantidadAlmacenCuerpo.setPreferredSize(new java.awt.Dimension(14, 20));
        almacenCuerpoPanel.add(cantidadAlmacenCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 22, 30));

        maxAlmacenCuerpo.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        maxAlmacenCuerpo.setText("/15");
        almacenCuerpoPanel.add(maxAlmacenCuerpo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 50, 30));

        javax.swing.GroupLayout panelAlmacenLayout = new javax.swing.GroupLayout(panelAlmacen);
        panelAlmacen.setLayout(panelAlmacenLayout);
        panelAlmacenLayout.setHorizontalGroup(
            panelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlmacenLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(almacenBrazoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(almacenPiernaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(panelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(almacenBotonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(almacenCuerpoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        panelAlmacenLayout.setVerticalGroup(
            panelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(almacenBotonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(almacenBrazoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(almacenPiernaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(almacenCuerpoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelFondo.add(panelAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 6, 410, 190));

        panelProduccion1.setBackground(new java.awt.Color(51, 51, 51));
        panelProduccion1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ensamblaje", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Bold", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        panelProduccion1.setForeground(new java.awt.Color(255, 255, 255));
        panelProduccion1.setLayout(null);

        ensamblajePanaPanel.setBackground(new java.awt.Color(204, 204, 204));
        ensamblajePanaPanel.setLayout(null);

        ensambladorPanasLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        ensambladorPanasLabel.setText("Ensamblador de panas");
        ensamblajePanaPanel.add(ensambladorPanasLabel);
        ensambladorPanasLabel.setBounds(10, 10, 207, 23);

        crearEnsam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        crearEnsam.setText("Contratar");
        crearEnsam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearEnsamActionPerformed(evt);
            }
        });
        ensamblajePanaPanel.add(crearEnsam);
        crearEnsam.setBounds(10, 40, 90, 23);

        deleteEnsam.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        deleteEnsam.setText("Despedir");
        deleteEnsam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEnsam(evt);
            }
        });
        ensamblajePanaPanel.add(deleteEnsam);
        deleteEnsam.setBounds(110, 40, 80, 23);

        progressBarEnsam.setMaximum(5);
        ensamblajePanaPanel.add(progressBarEnsam);
        progressBarEnsam.setBounds(210, 40, 110, 23);

        ensambladoresActivos.setEditable(false);
        ensambladoresActivos.setBackground(new java.awt.Color(204, 204, 204));
        ensambladoresActivos.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        ensambladoresActivos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ensambladoresActivos.setText("0");
        ensambladoresActivos.setBorder(null);
        ensambladoresActivos.setPreferredSize(new java.awt.Dimension(14, 20));
        ensamblajePanaPanel.add(ensambladoresActivos);
        ensambladoresActivos.setBounds(250, 10, 22, 20);

        maxEmpleadosPana.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        maxEmpleadosPana.setText("/5");
        ensamblajePanaPanel.add(maxEmpleadosPana);
        maxEmpleadosPana.setBounds(270, 10, 40, 20);

        panelProduccion1.add(ensamblajePanaPanel);
        ensamblajePanaPanel.setBounds(12, 24, 386, 71);

        almacenBrazoPanel4.setBackground(new java.awt.Color(204, 204, 204));

        almacenPanaLabel.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        almacenPanaLabel.setText("Panas");

        cantidadAlmacenPana.setEditable(false);
        cantidadAlmacenPana.setBackground(new java.awt.Color(204, 204, 204));
        cantidadAlmacenPana.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        cantidadAlmacenPana.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cantidadAlmacenPana.setText("0");
        cantidadAlmacenPana.setBorder(null);
        cantidadAlmacenPana.setPreferredSize(new java.awt.Dimension(14, 20));

        javax.swing.GroupLayout almacenBrazoPanel4Layout = new javax.swing.GroupLayout(almacenBrazoPanel4);
        almacenBrazoPanel4.setLayout(almacenBrazoPanel4Layout);
        almacenBrazoPanel4Layout.setHorizontalGroup(
            almacenBrazoPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(almacenBrazoPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(almacenPanaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(cantidadAlmacenPana, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        almacenBrazoPanel4Layout.setVerticalGroup(
            almacenBrazoPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(almacenBrazoPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(almacenBrazoPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(almacenPanaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cantidadAlmacenPana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelProduccion1.add(almacenBrazoPanel4);
        almacenBrazoPanel4.setBounds(12, 113, 173, 36);

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 204, 204));
        jLabel10.setText("Total panas entregados:");
        panelProduccion1.add(jLabel10);
        jLabel10.setBounds(200, 120, 160, 16);

        panasTotal.setEditable(false);
        panasTotal.setBackground(new java.awt.Color(51, 51, 51));
        panasTotal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        panasTotal.setForeground(new java.awt.Color(204, 204, 204));
        panasTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panasTotal.setText("0");
        panasTotal.setBorder(null);
        panasTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                panasTotalActionPerformed(evt);
            }
        });
        panelProduccion1.add(panasTotal);
        panasTotal.setBounds(350, 114, 50, 30);

        panelFondo.add(panelProduccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, 410, 170));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Estadisticas", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Dias para la siguiente entrega:");

        diasFaltan.setEditable(false);
        diasFaltan.setBackground(new java.awt.Color(204, 204, 204));
        diasFaltan.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        diasFaltan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        diasFaltan.setText("0");
        diasFaltan.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(diasFaltan, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(diasFaltan, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 20, 380, 50);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Estatus Jefe:");

        jefeDescansa.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3)));
        jefeDescansa.setAlignmentX(0.0F);
        jefeDescansa.setAlignmentY(0.0F);

        javax.swing.GroupLayout jefeDescansaLayout = new javax.swing.GroupLayout(jefeDescansa);
        jefeDescansa.setLayout(jefeDescansaLayout);
        jefeDescansaLayout.setHorizontalGroup(
            jefeDescansaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jefeDescansaLayout.setVerticalGroup(
            jefeDescansaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jefeTrabaja.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3)));
        jefeTrabaja.setAlignmentX(0.0F);
        jefeTrabaja.setAlignmentY(0.0F);

        javax.swing.GroupLayout jefeTrabajaLayout = new javax.swing.GroupLayout(jefeTrabaja);
        jefeTrabaja.setLayout(jefeTrabajaLayout);
        jefeTrabajaLayout.setHorizontalGroup(
            jefeTrabajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jefeTrabajaLayout.setVerticalGroup(
            jefeTrabajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Descansando");

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Trabajando");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jefeDescansa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(12, 12, 12)
                .addComponent(jefeTrabaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(16, 16, 16))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jefeDescansa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(jefeTrabaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(10, 20, 370, 50);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Estatus Gerente:");

        gerDescansa.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3)));
        gerDescansa.setAlignmentX(0.0F);
        gerDescansa.setAlignmentY(0.0F);

        javax.swing.GroupLayout gerDescansaLayout = new javax.swing.GroupLayout(gerDescansa);
        gerDescansa.setLayout(gerDescansaLayout);
        gerDescansaLayout.setHorizontalGroup(
            gerDescansaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        gerDescansaLayout.setVerticalGroup(
            gerDescansaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        gerTrabaja.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3)));
        gerTrabaja.setAlignmentX(0.0F);
        gerTrabaja.setAlignmentY(0.0F);

        javax.swing.GroupLayout gerTrabajaLayout = new javax.swing.GroupLayout(gerTrabaja);
        gerTrabaja.setLayout(gerTrabajaLayout);
        gerTrabajaLayout.setHorizontalGroup(
            gerTrabajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        gerTrabajaLayout.setVerticalGroup(
            gerTrabajaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );

        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Trabajando");

        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Descansando");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gerDescansa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gerTrabaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(gerTrabaja, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(gerDescansa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(10, 80, 370, 50);

        notice.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)), javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3)));
        notice.setAlignmentX(0.0F);
        notice.setAlignmentY(0.0F);

        javax.swing.GroupLayout noticeLayout = new javax.swing.GroupLayout(notice);
        notice.setLayout(noticeLayout);
        noticeLayout.setHorizontalGroup(
            noticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        noticeLayout.setVerticalGroup(
            noticeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );

        jPanel1.add(notice);
        notice.setBounds(760, 110, 20, 20);

        ensamblar.setBackground(new java.awt.Color(255, 255, 255));
        ensamblar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ensamblar.setText("Ensamblar");
        ensamblar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ensamblarActionPerformed(evt);
            }
        });
        jPanel1.add(ensamblar);
        ensamblar.setBounds(610, 100, 130, 30);

        horas.setEditable(false);
        horas.setBackground(new java.awt.Color(51, 51, 51));
        horas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        horas.setForeground(new java.awt.Color(204, 204, 204));
        horas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        horas.setText("0:00 Hs");
        horas.setBorder(null);
        jPanel1.add(horas);
        horas.setBounds(520, 100, 74, 24);

        jLabel11.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 204, 204));
        jLabel11.setText("Hora del dia:");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(400, 100, 120, 24);

        seconds.setMinimum(1);
        jPanel1.add(seconds);
        seconds.setBounds(400, 80, 350, 12);

        counterSeconds.setEditable(false);
        counterSeconds.setBackground(new java.awt.Color(51, 51, 51));
        counterSeconds.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        counterSeconds.setForeground(new java.awt.Color(204, 204, 204));
        counterSeconds.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        counterSeconds.setText("0");
        counterSeconds.setBorder(null);
        jPanel1.add(counterSeconds);
        counterSeconds.setBounds(750, 70, 40, 30);

        panelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 800, 140));

        getContentPane().add(panelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearProdBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearProdBotonActionPerformed
        if(activo && PBtnActivos < PBtnMax){
          productoresBotones[PBtnActivos].start();
          PBtnActivos++;
          prodsBotones.setText(Integer.toString(PBtnActivos));
          progressBarBoton.setValue(PBtnActivos);  
        } else if (PBtnActivos < PBtnMax){
          PBtnActivos++;
          prodsBotones.setText(Integer.toString(PBtnActivos));
          progressBarBoton.setValue(PBtnActivos); 
        }
        
    }//GEN-LAST:event_crearProdBotonActionPerformed

    private void deleteProdBrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProdBrazoActionPerformed
        if(activo && PBraActivos >= 1){
            productoresBrazos[PBraActivos-1].exit = false;
            productoresBrazos[PBraActivos-1] = new Productor(almacenBrazo, 1, 1, tiempoDia, semCons, semProdBrazo, mutex);
            PBraActivos--;
            prodsBrazos.setText(Integer.toString(PBraActivos));
            progressBarBrazo.setValue(PBraActivos);
        } else if (PBraActivos >= 1){
            PBraActivos--;
            prodsBrazos.setText(Integer.toString(PBraActivos));
            progressBarBrazo.setValue(PBraActivos);
        }
    }//GEN-LAST:event_deleteProdBrazoActionPerformed

    private void crearProdBrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearProdBrazoActionPerformed
        if(activo && PBraActivos < PBraMax){
          productoresBrazos[PBraActivos].start();
          PBraActivos++;
          prodsBrazos.setText(Integer.toString(PBraActivos));
          progressBarBrazo.setValue(PBraActivos);  
        } else if (PBraActivos < PBraMax){
          PBraActivos++;
          prodsBrazos.setText(Integer.toString(PBraActivos));
          progressBarBrazo.setValue(PBraActivos);  
        }
    }//GEN-LAST:event_crearProdBrazoActionPerformed

    private void deleteProdCuerpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProdCuerpoActionPerformed
        if(activo && PCueActivos >= 1){
            productoresCuerpos[PCueActivos-1].exit = false;
            productoresCuerpos[PCueActivos-1] = new Productor(almacenCuerpo, 3, 1, tiempoDia, semCons, semProdCuerpo, mutex);
            PCueActivos--;
            prodsCuerpos.setText(Integer.toString(PCueActivos));
            progressBarCuerpo.setValue(PCueActivos);
        } else if (PCueActivos >= 1){
            PCueActivos--;
            prodsCuerpos.setText(Integer.toString(PCueActivos));
            progressBarCuerpo.setValue(PCueActivos);
        }
    }//GEN-LAST:event_deleteProdCuerpoActionPerformed

    private void crearProdCuerpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearProdCuerpoActionPerformed
        if(activo && PCueActivos < PCueMax){
          productoresCuerpos[PCueActivos].start();
          PCueActivos++;
          prodsCuerpos.setText(Integer.toString(PCueActivos));
          progressBarCuerpo.setValue(PCueActivos);  
        } else if (PCueActivos < PCueMax) {
          PCueActivos++;
          prodsCuerpos.setText(Integer.toString(PCueActivos));
          progressBarCuerpo.setValue(PCueActivos);  
        }
    }//GEN-LAST:event_crearProdCuerpoActionPerformed

    private void deleteProdBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProdBotonActionPerformed
        if(activo && PBtnActivos >= 1){
            productoresBotones[PBtnActivos-1].exit = false;
            productoresBotones[PBtnActivos-1] = new Productor(almacenBoton, 1, 4, tiempoDia, semCons, semProdBoton, mutex);
            PBtnActivos--;
            prodsBotones.setText(Integer.toString(PBtnActivos));
            progressBarBoton.setValue(PBtnActivos);
        } else if (PBtnActivos >= 1){
            PBtnActivos--;
            prodsBotones.setText(Integer.toString(PBtnActivos));
            progressBarBoton.setValue(PBtnActivos);
        }
    }//GEN-LAST:event_deleteProdBotonActionPerformed

    private void deleteProdPiernaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProdPiernaActionPerformed
       if(activo && PPieActivos >= 1){
            productoresPiernas[PPieActivos-1].exit = false;
            productoresPiernas[PPieActivos-1] = new Productor(almacenPierna, 2, 1, tiempoDia, semCons, semProdPierna, mutex);
            PPieActivos--;
            prodsPiernas.setText(Integer.toString(PPieActivos));
            progressBarPierna.setValue(PPieActivos);
        } else if (PPieActivos >= 1){
            PPieActivos--;
            prodsPiernas.setText(Integer.toString(PPieActivos));
            progressBarPierna.setValue(PPieActivos);
        }
    }//GEN-LAST:event_deleteProdPiernaActionPerformed

    private void crearProdPiernaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearProdPiernaActionPerformed
        if(activo && PPieActivos < PPieMax){
          productoresPiernas[PPieActivos].start();
          PPieActivos++;
          prodsPiernas.setText(Integer.toString(PPieActivos));
          progressBarPierna.setValue(PPieActivos);  
        } else if (PPieActivos < PPieMax){
          PPieActivos++;
          prodsPiernas.setText(Integer.toString(PPieActivos));
          progressBarPierna.setValue(PPieActivos);  
        }
    }//GEN-LAST:event_crearProdPiernaActionPerformed

    private void ensamblarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ensamblarActionPerformed
        if(!activo){
            notice.setBackground(clr);
            activo = true;
            jefe.start();
            gerente.start();
            print.start();
            start();
            for(int i = 0; i < PBtnActivos; i++){
                productoresBotones[i].start();
            }
            for(int i = 0; i < PBraActivos; i++){
                productoresBrazos[i].start();
            }
            for(int i = 0; i < PPieActivos; i++){
                productoresPiernas[i].start();
            }
            for(int i = 0; i < PCueActivos; i++){
                productoresCuerpos[i].start();
            }
            for(int i = 0; i < EnsamActivos; i++){
                ensambladores[i].start();
            }
        }
    }//GEN-LAST:event_ensamblarActionPerformed

    private void crearEnsamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearEnsamActionPerformed
        if(activo && EnsamActivos < EnsamMax){
          ensambladores[EnsamActivos].start();
          EnsamActivos++;
          ensambladoresActivos.setText(Integer.toString(EnsamActivos));
          progressBarEnsam.setValue(EnsamActivos);  
        } else if (EnsamActivos < EnsamMax){
          EnsamActivos++;
          ensambladoresActivos.setText(Integer.toString(EnsamActivos));
          progressBarEnsam.setValue(EnsamActivos);  
        }
    }//GEN-LAST:event_crearEnsamActionPerformed

    private void deleteEnsam(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEnsam
        if(activo && EnsamActivos >= 1){
            ensambladores[EnsamActivos-1].exit = false;
            ensambladores[EnsamActivos-1] = new Ensamblador(semCons, mutex, semProdBoton, semProdBrazo, semProdPierna, semProdCuerpo, almacenPana,almacenBrazo,almacenPierna,almacenCuerpo,almacenBoton,2,2,1,8,tiempoDia);
            EnsamActivos--;
            ensambladoresActivos.setText(Integer.toString(EnsamActivos));
            progressBarEnsam.setValue(EnsamActivos);
        } else if ( EnsamActivos >= 1){
            EnsamActivos--;
            ensambladoresActivos.setText(Integer.toString(EnsamActivos));
            progressBarEnsam.setValue(EnsamActivos);
        }
    }//GEN-LAST:event_deleteEnsam

    private void panasTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_panasTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_panasTotalActionPerformed
    
    private void start() {
        Thread worker = new Thread() {
        public void run() {
            while(true){
                progressBarAlmacenBoton.setValue(almacenBoton.cantidad);
                cantidadAlmacenBoton.setText(Integer.toString(almacenBoton.cantidad));
                
                progressBarAlmacenBrazo.setValue(almacenBrazo.cantidad);
                cantidadAlmacenBrazo.setText(Integer.toString(almacenBrazo.cantidad));
                
                progressBarAlmacenPierna.setValue(almacenPierna.cantidad);
                cantidadAlmacenPierna.setText(Integer.toString(almacenPierna.cantidad));
                
                progressBarAlmacenCuerpo.setValue(almacenCuerpo.cantidad);
                cantidadAlmacenCuerpo.setText(Integer.toString(almacenCuerpo.cantidad));
                
                cantidadAlmacenPana.setText(Integer.toString(almacenPana.cantidad));
                
                if(jefeTrabajando){
                    jefeTrabaja.setBackground(clr);
                    jefeDescansa.setBackground(Color.lightGray);
                } else {
                    jefeTrabaja.setBackground(Color.lightGray);
                    jefeDescansa.setBackground(clr);
                }
                
                if(gerenteTrabajando){
                    gerTrabaja.setBackground(clr);
                    gerDescansa.setBackground(Color.lightGray);
                } else {
                    gerTrabaja.setBackground(Color.lightGray);
                    gerDescansa.setBackground(clr);
                }
                
                diasFaltan.setText(Integer.toString(diaDespachos - dias.cantidad));
                seconds.setValue(print.seconds - 1);
                counterSeconds.setText(Integer.toString(print.seconds - 1));
                horas.setText(Integer.toString((24*(print.seconds - 1))/tiempoDia) + ":00 Hs");
                panasTotal.setText(Integer.toString(panasTotales));
            }
        }
       };

       worker.start();
  
    }
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
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel almacenBotonLabel;
    private javax.swing.JPanel almacenBotonPanel;
    private javax.swing.JLabel almacenBrazoLabel;
    private javax.swing.JLabel almacenBrazoLabel3;
    private javax.swing.JPanel almacenBrazoPanel;
    private javax.swing.JPanel almacenBrazoPanel4;
    private javax.swing.JPanel almacenCuerpoPanel;
    private javax.swing.JLabel almacenPanaLabel;
    private javax.swing.JLabel almacenPiernaLabel;
    private javax.swing.JPanel almacenPiernaPanel;
    private javax.swing.JTextField cantidadAlmacenBoton;
    private javax.swing.JTextField cantidadAlmacenBrazo;
    private javax.swing.JTextField cantidadAlmacenCuerpo;
    private javax.swing.JTextField cantidadAlmacenPana;
    private javax.swing.JTextField cantidadAlmacenPierna;
    private javax.swing.JTextField counterSeconds;
    private javax.swing.JButton crearEnsam;
    private javax.swing.JButton crearProdBoton;
    private javax.swing.JButton crearProdBrazo;
    private javax.swing.JButton crearProdCuerpo;
    private javax.swing.JButton crearProdPierna;
    private javax.swing.JButton deleteEnsam;
    private javax.swing.JButton deleteProdBoton;
    private javax.swing.JButton deleteProdBrazo;
    private javax.swing.JButton deleteProdCuerpo;
    private javax.swing.JButton deleteProdPierna;
    private javax.swing.JTextField diasFaltan;
    private javax.swing.JLabel ensambladorPanasLabel;
    private javax.swing.JTextField ensambladoresActivos;
    private javax.swing.JPanel ensamblajePanaPanel;
    private javax.swing.JButton ensamblar;
    private javax.swing.JPanel gerDescansa;
    private javax.swing.JPanel gerTrabaja;
    private javax.swing.JTextField horas;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jefeDescansa;
    private javax.swing.JPanel jefeTrabaja;
    private javax.swing.JLabel maxAlmacenBoton;
    private javax.swing.JLabel maxAlmacenBrazo;
    private javax.swing.JLabel maxAlmacenCuerpo;
    private javax.swing.JLabel maxAlmacenPierna;
    private javax.swing.JLabel maxEmpleadosBoton;
    private javax.swing.JLabel maxEmpleadosBrazo;
    private javax.swing.JLabel maxEmpleadosCuerpo;
    private javax.swing.JLabel maxEmpleadosPana;
    private javax.swing.JLabel maxEmpleadosPierna;
    private javax.swing.JPanel notice;
    private javax.swing.JTextField panasTotal;
    private javax.swing.JPanel panelAlmacen;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelProduccion;
    private javax.swing.JPanel panelProduccion1;
    private javax.swing.JTextField prodsBotones;
    private javax.swing.JTextField prodsBrazos;
    private javax.swing.JTextField prodsCuerpos;
    private javax.swing.JTextField prodsPiernas;
    private javax.swing.JLabel productorBrazoLabel;
    private javax.swing.JLabel productorBrazoLabel1;
    private javax.swing.JLabel productorBrazoLabel2;
    private javax.swing.JLabel productorBrazoLabel3;
    private javax.swing.JPanel productorBrazoPanel;
    private javax.swing.JPanel productorPiernasPanel;
    private javax.swing.JPanel productorPiernasPanel1;
    private javax.swing.JPanel productorPiernasPanel2;
    private javax.swing.JProgressBar progressBarAlmacenBoton;
    private javax.swing.JProgressBar progressBarAlmacenBrazo;
    private javax.swing.JProgressBar progressBarAlmacenCuerpo;
    private javax.swing.JProgressBar progressBarAlmacenPierna;
    private javax.swing.JProgressBar progressBarBoton;
    private javax.swing.JProgressBar progressBarBrazo;
    private javax.swing.JProgressBar progressBarCuerpo;
    private javax.swing.JProgressBar progressBarEnsam;
    private javax.swing.JProgressBar progressBarPierna;
    private javax.swing.JProgressBar seconds;
    // End of variables declaration//GEN-END:variables

    private void readJSON() {
      JSONParser jsonParser = new JSONParser();
      try {
        JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader(".\\src\\test\\java\\datos.json"));
        tiempoDia = Integer.parseInt((String) jsonObject.get("Tiempo_Dia"));
        diaDespachos = Integer.parseInt((String)jsonObject.get("Dias_Despacho"));
        maxBotones = Integer.parseInt((String)jsonObject.get("Maximo_Almacen_Botones"));
        maxBrazos = Integer.parseInt((String) jsonObject.get("Maximo_Almacen_Brazos"));
        maxPiernas = Integer.parseInt((String) jsonObject.get("Maximo_Almacen_Piernas"));
        maxCuerpos = Integer.parseInt((String) jsonObject.get("Maximo_Almacen_Cuerpos"));
        PBtnMax = Integer.parseInt((String) jsonObject.get("Maximo_Productores_Botones"));
        PBraMax = Integer.parseInt((String) jsonObject.get("Maximo_Productores_Brazos"));
        PPieMax = Integer.parseInt((String) jsonObject.get("Maximo_Productores_Piernas"));
        PCueMax = Integer.parseInt((String) jsonObject.get("Maximo_Productores_Cuerpos"));
        EnsamMax = Integer.parseInt((String) jsonObject.get("Maximo_Ensambladores"));
        PBtnActivos = Integer.parseInt((String) jsonObject.get("Productores_Botones_Activos"));
        PBraActivos = Integer.parseInt((String) jsonObject.get("Productores_Brazos_Activos"));
        PPieActivos = Integer.parseInt((String) jsonObject.get("Productores_Piernas_Activos"));
        PCueActivos = Integer.parseInt((String) jsonObject.get("Productores_Cuerpos_Activos"));
        EnsamActivos = Integer.parseInt((String) jsonObject.get("Ensambladores_Activos"));
        jefeTrabajo = Integer.parseInt((String) jsonObject.get("Tiempo_Trabajo_Jefe"));
        gerenteDescanso = Integer.parseInt((String) jsonObject.get("Tiempo_Descanso_Gerente"));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
          System.out.println("File no encontrado");
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ParseException e) {
        e.printStackTrace();
      }
    }
}
