/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.controlador;

//import com.fasterxml.jackson.databind.JsonNode;
import com.personalsoft.ges_sol_construccion.persistencia.dto.RespuestaDTO;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.TipconsMaterial;
import com.personalsoft.ges_sol_construccion.servicio.TipconsMatServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author roagudelo
 */
@RestController
public class TipconsMatControlador {
    
    /**
    * Clase que se encarga de tener la lógica de negocio
    */
    @Autowired
    private TipconsMatServicio servicio;

    /**
     * Método encargado de controlar la consulta los materiales de los tipos e contruccion
     *
     * @return Respuesta Genérica si es correcta o incorrecta y con el listado de materiales para los diferentes tipos de Contruccion
     */
    @PostMapping("/tipcons_mat/consultar")
    public RespuestaDTO consultar()
    {       
      return new RespuestaDTO().setDatos(servicio.findAll());
    }
    
    /**
     * Metodo para guardar los materiales que requiere un tipo de contruccion.
     * @param tipconMat material para el tipo de construccion 
     * @return respuesta generica con los datos consultados
     */
    @PostMapping("/tipcons_mat/guardar")
    public RespuestaDTO guardar(@RequestBody TipconsMaterial tipconMat)
    {
        System.err.println("estamos aqui en guardar");
        System.out.println(tipconMat);
      return new RespuestaDTO().setDatos(servicio.create(tipconMat));
    }

}
