package cl.unitec.springedumanager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.unitec.springedumanager.model.Estudiante;
import cl.unitec.springedumanager.repository.EstudianteRepository;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	public void guardarEstudiante(Estudiante estudiante) {
		estudianteRepository.save(estudiante);
	}

	public List<Estudiante> obtenerTodos() {
		return estudianteRepository.findAll();
	}

	public java.util.List<cl.unitec.springedumanager.dto.EstudianteDTO> obtenerTodosDTO() {
		java.util.List<cl.unitec.springedumanager.model.Estudiante> estudiantes = estudianteRepository.findAll();
		java.util.List<cl.unitec.springedumanager.dto.EstudianteDTO> dtos = new java.util.ArrayList<>();

		for (cl.unitec.springedumanager.model.Estudiante est : estudiantes) {
			dtos.add(new cl.unitec.springedumanager.dto.EstudianteDTO(est.getId(), est.getNombre(), est.getApellido(),
					est.getEmail()));
		}
		return dtos;
	}
}