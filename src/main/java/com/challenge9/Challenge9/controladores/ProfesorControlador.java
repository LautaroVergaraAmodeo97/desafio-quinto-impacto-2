package com.challenge9.Challenge9.controladores;

import com.challenge9.Challenge9.entidades.Alumno;
import com.challenge9.Challenge9.entidades.Curso;
import com.challenge9.Challenge9.entidades.Profesor;
import com.challenge9.Challenge9.repositorios.CursoRepositorio;
import com.challenge9.Challenge9.repositorios.ProfesorRepositorio;
import com.challenge9.Challenge9.servicios.ServicioCurso;
import com.challenge9.Challenge9.servicios.ServicioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProfesorControlador {

    @Autowired
    private ServicioProfesor profesorServicio;
    @Autowired
    private ServicioCurso cursoServicio;


    @GetMapping("/demostracion")
    public String crudProfesor(Model model){
        try{
            List<Profesor> profesor = this.profesorServicio.findAll();
            model.addAttribute("profesor",profesor);
            return "crud_profesor";
        }catch (Exception e){
            model.addAttribute("mensaje",e.getMessage());
            return "error";
        }
    }

    @GetMapping("/formulario/profesor/{id}")
    public String formularioProfesor(Model model, @PathVariable("id") long id){
        try{
            model.addAttribute("curso",this.cursoServicio.findAll());
            if(id==0){
                model.addAttribute("profesor",new Profesor());
            }else{
                model.addAttribute("profesor",this.profesorServicio.findById(id));
            }
            return "formulario_profesor";
        }catch (Exception e){
            model.addAttribute("mensaje",e.getMessage());
            return "error";
        }
    }


    @PostMapping("/formulario/profesor/{id}")
    public String guardarProfesor(@ModelAttribute("profesor")Profesor profesor, Model model, @PathVariable("id") long id){
        try{
            if(id==0){
                this.profesorServicio.guardar(profesor);
            }else{
                this.profesorServicio.actualizar(profesor,id);
            }
            return "redirect:/crud_profesor";
        }catch (Exception e){
            model.addAttribute("mensaje",e.getMessage());
            return "error";

        }
    }

    @GetMapping("/eliminar/profesor/{id}")
    public String eliminarProfesor(Model model,@PathVariable("id") long id){

        try{
            model.addAttribute("profesor",this.profesorServicio.findById(id));
            return "eliminar_profesor";
        }catch(Exception e){
            model.addAttribute("mensaje",e.getMessage());
            return "error";
        }
    }




}
