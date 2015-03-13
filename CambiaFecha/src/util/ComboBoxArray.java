/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author garciparedes
 */
public class ComboBoxArray {
    
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
    
    private static String[] genConsecutiveNumberArray(int ini, int fin){
        int resultLenght = fin-ini+1;
        AtomicInteger atomic = new AtomicInteger(ini);
        String result[] = new String[resultLenght];
        for (int i = 0; i < resultLenght; i++){
            result[i] = String.valueOf( atomic.getAndIncrement());
        }
        return result;
    }
    
    public static String[] genMonthArray(){
        return monthArray;
    }

    public static String[] genConsecutiveDayArray(int month, int year){
        Calendar  gC = new GregorianCalendar(year, month, 1);
        return genConsecutiveNumberArray(1, gC.getActualMaximum(Calendar.DAY_OF_MONTH));
    }
    
}
