/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.persistencia.dto;

import com.personalsoft.ges_sol_construccion.estandar.clases.MensajeEstandar;
import java.util.List;
import com.personalsoft.ges_sol_construccion.estandar.interfaz.IMensajeEstandar;


/**
 * Clase estandar para las respuesta a los llamados de los controller
 * 
 * @author roagudelo
 */
public class RespuestaDTO<T> {
    
    public int codigo;
    public String mensaje;
    public T datos;

    public RespuestaDTO() {
        this(MensajeEstandar.OK);
    }

    public RespuestaDTO(MensajeEstandar mensaje) {
        setRespuesta(mensaje);
    }
    
    public RespuestaDTO(int codigo, String mensaje) {
       this.codigo = codigo ;
       this.mensaje = mensaje ;
    }
    
    private void setRespuesta(MensajeEstandar mensaje){
      this.codigo = mensaje.getCodigo();
      this.mensaje = mensaje.getMensaje();
    }    
    
    public int getCodigo() {
        return codigo;
    }
    
    public RespuestaDTO <T> setCodigo(int codigo) {
       this.codigo = codigo ;
       return this ;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    public RespuestaDTO <T> setMensaje(String mensaje) {
       this.mensaje = mensaje;
       return this ;
    }

    public T getDatos() {
        return datos;
    }

    public RespuestaDTO <T> setDatos(T datos) {   
        this.datos = datos;
        if (datos instanceof List){
            validarDatos((List) datos);
        }
        return this ;
    }
    
    private void validarDatos(List datos)
    {
        if(datos== null || datos.isEmpty()){
            setRespuesta(MensajeEstandar.NO_RESULTADOS);
            this.datos = null ;
        }  
    }  
}
