package P6_Cicatrack.P6.model;


import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas de la Entidad Medicion")
class MedicionTest {

    @Test
    @DisplayName("Test Constructor Vacío y Setters")
    void testConstructorVacioYSetters() {
        // Arrange
        Medicion medicion = new Medicion();
        Long id = 1L;
        Double temp = 36.5;
        Double ph = 7.0;
        Double hum = 45.0;
        LocalDateTime fecha = LocalDateTime.now();

        // Act
        medicion.setId(id);
        medicion.setTemperatura(temp);
        medicion.setPh(ph);
        medicion.setHumedad(hum);
        medicion.setFechaRegistro(fecha);

        // Assert
        assertEquals(id, medicion.getId());
        assertEquals(temp, medicion.getTemperatura());
        assertEquals(ph, medicion.getPh());
        assertEquals(hum, medicion.getHumedad());
        assertEquals(fecha, medicion.getFechaRegistro());
    }

    @Test
    @DisplayName("Test Constructor con Parámetros")
    void testConstructorConParametros() {
        // Arrange
        Double temp = 38.0;
        Double ph = 6.5;
        Double hum = 50.0;

        // Act
        Medicion medicion = new Medicion(temp, ph, hum);

        // Assert
        assertEquals(temp, medicion.getTemperatura());
        assertEquals(ph, medicion.getPh());
        assertEquals(hum, medicion.getHumedad());
        // Verificamos que la fecha no sea nula (se asigna automáticamente)
        assertNotNull(medicion.getFechaRegistro());
    }
}