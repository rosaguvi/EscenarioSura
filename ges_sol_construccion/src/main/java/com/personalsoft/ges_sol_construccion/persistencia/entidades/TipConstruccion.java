/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.persistencia.entidades;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * entidad que representa la tabla que guardara la informacion de los materiales a usar en la construccion
 * @author roagudelo
 */

@Entity
@Table(name = "tip_construcciones")
public class TipConstruccion extends EntityBase {

    @Column(name = "nom_tipconstruccion")
    private String nomTipconstruccion ;
    
    @Column(name = "tiempo_construccion")
    private int tiempoConstruccion ;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipConstruccion" , fetch = FetchType.EAGER)
    private List<TipconsMaterial> materiales;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }
    public int getTiempoConstruccion(){
        return tiempoConstruccion;
    }

    public void setTiempoConstruccion(int tiempoConstruccion){
        this.tiempoConstruccion = tiempoConstruccion;
    }    

    public String getNomTipconstruccion(){
        return nomTipconstruccion;
    }

    public void setNomTipconstruccion(String nomTipconstruccion){
        this.nomTipconstruccion = nomTipconstruccion;
    }  

    public List<TipconsMaterial> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<TipconsMaterial> materiales) {
        this.materiales = materiales;
    }
    
 }
