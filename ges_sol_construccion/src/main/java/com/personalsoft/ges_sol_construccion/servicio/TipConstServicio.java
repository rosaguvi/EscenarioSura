/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.servicio;


import com.personalsoft.ges_sol_construccion.persistencia.repository.TipConstRepository;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.TipConstruccion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author roagudelo
 */
@Service
public class TipConstServicio{  

    @Autowired
    private TipConstRepository respositorio ;

    public List<TipConstruccion> findAll() {        
        return  respositorio.findAll();
    }

    public TipConstruccion create(TipConstruccion tipConstMat) {
        return respositorio.save(tipConstMat);
    }
}
