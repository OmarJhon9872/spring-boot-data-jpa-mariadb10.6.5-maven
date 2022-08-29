package com.holamundothymeleaf.web;

import com.holamundothymeleaf.dao.IPersonaDao;
import com.holamundothymeleaf.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

@Controller
@Slf4j
public class HolaMundo {

    @Autowired
    private IPersonaDao personaDao;

    @GetMapping("/")
    public String inicio(Model model){

        var personas = personaDao.findAll();
        model.addAttribute("personas", personas);

        log.info("Ejecutando el metodo inicio");
        return "index";
    }
}
