package com.challenge9.Challenge9.repositorios;

import com.challenge9.Challenge9.entidades.Alumno;
import com.challenge9.Challenge9.entidades.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfesorRepositorio extends JpaRepository<Profesor,Long> {


    @Query(value = "SELECT * FROM profesor  WHERE profesor.activo = true", nativeQuery = true)
    List<Profesor> findAllByActivo();

    @Query(value = "SELECT * FROM profesor  WHERE profesor.id = :id AND profesor.activo = true", nativeQuery = true)
    Optional<Profesor> findByIdAndActivo(@Param("id") long id);

    @Query(value = "SELECT * FROM profesor WHERE profesor.nombre LIKE %:q% AND profesor.activo =true", nativeQuery = true)
    List<Profesor> findByNombre(@Param("q")String q);



}
