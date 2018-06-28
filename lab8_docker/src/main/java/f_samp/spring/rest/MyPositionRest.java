package f_samp.spring.rest;


import f_samp.database.dao.PersonRepository;
import f_samp.database.dao.PositionRepository;
import f_samp.database.model.Persons;
import f_samp.database.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

/**
 * Created by Sonad on 19.09.17.
 */
@RestController
@RequestMapping("/rest/Position")

@ComponentScan(basePackages = "f_samp.database.dao")

public class MyPositionRest {

    @Autowired
    private PositionRepository myPositionList;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> loadPage( @AuthenticationPrincipal Principal principal) {
        List<Position> list = (List<Position>)myPositionList.findAll();

        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }


}
