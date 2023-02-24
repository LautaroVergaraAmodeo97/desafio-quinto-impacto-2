package com.challenge9.Challenge9.repositorios;

import com.challenge9.Challenge9.entidades.Alumno;
import com.challenge9.Challenge9.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepositorio extends JpaRepository <Curso,Long> {


    @Query(value = "SELECT * FROM curso  WHERE curso.activo = true", nativeQuery = true)
    List<Curso> findAllByActivo();

    @Query(value = "SELECT * FROM curso  WHERE curso.id = :id AND curso.activo = true", nativeQuery = true)
    Optional<Curso> findByIdAndActivo(@Param("id") long id);

    @Query(value = "SELECT * FROM curso WHERE curso.nombre LIKE %:q% AND curso.activo =true", nativeQuery = true)
    List<Curso> findByNombre(@Param("q")String q);



}
