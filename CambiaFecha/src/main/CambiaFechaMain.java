/**
 * 
 * @author Sergio Garcia Prado
 * @author Adrian Calvo Rojo
 * 
 */
package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vistacontrolador.CambiaFechaUI;

public class CambiaFechaMain {

    /**
     * Metodo principal.
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             } 
             catch (UnsupportedLookAndFeelException e) {
                
                System.err.println("Aspecto de ventana no soportado.");
             }
             catch (ClassNotFoundException e) {
                System.err.println("Error en el Look & Feel:");
                e.printStackTrace();
             }
             catch (InstantiationException e) {
                System.err.println("Error en el Look & Feel:");
                e.printStackTrace();
             }
             catch (IllegalAccessException e) {
               System.err.println("Error en el Look & Feel:");
                e.printStackTrace();
             }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambiaFechaUI().setVisible(true);
            }
        });
    }
    
}
