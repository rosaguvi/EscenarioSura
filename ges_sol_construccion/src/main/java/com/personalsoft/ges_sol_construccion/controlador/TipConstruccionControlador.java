/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.controlador;

import com.personalsoft.ges_sol_construccion.persistencia.dto.RespuestaDTO;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.TipConstruccion;
import com.personalsoft.ges_sol_construccion.servicio.TipConstServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author roagudelo
 */
@RestController
public class TipConstruccionControlador {
    
    /**
    * Clase que se encarga de tener la lógica de negocio
    */
    @Autowired
    private TipConstServicio servicio;

    /**
     * Método encargado de controlar la consulta de solicitudes
     *
     * @return Respuesta Genérica si es correcta o incorrecta y con el listado de Tipos de Construccion consultadas
     * 
     */
    @PostMapping("/tipconstruccion/consultar")
    public RespuestaDTO consultar()
    {
        return new RespuestaDTO().setDatos(servicio.findAll());
    }
    /**
     * crea el tipo de contruccion y la retorna
     * @param tipConstruc a guardar
     * @return Respuesta Genérica si es correcta o incorrecta y con el Tipo de Construccion creador
     * 
     */
    @PostMapping("/tipconstruccion/guardar")
    public RespuestaDTO guardar(@RequestBody TipConstruccion tipConstruc)
    {
        return new RespuestaDTO().setDatos(servicio.create(tipConstruc));
    }

}
