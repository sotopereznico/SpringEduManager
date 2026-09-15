package cl.unitec.springedumanager.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class EvaluacionTest {
    @Test
    void testEvaluacionGettersYSetters() {
        Evaluacion ev = new Evaluacion();
        ev.setId(1L);
        ev.setTitulo("Prueba 1");
        ev.setNota(6.5);
        
        Curso c = new Curso();
        c.setNombre("Java");
        ev.setCurso(c);
        
        Estudiante e = new Estudiante();
        e.setNombre("Nicolás");
        ev.setEstudiante(e);

        assertEquals(1L, ev.getId());
        assertEquals("Prueba 1", ev.getTitulo());
        assertEquals(6.5, ev.getNota());
        assertNotNull(ev.getCurso());
        assertNotNull(ev.getEstudiante());
    }
}