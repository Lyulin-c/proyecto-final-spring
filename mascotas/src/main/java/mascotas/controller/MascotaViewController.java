package mascotas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import mascotas.entity.Mascota;
import mascotas.service.MascotaService;
import mascotas.service.PropietarioService;

@Controller
@RequestMapping("/mascotas")
@RequiredArgsConstructor
public class MascotaViewController {

	@Autowired
	MascotaService mascotaService;
	
	@Autowired
	PropietarioService propietarioService;
	
	@GetMapping
	public String listarMascotas(@RequestParam(defaultValue = "0") int page,
	                              @RequestParam(defaultValue = "5") int size,
	                              Model model) {
	    model.addAttribute("mascotas", mascotaService.findPaginated(PageRequest.of(page, size)));
	    model.addAttribute("currentPage", page);
	    return "mascotas";
	}

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("propietarios", propietarioService.findAll());
        return "subirMascotas";
    }

    @PostMapping
    public String guardarMascota(@ModelAttribute Mascota mascota) {
        mascotaService.save(mascota);
        return "redirect:/mascotas?page=0&size=5";
    }
	
}
