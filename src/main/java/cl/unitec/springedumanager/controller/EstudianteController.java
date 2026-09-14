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

    // Mostrar la página con la lista y el formulario
    @GetMapping("/estudiantes")
    public String listarEstudiantes(Model model) {
        model.addAttribute("estudiantes", estudianteService.obtenerTodos());
        model.addAttribute("nuevoEstudiante", new Estudiante());
        return "lista-estudiantes"; // Nombre del archivo HTML
    }

    // Recibir los datos del formulario y guardarlos
    @PostMapping("/estudiantes/guardar")
    public String guardarEstudiante(@ModelAttribute Estudiante estudiante) {
        estudianteService.guardarEstudiante(estudiante);
        return "redirect:/estudiantes"; // Recarga la página
    }
}