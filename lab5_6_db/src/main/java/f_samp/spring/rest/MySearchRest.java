package f_samp.spring.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import f_samp.database.dao.PersonRepository;
import f_samp.database.model.Persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import java.util.Collection;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Sonad on 19.09.17.
 */
@RestController
@RequestMapping("/rest/SearchPerson")

@ComponentScan(basePackages = "f_samp.database.dao")

public class MySearchRest {

    @Autowired
    private PersonRepository PersonList ;

    @RequestMapping(value = "/{Surname}", method = RequestMethod.POST)
    public ResponseEntity<Object> searchPerson(@PathVariable("Surname") String surname) {
        if (surname.equals("undefined"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\" : \"Invalid Surname\"}");
        Collection<Persons> searchResult = PersonList.findBySurname(surname);
        if (searchResult.isEmpty())
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\" : \"There is no one person.\"}");
        else return ResponseEntity.ok(searchResult);
    }



}
