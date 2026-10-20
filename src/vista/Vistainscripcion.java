package vista;

import modelo.Alumno;
import modelo.Cursada;
import modelo.Materia;
import persistencia.AlumnoData;
import persistencia.CursadaData;
import persistencia.conexion;

public class Vistainscripcion extends javax.swing.JInternalFrame {

    private javax.swing.table.DefaultTableModel modeloTabla = new javax.swing.table.DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public Vistainscripcion() {
        initComponents();
        cargarComboBox();
        armarCabecera();

        jBtnInscribir.setEnabled(false);
        jBtnAnularInscripcion.setEnabled(false);

        jTablaInscripcion.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                actualizarEstadoRadioBtn();
            }
        });
        jBtnAnularInscripcion.addActionListener(this::jBtnAnularInscripcionActionPerformed);
    }

    public void cargarComboBox() {
        jComboBoxAlumnos.removeAllItems();
        conexion con = new conexion();
        AlumnoData alumnoData = new AlumnoData(con);

        for (Alumno a : alumnoData.listarAlumnos()) {
            jComboBoxAlumnos.addItem(a);
        }
    }

    public void armarCabecera() {
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Estado");
        jTablaInscripcion.setModel(modeloTabla);

    }

    public void actualizarEstadoRadioBtn() {
        int filaSeleccionada = jTablaInscripcion.getSelectedRow();
        boolean hayFilaSeleccionada = (filaSeleccionada != -1);

        if (jRadioBtnInscriptas.isSelected()) {
            jBtnInscribir.setEnabled(false);
            jBtnAnularInscripcion.setEnabled(hayFilaSeleccionada);
        } else if (jRadioBtnNoInscriptas.isSelected()) {
            jBtnAnularInscripcion.setEnabled(false);
            jBtnInscribir.setEnabled(hayFilaSeleccionada);
        } else {
            jBtnInscribir.setEnabled(false);
            jBtnAnularInscripcion.setEnabled(false);
        }
    }

    public void cargarDatosTabla() {
        modeloTabla.setRowCount(0);

        Alumno seleccionado = (Alumno) jComboBoxAlumnos.getSelectedItem();
        if (seleccionado == null) {
            return;
        }

        conexion con = new conexion();
        CursadaData cursadaData = new CursadaData(con);

        if (jRadioBtnInscriptas.isSelected()) {
            for (Materia m : cursadaData.materiasDeUnAlumno(seleccionado.getId())) {
                modeloTabla.addRow(new Object[]{
                    m.getIdMateria(),
                    m.getNombre(),
                    m.isEstado() ? "Activa" : "Inactiva"
                });
            }
        } else if (jRadioBtnNoInscriptas.isSelected()) {
            for (Materia m : cursadaData.obtenerMateriasNoCursadas(seleccionado.getId())) {
                modeloTabla.addRow(new Object[]{
                    m.getIdMateria(),
                    m.getNombre(),
                    m.isEstado() ? "Activa" : "Inactiva"
                });
            }
        }

        actualizarEstadoRadioBtn();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxAlumnos = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablaInscripcion = new javax.swing.JTable();
        jRadioBtnInscriptas = new javax.swing.JRadioButton();
        jRadioBtnNoInscriptas = new javax.swing.JRadioButton();
        jBtnInscribir = new javax.swing.JButton();
        jBtnAnularInscripcion = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Formulario de Inscripción");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Formulario de Inscripción");

        jLabel2.setText("Seleccione un alumno:");

        jComboBoxAlumnos.addItemListener(this::jComboBoxAlumnosItemStateChanged);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Listado de alumnos:");

        jTablaInscripcion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTablaInscripcion);

        buttonGroup1.add(jRadioBtnInscriptas);
        jRadioBtnInscriptas.setText("Materias inscriptas");
        jRadioBtnInscriptas.addActionListener(this::jRadioBtnInscriptasActionPerformed);

        buttonGroup1.add(jRadioBtnNoInscriptas);
        jRadioBtnNoInscriptas.setText("Materias sin inscribir");
        jRadioBtnNoInscriptas.addActionListener(this::jRadioBtnNoInscriptasActionPerformed);

        jBtnInscribir.setText("Inscribir");
        jBtnInscribir.addActionListener(this::jBtnInscribirActionPerformed);

        jBtnAnularInscripcion.setText("Anular inscripción");
        jBtnAnularInscripcion.addActionListener(this::jBtnAnularInscripcionActionPerformed);

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(this::jBtnSalirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jRadioBtnInscriptas)
                        .addGap(40, 40, 40)
                        .addComponent(jRadioBtnNoInscriptas))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2)
                        .addGap(55, 55, 55)
                        .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBtnInscribir)
                                .addGap(41, 41, 41)
                                .addComponent(jBtnAnularInscripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBtnSalir)
                                .addGap(16, 16, 16)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioBtnInscriptas)
                    .addComponent(jRadioBtnNoInscriptas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnInscribir)
                    .addComponent(jBtnAnularInscripcion)
                    .addComponent(jBtnSalir))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxAlumnosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxAlumnosItemStateChanged
        cargarDatosTabla();
    }//GEN-LAST:event_jComboBoxAlumnosItemStateChanged

    private void jRadioBtnInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioBtnInscriptasActionPerformed
        cargarDatosTabla();
    }//GEN-LAST:event_jRadioBtnInscriptasActionPerformed

    private void jRadioBtnNoInscriptasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioBtnNoInscriptasActionPerformed
        cargarDatosTabla();
    }//GEN-LAST:event_jRadioBtnNoInscriptasActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jBtnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnInscribirActionPerformed
        int filaSeleccionada = jTablaInscripcion.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                Alumno alumno = (Alumno) jComboBoxAlumnos.getSelectedItem();
                int idMateria = (Integer) jTablaInscripcion.getValueAt(filaSeleccionada, 0);

                Materia materia = new Materia();
                materia.setIdMateria(idMateria);

                int anioActual = java.time.LocalDate.now().getYear();

                conexion con = new conexion();
                CursadaData cursadaData = new CursadaData(con);

                boolean yaInscriptoEsteAnio = false;
                for (Cursada c : cursadaData.listarCursadas()) {
                    if (c.getAlumno().getId() == alumno.getId()
                            && c.getMateria().getIdMateria() == idMateria
                            && c.getCursa() == anioActual) {
                        yaInscriptoEsteAnio = true;
                        break;
                    }
                }

                if (yaInscriptoEsteAnio) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            "El alumno ya está inscripto en esta materia durante el corriente año (" + anioActual + ").",
                            "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Cursada inscripcion = new Cursada();
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripcion.setNota(0.0);
                inscripcion.setAsist(0.0);
                inscripcion.setCursa(anioActual); 

                cursadaData.guardarCursada(inscripcion);

                javax.swing.JOptionPane.showMessageDialog(this, "¡Inscripción realizada con éxito para el año " + anioActual + "!");
                cargarDatosTabla();

            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al inscribir: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jBtnInscribirActionPerformed

    private void jBtnAnularInscripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAnularInscripcionActionPerformed
        int filaSeleccionada = jTablaInscripcion.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                Alumno alumno = (Alumno) jComboBoxAlumnos.getSelectedItem();
                int idMateria = (Integer) jTablaInscripcion.getValueAt(filaSeleccionada, 0);

                conexion con = new conexion();
                CursadaData cursadaData = new CursadaData(con);

                int idCursadaEncontrada = -1;
                for (Cursada c : cursadaData.listarCursadas()) {
                    if (c.getAlumno().getId() == alumno.getId() && c.getMateria().getIdMateria() == idMateria) {
                        idCursadaEncontrada = c.getIdCursada();
                        break;
                    }
                }

                if (idCursadaEncontrada != -1) {
                    cursadaData.borrarCursada(idCursadaEncontrada);
                    javax.swing.JOptionPane.showMessageDialog(this, "¡Inscripción anulada con éxito!");
                    cargarDatosTabla();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No se encontró la inscripción para anular.");
                }

            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al anular inscripción: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jBtnAnularInscripcionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnAnularInscripcion;
    private javax.swing.JButton jBtnInscribir;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JComboBox<Alumno> jComboBoxAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioBtnInscriptas;
    private javax.swing.JRadioButton jRadioBtnNoInscriptas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablaInscripcion;
    // End of variables declaration//GEN-END:variables
}
