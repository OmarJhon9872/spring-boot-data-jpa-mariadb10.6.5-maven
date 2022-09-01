package com.holamundothymeleaf.web;

import com.holamundothymeleaf.domain.Persona;
import com.holamundothymeleaf.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class HolaMundo {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model){

        var personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);

        log.info("Ejecutando el metodo inicio");
        return "index";
    }


    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona){
        personaService.guardarPersona(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model){
        persona = personaService.encontrarPersona(persona);

        model.addAttribute("persona", persona);
        return "modificar";
    }

    //@GetMapping("/eliminar/{id}")
    @GetMapping("/eliminar")
    public String eliminar(Persona persona, Model model){
        personaService.eliminarPersona(persona);
        return "redirect:/";
    }
}
