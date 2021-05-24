/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.estandar.clases;

import com.personalsoft.ges_sol_construccion.estandar.interfaz.IMensajeEstandar;

/**
 * Clase de error producto de la ejecucion de la aplicacion
 * @author roagudelo
 */


@SuppressWarnings("OverridableMethodCallInConstructor")
public class AplicacionExcepcion extends Exception
{

  /**
   * Código de respuesta que se devolvera en la solicitud
   */
  protected int codigo;

  /**
   * Descripción del error
   */
  protected String mensaje;

  /**
   * Información adicional del error
   */
  protected Object datos;

  /**
   * Constructor de la clase
   *
   * @param mensaje Constante del error que está orriendo
   */
  public AplicacionExcepcion(IMensajeEstandar mensaje)
  {
    super(mensaje.getMensaje());
    this.codigo = mensaje.getCodigo();
    this.mensaje = mensaje.getMensaje();
  }

  public AplicacionExcepcion(IMensajeEstandar mensaje, Object datos)
  {
    super(mensaje.getMensaje());
    this.codigo = mensaje.getCodigo();
    this.mensaje = mensaje.getMensaje();
    this.datos = datos;
  }

  public AplicacionExcepcion(int codigo, String mensaje)
  {
    super(mensaje);
    this.codigo = codigo;
    this.mensaje = mensaje;
  }

  public AplicacionExcepcion(IMensajeEstandar eMensaje, String complemento)
  {
    super(eMensaje.getMensaje().replaceAll("__COMPLEMENTO__", complemento));
    this.codigo = eMensaje.getCodigo();
    this.mensaje = getMessage();

  }

  public int getCodigo()
  {
    return codigo;
  }

  public AplicacionExcepcion setCodigo(int codigo)
  {
    this.codigo = codigo;
    return this;
  }

  public String getMensaje()
  {
    return mensaje;
  }

  public AplicacionExcepcion setMensaje(String mensaje)
  {
    this.mensaje = mensaje;
    return this;
  }

  public Object getDatos()
  {
    return datos;
  }

  public AplicacionExcepcion setDatos(Object datos)
  {
    this.datos = datos;
    return this;
  }

}



