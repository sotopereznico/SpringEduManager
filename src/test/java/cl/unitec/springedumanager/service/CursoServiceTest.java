package cl.unitec.springedumanager.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.unitec.springedumanager.model.Curso;
import cl.unitec.springedumanager.repository.CursoRepository;

@ExtendWith(MockitoExtension.class)
public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @Test
    void testGuardarYELiminarCurso() {
        Curso c = new Curso();
        cursoService.guardarCurso(c);
        verify(cursoRepository, times(1)).save(c);

        cursoService.eliminarCurso(1L);
        verify(cursoRepository, times(1)).deleteById(1L);
    }
}