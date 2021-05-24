package com.personalsoft.ges_sol_construccion.dao;

import com.personalsoft.ges_sol_construccion.estandar.clases.AplicacionExcepcion;
import com.personalsoft.ges_sol_construccion.estandar.clases.MensajeEstandar;
import com.personalsoft.ges_sol_construccion.estandar.clases.MyExcepcion;
import com.personalsoft.ges_sol_construccion.persistencia.dto.TipConstruccionDto;
import com.personalsoft.ges_sol_construccion.persistencia.dto.TipconsMaterialDto;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.Material;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.TipConstruccion;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.TipconsMaterial;
import com.personalsoft.ges_sol_construccion.persistencia.repository.TipConstRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roagudelo
 */
@Repository
public class TipConstruccionDao {

   @Autowired
    private TipConstRepository respositorio ;
    private MaterialDao daoMaterial ;

    /**
     * Método encargado de consultar el tipo de construccion por id registro y Nombre y retorna un Dto con los datos
     *
     * @param id_tipcons ideintificador unico del registr 
     * @return Entity(TipConstruccion)
     * @throws AplicacionExcepcion para trasladar el manejo del error al servicio
   */
    public TipConstruccionDto buscarPorId (Long id_tipcons )
        throws AplicacionExcepcion 
    {  
        TipConstruccion tipCons = new TipConstruccion();
       if(Long.valueOf(id_tipcons)!=null)
        {
            tipCons = respositorio.findById(id_tipcons).get();
        }else{
            System.out.println("ERROR_DATOS_CONSULTAR_ENTIDAD");
             throw new MyExcepcion(MensajeEstandar.ERROR_DATOS_CONSULTAR_ENTIDAD, "TipConstruccion");
        }
       if (tipCons == null)
       {      
            System.out.println("ERROR_SIN_DATOS_CONSULTAR_ENTIDAD");
           throw new MyExcepcion(MensajeEstandar.ERROR_SIN_DATOS_CONSULTAR_ENTIDAD, "TipConstruccion");
       } else {
           return getDtotoEntity(tipCons) ;
       }
    }      
    
    /**
     * Método encargado de consultar el tipo de construccion por id registro y Nombre
     *
     * @param id_tipcons ideintificador unico del registr
     * @param nombre_tp  codigo del material, el cual debe ser unico  
     * @return Entity(TipConstruccion)
     * @throws AplicacionExcepcion para trasladar el manejo del error al servicio
   */
    
    public TipConstruccion getTipConstByIdNom (Long id_tipcons , String nombre_tp)
        throws AplicacionExcepcion 
    {      
        TipConstruccion tipCons = new TipConstruccion();
       if(Long.valueOf(id_tipcons)!=null)
        {
            tipCons = respositorio.findById(id_tipcons).get();
        }
        else if (nombre_tp == null){
            List<TipConstruccion> lista = respositorio.findByNomTipconstruccion(nombre_tp);
            tipCons = lista.get(0);
        }else{
             throw new MyExcepcion(MensajeEstandar.ERROR_DATOS_CONSULTAR_ENTIDAD, "TipConstruccion");
        }
       if (tipCons == null)
       {
            throw new MyExcepcion(MensajeEstandar.ERROR_SIN_DATOS_CONSULTAR_ENTIDAD, "TipConstruccion");
       } else {
           return tipCons ;
       }        
    }

    /**
     * Método encargado de convertir la entidad en Dto para enviarlo al servicio
     *
     * @param TipConst Entity(TipConstruccion)
     * @return Obj(TipConstruccionDto)
     * @throws AplicacionExcepcion para trasladar el manejo del error al servicio
     */

    public TipConstruccionDto getDtotoEntity (TipConstruccion TipConst) 
            throws AplicacionExcepcion
    {
        TipConstruccionDto TipConsDto = new TipConstruccionDto();
        TipConsDto.setIdTipConstruccion(TipConst.getId());
        TipConsDto.setNomTipconstruccion(TipConst.getNomTipconstruccion());
        TipConsDto.setTiempoConstruccion(TipConst.getTiempoConstruccion());
        TipConsDto.setMateriales(getListDtotoListEntityMateriales(TipConst.getMateriales()));        
        return TipConsDto ;
    }
    /**
     * Método encargado de convertir el Dto a Entidad para ser procesado por la base de datos
     *
     * @param TipConsDto Obj(TipConstruccionDto)
     * @return Entity(TipConstruccion)
     * @throws AplicacionExcepcion para trasladar el manejo del error al servicio
     */
    public TipConstruccion getEntitytoDto(TipConstruccionDto TipConsDto) 
            throws AplicacionExcepcion
    {
        TipConstruccion tipCons = new TipConstruccion();
        tipCons.setId(TipConsDto.getIdTipConstruccion());
        tipCons.setNomTipconstruccion(TipConsDto.getNomTipconstruccion());
        tipCons.setTiempoConstruccion(TipConsDto.getTiempoConstruccion());
        tipCons.setMateriales(getListEntitytoListDtoMateriales(TipConsDto.getMateriales()));        
        return tipCons ;
    }
    
     /**
     * Método encargado de convertir la entidad que contiene los materiales en Dto para enviarlo al servicio
     *
     * @param materialCons Entity(TipConstruccion)
     * @return Obj(TipConstruccionDto)
     */

    public TipconsMaterialDto getDtotoEntityMateriales (TipconsMaterial materialCons)
    {
        TipconsMaterialDto materialConsDto = new TipconsMaterialDto();
        materialConsDto.setCntMaterial(materialCons.getCntMaterial());
        materialConsDto.setIdMaterial(materialCons.getMaterial().getId());
        materialConsDto.setIdTipConstruccion(materialCons.getTipConstruccion().getId());
        return materialConsDto ;
    }
    /**
     * Método encargado de convertir el Dto a Entidad que contiene los materialespara ser procesado por la base de datos
     *
     * @param materialesDto Obj(TipconsMaterialDto)
     * @return Entity(TipconsMaterial)
     * @throws AplicacionExcepcion para trasladar el manejo del error al servicio
     */
    public TipconsMaterial getEntitytoDtoMateriales(TipconsMaterialDto materialesDto) 
            throws AplicacionExcepcion
    {
        TipconsMaterial materialCons = new TipconsMaterial();
        TipConstruccion tipCons = getTipConstByIdNom(materialesDto.getIdTipConstruccion(), null);     
        Material material = daoMaterial.getMaterialByIdCod(materialesDto.getIdMaterial(), null);     
        materialCons.setTipConstruccion(tipCons);
        materialCons.setMaterial(material);
        materialCons.setCntMaterial(materialesDto.getCntMaterial());  
        return materialCons ;
    }
    
    /**
     * Método encargado de convertir una lista de Dto´s a una Listado de Entidad´s que contiene los materialespara ser procesado por la base de datos
     * @param materialesConsDto list(TipconsMaterialDto)
     * @return List(TipconsMaterial)
     * @throws AplicacionExcepcion para trasladar el manejo del error al servicio
     */
    public List<TipconsMaterial> getListEntitytoListDtoMateriales(List<TipconsMaterialDto> materialesConsDto) 
            throws AplicacionExcepcion
    {
        List<TipconsMaterial> materialesCons = new ArrayList<>();
        for (TipconsMaterialDto MaterialConsDto: materialesConsDto) {
            materialesCons.add(getEntitytoDtoMateriales(MaterialConsDto));
        }         
        return materialesCons ;
    }
    /**
     * Método encargado de convertir una lista de Entity´s a una Listado de Dto´s que contiene los materialespara ser procesado por la base de datos
     * @param materialesCons list(TipconsMaterial)
     * @return List(TipconsMaterialDto)
     * @throws AplicacionExcepcion para trasladar el manejo del error al servicio
     */
    public List<TipconsMaterialDto> getListDtotoListEntityMateriales(List<TipconsMaterial> materialesCons) 
            throws AplicacionExcepcion
    {
        List<TipconsMaterialDto> materialesConsDto = new ArrayList<>();
        for (TipconsMaterial MaterialCons: materialesCons) {
            materialesConsDto.add(getDtotoEntityMateriales(MaterialCons));
        }         
        return materialesConsDto ;
    }

}
