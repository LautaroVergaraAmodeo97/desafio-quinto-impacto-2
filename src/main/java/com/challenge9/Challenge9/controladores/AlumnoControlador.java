package com.challenge9.Challenge9.controladores;

import com.challenge9.Challenge9.entidades.Alumno;
import com.challenge9.Challenge9.servicios.ServicioAlumno;
import com.challenge9.Challenge9.servicios.ServicioCurso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AlumnoControlador {

    @Autowired
    private ServicioAlumno servicioAlumno;

    @Autowired
    private ServicioCurso servicioCurso;

    @GetMapping("/")
    public String inicio (Model model){
        try{
            List<Alumno> alumnos = this.servicioAlumno.findAllByActivo();
            model.addAttribute("alumnos",alumnos);
            return "inicio";
        }catch (Exception e){
            model.addAttribute("mensaje",e.getMessage());
            return "error";
        }
    }

    @GetMapping("/crud")
    public String crudAlumnos(Model model){
        try{
            List<Alumno> alumnos = this.servicioAlumno.findAll();
            model.addAttribute("alumnos",alumnos);
            return "crud_alumnos";
        }catch (Exception e){
            model.addAttribute("mensaje",e.getMessage());
            return "error";
        }
    }

    @GetMapping("/formulario/alumno/{id}")
    public String formularioAlumnos(Model model, @PathVariable("id") long id){
        try{
             model.addAttribute("curso",this.servicioCurso.findAll());
            if(id==0){
                model.addAttribute("alumnos",new Alumno());
            }else{
                model.addAttribute("alumnos",this.servicioAlumno.findById(id));
            }
            return "formulario_alumno";
        }catch (Exception e){
            model.addAttribute("mensaje",e.getMessage());
            return "error";
        }
    }


    @PostMapping("/formulario/alumno/{id}")
    public String guardarAlumno(@ModelAttribute("alumno")Alumno alumno, Model model, @PathVariable("id") long id){
        try{
            if(id==0){
                this.servicioAlumno.guardar(alumno);
            }else{
                this.servicioAlumno.actualizar(alumno,id);
            }
            return "redirect:/crud_alumnos";
        }catch (Exception e){
            model.addAttribute("mensaje",e.getMessage());
            return "error";

        }
    }


    @GetMapping("/eliminar/alumno/{id}")
    public String eliminarAlumno(Model model,@PathVariable("id") long id){

    try{
        model.addAttribute("alumnos",this.servicioAlumno.findById(id));
        return "eliminar_alumno";
    }catch(Exception e){
        model.addAttribute("mensaje",e.getMessage());
        return "error";
    }
    }


}
