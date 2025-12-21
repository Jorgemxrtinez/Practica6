package P6_Cicatrack.P6.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import P6_Cicatrack.P6.model.Medicion;
import P6_Cicatrack.P6.repository.MedicionRepository;

@ExtendWith(MockitoExtension.class)
@DisplayName("Pruebas del Servicio Medicion (Mock)")
class MedicionServiceTest {

    @Mock
    private MedicionRepository repository; // Simulamos el Repo

    @InjectMocks
    private MedicionService service; // Inyectamos el Mock en el Servicio

    @Test
    @DisplayName("Guardar medición")
    void testGuardar() {
        // Arrange
        Medicion medicion = new Medicion(36.0, 7.0, 50.0);

        // Act
        service.guardar(medicion);

        // Assert
        verify(repository, times(1)).save(medicion);
    }

    @Test
    @DisplayName("Listar todas las mediciones")
    void testListarTodas() {
        // Arrange
        List<Medicion> datos = Arrays.asList(new Medicion(), new Medicion());
        when(repository.findAll()).thenReturn(datos);

        // Act
        List<Medicion> resultado = service.listarTodas();

        // Assert
        assertEquals(2, resultado.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    @DisplayName("Obtener por ID existente")
    void testObtenerPorId_Existe() {
        // Arrange
        Long id = 1L;
        Medicion medicion = new Medicion();
        when(repository.findById(id)).thenReturn(Optional.of(medicion));

        // Act
        Medicion resultado = service.obtenerPorId(id);

        // Assert
        assertNotNull(resultado);
        verify(repository, times(1)).findById(id);
    }

    @Test
    @DisplayName("Obtener por ID no existente (devuelve null)")
    void testObtenerPorId_NoExiste() {
        // Arrange
        Long id = 99L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        // Act
        Medicion resultado = service.obtenerPorId(id);

        // Assert
        assertNull(resultado);
    }

    @Test
    @DisplayName("Eliminar medición")
    void testEliminar() {
        // Arrange
        Long id = 1L;

        // Act
        service.eliminar(id);

        // Assert
        verify(repository, times(1)).deleteById(id);
    }
}
