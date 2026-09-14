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
    public java.util.List<cl.unitec.springedumanager.dto.EstudianteDTO> listarTodos() {
        return estudianteService.obtenerTodosDTO();
    }
    
    @Autowired
    private cl.unitec.springedumanager.integration.CampusIntegrationService integracionService;

    // Endpoint para guardar un estudiante enviando un JSON
    @PostMapping
    public void guardar(@RequestBody Estudiante estudiante) {
        estudianteService.guardarEstudiante(estudiante);
    }
    
 // Endpoint para probar la interoperabilidad con RestTemplate
    @GetMapping("/integracion")
    public java.util.List<cl.unitec.springedumanager.dto.EstudianteDTO> probarInteroperabilidad() {
        return integracionService.obtenerEstudiantesDesdeCampus();
    }
}