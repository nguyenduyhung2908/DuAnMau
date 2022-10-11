/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Nguyen Duy Hung
 */
public class Validator{

    public String getString(String text) {
        if(text.isBlank())
            return null;
        return text;
    }

    public Date getDate(java.util.Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return Date.valueOf(sdf.format(date));
    }
    
    public int getInt(String text){
        try{
            int result = Integer.parseInt(text);
            return result;
        }catch(NumberFormatException e){
            System.out.println("Loi getInt()");
            return -1;
        }
    }
    public BigDecimal getBigDecimal(String text){
        try{
            BigDecimal bigDecimal = BigDecimal.valueOf(Double.valueOf(text));
            return bigDecimal;
        }catch(NumberFormatException e){
            return null;
        }
    }
}
