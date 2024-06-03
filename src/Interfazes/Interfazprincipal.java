
package Interfazes;

import Clases.Usuariosesion;
import Clases.VentaManager;
import Paneles.Productos;
import Paneles.Estadistica;
import Paneles.Ventas;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import rojerusan.RSAnimation;
import Conexion.Conexion;
import Filtros.Filtronumeros;
import Jframes.Corte;
import Paneles.Clientes;
import Paneles.Usuariospan;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.text.PlainDocument;

public class Interfazprincipal extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private Clientes clientesPanel;
    private Ventas ventaspanel;
    public Double totalVentasDelDia=0.0;
    
    public void registrarVenta(double totalVenta) {
        this.totalVentasDelDia += totalVenta;
    }

    public double getContadorVenta() {
        return totalVentasDelDia;
    }
    
    public Interfazprincipal() {
     
        initComponents();
        inicializarCardLayout();
        agregarKeyListenerGlobal();
        ajustarInterfazSegunRol(Usuariosesion.getInstance().getRol());
        bloquearbusqueda();
        
        Jtxtbusquedaproductos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                Ventas.getInstance().cargarProductos(Jtxtbusquedaproductos.getText());
            }
        });
        
       
  
    }
    
    
    private void inicializarCardLayout() {
       
        // Inicializar CardLayout y agregar paneles
        cardLayout = new CardLayout();
        Panelacambiar.setLayout(cardLayout);

        // Crear instancias de los paneles
        Productos productos = new Productos();
        clientesPanel = new Clientes();
        ventaspanel = Ventas.getInstance();
        Estadistica pedido = new Estadistica();
        Usuariospan usuariopanel = new Usuariospan();
       
        // Agregar los paneles al CardLayout
        Panelacambiar.add(productos,"Productos");
        Panelacambiar.add(clientesPanel, "Clientes");
        Panelacambiar.add(ventaspanel, "Ventas");
        Panelacambiar.add(pedido,"Pedido");
        Panelacambiar.add(usuariopanel,"Usuario");
        // Panel Deafeult panelacambiar
        cardLayout.show(Panelacambiar, "Ventas");
    }
    
    private void agregarKeyListenerGlobal() {
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
            @Override
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getID() == KeyEvent.KEY_PRESSED && e.getKeyCode() == KeyEvent.VK_F10) {
                    cambiarSesion();
                }
                return false;
            }
        });
    }
    
    private void bloquearbusqueda(){
        if (ventaspanel.isVisible()==false){
           Jtxtbusquedaproductos.setEditable(false);
        } else {
            Jtxtbusquedaproductos.setEditable(true);
        }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPadre = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtnVenta = new javax.swing.JButton();
        Estadísticas = new javax.swing.JButton();
        BtnClientes = new javax.swing.JButton();
        Contraer = new javax.swing.JButton();
        Jtxtbusquedaproductos = new javax.swing.JTextField();
        Menuabajo = new javax.swing.JPanel();
        Btnusuarios = new javax.swing.JButton();
        btnvtasdia = new javax.swing.JButton();
        BtnProductos = new javax.swing.JButton();
        btnvtasdia1 = new javax.swing.JButton();
        Panelacambiar = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Copymax 1.0");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelPadre.setBackground(new java.awt.Color(54, 170, 219));
        PanelPadre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));
        PanelPadre.setPreferredSize(new java.awt.Dimension(600, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logopng (Custom) (1).png"))); // NOI18N

        BtnVenta.setBackground(new java.awt.Color(204, 255, 255));
        BtnVenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnVenta.setForeground(new java.awt.Color(0, 0, 0));
        BtnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas (Custom).png"))); // NOI18N
        BtnVenta.setText("Venta");
        BtnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVentaActionPerformed(evt);
            }
        });

        Estadísticas.setBackground(new java.awt.Color(204, 255, 255));
        Estadísticas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Estadísticas.setForeground(new java.awt.Color(0, 0, 0));
        Estadísticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/entrega-de-pedidos (Custom).png"))); // NOI18N
        Estadísticas.setText("Estadísticas");
        Estadísticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EstadísticasActionPerformed(evt);
            }
        });

        BtnClientes.setBackground(new java.awt.Color(204, 255, 255));
        BtnClientes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BtnClientes.setForeground(new java.awt.Color(0, 0, 0));
        BtnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/clasificacion (Custom).png"))); // NOI18N
        BtnClientes.setText("Clientes");
        BtnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClientesActionPerformed(evt);
            }
        });

        Contraer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/configuraciones.png"))); // NOI18N
        Contraer.setOpaque(false);
        Contraer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraerActionPerformed(evt);
            }
        });

        Jtxtbusquedaproductos.setBackground(new java.awt.Color(255, 204, 255));
        Jtxtbusquedaproductos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Jtxtbusquedaproductos.setForeground(new java.awt.Color(0, 0, 0));
        Jtxtbusquedaproductos.setText("Producto a buscar");
        Jtxtbusquedaproductos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                JtxtbusquedaproductosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                JtxtbusquedaproductosFocusLost(evt);
            }
        });
        Jtxtbusquedaproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JtxtbusquedaproductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelPadreLayout = new javax.swing.GroupLayout(PanelPadre);
        PanelPadre.setLayout(PanelPadreLayout);
        PanelPadreLayout.setHorizontalGroup(
            PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPadreLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Contraer, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Estadísticas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnClientes)
                .addGap(18, 18, 18)
                .addComponent(Jtxtbusquedaproductos, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelPadreLayout.setVerticalGroup(
            PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPadreLayout.createSequentialGroup()
                .addGroup(PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPadreLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BtnVenta)
                                .addComponent(Estadísticas)
                                .addComponent(BtnClientes)
                                .addComponent(Jtxtbusquedaproductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelPadreLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Contraer)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(PanelPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 80));

        Menuabajo.setBackground(new java.awt.Color(204, 204, 255));
        Menuabajo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Btnusuarios.setBackground(new java.awt.Color(153, 204, 255));
        Btnusuarios.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Btnusuarios.setForeground(new java.awt.Color(0, 0, 0));
        Btnusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        Btnusuarios.setText("Usuarios");
        Btnusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnusuariosActionPerformed(evt);
            }
        });

        btnvtasdia.setBackground(new java.awt.Color(255, 204, 255));
        btnvtasdia.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnvtasdia.setForeground(new java.awt.Color(0, 0, 0));
        btnvtasdia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas.png"))); // NOI18N
        btnvtasdia.setText("Ventas del día ");
        btnvtasdia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvtasdiaActionPerformed(evt);
            }
        });

        BtnProductos.setBackground(new java.awt.Color(204, 255, 204));
        BtnProductos.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnProductos.setForeground(new java.awt.Color(0, 0, 0));
        BtnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/papeleria (Custom).png"))); // NOI18N
        BtnProductos.setText("Productos");
        BtnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProductosActionPerformed(evt);
            }
        });

        btnvtasdia1.setBackground(new java.awt.Color(255, 102, 102));
        btnvtasdia1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnvtasdia1.setForeground(new java.awt.Color(0, 0, 0));
        btnvtasdia1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        btnvtasdia1.setText("Cerrar Sesión");
        btnvtasdia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvtasdia1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuabajoLayout = new javax.swing.GroupLayout(Menuabajo);
        Menuabajo.setLayout(MenuabajoLayout);
        MenuabajoLayout.setHorizontalGroup(
            MenuabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuabajoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(MenuabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnvtasdia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnusuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnvtasdia1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );
        MenuabajoLayout.setVerticalGroup(
            MenuabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuabajoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Btnusuarios)
                .addGap(27, 27, 27)
                .addComponent(BtnProductos)
                .addGap(29, 29, 29)
                .addComponent(btnvtasdia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnvtasdia1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        getContentPane().add(Menuabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -220, -1, 300));

        Panelacambiar.setBackground(new java.awt.Color(255, 255, 255));
        Panelacambiar.setPreferredSize(new java.awt.Dimension(600, 520));

        javax.swing.GroupLayout PanelacambiarLayout = new javax.swing.GroupLayout(Panelacambiar);
        Panelacambiar.setLayout(PanelacambiarLayout);
        PanelacambiarLayout.setHorizontalGroup(
            PanelacambiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        PanelacambiarLayout.setVerticalGroup(
            PanelacambiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 520, Short.MAX_VALUE)
        );

        getContentPane().add(Panelacambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 800, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVentaActionPerformed
        
       cardLayout.show(Panelacambiar, "Ventas");
    }//GEN-LAST:event_BtnVentaActionPerformed

    private void EstadísticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EstadísticasActionPerformed
       cardLayout.show(Panelacambiar,"Pedido");
    }//GEN-LAST:event_EstadísticasActionPerformed

    private void BtnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientesActionPerformed
        cardLayout.show(Panelacambiar,"Clientes");
    }//GEN-LAST:event_BtnClientesActionPerformed

    
    
    private void ContraerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraerActionPerformed
        
        int posicion= this.Menuabajo.getY();
        System.out.println(posicion);
        if (posicion < -1){
            
            RSAnimation.setBajar(-220, 82, 1, 2,Menuabajo);              
        }else {
            RSAnimation.setSubir(82,-220, 1, 2,Menuabajo);
        }
    }//GEN-LAST:event_ContraerActionPerformed

    private void BtnusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnusuariosActionPerformed
        cardLayout.show(Panelacambiar,"Usuario");
       
    }//GEN-LAST:event_BtnusuariosActionPerformed

    private void BtnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProductosActionPerformed
        cardLayout.show(Panelacambiar,"Productos");
    }//GEN-LAST:event_BtnProductosActionPerformed

    private void btnvtasdiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvtasdiaActionPerformed
        
        Corte corte =new Corte();
        corte.setVisible(true);
        
    }//GEN-LAST:event_btnvtasdiaActionPerformed

    private void JtxtbusquedaproductosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JtxtbusquedaproductosFocusLost
        if (Jtxtbusquedaproductos.getText().isEmpty()){
            Jtxtbusquedaproductos.setForeground(Color.black);
            Jtxtbusquedaproductos.setText("Producto a buscar");
        }
    }//GEN-LAST:event_JtxtbusquedaproductosFocusLost

    private void JtxtbusquedaproductosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_JtxtbusquedaproductosFocusGained
        if (Jtxtbusquedaproductos.getText().equals("Producto a buscar")){
            Jtxtbusquedaproductos.setText("");
            Jtxtbusquedaproductos.setForeground(Color.black);

        }
    }//GEN-LAST:event_JtxtbusquedaproductosFocusGained

    private void JtxtbusquedaproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JtxtbusquedaproductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JtxtbusquedaproductosActionPerformed

    private void btnvtasdia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvtasdia1ActionPerformed
        LoginRegistro login = new LoginRegistro();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnvtasdia1ActionPerformed
    
  
      
       private void cambiarSesion() {
        JTextField nombreUsuarioField = new JTextField();
        JPasswordField contraseñaField = new JPasswordField();
        Object[] message = {
            "Nombre de usuario:", nombreUsuarioField,
            "Contraseña:", contraseñaField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Cambiar sesión", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String nombreUsuario = nombreUsuarioField.getText();
            String contraseña = new String(contraseñaField.getPassword());

            if (validarUsuario(nombreUsuario, contraseña)) {
                JOptionPane.showMessageDialog(null, "Cambio de sesión exitoso");
                
            } else {
                JOptionPane.showMessageDialog(null, "Nombre de usuario o contraseña incorrectos");
            }
        }
           System.out.println(Usuariosesion.getInstance().getNombre());
           System.out.println(Usuariosesion.getInstance().getRol());
        
    }


      public boolean validarUsuario(String nombreUsuario, String contraseña) {
    Conexion conex = new Conexion();
    String consulta = "SELECT Nombreusuario, Rol, Nombre,idUsuario FROM Usuario WHERE Nombreusuario = ? AND Contraseña = ?";
    try (
            PreparedStatement pst = conex.getConnection().prepareStatement(consulta)) {
        pst.setString(1, nombreUsuario);
        pst.setString(2, contraseña);
        
        var rs = pst.executeQuery();
        if (rs.next()) {
            String nombre = rs.getString("Nombreusuario");
            String rol = rs.getString("Rol");
            String nombreal = rs.getString("Nombre");
            int idsuario =rs.getInt("idUsuario");
            Usuariosesion.getInstance().setUsuario(nombre, rol,nombreal,idsuario); // Guardar información del usuario en la sesión
            // Actualizar la interfaz según el rol
            ajustarInterfazSegunRol(rol);
            Ventas.getInstance().ajustarInterfazSegunRol(rol); // Usar la instancia única
            Ventas.getInstance().ajustarnombre(nombreal);
            // Revalidate y repaint para asegurar que la interfaz se actualice
            revalidate();
            repaint();

            return true;
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al validar usuario: " + e.toString());
    }
    return false;
}

   public void ajustarInterfazSegunRol(String rol) {
        if (clientesPanel != null) {
            clientesPanel.ajustarInterfazSegunRol(rol);
            ajusterol(rol);
        }

        if (ventaspanel != null) {
            ventaspanel.ajustarInterfazSegunRol(rol);
            ajusterol(rol);
        }
    }

    
   public void ajusterol(String rol){
       if ("Estandar".equals(rol)){
            
           BtnProductos.setEnabled(false);
           Btnusuarios.setEnabled(false);
           btnvtasdia.setEnabled(false);
       
       } else {
           BtnProductos.setEnabled(true);
           Btnusuarios.setEnabled(true);
           btnvtasdia.setEnabled(true);
       }
   }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnClientes;
    private javax.swing.JButton BtnProductos;
    private javax.swing.JButton BtnVenta;
    private javax.swing.JButton Btnusuarios;
    private javax.swing.JButton Contraer;
    private javax.swing.JButton Estadísticas;
    private javax.swing.JTextField Jtxtbusquedaproductos;
    private javax.swing.JPanel Menuabajo;
    private javax.swing.JPanel PanelPadre;
    private javax.swing.JPanel Panelacambiar;
    private javax.swing.JButton btnvtasdia;
    private javax.swing.JButton btnvtasdia1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
