/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package copymax;

import Conexion.Conexion;
import Interfazes.LoginRegistro;

/**
 *
 * @author maxst
 */
public class main {

    static Conexion cone;
    
  
    public static void main(String[] args) {
         
      cone = new Conexion();
       
            //  LoginRegistro log = new LoginRegistro();
        
      //  log.setVisible(true);
      
    }
    
      public static Conexion getCone() {
        return cone;
    }
    
}
