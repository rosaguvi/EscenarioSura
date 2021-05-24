package com.personalsoft.ges_sol_construccion.persistencia.repository;


import com.personalsoft.ges_sol_construccion.persistencia.entidades.TipconsMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipconsMatRepository extends JpaRepository<TipconsMaterial, Long>
{

    
}