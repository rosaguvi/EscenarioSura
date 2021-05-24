package com.personalsoft.ges_sol_construccion.persistencia.repository;


import com.personalsoft.ges_sol_construccion.persistencia.entidades.Material;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.SolConstruccion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolConstRepository extends JpaRepository<SolConstruccion, Long>
{
    List<SolConstruccion> findByCorxConstruccionAndCoryConstruccion (Double cor_x , Double cor_y);     
}