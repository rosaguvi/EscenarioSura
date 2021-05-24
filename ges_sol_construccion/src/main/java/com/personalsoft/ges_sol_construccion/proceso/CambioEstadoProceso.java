package com.personalsoft.ges_sol_construccion.proceso;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.personalsoft.ges_sol_construccion.dao.OrdConstruccionDao;
import com.personalsoft.ges_sol_construccion.estandar.clases.AplicacionExcepcion;
import com.personalsoft.ges_sol_construccion.estandar.clases.Utilidades;
import com.personalsoft.ges_sol_construccion.persistencia.dto.OrdConstruccionDto;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * clase encargada de los procesos automaticos
 * @author roagudelo
 */
@Component
public class CambioEstadoProceso extends Utilidades 
{

   @Autowired
    private OrdConstruccionDao dao ;
  /**
   * Metodo que se encarga de ejecutarse de acuerdo a la expresi�n del cron el que cambia estado a Ejecutando
   */
  @Scheduled(cron = "00 30 02 * * *")// todos los dias a las 6 de lamañana
  public void procesar()
  {
    try {
        System.out.print("Se inicia proceso que Actualiza las Ordenenes de trabajo a en Proceso");
        procesarOrdenes();
        System.out.print("Se Finaliza proceso que Actualiza las Ordenenes de trabajo a en Proceso..");
    } catch (Exception ex) {
        System.err.print("Error en algun momento del proceso.." + ex.getMessage());
    } 
  }
  /**
   * Metodo que ejecuta el proceso de terminar construccion 
   */  
  @Scheduled(cron = "00 32 02 * * *")// todos los dias a las 6 de la tarde
  public void ejecutada()
  {
    try {
        System.out.print("Se inicia proceso que Actualiza las Ordenenes de trabajo a Ejecutada");
        FinalizarOrdenes();
        System.out.print("Se Finaliza proceso que Actualiza las Ordenenes de trabajo a Ejecutad..");
    } catch (Exception ex) {
        System.err.print("Error en algun momento del proceso.." + ex.getMessage());
    } 
  }

  /**
   * Metodo procesarOrdenes que consulta las ordenes que inician en el dia y les actualiza el estado a En Proceso
   * @throws AplicacionExcepcion  para trasladar el manejo del error al llamado
   */
    public void procesarOrdenes() 
        throws AplicacionExcepcion 
    {
       try {
           Date fecha = new Date();
           List<OrdConstruccionDto> ordProcesar = dao.traerInicianFecha(convertirFecha(fecha));
           for (OrdConstruccionDto dto: ordProcesar ){
               dto.setEstConstruccion("En Proceso");
               dao.save(dto);
           }
       } catch (ParseException ex) {
           System.err.println("Error al ejecuta Proceso Automatico..." + ex.getMessage() );
       }

    }

  /**
   * Metodo procesarOrdenes que consulta las ordenes que inician en el dia y les actualiza el estado a En Proceso
   * @throws AplicacionExcepcion para trasladar el manejo del error al llamado
   */
    public void FinalizarOrdenes() 
            throws AplicacionExcepcion 
    {
       try {
           Date fecha = new Date();
           List<OrdConstruccionDto> ordProcesar = dao.traerFinalizaFecha(convertirFecha(fecha));
           for (OrdConstruccionDto dto: ordProcesar ){
               System.out.println("Ingreso al proceso una vez " );
               dto.setEstConstruccion("Ejecutada");
               dao.save(dto);
           }
       } catch (ParseException ex) {
           System.err.println("Error al ejecuta Proceso Automatico..." + ex.getMessage() );
       }

    }

}
