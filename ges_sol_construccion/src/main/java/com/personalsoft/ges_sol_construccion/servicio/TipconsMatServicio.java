/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.servicio;

import com.personalsoft.ges_sol_construccion.persistencia.repository.TipconsMatRepository;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.TipconsMaterial;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author roagudelo
 */
@Service
public class TipconsMatServicio{  

    @Autowired
    private TipconsMatRepository repository ;

    public List<TipconsMaterial> findAll() {        
        return  repository.findAll();
    }

    public TipconsMaterial create(TipconsMaterial tipconsMat) {
        return (TipconsMaterial) repository.save(tipconsMat);
    }
}
