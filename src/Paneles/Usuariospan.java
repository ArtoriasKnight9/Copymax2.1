
package Paneles;

import Clases.Clientesclass;
import Clases.Usuariosclass;
import Conexion.Conexion;
import Filtros.Filtronumeros;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PlainDocument;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Usuariospan extends javax.swing.JPanel {

    private DefaultTableModel modelo;
     
    public Usuariospan() {
        initComponents();
        modelo = new DefaultTableModel();
       modelo.addColumn("idUsuario");
        modelo.addColumn("Nombre de Usuario");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Celular");
        modelo.addColumn("Rol");
        Tablausuarios.setModel(modelo);
        llenarTabla();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tablausuarios = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtregclicelularbusqueda = new javax.swing.JTextField();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        Btnactualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));

        Tablausuarios.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Tablausuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        Tablausuarios.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(Tablausuarios);
        Tablausuarios.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clasificacion (Custom).png"))); // NOI18N
        jLabel1.setText("Lista Usuarios");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtregclicelularbusqueda.setBackground(new java.awt.Color(51, 51, 51));
        txtregclicelularbusqueda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtregclicelularbusqueda.setForeground(new java.awt.Color(255, 255, 255));
        txtregclicelularbusqueda.setText("Numero a buscar");
        txtregclicelularbusqueda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtregclicelularbusquedaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtregclicelularbusquedaFocusLost(evt);
            }
        });
        txtregclicelularbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtregclicelularbusquedaActionPerformed(evt);
            }
        });

        BtnModificar.setText("Modificar");
        BtnModificar.setOpaque(false);
        BtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnModificarActionPerformed(evt);
            }
        });

        BtnEliminar.setText("Eliminar");
        BtnEliminar.setOpaque(false);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        Btnactualizar.setText("Actualizar");
        Btnactualizar.setOpaque(false);
        Btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnactualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(txtregclicelularbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtregclicelularbusqueda)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        txtregclicelularbusqueda.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                actualizarTablabus();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                actualizarTablabus();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                actualizarTablabus();
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    private void BtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnModificarActionPerformed
     int selectedRow = Tablausuarios.getSelectedRow();
        if (selectedRow != -1) {
            // Obtener los valores de la fila seleccionada
            int idUsuario = (int) modelo.getValueAt(selectedRow, 0);
            String nombreusario = (String) modelo.getValueAt(selectedRow, 1);
            String nombre = (String) modelo.getValueAt(selectedRow, 2);
            String apellidos = (String) modelo.getValueAt(selectedRow, 3);
            String celular = (String) modelo.getValueAt(selectedRow, 4);
            String rol = (String) modelo.getValueAt(selectedRow, 5);
            
            System.out.println(nombre);
            System.out.println(nombreusario);
            System.out.println(apellidos);
            System.out.println(celular);
            System.out.println(rol);
            
            // Actualizar en la base de datos
            Conexion conex = new Conexion();
            String consulta = "UPDATE Usuario SET Nombreusuario = ?, Nombre = ?, Apellidos = ?, Celular = ?, Rol = ? WHERE idUsuario = ?";
            try (Connection con = conex.getConnection(); 
                 PreparedStatement pst = con.prepareStatement(consulta)) {
                pst.setString(1, nombreusario);
                pst.setString(2, nombre);
                pst.setString(3, apellidos);
                pst.setString(4, celular);
                pst.setString(5, rol);
                pst.setInt(6, idUsuario);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Usuario Modificado Con Exito !!!");
                llenarTabla(); // Volver a llenar la tabla después de la actualización
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al modificar usuario: " + e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.");
        }
        
    }//GEN-LAST:event_BtnModificarActionPerformed
    
   public void actualizarClienteBD(Usuariosclass usuarios) {
        Conexion conex = new Conexion();
        String consulta = "UPDATE Usuario SET Nombreusuario = ?, Nombre = ?, Apellidos = ?, Rol = ? ,Celular= ? WHERE idUsuario = ?";
        try (
                PreparedStatement pst = conex.getConnection().prepareCall(consulta)) {
            pst.setString(1, usuarios.getNombreUsuario());
            pst.setString(2, usuarios.getNombre());
            pst.setString(3, usuarios.getApellidos());
            pst.setString(4, usuarios.getRol());
            pst.setString(5, usuarios.getCelular());
            pst.setInt(6,usuarios.getId());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usuario Modificado Con Exito !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar cliente: " + e.toString());
        }
        
    }


    
    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
         int selectedRow = Tablausuarios.getSelectedRow();
        if (selectedRow != -1) {
            String celular = (String) modelo.getValueAt(selectedRow, 2);

            eliminarClienteBD(celular);
            modelo.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para eliminar.");
        }
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void txtregclicelularbusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtregclicelularbusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtregclicelularbusquedaActionPerformed

    private void txtregclicelularbusquedaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregclicelularbusquedaFocusGained
        if (txtregclicelularbusqueda.getText().equals("Numero a buscar")){
        txtregclicelularbusqueda.setText("");
        txtregclicelularbusqueda.setForeground(Color.black);
        
        PlainDocument doc = (PlainDocument)  txtregclicelularbusqueda.getDocument();
        doc.setDocumentFilter(new Filtronumeros());
       }
    }//GEN-LAST:event_txtregclicelularbusquedaFocusGained

    private void txtregclicelularbusquedaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtregclicelularbusquedaFocusLost
         if (txtregclicelularbusqueda.getText().isEmpty()){
        txtregclicelularbusqueda.setForeground(new Color(204, 204, 204));
        txtregclicelularbusqueda.setText("Numero a buscar");
        }
    }//GEN-LAST:event_txtregclicelularbusquedaFocusLost

    private void BtnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnactualizarActionPerformed
        actualizarTabla();
    }//GEN-LAST:event_BtnactualizarActionPerformed
    
      private void llenarTabla() {
        modelo.setRowCount(0); // Borrar todas las filas existentes
        Conexion conex = new Conexion();
        String sql = "SELECT idUsuario, Nombreusuario, Nombre, Apellidos, Celular, Rol FROM Usuario";
        try (Connection con = conex.getConnection(); 
             PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Object[] fila = new Object[6];
                fila[0] = rs.getInt("idUsuario");
                fila[1] = rs.getString("Nombreusuario");
                fila[2] = rs.getString("Nombre");
                fila[3] = rs.getString("Apellidos");
                fila[4] = rs.getString("Celular");
                fila[5] = rs.getString("Rol");
                modelo.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener usuarios: " + e.toString());
        }
    }
      
      private void eliminarClienteBD(String celular) {
        Conexion conex = new Conexion();
        String consulta = "DELETE FROM Usuario WHERE Celular = ?";
        try (
                PreparedStatement pst = conex.getConnection().prepareCall(consulta)) {
            pst.setString(1, celular);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Eliminado Con Exito !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e.toString());
        }
    }
     
   public void actualizarTabla() {
    // Limpiar el modelo de la tabla
    modelo.setRowCount(0);
    
    // Obtener la lista actualizada de clientes
    Usuariosclass usuarioo = new Usuariosclass();
    List<Usuariosclass> usuario = usuarioo.obtenerUsuarios();
    
    // Agregar las nuevas filas al modelo de la tabla
    for (Usuariosclass usuariooo : usuario) {
            Object[] fila = new Object[6];
            fila[0] = usuariooo.getId();
            fila[1] = usuariooo.getNombreUsuario();
            fila[2] = usuariooo.getNombre();
            fila[3] = usuariooo.getApellidos();
            fila[4] = usuariooo.getCelular();
            fila[5] = usuariooo.getRol();
            modelo.addRow(fila);
        }
}
   private void actualizarTablabus() {
    String textoBusqueda = txtregclicelularbusqueda.getText();
    
    // Limpia la tabla
    DefaultTableModel modelo = (DefaultTableModel) Tablausuarios.getModel();
    modelo.setRowCount(0);

    // Realiza una consulta a la base de datos para obtener los registros que coincidan con el texto de búsqueda
    Usuariosclass usuariosclass = new Usuariosclass();
    List<Usuariosclass> usuarioss = usuariosclass.obtenerUsuariosPorNumero(textoBusqueda);
    
    // Agrega los registros encontrados a la tabla
    for (Usuariosclass usuariooo : usuarioss) {
            Object[] fila = new Object[6];
            fila[0] = usuariooo.getNombreUsuario();
            fila[1] = usuariooo.getNombre();
            fila[2] = usuariooo.getApellidos();
            fila[3] = usuariooo.getCelular();
            fila[4] = usuariooo.getRol();
            modelo.addRow(fila);
        }
   
   }

   public void ajustarInterfazSegunRol(String rol) {
        if ("Estandar".equals(rol)) {
            BtnModificar.setEnabled(false);
            BtnEliminar.setEnabled(false);
            
        } else {
            BtnModificar.setEnabled(true);
            BtnEliminar.setEnabled(true);
        }
    }
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnEliminar;
    public javax.swing.JButton BtnModificar;
    private javax.swing.JButton Btnactualizar;
    private javax.swing.JTable Tablausuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtregclicelularbusqueda;
    // End of variables declaration//GEN-END:variables
}
