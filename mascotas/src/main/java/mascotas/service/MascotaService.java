package mascotas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mascotas.entity.Mascota;
import mascotas.entity.Propietario;
import mascotas.repository.MascotaRepository;
import mascotas.repository.PropietarioRepository;

@Service
@RequiredArgsConstructor
public class MascotaService {

	@Autowired
	MascotaRepository mascotaRepository;
    
	@Autowired
	PropietarioRepository propietarioRepository;

    public List<Mascota> findAll() {
        return mascotaRepository.findAll();
    }
    
    public Mascota getById(Long id) {
        return mascotaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Mascota no encontrada"));
    }

    public Mascota save(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public List<Mascota> findByRaza(String raza) {
        return mascotaRepository.findByRaza(raza);
    }

    public List<Mascota> find20MasJovenes() {
        return mascotaRepository.findTop20ByOrderByFechaNacDesc();
    }

    public Page<Mascota> findPaginated(Pageable pageable) {
        return mascotaRepository.findAll(pageable);
    }

    public void delete(Long id) {
        mascotaRepository.deleteById(id);
    }

    public List<Mascota> findByPropietario(Long propietarioId) {
        return mascotaRepository.findByPropietarioId(propietarioId);
    }

    public Propietario getPropietarioDeMascota(Long mascotaId) {
        Mascota mascota = getById(mascotaId);
        return mascota.getPropietario();
    }
	
}
