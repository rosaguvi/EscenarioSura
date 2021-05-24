package com.personalsoft.ges_sol_construccion.dao;

import com.personalsoft.ges_sol_construccion.estandar.clases.AplicacionExcepcion;
import com.personalsoft.ges_sol_construccion.persistencia.dto.OrdConstruccionDto;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.OrdConstruccion;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.SolConstruccion;
import com.personalsoft.ges_sol_construccion.persistencia.repository.OrdConstRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Clase que se encarga de organizar los objetos de tipo OrdConstruccion para ser consultado o enviados a la base de datos
 * @author roagudelo
*/
@Repository
public class OrdConstruccionDao {

   @Autowired
    private OrdConstRepository repositorio ;
   @Autowired
    private SolConstruccionDao daoSolCons ;
 
     /**
     * Método traerUltimoReg que consulta la ultima orden de construccion
     * @return OrdConstruccionDto 
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public OrdConstruccionDto traerUltimoReg() 
            throws AplicacionExcepcion 
    {
        List<OrdConstruccion> lista = repositorio.findTopByOrderByIdDesc();
        if (!lista.isEmpty())
        {
            return getDtotoEntity(lista.get(0)) ;
        }        
        return null ;       
    }   
    
    /**
     * metodo consultarPorFecha consultara la ordenesde trabajao que inicia en la fceha indicada
     * @param fecha_ini fecha con la que se compara la fecha de inicio de la construccion
     * @return OrdConstruccionDto
     * @throws AplicacionExcepcion  para trasladar el manejo de los errores a la capa de servicio
     */
    public List<OrdConstruccionDto> traerInicianFecha(Date fecha_ini) 
            throws AplicacionExcepcion 
    {
        List<OrdConstruccion> lista = repositorio.findByFeciniConstruccionEquals(fecha_ini);
        if (!lista.isEmpty())
        {
            return getListDtotoListEntity(lista) ;
        }        
        return null ;       
    }   
    /**
     * metodo consultarPorFecha consultara la ordenesde trabajao que terminan en la fceha indicada
     * @param fecha_fin fecha con la que se compara la fecha de finalizacion de la construccion
     * @return OrdConstruccionDto
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public List<OrdConstruccionDto> traerFinalizaFecha(Date fecha_fin) 
            throws AplicacionExcepcion 
    {
        List<OrdConstruccion> lista = repositorio.findByFecfinConstruccionEquals(fecha_fin);
        if (!lista.isEmpty())
        {
            return getListDtotoListEntity(lista) ;
        }        
        return null ;       
    }   
    
     /**
     * Método que lista todas las Ordenes de Contruccion creadas
     * @return List de OrdConstruccionDto
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public List<OrdConstruccionDto> getTodos() 
            throws AplicacionExcepcion 
    {
        List<OrdConstruccion> lista = repositorio.findAll();        
        return getListDtotoListEntity(lista);       
    }  
    
        /**
     * Método que lista todas las Ordenes de Contruccion creadas y que estan pendientes
     * @param estado de la orden de construccion
     * @return List de OrdConstruccionDto
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public List<OrdConstruccionDto> getTodasEstado(String estado) 
            throws AplicacionExcepcion 
    {
        List<OrdConstruccion> lista = repositorio.findByEstConstruccionEquals(estado);        
        return getListDtotoListEntity(lista);       
    } 
    
     /**
     * Método save encargado de guardar registros de la solicitud de Construccion
     * @param ordConst(OrdConstruccionDto)
     * @return OrdConstruccionDto
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public OrdConstruccionDto save(OrdConstruccionDto ordConst) 
            throws AplicacionExcepcion 
    {
        // se convierte a entidad para enviar a la base de datos y luego la respuesta a Dto para retornarlo al servicio
        return getDtotoEntity(repositorio.save(getEntitytoDto(ordConst)));
    }  
    
     /**
     * Método encargado de convertir la entidad en Dto para enviarlo al servicio
     *
     * @param ordConst OrdConstruccion 
     * @return Obj(OrdConstruccionDto)
     */

    public OrdConstruccionDto getDtotoEntity (OrdConstruccion ordConst)
    {
        OrdConstruccionDto ordConsDto = new OrdConstruccionDto();
        ordConsDto.setTipConstruccion(ordConst.getSolConstruccion().getTipConstruccion().getNomTipconstruccion());
        ordConsDto.setCorX(ordConst.getSolConstruccion().getCorxConstruccion());
        ordConsDto.setCory(ordConst.getSolConstruccion().getCoryConstruccion());
        ordConsDto.setEstConstruccion(ordConst.getEstConstruccion());
        ordConsDto.setFecfinConstruccion(ordConst.getFecfinConstruccion());
        ordConsDto.setFeciniConstruccion(ordConst.getFeciniConstruccion());
        ordConsDto.setIdOrdConstruccion(ordConst.getId());
        ordConsDto.setIdSolConstruccion(ordConst.getSolConstruccion().getId());
        return ordConsDto ;
    }
    /**
     * Método encargado de convertir el Dto a Entidad para ser procesado por la base de datos
     *
     * @param ordConsDto(OrdConstruccionDto)
     * @return OrdConstruccion Entity
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public OrdConstruccion getEntitytoDto(OrdConstruccionDto ordConsDto) 
            throws AplicacionExcepcion
    {
        OrdConstruccion ordCons = new OrdConstruccion();
        SolConstruccion solCons = daoSolCons.buscarPorId(ordConsDto.getIdSolConstruccion());   
        ordCons.setSolConstruccion(solCons);
        ordCons.setEstConstruccion(ordConsDto.getEstConstruccion());
        ordCons.setFecfinConstruccion(ordConsDto.getFecfinConstruccion());
        ordCons.setFeciniConstruccion(ordConsDto.getFeciniConstruccion());
        ordCons.setId(ordConsDto.getIdOrdConstruccion());
        return ordCons ;
    }

     /**
     * Método encargado de convertir una lista de Dto´s a una Listado de Entidad´s 
     * @param OrdenesConsDto list(OrdConstruccionDto)
     * @return List(OrdConstruccion)
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public List<OrdConstruccion> getListEntitytoListDto(List<OrdConstruccionDto> OrdenesConsDto) 
            throws AplicacionExcepcion
    {
        List<OrdConstruccion> OrdenesCons = new ArrayList<>();
        for (OrdConstruccionDto ordenConsDto: OrdenesConsDto) {
            OrdenesCons.add(getEntitytoDto(ordenConsDto));
        }         
        return OrdenesCons ;
    }
    /**
     * Método encargado de convertir una lista de Entity´s a una Listado de Dto´s
     * @param ordenesCons list(OrdConstruccionDto)
     * @return List(OrdConstruccion)
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public List<OrdConstruccionDto> getListDtotoListEntity(List<OrdConstruccion> ordenesCons) 
            throws AplicacionExcepcion
    {
        List<OrdConstruccionDto> ordenesConsDto = new ArrayList<>();
        for (OrdConstruccion ordenCons: ordenesCons) {
            ordenesConsDto.add(getDtotoEntity(ordenCons));
        }         
        return ordenesConsDto ;
    }
}
