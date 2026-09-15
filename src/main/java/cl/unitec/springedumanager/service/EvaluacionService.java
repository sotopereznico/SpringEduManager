package cl.unitec.springedumanager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.unitec.springedumanager.model.Evaluacion;
import cl.unitec.springedumanager.repository.EvaluacionRepository;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    // Método para obtener todas las evaluaciones de la base de datos
    public List<Evaluacion> obtenerTodas() {
        return evaluacionRepository.findAll();
    }

    // Método para guardar una nueva evaluación
    public void guardarEvaluacion(Evaluacion evaluacion) {
        evaluacionRepository.save(evaluacion);
    }
    public void eliminarEvaluacion(Long id) {
        evaluacionRepository.deleteById(id);
    }
}