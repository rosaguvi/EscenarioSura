package com.personalsoft.ges_sol_construccion.dao;

import com.personalsoft.ges_sol_construccion.estandar.clases.AplicacionExcepcion;
import com.personalsoft.ges_sol_construccion.estandar.clases.MensajeEstandar;
import com.personalsoft.ges_sol_construccion.estandar.clases.MyExcepcion;

import com.personalsoft.ges_sol_construccion.persistencia.dto.MaterialDto;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.Material;
import com.personalsoft.ges_sol_construccion.persistencia.repository.MaterialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author roagudelo
 */
@Repository
public class MaterialDao {

   @Autowired
    private MaterialRepository repositorio ;

   /**
     * Método Save encargado de Actualizar o crear el registro
     *
     * @param materialDto Obj MaterialDto
     * @return MaterialDto Obj
     * @throws AplicacionExcepcion para capturar los errores de las otras capaas y pasarlos al controller
   */
   public MaterialDto Save (MaterialDto materialDto )
        throws AplicacionExcepcion 
    {      
        // convierte el Dto a Entity y luego que lo guarda nuevamente convierte la Entity a Dto
        return getDtotoEntity(repositorio.save(getEntitytoDto(materialDto)));
    }
   
   /**
     * Método encargado de consultar el material por id registro y restorna un Dto con los datos requerido
     *
     * @param id_Material ideintificador unico del registr
     * @return Obj(MaterialDto)
     * @throws AplicacionExcepcion para capturar los errores de las otras capaas y pasarlos al controller
   */
   public MaterialDto getMaterialById (Long id_Material ) 
           throws AplicacionExcepcion
    {      
        Material material = new Material();
       if(Long.valueOf(id_Material)!=null)
        {
            material = repositorio.findById(id_Material).get();
        }else{
             throw new MyExcepcion(MensajeEstandar.ERROR_DATOS_CONSULTAR_ENTIDAD, "Material");
        }
       if (material == null)
       {
            throw new MyExcepcion(MensajeEstandar.ERROR_SIN_DATOS_CONSULTAR_ENTIDAD, "Material");
       } else {
           return getDtotoEntity(material);
       }
    }
   
   /**
     * Método encargado de consultar el material por id registro y codigo
     *
     * @param id_Material ideintificador unico del registr
     * @param cod_Material  codigo del material, el cual debe ser unico  
     * @return Entity(Material)
     * @throws AplicacionExcepcion para capturar los errores de las otras capaas y pasarlos al controller
   */
   public Material getMaterialByIdCod (Long id_Material , String cod_Material)
        throws AplicacionExcepcion 
    {      
        Material material = new Material();
       if(Long.valueOf(id_Material)!=null)
        {
            material = repositorio.findById(id_Material).get();
        }
        else if (cod_Material == null || cod_Material == ""){
            List<Material> lista = repositorio.findByCodMaterial(cod_Material);
            material = lista.get(0);
        }else{
             throw new MyExcepcion(MensajeEstandar.ERROR_DATOS_CONSULTAR_ENTIDAD, "Material");
        }
       if (material == null)
       {
            throw new MyExcepcion(MensajeEstandar.ERROR_SIN_DATOS_CONSULTAR_ENTIDAD, "Material");
       } else {
           return material ;
       }        
    }
    

    /**
     * Método encargado de convertir la entidad en Dto para enviarlo al servicio
     *
     * @param material objeto entidad
     * @return Obj(MaterialDto)
     */

    public MaterialDto getDtotoEntity (Material material)
    {
        MaterialDto materialDto = new MaterialDto();
        materialDto.setId(material.getId());
        materialDto.setCodMaterial(material.getCodMaterial());
        materialDto.setNomMaterial(material.getNomMaterial());
        materialDto.setCntMaterial(material.getCntMaterial());        
        return materialDto ;
    }
    /**
     * Método encargado de convertir el Dto a Entidad para ser procesado por la base de datos
     *
     * @param materialDto objeto de tipo Dto
     * @return Entity(Material)
     */
    public Material getEntitytoDto(MaterialDto materialDto) 
    {
        Material material = new Material();
        material.setId(materialDto.getId());
        material.setCodMaterial(materialDto.getCodMaterial());
        material.setNomMaterial(materialDto.getNomMaterial());
        material.setCntMaterial(materialDto.getCntMaterial()); 
        return material ;
    }    

}
