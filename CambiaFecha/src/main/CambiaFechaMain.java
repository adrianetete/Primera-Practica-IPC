/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import vistacontrolador.CambiaFechaUI;

/**
 *
 * @author garciparedes
 */
public class CambiaFechaMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
                 // Set System L&F
                 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
             } 
             catch (UnsupportedLookAndFeelException e) {
                // handle exception
             }
             catch (ClassNotFoundException e) {
                // handle exception
             }
             catch (InstantiationException e) {
                // handle exception
             }
             catch (IllegalAccessException e) {
                // handle exception
             }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CambiaFechaUI().setVisible(true);
            }
        });
    }
    
}
