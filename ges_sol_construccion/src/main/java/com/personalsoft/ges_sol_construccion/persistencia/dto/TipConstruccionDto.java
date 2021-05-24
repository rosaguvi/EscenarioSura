/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.persistencia.dto;

import java.io.Serializable;
import java.util.List;


/**
 * entidad que representa la tabla que guardara la informacion de los materiales a usar en la construccion
 * @author roagudelo
 */

public class TipConstruccionDto implements Serializable {

    private Long idTipConstruccion ;
    private String nomTipconstruccion ;
    private int tiempoConstruccion ;
    private List<TipconsMaterialDto> materiales;

    public Long getIdTipConstruccion() {
        return idTipConstruccion;
    }

    public void setIdTipConstruccion(Long idTipConstruccion) {
        this.idTipConstruccion = idTipConstruccion;
    }

    public String getNomTipconstruccion() {
        return nomTipconstruccion;
    }

    public void setNomTipconstruccion(String nomTipconstruccion) {
        this.nomTipconstruccion = nomTipconstruccion;
    }

    public int getTiempoConstruccion() {
        return tiempoConstruccion;
    }

    public void setTiempoConstruccion(int tiempoConstruccion) {
        this.tiempoConstruccion = tiempoConstruccion;
    }

    public List<TipconsMaterialDto> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<TipconsMaterialDto> materiales) {
        this.materiales = materiales;
    }   
    
 }
