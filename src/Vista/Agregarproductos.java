/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.Productoclass;
import Contorlador.Conexion;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Artorias<maxstell5549@hotmail.com>
 */
public class Agregarproductos extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    private Ventas ventasPanel; // Referencia al panel de ventas o a la clase que tiene el método agregarProductoAlTicket

    /**
     * Creates new form Agregarproductos
     */
    public Agregarproductos() {
        initComponents();
        agregarKeyListenerGlobal();
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio Unitario");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Categoría");
        Stock.setModel(modelo);
        llenarTabla();
        
        
         Jtxtbusquedastock.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchText = Jtxtbusquedastock.getText();
                List<Productoclass> filteredProducts = getFilteredProducts(searchText);
                updateTable(filteredProducts);
            }
        });

        Stock.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) {
                    int selectedRow = Stock.getSelectedRow();
                    if (selectedRow != -1) {
                        Productoclass selectedProduct = getProductFromTableRow(selectedRow);
                        Ventas.getInstance().agregarProductoAlTicketstocl(selectedProduct);
                        dispose();
                    }
                }
            }
        });

        Stock.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    
                    int selectedRow = Stock.getSelectedRow();
                    if (selectedRow != -1) {
                        Productoclass selectedProduct = getProductFromTableRow(selectedRow);
                          Ventas.getInstance().agregarProductoAlTicketstocl(selectedProduct);
                          dispose();
                    }
                }
            }
        });
    
    }
    
    public Productoclass getProductFromTableRow(int row) {
        int id = (int) modelo.getValueAt(row, 0);
        String nombre = (String) modelo.getValueAt(row, 1);
        double precio = (double) modelo.getValueAt(row, 2);
        int cantidad = (int) modelo.getValueAt(row, 3);
        String categoria = (String) modelo.getValueAt(row, 4);

        Productoclass product = new Productoclass();
        product.setId(id);
        product.setNombre(nombre);
        product.setPrecio(precio);
        product.setCantidad(cantidad);
        product.setCategoria(categoria);
        return product;
    }
    
    
    public List<Productoclass> getFilteredProducts(String searchText) {
        List<Productoclass> products = new ArrayList<>();
        String query = "SELECT `idProductos`, `Nombre_producto`, `Cantidad`, `Precio`, `Categoria`, `Icono` " +
                       "FROM `productos` " +
                       "WHERE `idProductos` LIKE ? OR `Nombre_producto` LIKE ?";
 Conexion conex = new Conexion();
        try (Connection conn = conex.getConnection() ;
             PreparedStatement ps = conn.prepareStatement(query)) {
             
            ps.setString(1, "%" + searchText + "%");
            ps.setString(2, "%" + searchText + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Productoclass product = new Productoclass();
                product.setId(rs.getInt("idProductos"));
                product.setNombre(rs.getString("Nombre_producto"));
                product.setCantidad(rs.getInt("Cantidad"));
                product.setPrecio(rs.getDouble("Precio"));
                product.setCategoria(rs.getString("Categoria"));
                product.setIcono(rs.getString("Icono"));
                products.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return products;
    }
    
    
    
 public void updateTable(List<Productoclass> products) {
        modelo.setRowCount(0);  // Limpiar la tabla
        for (Productoclass product : products) {
            Object[] fila = new Object[5];
            fila[0] = product.getId();
            fila[1] = product.getNombre();
            fila[2] = product.getPrecio();
            fila[3] = product.getCantidad();
            fila[4] = product.getCategoria();
            modelo.addRow(fila);
        }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        Stock = new javax.swing.JTable();
        Jtxtbusquedastock = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 102, 102));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        Stock.setBackground(new java.awt.Color(102, 204, 255));
        Stock.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Stock.setForeground(new java.awt.Color(0, 0, 0));
        Stock.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Stock);

        Jtxtbusquedastock.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
            .addComponent(Jtxtbusquedastock)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(Jtxtbusquedastock, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
  
    
    

    public void llenarTabla() {
          Productoclass productoo = new Productoclass();
        List<Productoclass> productos = productoo.obtenerProductos();
        
        for (Productoclass producto : productos) {
            Object[] fila = new Object[5];
            fila[0] = producto.getId();
            fila[1] = producto.getNombre();
            fila[2] = producto.getPrecio();
            fila[3] = producto.getCantidad();
            fila[4] = producto.getCategoria();
             modelo.addRow(fila);
        }
    }
    
    private void agregarKeyListenerGlobal() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                dispose();
                }
                
                return false;
            }
        });
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
            java.util.logging.Logger.getLogger(Agregarproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agregarproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agregarproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agregarproductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agregarproductos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Jtxtbusquedastock;
    private javax.swing.JTable Stock;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
