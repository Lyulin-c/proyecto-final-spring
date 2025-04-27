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
import mascotas.entity.Propietario;
import mascotas.service.PropietarioService;

@Controller
@RequestMapping("/propietarios")
@RequiredArgsConstructor
public class PropietarioViewController2 {
	
	@Autowired
	PropietarioService propietarioService;
	
	@GetMapping
	public String listarPropietarios(@RequestParam(defaultValue = "0") int page,
	                              @RequestParam(defaultValue = "5") int size,
	                              Model model) {
	    model.addAttribute("propietarios", propietarioService.findPaginated(PageRequest.of(page, size)));
	    model.addAttribute("currentPage", page);
	    return "propietarios";
	}

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("propietario", new Propietario());
        return "nuevoPropietario";
    }

    @PostMapping
    public String guardarMascota(@ModelAttribute Propietario propietario) {
    	propietarioService.save(propietario);
        return "redirect:/propietarios?page=0&size=5";
    }
	
}
