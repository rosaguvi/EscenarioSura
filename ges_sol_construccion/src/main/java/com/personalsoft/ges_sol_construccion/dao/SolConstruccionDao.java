package com.personalsoft.ges_sol_construccion.dao;

import com.personalsoft.ges_sol_construccion.estandar.clases.AplicacionExcepcion;
import com.personalsoft.ges_sol_construccion.estandar.clases.MensajeEstandar;
import com.personalsoft.ges_sol_construccion.estandar.clases.MyExcepcion;
import com.personalsoft.ges_sol_construccion.persistencia.dto.SolConstruccionDto;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.SolConstruccion;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.TipConstruccion;
import com.personalsoft.ges_sol_construccion.persistencia.repository.SolConstRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * Clase que se encarga de organizar los objetos de tipo SolConstruccion para ser consultado o enviados a la base de datos
 * @author roagudelo
*/
@Repository
public class SolConstruccionDao {

   @Autowired
    private SolConstRepository repositorio ;
   @Autowired
    private TipConstruccionDao daoTipCons ;
 
     /**
     * Método que lista todas las solicitudes creadas
     * 
     * @return List de SolConstruccionDto
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public List<SolConstruccionDto> ListarTodos() 
            throws AplicacionExcepcion 
    {
        List<SolConstruccion> lista = repositorio.findAll();
        
        return getListDtotoListEntity(lista);
       
    }    
     /**
     * Método create encargado de guardar registros de la solicitud de Construccion
     * @param solConst(SolConstruccionDto)
     * @return SolConstruccionDto
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public SolConstruccionDto create(SolConstruccionDto solConst) 
            throws AplicacionExcepcion 
    {
        // se agrega el estado para garantizar que sea pendiente
        solConst.setEstSolconstriuccion("Pendiente");
        // se convierte a entidad para enviar a la base de datos y luego la respuesta a Dto para retornarlo al servicio
        return getDtotoEntity(repositorio.save(getEntitytoDto(solConst)));
    }    
    /**
     * Método getTipConstByUbicacion encargado de consultar el tipo de construccion por la coordenada enviada
     *
     * @param cor_x ideintificador unico del registr
     * @param cor_y  codigo del material, el cual debe ser unico  
     * @return SolConstruccionDto
     * 
   */
    
    public SolConstruccionDto getTipConstByUbicacion (Double cor_x , Double cor_y)
    {     
        List<SolConstruccion> lista = repositorio.findByCorxConstruccionAndCoryConstruccion(cor_x ,cor_y);
        if (!lista.isEmpty())
        {
            return getDtotoEntity(lista.get(0));
        }
        return null ;
    }
    
     /**
     * Método encargado de consultar la solicitud de construccion por id registro
     * @param id_solcons ideintificador unico del registro
     * @return SolConstruccion Entity 
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
   */
    public SolConstruccion buscarPorId (Long id_solcons )
        throws AplicacionExcepcion 
    {  
        SolConstruccion solCons = new SolConstruccion();
       if(Long.valueOf(id_solcons)!=null)
        {
            solCons = repositorio.findById(id_solcons).get();
        }else{
            System.out.println("ERROR_DATOS_CONSULTAR_ENTIDAD");
             throw new MyExcepcion(MensajeEstandar.ERROR_DATOS_CONSULTAR_ENTIDAD, "SolConstruccion");
        }
       if (solCons == null)
       {      
            System.out.println("ERROR_SIN_DATOS_CONSULTAR_ENTIDAD");
           throw new MyExcepcion(MensajeEstandar.ERROR_SIN_DATOS_CONSULTAR_ENTIDAD, "SolConstruccion");
       } else {
           return solCons ;
       }
    }   
     /**
     * Método encargado de convertir la entidad en Dto para enviarlo al servicio
     *
     * @param solConst Entity(SolConstruccion)
     * @return Obj(SolConstruccionDto)
     *  
     */

    public SolConstruccionDto getDtotoEntity (SolConstruccion solConst)
    {
        SolConstruccionDto solConsDto = new SolConstruccionDto();
        solConsDto.setCorxConstruccion(solConst.getCorxConstruccion());
        solConsDto.setCoryConstruccion(solConst.getCoryConstruccion());
        solConsDto.setEstSolconstriuccion(solConst.getEstSolconstriuccion());
        solConsDto.setIdSolicitud(solConst.getId());
        solConsDto.setIdTipConstruccion(solConst.getTipConstruccion().getId());
        solConsDto.setTipConsNombre(solConst.getTipConstruccion().getNomTipconstruccion());
        return solConsDto ;
    }
    /**
     * Método encargado de convertir el Dto a Entidad para ser procesado por la base de datos
     *
     * @param  solConsDto Obj(SolConstruccionDto)
     * @return Entity(SolConstruccion)
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public SolConstruccion getEntitytoDto(SolConstruccionDto solConsDto) 
            throws AplicacionExcepcion
    {
        SolConstruccion solCons = new SolConstruccion();
        TipConstruccion tipCons = daoTipCons.getTipConstByIdNom(solConsDto.getIdTipConstruccion(), solConsDto.getTipConsNombre());       
        solCons.setTipConstruccion(tipCons);
        solCons.setCorxConstruccion(solConsDto.getCorxConstruccion());
        solCons.setCoryConstruccion(solConsDto.getCoryConstruccion());
        solCons.setId(solConsDto.getIdSolicitud());
        solCons.setEstSolconstriuccion(solConsDto.getEstSolconstriuccion());
        return solCons ;
    }

     /**
     * Método encargado de convertir una lista de Dto´s a una Listado de Entidad´s 
     * @param solicitudesConsDto list(SolConstruccionDto)
     * @return List(SolConstruccion)
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public List<SolConstruccion> getListEntitytoListDto(List<SolConstruccionDto> solicitudesConsDto) 
            throws AplicacionExcepcion
    {
        List<SolConstruccion> solicitudesCons = new ArrayList<>();
        for (SolConstruccionDto solicitudConsDto: solicitudesConsDto) {
            solicitudesCons.add(getEntitytoDto(solicitudConsDto));
        }         
        return solicitudesCons ;
    }
    /**
     * Método encargado de convertir una lista de Entity´s a una Listado de Dto´s
     * @param solicitudesCons list(SolConstruccionDto)
     * @return List(SolConstruccion)
     * @throws AplicacionExcepcion para trasladar el manejo de los errores a la capa de servicio
     */
    public List<SolConstruccionDto> getListDtotoListEntity(List<SolConstruccion> solicitudesCons) 
            throws AplicacionExcepcion
    {
        List<SolConstruccionDto> solicitudesConsDto = new ArrayList<>();
        for (SolConstruccion solicitudCons: solicitudesCons) {
            solicitudesConsDto.add(getDtotoEntity(solicitudCons));
        }         
        return solicitudesConsDto ;
    }
}
