package com.holamundothymeleaf.dao;


import com.holamundothymeleaf.domain.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository<Persona, Long> {

}
