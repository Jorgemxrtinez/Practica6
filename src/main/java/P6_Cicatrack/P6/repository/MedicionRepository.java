package P6_Cicatrack.P6.repository;

import P6_Cicatrack.P6.model.Medicion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicionRepository extends JpaRepository<Medicion, Long> {
    
}
