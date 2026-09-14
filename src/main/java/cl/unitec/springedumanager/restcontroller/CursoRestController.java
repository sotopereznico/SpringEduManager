package cl.unitec.springedumanager.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.unitec.springedumanager.model.Curso;
import cl.unitec.springedumanager.service.CursoService;

@RestController
@RequestMapping("/api/cursos")
public class CursoRestController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listarTodos() {
        return cursoService.obtenerTodos();
    }

    @PostMapping
    public void guardar(@RequestBody Curso curso) {
        cursoService.guardarCurso(curso);
    }
}