package com.holamundothymeleaf.web;

import com.holamundothymeleaf.domain.Persona;
import com.holamundothymeleaf.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
@Slf4j
public class ControladorPrincipal {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(@NotNull Model model, @AuthenticationPrincipal User user){

        var personas = personaService.listarPersonas();
        model.addAttribute("personas", personas);

        log.info("Ejecutando el metodo inicio");
        log.info("usuario que hizo login: "+user);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregar(Persona persona){
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
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
