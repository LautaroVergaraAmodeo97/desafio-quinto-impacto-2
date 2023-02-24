package com.challenge9.Challenge9.servicios;

import com.challenge9.Challenge9.entidades.Alumno;
import com.challenge9.Challenge9.entidades.Profesor;
import com.challenge9.Challenge9.repositorios.ProfesorRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioProfesor implements ServicioBase<Profesor> {

    @Autowired
    private ProfesorRepositorio profesorRepositorio;

    @Override
    @Transactional
    public List<Profesor> findAll() throws Exception {

        try{
            List<Profesor> entities = this.profesorRepositorio.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Override
    @Transactional
    public Profesor findById(long id) throws Exception {
        try{

            Optional<Profesor> opt = this.profesorRepositorio.findById(id);
            return opt.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Profesor guardar(Profesor entity) throws Exception {
        try{
            Profesor profesor = this.profesorRepositorio.save(entity);
            return profesor;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Profesor actualizar(Profesor entity, long id) throws Exception {

        try{
            Optional<Profesor> opt = this.profesorRepositorio.findById(id);
            Profesor profesor = opt.get();
            profesor = this.profesorRepositorio.save(entity);
            return profesor;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean borrar(long id) throws Exception {

        try{

            Optional<Profesor> opt = this.profesorRepositorio.findById(id);
            if(!opt.isEmpty()){

                Profesor profesor = opt.get();
                profesor.setActivo(!profesor.isActivo());
                this.profesorRepositorio.save(profesor);
            }else{
                throw new Exception();
            }
            return true;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }



    @Transactional
    public List<Profesor> findAllByActivo() throws Exception{
        try {
            List<Profesor> entities = this.profesorRepositorio.findAllByActivo();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Profesor findByIdAndActivo(long id) throws Exception {
        try {
            Optional<Profesor> opt = this.profesorRepositorio.findByIdAndActivo(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Profesor> findByNombre(String q) throws Exception{
        try{
            List<Profesor> entities = this.profesorRepositorio.findByNombre(q);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }









}
