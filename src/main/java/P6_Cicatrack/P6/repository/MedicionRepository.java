package P6_Cicatrack.P6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import P6_Cicatrack.P6.model.Medicion;

@Repository
public interface MedicionRepository extends JpaRepository<Medicion, Long> {
    
}
