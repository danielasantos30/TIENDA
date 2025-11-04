package com.tienda.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.tienda.entity.CategoriaEntity;

public interface ICategoriaRepository extends JpaRepository<CategoriaEntity, Integer>{

}
