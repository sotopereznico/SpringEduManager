package cl.unitec.springedumanager.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class EstudianteTest {
    @Test
    void testEstudianteGettersYSetters() {
        Estudiante est = new Estudiante();
        est.setId(1L);
        est.setNombre("Nicolás");
        est.setEmail("nico@correo.cl");
        est.setCursos(new ArrayList<>());

        assertEquals(1L, est.getId());
        assertEquals("Nicolás", est.getNombre());
        assertEquals("nico@correo.cl", est.getEmail());
        assertNotNull(est.getCursos());
    }
}