package mascotas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import mascotas.entity.Propietario;
import mascotas.repository.PropietarioRepository;

@Service
@RequiredArgsConstructor
public class PropietarioService {

	@Autowired
	PropietarioRepository propietarioRepository;
	
	public List<Propietario> findAll() {
        return propietarioRepository.findAll();
    }
	
	public Propietario getById(Long id) {
        return propietarioRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Propietario no encontrada"));
    }

    public Propietario save(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }
    
    public Page<Propietario> findPaginated(Pageable pageable) {
        return propietarioRepository.findAll(pageable);
    }

    public void delete(Long id) {
    	propietarioRepository.deleteById(id);
    }
	
}
