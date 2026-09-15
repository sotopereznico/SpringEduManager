package cl.unitec.springedumanager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.unitec.springedumanager.model.Curso;
import cl.unitec.springedumanager.model.Estudiante;
import cl.unitec.springedumanager.repository.EstudianteRepository;

@Service
public class EstudianteService {


	@Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private cl.unitec.springedumanager.repository.CursoRepository cursoRepository;

	public void guardarEstudiante(Estudiante estudiante) {
		estudianteRepository.save(estudiante);
	}
	public void inscribirCurso(Long estudianteId, Long cursoId) {
	    Estudiante estudiante = estudianteRepository.findById(estudianteId).orElseThrow();
	    Curso curso = cursoRepository.findById(cursoId).orElseThrow();
	    if(!estudiante.getCursos().contains(curso)) {
	        estudiante.getCursos().add(curso);
	        estudianteRepository.save(estudiante);
	    }
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
	public void eliminarEstudiante(Long id) {
	    estudianteRepository.deleteById(id);
	}
}