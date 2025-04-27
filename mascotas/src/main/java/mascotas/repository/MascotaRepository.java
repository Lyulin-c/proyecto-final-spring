package mascotas.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import mascotas.entity.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    List<Mascota> findByRaza(String raza);
    List<Mascota> findTop20ByOrderByFechaNacDesc();
    Page<Mascota> findAll(Pageable pageable);
    List<Mascota> findByPropietarioId(Long propietarioId);
}

