package P6_Cicatrack.P6.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mediciones")
public class Medicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double temperatura;
    private Double ph;       
    private Double humedad; 

    private LocalDateTime fechaRegistro;

    public Medicion() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public Medicion(Double temperatura, Double ph, Double humedad) {
        this.temperatura = temperatura;
        this.ph = ph;
        this.humedad = humedad;
        this.fechaRegistro = LocalDateTime.now();
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getTemperatura() { return temperatura; }
    public void setTemperatura(Double temperatura) { this.temperatura = temperatura; }

    public Double getPh() { return ph; }
    public void setPh(Double ph) { this.ph = ph; }

    public Double getHumedad() { return humedad; }
    public void setHumedad(Double humedad) { this.humedad = humedad; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}
