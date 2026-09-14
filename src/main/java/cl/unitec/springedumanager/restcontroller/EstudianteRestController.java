package cl.unitec.springedumanager.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.unitec.springedumanager.model.Estudiante;
import cl.unitec.springedumanager.service.EstudianteService;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteRestController {

    @Autowired
    private EstudianteService estudianteService;

    // Endpoint para obtener todos los estudiantes en formato JSON
    @GetMapping
    public List<Estudiante> listarTodos() {
        return estudianteService.obtenerTodos();
    }

    // Endpoint para guardar un estudiante enviando un JSON
    @PostMapping
    public void guardar(@RequestBody Estudiante estudiante) {
        estudianteService.guardarEstudiante(estudiante);
    }
}