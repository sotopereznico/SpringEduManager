package cl.unitec.springedumanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cl.unitec.springedumanager.model.Estudiante;
import cl.unitec.springedumanager.service.EstudianteService;

@Controller
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;
    
    @Autowired
    private cl.unitec.springedumanager.service.CursoService cursoService;

    // Mostrar la página con la lista y el formulario
    @GetMapping("/estudiantes")
    public String listarEstudiantes(org.springframework.ui.Model model) {
        model.addAttribute("estudiantes", estudianteService.obtenerTodos());
        // Enviamos todos los cursos para el menú desplegable
        model.addAttribute("cursosTotales", cursoService.obtenerTodos()); 
        model.addAttribute("nuevoEstudiante", new Estudiante());
        return "estudiantes"; // Ojo: renombramos la vista a "estudiantes"
    }

    @PostMapping("/estudiantes/guardar")
    public String guardarEstudiante(@org.springframework.web.bind.annotation.ModelAttribute Estudiante estudiante) {
        estudianteService.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    // Nuevo método para procesar la inscripción de un alumno a un curso
    @PostMapping("/estudiantes/inscribir")
    public String inscribir(@org.springframework.web.bind.annotation.RequestParam Long estudianteId, 
                            @org.springframework.web.bind.annotation.RequestParam Long cursoId) {
        estudianteService.inscribirCurso(estudianteId, cursoId);
        return "redirect:/estudiantes";
    }
    @PostMapping("/estudiantes/eliminar")
    public String eliminarEstudiante(@org.springframework.web.bind.annotation.RequestParam Long id) {
        estudianteService.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}