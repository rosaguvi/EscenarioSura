/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.controlador;

import com.personalsoft.ges_sol_construccion.estandar.clases.AplicacionExcepcion;
import com.personalsoft.ges_sol_construccion.estandar.clases.MensajeEstandar;
import com.personalsoft.ges_sol_construccion.persistencia.dto.RespuestaDTO;
import com.personalsoft.ges_sol_construccion.persistencia.dto.SolConstruccionDto;
import com.personalsoft.ges_sol_construccion.servicio.OrdConstServicio;
import com.personalsoft.ges_sol_construccion.servicio.SolConstServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * controlador para las solicitudes de construccion 
 * @author roagudelo
 */
@RestController
public class SolConstruccionControlador {
    /**
    * Clase que se encarga de tener la lógica de negocio
    */
    @Autowired
    private SolConstServicio servicio;
    @Autowired
    private OrdConstServicio servicioOrd;

    /**
     * Método encargado de controlar la consulta de solicitudes
     *
     * @return Respuesta Genérica si es correcta o incorrecta y con el listado de solicitudes consultadas
     * 
     */
    @PostMapping("/sol_construccion/consultar")
    public RespuestaDTO consultar()
    {
         try {
            return new RespuestaDTO().setDatos(servicio.findAll());
        } catch (AplicacionExcepcion ex) {
            System.err.println("Error en la ejecucion de la aplicacion:" + ex.getMensaje());
            return new RespuestaDTO(ex.getCodigo(),ex.getMensaje()).setDatos(null);
        }  
    }
    /**
     * Metodo para consultar las ordenes de trabajo
     * @return Respuesta Genérica si es correcta o incorrecta y con el listado de ordenes consultadas
     * 
     */
    
    @PostMapping("/org_construccion/consultar")
    public RespuestaDTO consultarOrd()
    {
         try {
            return new RespuestaDTO().setDatos(servicioOrd.findAll());
        } catch (AplicacionExcepcion ex) {
            System.err.println("Error en la ejecucion de la aplicacion:" + ex.getMensaje());
            return new RespuestaDTO(ex.getCodigo(),ex.getMensaje()).setDatos(null);
        }  
    }
    
    /**
     * metodo para crear las solicitudes de construccion
     * @param solConDto solicitud a guardar
     * @return SolConstruccionDto
     */
    @PostMapping("/sol_construccion/guardar")
    public RespuestaDTO guardar(@RequestBody SolConstruccionDto solConDto)
    {
        try {
            solConDto = servicio.create(solConDto) ;
            return new RespuestaDTO(MensajeEstandar.Ok_ORDTRABAJO).setDatos(servicioOrd.create(solConDto));
        } catch (AplicacionExcepcion ex) {
            System.err.println("Error en la ejecucion de la aplicacion:" + ex.getMensaje());
            return new RespuestaDTO(ex.getCodigo(),ex.getMensaje()).setDatos(solConDto);
        }
    }
    
    /**
     * metodo para consultar la fecha de finalizacion de la ciudadela
     * @return Respuesta Genérica si es correcta o incorrecta 
     */
    @PostMapping("/sol_construccion/finalizacion")
    public RespuestaDTO consultarFinalizacion()
    {
        try {
            return new RespuestaDTO().setDatos(servicioOrd.consultarFecFinConstr());
        } catch (AplicacionExcepcion ex) {
            System.err.println("Error en la ejecucion de la aplicacion:" + ex.getMensaje());
            return new RespuestaDTO(ex.getCodigo(),ex.getMensaje()).setDatos(null);
        }
    }
    
    /**
     * Método encargado de generar el resporte de construcciones Pendientes
     *
     * @return Respuesta Genérica si es correcta o incorrecta y con el listado de las ordenes de construccion pendientes
     * 
     */
    @PostMapping("/ord_construccion/pendientes")
    public RespuestaDTO consultarPendientes()
    {
         try {
            return new RespuestaDTO().setDatos(servicioOrd.findAllEstado("Pendiente"));
        } catch (AplicacionExcepcion ex) {
            System.err.println("Error en la ejecucion de la aplicacion:" + ex.getMensaje());
            return new RespuestaDTO(ex.getCodigo(),ex.getMensaje()).setDatos(null);
        }  
    }
    /**
     * Método encargado de generar el resporte de construcciones Ejecutadas
     *
     * @return Respuesta Genérica si es correcta o incorrecta y con el listado de las ordenes de construccion pendientes
     * 
     */
    @PostMapping("/ord_construccion/finalizadas")
    public RespuestaDTO consultarFinalizadas()
    {
         try {
            return new RespuestaDTO().setDatos(servicioOrd.findAllEstado("Ejecutada"));
        } catch (AplicacionExcepcion ex) {
            System.err.println("Error en la ejecucion de la aplicacion:" + ex.getMensaje());
            return new RespuestaDTO(ex.getCodigo(),ex.getMensaje()).setDatos(null);
        }  
    }
    /**
     * Método encargado de generar el resporte de construcciones En Proceso
     *
     * @return Respuesta Genérica si es correcta o incorrecta y con el listado de las ordenes de construccion pendientes
     * 
     */
    @PostMapping("/ord_construccion/proceso")
    public RespuestaDTO consultarProceso()
    {
         try {
            return new RespuestaDTO().setDatos(servicioOrd.findAllEstado("En Proceso"));
        } catch (AplicacionExcepcion ex) {
            System.err.println("Error en la ejecucion de la aplicacion:" + ex.getMensaje());
            return new RespuestaDTO(ex.getCodigo(),ex.getMensaje()).setDatos(null);
        }  
    }
}
   
