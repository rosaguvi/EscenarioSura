/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author roagudelo
 */
@Entity
@Table(name = "tipcons_material")
public class TipconsMaterial extends EntityBase {
   
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipconstruccion_id")
    private TipConstruccion tipConstruccion;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "material_id")
    private Material material;
    
    @Column(name = "cnt_material")
    private int cntMaterial ;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipConstruccion getTipConstruccion() {
        return tipConstruccion;
    }

    public void setTipConstruccion(TipConstruccion tipConstruccion) {
        this.tipConstruccion = tipConstruccion;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public int getCntMaterial() {
        return cntMaterial;
    }

    public void setCntMaterial(int cntMaterial) {
        this.cntMaterial = cntMaterial;
    }

   
}
