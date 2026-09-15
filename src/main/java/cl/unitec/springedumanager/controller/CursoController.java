package cl.unitec.springedumanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cl.unitec.springedumanager.model.Curso;
import cl.unitec.springedumanager.service.CursoService;

@Controller
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/cursos")
    public String listarCursos(Model model) {
        model.addAttribute("cursos", cursoService.obtenerTodos());
        model.addAttribute("nuevoCurso", new Curso());
        return "lista-cursos";
    }

    @PostMapping("/cursos/guardar")
    public String guardarCurso(@ModelAttribute Curso curso) {
        cursoService.guardarCurso(curso);
        return "redirect:/cursos";
    }
    @PostMapping("/cursos/eliminar")
    public String eliminarCurso(@org.springframework.web.bind.annotation.RequestParam Long id) {
        cursoService.eliminarCurso(id);
        return "redirect:/cursos";
    }
}