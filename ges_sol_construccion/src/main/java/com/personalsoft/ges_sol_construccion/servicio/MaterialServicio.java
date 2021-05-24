/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.servicio;

import com.personalsoft.ges_sol_construccion.persistencia.repository.MaterialRepository;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.Material;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author roagudelo
 */
@Service
public class MaterialServicio{  

    @Autowired
    private MaterialRepository material_it ;

    public List<Material> findAll() {        
        return  material_it.findAll();
    }

    public Material create(Material material) {
        return (Material) material_it.save(material);
    }
}
