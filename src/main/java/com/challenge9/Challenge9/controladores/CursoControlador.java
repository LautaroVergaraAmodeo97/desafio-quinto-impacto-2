package com.challenge9.Challenge9.controladores;

import com.challenge9.Challenge9.entidades.Alumno;
import com.challenge9.Challenge9.entidades.Curso;
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
public class CursoControlador {

    @Autowired
    private ServicioCurso servicioCurso;

    @GetMapping("/muestra")
    public String crudCurso(Model model){
        try{
            List<Curso> cursos = this.servicioCurso.findAll();
            model.addAttribute("cursos",cursos);
            return "crud_curso";
        }catch (Exception e){
            model.addAttribute("mensaje",e.getMessage());
            return "error";
        }
    }

    @GetMapping("/formulario/curso/{id}")
    public String formularioCurso(Model model, @PathVariable("id") long id){
        try{
            if(id==0){
                model.addAttribute("cursos",new Curso());
            }else{
                model.addAttribute("cursos",this.servicioCurso.findById(id));
            }
            return "formulario_curso";
        }catch (Exception e){
            model.addAttribute("mensaje",e.getMessage());
            return "error";
        }
    }

    @PostMapping("/formulario/curso/{id}")
    public String guardarCurso(@ModelAttribute("cursos")Curso curso, Model model, @PathVariable("id") long id){
        try{
            if(id==0){
                this.servicioCurso.guardar(curso);
            }else{
                this.servicioCurso.actualizar(curso,id);
            }
            return "redirect:/crud_curso";
        }catch (Exception e){
            model.addAttribute("mensaje",e.getMessage());
            return "error";

        }
    }

    @GetMapping("/eliminar/curso/{id}")
    public String eliminarCurso(Model model,@PathVariable("id") long id){
        try{
            model.addAttribute("cursos",this.servicioCurso.findById(id));
            return "eliminar_curso";
        }catch(Exception e){
            model.addAttribute("mensaje",e.getMessage());
            return "error";
        }
    }


}
