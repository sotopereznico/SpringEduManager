package cl.unitec.springedumanager.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class EstudianteDTOTest {

    @Test
    public void probarCreacionEstudianteDTO() {
        // Preparamos los datos
        Long idEsperado = 1L;
        String nombreEsperado = "Nicolás";
        String apellidoEsperado = "Soto";
        String emailEsperado = "nicolas@correo.cl";

        // Ejecutamos la acción (Crear el objeto)
        EstudianteDTO estudiante = new EstudianteDTO(idEsperado, nombreEsperado, apellidoEsperado, emailEsperado);

        // Validamos que los datos se asignaron correctamente
        assertEquals(idEsperado, estudiante.getId());
        assertEquals(nombreEsperado, estudiante.getNombre());
        assertEquals(emailEsperado, estudiante.getEmail());
    }
}