package com.personalsoft.ges_sol_construccion.persistencia.repository;


import com.personalsoft.ges_sol_construccion.persistencia.entidades.TipConstruccion;
import com.personalsoft.ges_sol_construccion.persistencia.entidades.TipconsMaterial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipConstMateRepository extends JpaRepository<TipconsMaterial, Long>
{
    List<TipConstruccion> findByTipConstruccion(Long tipconstruccion_id);
    
}