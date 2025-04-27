package mascotas.apiController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import mascotas.entity.Mascota;
import mascotas.entity.Propietario;
import mascotas.service.MascotaService;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
public class MascotaController {

	@Autowired
	MascotaService mascotaService;

    @GetMapping("/{id}")
    public Mascota getMascota(@PathVariable Long id) {
        return mascotaService.getById(id);
    }

    @PostMapping
    public Mascota createMascota(@RequestBody Mascota mascota) {
        return mascotaService.save(mascota);
    }

    @GetMapping
    public List<Mascota> getAllMascotas() {
        return mascotaService.findAll();
    }

    @GetMapping("/raza/{raza}")
    public List<Mascota> getByRaza(@PathVariable String raza) {
        return mascotaService.findByRaza(raza);
    }

    @GetMapping("/jovenes")
    public List<Mascota> get20Jovenes() {
        return mascotaService.find20MasJovenes();
    }

    @GetMapping("/paginated")
    public Page<Mascota> getPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return mascotaService.findPaginated(PageRequest.of(page, size));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMascota(@PathVariable Long id) {
        mascotaService.delete(id);
    }

    @GetMapping("/propietario/{propietarioId}")
    public List<Mascota> getMascotasDePropietario(@PathVariable Long propietarioId) {
        return mascotaService.findByPropietario(propietarioId);
    }

    @GetMapping("/{id}/propietario")
    public Propietario getPropietarioDeMascota(@PathVariable Long id) {
        return mascotaService.getPropietarioDeMascota(id);
    }
	
}
