/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.persistencia.entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author roagudelo
 */
@Entity
@Table(name = "ord_construccion")
public class OrdConstruccion extends EntityBase {
   
    @JsonBackReference
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "solconstruccion_id")
    private SolConstruccion solConstruccion;
    
    @Column(name = "fecini_construccion")
    private Date feciniConstruccion;
    
    @Column(name = "fecfin_construccion")
    private Date fecfinConstruccion;
    
    @Column(name = "est_constriuccion")
    private String estConstruccion;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SolConstruccion getSolConstruccion() {
        return solConstruccion;
    }

    public void setSolConstruccion(SolConstruccion solConstruccion) {
        this.solConstruccion = solConstruccion;
    }

    public Date getFeciniConstruccion() {
        return feciniConstruccion;
    }

    public void setFeciniConstruccion(Date feciniConstruccion) {
        this.feciniConstruccion = feciniConstruccion;
    }

    public Date getFecfinConstruccion() {
        return fecfinConstruccion;
    }

    public void setFecfinConstruccion(Date fecfinConstruccion) {
        this.fecfinConstruccion = fecfinConstruccion;
    }

    public String getEstConstruccion() {
        return estConstruccion;
    }

    public void setEstConstruccion(String estConstruccion) {
        this.estConstruccion = estConstruccion;
    }
       
}
