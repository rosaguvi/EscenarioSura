/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.estandar.clases;

import com.personalsoft.ges_sol_construccion.estandar.interfaz.IMensajeEstandar;


/**
 *
 * @author roagudelo
 */
public enum MensajeEstandar implements IMensajeEstandar
{
    OK(1, "Petición ejecutada correctamente"),
    Ok_ORDTRABAJO(2, "Se crea la Solicitud y la Orden de Construccion"),
    NO_RESULTADOS(0, "No se encontraron resultados"),
    ERROR(-1, "Error al procesar la petición"),
    ERROR_SESION_EXPIRADO(-2, "La sesión ha expirado"),
    ERROR_DATOS_CONSULTAR_ENTIDAD(-3, "Error no hay datos para consultar la entidad  __COMPLEMENTO__"),
    ERROR_SIN_DATOS_CONSULTAR_ENTIDAD(-4, "Error no hay registros para los datos enviados de la entidad __COMPLEMENTO__"),
    ERROR_MATERIAL_NO_SUFICIENTE(-5, "Error no hay Cantidad suficientre del material:  __COMPLEMENTO__"),
    ERROR_UBICACION_NO_DISPONIBLE(-6, "Error ya hay una solicitud de construccion para la ubicacion"),
    ERROR_Fechas(-7, "Error al convertir las fechas __COMPLEMENTO__ ");
    
    /**
     * Código del error
     */
    private final int codigo;
    
    /**
     * Mensaje del evento
     */
    private final String mensaje;

    private MensajeEstandar(int codigo, String mensaje)
    {
      this.codigo = codigo;
      this.mensaje = mensaje;
    }

    @Override
    public String getMensaje()
    {
      return mensaje;
    }
    
    @Override
    public int getCodigo()
    {
      return codigo;
    }
 
}

    

