package com.personalsoft.ges_sol_construccion.estandar.clases;



import com.personalsoft.ges_sol_construccion.estandar.interfaz.IMensajeEstandar;

/**
 * Clase para crear el error producto de la ejecucion de la aplicacion
 * @author roagudelo
 */

public class MyExcepcion extends AplicacionExcepcion {

    public MyExcepcion(IMensajeEstandar mensaje) {
        super(mensaje);
    }

    public MyExcepcion(IMensajeEstandar mensaje, Object datos) {
        super(mensaje, datos);
    }

    public MyExcepcion(IMensajeEstandar eMensaje, String complemento) {
        super(eMensaje);
        mensaje = eMensaje.getMensaje().replaceAll("__COMPLEMENTO__", complemento);
    }

}
