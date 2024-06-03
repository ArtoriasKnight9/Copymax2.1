
package Paneles;

import Clases.Clientesclass;
import Conexion.Conexion;
import Filtros.Filtronumeros;
import Filtros.Letraseditor;
import Filtros.Numeroseditor;
import Jframes.RegistroClientes;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.PlainDocument;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableCellEditor;

public class Clientes extends javax.swing.JPanel {

    private DefaultTableModel modelo;
     
    public Clientes() {
        initComponents();
        modelo = new DefaultTableModel();
       
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Celular");
        modelo.addColumn("RFC");
        modelo.addColumn("Correo");
        
        Tablaclientes.setModel(modelo);
        llenarTabla();
        tabladiseño();
    
    }
    private void tabladiseño(){
    // Asignar el editor personalizado a las columnas específicas
        Tablaclientes.getColumnModel().getColumn(0).setCellEditor(new Letraseditor()); 
        Tablaclientes.getColumnModel().getColumn(1).setCellEditor(new Letraseditor());
        Tablaclientes.getColumnModel().getColumn(2).setCellEditor(new Numeroseditor());
        if (Tablaclientes.getColumnModel().getColumnCount() > 0) {
        
        Tablaclientes.getColumnModel().getColumn(0).setMaxWidth(110);
        Tablaclientes.getColumnModel().getColumn(1).setMaxWidth(150);       
        Tablaclientes.getColumnModel().getColumn(2).setMaxWidth(120);
        Tablaclientes.getColumnModel().getColumn(3).setMaxWidth(160); 
        Tablaclientes.getColumnModel().getColumn(4).setMaxWidth(220);
        
       Tablaclientes.setRowHeight(30);
     
}
    
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tablaclientes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtregclicelularbusqueda = new javax.swing.JTextField();
        BtnNuevo = new javax.swing.JButton();
        BtnModificar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        Btnactualizar = new javax.swing.JButton();

        setBackground(new java.awt.Color(54, 170, 219));

        Tablaclientes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        Tablaclientes.setModel(new javax.swing.table.DefaultTableModel(
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
        Tablaclientes.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(Tablaclientes);
        Tablaclientes.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (Tablaclientes.getColumnModel().getColumnCount() > 0) {
            Tablaclientes.getColumnModel().getColumn(0).setPreferredWidth(30);
        }

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clasificacion (Custom).png"))); // NOI18N
        jLabel1.setText("Registro de Clientes");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtregclicelularbusqueda.setBackground(new java.awt.Color(204, 255, 255));
        txtregclicelularbusqueda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        BtnNuevo.setText("Nuevo");
        BtnNuevo.setOpaque(false);
        BtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(txtregclicelularbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtregclicelularbusqueda)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
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
      
        int selectedRow = Tablaclientes.getSelectedRow();
        if (selectedRow != -1) {
            String nombre = (String) modelo.getValueAt(selectedRow, 0);
            String apellidos = (String) modelo.getValueAt(selectedRow, 1);
            String celular = (String) modelo.getValueAt(selectedRow, 2);
            String rfc = (String) modelo.getValueAt(selectedRow, 3);
            String correo = (String) modelo.getValueAt(selectedRow, 4);
            
            Clientesclass cliente = new Clientesclass();
            cliente.setNombre(nombre);
            cliente.setApellidos(apellidos);
            cliente.setCelular(celular);
            cliente.setRfc(rfc);
            cliente.setCorreo(correo);

            actualizarClienteBD(cliente);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una fila para modificar.");
        }
        
        
    }//GEN-LAST:event_BtnModificarActionPerformed
    
    public void actualizarClienteBD(Clientesclass cliente) {
        Conexion conex = new Conexion();
        String consulta = "UPDATE Cliente SET Nombre = ?, Apellidos = ?, RFC = ?, Correo = ? WHERE Celular = ?";
        try (
                PreparedStatement pst = conex.getConnection().prepareCall(consulta)) {
            pst.setString(1, cliente.getNombre());
            pst.setString(2, cliente.getApellidos());
            pst.setString(3, cliente.getRfc());
            pst.setString(4, cliente.getCorreo());
            pst.setString(5, cliente.getCelular());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente Modificado Con Exito !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar cliente: " + e.toString());
        }
        
    }

    
    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
         int selectedRow = Tablaclientes.getSelectedRow();
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

    private void BtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNuevoActionPerformed
       
     RegistroClientes  regi = new RegistroClientes();
     
     regi.setVisible(true);
     
     
    }//GEN-LAST:event_BtnNuevoActionPerformed

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
          Clientesclass clientee = new Clientesclass();
        List<Clientesclass> clientes = clientee.obtenerClientes();
        
        for (Clientesclass cliente : clientes) {
            Object[] fila = new Object[5];
            fila[0] = cliente.getNombre();
            fila[1] = cliente.getApellidos();
            fila[2] = cliente.getCelular();
            fila[3] = cliente.getRfc();
            fila[4] = cliente.getCorreo();
            modelo.addRow(fila);
        }
    }
      
      private void eliminarClienteBD(String celular) {
        Conexion conex = new Conexion();
        String consulta = "DELETE FROM Cliente WHERE Celular = ?";
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
    Clientesclass clientee = new Clientesclass();
    List<Clientesclass> clientes = clientee.obtenerClientes();
    
    // Agregar las nuevas filas al modelo de la tabla
    for (Clientesclass cliente : clientes) {
        Object[] fila = new Object[5];
        fila[0] = cliente.getNombre();
        fila[1] = cliente.getApellidos();
        fila[2] = cliente.getCelular();
        fila[3] = cliente.getRfc();
        fila[4] = cliente.getCorreo();
        modelo.addRow(fila);
    }
}
   private void actualizarTablabus() {
    String textoBusqueda = txtregclicelularbusqueda.getText();
    
    // Limpia la tabla
    DefaultTableModel modelo = (DefaultTableModel) Tablaclientes.getModel();
    modelo.setRowCount(0);

    // Realiza una consulta a la base de datos para obtener los registros que coincidan con el texto de búsqueda
    Clientesclass clientee = new Clientesclass();
    List<Clientesclass> clientes = clientee.obtenerClientesPorNumero(textoBusqueda);
    
    // Agrega los registros encontrados a la tabla
    for (Clientesclass cliente : clientes) {
        Object[] fila = new Object[5];
        fila[0] = cliente.getNombre();
        fila[1] = cliente.getApellidos();
        fila[2] = cliente.getCelular();
        fila[3] = cliente.getRfc();
        fila[4] = cliente.getCorreo();
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
    private javax.swing.JButton BtnNuevo;
    private javax.swing.JButton Btnactualizar;
    private javax.swing.JTable Tablaclientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtregclicelularbusqueda;
    // End of variables declaration//GEN-END:variables
}
