package com.personalsoft.ges_sol_construccion.persistencia.repository;


import com.personalsoft.ges_sol_construccion.persistencia.entidades.TipConstruccion;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipConstRepository extends JpaRepository<TipConstruccion, Long>
{
    List<TipConstruccion> findByNomTipconstruccion(String nomTipconstruccion);
    
}