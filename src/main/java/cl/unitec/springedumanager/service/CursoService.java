package cl.unitec.springedumanager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.unitec.springedumanager.model.Curso;
import cl.unitec.springedumanager.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public void guardarCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}