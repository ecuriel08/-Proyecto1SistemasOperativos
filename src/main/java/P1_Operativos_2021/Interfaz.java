package P1_Operativos_2021;
/**
 * 30/11/2020
 * @author Nicolas Bolinaga
 * @author Ricardo Micale
 */
import javax.swing.JOptionPane;
import java.util.Arrays;

public class Interfaz extends javax.swing.JFrame {
    Productor[] prodsBoton = new Productor[4];
    Productor[] prodsBrazo = new Productor[5];
    Productor[] prodsPierna = new Productor[4];
    Productor[] prodsCuerpo = new Productor[4];
    int ensambladoresCount;
    
    public Interfaz() {
        initComponents();
        this.ensambladoresCount = 0;
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
        maxEmpleadosBrazo1 = new javax.swing.JLabel();
        progressBarPierna = new javax.swing.JProgressBar();
        productorPiernasPanel1 = new javax.swing.JPanel();
        productorBrazoLabel2 = new javax.swing.JLabel();
        crearProdBoton = new javax.swing.JButton();
        deleteProdBoton = new javax.swing.JButton();
        progressBarBoton = new javax.swing.JProgressBar();
        prodsBotones = new javax.swing.JTextField();
        maxEmpleadosBrazo2 = new javax.swing.JLabel();
        productorPiernasPanel2 = new javax.swing.JPanel();
        productorBrazoLabel3 = new javax.swing.JLabel();
        crearProdCuerpo = new javax.swing.JButton();
        deleteProdCuerpo = new javax.swing.JButton();
        prodsCuerpos = new javax.swing.JTextField();
        maxEmpleadosBrazo3 = new javax.swing.JLabel();
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
        progressBarAlmacenCuerpo3 = new javax.swing.JProgressBar();
        cantidadAlmacenCuerpo = new javax.swing.JTextField();
        maxAlmacenCuerpo = new javax.swing.JLabel();
        panelProduccion1 = new javax.swing.JPanel();
        ensamblajePanaPanel = new javax.swing.JPanel();
        ensambladorPanasLabel = new javax.swing.JLabel();
        crearEnsam = new javax.swing.JButton();
        deleteEnsam = new javax.swing.JButton();
        progressBarEnsam = new javax.swing.JProgressBar();
        ensambladores = new javax.swing.JTextField();
        maxEmpleadosPana = new javax.swing.JLabel();
        almacenBrazoPanel4 = new javax.swing.JPanel();
        almacenPanaLabel = new javax.swing.JLabel();
        cantidadAlmacenPana = new javax.swing.JTextField();
        ensamblar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        prodsBrazos.setBounds(260, 20, 20, 30);

        maxEmpleadosBrazo.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        maxEmpleadosBrazo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxEmpleadosBrazo.setText("/ 5");
        productorBrazoPanel.add(maxEmpleadosBrazo);
        maxEmpleadosBrazo.setBounds(290, 20, 50, 30);

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
        prodsPiernas.setBounds(260, 30, 20, 20);

        maxEmpleadosBrazo1.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        maxEmpleadosBrazo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        maxEmpleadosBrazo1.setText("/ 4");
        productorPiernasPanel.add(maxEmpleadosBrazo1);
        maxEmpleadosBrazo1.setBounds(300, 30, 33, 20);

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
        prodsBotones.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        prodsBotones.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prodsBotones.setText("0");
        prodsBotones.setBorder(null);
        prodsBotones.setMinimumSize(new java.awt.Dimension(7, 25));
        prodsBotones.setPreferredSize(new java.awt.Dimension(13, 21));
        productorPiernasPanel1.add(prodsBotones);
        prodsBotones.setBounds(270, 30, 23, 20);

        maxEmpleadosBrazo2.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        maxEmpleadosBrazo2.setText(" / 4");
        productorPiernasPanel1.add(maxEmpleadosBrazo2);
        maxEmpleadosBrazo2.setBounds(290, 30, 50, 20);

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
        prodsCuerpos.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        prodsCuerpos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        prodsCuerpos.setText("0");
        prodsCuerpos.setBorder(null);
        prodsCuerpos.setMinimumSize(new java.awt.Dimension(7, 25));
        prodsCuerpos.setPreferredSize(new java.awt.Dimension(13, 21));
        productorPiernasPanel2.add(prodsCuerpos);
        prodsCuerpos.setBounds(270, 30, 23, 21);

        maxEmpleadosBrazo3.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        maxEmpleadosBrazo3.setText("/ 4");
        productorPiernasPanel2.add(maxEmpleadosBrazo3);
        maxEmpleadosBrazo3.setBounds(300, 30, 40, 20);

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
        almacenBrazoPanel.add(maxAlmacenBrazo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 50, 30));

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
        maxAlmacenBoton.setBounds(110, 10, 40, 30);

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
        maxAlmacenPierna.setBounds(110, 10, 50, 30);

        almacenCuerpoPanel.setBackground(new java.awt.Color(204, 204, 204));
        almacenCuerpoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        almacenBrazoLabel3.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 18)); // NOI18N
        almacenBrazoLabel3.setText("Cuerpos");
        almacenCuerpoPanel.add(almacenBrazoLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 23));

        progressBarAlmacenCuerpo3.setMaximum(15);
        progressBarAlmacenCuerpo3.setToolTipText("");
        almacenCuerpoPanel.add(progressBarAlmacenCuerpo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 140, 23));

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
                .addContainerGap()
                .addGroup(panelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(almacenPiernaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                    .addComponent(almacenBrazoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(almacenBotonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(almacenCuerpoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
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

        panelFondo.add(panelAlmacen, new org.netbeans.lib.awtextra.AbsoluteConstraints(449, 6, 360, 190));

        panelProduccion1.setBackground(new java.awt.Color(51, 51, 51));
        panelProduccion1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Ensamblaje", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Copperplate Gothic Bold", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        panelProduccion1.setForeground(new java.awt.Color(255, 255, 255));

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

        ensambladores.setEditable(false);
        ensambladores.setBackground(new java.awt.Color(204, 204, 204));
        ensambladores.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        ensambladores.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ensambladores.setText("0");
        ensambladores.setBorder(null);
        ensambladores.setPreferredSize(new java.awt.Dimension(14, 20));
        ensamblajePanaPanel.add(ensambladores);
        ensambladores.setBounds(250, 10, 22, 20);

        maxEmpleadosPana.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        maxEmpleadosPana.setText("/5");
        ensamblajePanaPanel.add(maxEmpleadosPana);
        maxEmpleadosPana.setBounds(270, 10, 40, 20);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
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

        ensamblar.setBackground(new java.awt.Color(255, 255, 255));
        ensamblar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ensamblar.setText("Ensamblar");
        ensamblar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ensamblarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelProduccion1Layout = new javax.swing.GroupLayout(panelProduccion1);
        panelProduccion1.setLayout(panelProduccion1Layout);
        panelProduccion1Layout.setHorizontalGroup(
            panelProduccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProduccion1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProduccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ensamblajePanaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelProduccion1Layout.createSequentialGroup()
                        .addComponent(almacenBrazoPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(ensamblar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelProduccion1Layout.setVerticalGroup(
            panelProduccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProduccion1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ensamblajePanaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelProduccion1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(almacenBrazoPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ensamblar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelFondo.add(panelProduccion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 360, 160));
        panelProduccion1.getAccessibleContext().setAccessibleName("Ensamblaje");

        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MATTEL®");
        panelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 60, 30));

        getContentPane().add(panelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearProdBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearProdBotonActionPerformed
        int cantidad = Integer.parseInt(prodsBotones.getText());
        if( cantidad < 4){
            Productor prodBotonTemp =  new Productor(1,(cantidad + 1),(4/1),60);
            prodsBoton[cantidad] = prodBotonTemp;
            cantidad++;
            prodsBotones.setText(String.valueOf(cantidad));
            System.out.println("Productor Boton Creado");
            progressBarBoton.setValue(cantidad);
        } else {
            System.out.println("Limite de productor de boton alcanzado");
        }
    }//GEN-LAST:event_crearProdBotonActionPerformed

    private void deleteProdBrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProdBrazoActionPerformed
        int cantidad = Integer.parseInt(prodsBrazos.getText());
        if( cantidad > 0){
            cantidad--;
            prodsBrazos.setText(String.valueOf(cantidad));
            prodsBrazo[cantidad] = null;
            System.out.println("Productor Brazo Eliminado");
            progressBarBrazo.setValue(cantidad);
        }
    }//GEN-LAST:event_deleteProdBrazoActionPerformed

    private void crearProdBrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearProdBrazoActionPerformed
        int cantidad = Integer.parseInt(prodsBrazos.getText());
        if(cantidad < 5){
            Productor prodBrazoTemp =  new Productor(2,(cantidad + 1),1,40);
            prodsBrazo[cantidad] = prodBrazoTemp;
            cantidad++;
            prodsBrazos.setText(String.valueOf(cantidad));
            System.out.println("Productor Brazo Creado");
            progressBarBrazo.setValue(cantidad);
        } else {
            System.out.println("Limite de productor de brazo alcanzado");
        }
    }//GEN-LAST:event_crearProdBrazoActionPerformed

    private void deleteProdCuerpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProdCuerpoActionPerformed
        int cantidad = Integer.parseInt(prodsCuerpos.getText());
        if( cantidad > 0){
            cantidad--;
            prodsCuerpos.setText(String.valueOf(cantidad));
            prodsCuerpo[cantidad] = null;
            System.out.println("Productor Cuerpo Eliminado");
            progressBarCuerpo.setValue(cantidad);
        }
    }//GEN-LAST:event_deleteProdCuerpoActionPerformed

    private void crearProdCuerpoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearProdCuerpoActionPerformed
        int cantidad = Integer.parseInt(prodsCuerpos.getText());
        if(cantidad < 4){
            Productor prodCCTemp =  new Productor(4,(cantidad + 1),(1/3),15);
            prodsCuerpo[cantidad] = prodCCTemp;
            cantidad++;
            prodsCuerpos.setText(String.valueOf(cantidad));
            System.out.println("Productor Cuerpo Creado");
            progressBarCuerpo.setValue(cantidad);
        } else {
            System.out.println("Limite de productor de cuerpo alcanzado");
        }
    }//GEN-LAST:event_crearProdCuerpoActionPerformed

    private void deleteProdBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProdBotonActionPerformed
        int cantidad = Integer.parseInt(prodsBotones.getText());
        if( cantidad > 0){
            cantidad--;
            prodsBotones.setText(String.valueOf(cantidad));
            prodsBoton[cantidad] = null;
            System.out.println("Productor Boton Eliminado");
            progressBarBoton.setValue(cantidad);
        }
    }//GEN-LAST:event_deleteProdBotonActionPerformed

    private void deleteProdPiernaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProdPiernaActionPerformed
        int cantidad = Integer.parseInt(prodsPiernas.getText());
        if( cantidad > 0){
            cantidad--;
            prodsPiernas.setText(String.valueOf(cantidad));
            prodsPierna[cantidad] = null;
            System.out.println("Productor Pierna Eliminado");
            progressBarPierna.setValue(cantidad);
        }
    }//GEN-LAST:event_deleteProdPiernaActionPerformed

    private void crearProdPiernaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearProdPiernaActionPerformed
        int cantidad = Integer.parseInt(prodsPiernas.getText());
        if(cantidad < 4){
            Productor prodPiernaTemp =  new Productor(3,(cantidad + 1),(1/2),36);
            prodsPierna[cantidad] = prodPiernaTemp;
            cantidad++;
            prodsPiernas.setText(String.valueOf(cantidad));
            System.out.println("Productor Pierna Creado");
            progressBarPierna.setValue(cantidad);
        } else {
            System.out.println("Limite de productor de pierna alcanzado");
        }
    }//GEN-LAST:event_crearProdPiernaActionPerformed

    private void ensamblarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ensamblarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ensamblarActionPerformed

    private void crearEnsamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearEnsamActionPerformed
        if(ensambladoresCount < 5){
            ensambladoresCount++;
            ensambladores.setText(String.valueOf(ensambladoresCount));
            progressBarEnsam.setValue(ensambladoresCount);
        }
        
    }//GEN-LAST:event_crearEnsamActionPerformed

    private void deleteEnsam(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEnsam
        if(ensambladoresCount > 0){
            ensambladoresCount--;
            ensambladores.setText(String.valueOf(ensambladoresCount));
            progressBarEnsam.setValue(ensambladoresCount);
        }
    }//GEN-LAST:event_deleteEnsam
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
    private javax.swing.JLabel ensambladorPanasLabel;
    private javax.swing.JTextField ensambladores;
    private javax.swing.JPanel ensamblajePanaPanel;
    private javax.swing.JButton ensamblar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel maxAlmacenBoton;
    private javax.swing.JLabel maxAlmacenBrazo;
    private javax.swing.JLabel maxAlmacenCuerpo;
    private javax.swing.JLabel maxAlmacenPierna;
    private javax.swing.JLabel maxEmpleadosBrazo;
    private javax.swing.JLabel maxEmpleadosBrazo1;
    private javax.swing.JLabel maxEmpleadosBrazo2;
    private javax.swing.JLabel maxEmpleadosBrazo3;
    private javax.swing.JLabel maxEmpleadosPana;
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
    private javax.swing.JProgressBar progressBarAlmacenCuerpo3;
    private javax.swing.JProgressBar progressBarAlmacenPierna;
    private javax.swing.JProgressBar progressBarBoton;
    private javax.swing.JProgressBar progressBarBrazo;
    private javax.swing.JProgressBar progressBarCuerpo;
    private javax.swing.JProgressBar progressBarEnsam;
    private javax.swing.JProgressBar progressBarPierna;
    // End of variables declaration//GEN-END:variables
}
