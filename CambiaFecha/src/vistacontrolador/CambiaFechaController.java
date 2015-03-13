/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistacontrolador;

import modelo.Tiempo;

/**
 *
 * @author garciparedes
 */
public class CambiaFechaController implements Runnable {
    
    private Tiempo mTiempoVisible, mTiempoGuardado;
    private CambiaFechaUI mCambiaFechaUI;
    Thread hilo;
    
    public CambiaFechaController(CambiaFechaUI cambiaVistaUI, 
            Tiempo tiempo){
        
        hilo = new Thread(this);
        hilo.start();
        
        this.mCambiaFechaUI = cambiaVistaUI;
        this.mTiempoVisible = tiempo;
        this.mTiempoGuardado = tiempo.duplicar();
    }
    
    public void changeTime(){
        
    }

    public void exit() {
        System.exit(0);
    }
    
    public void actualizaMes(){
        try{
            mTiempoVisible.setMonth(
                    mCambiaFechaUI.getJComboBoxMonth()
            );
            mCambiaFechaUI.updateComboBoxDayModel(mTiempoVisible);
        } catch (NumberFormatException e){}
    }
    
    public void actualizaAño(){
        try{
            mTiempoVisible.setYear(
                    Integer.valueOf(mCambiaFechaUI.getJTextFieldYear())
            );
            mCambiaFechaUI.updateComboBoxDayModel(mTiempoVisible);
        } catch (NumberFormatException e){}
    }
    
    public void  refreshTime(){
        mCambiaFechaUI.setJTextFieldHour(mTiempoVisible.getHour());
        mCambiaFechaUI.setJTextFieldMin(mTiempoVisible.getMinute());
        mCambiaFechaUI.setJTextFieldSec(mTiempoVisible.getSecond());
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
