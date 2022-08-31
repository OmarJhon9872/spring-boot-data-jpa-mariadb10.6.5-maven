package com.holamundothymeleaf.web;

import com.holamundothymeleaf.service.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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
}
