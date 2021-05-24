package com.personalsoft.ges_sol_construccion.persistencia.repository;

import com.personalsoft.ges_sol_construccion.persistencia.entidades.OrdConstruccion;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdConstRepository extends JpaRepository<OrdConstruccion, Long>
{
    List<OrdConstruccion> findTopByOrderByIdDesc();     
    List<OrdConstruccion> findByFeciniConstruccionEquals(Date fec_ini);     
    List<OrdConstruccion> findByFecfinConstruccionEquals(Date fec_fin);     
    List<OrdConstruccion> findByEstConstruccionEquals(String estado);     
}