package com.personalsoft.ges_sol_construccion.persistencia.repository;


import com.personalsoft.ges_sol_construccion.persistencia.entidades.Material;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends JpaRepository<Material, Long>
{
    List<Material> findByCodMaterial(String Cod_material); 
}