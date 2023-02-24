package com.challenge9.Challenge9.servicios;

import com.challenge9.Challenge9.entidades.Alumno;
import com.challenge9.Challenge9.entidades.Curso;
import com.challenge9.Challenge9.repositorios.CursoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioCurso implements ServicioBase<Curso> {

    @Autowired
    private CursoRepositorio cursoRepositorio;


    @Override
    @Transactional
    public List<Curso> findAll() throws Exception {

        try {
            List<Curso> entities = this.cursoRepositorio.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional
    public Curso findById(long id) throws Exception {
        try {
            Optional<Curso> opt = this.cursoRepositorio.findById(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Curso guardar(Curso entity) throws Exception {

        try {
            Curso curso = this.cursoRepositorio.save(entity);
            return curso;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }


    }

    @Override
    @Transactional
    public Curso actualizar(Curso entity, long id) throws Exception {
        try {
            Optional<Curso> opt = this.cursoRepositorio.findById(id);
            Curso curso = opt.get();
            curso = this.cursoRepositorio.save(entity);
            return curso;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean borrar(long id) throws Exception {

        try {
            Optional<Curso> opt = this.cursoRepositorio.findById(id);
            if (!opt.isEmpty()) {
                Curso curso = opt.get();
                curso.setActivo(!curso.isActivo());
                this.cursoRepositorio.save(curso);
            } else {
                throw new Exception();
            }
            return true;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


    @Transactional
    public List<Curso> findAllByActivo() throws Exception{
        try {
            List<Curso> entities = this.cursoRepositorio.findAllByActivo();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public Curso findByIdAndActivo(long id) throws Exception {
        try {
            Optional<Curso> opt = this.cursoRepositorio.findByIdAndActivo(id);
            return opt.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Transactional
    public List<Curso> findByNombre(String q) throws Exception{
        try{
            List<Curso> entities = this.cursoRepositorio.findByNombre(q);
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }


}


