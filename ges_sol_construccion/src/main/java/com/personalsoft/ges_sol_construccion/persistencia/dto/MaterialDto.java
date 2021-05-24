package com.personalsoft.ges_sol_construccion.persistencia.dto;



import java.io.Serializable;


/**
 * Dto para el traslado de la informacion entre las capas de la aplicación
 * @author roagudelo
 */

public class MaterialDto  implements Serializable{
    private Long id ;
    private String codMaterial ;    
    private String nomMaterial ;    
    private int cntMaterial ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(String codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getNomMaterial() {
        return nomMaterial;
    }

    public void setNomMaterial(String nomMaterial) {
        this.nomMaterial = nomMaterial;
    }

    public int getCntMaterial() {
        return cntMaterial;
    }

    public void setCntMaterial(int cntMaterial) {
        this.cntMaterial = cntMaterial;
    }

    
}
