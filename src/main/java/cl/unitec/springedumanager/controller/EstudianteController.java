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


    @GetMapping("/estudiantes")
    public String listarEstudiantes(org.springframework.ui.Model model) {
        model.addAttribute("estudiantes", estudianteService.obtenerTodos());

        model.addAttribute("cursosTotales", cursoService.obtenerTodos()); 
        model.addAttribute("nuevoEstudiante", new Estudiante());
        return "estudiantes"; 
    }

    @PostMapping("/estudiantes/guardar")
    public String guardarEstudiante(@org.springframework.web.bind.annotation.ModelAttribute Estudiante estudiante) {
        estudianteService.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }


    @PostMapping("/estudiantes/inscribir")
    public String inscribir(@org.springframework.web.bind.annotation.RequestParam Long estudianteId, 
                            @org.springframework.web.bind.annotation.RequestParam(required = false) Long cursoId,
                            org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttrs) {

        if (cursoId == null) {
            redirectAttrs.addFlashAttribute("error", "No se puede inscribir: No hay cursos disponibles o no seleccionaste ninguno. Crea un curso primero.");
            return "redirect:/estudiantes";
        }
        
        try {
            estudianteService.inscribirCurso(estudianteId, cursoId);
            redirectAttrs.addFlashAttribute("success", "Estudiante inscrito en el curso exitosamente.");
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "Ocurrió un error al intentar inscribir al estudiante.");
        }
        
        return "redirect:/estudiantes";
    }
    
    @PostMapping("/estudiantes/eliminar")
    public String eliminarEstudiante(@org.springframework.web.bind.annotation.RequestParam Long id, 
                                     org.springframework.web.servlet.mvc.support.RedirectAttributes redirectAttrs) {
        try {
            estudianteService.eliminarEstudiante(id);
            redirectAttrs.addFlashAttribute("success", "Estudiante eliminado correctamente.");
        } catch (Exception e) {
            redirectAttrs.addFlashAttribute("error", "No se puede eliminar: El estudiante tiene evaluaciones o cursos asociados. Elimine sus registros primero.");
        }
        return "redirect:/estudiantes";
    }
}