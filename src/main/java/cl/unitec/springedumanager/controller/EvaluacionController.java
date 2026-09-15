package cl.unitec.springedumanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.unitec.springedumanager.model.Evaluacion;
import cl.unitec.springedumanager.service.CursoService;
import cl.unitec.springedumanager.service.EstudianteService;
import cl.unitec.springedumanager.service.EvaluacionService;

@Controller
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;
    
    @Autowired
    private CursoService cursoService;

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/evaluaciones")
    public String listarEvaluaciones(Model model) {
        model.addAttribute("evaluaciones", evaluacionService.obtenerTodas());
        model.addAttribute("cursosTotales", cursoService.obtenerTodos());
        model.addAttribute("estudiantesTotales", estudianteService.obtenerTodos());
        model.addAttribute("nuevaEvaluacion", new Evaluacion());
        return "evaluaciones"; 
    }

  
    @PostMapping("/evaluaciones/guardar")
    public String guardarEvaluacion(@ModelAttribute Evaluacion evaluacion) {
        evaluacionService.guardarEvaluacion(evaluacion);
        return "redirect:/evaluaciones";
    }


    @PostMapping("/evaluaciones/eliminar")
    public String eliminarEvaluacion(@RequestParam Long id) {
        evaluacionService.eliminarEvaluacion(id);
        return "redirect:/evaluaciones";
    }
}