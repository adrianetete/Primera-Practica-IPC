/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author garciparedes
 */
public class ComboBoxArray {
    
    public static String[] genConsecutiveNumber(int ini, int fin){
        int resultLenght = fin-ini+1;
        AtomicInteger atomic = new AtomicInteger(ini);
        String result[] = new String[resultLenght];
        for (int i = 0; i < resultLenght; i++){
            result[i] = String.valueOf( atomic.getAndIncrement());
        }
        return result;
    }
}
