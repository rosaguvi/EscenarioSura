/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.persistencia.entidades;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * entidad que representa la tabla que guardara la informacion de los materiales a usar en la construccion
 * @author roagudelo
 */
@Entity
@Table(name = "materiales")
public class Material extends EntityBase implements Serializable{

    @Column(name = "cod_material")
    private String codMaterial ;
    
    @Column(name = "nom_material")
    private String nomMaterial ;
    
    @Column(name = "cnt_material")
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
