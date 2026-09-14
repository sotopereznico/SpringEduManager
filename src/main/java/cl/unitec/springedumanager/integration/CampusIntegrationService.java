package cl.unitec.springedumanager.integration;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import cl.unitec.springedumanager.dto.EstudianteDTO;

@Service
public class CampusIntegrationService {

    @Autowired
    private RestTemplate restTemplate;

    // Método que actúa como un cliente externo consumiendo nuestra propia API
    public List<EstudianteDTO> obtenerEstudiantesDesdeCampus() {
        // Simulamos que le pegamos a una API externa (en este caso, la nuestra)
        String urlExterna = "http://localhost:8080/api/estudiantes";
        
        // RestTemplate hace la petición GET y convierte el JSON resultante en un arreglo de DTOs
        EstudianteDTO[] estudiantesArray = restTemplate.getForObject(urlExterna, EstudianteDTO[].class);
        
        return Arrays.asList(estudiantesArray);
    }
}