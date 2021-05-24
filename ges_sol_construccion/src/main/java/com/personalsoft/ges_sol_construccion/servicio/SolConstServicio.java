/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.servicio;


import com.personalsoft.ges_sol_construccion.dao.MaterialDao;
import com.personalsoft.ges_sol_construccion.dao.SolConstruccionDao;
import com.personalsoft.ges_sol_construccion.dao.TipConstruccionDao;
import com.personalsoft.ges_sol_construccion.estandar.clases.AplicacionExcepcion;
import com.personalsoft.ges_sol_construccion.estandar.clases.MensajeEstandar;
import com.personalsoft.ges_sol_construccion.estandar.clases.MyExcepcion;
import com.personalsoft.ges_sol_construccion.persistencia.dto.MaterialDto;
import com.personalsoft.ges_sol_construccion.persistencia.dto.SolConstruccionDto;
import com.personalsoft.ges_sol_construccion.persistencia.dto.TipConstruccionDto;
import com.personalsoft.ges_sol_construccion.persistencia.dto.TipconsMaterialDto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author roagudelo
 */
@Service
public class SolConstServicio{  

    @Autowired
    private SolConstruccionDao dao ;
    @Autowired
    private TipConstruccionDao tipConsDao ;
    @Autowired
    private MaterialDao materialDao ;

    public List<SolConstruccionDto> findAll() 
            throws AplicacionExcepcion 
    {        
        return  dao.ListarTodos();
    }

    /**
     * metodo create metodo encargado de validar las restricciones y crear la solicitud de construccion
     * @param solConst a enviar a la base de datos
     * @return SolConstruccionDto
     * @throws AplicacionExcepcion para pasar el manejo del error de las conversiones al cotroller
     */
    public SolConstruccionDto create(SolConstruccionDto solConst) 
            throws AplicacionExcepcion 
    {
        /**
         * se consulta solicitudes por la ubicacion y si existe alguna se genera una Excepcion, de lo contrario continua
         */
        if (dao.getTipConstByUbicacion(solConst.getCorxConstruccion(), solConst.getCoryConstruccion()) != null )
        {
            throw new MyExcepcion(MensajeEstandar.ERROR_UBICACION_NO_DISPONIBLE );
        }
        
        // se valida los materiales
        valdidarCantidadMateriales(solConst);
        // se envia al dao para la creacion del registro en estado pendiente 
        return dao.create(solConst);
    }
    
    /**
     * Método valdidarCantidadMateriales: encargado de validar si hay suficiente cantidad de todos los materiales requeridos para la construccion
     * @param solConst de tipo SolConstruccionDto
     * @throws AplicacionExcepcion  apenas encuentra un material del que no hay suficiente cantidad
     */
    public void valdidarCantidadMateriales(SolConstruccionDto solConst) 
            throws AplicacionExcepcion 
    {
       /**
        * Consulta la listade materiales necesarios y recorre uno a uno para valdiarlos
        */
        TipConstruccionDto tip_construccion = tipConsDao.buscarPorId(solConst.getIdTipConstruccion());  
        if ( tip_construccion != null)
        {       
            List<TipconsMaterialDto> materialescons = tip_construccion.getMateriales();        
            for (TipconsMaterialDto MaterialCons: materialescons) 
            {
                MaterialDto material = materialDao.getMaterialById(MaterialCons.getIdMaterial());

                if (material.getCntMaterial()<MaterialCons.getCntMaterial())
                {
                 
                    throw new MyExcepcion(MensajeEstandar.ERROR_MATERIAL_NO_SUFICIENTE, material.getNomMaterial());
                } 

             }
        }else {
            throw new MyExcepcion(MensajeEstandar.ERROR_SIN_DATOS_CONSULTAR_ENTIDAD, "TipConstruccion" );
        }        
        
    }
    
}
