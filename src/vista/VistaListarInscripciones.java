package vista;

import modelo.Alumno;
import modelo.Materia;
import persistencia.CursadaData;
import persistencia.MateriaData;
import persistencia.conexion;

public class VistaListarInscripciones extends javax.swing.JInternalFrame {

    private javax.swing.table.DefaultTableModel modeloTabla = new javax.swing.table.DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public VistaListarInscripciones() {
        initComponents();
        cargarComboBox();
        armarCabecera();
    }
    
    public void cargarComboBox(){
        jComboBoxListMat.removeAllItems();
        conexion con = new conexion();
        MateriaData materiaData = new MateriaData(con);
        
        for (Materia m : materiaData.listarMateria()){
            jComboBoxListMat.addItem(m);
        }
    }
    
    public void armarCabecera(){
        modeloTabla.addColumn("Dni");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Fecha Nacimiento");
        jTablaListMat.setModel(modeloTabla);
    }
    
    public void cargarDatosTabla(){
        modeloTabla.setRowCount(0);
        
        Materia seleccionada = (Materia) jComboBoxListMat.getSelectedItem();
        if (seleccionada == null){
            return;
        }
        
        conexion con = new conexion();
        CursadaData cursada = new CursadaData(con);
        
        for (Alumno a : cursada.alumnosDeUnaMateria(seleccionada.getIdMateria())){
            modeloTabla.addRow(new Object[]{
                a.getDni(),
                a.getNombre(),
                a.getFechaNac()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaListMat = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxListMat = new javax.swing.JComboBox<>();
        jButtonSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Listado de Inscriptos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Lista de alumnos inscriptos");

        jTablaListMat.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablaListMat);

        jLabel2.setText("Seleccione una materia:");

        jComboBoxListMat.addItemListener(this::jComboBoxListMatItemStateChanged);

        jButtonSalir.setText("Salir");
        jButtonSalir.addActionListener(this::jButtonSalirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(jComboBoxListMat, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel1)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxListMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonSalir)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jComboBoxListMatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxListMatItemStateChanged
        cargarDatosTabla();
    }//GEN-LAST:event_jComboBoxListMatItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<Materia> jComboBoxListMat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaListMat;
    // End of variables declaration//GEN-END:variables
}
