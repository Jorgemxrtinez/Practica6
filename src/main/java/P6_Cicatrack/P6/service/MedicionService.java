package P6_Cicatrack.P6.service;

import P6_Cicatrack.P6.model.Medicion;
import P6_Cicatrack.P6.repository.MedicionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicionService {

    @Autowired
    private MedicionRepository repository; // Inyectamos el repositorio que acabamos de crear

    // 1. Crear o Guardar
    public void guardar(Medicion medicion) {
        repository.save(medicion);
    }

    // 2. Leer todas
    public List<Medicion> listarTodas() {
        return repository.findAll();
    }

    // 3. Leer una por ID
    public Medicion obtenerPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    // 4. Eliminar
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
