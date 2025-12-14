package P6_Cicatrack.P6.service;

import P6_Cicatrack.P6.model.Medicion;
import P6_Cicatrack.P6.repository.MedicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicionService {

    @Autowired
    private MedicionRepository repository;

    // Guardar una nueva medición (simula que el vendaje envía datos)
    public void guardar(Medicion medicion) {
        repository.save(medicion);
    }

    // Consultar historial (RF14)
    public List<Medicion> listarTodas() {
        return repository.findAll();
    }

    // Obtener una específica para editar
    public Medicion obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Eliminar (por si hay error de lectura)
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
