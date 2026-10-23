/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import javax.swing.event.DocumentEvent;
import persistencia.AlumnoData;
import modelo.Alumno;
import persistencia.conexion;

public class Vistaalumno extends javax.swing.JInternalFrame {

    /**
     * Creates new form Vistaalumno
     */
    public Vistaalumno() {
        initComponents();
        jButtonGuardar.setEnabled(false);
        jButtonEliminar.setEnabled(false);
        javax.swing.event.DocumentListener validadorListener = new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                validarCampos();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                validarCampos();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                validarCampos();
            }
        };

        jTxtDocumento.getDocument().addDocumentListener(validadorListener);
        jTxtNombre.getDocument().addDocumentListener(validadorListener);

        jDatecFecNac.getDateEditor().addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                if ("date".equals(evt.getPropertyName())) {
                    validarCampos();
                }
            }
        });

        java.awt.event.ActionListener radioListener = new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                validarCampos();
            }
        };
        jRadioBtnActivo.addActionListener(radioListener);
        jRadioBtnInactivo.addActionListener(radioListener);
    }

    public void validarCampos() {
        boolean documentoLleno = !jTxtDocumento.getText().trim().isEmpty();
        boolean nombreLleno = !jTxtNombre.getText().trim().isEmpty();
        boolean fechaLlena = (jDatecFecNac.getDate() != null);
        boolean estadoSelect = jRadioBtnActivo.isSelected() || jRadioBtnInactivo.isSelected();

        jButtonGuardar.setEnabled(documentoLleno && nombreLleno && fechaLlena && estadoSelect);
    }

    public void limpiarCampos() {
        jTxtDocumento.setText("");
        jTxtNombre.setText("");
        jDatecFecNac.setDate(null);
        buttonGroup1.clearSelection();
        jButtonGuardar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jTxtDocumento = new javax.swing.JTextField();
        jTxtNombre = new javax.swing.JTextField();
        jDatecFecNac = new com.toedter.calendar.JDateChooser();
        jButtonBuscar = new javax.swing.JButton();
        jRadioBtnActivo = new javax.swing.JRadioButton();
        jRadioBtnInactivo = new javax.swing.JRadioButton();
        jBtnSalir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alumnos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Alumno");

        jLabel2.setText("Documento:");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Fecha de Nacimiento:");

        jLabel6.setText("Estado:");

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(this::jButtonLimpiarActionPerformed);

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(this::jButtonGuardarActionPerformed);

        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.addActionListener(this::jButtonEliminarActionPerformed);

        jButtonBuscar.setIcon(new javax.swing.ImageIcon("C:\\Users\\JuanS\\OneDrive\\Documentos\\GitHub\\Proyecto-Transversal\\src\\iconos\\buscar.png")); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(this::jButtonBuscarActionPerformed);

        buttonGroup1.add(jRadioBtnActivo);
        jRadioBtnActivo.setText("Activo");

        buttonGroup1.add(jRadioBtnInactivo);
        jRadioBtnInactivo.setText("Inactivo");

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(this::jBtnSalirActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jRadioBtnActivo))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jButtonLimpiar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonGuardar)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jRadioBtnInactivo)
                                        .addGap(78, 78, 78))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jButtonEliminar)
                                        .addGap(18, 18, 18)
                                        .addComponent(jBtnSalir)))))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTxtDocumento, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(jTxtNombre)))
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(jDatecFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTxtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jDatecFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioBtnActivo)
                    .addComponent(jRadioBtnInactivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLimpiar)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButtonEliminar)
                    .addComponent(jBtnSalir))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        limpiarCampos();
        jButtonEliminar.setEnabled(false);
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        try {
            int dni = Integer.parseInt(jTxtDocumento.getText().trim());
            String nombre = jTxtNombre.getText().trim();
            java.util.Date fecha = jDatecFecNac.getDate();
            if (fecha == null) {
                javax.swing.JOptionPane.showMessageDialog(this, "Por favor, seleccione una fecha");
                return;
            }
            java.time.LocalDate fechaNac = fecha.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

            int edad = java.time.Period.between(fechaNac, java.time.LocalDate.now()).getYears();
            if (edad < 18) {
                javax.swing.JOptionPane.showMessageDialog(this, "El alumno debe tener una edad mayor o igual a 18 años.", "Menor de edad", javax.swing.JOptionPane.WARNING_MESSAGE);
                return;
            }

            boolean activo = false;

            if (jRadioBtnActivo.isSelected()) {
                activo = true;
            } else if (jRadioBtnInactivo.isSelected()) {
                activo = false;
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un estado para el alumno");
                return;
            }

            conexion con = new conexion();
            AlumnoData alumnoData = new AlumnoData(con);

            Alumno alumnoExiste = alumnoData.buscarAlumno(dni);

            if (alumnoExiste == null) {
                Alumno nuevoAlumno = new Alumno();
                nuevoAlumno.setDni(dni);
                nuevoAlumno.setNombre(nombre);
                nuevoAlumno.setFechaNac(fechaNac);
                nuevoAlumno.setActivo(activo);

                alumnoData.guardarAlumno(nuevoAlumno);
                javax.swing.JOptionPane.showMessageDialog(this, "Alumno guardado correctamente");
                limpiarCampos();
            } else {
                alumnoExiste.setNombre(nombre);
                alumnoExiste.setFechaNac(fechaNac);
                alumnoExiste.setActivo(activo);

                boolean actualizo = alumnoData.actualizarAlumno(alumnoExiste);

                if (actualizo) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Informacion de alumno actualizada correctamente");
                    limpiarCampos();
                    jButtonEliminar.setEnabled(false);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No se pudo actualizar alumno");
                }
            }

            limpiarCampos();
            jButtonEliminar.setEnabled(false);

        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese un numero de documento valido");
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        try {
            int dni = Integer.parseInt(jTxtDocumento.getText().trim());
            conexion con = new conexion();
            AlumnoData alumnoData = new AlumnoData(con);
            Alumno alumno = alumnoData.buscarAlumno(dni);

            if (alumno != null) {
                int confirmar = javax.swing.JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar a " + alumno.getNombre() + " de la base de datos?", "Confirmar eliminacion", javax.swing.JOptionPane.YES_NO_CANCEL_OPTION);

                if (confirmar == javax.swing.JOptionPane.YES_OPTION) {
                    alumnoData.borrarAlumno(alumno.getId());
                    limpiarCampos();
                    jButtonEliminar.setEnabled(false);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontro el alumno a eliminar");
            }
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Numero de documento invalido");
        } catch (Exception ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Se ha producido un error " + ex.getMessage());
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        try {;
            int dni = Integer.parseInt(jTxtDocumento.getText().trim());
            conexion con = new conexion();
            AlumnoData alumnoData = new AlumnoData(con);
            Alumno encontrado = alumnoData.buscarAlumno(dni);

            if (encontrado != null) {
                jTxtNombre.setText(encontrado.getNombre());
                if (encontrado.getFechaNac() != null) {
                    java.util.Date fecha = java.sql.Date.valueOf(encontrado.getFechaNac());
                    jDatecFecNac.setDate(fecha);
                } else {
                    jDatecFecNac.setDate(null);
                }

                if (encontrado.isActivo()) {
                    jRadioBtnActivo.setSelected(true);
                } else {
                    jRadioBtnInactivo.setSelected(true);
                }

                jButtonEliminar.setEnabled(true);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontro ningun alumno con el numero de documento " + jTxtDocumento.getText());
                jButtonEliminar.setEnabled(false);
            }
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "El numero de documento debe ser un numero valido");
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonLimpiar;
    private com.toedter.calendar.JDateChooser jDatecFecNac;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioBtnActivo;
    private javax.swing.JRadioButton jRadioBtnInactivo;
    private javax.swing.JTextField jTxtDocumento;
    private javax.swing.JTextField jTxtNombre;
    // End of variables declaration//GEN-END:variables
}
