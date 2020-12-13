/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javafx.util.converter.LocalDateStringConverter;

/**
 *
 * @author Guillermo
 */
public class prueba {
   public static void main(String[] args) throws ParseException {
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
      LocalDateTime fecha; 
      fecha = LocalDateTime.now();
      System.out.println(dtf.format(fecha));
       
//      LocalDateTime now = LocalDateTime.now();  
//      String temp = dtf.format(now);
//      System.out.println(temp);
   }
}
