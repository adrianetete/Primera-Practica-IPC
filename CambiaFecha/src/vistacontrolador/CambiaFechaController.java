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
public class CambiaFechaController {
    
    private InfoDelSys mInfoDelSys;
    private CambiaFechaUI mCambiaFechaUI;
    
    public CambiaFechaController(CambiaFechaUI cambiaVistaUI, 
            InfoDelSys informacionDelSistema){
        this.mCambiaFechaUI = cambiaVistaUI;
        this.mInfoDelSys = informacionDelSistema;
    }
    
    public void changeTime(){
        
    }

    public void exit() {
        System.exit(0);
    }
}
