/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.GregorianCalendar;

/**
 *
 * @author garciparedes
 */
public class InfoDelSys {
    
    private GregorianCalendar mDate;
    
    private static final String FAIL_DAY = "Dia incorrecto";
    private static final String FAIL_MONTH = "Mes incorrecto";
    private static final String FAIL_YEAR = "Año incorrecto";
    private static final String FAIL_HOUR = "Hora incorrecto";
    private static final String FAIL_MIN = "Minutos incorrectos";

    
    public InfoDelSys(){
        mDate = (GregorianCalendar)GregorianCalendar.getInstance();
    }
    
    
    
    /**
    * @return año de la fecha actual del sistema */
    public​​ int getDay() {
        return​ mDate.get(GregorianCalendar.DAY_OF_MONTH); 
    }
    
    /**
    * @return año de la fecha actual del sistema */
    public​​ int getDayOverZero() {
        return​ getDay()-1; 
    }
    
    /**
    * @return año de la fecha actual del sistema */
    public​​ int getMonth() {
        return​ mDate.get(GregorianCalendar.MONTH); 
    }
    
    /**
    * @return año de la fecha actual del sistema */
    public​​ int getYear() {
        return​ mDate.get(GregorianCalendar.YEAR); 
    }
    
    /**
    * @return año de la fecha actual del sistema */
    public​​ String getYearString() {
        return​ Integer.toString(mDate.get(GregorianCalendar.YEAR)); 
    }
    
    
    /**
    * @param year para modificar la fecha actual del sistema,
    * el año debe ser correcto para el Calendario Gregoriano y debe ser * además ser compatible con el día y mes actual. El caso
    * concreto sería si un año es bisiesto y tenemos la fecha 29 del 2, * no podemos cambiar el año a un año no bisiesto
    */
    public​​ void​ setYear(int year) {
    if​( year < mDate.getActualMinimum( GregorianCalendar.YEAR )) 
        throw​​ new​ IllegalArgumentException(FAIL_YEAR);
    
    }
}
