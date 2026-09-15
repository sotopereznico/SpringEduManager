package cl.unitec.springedumanager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import cl.unitec.springedumanager.model.Estudiante;
import cl.unitec.springedumanager.repository.EstudianteRepository;

@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {

    @Mock
    private EstudianteRepository estudianteRepository;

    @InjectMocks
    private EstudianteService estudianteService;

    @Test
    void testObtenerTodos() {
        // Simulamos la respuesta de la base de datos
        Estudiante e1 = new Estudiante();
        e1.setNombre("Daniel");
        when(estudianteRepository.findAll()).thenReturn(Arrays.asList(e1));

        // Ejecutamos el servicio
        List<Estudiante> resultado = estudianteService.obtenerTodos();

        // Validamos
        assertEquals(1, resultado.size());
        assertEquals("Daniel", resultado.get(0).getNombre());
    }

    @Test
    void testGuardarEstudiante() {
        Estudiante e = new Estudiante();
        e.setNombre("Cristina");
        estudianteService.guardarEstudiante(e);
        
        // Verificamos que el servicio haya llamado al repositorio exactamente 1 vez
        verify(estudianteRepository, times(1)).save(e);
    }

    @Test
    void testEliminarEstudiante() {
        estudianteService.eliminarEstudiante(1L);
        verify(estudianteRepository, times(1)).deleteById(1L);
    }
}