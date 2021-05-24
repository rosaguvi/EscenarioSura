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

public class TipconsMaterialDto implements Serializable{
      
    private Long idMaterial;    
    private Long idTipConstruccion;   
    private int cntMaterial ;

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public Long getIdTipConstruccion() {
        return idTipConstruccion;
    }

    public void setIdTipConstruccion(Long idTipConstruccion) {
        this.idTipConstruccion = idTipConstruccion;
    }

    public int getCntMaterial() {
        return cntMaterial;
    }

    public void setCntMaterial(int cntMaterial) {
        this.cntMaterial = cntMaterial;
    }
   

   
}
