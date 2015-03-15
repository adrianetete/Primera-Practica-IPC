/**
 * 
 * @author Sergio Garcia Prado
 * @author Adrian Calvo Rojo
 * 
 */
package vistacontrolador;

import modelo.Tiempo;

public class CambiaFechaController implements Runnable {
    
    private Tiempo mTiempoVisible, mTiempoGuardado;
    private CambiaFechaUI mCambiaFechaUI;
    private boolean modificando;
    Thread hilo;
    
    public CambiaFechaController(CambiaFechaUI cambiaVistaUI, 
            Tiempo tiempo){
        
        hilo = new Thread(this);
        hilo.start();
        
        this.mCambiaFechaUI = cambiaVistaUI;
        this.mTiempoVisible = tiempo;
        this.mTiempoGuardado = tiempo.duplicar();
    }
    
    /**
     * Cambia el tiempo del sistema, por el que ha proporcionado el usuario.
     */
    public void changeTime(){
        
        this.modificando = false;
        mTiempoGuardado = mTiempoVisible.duplicar();
        onSavedDateChanged();
    }

    /**
     * Termina el porgama.
     */
    public void exit() {
        
        System.exit(0);
    }
    /**
     * Hace saber al metodo que refresca la hora que se está modificando 
     * cualquiera de los campos: hora, minutos o segundos.
     * 
     * @param modi 
     */
    public void setModificando(boolean modi){
        
        this.modificando = modi;
            }
    
    public void onHourModified(){
        mTiempoVisible.setHour(
                Integer.valueOf(mCambiaFechaUI.getJComboBoxHour())
        );
        setModificando(false);

    }
    
    public void onMinModified(){
       mTiempoVisible.setMin(
                Integer.valueOf(mCambiaFechaUI.getJComboBoxMin())
        );
        setModificando(false);
    }
    
    public void onSecModified(){
        mTiempoVisible.setSec(
                Integer.valueOf(mCambiaFechaUI.getJComboBoxSec())
        );
        setModificando(false);
    }
    
    /**
     * 
     */
    public void onMonthModified(){
        
        mTiempoVisible.setMonth(
                mCambiaFechaUI.getJComboBoxMonth()
        );
        mCambiaFechaUI.updateComboBoxDayModel(mTiempoVisible);
        mCambiaFechaUI.setJComboBoxDay(mTiempoVisible.getDayOverZero());
    }
    
    /**
     * 
     */
    public void onYearModified(){
        
        mTiempoVisible.setYear(
                Integer.valueOf(mCambiaFechaUI.getJTextFieldYear())
        );
        mCambiaFechaUI.updateComboBoxDayModel(mTiempoVisible);
        mCambiaFechaUI.setJComboBoxDay(mTiempoVisible.getDayOverZero());
    }
    
    /**
     * 
     */
    public void  refreshTime(){
        
        if(!modificando){
            
            mTiempoVisible.update();
            mCambiaFechaUI.setJTextFieldHour(mTiempoVisible.getHourString());
            mCambiaFechaUI.setJTextFieldMin(mTiempoVisible.getMinuteString());
            mCambiaFechaUI.setJTextFieldSec(mTiempoVisible.getSecondString());

        }
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

    public void onDayModified() {
        
        /* Tenemos que sumar 1 para que el día sea correcto
         * ya que el ComboBox empieza a contar en 0
         * mientras que GregorianCalendar en 1. */
        mTiempoVisible.setDay(
                mCambiaFechaUI.getJComboBoxDay()+1
        );
    }

    private void onSavedDateChanged() {
        mCambiaFechaUI.showTimeOnLabel(mTiempoGuardado);
    }
}
