package vista;

import modelo.Alumno;
import modelo.Cursada;
import modelo.Materia;
import persistencia.AlumnoData;
import persistencia.CursadaData;
import persistencia.conexion;

public class Vistanotas extends javax.swing.JInternalFrame {

    private javax.swing.table.DefaultTableModel modeloTabla = new javax.swing.table.DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return column == 2;
        }
    };

    public Vistanotas() {
        initComponents();
        cargarComboBox();
        armarCabecera();
        jComboBoxAlumnos.addActionListener(e -> cargarDatosTabla());
        cargarDatosTabla();
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
        modeloTabla.addColumn("ID Materia");
        modeloTabla.addColumn("Nombre Materia");
        modeloTabla.addColumn("Nota");
        jTableNotas.setModel(modeloTabla);
    }

    public void cargarDatosTabla() {
        modeloTabla.setRowCount(0);

        Alumno seleccionado = (Alumno) jComboBoxAlumnos.getSelectedItem();
        if (seleccionado == null) {
            return;
        }

        conexion con = new conexion();
        CursadaData cursadaData = new CursadaData(con);

        // Obtenemos las materias y buscamos su nota correspondiente
        for (Materia m : cursadaData.materiasDeUnAlumno(seleccionado.getId())) {
            double notaActual = 0.0;
            int idCursadaEncontrada = -1;

            for (Cursada c : cursadaData.listarCursadas()) {
                if (c.getAlumno().getId() == seleccionado.getId() && c.getMateria().getIdMateria() == m.getIdMateria()) {
                    notaActual = c.getNota();
                    idCursadaEncontrada = c.getIdCursada();
                    break;
                }
            }

            modeloTabla.addRow(new Object[]{
                m.getIdMateria(),
                m.getNombre(),
                notaActual
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxAlumnos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableNotas = new javax.swing.JTable();
        jBtnGuardar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consultas de Notas");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Consultas de Notas");

        jLabel2.setText("Seleccione un alumno:");

        jTableNotas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableNotas);

        jBtnGuardar.setText("Guardar");
        jBtnGuardar.addActionListener(this::jBtnGuardarActionPerformed);

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(this::jBtnSalirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jBtnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBtnSalir)
                .addGap(69, 69, 69))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnGuardar)
                    .addComponent(jBtnSalir))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
        int filaSeleccionada = jTableNotas.getSelectedRow();
        if (filaSeleccionada != -1) {
            try {
                Alumno alumno = (Alumno) jComboBoxAlumnos.getSelectedItem();
                int idMateria = (Integer) jTableNotas.getValueAt(filaSeleccionada, 0);

                double nuevaNota = Double.parseDouble(jTableNotas.getValueAt(filaSeleccionada, 2).toString());

                conexion con = new conexion();
                CursadaData cursadaData = new CursadaData(con);

                int idCursada = -1;
                for (Cursada c : cursadaData.listarCursadas()) {
                    if (c.getAlumno().getId() == alumno.getId() && c.getMateria().getIdMateria() == idMateria) {
                        idCursada = c.getIdCursada();
                        break;
                    }
                }

                if (idCursada != -1) {
                    cursadaData.registrarNota(idCursada, nuevaNota);

                    javax.swing.JOptionPane.showMessageDialog(this, "¡Nota actualizada con éxito!");
                    cargarDatosTabla();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No se encontró la inscripción para actualizar.");
                }

            } catch (NumberFormatException ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido para la nota.", "Error de formato", javax.swing.JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar la nota: " + ex.getMessage());
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione una fila de la tabla.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jBtnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JComboBox<Alumno> jComboBoxAlumnos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableNotas;
    // End of variables declaration//GEN-END:variables
}
