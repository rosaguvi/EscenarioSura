/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.persistencia.dto;

import java.io.Serializable;


/**
 *
 * @author roagudelo
 */

public class SolConstruccionDto implements Serializable  {   

    private Long idSolicitud;    
    private Long idTipConstruccion;    
    private String tipConsNombre;    
    private Double corxConstruccion;   
    private Double coryConstruccion;    
    private String estSolconstriuccion;

    public Long getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Long idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Long getIdTipConstruccion() {
        return idTipConstruccion;
    }

    public void setIdTipConstruccion(Long idTipConstruccion) {
        this.idTipConstruccion = idTipConstruccion;
    }

    public String getTipConsNombre() {
        return tipConsNombre;
    }

    public void setTipConsNombre(String tipConsNombre) {
        this.tipConsNombre = tipConsNombre;
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
