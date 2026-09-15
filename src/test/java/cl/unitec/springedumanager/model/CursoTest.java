package cl.unitec.springedumanager.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CursoTest {
    @Test
    void testCursoGettersYSetters() {
        Curso curso = new Curso();
        curso.setId(1L);
        curso.setCodigo("SPR-M6");
        curso.setNombre("Spring Boot");
        curso.setDescripcion("Curso backend");

        assertEquals(1L, curso.getId());
        assertEquals("SPR-M6", curso.getCodigo());
        assertEquals("Spring Boot", curso.getNombre());
        assertEquals("Curso backend", curso.getDescripcion());
    }
}