package vistacontrolador;

import modelo.Tiempo;

/**
 *
 * @author garciparedes
 * 
 */
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
    
    public void changeTime(){
        
        this.modificando = false;
        mTiempoGuardado = mTiempoVisible.duplicar();
        onSavedDateChanged();
    }

    public void exit() {
        
        System.exit(0);
    }
    public void setModificando(boolean modi){
        
        this.modificando = modi;
    }
    
    public void onMonthModified(){
        
        mTiempoVisible.setMonth(
                mCambiaFechaUI.getJComboBoxMonth()
        );
        mCambiaFechaUI.updateComboBoxDayModel(mTiempoVisible);
        mCambiaFechaUI.setJComboBoxDay(mTiempoVisible.getDayOverZero());
    }
    
    public void onYearModified(){
        
        mTiempoVisible.setYear(
                Integer.valueOf(mCambiaFechaUI.getJTextFieldYear())
        );
        mCambiaFechaUI.updateComboBoxDayModel(mTiempoVisible);
        mCambiaFechaUI.setJComboBoxDay(mTiempoVisible.getDayOverZero());
    }
    
    public void  refreshTime(){
        
        mTiempoVisible.update();
        if(!modificando){
            
            mCambiaFechaUI.setJTextFieldHour(mTiempoVisible.getHour());
            mCambiaFechaUI.setJTextFieldMin(mTiempoVisible.getMinute());
            mCambiaFechaUI.setJTextFieldSec(mTiempoVisible.getSecond());
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
        // Tenemos que sumar 1 para que el día sea correcto
        // ya que el ComboBox empieza a contar en 0
        // mientras que GregorianCalendar en 1.
        mTiempoVisible.setDay(
                mCambiaFechaUI.getJComboBoxDay()+1
        );
    }

    private void onSavedDateChanged() {
        mCambiaFechaUI.showTimeOnLabel(mTiempoGuardado);
    }
}
