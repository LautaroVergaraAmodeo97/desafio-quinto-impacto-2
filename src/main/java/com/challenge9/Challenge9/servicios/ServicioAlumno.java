package com.challenge9.Challenge9.servicios;

import com.challenge9.Challenge9.entidades.Alumno;
import com.challenge9.Challenge9.repositorios.AlumnoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioAlumno implements ServicioBase<Alumno> {

    @Autowired
    private AlumnoRepositorio alumnoRepositorio;

    @Transactional
    @Override
    public List<Alumno> findAll() throws Exception {
        try{
            List<Alumno> entities = this.alumnoRepositorio.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Alumno findById(long id) throws Exception {
        try{
            Optional<Alumno> opt = this.alumnoRepositorio.findById(id);
            return opt.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Alumno guardar(Alumno entity) throws Exception {
        try{
            Alumno alumno = this.alumnoRepositorio.save(entity);
            return alumno;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Alumno actualizar(Alumno entity, long id) throws Exception {
        try {
            Optional<Alumno> opt = this.alumnoRepositorio.findById(id);
            Alumno alumno = opt.get();
            alumno = this.alumnoRepositorio.save(entity);
            return alumno;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean borrar(long id) throws Exception {
        try{
            Optional<Alumno> opt = this.alumnoRepositorio.findById(id);
            if(!opt.isEmpty()){
                Alumno alumno = opt.get();
                alumno.setActivo(!alumno.isActivo());
                this.alumnoRepositorio.save(alumno);
            }else{
                throw new Exception();
            }
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }



    @Transactional
    public List<Alumno> findAllByActivo() throws Exception{
        try {
            List<Alumno> entities = this.alumnoRepositorio.findAllByActivo();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Alumno findByIdAndActivo(long id) throws Exception {
        try {
            Optional<Alumno> opt = this.alumnoRepositorio.findByIdAndActivo(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Alumno> findByNombre(String q) throws Exception{
        try{
            List<Alumno> entities = this.alumnoRepositorio.findByNombre(q);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
