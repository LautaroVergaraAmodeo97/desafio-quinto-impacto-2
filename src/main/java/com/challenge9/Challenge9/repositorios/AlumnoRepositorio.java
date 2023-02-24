package com.challenge9.Challenge9.repositorios;

import com.challenge9.Challenge9.entidades.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepositorio extends JpaRepository<Alumno,Long> {

    @Query(value = "SELECT * FROM alumno  WHERE alumno.activo = true", nativeQuery = true)
    List<Alumno> findAllByActivo();

    @Query(value = "SELECT * FROM alumno  WHERE alumno.id = :id AND alumno.activo = true", nativeQuery = true)
    Optional<Alumno> findByIdAndActivo(@Param("id") long id);

    @Query(value = "SELECT * FROM alumno WHERE alumno.nombre LIKE %:q% AND alumno.activo =true", nativeQuery = true)
    List<Alumno> findByNombre(@Param("q")String q);

}
