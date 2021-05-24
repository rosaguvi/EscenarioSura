/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.persistencia.dto;

import com.personalsoft.ges_sol_construccion.persistencia.entidades.*;
import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author roagudelo
 */

public class OrdConstruccionDto implements Serializable  {
   
   
    private Long idOrdConstruccion ;
    private String tipConstruccion;
    private Long idSolConstruccion ;
    private Date feciniConstruccion;
    private Date fecfinConstruccion;
    private Double corX;
    private Double cory;
    private String estConstruccion;
    

    public Long getIdOrdConstruccion() {
        return idOrdConstruccion;
    }

    public void setIdOrdConstruccion(Long idOrdConstruccion) {
        this.idOrdConstruccion = idOrdConstruccion;
    }

    public String getTipConstruccion() {
        return tipConstruccion;
    }

    public void setTipConstruccion(String tipConstruccion) {
        this.tipConstruccion = tipConstruccion;
    }

    public Long getIdSolConstruccion() {
        return idSolConstruccion;
    }

    public void setIdSolConstruccion(Long idSolConstruccion) {
        this.idSolConstruccion = idSolConstruccion;
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

    public Double getCorX() {
        return corX;
    }

    public void setCorX(Double corX) {
        this.corX = corX;
    }

    public Double getCory() {
        return cory;
    }

    public void setCory(Double cory) {
        this.cory = cory;
    }

    public String getEstConstruccion() {
        return estConstruccion;
    }

    public void setEstConstruccion(String estConstruccion) {
        this.estConstruccion = estConstruccion;
    }

    
    
}
