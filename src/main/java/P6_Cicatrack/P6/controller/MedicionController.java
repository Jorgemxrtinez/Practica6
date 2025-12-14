package P6_Cicatrack.P6.controller;

import P6_Cicatrack.P6.model.Medicion;
import P6_Cicatrack.P6.service.MedicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/mediciones")
public class MedicionController {

    @Autowired
    private MedicionService service;

    // Listar historial de Cica-Track
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("mediciones", service.listarTodas());
        return "lista_mediciones"; 
    }

    // Formulario para simular una nueva lectura del vendaje
    @GetMapping("/nueva")
    public String formulario(Model model) {
        model.addAttribute("medicion", new Medicion());
        return "formulario_medicion";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("medicion") Medicion medicion) {
        service.guardar(medicion);
        return "redirect:/mediciones";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("medicion", service.obtenerPorId(id));
        return "formulario_medicion";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return "redirect:/mediciones";
    }
}

