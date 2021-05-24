/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
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
@Table(name = "sol_construccion")
public class SolConstruccion extends EntityBase {
   
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipconstruccion_id")
    private TipConstruccion tipConstruccion;
    
    @Column(name = "corx_construccion")
    private Double corxConstruccion;
    
    @Column(name = "cory_construccion")
    private Double coryConstruccion;
    
    @Column(name = "est_solconstruccion")
    private String estSolconstriuccion;
    
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

    public Double getCorxConstruccion() {
        return corxConstruccion;
    }

    public void setCorxConstruccion(Double corxConstruccion) {
        this.corxConstruccion = corxConstruccion;
    }

    public Double getCoryConstruccion() {
        return coryConstruccion;
    }

    public void setCoryConstruccion(Double coryConstruccion) {
        this.coryConstruccion = coryConstruccion;
    }

    public String getEstSolconstriuccion() {
        return estSolconstriuccion;
    }

    public void setEstSolconstriuccion(String estSolconstriuccion) {
        this.estSolconstriuccion = estSolconstriuccion;
    }
}
