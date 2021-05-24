/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.personalsoft.ges_sol_construccion.servicio;


import com.personalsoft.ges_sol_construccion.dao.MaterialDao;
import com.personalsoft.ges_sol_construccion.dao.OrdConstruccionDao;
import com.personalsoft.ges_sol_construccion.dao.SolConstruccionDao;
import com.personalsoft.ges_sol_construccion.dao.TipConstruccionDao;
import com.personalsoft.ges_sol_construccion.estandar.clases.AplicacionExcepcion;
import com.personalsoft.ges_sol_construccion.estandar.clases.MensajeEstandar;
import com.personalsoft.ges_sol_construccion.estandar.clases.MyExcepcion;
import com.personalsoft.ges_sol_construccion.estandar.clases.Utilidades;
import com.personalsoft.ges_sol_construccion.persistencia.dto.MaterialDto;
import com.personalsoft.ges_sol_construccion.persistencia.dto.OrdConstruccionDto;
import com.personalsoft.ges_sol_construccion.persistencia.dto.SolConstruccionDto;
import com.personalsoft.ges_sol_construccion.persistencia.dto.TipConstruccionDto;
import com.personalsoft.ges_sol_construccion.persistencia.dto.TipconsMaterialDto;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author roagudelo
 */
@Service
public class OrdConstServicio extends Utilidades{  

    @Autowired
    private OrdConstruccionDao dao ;
    @Autowired
    private SolConstruccionDao daoSolCon ;
    @Autowired
    private TipConstruccionDao tipConsDao ;
    @Autowired
    private MaterialDao materialDao ;
    
    /**
     * retorna todos los registros
     * @return listado con todas las ordenes de servicio
     * @throws AplicacionExcepcion para pasar el manejo del error al controller
     */
    public List<OrdConstruccionDto> findAll() 
            throws AplicacionExcepcion 
    {        
        return dao.getTodos();
    }
     
    /**
     * Genera listado de ordenes de trabajo en el estado enviado
     * @param estado de la orden de contruccion
     * @return listado con todas las ordenes de servicio en estado pendientes
     * @throws AplicacionExcepcion para pasar el manejo del error al controller
     */
    public List<OrdConstruccionDto> findAllEstado(String estado) 
            throws AplicacionExcepcion 
    {        
        return dao.getTodasEstado(estado);
    }
    /**
     * Metodo encargado de crear la solicitud de contruccion
     * metodo que crea la orden de conatruccion
     * @param solConst a enviar a la base de datos
     * @return OrdConstruccionDto
     * @throws AplicacionExcepcion para pasar el manejo del error al controller 
     */
    public OrdConstruccionDto create(SolConstruccionDto solConst) 
            throws AplicacionExcepcion 
    {
        // se envian los materiales a actualizar y se traen los dias de construccion
        int cntDiasCont = ActCantidadMateriales(solConst);
        // se crea y llena el Dto
        OrdConstruccionDto ordConDto = new OrdConstruccionDto();
        ordConDto.setCorX(solConst.getCorxConstruccion());
        ordConDto.setCory(solConst.getCoryConstruccion());
        ordConDto.setEstConstruccion("Pendiente");
        ordConDto.setIdSolConstruccion(solConst.getIdSolicitud());
        // se llenan las fechas inicio y fin de la orden de construccion
        ordConDto = generarFecInicFecFin(ordConDto, cntDiasCont) ;       
        // se envia al dao para la creacion del registro en estado pendiente 
        return dao.save(ordConDto);
    }

    /**
     * Método valdidarCantidadMateriales: encargado de validar si hay suficiente cantidad de todos los materiales requeridos para la construccion
     * @param solConst de tipo SolConstruccionDto
     * @throws AplicacionExcepcion apenas encuentra un material del que no hay suficiente cantidad
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
    /**
     * Método ActCantidadMateriales: encargado de validar los materiales y actualizar las cantidades
     * @param solConst de tipo SolConstruccionDto
     * @return Int con los dias que dura la construccion si se realizo la actualizacion correctamente
     * @throws AplicacionExcepcion apenas encuentra un material del que no hay suficiente cantidad o si se genera algun error
     */
    public int ActCantidadMateriales(SolConstruccionDto solConst) 
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
                } else{
                    material.setCntMaterial(material.getCntMaterial()- MaterialCons.getCntMaterial());
                    materialDao.Save(material);                
                }

             }
            return tip_construccion.getTiempoConstruccion();
        }else {
            throw new MyExcepcion(MensajeEstandar.ERROR_SIN_DATOS_CONSULTAR_ENTIDAD, "TipConstruccion" );
        }        
        
    }
    /**
     * metodo generarFecInicFecFin que genera las fechas de inicio y de finalizacion de la orden de construccion
     * @param ordConst Dto con la informacion a guardar, para actualizar las fechas
     * @param cntDiasCont Cantidad de dias que dura la construccion
     * @return OrdConstruccionDto con las fechas actualkizada
     * @throws AplicacionExcepcion para pasar el manejo del error al controller 
     */
    
    public OrdConstruccionDto generarFecInicFecFin(OrdConstruccionDto ordConst , int cntDiasCont) 
            throws AplicacionExcepcion 
    {
        /**
         * se consulta solicitudes por la ubicacion y si existe alguna se genera una Excepcion, de lo contrario continua
         */
        OrdConstruccionDto ultOrdCons = dao.traerUltimoReg() ;
        Date fechaAct = new Date();  
        if (ultOrdCons != null ){
            if ((ultOrdCons.getFecfinConstruccion()).before(fechaAct))
            {
                fechaAct = ultOrdCons.getFecfinConstruccion();
            }            
        }  
        try {
            ordConst.setFeciniConstruccion(convertirFecha(sumarDiasAFecha(fechaAct, 1)));  
            ordConst.setFecfinConstruccion(convertirFecha(sumarDiasAFecha(fechaAct,cntDiasCont)));  
        } catch (Exception e) {
            throw new MyExcepcion(MensajeEstandar.ERROR_Fechas, e.getMessage());
        }
         
        return ordConst ;
    }

    /**
     * Método consultarFecFinConstr Consulta la Fecha de Finalizacion de la Ciudadela
     * @return String 
     * @throws AplicacionExcepcion para pasar el manejo del error al controller 
     */
    public String consultarFecFinConstr () 
            throws AplicacionExcepcion 
    {
        // se consulta la ultima orden de construccion Generada para saber la fecha de finalizacion 
        OrdConstruccionDto ultOrdCons = dao.traerUltimoReg() ;       
        return  ("La ciudadela se terminara de Contruir en: " + ultOrdCons.getFecfinConstruccion() );
    }
    

}
