/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.estandar.clases;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 * Clase para tener funcionaldiades genericas que no hacen parte de la logica de negocio
 * @author roagudelo
 */
public class Utilidades {
    
        /**
     * metodo sumarDiasAFecha que se encarga de sumar fechas
     * @param fecha fecha inicial
     * @param dias dias a sumar
     * @return Date con la fecha final
     */
    public static Date sumarDiasAFecha(Date fecha, int dias){
      if (dias==0) return fecha;
      Calendar calendar = Calendar.getInstance();
      calendar.setTime(fecha); 
      calendar.add(Calendar.DAY_OF_YEAR, dias);  
      return calendar.getTime(); 
    }
    
    /**
     * metodo que transforma la fecha para que no quede con horas minutos y segundo 
     * @param fecha inicial a convertir
     * @return Date con la fecha final
     * @throws ParseException para pasar el manejo del error al llamado 
     */
    public static Date convertirFecha(Date fecha) 
            throws ParseException
    {    
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int month = localDate.getMonthValue();
        int day   = localDate.getDayOfMonth();
        String fechaString = year + "-" + month + "-" + day ;        
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
        Date fechaDate = null;
        fechaDate = formato.parse(fechaString);  
        return fechaDate;

    }
    
}
