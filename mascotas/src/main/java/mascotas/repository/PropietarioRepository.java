package mascotas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mascotas.entity.Propietario;

public interface PropietarioRepository extends JpaRepository<Propietario, Long> {
}
