
package vista;

import modelo.Materia;
import persistencia.MateriaData;
import persistencia.conexion;


public class Vistamateria extends javax.swing.JInternalFrame {

    
    public Vistamateria() {
        initComponents();
        jBtnGuardar.setEnabled(false);
        jBtnEliminar.setEnabled(false);
        
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
         jtxtNombre.getDocument().addDocumentListener(validadorListener);
         
         java.awt.event.ActionListener radioListener = new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                validarCampos();
            }
        };
         
         radioBtnActivo.addActionListener(radioListener);
         radioBtnInactivo.addActionListener(radioListener);
    }

    public void limpiarCampos(){
        jtxtCodigo.setText("");
        jtxtNombre.setText("");
        buttonGroup1.clearSelection();
        jBtnGuardar.setEnabled(false);
    }
    
    public void validarCampos(){
        boolean hayNombre = !jtxtNombre.getText().trim().isEmpty();
        boolean estadoSeleccionado = radioBtnActivo.isSelected() || radioBtnInactivo.isSelected();
        
        jBtnGuardar.setEnabled(hayNombre && estadoSeleccionado);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtCodigo = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        radioBtnActivo = new javax.swing.JRadioButton();
        radioBtnInactivo = new javax.swing.JRadioButton();
        jBtnLimpiar = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jBtnEliminar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jBtnBuscarMaterias = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Materias");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Materias");

        jLabel2.setText("Código:");

        jLabel3.setText("Nombre:");

        jLabel5.setText("Estado:");

        jtxtCodigo.addActionListener(this::jtxtCodigoActionPerformed);

        buttonGroup1.add(radioBtnActivo);
        radioBtnActivo.setText("Activo");

        buttonGroup1.add(radioBtnInactivo);
        radioBtnInactivo.setText("Inactivo");

        jBtnLimpiar.setText("Limpiar");
        jBtnLimpiar.addActionListener(this::jBtnLimpiarActionPerformed);

        jBtnGuardar.setText("Guardar");
        jBtnGuardar.addActionListener(this::jBtnGuardarActionPerformed);

        jBtnEliminar.setText("Eliminar");
        jBtnEliminar.addActionListener(this::jBtnEliminarActionPerformed);

        jBtnSalir.setText("Salir");
        jBtnSalir.addActionListener(this::jBtnSalirActionPerformed);

        jBtnBuscarMaterias.setText("Buscar");
        jBtnBuscarMaterias.addActionListener(this::jBtnBuscarMateriasActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jBtnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(radioBtnActivo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(radioBtnInactivo))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jBtnBuscarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jBtnBuscarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(radioBtnActivo)
                    .addComponent(radioBtnInactivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnLimpiar)
                    .addComponent(jBtnGuardar)
                    .addComponent(jBtnEliminar)
                    .addComponent(jBtnSalir))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnBuscarMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBuscarMateriasActionPerformed
        try {
            int cod = Integer.parseInt(jtxtCodigo.getText().trim());
            conexion con = new conexion();
            MateriaData materiaData = new MateriaData(con);
            Materia encontrada = materiaData.buscarMateria(cod);
            
            if (encontrada != null){
                jtxtNombre.setText(encontrada.getNombre());
                if (encontrada.isEstado()){
                    radioBtnActivo.setSelected(true);
                } else {
                    radioBtnInactivo.setSelected(true);
                }
                
                jBtnEliminar.setEnabled(true);
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontro ninguna materia con el codigo " + jtxtCodigo.getText());
                jBtnEliminar.setEnabled(false);
            }
        } catch (NumberFormatException ex){
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese un codigo valido");
        }
    }//GEN-LAST:event_jBtnBuscarMateriasActionPerformed

    private void jBtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jBtnLimpiarActionPerformed

    private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
        try {
            String nombre = jtxtNombre.getText().trim();
            boolean activo;
            
            if (radioBtnActivo.isSelected()){
                activo = true;
            } else if (radioBtnInactivo.isSelected()){
                activo = false;
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar un estado para la materia");
                return;
            }
            
            conexion con = new conexion();
            MateriaData materiaData = new MateriaData(con);
            
            String cod = jtxtCodigo.getText().trim();
            
            if (cod.isEmpty()){
                Materia nuevaMateria = new Materia();
                nuevaMateria.setNombre(nombre);
                nuevaMateria.setEstado(activo);
                materiaData.guardarMateria(nuevaMateria);
                javax.swing.JOptionPane.showMessageDialog(this, "Nueva materia guardada exitosamente");
                limpiarCampos();
            } else {
                int id = Integer.parseInt(cod);
                Materia materiaActualizada = new Materia(id, nombre, activo);
                boolean actualizo = materiaData.actualizarMateria(materiaActualizada);
                
                if (actualizo){
                    javax.swing.JOptionPane.showMessageDialog(this, "Materia actualizada con exito");
                    limpiarCampos();
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No se puede actualizar, no existe una materia con el codigo " + id);
                }
            }            
        } catch (NumberFormatException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese un codigo valido");
        } catch (Exception ex){
            javax.swing.JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_jBtnGuardarActionPerformed

    private void jBtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEliminarActionPerformed
        try {
            int cod = Integer.parseInt(jtxtCodigo.getText().trim());
            conexion con = new conexion();
            MateriaData materiaData = new MateriaData(con);
            Materia materia = materiaData.buscarMateria(cod);
            
            if (materia != null){
                int confirmar = javax.swing.JOptionPane.showConfirmDialog(this, "Seguro que desea eliminar " + materia.getNombre() + " de la base de datos?", "Confirmar eliminacion", javax.swing.JOptionPane.YES_NO_CANCEL_OPTION);
                
                if (confirmar == javax.swing.JOptionPane.YES_OPTION){
                    javax.swing.JOptionPane.showMessageDialog(this, "Materia eliminada correctamente");
                    materiaData.borrarMateria(cod);
                    limpiarCampos();
                    jBtnEliminar.setEnabled(false);
                }
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se encontro la materia a eliminar");
            }
        } catch (NumberFormatException ex){
            javax.swing.JOptionPane.showMessageDialog(this, "Codigo invalido");
        } catch (Exception ex){
            javax.swing.JOptionPane.showMessageDialog(this, "Se ha producido un error: " + ex.getMessage());
        }
    }//GEN-LAST:event_jBtnEliminarActionPerformed

    private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_jBtnSalirActionPerformed

    private void jtxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBtnBuscarMaterias;
    private javax.swing.JButton jBtnEliminar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JButton jBtnLimpiar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JRadioButton radioBtnActivo;
    private javax.swing.JRadioButton radioBtnInactivo;
    // End of variables declaration//GEN-END:variables
}
