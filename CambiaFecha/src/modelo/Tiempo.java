/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author garciparedes
 */
public class Tiempo {
    
    
    private static final String FAIL_DAY = "Dia incorrecto";
    private static final String FAIL_MONTH = "Mes incorrecto";
    private static final String FAIL_YEAR = "Año incorrecto";
    private static final String FAIL_HOUR = "Hora incorrecto";
    private static final String FAIL_MIN = "Minutos incorrectos";

    private static final String[] monthArray = {
        "Enero",
        "Febrero",
        "Marzo",
        "Abril",
        "Mayo",
        "Junio",
        "Julio",
        "Agosto",
        "Septiembre",
        "Octubre",
        "Noviembre",
        "Diciembre"
    };
    
    public static String[] genMonthArray(){
        return monthArray;
    }
    
    private GregorianCalendar mDate;

    
    public Tiempo(){
        this.mDate = (GregorianCalendar)GregorianCalendar.getInstance();
    }
    
    public Tiempo(GregorianCalendar date){
        this.mDate = date;
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
    
    public int getHour(){
        return mDate.get(GregorianCalendar.HOUR_OF_DAY);
    }
    public int getMinute(){        
        return mDate.get(GregorianCalendar.MINUTE);
    }
    public int getSecond(){
        return mDate.get(GregorianCalendar.SECOND);
    }
    
   
    public void setDay(int day) throws IllegalArgumentException {
        if​( day < mDate.getActualMinimum(GregorianCalendar.DAY_OF_MONTH )) 
            throw​​ new​ IllegalArgumentException(FAIL_DAY + day);
    
        if​( day > mDate.getActualMaximum(GregorianCalendar.DAY_OF_MONTH )) 
            throw​​ new​ IllegalArgumentException(FAIL_DAY + day);
        
        mDate.set(GregorianCalendar.DAY_OF_MONTH, day);
    }

    
    public void setMonth(int month) throws IllegalArgumentException{
        if​( month < mDate.getActualMinimum( GregorianCalendar.MONTH )) 
            throw​​ new​ IllegalArgumentException(FAIL_MONTH + month);
        
        if​( month > mDate.getActualMaximum(GregorianCalendar.MONTH )) 
            throw​​ new​ IllegalArgumentException(FAIL_MONTH + month);
    
        dayRefresh(month, getYear());
        mDate.set(GregorianCalendar.MONTH, month);
    }
    
    
    private void dayRefresh(int month, int year){
        GregorianCalendar gC = new GregorianCalendar(year,month,1);
        int maxDays = gC.getActualMaximum(GregorianCalendar.DAY_OF_MONTH );

        System.out.println(maxDays);
        System.out.println(getDay());
        System.out.println(gC.getActualMaximum(GregorianCalendar.DAY_OF_MONTH ));

        if (getDay() > maxDays){
            setDay(gC.getActualMaximum(GregorianCalendar.DAY_OF_MONTH ));
        }
    }
    
    
    /**
    * @param year para modificar la fecha actual del sistema,
    * el año debe ser correcto para el Calendario Gregoriano y debe ser * además ser compatible con el día y mes actual. El caso
    * concreto sería si un año es bisiesto y tenemos la fecha 29 del 2, * no podemos cambiar el año a un año no bisiesto
    */
    public​​ void​ setYear(int year) throws IllegalArgumentException {
        if​( year < mDate.getActualMinimum( GregorianCalendar.YEAR )) 
            throw​​ new​ IllegalArgumentException(FAIL_YEAR + year);
    
        dayRefresh(getMonth(), year);
        mDate.set(GregorianCalendar.YEAR, year);
    }
    
    public String[] genConsecutiveDayArray(){
        int resultLenght = mDate.getActualMaximum(Calendar.DAY_OF_MONTH);
        AtomicInteger atomic = new AtomicInteger(1);
        String result[] = new String[resultLenght];
        for (int i = 0; i < resultLenght; i++){
            result[i] = String.valueOf( atomic.getAndIncrement());
        }
        return result;
    }
    

    public Tiempo duplicar() {
        return new Tiempo(this.mDate);
    }

    public void update() {
        mDate.setTimeInMillis(mDate.getTimeInMillis()+1000);
    }
}
