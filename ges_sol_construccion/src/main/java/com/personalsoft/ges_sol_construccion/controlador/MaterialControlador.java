/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.controlador;

import com.personalsoft.ges_sol_construccion.estandar.clases.AplicacionExcepcion;
import com.personalsoft.ges_sol_construccion.persistencia.dto.RespuestaDTO;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.Material;
import com.personalsoft.ges_sol_construccion.servicio.MaterialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * controlador para los materiales
 * @author roagudelo
 */
@RestController
public class MaterialControlador {
    
    /**
    * Clase que se encarga de tener la lógica de negocio
    */
    @Autowired
    private MaterialServicio servicio;

    /**
     * Método encargado de controlar la consulta de solicitudes
     * 
     * @return Respuesta Genérica si es correcta o incorrecta y con el listado de solicitudes consultadas
     */
    @PostMapping("/material/consultar")
    public RespuestaDTO consultar()
    {
        return new RespuestaDTO().setDatos(servicio.findAll());
    }
    /**
     * metodo para crear o actualizar el material
     * @param material a guardar en la base de datos
     * @return repuesta generica
     */
    @PostMapping("/material/guardar")
    public RespuestaDTO guardar(@RequestBody Material material)
    {
        return new RespuestaDTO().setDatos(servicio.create(material));
        
    }

}
