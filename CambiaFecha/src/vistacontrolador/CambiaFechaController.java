/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistacontrolador;

import modelo.InfoDelSys;

/**
 *
 * @author garciparedes
 */
public class CambiaFechaController implements Runnable {
    
    private InfoDelSys mInfoDelSys;
    private CambiaFechaUI mCambiaFechaUI;
    Thread hilo;
    
    public CambiaFechaController(CambiaFechaUI cambiaVistaUI, 
            InfoDelSys informacionDelSistema){
         hilo = new Thread(this);
        hilo.start();
        
        this.mCambiaFechaUI = cambiaVistaUI;
        this.mInfoDelSys = informacionDelSistema;
    }
    
    public void changeTime(){
        
    }

    public void exit() {
        System.exit(0);
    }
    
    public void  refreshTime(){
        mCambiaFechaUI.setJTextFieldHour(mInfoDelSys.getHour());
        mCambiaFechaUI.setJTextFieldMin(mInfoDelSys.getMinute());
        mCambiaFechaUI.setJTextFieldSec(mInfoDelSys.getSecond());
    }

    @Override
    public void run() {
        
        while(true){
            try {
                 refreshTime();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
               ex.printStackTrace();
            }
        }
    }
}
