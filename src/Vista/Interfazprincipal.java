
package Vista;

import Contorlador.Conexion;
import Modelo.Usuariosesion;
import java.awt.CardLayout;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import rojerusan.RSAnimation;
import Vista.Corte;
import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyAdapter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Interfazprincipal extends javax.swing.JFrame {
    
    private static Interfazprincipal instance;
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
    
    public static Interfazprincipal getInstance() {
        if (instance == null) {
            instance = new Interfazprincipal();
        }
        return instance;
    }
    
    
    public Interfazprincipal() {
     
        initComponents();
        inicializarCardLayout();
        agregarKeyListenerGlobal();
        ajustarInterfazSegunRol(Usuariosesion.getInstance().getRol());
        
        
        Jtxtbusquedaproductos.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                ventaspanel.getInstance().cargarProductos(Jtxtbusquedaproductos.getText());
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
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menuabajo = new javax.swing.JPanel();
        BtnEstadísticas = new javax.swing.JButton();
        Btnusuarios = new javax.swing.JButton();
        btnvtasdia = new javax.swing.JButton();
        BtnProductos = new javax.swing.JButton();
        BtnCerrarsesion = new javax.swing.JButton();
        PanelPadre = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtnVenta = new javax.swing.JButton();
        BtnClientes = new javax.swing.JButton();
        Contraer = new javax.swing.JButton();
        Jtxtbusquedaproductos = new javax.swing.JTextField();
        Panelacambiar = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Copymax 1.0");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menuabajo.setBackground(new java.awt.Color(204, 204, 255));
        Menuabajo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        BtnEstadísticas.setBackground(new java.awt.Color(204, 255, 255));
        BtnEstadísticas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnEstadísticas.setForeground(new java.awt.Color(0, 0, 0));
        BtnEstadísticas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/entrega-de-pedidos (Custom).png"))); // NOI18N
        BtnEstadísticas.setText("Estadísticas");
        BtnEstadísticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEstadísticasActionPerformed(evt);
            }
        });

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

        BtnCerrarsesion.setBackground(new java.awt.Color(255, 102, 102));
        BtnCerrarsesion.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnCerrarsesion.setForeground(new java.awt.Color(0, 0, 0));
        BtnCerrarsesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/salida.png"))); // NOI18N
        BtnCerrarsesion.setText("Cerrar Sesión");
        BtnCerrarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarsesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuabajoLayout = new javax.swing.GroupLayout(Menuabajo);
        Menuabajo.setLayout(MenuabajoLayout);
        MenuabajoLayout.setHorizontalGroup(
            MenuabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuabajoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenuabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnvtasdia, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(BtnEstadísticas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Btnusuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnCerrarsesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        MenuabajoLayout.setVerticalGroup(
            MenuabajoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuabajoLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(Btnusuarios)
                .addGap(18, 18, 18)
                .addComponent(BtnProductos)
                .addGap(18, 18, 18)
                .addComponent(BtnEstadísticas, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnvtasdia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnCerrarsesion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        getContentPane().add(Menuabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -300, -1, 300));

        PanelPadre.setBackground(new java.awt.Color(54, 170, 219));
        PanelPadre.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 102)));
        PanelPadre.setPreferredSize(new java.awt.Dimension(600, 100));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logopng (Custom) (1).png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        BtnVenta.setBackground(new java.awt.Color(204, 255, 255));
        BtnVenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BtnVenta.setForeground(new java.awt.Color(0, 0, 0));
        BtnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ventas (Custom).png"))); // NOI18N
        BtnVenta.setText("Venta");
        BtnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVentaActionPerformed(evt);
            }
        });

        BtnClientes.setBackground(new java.awt.Color(204, 255, 255));
        BtnClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
        Jtxtbusquedaproductos.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
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
                .addGap(8, 8, 8)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contraer)
                .addGap(18, 18, 18)
                .addComponent(BtnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(BtnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(Jtxtbusquedaproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelPadreLayout.setVerticalGroup(
            PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPadreLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPadreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BtnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Jtxtbusquedaproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Contraer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(PanelPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 60));

        Panelacambiar.setBackground(new java.awt.Color(0, 0, 0));
        Panelacambiar.setName(""); // NOI18N
        Panelacambiar.setOpaque(false);
        Panelacambiar.setPreferredSize(new java.awt.Dimension(600, 520));

        javax.swing.GroupLayout PanelacambiarLayout = new javax.swing.GroupLayout(Panelacambiar);
        Panelacambiar.setLayout(PanelacambiarLayout);
        PanelacambiarLayout.setHorizontalGroup(
            PanelacambiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        PanelacambiarLayout.setVerticalGroup(
            PanelacambiarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(Panelacambiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 800, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVentaActionPerformed
        
       mostrarventa();
    }//GEN-LAST:event_BtnVentaActionPerformed
    
    public void mostrarventa(){
        cardLayout.show(Panelacambiar, "Ventas");
    }
    
    private void BtnEstadísticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEstadísticasActionPerformed
               
        cardLayout.show(Panelacambiar,"Pedido");
    }//GEN-LAST:event_BtnEstadísticasActionPerformed
        public void mostrarestadistica(){
        cardLayout.show(Panelacambiar, "Pedido");
    }
    private void BtnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClientesActionPerformed
        cardLayout.show(Panelacambiar,"Clientes");
    }//GEN-LAST:event_BtnClientesActionPerformed

     public void mostrarclientes(){
        cardLayout.show(Panelacambiar, "Clientes");
    }
    
    private void ContraerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraerActionPerformed
        
        int posicion= this.Menuabajo.getY();
        System.out.println(posicion);
        if (posicion < -1){
            
            RSAnimation.setBajar(-360, 60, 1, 2,Menuabajo);              
        }else {
            RSAnimation.setSubir(60,-360, 1, 2,Menuabajo);
        }
    }//GEN-LAST:event_ContraerActionPerformed

    private void BtnusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnusuariosActionPerformed
         mostrarusuarios();
       
    }//GEN-LAST:event_BtnusuariosActionPerformed

    public void mostrarusuarios(){
         cardLayout.show(Panelacambiar,"Usuario");
    }
    
    private void BtnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProductosActionPerformed
         mostrarproductos();
    }//GEN-LAST:event_BtnProductosActionPerformed

    public void mostrarproductos(){
         cardLayout.show(Panelacambiar,"Productos");
    }
    
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

    private void BtnCerrarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarsesionActionPerformed
        LoginRegistro login = new LoginRegistro();
        login.setVisible(true);
        Usuariosesion.getInstance().cerrarSesion();
        dispose();
    }//GEN-LAST:event_BtnCerrarsesionActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        MVC mvc = new MVC();
        mvc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked
    
  
      
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
           BtnEstadísticas.setEnabled(false);
           
       
       } else {
           BtnProductos.setEnabled(true);
           Btnusuarios.setEnabled(true);
           btnvtasdia.setEnabled(true);
           BtnEstadísticas.setEnabled(true);
       }
   }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrarsesion;
    private javax.swing.JButton BtnClientes;
    private javax.swing.JButton BtnEstadísticas;
    private javax.swing.JButton BtnProductos;
    private javax.swing.JButton BtnVenta;
    private javax.swing.JButton Btnusuarios;
    private javax.swing.JButton Contraer;
    private javax.swing.JTextField Jtxtbusquedaproductos;
    private javax.swing.JPanel Menuabajo;
    private javax.swing.JPanel PanelPadre;
    private javax.swing.JPanel Panelacambiar;
    private javax.swing.JButton btnvtasdia;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
